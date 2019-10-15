package com.cxsz.mealbuy.model.modelInterface;

import android.content.Context;
import com.cxsz.mealbuy.model.callback.CallBack;

public interface IntelligentDiagnosisModel {

    void RequestRealNameDiagnosis(Context context, String number, CallBack callBack);

    void RequestCardPackageDiagnosis(Context context, String number, CallBack callBack);

    void RequestSynchronizationCardStatus(Context context, String number, CallBack callBack);

    void RequestUpdateVoiceData(Context context, String number, CallBack callBack);

    void RequestUpdateTrafficData(Context context, String number, CallBack callBack);

    void RequestFlowDetection(Context context, String number, CallBack callBack);

    void RequestSpeechDetection(Context context, String number, CallBack callBack);

    void RequestWhiteListDiagnosis(Context context, String number, CallBack callBack);

    void RequestReadCardStatus(Context context, String number, CallBack callBack);
}
