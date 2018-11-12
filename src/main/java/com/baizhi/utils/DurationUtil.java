package com.baizhi.utils;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;
import java.io.File;
public class DurationUtil {
    public static String getVideoTime(File f) {
        String time = "";
        //新建编码器对象
        Encoder encoder = new Encoder();
        try {
            //得到多媒体视频的信息
            MultimediaInfo m = encoder.getInfo(f);
            //得到毫秒级别的多媒体是视频长度
            long ls = m.getDuration();
            //转换为分秒
            time = ls / 60000 + "分" + (ls - (ls / 60000 * 60000)) / 1024 + "秒";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }
}