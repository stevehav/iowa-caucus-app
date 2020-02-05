package com.facebook.react.views.picker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.google.common.primitives.Ints;
import java.util.List;

public class ReactPicker extends AppCompatSpinner {
    private final AdapterView.OnItemSelectedListener mItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (ReactPicker.this.mOnSelectListener != null) {
                ReactPicker.this.mOnSelectListener.onItemSelected(i);
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
            if (ReactPicker.this.mOnSelectListener != null) {
                ReactPicker.this.mOnSelectListener.onItemSelected(-1);
            }
        }
    };
    @Nullable
    private List<ReactPickerItem> mItems;
    private int mMode = 0;
    /* access modifiers changed from: private */
    @Nullable
    public OnSelectListener mOnSelectListener;
    @Nullable
    private List<ReactPickerItem> mStagedItems;
    @Nullable
    private Integer mStagedPrimaryTextColor;
    @Nullable
    private Integer mStagedSelection;
    private final Runnable measureAndLayout = new Runnable() {
        public void run() {
            ReactPicker reactPicker = ReactPicker.this;
            reactPicker.measure(View.MeasureSpec.makeMeasureSpec(reactPicker.getWidth(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(ReactPicker.this.getHeight(), Ints.MAX_POWER_OF_TWO));
            ReactPicker reactPicker2 = ReactPicker.this;
            reactPicker2.layout(reactPicker2.getLeft(), ReactPicker.this.getTop(), ReactPicker.this.getRight(), ReactPicker.this.getBottom());
        }
    };

    public interface OnSelectListener {
        void onItemSelected(int i);
    }

    public ReactPicker(Context context) {
        super(context);
    }

    public ReactPicker(Context context, int i) {
        super(context, i);
        this.mMode = i;
    }

    public ReactPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ReactPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ReactPicker(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mMode = i2;
    }

    public void requestLayout() {
        super.requestLayout();
        post(this.measureAndLayout);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getOnItemSelectedListener() == null) {
            setOnItemSelectedListener(this.mItemSelectedListener);
        }
    }

    public void setOnSelectListener(@Nullable OnSelectListener onSelectListener) {
        this.mOnSelectListener = onSelectListener;
    }

    @Nullable
    public OnSelectListener getOnSelectListener() {
        return this.mOnSelectListener;
    }

    /* access modifiers changed from: package-private */
    public void setStagedItems(@Nullable List<ReactPickerItem> list) {
        this.mStagedItems = list;
    }

    /* access modifiers changed from: package-private */
    public void setStagedSelection(int i) {
        this.mStagedSelection = Integer.valueOf(i);
    }

    /* access modifiers changed from: package-private */
    public void setStagedPrimaryTextColor(@Nullable Integer num) {
        this.mStagedPrimaryTextColor = num;
    }

    /* access modifiers changed from: package-private */
    public void commitStagedData() {
        setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        ReactPickerAdapter reactPickerAdapter = (ReactPickerAdapter) getAdapter();
        int selectedItemPosition = getSelectedItemPosition();
        List<ReactPickerItem> list = this.mStagedItems;
        if (!(list == null || list == this.mItems)) {
            this.mItems = list;
            this.mStagedItems = null;
            if (reactPickerAdapter == null) {
                reactPickerAdapter = new ReactPickerAdapter(getContext(), this.mItems);
                setAdapter((SpinnerAdapter) reactPickerAdapter);
            } else {
                reactPickerAdapter.clear();
                reactPickerAdapter.addAll(this.mItems);
                reactPickerAdapter.notifyDataSetChanged();
            }
        }
        Integer num = this.mStagedSelection;
        if (!(num == null || num.intValue() == selectedItemPosition)) {
            setSelection(this.mStagedSelection.intValue(), false);
            this.mStagedSelection = null;
        }
        Integer num2 = this.mStagedPrimaryTextColor;
        if (!(num2 == null || reactPickerAdapter == null || num2 == reactPickerAdapter.getPrimaryTextColor())) {
            reactPickerAdapter.setPrimaryTextColor(this.mStagedPrimaryTextColor);
            this.mStagedPrimaryTextColor = null;
        }
        setOnItemSelectedListener(this.mItemSelectedListener);
    }

    @VisibleForTesting
    public int getMode() {
        return this.mMode;
    }
}
