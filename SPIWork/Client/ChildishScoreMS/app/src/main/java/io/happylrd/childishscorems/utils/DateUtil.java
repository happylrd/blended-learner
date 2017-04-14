package io.happylrd.childishscorems.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

    public static Date parse(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN, Locale.US);
        return sdf.parse(dateStr);
    }

    public static String getDateStr(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.YEAR) + "-"
                + StaticClass.autoFillZero((calendar.get(Calendar.MONTH) + 1), 2) + "-"
                + StaticClass.autoFillZero(calendar.get(Calendar.DAY_OF_MONTH), 2);
    }

    public static String getTimeStr(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return StaticClass.autoFillZero(calendar.get(Calendar.HOUR_OF_DAY), 2) + ":"
                + StaticClass.autoFillZero(calendar.get(Calendar.MINUTE), 2)
                + ":00";
    }
}
