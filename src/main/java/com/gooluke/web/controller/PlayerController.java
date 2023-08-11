package com.gooluke.web.controller;

import com.gooluke.biz.entity.Player;
import com.gooluke.biz.integration.dao.PlayerDAO;
import com.gooluke.common.dto.PageInfo;
import com.gooluke.common.tool.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
public class PlayerController {

    private static final JsonMapper JSON_MAPPER = JsonMapper.nonDefaultMapper();

    @Autowired
    private PlayerDAO playerDAO;
    @RequestMapping("/list")
    public List<Player> selectPlayerList (@RequestBody Player player, int currentPage, int pageSize) {
        PageInfo pageInfo = new PageInfo(currentPage, pageSize);
        player.setPage(pageInfo);
        log.info("selectPlayerList request:{}",JSON_MAPPER.toJson(player));
        return playerDAO.selectPlayerList(player);
    }

}
