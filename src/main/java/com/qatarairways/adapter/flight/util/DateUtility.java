package com.qatarairways.adapter.flight.util;

import java.util.Date;

/**
 * Provides utility functions for date usages.
 */
public interface DateUtility {

    public Date getDateTime(int year, int month, int dayOfMonth, int hourOfDay, int minute, int sec);
}
