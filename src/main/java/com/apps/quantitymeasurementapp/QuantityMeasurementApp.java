package com.apps.quantitymeasurementapp;

import com.apps.quantitymeasurementapp.Length.LengthUnit;

public class QuantityMeasurementApp {

    // Old approach (separate classes)
    public static class FeetEquality {
        private final double value;

        public FeetEquality(Double value) {
            if (Double.isNaN(value)) {
                throw new IllegalArgumentException("Invalid input!");
            }
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            return Double.compare(this.value, ((FeetEquality) obj).value) == 0;
        }
    }

    public static class InchEquality {
        private final double value;

        public InchEquality(double value) {
            if (Double.isNaN(value)) {
                throw new IllegalArgumentException("Invalid input!");
            }
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            return Double.compare(this.value, ((InchEquality) obj).value) == 0;
        }
    }

    public static boolean demonstrateInchEquality() {
        return new InchEquality(23.2).equals(new InchEquality(23.2));
    }

    public static boolean demonstrateFeetEquality() {
        return new FeetEquality(34.2).equals(new FeetEquality(34.2));
    }

    // UC3 demonstrations
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static void demonstrateFeetInchComparison() {
        System.out.println("1 Foot = 12 Inches: " +
                new Length(1, LengthUnit.FEET)
                        .equals(new Length(12, LengthUnit.INCHES)));

        System.out.println("3 Feet = 36 Inches: " +
                new Length(3, LengthUnit.FEET)
                        .equals(new Length(36, LengthUnit.INCHES)));

        System.out.println("1 Inch == 1 Foot: " +
                new Length(1, LengthUnit.INCHES)
                        .equals(new Length(1, LengthUnit.FEET)));
    }

    public static Length demonstrateLengthConversion(Length l1, LengthUnit unit)
            throws InvalidUnitMeasurementException {
        return l1.convertTo(unit);
    }

    public static Length demonstrateLengthConversion(Double val,
                                                     LengthUnit unit1,
                                                     LengthUnit unit2)
            throws InvalidUnitMeasurementException {
        if (val == null) {
            throw new InvalidUnitMeasurementException("Value cannot be null!");
        }
        return new Length(val, unit1).convertTo(unit2);
    }

    public static boolean demonstrateLengthComparison(Length l1, Length l2) {
        return l1.compare(l2);
    }

    public static Length convertFromBaseToTargetUnit(Length l1, Length l2)
            throws InvalidUnitMeasurementException {
        if (l1 == null || l2 == null) {
            throw new InvalidUnitMeasurementException("Null object not allowed!");
        }
        return l1.add(l2);
    }

    public static void main(String[] args) throws InvalidUnitMeasurementException {

        demonstrateFeetEquality();
        demonstrateInchEquality();
        demonstrateFeetInchComparison();

        System.out.println(demonstrateLengthEquality(
                new Length(1, LengthUnit.FEET),
                new Length(12, LengthUnit.INCHES)));

        System.out.println(demonstrateLengthEquality(
                new Length(1.0, LengthUnit.YARD),
                new Length(36.0, LengthUnit.INCHES)));

        System.out.println(demonstrateLengthEquality(
                new Length(100.0, LengthUnit.CENTIMETERS),
                new Length(39.37, LengthUnit.INCHES)));

        System.out.println(demonstrateLengthEquality(
                new Length(3.0, LengthUnit.FEET),
                new Length(1.0, LengthUnit.YARD)));

        System.out.println(demonstrateLengthEquality(
                new Length(30.48, LengthUnit.CENTIMETERS),
                new Length(1.0, LengthUnit.FEET)));

        System.out.println("Convert Feet to Inches: " +
                demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES));

        System.out.println("Convert Yard to Feet: " +
                demonstrateLengthConversion(3.0, LengthUnit.YARD, LengthUnit.FEET));

        System.out.println("Convert Inches to Yard: " +
                demonstrateLengthConversion(36.0, LengthUnit.INCHES, LengthUnit.YARD));

        System.out.println("Convert Centimeter to Inches: " +
                demonstrateLengthConversion(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES));

        System.out.println("Convert Feet to Inches: " +
                demonstrateLengthConversion(0.0, LengthUnit.FEET, LengthUnit.INCHES));

        System.out.println("Add Feet to Feet: " +
                convertFromBaseToTargetUnit(
                        new Length(1.0, LengthUnit.FEET),
                        new Length(2.0, LengthUnit.FEET)));

        System.out.println("Add Feet to Inches: " +
                convertFromBaseToTargetUnit(
                        new Length(1.0, LengthUnit.FEET),
                        new Length(12.0, LengthUnit.INCHES)));

        System.out.println("Add Inches to Feet: " +
                convertFromBaseToTargetUnit(
                        new Length(12.0, LengthUnit.INCHES),
                        new Length(1.0, LengthUnit.FEET)));

        System.out.println("Add Yard to Feet: " +
                convertFromBaseToTargetUnit(
                        new Length(1.0, LengthUnit.YARD),
                        new Length(3.0, LengthUnit.FEET)));

        System.out.println("Add Inches to Yard: " +
                convertFromBaseToTargetUnit(
                        new Length(36.0, LengthUnit.INCHES),
                        new Length(2.0, LengthUnit.YARD)));

        System.out.println("Add Centimeter to Inches: " +
                convertFromBaseToTargetUnit(
                        new Length(2.54, LengthUnit.CENTIMETERS),
                        new Length(1.0, LengthUnit.INCHES)));

        System.out.println("Add Feet to Inches: " +
                convertFromBaseToTargetUnit(
                        new Length(5.0, LengthUnit.FEET),
                        new Length(0.0, LengthUnit.INCHES)));

        System.out.println("Add Feet to Feet: " +
                convertFromBaseToTargetUnit(
                        new Length(5.0, LengthUnit.FEET),
                        new Length(-2.0, LengthUnit.FEET)));
    }
}