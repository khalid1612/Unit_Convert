package com.example.unitconverter;

public class LengthConvert {
    public static double cmToM(double centimeter){
        return centimeter / 100;
    }

    public static double cmToKm(double centimeter){
        return centimeter / 100000;
    }

    public static double mToCm(double meter){
        return meter * 100;
    }

    public static double mToKm(double meter){
        return meter / 1000;
    }

    public static double kToCm(double kiloMeter){
        return kiloMeter * 100000;
    }

    public static double kToM(double kiloMeter){
        return kiloMeter * 1000;
    }
}
