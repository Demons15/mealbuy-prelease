package com.cxsz.mealbuy.view.widget;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.base.BaseWindowView;
import com.cxsz.mealbuy.bean.ContactBean;

/**
 * 联系人添加弹窗
 * Created by yangqian on 2017/2/3.
 */

public class AddContactShowPopWindow extends BaseWindowView {
    private EditText contactName;
    private EditText contactPhoneNumber;

    private SureContactListener sureContactListener;

    public AddContactShowPopWindow(Activity activity) {
        super(activity, Gravity.BOTTOM);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.add_contact_windows_layout;
    }

    @Override
    protected void initView() {
        contactName = findViewById(R.id.contact_name);
        contactPhoneNumber = findViewById(R.id.contact_phone_number);
        TextView cancel = findViewById(R.id.cancel);//添加联系人取消按钮
        TextView sure = findViewById(R.id.sure);//添加联系人确定按钮
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactBean contactBean = new ContactBean();
                contactBean.setContactName(contactName.getText().toString());
                contactBean.setContactPhoneNumber(contactPhoneNumber.getText().toString());
                sureContactListener.sureContact(contactBean);
            }
        });
    }

    public void setContactInfo(ContactBean messageBean) {
        contactName.setText(messageBean.getContactName() + "");
        contactPhoneNumber.setText(messageBean.getContactPhoneNumber() + "");
    }

    public void setOnSureContactListener(SureContactListener sureContactListener) {
        this.sureContactListener = sureContactListener;
    }

    public interface SureContactListener {
        void sureContact(ContactBean messageBean);
    }

    @Override
    public void showPopupWindow() {
        super.showPopupWindow();
        contactName.setText("");
        contactPhoneNumber.setText("");

    }
}
