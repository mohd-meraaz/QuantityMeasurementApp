package com.apps.qualitymanagementsystem;
public class QuantityMeasurementApp {
	

	public static class FeetEquality {

		private final double value;
		
		public FeetEquality(Double value) {
			if(Double.isNaN(value)) {
				throw new IllegalArgumentException("Invalid input!");
			}
			this.value = value;
		}

		@Override
		public boolean equals(Object obj) {
			if(this==obj) {
				return true;
			}
			
			if(obj==null || obj.getClass()!=this.getClass()) {
				return false;
			}
			return Double.compare(this.value, ((FeetEquality)obj).value)==0;
		}
	}
	
	public static class InchEquality{
		private final double value;

		public InchEquality(double value) {
			if(Double.isNaN(value)) {
				throw new IllegalArgumentException("Invalid input!");
			}
			this.value = value;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(this==obj) {
				return true;
			}
			if(obj==null || obj.getClass()!=this.getClass()) {
				return false;
			}
			return Double.compare(this.value, ((InchEquality)obj).value)==0;
		}
	}
	
	public static boolean domonstrateInchEquality() {
		InchEquality inch1 = new InchEquality(23.2);
		InchEquality inch2 = new InchEquality(23.2);
		return inch1.equals(inch2);
	}
	public static boolean domonstrateFeetEquality() {
		FeetEquality feet1 = new FeetEquality(34.2);
		FeetEquality feet2 = new FeetEquality(34.2);
		return feet1.equals(feet2);
	}
	
	public static boolean domonstrateLengthEquality(Length l1, Length l2) {
		return l1.equals(l2);
	}
	
	public static void domonstrateFeetInchComparison() {
		Length oneFeet = new Length(1,Length.LengthUnit.FEET);
		Length twelveInches = new Length(12,Length.LengthUnit.INCHES);
		System.out.println("1 Feet = 12 Inches: "+oneFeet.equals(twelveInches));
		
		
		Length threeFeet = new Length(3,Length.LengthUnit.FEET);
		Length thirtysixInches = new Length(36,Length.LengthUnit.INCHES);
		System.out.println("3 Feet = 36 Inches: "+threeFeet.equals(thirtysixInches));
		
		Length oneInch = new Length(1, Length.LengthUnit.INCHES);
        Length oneFootAgain = new Length(1, Length.LengthUnit.FEET);

        System.out.println("1 Inch == 1 Foot : " + oneInch.equals(oneFootAgain));
	}
	
	public static void main(String[] args) {
		domonstrateFeetEquality();
		domonstrateInchEquality();
		
		domonstrateFeetInchComparison();
		
		//Domonstrate Feet to Inches
		System.out.println(domonstrateLengthEquality(new Length(1,Length.LengthUnit.FEET), new Length(12,Length.LengthUnit.INCHES)));
		
		
		//Domonstrate Yard to Inch
		System.out.println(domonstrateLengthEquality(new Length(1.0,Length.LengthUnit.YARD), new Length(36.0,Length.LengthUnit.INCHES)));
		
		//Domonstrate Centimeter to Inch
		System.out.println(domonstrateLengthEquality(new Length(100.0,Length.LengthUnit.CENTIMETERS), new Length(39.37,Length.LengthUnit.INCHES)));
		
		//Domonstrate Feet to Yard
		System.out.println(domonstrateLengthEquality(new Length(3.0,Length.LengthUnit.FEET), new Length(1.0,Length.LengthUnit.YARD)));
		
		//Domonstrate Centimeter to feet
		System.out.println(domonstrateLengthEquality(new Length(30.48,Length.LengthUnit.CENTIMETERS), new Length(1.0,Length.LengthUnit.FEET)));
	}
}