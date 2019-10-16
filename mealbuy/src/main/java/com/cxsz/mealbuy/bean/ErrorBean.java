package com.cxsz.mealbuy.bean;

public class ErrorBean {
    private String requestTag;
    private String errorInfo;

    public ErrorBean(String requestTag, String errorInfo) {
        this.requestTag = requestTag;
        this.errorInfo = errorInfo;
    }

    public String getRequestTag() {
        return requestTag;
    }

    public void setRequestTag(String requestTag) {
        this.requestTag = requestTag;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }
}
