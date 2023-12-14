package com.gooluke.common.enums;

/**
 * @author 咕噜科
 * ClassName: ErrorStatus
 * date: 2023-06-10 15:01
 * Description:
 * version 1.0
 */
public enum AdminErrorStatus {

    //系统错误码
    SUCCESS("0","success"),
    SYSTEM_ERROR("17020001","系统异常"),
    SYSTEM_BUSY("17020002","系统繁忙，请稍后重试"),
    TIMEOUT_EXCEPTION("17020003","系统超时"),
    WRONG_PARAM("17020004","参数错误"),
    UNAUTHORIZED_ERROR("17020005","请求不合法或登录态已失效"),

    //用户错误码
    LOGIN_WRONG("17021001","用户不存在或密码错误"),

    //文件
    FILE_NULL("17022001","上传文件不能为空"),
    FILE_NOT_EXIST("17022002","文件不存在"),
    ;

    private String errCode;
    private String errMsg;

    AdminErrorStatus(String errCode, String errMsg) {
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
