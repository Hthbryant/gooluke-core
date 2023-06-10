package com.gooluke.common.enums;

/**
 * @author 咕噜科
 * ClassName: ErrorStatus
 * date: 2023-06-10 15:01
 * Description:
 * version 1.0
 */
public enum ErrorStatus {

    SUCCESS("0",""),
    SYSTEM_ERROR("10000001","系统异常"),
    WRONG_PARAM("10000002","参数错误"),
    ;

    private String errCode;
    private String errMsg;

    ErrorStatus(String errCode,String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
