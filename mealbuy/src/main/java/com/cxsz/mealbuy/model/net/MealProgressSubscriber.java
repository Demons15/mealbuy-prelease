package com.cxsz.mealbuy.model.net;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.cxsz.mealbuy.component.LogUtil;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import rx.Subscriber;

/**
 * 调用者自己对请求数据进行处理
 * Created by yangqian on 2017/2/26.
 */

public class MealProgressSubscriber<T> extends Subscriber<T> implements MealProgressCancelListener {

    private MealSubscriberOnNextListener mSubscriberOnNextListener;
    private Context context;
    private boolean isNeedProgressDialog;

    //private ProgressDialogHandler mProgressDialogHandler;
    public MealProgressSubscriber(MealSubscriberOnNextListener mSubscriberOnNextListener, Context context) {
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
        this.context = context;
    }

    public MealProgressSubscriber(MealSubscriberOnNextListener mSubscriberOnNextListener, Context context, boolean isNeedProgressDialog) {
        this.isNeedProgressDialog = isNeedProgressDialog;
        this.context = context;
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
    }

    /**
     * 订阅开始时调用
     * 显示ProgressDialog
     */
    @Override
    public void onStart() {
        if (false == isNeedProgressDialog) {
            showProgressDialog();
        }
    }

    /**
     * 完成，隐藏ProgressDialog
     */
    @Override
    public void onCompleted() {
        if (false == isNeedProgressDialog) {
            dismissProgressDialog();
        }
    }

    /**
     * 对错误进行统一处理
     * 隐藏ProgressDialog
     *
     * @param e
     */
    @Override
    public void onError(Throwable e) {
        String errorInfo = "";
        if (e instanceof SocketTimeoutException) {
            errorInfo = "网络连接超时!";
            LogUtil.setTagE("NetError:", errorInfo);
            Toast.makeText(context, errorInfo, Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
            errorInfo = "网络连接异常!";
            LogUtil.setTagE("NetError:", errorInfo);
            Toast.makeText(context, errorInfo, Toast.LENGTH_SHORT).show();
        } else if (e instanceof UnknownHostException) {
            errorInfo = "网络连接异常!";
            LogUtil.setTagE("NetError:", errorInfo);
            Toast.makeText(context, errorInfo, Toast.LENGTH_SHORT).show();
        }  else if (e instanceof NoNetWorkException) {
            errorInfo = "网络不可用!";
            LogUtil.setTagE("NetError:", errorInfo);
            Toast.makeText(context, errorInfo, Toast.LENGTH_SHORT).show();
        }else {
            errorInfo = e.getMessage();
            LogUtil.setTagE("NetError:", errorInfo);
            Toast.makeText(context, errorInfo, Toast.LENGTH_SHORT).show();
        }
        mSubscriberOnNextListener.onError(new Exception(errorInfo));
    }

    /**
     * 将onNext方法中的返回结果交给Activity或Fragment自己处理
     *
     * @param t 创建Subscriber时的泛型类型
     */
    @Override
    public void onNext(T t) {
        if (mSubscriberOnNextListener != null) {
            mSubscriberOnNextListener.onNext(t);
        }
    }

    /**
     * ，取消对observable的订阅，同时也取消了http请求
     */
    @Override
    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }

    private void showProgressDialog() {
/*        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }*/
    }

    private void dismissProgressDialog() {
/*        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mProgressDialogHandler = null;
        }*/
    }
}