package com.project2.town.complaint.utils;

public class NumCheck {
    private NumCheck(){
        throw new IllegalStateException("Utility class");
    }
    public static boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}
