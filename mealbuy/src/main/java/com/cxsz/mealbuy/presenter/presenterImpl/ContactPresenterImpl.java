package com.cxsz.mealbuy.presenter.presenterImpl;

import android.content.Context;

import com.cxsz.mealbuy.model.callback.CallBack;
import com.cxsz.mealbuy.model.modelImpl.ContactModelImpl;
import com.cxsz.mealbuy.model.modelInterface.ContactModel;
import com.cxsz.mealbuy.model.net.MealCodeData;
import com.cxsz.mealbuy.presenter.presenterInterface.ContactPresenter;
import com.cxsz.mealbuy.view.viewInterface.ContactView;

public class ContactPresenterImpl implements ContactPresenter {
    private Context context;
    private ContactView contactView;
    private ContactModel intelligentDiagnosisModel;
    
    public ContactPresenterImpl(Context context, ContactView contactView) {
        this.context = context;
        this.contactView = contactView;
        intelligentDiagnosisModel = new ContactModelImpl();
    }

    @Override
    public void RequestAddOrDelVoiceWhiteManager(String type, String msisdn, String operType, String phone) {
        contactView.showLoadingView();
        intelligentDiagnosisModel.RequestAddOrDelVoiceWhiteManager(context, type, msisdn, operType, phone, new CallBack() {
            @Override
            public void onSuccess(Object response) {
                MealCodeData bodyBean = (MealCodeData) response;
                contactView.ResponseAddOrDelVoiceWhiteManager(bodyBean);
                contactView.closeLoadingView();
                if (bodyBean.getMessage() != null) {
                    contactView.showSuccessInfo(bodyBean.getMessage());
                }
            }

            @Override
            public void onError(String error) {
                if (error != null) {
                    contactView.showErrorInfo(error);
                }
                contactView.closeLoadingView();
            }
        });
    }

    @Override
    public void RequestQueryVoiceWhiteList(String type, String msisdn) {
        contactView.showLoadingView();
        intelligentDiagnosisModel.RequestQueryVoiceWhiteList(context, type, msisdn, new CallBack() {
            @Override
            public void onSuccess(Object response) {
                MealCodeData bodyBean = (MealCodeData) response;
                contactView.ResponseQueryVoiceWhiteList(bodyBean);
                contactView.closeLoadingView();
            }

            @Override
            public void onError(String error) {
                if (error != null) {
                    contactView.showErrorInfo(error);
                }
                contactView.closeLoadingView();
            }
        });
    }

    @Override
    public void RequestQueryAddWhiteCount(String type, String msisdn) {
        contactView.showLoadingView();
        intelligentDiagnosisModel.RequestQueryAddWhiteCount(context, type, msisdn, new CallBack() {
            @Override
            public void onSuccess(Object response) {
                MealCodeData bodyBean = (MealCodeData) response;
                contactView.ResponseQueryAddWhiteCount(bodyBean);
                contactView.closeLoadingView();
            }

            @Override
            public void onError(String error) {
                if (error != null) {
                    contactView.showErrorInfo(error);
                }
                contactView.closeLoadingView();
            }
        });
    }
}
