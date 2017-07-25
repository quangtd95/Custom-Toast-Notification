package com.quangtd95.customtoastnotification;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.quangtd95.customtoastnotification.databinding.CustomToastNotificationBinding;

/**
 * Quang_TD on 7/25/2017.
 */

public class CustomToastNotification extends LinearLayout {
    private Context mContext;
    private String message;
    private String title;
    private CustomToastNotificationBinding mBinding;

    public CustomToastNotification(Context context) {
        super(context);
        init(context);
    }

    public CustomToastNotification(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomToastNotification(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP) public CustomToastNotification(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.custom_toast_notification, this, true);
        mBinding.setViewModel(this);
    }

    public CustomToastNotification setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomToastNotification setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomToastNotification setBackground(int id) {
        mBinding.notificationBackground.setBackgroundResource(id);
        return this;
    }

    public CustomToastNotification setIcon(int resId) {
        mBinding.iconToast.setImageResource(resId);
        return this;
    }

    public String getTitle() {
        if (TextUtils.isEmpty(title)) {
            return getResources().getString(R.string.app_name);
        }
        return title;
    }
    public String getMessage() {
        return message;
    }




}
