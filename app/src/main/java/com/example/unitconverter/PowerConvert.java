package com.example.unitconverter;

public class PowerConvert {
    public static double wattToKilowatt(double watt){
        return watt / 1000;
    }

    public static double wattToHorsepower(double watt){
        return watt * .001341;
    }

    public static double kilowattToWatt(double kilowatt){
        return kilowatt * 1000;
    }

    public static double kilowattToHorsepower(double kilowatt){
        return kilowatt * 1.341022;
    }

    public static double horsepowerToWatt(double horsepower){
        return horsepower / .001341;
    }

    public static double horsepowerToKilowatt(double horsepower){
        return horsepower / 1.341022;
    }
}
