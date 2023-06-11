package com.gooluke;

import com.alibaba.excel.EasyExcel;
import com.gooluke.common.entity.UserInfoExcelData;
import com.gooluke.common.listener.UserInfoExcelListener;

import java.util.List;

/**
 * @author 咕噜科
 * ClassName: FileReadTest
 * date: 2023-06-11 10:54
 * Description:
 * version 1.0
 */
public class FileReadTest {

    public static void main(String[] args) {
        try {
            String fileName = "E:\\work\\temp\\文件导出_CFC3A7DAD73337AF.xlsx";
            UserInfoExcelListener listener = new UserInfoExcelListener();
            // 这里默认读取第一个sheet
            EasyExcel.read(fileName, UserInfoExcelData.class, listener).sheet().doRead();
            List<UserInfoExcelData> dataList = listener.getDataList();
            System.out.println("dataList = " + dataList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
