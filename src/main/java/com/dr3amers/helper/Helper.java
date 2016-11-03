package com.dr3amers.helper;

import java.sql.Date;
import java.sql.Timestamp;

public class Helper {

    public static Timestamp setCurrentTimestamp() {
        java.util.Date date = new Date(System.currentTimeMillis());
        return new Timestamp(date.getTime());
    }
}
