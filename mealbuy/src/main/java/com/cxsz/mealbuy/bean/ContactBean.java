package com.cxsz.mealbuy.bean;

public class ContactBean {
    private String contactName;
    private String contactPhoneNumber;
    private boolean isCheck;

    public ContactBean() {
    }

    public ContactBean(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }


    public ContactBean(String contactPhoneNumber, boolean isCheck) {
        this.contactPhoneNumber = contactPhoneNumber;
        this.isCheck = isCheck;
    }

    public ContactBean(String contactName, String contactPhoneNumber) {
        this.contactName = contactName;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
