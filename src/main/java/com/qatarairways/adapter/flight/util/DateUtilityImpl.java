package com.qatarairways.adapter.flight.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtilityImpl implements DateUtility{

    @Override
    public Date getDateTime(int year, int month, int dayOfMonth, int hourOfDay, int minute, int sec) {
        Calendar cal = new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute, sec);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return cal.getTime();
    }
}
