package com.lubanresearch.lubanmall.common.exception;

/**
 * @author hilbert.cao
 */
public class UIException extends BaseException {
    protected String desc = "应用服务器异常";
    protected Integer code = 100000;
    public UIException(){}
    public UIException(Integer code, String desc){super(code, desc);}
    public UIException(Integer code){super(code);}
}