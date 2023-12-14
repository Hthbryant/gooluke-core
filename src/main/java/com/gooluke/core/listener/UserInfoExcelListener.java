package com.gooluke.core.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import com.gooluke.core.entity.UserInfoExcelData;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 咕噜科
 * ClassName: UserInfoExcelListener
 * date: 2023-06-11 10:52
 * Description:
 * version 1.0
 */
@Data
public class UserInfoExcelListener implements ReadListener<UserInfoExcelData> {

    private static final Logger log = LoggerFactory.getLogger(UserInfoExcelListener.class);

    private List<UserInfoExcelData> dataList = new ArrayList<>();

    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;
    /**
     * 缓存的数据
     */
    private List<UserInfoExcelData> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    public UserInfoExcelListener() {

    }

    @Override
    public void invoke(UserInfoExcelData data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
        dataList.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("所有数据解析完成");
    }

    private void saveData () {

    }
}
