package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        if (telNumber.isEmpty()) return false;
        if (!telNumber.matches("[0-9,\\+,\\(, \\)]*")) return false;
        if (telNumber.contains("(") && !telNumber.contains(")")) return false;
        if (telNumber.startsWith("+") && telNumber.contains("(") && telNumber.length() != 15) return false;
        if (telNumber.startsWith("+") && !telNumber.contains("(") && telNumber.length() != 13) return false;
        if (Character.isDigit(telNumber.charAt(0)) && telNumber.contains("(") && telNumber.length() != 12) return false;
        if (Character.isDigit(telNumber.charAt(0)) && !telNumber.contains("(") && telNumber.length() != 10) return false;
        if (telNumber.startsWith("(") && telNumber.length() != 12) return false;
        if ((telNumber.contains("(")) && (telNumber.indexOf(')') - telNumber.indexOf('(') -1 != 3)) return false;
        if (!Character.isDigit(telNumber.charAt(telNumber.length()-1))) return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println("+380501234567 - true = " + checkTelNumber("+380501234567"));
        System.out.println("+3805012345673 - false = " + checkTelNumber("+3805012345673"));
        System.out.println("+38050123456 - false = " + checkTelNumber("+38050123456"));
        System.out.println("+38(050)1234567 - true = " + checkTelNumber("+38(050)1234567"));
        System.out.println("(050)1234567 - true = " + checkTelNumber("(050)1234567"));
        System.out.println("0(501)234567 - true = " + checkTelNumber("0(501)234567"));
        System.out.println("+38)050(1234567 - false = " + checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)123-45-67 - false = " + checkTelNumber("+38(050)123-45-67"));
        System.out.println("050ххх4567 - false = " + checkTelNumber("050ххх4567"));
        System.out.println("050123456 - false = " + checkTelNumber("050123456"));
        System.out.println("(0)501234567 - false = " + checkTelNumber("(0)501234567"));
        System.out.println("123456789012 - false = " + checkTelNumber("123456789012"));
        System.out.println("123(456)7890 - true = " + checkTelNumber("123(456)7890"));
        System.out.println("123456(789)0 - true = " + checkTelNumber("123456(789)0"));
        System.out.println("+123(456)789012 - true = " + checkTelNumber("+123(456)789012"));
        System.out.println("+123456(789)012 - true = " + checkTelNumber("+123456(789)012"));
        System.out.println("+123456789(456) - false = " + checkTelNumber("+123456789(456)"));
        System.out.println("Проверка на пустую строку \"\" - false = " + checkTelNumber(""));
        System.out.println("Проверка на null - false =  " + checkTelNumber(null));
    }
}
