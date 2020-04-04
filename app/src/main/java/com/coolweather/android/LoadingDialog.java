package com.coolweather.android;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LoadingDialog extends Dialog {

    public LoadingDialog(@NonNull Context context) {
        super(context);
    }

    public LoadingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public LoadingDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static class Builder{
        private Context context;
        private String message;
        private boolean isShowMsg = true;
        private boolean isCancelable = true;
        private boolean isCancelOutside = true;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setShowMsg(boolean showMsg) {
            isShowMsg = showMsg;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            isCancelable = cancelable;
            return this;
        }

        public Builder setCancelOutside(boolean cancelOutside) {
            isCancelOutside = cancelOutside;
            return this;
        }

        public LoadingDialog create(){
            View view = LayoutInflater.from(context).inflate(R.layout.dialog_loading,null);
            LoadingDialog loadingDialog = new LoadingDialog(context,R.style.MyDialogStyle);
            TextView tipText = view.findViewById(R.id.tipText);
            if(isShowMsg){
                tipText.setText(message);
            }else{
                tipText.setVisibility(View.GONE);
            }
            loadingDialog.setContentView(view);
            loadingDialog.setCancelable(isCancelable);
            loadingDialog.setCanceledOnTouchOutside(isCancelOutside);
            return loadingDialog;
        }
    }
}
