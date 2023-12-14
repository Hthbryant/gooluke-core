package com.gooluke.web.controller;

import com.gooluke.biz.function.MyFunction;
import com.gooluke.web.dto.Resp;
import io.github.hthbryant.gooluke.framework.biz.common.context.GoolukeContextUtil;
import io.github.hthbryant.gooluke.framework.biz.common.dto.BaseRequestDTO;
import io.github.hthbryant.gooluke.framework.biz.common.dto.BaseResponseDTO;
import io.github.hthbryant.gooluke.framework.biz.common.enums.ErrorStatus;
import io.github.hthbryant.gooluke.framework.biz.controller.GoolukeAbstractBaseController;
import io.github.hthbryant.gooluke.framework.biz.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author 咕噜科
 * ClassName: BaseController
 * date: 2023-10-30 22:30
 * Description:
 * version 1.0
 */
@Slf4j
public class BaseController extends GoolukeAbstractBaseController {

    protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);
    protected static final JsonMapper JSON_MAPPER = JsonMapper.nonEmptyMapper();

    protected static final BaseResponseDTO timeoutResponse = new BaseResponseDTO(ErrorStatus.TIMEOUT_EXCEPTION);
    protected static final BaseResponseDTO exceptionResponse = new BaseResponseDTO(ErrorStatus.SYSTEM_ERROR);

    protected static long defaultTimeout = 7000;

    public <E extends BaseRequestDTO> Resp doExecute(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse, E requestDTO, MyFunction<E> function) {
        return doExecute(httpServletRequest, httpServletResponse, defaultTimeout, requestDTO, (function::apply), Resp.timeout(), Resp.exception());
    }

    public <E extends BaseRequestDTO> Resp doExecute(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse, Long timeout, E requestDTO, MyFunction<E> function) {
        return doExecute(httpServletRequest, httpServletResponse, timeout, requestDTO, (function::apply), Resp.timeout(), Resp.exception());
    }

    @Override
    protected void preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BaseRequestDTO request, Method method) {
        //统一请求日志打印
        logger.info("{}.{} request:{}", method.getDeclaringClass().getSimpleName(), method.getName(), JSON_MAPPER.toJson(request));
    }

    @Override
    protected void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object response, Method method) {
        //统一响应日志打印
        logger.info("{}.{} response:{}", method.getDeclaringClass().getSimpleName(), method.getName(), JSON_MAPPER.toJson(response));
        if (response instanceof Resp) {
            ((Resp) response).setBizSeqNo(GoolukeContextUtil.getBizSeqNo());
        }
    }

    @Override
    protected void exceptionHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object response) {
        if (response instanceof Resp) {
            ((Resp) response).setBizSeqNo(GoolukeContextUtil.getBizSeqNo());
        }
    }
}
