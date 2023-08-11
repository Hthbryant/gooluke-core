package com.gooluke.biz.entity;

import com.gooluke.common.dto.PageInfo;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 咕噜科
 * ClassName: Player
 * date: 2022-06-08 22:39
 * Description:
 * version 1.0
 */
@Data
public class Player implements Serializable {

    private Integer id;
    private String name;
    private Integer age;
    private String phone;

    private PageInfo page;

}
