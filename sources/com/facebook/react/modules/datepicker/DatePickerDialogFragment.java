package com.facebook.react.modules.datepicker;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;
import java.util.Locale;

@SuppressLint({"ValidFragment"})
public class DatePickerDialogFragment extends DialogFragment {
    private static final long DEFAULT_MIN_DATE = -2208988800001L;
    @Nullable
    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    @Nullable
    private DialogInterface.OnDismissListener mOnDismissListener;

    public Dialog onCreateDialog(Bundle bundle) {
        return createDialog(getArguments(), getActivity(), this.mOnDateSetListener);
    }

    static Dialog createDialog(Bundle bundle, Context context, @Nullable DatePickerDialog.OnDateSetListener onDateSetListener) {
        DismissableDatePickerDialog dismissableDatePickerDialog;
        Calendar instance = Calendar.getInstance();
        if (bundle != null && bundle.containsKey("date")) {
            instance.setTimeInMillis(bundle.getLong("date"));
        }
        int i = instance.get(1);
        int i2 = instance.get(2);
        int i3 = instance.get(5);
        DatePickerMode datePickerMode = DatePickerMode.DEFAULT;
        if (!(bundle == null || bundle.getString("mode", (String) null) == null)) {
            datePickerMode = DatePickerMode.valueOf(bundle.getString("mode").toUpperCase(Locale.US));
        }
        DatePickerMode datePickerMode2 = datePickerMode;
        if (Build.VERSION.SDK_INT >= 21) {
            int i4 = AnonymousClass1.$SwitchMap$com$facebook$react$modules$datepicker$DatePickerMode[datePickerMode2.ordinal()];
            if (i4 == 1) {
                dismissableDatePickerDialog = new DismissableDatePickerDialog(context, context.getResources().getIdentifier("CalendarDatePickerDialog", "style", context.getPackageName()), onDateSetListener, i, i2, i3);
            } else if (i4 != 2) {
                dismissableDatePickerDialog = i4 != 3 ? null : new DismissableDatePickerDialog(context, onDateSetListener, i, i2, i3);
            } else {
                dismissableDatePickerDialog = new DismissableDatePickerDialog(context, 16973939, onDateSetListener, i, i2, i3);
                dismissableDatePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            }
        } else {
            DismissableDatePickerDialog dismissableDatePickerDialog2 = new DismissableDatePickerDialog(context, onDateSetListener, i, i2, i3);
            int i5 = AnonymousClass1.$SwitchMap$com$facebook$react$modules$datepicker$DatePickerMode[datePickerMode2.ordinal()];
            if (i5 == 1) {
                dismissableDatePickerDialog2.getDatePicker().setCalendarViewShown(true);
                dismissableDatePickerDialog2.getDatePicker().setSpinnersShown(false);
            } else if (i5 == 2) {
                dismissableDatePickerDialog2.getDatePicker().setCalendarViewShown(false);
            }
            dismissableDatePickerDialog = dismissableDatePickerDialog2;
        }
        DatePicker datePicker = dismissableDatePickerDialog.getDatePicker();
        if (bundle == null || !bundle.containsKey("minDate")) {
            datePicker.setMinDate(DEFAULT_MIN_DATE);
        } else {
            instance.setTimeInMillis(bundle.getLong("minDate"));
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            datePicker.setMinDate(instance.getTimeInMillis());
        }
        if (bundle != null && bundle.containsKey("maxDate")) {
            instance.setTimeInMillis(bundle.getLong("maxDate"));
            instance.set(11, 23);
            instance.set(12, 59);
            instance.set(13, 59);
            instance.set(14, 999);
            datePicker.setMaxDate(instance.getTimeInMillis());
        }
        return dismissableDatePickerDialog;
    }

    /* renamed from: com.facebook.react.modules.datepicker.DatePickerDialogFragment$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$modules$datepicker$DatePickerMode = new int[DatePickerMode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.facebook.react.modules.datepicker.DatePickerMode[] r0 = com.facebook.react.modules.datepicker.DatePickerMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$modules$datepicker$DatePickerMode = r0
                int[] r0 = $SwitchMap$com$facebook$react$modules$datepicker$DatePickerMode     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.facebook.react.modules.datepicker.DatePickerMode r1 = com.facebook.react.modules.datepicker.DatePickerMode.CALENDAR     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$facebook$react$modules$datepicker$DatePickerMode     // Catch:{ NoSuchFieldError -> 0x001f }
                com.facebook.react.modules.datepicker.DatePickerMode r1 = com.facebook.react.modules.datepicker.DatePickerMode.SPINNER     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$facebook$react$modules$datepicker$DatePickerMode     // Catch:{ NoSuchFieldError -> 0x002a }
                com.facebook.react.modules.datepicker.DatePickerMode r1 = com.facebook.react.modules.datepicker.DatePickerMode.DEFAULT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.datepicker.DatePickerDialogFragment.AnonymousClass1.<clinit>():void");
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnDateSetListener(@Nullable DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.mOnDateSetListener = onDateSetListener;
    }

    /* access modifiers changed from: package-private */
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }
}
