package com.cxsz.mealbuy.model.net;

/**
 * 网络异常信息自定义
 */

public class NoNetWorkException extends RuntimeException {
    public NoNetWorkException() {

    }

    public NoNetWorkException(String message) {
        super(message);
    }
}
