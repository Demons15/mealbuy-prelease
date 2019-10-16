package com.cxsz.mealbuy.model.modelImpl;

import android.content.Context;

import com.cxsz.mealbuy.model.callback.CallBack;
import com.cxsz.mealbuy.model.modelInterface.ContactModel;
import com.cxsz.mealbuy.model.net.MealCodeData;
import com.cxsz.mealbuy.model.net.MealNetRequestModelImpl;
import com.cxsz.mealbuy.model.net.MealProgressSubscriber;
import com.cxsz.mealbuy.model.net.MealSubscriberOnNextListener;

public class ContactModelImpl  implements ContactModel {

    @Override
    public void RequestAddOrDelVoiceWhiteManager(Context context, String type, String msisdn, String operType, String phone, CallBack callBack) {
        MealSubscriberOnNextListener<MealCodeData> bindSubscriberOnNextListener = new MealSubscriberOnNextListener<MealCodeData>() {
            @Override
            public void onNext(final MealCodeData codeData) {
                if (codeData.getCode() == 1) {
                    callBack.onSuccess(codeData);
                } else {
                    callBack.onError(codeData.getMessage());
                }
            }

            @Override
            public void onError(Throwable e) {
                callBack.equals(e.getMessage());
            }
        };
        MealNetRequestModelImpl.getInstance().addOrDelVoiceWhiteManager(new MealProgressSubscriber<MealCodeData>(bindSubscriberOnNextListener, context, true),
                type, msisdn, operType, phone);
    }

    @Override
    public void RequestQueryVoiceWhiteList(Context context, String type, String msisdn, CallBack callBack) {
        MealSubscriberOnNextListener<MealCodeData> bindSubscriberOnNextListener = new MealSubscriberOnNextListener<MealCodeData>() {
            @Override
            public void onNext(final MealCodeData codeData) {
                if (codeData.getCode() == 1) {
                    callBack.onSuccess(codeData);
                } else {
                    callBack.onError(codeData.getMessage());
                }
            }

            @Override
            public void onError(Throwable e) {
                callBack.equals(e.getMessage());
            }
        };
        MealNetRequestModelImpl.getInstance().queryVoiceWhiteList(new MealProgressSubscriber<MealCodeData>(bindSubscriberOnNextListener, context, true),
                type, msisdn);
    }

    @Override
    public void RequestQueryAddWhiteCount(Context context, String type, String msisdn, CallBack callBack) {
        MealSubscriberOnNextListener<MealCodeData> bindSubscriberOnNextListener = new MealSubscriberOnNextListener<MealCodeData>() {
            @Override
            public void onNext(final MealCodeData codeData) {
                if (codeData.getCode() == 1) {
                    callBack.onSuccess(codeData);
                } else {
                    callBack.onError(codeData.getMessage());
                }
            }

            @Override
            public void onError(Throwable e) {
                callBack.equals(e.getMessage());
            }
        };
        MealNetRequestModelImpl.getInstance().queryAddWhiteCount(new MealProgressSubscriber<MealCodeData>(bindSubscriberOnNextListener, context, true),
                type, msisdn);
    }
}
