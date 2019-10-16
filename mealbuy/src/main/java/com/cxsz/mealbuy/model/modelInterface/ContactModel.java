package com.cxsz.mealbuy.model.modelInterface;

import android.content.Context;

import com.cxsz.mealbuy.model.callback.CallBack;

public interface ContactModel {

    void RequestAddOrDelVoiceWhiteManager(Context context, String type, String msisdn, String operType, String phone, CallBack callBack);

    void RequestQueryVoiceWhiteList(Context context, String type, String msisdn, CallBack callBack);

    void RequestQueryAddWhiteCount(Context context, String type, String msisdn, CallBack callBack);

}
