package com.cxsz.mealbuy.model.modelImpl;

import android.content.Context;

import com.cxsz.mealbuy.model.callback.CallBack;
import com.cxsz.mealbuy.model.modelInterface.IntelligentDiagnosisModel;
import com.cxsz.mealbuy.model.net.MealCodeData;
import com.cxsz.mealbuy.model.net.MealNetRequestModelImpl;
import com.cxsz.mealbuy.model.net.MealProgressSubscriber;
import com.cxsz.mealbuy.model.net.MealSubscriberOnNextListener;

public class IntelligentDiagnosisModelImpl  implements IntelligentDiagnosisModel {

    @Override
    public void RequestRealNameDiagnosis(Context context, String number, CallBack callBack) {
        MealSubscriberOnNextListener<MealCodeData> bindSubscriberOnNextListener = new MealSubscriberOnNextListener<MealCodeData>() {
            @Override
            public void onNext(final MealCodeData codeData) {
                if (codeData.getCode() == 1) {

                }
                callBack.onSuccess(codeData);
            }

            @Override
            public void onError(Throwable e) {
                callBack.equals(e.getMessage());
            }
        };
        MealNetRequestModelImpl.getInstance().realNameDiagnosis(new MealProgressSubscriber<MealCodeData>(bindSubscriberOnNextListener, context, true),
               number);
    }

    @Override
    public void RequestCardPackageDiagnosis(Context context, String number, CallBack callBack) {
        MealSubscriberOnNextListener<MealCodeData> bindSubscriberOnNextListener = new MealSubscriberOnNextListener<MealCodeData>() {
            @Override
            public void onNext(final MealCodeData codeData) {
                if (codeData.getCode() == 1) {

                }
                callBack.onSuccess(codeData);
            }

            @Override
            public void onError(Throwable e) {
                callBack.equals(e.getMessage());
            }
        };
        MealNetRequestModelImpl.getInstance().cardPackageDiagnosis(new MealProgressSubscriber<MealCodeData>(bindSubscriberOnNextListener, context, true),
                number);
    }

    @Override
    public void RequestSynchronizationCardStatus(Context context, String number, CallBack callBack) {
        MealSubscriberOnNextListener<MealCodeData> bindSubscriberOnNextListener = new MealSubscriberOnNextListener<MealCodeData>() {
            @Override
            public void onNext(final MealCodeData codeData) {
                if (codeData.getCode() == 1) {

                }
                callBack.onSuccess(codeData);
            }

            @Override
            public void onError(Throwable e) {
                callBack.equals(e.getMessage());
            }
        };
        MealNetRequestModelImpl.getInstance().synchronizationCardStatus(new MealProgressSubscriber<MealCodeData>(bindSubscriberOnNextListener, context, true),
                number);
    }

    @Override
    public void RequestUpdateVoiceData(Context context, String number, CallBack callBack) {
        MealSubscriberOnNextListener<MealCodeData> bindSubscriberOnNextListener = new MealSubscriberOnNextListener<MealCodeData>() {
            @Override
            public void onNext(final MealCodeData codeData) {
                if (codeData.getCode() == 1) {

                }
                callBack.onSuccess(codeData);
            }

            @Override
            public void onError(Throwable e) {
                callBack.equals(e.getMessage());
            }
        };
        MealNetRequestModelImpl.getInstance().updateVoiceData(new MealProgressSubscriber<MealCodeData>(bindSubscriberOnNextListener, context, true),
                number);
    }

    @Override
    public void RequestUpdateTrafficData(Context context, String number, CallBack callBack) {
        MealSubscriberOnNextListener<MealCodeData> bindSubscriberOnNextListener = new MealSubscriberOnNextListener<MealCodeData>() {
            @Override
            public void onNext(final MealCodeData codeData) {
                if (codeData.getCode() == 1) {

                }
                callBack.onSuccess(codeData);
            }

            @Override
            public void onError(Throwable e) {
                callBack.equals(e.getMessage());
            }
        };
        MealNetRequestModelImpl.getInstance().updateTrafficData(new MealProgressSubscriber<MealCodeData>(bindSubscriberOnNextListener, context, true),
                number);
    }

    @Override
    public void RequestFlowDetection(Context context, String number, CallBack callBack) {
        MealSubscriberOnNextListener<MealCodeData> bindSubscriberOnNextListener = new MealSubscriberOnNextListener<MealCodeData>() {
            @Override
            public void onNext(final MealCodeData codeData) {
                if (codeData.getCode() == 1) {

                }
                callBack.onSuccess(codeData);
            }

            @Override
            public void onError(Throwable e) {
                callBack.equals(e.getMessage());
            }
        };
        MealNetRequestModelImpl.getInstance().flowDetection(new MealProgressSubscriber<MealCodeData>(bindSubscriberOnNextListener, context, true),
                number);
    }

    @Override
    public void RequestSpeechDetection(Context context, String number, CallBack callBack) {
        MealSubscriberOnNextListener<MealCodeData> bindSubscriberOnNextListener = new MealSubscriberOnNextListener<MealCodeData>() {
            @Override
            public void onNext(final MealCodeData codeData) {
                if (codeData.getCode() == 1) {

                }
                callBack.onSuccess(codeData);
            }

            @Override
            public void onError(Throwable e) {
                callBack.equals(e.getMessage());
            }
        };
        MealNetRequestModelImpl.getInstance().speechDetection(new MealProgressSubscriber<MealCodeData>(bindSubscriberOnNextListener, context, true),
                number);
    }

    @Override
    public void RequestWhiteListDiagnosis(Context context, String number, CallBack callBack) {
        MealSubscriberOnNextListener<MealCodeData> bindSubscriberOnNextListener = new MealSubscriberOnNextListener<MealCodeData>() {
            @Override
            public void onNext(final MealCodeData codeData) {
                if (codeData.getCode() == 1) {

                }
                callBack.onSuccess(codeData);
            }

            @Override
            public void onError(Throwable e) {
                callBack.equals(e.getMessage());
            }
        };
        MealNetRequestModelImpl.getInstance().whiteListDiagnosis(new MealProgressSubscriber<MealCodeData>(bindSubscriberOnNextListener, context, true),
                number);
    }

    @Override
    public void RequestReadCardStatus(Context context, String number, CallBack callBack) {
        MealSubscriberOnNextListener<MealCodeData> bindSubscriberOnNextListener = new MealSubscriberOnNextListener<MealCodeData>() {
            @Override
            public void onNext(final MealCodeData codeData) {
                if (codeData.getCode() == 1) {

                }
                callBack.onSuccess(codeData);
            }

            @Override
            public void onError(Throwable e) {
                callBack.equals(e.getMessage());
            }
        };
        MealNetRequestModelImpl.getInstance().readCardStatus(new MealProgressSubscriber<MealCodeData>(bindSubscriberOnNextListener, context, true),
                number);
    }
}
