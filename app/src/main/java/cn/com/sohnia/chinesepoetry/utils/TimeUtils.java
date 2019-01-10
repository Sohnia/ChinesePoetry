package cn.com.sohnia.chinesepoetry.utils;

import java.util.Calendar;


public class TimeUtils {
    //月
    Calendar calendar = Calendar.getInstance();

    private int year = calendar.get(Calendar.YEAR);
    //月
    private int month = calendar.get(Calendar.MONTH)+1;
    //日
    private int day = calendar.get(Calendar.DAY_OF_MONTH);
    //获取系统时间
    //小时
    private int hour = calendar.get(Calendar.HOUR_OF_DAY);
    //分钟
    private int minute = calendar.get(Calendar.MINUTE);
    //秒
    private int second = calendar.get(Calendar.SECOND);

    public String getCurrentDate(){
        return String.format("%s年%s月%s日",year,month,day);
    }

    public String getCurrentTime(){
        return String.format("%s年%s月%s日%s:%s:%s",year,month,day,hour,minute,second);
    }

}
