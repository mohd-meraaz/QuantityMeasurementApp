package com.apps.qualitymanagementsystem;

public class QuantityManagementApp {

    public static void main(String[] args) {

        Length len1 = new Length(1.0, Length.LengthUnit.FEET);
        Length len2 = new Length(12.0, Length.LengthUnit.INCH);

        System.out.println("Input: Quantity(1.0, FEET) and Quantity(12.0, INCH)");
        System.out.println("Output: Equal (" + len1.equals(len2) + ")");
        System.out.println("------------------------------------");

        Length len3 = new Length(1.0, Length.LengthUnit.INCH);
        Length len4 = new Length(1.0, Length.LengthUnit.INCH);

        System.out.println("Input: Quantity(1.0, INCH) and Quantity(1.0, INCH)");
        System.out.println("Output: Equal (" + len3.equals(len4) + ")");
    }
}