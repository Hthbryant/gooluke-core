package com.gooluke.biz.service.impl;

import com.gooluke.biz.entity.Player;
import com.gooluke.biz.integration.dao.PlayerDAO;
import com.gooluke.biz.service.PlayerService;
import com.gooluke.common.dto.palyer.PlayerRequestDTO;
import io.github.hthbryant.gooluke.framework.biz.common.dto.BaseResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 咕噜科
 * ClassName: PlayerServiceImpl
 * date: 2023-10-22 3:21
 * Description:
 * version 1.0
 */
@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerDAO playerDAO;

    @Override
    public BaseResponseDTO getPlayerList(PlayerRequestDTO requestDTO) {
        Player player = new Player();
        BeanUtils.copyProperties(player,requestDTO);
        List<Player> players = playerDAO.selectPlayerList(player);
        return BaseResponseDTO.success(players);
    }
}
