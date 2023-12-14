package com.gooluke.core.integration.dao;

import com.gooluke.core.entity.Player;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 咕噜科
 * ClassName: PlayerDAO
 * date: 2023-08-12 1:01
 * Description:
 * version 1.0
 */
@Mapper
public interface PlayerDAO {

    Player selectById(@Param("id") String id);

    List<Player> selectPlayerList(Player player);

}
