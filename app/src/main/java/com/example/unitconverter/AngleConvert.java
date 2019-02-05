package com.example.unitconverter;

public class AngleConvert {
    public static double degreeToRadian(double degree){
        //1° = π/180° = 0.005555556π = 0.01745329252 rad
        return degree * 0.01745329252;
    }

    public static double degreeToGradian(double degree){
        return degree * 1.11111;
    }

    public static double radianToDegree(double radian){
        //1 rad = 180°/π = 57.295779513°
        return radian * 57.295779513;
    }

    public static double radianToGradian(double radian){
        return radian * 63.662;
    }

    public static double gradianToDegree(double gradian){
        return gradian * 0.9;
    }

    public static double gradianToRadian(double gradian){
        return gradian * 0.015708;
    }
}
