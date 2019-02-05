package com.example.unitconverter;

public class TemperatureConvert {
    public static double celsiusToFahrenheit(double celsiusTemperature){
        return celsiusTemperature * 1.8 + 32;
    }

    public static double celsiusToKelvin(double celsiusTemperature){
        return celsiusTemperature + 273.15;
    }

    public static double fahrenheitToCelsius(double fahrenheitTemperature){
        return (fahrenheitTemperature - 32) / 1.8;
    }

    public static double fahrenheitToKelvin(double fahrenheitTemperature){
        return (fahrenheitTemperature + 459.67) * (5/9);
    }

    public static double kelvinToCelsius(double kelvinTemperature){
        return kelvinTemperature - 273.15;
    }

    public static double kelvinToFahrenheit(double kelvinTemperature){
        return kelvinTemperature * (9/5) - 459.67;
    }
}
