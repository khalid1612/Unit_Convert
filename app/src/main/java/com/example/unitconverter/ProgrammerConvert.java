package com.example.unitconverter;

public class ProgrammerConvert {

    public static String decimalToBinary(long number){
        return Long.toBinaryString(number);
        //or, return Long.toString(number,2);
    }

    public static String decimalToOctal(long number){
        return Long.toOctalString(number);
        //or, return Long.toString(number,8);
    }

    public static String decimalToHex(long number){
        return Long.toHexString(number);
        //or, return Long.toString(number,16);
    }

    public static long binaryToDecimal(String number){
        return Long.parseLong(number,2);
    }

    public static String binaryToOctal(String number){
        //binary to decimal
        long convertDecimal = ProgrammerConvert.binaryToDecimal(number);
        //decimal to octal
        return ProgrammerConvert.decimalToOctal(convertDecimal);
    }

    public static String binaryToHex(String number){
        //binary to decimal
        long convertDecimal = ProgrammerConvert.binaryToDecimal(number);
        //decimal to hex
        return ProgrammerConvert.decimalToHex(convertDecimal);
    }

    public static long octalToDecimal(String number){
        return Long.parseLong(number,8);
    }

    public static String octalToBinary(String number){
        //convert to decimal
        long convertDecimal = ProgrammerConvert.octalToDecimal(number);
        //decimal to binary
        return ProgrammerConvert.decimalToBinary(convertDecimal);
    }

    public static String octalToHex(String number){
        //convert to decimal
        long convertDecimal = ProgrammerConvert.octalToDecimal(number);
        //decimal to binary
        return ProgrammerConvert.decimalToHex(convertDecimal);
    }

    public static long hexToDecimal(String number){
        return Long.parseLong(number,16);
    }

    public static String hexToBinary(String number){
        //convert to decimal
        long convertDecimal = ProgrammerConvert.hexToDecimal(number);
        // convert decimal to binary
        return ProgrammerConvert.decimalToBinary(convertDecimal);
    }

    public static String hexToOctal(String number){
        //convert to decimal
        long convertDecimal = ProgrammerConvert.hexToDecimal(number);
        // convert decimal to octal
        return ProgrammerConvert.decimalToOctal(convertDecimal);
    }
}
