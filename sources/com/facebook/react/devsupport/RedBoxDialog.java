package com.facebook.react.devsupport;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.SpannedString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.common.util.UriUtil;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.devsupport.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.StackFrame;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

class RedBoxDialog extends Dialog implements AdapterView.OnItemClickListener {
    /* access modifiers changed from: private */
    public boolean isReporting = false;
    /* access modifiers changed from: private */
    public final DevSupportManager mDevSupportManager;
    private Button mDismissButton;
    private final DoubleTapReloadRecognizer mDoubleTapReloadRecognizer;
    /* access modifiers changed from: private */
    @Nullable
    public View mLineSeparator;
    /* access modifiers changed from: private */
    @Nullable
    public ProgressBar mLoadingIndicator;
    /* access modifiers changed from: private */
    @Nullable
    public final RedBoxHandler mRedBoxHandler;
    private Button mReloadJsButton;
    /* access modifiers changed from: private */
    @Nullable
    public Button mReportButton;
    private View.OnClickListener mReportButtonOnClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            if (RedBoxDialog.this.mRedBoxHandler != null && RedBoxDialog.this.mRedBoxHandler.isReportEnabled() && !RedBoxDialog.this.isReporting) {
                boolean unused = RedBoxDialog.this.isReporting = true;
                ((TextView) Assertions.assertNotNull(RedBoxDialog.this.mReportTextView)).setText("Reporting...");
                ((TextView) Assertions.assertNotNull(RedBoxDialog.this.mReportTextView)).setVisibility(0);
                ((ProgressBar) Assertions.assertNotNull(RedBoxDialog.this.mLoadingIndicator)).setVisibility(0);
                ((View) Assertions.assertNotNull(RedBoxDialog.this.mLineSeparator)).setVisibility(0);
                ((Button) Assertions.assertNotNull(RedBoxDialog.this.mReportButton)).setEnabled(false);
                String sourceUrl = RedBoxDialog.this.mDevSupportManager.getSourceUrl();
                RedBoxDialog.this.mRedBoxHandler.reportRedbox(view.getContext(), (String) Assertions.assertNotNull(RedBoxDialog.this.mDevSupportManager.getLastErrorTitle()), (StackFrame[]) Assertions.assertNotNull(RedBoxDialog.this.mDevSupportManager.getLastErrorStack()), sourceUrl, (RedBoxHandler.ReportCompletedListener) Assertions.assertNotNull(RedBoxDialog.this.mReportCompletedListener));
            }
        }
    };
    /* access modifiers changed from: private */
    public RedBoxHandler.ReportCompletedListener mReportCompletedListener = new RedBoxHandler.ReportCompletedListener() {
        public void onReportSuccess(SpannedString spannedString) {
            boolean unused = RedBoxDialog.this.isReporting = false;
            ((Button) Assertions.assertNotNull(RedBoxDialog.this.mReportButton)).setEnabled(true);
            ((ProgressBar) Assertions.assertNotNull(RedBoxDialog.this.mLoadingIndicator)).setVisibility(8);
            ((TextView) Assertions.assertNotNull(RedBoxDialog.this.mReportTextView)).setText(spannedString);
        }

        public void onReportError(SpannedString spannedString) {
            boolean unused = RedBoxDialog.this.isReporting = false;
            ((Button) Assertions.assertNotNull(RedBoxDialog.this.mReportButton)).setEnabled(true);
            ((ProgressBar) Assertions.assertNotNull(RedBoxDialog.this.mLoadingIndicator)).setVisibility(8);
            ((TextView) Assertions.assertNotNull(RedBoxDialog.this.mReportTextView)).setText(spannedString);
        }
    };
    /* access modifiers changed from: private */
    @Nullable
    public TextView mReportTextView;
    private ListView mStackView;

    private static class StackAdapter extends BaseAdapter {
        private static final int VIEW_TYPE_COUNT = 2;
        private static final int VIEW_TYPE_STACKFRAME = 1;
        private static final int VIEW_TYPE_TITLE = 0;
        private final StackFrame[] mStack;
        private final String mTitle;

        public boolean areAllItemsEnabled() {
            return false;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            return i == 0 ? 0 : 1;
        }

        public int getViewTypeCount() {
            return 2;
        }

        public boolean isEnabled(int i) {
            return i > 0;
        }

        private static class FrameViewHolder {
            /* access modifiers changed from: private */
            public final TextView mFileView;
            /* access modifiers changed from: private */
            public final TextView mMethodView;

            private FrameViewHolder(View view) {
                this.mMethodView = (TextView) view.findViewById(R.id.rn_frame_method);
                this.mFileView = (TextView) view.findViewById(R.id.rn_frame_file);
            }
        }

        public StackAdapter(String str, StackFrame[] stackFrameArr) {
            this.mTitle = str;
            this.mStack = stackFrameArr;
        }

        public int getCount() {
            return this.mStack.length + 1;
        }

        public Object getItem(int i) {
            return i == 0 ? this.mTitle : this.mStack[i - 1];
        }

        /* JADX WARNING: type inference failed for: r3v8, types: [android.view.View] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.view.View getView(int r3, android.view.View r4, android.view.ViewGroup r5) {
            /*
                r2 = this;
                r0 = 0
                if (r3 != 0) goto L_0x0027
                if (r4 == 0) goto L_0x0008
                android.widget.TextView r4 = (android.widget.TextView) r4
                goto L_0x0019
            L_0x0008:
                android.content.Context r3 = r5.getContext()
                android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
                int r4 = com.facebook.react.R.layout.redbox_item_title
                android.view.View r3 = r3.inflate(r4, r5, r0)
                r4 = r3
                android.widget.TextView r4 = (android.widget.TextView) r4
            L_0x0019:
                java.lang.String r3 = r2.mTitle
                java.lang.String r5 = "\\x1b\\[[0-9;]*m"
                java.lang.String r0 = ""
                java.lang.String r3 = r3.replaceAll(r5, r0)
                r4.setText(r3)
                return r4
            L_0x0027:
                if (r4 != 0) goto L_0x0040
                android.content.Context r4 = r5.getContext()
                android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
                int r1 = com.facebook.react.R.layout.redbox_item_frame
                android.view.View r4 = r4.inflate(r1, r5, r0)
                com.facebook.react.devsupport.RedBoxDialog$StackAdapter$FrameViewHolder r5 = new com.facebook.react.devsupport.RedBoxDialog$StackAdapter$FrameViewHolder
                r0 = 0
                r5.<init>(r4)
                r4.setTag(r5)
            L_0x0040:
                com.facebook.react.devsupport.interfaces.StackFrame[] r5 = r2.mStack
                int r3 = r3 + -1
                r3 = r5[r3]
                java.lang.Object r5 = r4.getTag()
                com.facebook.react.devsupport.RedBoxDialog$StackAdapter$FrameViewHolder r5 = (com.facebook.react.devsupport.RedBoxDialog.StackAdapter.FrameViewHolder) r5
                android.widget.TextView r0 = r5.mMethodView
                java.lang.String r1 = r3.getMethod()
                r0.setText(r1)
                android.widget.TextView r5 = r5.mFileView
                java.lang.String r3 = com.facebook.react.devsupport.StackTraceHelper.formatFrameSource(r3)
                r5.setText(r3)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.RedBoxDialog.StackAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }
    }

    private static class OpenStackFrameTask extends AsyncTask<StackFrame, Void, Void> {
        private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        private final DevSupportManager mDevSupportManager;

        private OpenStackFrameTask(DevSupportManager devSupportManager) {
            this.mDevSupportManager = devSupportManager;
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(StackFrame... stackFrameArr) {
            try {
                String uri = Uri.parse(this.mDevSupportManager.getSourceUrl()).buildUpon().path("/open-stack-frame").query((String) null).build().toString();
                OkHttpClient okHttpClient = new OkHttpClient();
                for (StackFrame stackFrameToJson : stackFrameArr) {
                    okHttpClient.newCall(new Request.Builder().url(uri).post(RequestBody.create(JSON, stackFrameToJson(stackFrameToJson).toString())).build()).execute();
                }
            } catch (Exception e) {
                FLog.e(ReactConstants.TAG, "Could not open stack frame", (Throwable) e);
            }
            return null;
        }

        private static JSONObject stackFrameToJson(StackFrame stackFrame) {
            return new JSONObject(MapBuilder.of(UriUtil.LOCAL_FILE_SCHEME, stackFrame.getFile(), "methodName", stackFrame.getMethod(), StackTraceHelper.LINE_NUMBER_KEY, Integer.valueOf(stackFrame.getLine()), StackTraceHelper.COLUMN_KEY, Integer.valueOf(stackFrame.getColumn())));
        }
    }

    protected RedBoxDialog(Context context, DevSupportManager devSupportManager, @Nullable RedBoxHandler redBoxHandler) {
        super(context, R.style.Theme_Catalyst_RedBox);
        requestWindowFeature(1);
        setContentView(R.layout.redbox_view);
        this.mDevSupportManager = devSupportManager;
        this.mDoubleTapReloadRecognizer = new DoubleTapReloadRecognizer();
        this.mRedBoxHandler = redBoxHandler;
        this.mStackView = (ListView) findViewById(R.id.rn_redbox_stack);
        this.mStackView.setOnItemClickListener(this);
        this.mReloadJsButton = (Button) findViewById(R.id.rn_redbox_reload_button);
        this.mReloadJsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RedBoxDialog.this.mDevSupportManager.handleReloadJS();
            }
        });
        this.mDismissButton = (Button) findViewById(R.id.rn_redbox_dismiss_button);
        this.mDismissButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RedBoxDialog.this.dismiss();
            }
        });
        RedBoxHandler redBoxHandler2 = this.mRedBoxHandler;
        if (redBoxHandler2 != null && redBoxHandler2.isReportEnabled()) {
            this.mLoadingIndicator = (ProgressBar) findViewById(R.id.rn_redbox_loading_indicator);
            this.mLineSeparator = findViewById(R.id.rn_redbox_line_separator);
            this.mReportTextView = (TextView) findViewById(R.id.rn_redbox_report_label);
            this.mReportTextView.setMovementMethod(LinkMovementMethod.getInstance());
            this.mReportTextView.setHighlightColor(0);
            this.mReportButton = (Button) findViewById(R.id.rn_redbox_report_button);
            this.mReportButton.setOnClickListener(this.mReportButtonOnClickListener);
        }
    }

    public void setExceptionDetails(String str, StackFrame[] stackFrameArr) {
        this.mStackView.setAdapter(new StackAdapter(str, stackFrameArr));
    }

    public void resetReporting() {
        RedBoxHandler redBoxHandler = this.mRedBoxHandler;
        if (redBoxHandler != null && redBoxHandler.isReportEnabled()) {
            this.isReporting = false;
            ((TextView) Assertions.assertNotNull(this.mReportTextView)).setVisibility(8);
            ((ProgressBar) Assertions.assertNotNull(this.mLoadingIndicator)).setVisibility(8);
            ((View) Assertions.assertNotNull(this.mLineSeparator)).setVisibility(8);
            ((Button) Assertions.assertNotNull(this.mReportButton)).setVisibility(0);
            ((Button) Assertions.assertNotNull(this.mReportButton)).setEnabled(true);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        new OpenStackFrameTask(this.mDevSupportManager).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new StackFrame[]{(StackFrame) this.mStackView.getAdapter().getItem(i)});
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 82) {
            this.mDevSupportManager.showDevOptionsDialog();
            return true;
        }
        if (this.mDoubleTapReloadRecognizer.didDoubleTapR(i, getCurrentFocus())) {
            this.mDevSupportManager.handleReloadJS();
        }
        return super.onKeyUp(i, keyEvent);
    }
}
