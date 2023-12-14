package com.gooluke.core.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author 咕噜科
 * ClassName: UserInfoExcel
 * date: 2023-06-11 10:40
 * Description:
 * version 1.0
 */
@Data
public class UserInfoExcelData {

    @ExcelProperty(value = "姓名",index = 0)
    private String userName;
    @ExcelProperty(value = "年龄",index = 1)
    private Integer age;
    @ExcelProperty(value = "地址",index = 2)
    private String address;

}
