package com.cxsz.mealbuy.presenter.presenterImpl;


import android.content.Context;

import com.cxsz.mealbuy.model.callback.CallBack;
import com.cxsz.mealbuy.model.modelImpl.IntelligentDiagnosisModelImpl;
import com.cxsz.mealbuy.model.modelInterface.IntelligentDiagnosisModel;
import com.cxsz.mealbuy.model.net.MealCodeData;
import com.cxsz.mealbuy.presenter.presenterInterface.IntelligentDiagnosisPresenter;
import com.cxsz.mealbuy.view.viewInterface.IntelligentDiagnosisView;

public class IntelligentDiagnosisPresenterImpl implements IntelligentDiagnosisPresenter {
    private Context context;
    private IntelligentDiagnosisView intelligentDiagnosisView;
    private IntelligentDiagnosisModel intelligentDiagnosisModel;

    public IntelligentDiagnosisPresenterImpl(Context context, IntelligentDiagnosisView intelligentDiagnosisView) {
        this.context = context;
        this.intelligentDiagnosisView = intelligentDiagnosisView;
        intelligentDiagnosisModel = new IntelligentDiagnosisModelImpl();
    }

    @Override
    public void RequestRealNameDiagnosis(String number) {
        intelligentDiagnosisView.showLoadingView();
        intelligentDiagnosisModel.RequestRealNameDiagnosis(context, number, new CallBack() {
            @Override
            public void onSuccess(Object response) {
                MealCodeData bodyBean = (MealCodeData) response;
                intelligentDiagnosisView.ResponseRealNameDiagnosis(bodyBean);
                intelligentDiagnosisView.closeLoadingView();
            }

            @Override
            public void onError(String error) {
                if (error != null) {
                    intelligentDiagnosisView.showErrorInfo(error);
                }
                intelligentDiagnosisView.closeLoadingView();
            }
        });
    }

    @Override
    public void RequestCardPackageDiagnosis(String number) {
        intelligentDiagnosisView.showLoadingView();
        intelligentDiagnosisModel.RequestCardPackageDiagnosis(context, number, new CallBack() {
            @Override
            public void onSuccess(Object response) {
                MealCodeData bodyBean = (MealCodeData) response;
                intelligentDiagnosisView.ResponseCardPackageDiagnosis(bodyBean);
                intelligentDiagnosisView.closeLoadingView();
            }

            @Override
            public void onError(String error) {
                if (error != null) {
                    intelligentDiagnosisView.showErrorInfo(error);
                }
                intelligentDiagnosisView.closeLoadingView();
            }
        });
    }

    @Override
    public void RequestSynchronizationCardStatus(String number) {
        intelligentDiagnosisView.showLoadingView();
        intelligentDiagnosisModel.RequestSynchronizationCardStatus(context, number, new CallBack() {
            @Override
            public void onSuccess(Object response) {
                MealCodeData bodyBean = (MealCodeData) response;
                intelligentDiagnosisView.ResponseSynchronizationCardStatus(bodyBean);
                intelligentDiagnosisView.closeLoadingView();
            }

            @Override
            public void onError(String error) {
                if (error != null) {
                    intelligentDiagnosisView.showErrorInfo(error);
                }
                intelligentDiagnosisView.closeLoadingView();
            }
        });
    }

    @Override
    public void RequestUpdateVoiceData(String number) {
        intelligentDiagnosisView.showLoadingView();
        intelligentDiagnosisModel.RequestUpdateVoiceData(context, number, new CallBack() {
            @Override
            public void onSuccess(Object response) {
                MealCodeData bodyBean = (MealCodeData) response;
                intelligentDiagnosisView.ResponseUpdateVoiceData(bodyBean);
                intelligentDiagnosisView.closeLoadingView();
            }

            @Override
            public void onError(String error) {
                if (error != null) {
                    intelligentDiagnosisView.showErrorInfo(error);
                }
                intelligentDiagnosisView.closeLoadingView();
            }
        });
    }

    @Override
    public void RequestUpdateTrafficData(String number) {
        intelligentDiagnosisView.showLoadingView();
        intelligentDiagnosisModel.RequestUpdateTrafficData(context, number, new CallBack() {
            @Override
            public void onSuccess(Object response) {
                MealCodeData bodyBean = (MealCodeData) response;
                intelligentDiagnosisView.ResponseUpdateTrafficData(bodyBean);
                intelligentDiagnosisView.closeLoadingView();
            }

            @Override
            public void onError(String error) {
                if (error != null) {
                    intelligentDiagnosisView.showErrorInfo(error);
                }
                intelligentDiagnosisView.closeLoadingView();
            }
        });
    }

    @Override
    public void RequestFlowDetection(String number) {
        intelligentDiagnosisView.showLoadingView();
        intelligentDiagnosisModel.RequestFlowDetection(context, number, new CallBack() {
            @Override
            public void onSuccess(Object response) {
                MealCodeData bodyBean = (MealCodeData) response;
                intelligentDiagnosisView.ResponseFlowDetection(bodyBean);
                intelligentDiagnosisView.closeLoadingView();
            }

            @Override
            public void onError(String error) {
                if (error != null) {
                    intelligentDiagnosisView.showErrorInfo(error);
                }
                intelligentDiagnosisView.closeLoadingView();
            }
        });
    }

    @Override
    public void RequestSpeechDetection(String number) {
        intelligentDiagnosisView.showLoadingView();
        intelligentDiagnosisModel.RequestSpeechDetection(context, number, new CallBack() {
            @Override
            public void onSuccess(Object response) {
                MealCodeData bodyBean = (MealCodeData) response;
                intelligentDiagnosisView.ResponseSpeechDetection(bodyBean);
                intelligentDiagnosisView.closeLoadingView();
            }

            @Override
            public void onError(String error) {
                if (error != null) {
                    intelligentDiagnosisView.showErrorInfo(error);
                }
                intelligentDiagnosisView.closeLoadingView();
            }
        });
    }

    @Override
    public void RequestWhiteListDiagnosis(String number) {
        intelligentDiagnosisView.showLoadingView();
        intelligentDiagnosisModel.RequestWhiteListDiagnosis(context, number, new CallBack() {
            @Override
            public void onSuccess(Object response) {
                MealCodeData bodyBean = (MealCodeData) response;
                intelligentDiagnosisView.ResponseWhiteListDiagnosis(bodyBean);
                intelligentDiagnosisView.closeLoadingView();
            }

            @Override
            public void onError(String error) {
                if (error != null) {
                    intelligentDiagnosisView.showErrorInfo(error);
                }
                intelligentDiagnosisView.closeLoadingView();
            }
        });
    }

    @Override
    public void RequestReadCardStatus(String number) {
        intelligentDiagnosisView.showLoadingView();
        intelligentDiagnosisModel.RequestReadCardStatus(context, number, new CallBack() {
            @Override
            public void onSuccess(Object response) {
                MealCodeData bodyBean = (MealCodeData) response;
                intelligentDiagnosisView.ResponseReadCardStatus(bodyBean);
                intelligentDiagnosisView.closeLoadingView();
            }

            @Override
            public void onError(String error) {
                if (error != null) {
                    intelligentDiagnosisView.showErrorInfo(error);
                }
                intelligentDiagnosisView.closeLoadingView();
            }
        });
    }
}
