package com.gooluke.core.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 咕噜科
 * ClassName: CoreDateUtils
 * date: 2023-06-10 15:38
 * Description: 时间工具类
 * version 1.0
 */
@Component
public class CoreDateUtils {

    private static final Logger log = LoggerFactory.getLogger(CoreDateUtils.class);
    private static final Map<String,DateTimeFormatter> dateTimeFormatterMap = new HashMap<>();
    private static final Map<String, SimpleDateFormat> simpleDateFormatMap = new HashMap<>();

    /**
     * 字符串转Date类型
     * @param date
     * @param format
     * @return
     */
    public Date String2date(String date,String format) {
        try {
            SimpleDateFormat sdf = getSimpleDateFormat(format);
            return sdf.parse(date);
        } catch (Exception e) {
            log.error("String2date error,format:{}|exception:",format,e);
            return null;
        }
    }

    private DateTimeFormatter getDateTimeFormatter (String format) {
        DateTimeFormatter formatter = dateTimeFormatterMap.get(format);
        if (formatter == null) {
            synchronized (CoreHttpUtils.class) {
                formatter = dateTimeFormatterMap.get(format);
                if (formatter != null) {
                    return formatter;
                }
                DateTimeFormatter newDateTimeFormatter = DateTimeFormatter.ofPattern(format);
                dateTimeFormatterMap.put(format,newDateTimeFormatter);
                log.info("dateTimeFormatterMap add pattern:[{}]",format);
                return newDateTimeFormatter;
            }
        }
        return formatter;
    }

    private SimpleDateFormat getSimpleDateFormat (String format) {
        SimpleDateFormat sdf = simpleDateFormatMap.get(format);
        if (sdf == null) {
            synchronized (CoreHttpUtils.class) {
                sdf = simpleDateFormatMap.get(format);
                if (sdf != null) {
                    return sdf;
                }
                SimpleDateFormat newSimpleDateFormat = new SimpleDateFormat(format);
                simpleDateFormatMap.put(format,newSimpleDateFormat);
                log.info("simpleDateFormatMap add pattern:[{}]",format);
                return newSimpleDateFormat;
            }
        }
        return sdf;
    }


}
