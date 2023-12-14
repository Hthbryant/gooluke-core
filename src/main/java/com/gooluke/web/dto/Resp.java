package com.gooluke.web.dto;

import com.gooluke.common.enums.AdminErrorStatus;
import io.github.hthbryant.gooluke.framework.biz.common.dto.BaseResponseDTO;
import io.github.hthbryant.gooluke.framework.biz.common.dto.PageInfo;
import lombok.Data;

/**
 * @author 咕噜科
 * ClassName: Resp
 * date: 2023-10-30 22:34
 * Description:
 * version 1.0
 */
@Data
public class Resp extends BaseResponseDTO {

    private String code;
    private String msg;
    private String bizSeqNo;
    private Object result;

    public Resp() {
        this.code = "0";
        this.msg = "success";
    }

    public Resp(AdminErrorStatus adminErrorStatus) {
        this.code = adminErrorStatus.getErrCode();
        this.msg = adminErrorStatus.getErrMsg();
    }

    public Resp(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Resp success(Object object) {
        Resp resp = new Resp();
        if (object instanceof BaseResponseDTO) {
            ((BaseResponseDTO) object).setCode(null);
            ((BaseResponseDTO) object).setMsg(null);
        }
        resp.setResult(object);
        return resp;
    }

    public static Resp page(PageInfo page,Object object) {
        Resp resp = new Resp();
        if (object instanceof BaseResponseDTO) {
            ((BaseResponseDTO) object).setCode(null);
            ((BaseResponseDTO) object).setMsg(null);
        }
        resp.setResult(object);
        resp.setPage(page);
        return resp;
    }


    public static Resp timeout() {
        return new Resp(AdminErrorStatus.TIMEOUT_EXCEPTION.getErrCode(), AdminErrorStatus.TIMEOUT_EXCEPTION.getErrMsg());
    }

    public static Resp exception() {
        return new Resp(AdminErrorStatus.SYSTEM_ERROR.getErrCode(), AdminErrorStatus.SYSTEM_ERROR.getErrMsg());
    }

    public static Resp genFail(String msg) {
        return new Resp(AdminErrorStatus.WRONG_PARAM.getErrCode(), msg);
    }

}
