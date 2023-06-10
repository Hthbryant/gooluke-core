package com.gooluke;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.metadata.WriteSheet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;

public class EasyExcelTest {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student().setName("小明").setAge(18).setAddress("江西"));
        students.add(new Student().setName("小红").setAge(17).setAddress("河北"));
        students.add(new Student().setName("小李").setAge(19).setAddress("广东"));
        String tempFilePath = "E:/work/temp/文件导出_"+ RandomStringUtils.random(16,"0123456789ABCDEF")+".xlsx";
        ExcelWriter excelWriter = EasyExcel.write(tempFilePath, Student.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        excelWriter.write(students, writeSheet);
        excelWriter.finish();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors(chain = true)
    public static class Student {
        @ExcelProperty("姓名")
        private String name;
        @ExcelProperty("年龄")
        private Integer age;
        @ExcelProperty("地址")
        private String address;
    }
}
