package com.cxsz.mealbuy.view.viewInterface;

public interface IntelligentDiagnosisView extends BaseView {

    <T> void ResponseRealNameDiagnosis(T t);

    <T> void ResponseCardPackageDiagnosis(T t);

    <T> void ResponseSynchronizationCardStatus(T t);

    <T> void ResponseUpdateVoiceData(T t);

    <T> void ResponseUpdateTrafficData(T t);

    <T> void ResponseFlowDetection(T t);

    <T> void ResponseSpeechDetection(T t);

    <T> void ResponseWhiteListDiagnosis(T t);

    <T> void ResponseReadCardStatus(T t);
}
