package com.gooluke.web.controller;

import com.gooluke.biz.service.PlayerService;
import com.gooluke.common.dto.palyer.PlayerRequestDTO;
import io.github.hthbryant.gooluke.framework.biz.common.dto.BaseResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 咕噜科
 * ClassName: PlayerController
 * date: 2023-08-12 1:10
 * Description:
 * version 1.0
 */
@RestController
@RequestMapping("/player")
@Slf4j
public class PlayerController extends BaseController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping("/list")
    public BaseResponseDTO getPlayerList(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         @RequestBody PlayerRequestDTO requestDTO) {
        return doExecute(httpServletRequest, httpServletResponse, defaultTimeout, requestDTO, (request -> {
            return playerService.getPlayerList(request);
        }), timeoutResponse, exceptionResponse);
    }

}
