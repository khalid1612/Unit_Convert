package com.example.unitconverter;

import java.util.ArrayList;

public class DataConvert {

    public static String convert(double amount, String convertFrom, String convertTo) {
        ArrayList<String> dataType = new ArrayList<>();

        dataType.add("bytes");
        dataType.add("KB");
        dataType.add("MB");
        dataType.add("GB");
        dataType.add("TB");
        dataType.add("PB");
        dataType.add("EB");
        dataType.add("ZB");
        dataType.add("YB");

        int fromPosition = dataType.indexOf(convertFrom);
        int toPosition = dataType.indexOf(convertTo);

        double result;

        if (fromPosition < toPosition){
            int difference = toPosition - fromPosition;
            result = amount / (difference * 1024);
        }else{
            int difference = fromPosition - toPosition;
            result = amount * difference * 1024;
        }

        return String.valueOf(result);
    }
}
