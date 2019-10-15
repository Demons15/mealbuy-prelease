package com.cxsz.mealbuy.presenter.presenterInterface;


public interface IntelligentDiagnosisPresenter {

    void RequestRealNameDiagnosis(String number);

    void RequestCardPackageDiagnosis(String number);

    void RequestSynchronizationCardStatus(String number);

    void RequestUpdateVoiceData(String number);

    void RequestUpdateTrafficData(String number);

    void RequestFlowDetection(String number);

    void RequestSpeechDetection(String number);

    void RequestWhiteListDiagnosis(String number);

    void RequestReadCardStatus(String number);
}
