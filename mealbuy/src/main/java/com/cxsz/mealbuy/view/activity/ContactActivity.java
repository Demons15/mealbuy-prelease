package com.cxsz.mealbuy.view.activity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.R2;
import com.cxsz.mealbuy.adapter.ContactListRecyclerAdapter;
import com.cxsz.mealbuy.base.BaseActivity;
import com.cxsz.mealbuy.bean.ContactBean;
import com.cxsz.mealbuy.component.MealConstants;
import com.cxsz.mealbuy.component.MealInfoHelper;
import com.cxsz.mealbuy.component.ToastUtil;
import com.cxsz.mealbuy.model.net.MealCodeData;
import com.cxsz.mealbuy.presenter.presenterImpl.ContactPresenterImpl;
import com.cxsz.mealbuy.presenter.presenterInterface.ContactPresenter;
import com.cxsz.mealbuy.view.viewInterface.ContactView;
import com.cxsz.mealbuy.view.widget.AddContactShowPopWindow;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class ContactActivity extends BaseActivity implements ContactView, AddContactShowPopWindow.SureContactListener, View.OnClickListener {
    @BindView(R2.id.base_left_iv)
    View leftArea;
    @BindView(R2.id.contact_notice_area)
    View contactNoticeArea;
    @BindView(R2.id.contact_notice_info)
    TextView contactNoticeInfo;
    @BindView(R2.id.contact_list)
    RecyclerView contactList;

    @BindView(R2.id.contact_control_area)
    View contactControlArea;
    @BindView(R2.id.all_choose)
    CheckBox allChoose;
    @BindView(R2.id.refresh_contact)
    LinearLayout refreshContact;
    @BindView(R2.id.delete_contact)
    LinearLayout deleteContact;

    @BindView(R2.id.add_contact)
    LinearLayout addContact;

    ContactPresenter contactPresenter;

    public String controlContactType;
    private AddContactShowPopWindow addContactShowPopWindow;
    private ContactListRecyclerAdapter contactListRecyclerAdapter;

    private ArrayList<ContactBean> mobiles = new ArrayList<ContactBean>();

    @Override
    protected int getLayoutId() {
        return R.layout.contact_list_layout;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this);
        addContactShowPopWindow = new AddContactShowPopWindow(ContactActivity.this);
        addContactShowPopWindow.setOnSureContactListener(this);
        contactListRecyclerAdapter = new ContactListRecyclerAdapter(mobiles);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ContactActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        contactList.setLayoutManager(linearLayoutManager);
        contactList.setAdapter(contactListRecyclerAdapter);
        contactPresenter = new ContactPresenterImpl(this, this);
        contactPresenter.RequestQueryVoiceWhiteList("1", MealInfoHelper.getInstance().getNumber());
        contactPresenter.RequestQueryAddWhiteCount("1", MealInfoHelper.getInstance().getNumber());
        leftArea.setOnClickListener(this);
        refreshContact.setOnClickListener(this);
        deleteContact.setOnClickListener(this);
        addContact.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.refresh_contact) {
            contactPresenter.RequestQueryVoiceWhiteList("1", MealInfoHelper.getInstance().getNumber());
        } else if (view.getId() == R.id.delete_contact) {
            deleteWhiteList();
        } else if (view.getId() == R.id.add_contact) {
            addContactShowPopWindow.showPopupWindow();
        } else if (view.getId() == R.id.base_left_iv) {
            finish();
        }
    }

    private void deleteWhiteList() {
        StringBuilder stringBuilder = new StringBuilder();
        Observable.from(contactListRecyclerAdapter.mobiles).filter(new Func1<ContactBean, Boolean>() {
            @Override
            public Boolean call(ContactBean contactBean) {
                return contactBean.isCheck();
            }
        }).subscribe(new Action1<ContactBean>() {
            @Override
            public void call(ContactBean contactBean) {
                stringBuilder.append(contactBean.getContactPhoneNumber()).append(",");
            }
        });

        if (stringBuilder.length() > 0) {
            setControlContactType(MealConstants.DELETE_CONTACT);
            contactPresenter.RequestAddOrDelVoiceWhiteManager(MealConstants.CONTACT_INPUT_TYPE, MealInfoHelper.getInstance().getNumber(), MealConstants.DELETE_CONTACT, stringBuilder.substring(0, stringBuilder.length() - 1));
        } else {
            ToastUtil.show(ContactActivity.this, "暂无选中要删除的数据!");
        }
    }

    @OnCheckedChanged({R2.id.all_choose})
    public void onCheckChange(CompoundButton compoundButton, boolean isCheck) {
        if (compoundButton.getId() == R.id.all_choose) {
            if (isCheck) {
                ToastUtil.show(ContactActivity.this, "勾选了全部!");
                contactListRecyclerAdapter.checkAll();
            } else {
                ToastUtil.show(ContactActivity.this, "取消勾选全部!");
                contactListRecyclerAdapter.unCheckAll();
            }
        }
    }

    @Override
    public void ResponseAddOrDelVoiceWhiteManager(MealCodeData mealCodeData) {
        if (getControlContactType().equals(MealConstants.ADD_CONTACT)) {
            addContactShowPopWindow.dismiss();
        } else if (getControlContactType().equals(MealConstants.DELETE_CONTACT)) {
            contactListRecyclerAdapter.deleteContact();
        }
        contactPresenter.RequestQueryVoiceWhiteList("1", MealInfoHelper.getInstance().getNumber());
        contactPresenter.RequestQueryAddWhiteCount("1", MealInfoHelper.getInstance().getNumber());
    }

    @Override
    public void ResponseQueryVoiceWhiteList(MealCodeData mealCodeData) {
        if (null != mealCodeData.getBody()) {
            ArrayList<String> mobiles = (ArrayList<String>) (((LinkedTreeMap) mealCodeData.getBody()).get("mobile"));
            if (null != mobiles) {
                ArrayList<ContactBean> contactBeans = new ArrayList<ContactBean>();
                Observable.from(mobiles).subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        contactBeans.add(new ContactBean(s, false));
                    }
                });
                contactListRecyclerAdapter.refreshContacts(contactBeans);
                contactControlArea.setVisibility(View.VISIBLE);
            } else {
                contactControlArea.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void ResponseQueryAddWhiteCount(MealCodeData mealCodeData) {
        if (((LinkedTreeMap) mealCodeData.getBody()) != null) {
            Double aDouble = (Double) ((LinkedTreeMap) mealCodeData.getBody()).get("count");
            double doubleValue = aDouble.doubleValue();
            String number = 20 - (int) doubleValue + "";
            String allNumber = "20";
            String numberCount = 20 - (int) doubleValue + "";
            String allNumberCount = "20";
            String noticeInfo = String.format("目前通讯录支持 <font color='#FFAD28'>" + number + "</font>/" + allNumber + "人，每月开通 " + " <font color='#FFAD28'>" + numberCount + "</font>" + "/ " + allNumberCount + "次");
            contactNoticeInfo.setText(Html.fromHtml(noticeInfo));
        }
    }

    @Override
    public void showLoadingView() {
        startProgressDialog();
    }

    @Override
    public void closeLoadingView() {
        stopProgressDialog();
    }

    @Override
    public void showSuccessInfo(String info) {
        ToastUtil.show(ContactActivity.this, info);
    }

    @Override
    public void showErrorInfo(String info) {
        ToastUtil.show(ContactActivity.this, info);
    }

    @Override
    public void showErrorInfo(String tag, String info) {

    }

    @Override
    public void sureContact(ContactBean messageBean) {
        if (messageBean.getContactName().isEmpty()) {
            ToastUtil.show(ContactActivity.this, "联系人不能为空!");
        } else if (messageBean.getContactPhoneNumber().isEmpty()) {
            ToastUtil.show(ContactActivity.this, "手机号不能为空!");
        } else {
            setControlContactType(MealConstants.ADD_CONTACT);
            contactPresenter.RequestAddOrDelVoiceWhiteManager(MealConstants.CONTACT_INPUT_TYPE, MealInfoHelper.getInstance().getNumber(), MealConstants.ADD_CONTACT, messageBean.getContactPhoneNumber());
        }
    }

    public String getControlContactType() {
        return controlContactType;
    }

    public void setControlContactType(String controlContactType) {
        this.controlContactType = controlContactType;
    }
}
