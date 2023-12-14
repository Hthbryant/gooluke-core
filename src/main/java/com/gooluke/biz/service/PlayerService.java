package com.gooluke.biz.service;

import com.gooluke.common.dto.palyer.PlayerRequestDTO;
import io.github.hthbryant.gooluke.framework.biz.common.dto.BaseResponseDTO;

/**
 * @author 咕噜科
 * ClassName: PlayerService
 * date: 2023-10-22 3:21
 * Description:
 * version 1.0
 */
public interface PlayerService {

    BaseResponseDTO getPlayerList(PlayerRequestDTO requestDTO);

}
