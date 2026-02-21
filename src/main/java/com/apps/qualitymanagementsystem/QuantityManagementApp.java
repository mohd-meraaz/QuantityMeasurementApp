package com.apps.qualitymanagementsystem;

public class QuantityManagementApp {

    // Generic Base Class
    public static abstract class Quantity<T extends Quantity<T>> {

        protected final double value;

        public Quantity(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Quantity<?> other = (Quantity<?>) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Feet class
    public static class Feet extends Quantity<Feet> {
        public Feet(double value) {
            super(value);
        }
    }

    // Inches class
    public static class Inches extends Quantity<Inches> {
        public Inches(double value) {
            super(value);
        }
    }

    public static void main(String[] args) {

        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        System.out.println("Input : 1.0 ft and 1.0 ft");
        System.out.println("Output: Equals (" + f1.equals(f2) + ")");
        System.out.println("------------------------------------");

        Inches i1 = new Inches(1.0);
        Inches i2 = new Inches(1.0);

        System.out.println("Input : 1.0 inches and 1.0 inches");
        System.out.println("Output: Equals (" + i1.equals(i2) + ")");

        System.out.println("------------------------------------");

        System.out.println("Cross comparison (Feet vs Inches): "
                + f1.equals(i1));  // false
    }
}
