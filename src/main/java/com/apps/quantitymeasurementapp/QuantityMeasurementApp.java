package com.apps.quantitymeasurementapp;

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
	
	public static boolean demonstrateInchEquality() {
		InchEquality inch1 = new InchEquality(23.2);
		InchEquality inch2 = new InchEquality(23.2);
		return inch1.equals(inch2);
	}
	
	public static boolean demonstrateFeetEquality() {
		FeetEquality feet1 = new FeetEquality(34.2);
		FeetEquality feet2 = new FeetEquality(34.2);
		return feet1.equals(feet2);
	}
						//demonstrateLength
	public static boolean demonstrateLengthEquality(Length l1, Length l2) {
		return l1.equals(l2);
	}
	
	public static void demonstrateFeetInchComparison() {
		Length oneFeet = new Length(1,LengthUnit.FEET);
		Length twelveInches = new Length(12,LengthUnit.INCHES);
		System.out.println("1 Feet = 12 Inches: "+oneFeet.equals(twelveInches));
		
		
		Length threeFeet = new Length(3,LengthUnit.FEET);
		Length thirtysixInches = new Length(36,LengthUnit.INCHES);
		System.out.println("3 Feet = 36 Inches: "+threeFeet.equals(thirtysixInches));
		
		Length oneInch = new Length(1, LengthUnit.INCHES);
        Length oneFootAgain = new Length(1, LengthUnit.FEET);

        System.out.println("1 Inch == 1 Foot : " + oneInch.equals(oneFootAgain));
	}
	
	public static Length demonstrateLengthConversion(Length l1, LengthUnit unit) throws InvalidUnitMeasurementException{
		l1 = l1.convertTo(unit);
		return l1;
	}
	
	public static Length demonstrateLengthConversion(Double val, LengthUnit unit1, LengthUnit unit2) throws InvalidUnitMeasurementException{
		if(val==null) {
			throw new InvalidUnitMeasurementException("Value null!");
		}
		Length result = new Length(val,unit1);
		return result.convertTo(unit2);
	}
	
	public static boolean demonstrateLengthComparison(Length l1, Length l2) {
		return l1.compare(l2);
	}
	
	
	public static Length convertFromBaseToTargetUnit(Length l1, Length l2) throws InvalidUnitMeasurementException {
		if(l1==null || l2 ==null) {
			throw new InvalidUnitMeasurementException("Null Object!");
		}
		return (l1.add(l2));
	}
	
	public static Length demonstrateLengthAddition(Length l1, Length l2, LengthUnit unit) throws InvalidUnitMeasurementException {
		if(l1==null || l2 ==null) {
			throw new InvalidUnitMeasurementException("Null Object!");
		}
		return l1.add(l2, unit);
	}
	
	public static Weight demonstrateWeightAddition(Weight w1, Weight w2) throws InvalidUnitMeasurementException {
		if(w1==null || w2 ==null) {
			throw new InvalidUnitMeasurementException("Null Object!");
		}
		return (w1.add(w2));
	}
	public static Weight demonstrateWeightAddition(Weight w1, Weight w2, WeightUnit unit) throws InvalidUnitMeasurementException {
		if(w1==null || w2 ==null) {
			throw new InvalidUnitMeasurementException("Null Object!");
		}
		return (w1.add(w2,unit));
	}
	
	public static Weight demonstrateWeightConversion(Weight w1, WeightUnit unit) throws InvalidUnitMeasurementException{
		w1 = w1.convertTo(unit);
		return w1;
	}
	
	public static Weight demonstrateWeightConversion(double value, WeightUnit from, WeightUnit to) {
		return new Weight(value, from).convertTo(to);
	}
	
	public static boolean demonstrateWeightEquality(Weight w1, Weight w2) {
	    return w1.equals(w2);
	}
	
	
	public static void main(String[] args) throws InvalidUnitMeasurementException {
		
		demonstrateFeetEquality();
		demonstrateInchEquality();
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		demonstrateFeetInchComparison();
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Domonstrate Feet to Inches
		System.out.println(demonstrateLengthEquality(new Length(1,LengthUnit.FEET), new Length(12,LengthUnit.INCHES)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		
		//Domonstrate Yard to Inch
		System.out.println(demonstrateLengthEquality(new Length(1.0,LengthUnit.YARD), new Length(36.0,LengthUnit.INCHES)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Domonstrate Centimeter to Inch
		System.out.println(demonstrateLengthEquality(new Length(100.0,LengthUnit.CENTIMETERS), new Length(39.37,LengthUnit.INCHES)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Domonstrate Feet to Yard
		System.out.println(demonstrateLengthEquality(new Length(3.0,LengthUnit.FEET), new Length(1.0,LengthUnit.YARD)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Domonstrate Centimeter to feet
		System.out.println(demonstrateLengthEquality(new Length(30.48,LengthUnit.CENTIMETERS), new Length(1.0,LengthUnit.FEET)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: convert(1.0, FEET, INCHES) → Output: 12.0
		System.out.println("Convert Feet to Inches: "+(demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: convert(3.0, YARDS, FEET) → Output: 9.0
		System.out.println("Convert Yard to Feet: "+(demonstrateLengthConversion(3.0, LengthUnit.YARD, LengthUnit.FEET)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: convert(36.0, INCHES, YARDS) → Output: 1.0
		System.out.println("Convert Inches to Yard: "+(demonstrateLengthConversion(36.0, LengthUnit.INCHES, LengthUnit.YARD)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: convert(1.0, CENTIMETERS, INCHES) → Output: ~0.393701
		System.out.println("Convert Centimeter to Inches: "+(demonstrateLengthConversion(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: convert(0.0, FEET, INCHES) → Output: 0.0
		System.out.println("Convert Feet to Inches: "+(demonstrateLengthConversion(0.0, LengthUnit.FEET, LengthUnit.INCHES)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");

		
		//Input: add(Quantity(1.0, FEET), Quantity(2.0, FEET))
		//Output: Quantity(3.0, FEET)
		System.out.println("Add Feet to Feet: "+(convertFromBaseToTargetUnit(new Length(1.0,LengthUnit.FEET), new Length(2.0,LengthUnit.FEET))));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: add(Quantity(1.0, FEET), Quantity(12.0, INCHES))
		//Output: Quantity(2.0, FEET)
		System.out.println("Add Feet to Inches: "+(convertFromBaseToTargetUnit(new Length(1.0,LengthUnit.FEET), new Length(12.0,LengthUnit.INCHES))));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: add(Quantity(12.0, INCHES), Quantity(1.0, FEET))
		//Output: Quantity(24.0, INCHES)
		System.out.println("Add Inches to Feet: "+(convertFromBaseToTargetUnit(new Length(12.0,LengthUnit.INCHES), new Length(1.0,LengthUnit.FEET))));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: add(Quantity(1.0, YARDS), Quantity(3.0, FEET))
		//Output: Quantity(2.0, YARDS)
		System.out.println("Add Yard to Feet: "+(convertFromBaseToTargetUnit(new Length(1.0,LengthUnit.YARD), new Length(3.0,LengthUnit.FEET))));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: add(Quantity(36.0, INCHES), Quantity(1.0, YARDS))
		//Output: Quantity(72.0, INCHES)
		System.out.println("Add Inches to Yard: "+(convertFromBaseToTargetUnit(new Length(36.0,LengthUnit.INCHES), new Length(2.0,LengthUnit.YARD))));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: add(Quantity(2.54, CENTIMETERS), Quantity(1.0, INCHES))
		//Output: Quantity(~5.08, CENTIMETERS)
		System.out.println("Add Centimeter to Inches: "+(convertFromBaseToTargetUnit(new Length(2.54,LengthUnit.CENTIMETERS), new Length(1.0,LengthUnit.INCHES))));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: add(Quantity(5.0, FEET), Quantity(0.0, INCHES))
		//Output: Quantity(5.0, FEET)
		System.out.println("Add Feet to Inches: "+(convertFromBaseToTargetUnit(new Length(5.0,LengthUnit.FEET), new Length(0.0,LengthUnit.INCHES))));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: add(Quantity(5.0, FEET), Quantity(-2.0, FEET))
		//Output: Quantity(3.0, FEET)
		System.out.println("Add Feet to Feet: "+(convertFromBaseToTargetUnit(new Length(5.0,LengthUnit.FEET), new Length(-2.0,LengthUnit.FEET))));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");

		//Input: add(Quantity(1.0, FEET), Quantity(12.0, INCHES), FEET) → Output: Quantity(2.0, FEET)
		System.out.println("Addition to Feet: "+(demonstrateLengthAddition(new Length(1.0,LengthUnit.FEET), new Length(36.0,LengthUnit.INCHES), LengthUnit.FEET)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: add(Quantity(1.0, FEET), Quantity(12.0, INCHES), INCHES) → Output: Quantity(24.0, INCHES)
		System.out.println("Addition to Inches: "+(demonstrateLengthAddition(new Length(1.0,LengthUnit.FEET), new Length(12.0,LengthUnit.INCHES), LengthUnit.INCHES)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: add(Quantity(1.0, FEET), Quantity(12.0, INCHES), YARDS) → Output: Quantity(~0.667, YARDS)
		System.out.println("Addition to Yards: "+(demonstrateLengthAddition(new Length(1.0,LengthUnit.FEET), new Length(12.0,LengthUnit.INCHES), LengthUnit.YARD)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: add(Quantity(1.0, YARDS), Quantity(3.0, FEET), YARDS) → Output: Quantity(2.0, YARDS)
		System.out.println("Addition to Yards: "+(demonstrateLengthAddition(new Length(1.0,LengthUnit.YARD), new Length(3.0,LengthUnit.FEET), LengthUnit.YARD)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: add(Quantity(36.0, INCHES), Quantity(1.0, YARDS), FEET) → Output: Quantity(6.0, FEET)
		System.out.println("Addition to Feet: "+(demonstrateLengthAddition(new Length(36.0,LengthUnit.INCHES), new Length(1.0,LengthUnit.YARD), LengthUnit.FEET)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: add(Quantity(2.54, CENTIMETERS), Quantity(1.0, INCHES), CENTIMETERS) → Output: Quantity(~5.08, CENTIMETERS)
		System.out.println("Addition to Centimeters: "+(demonstrateLengthAddition(new Length(2.54,LengthUnit.CENTIMETERS), new Length(1.0,LengthUnit.INCHES), LengthUnit.CENTIMETERS)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: add(Quantity(5.0, FEET), Quantity(0.0, INCHES), YARDS) → Output: Quantity(~1.667, YARDS)
		System.out.println("Addition to Yards: "+(demonstrateLengthAddition(new Length(5.0,LengthUnit.FEET), new Length(0.0,LengthUnit.INCHES), LengthUnit.YARD)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: add(Quantity(5.0, FEET), Quantity(-2.0, FEET), INCHES) → Output: Quantity(36.0, INCHES)
		System.out.println("Addition to Inches: "+(demonstrateLengthAddition(new Length(5.0,LengthUnit.FEET), new Length(-2.0,LengthUnit.INCHES), LengthUnit.INCHES)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		
		//Input: Quantity(1.0, FEET).convertTo(INCHES) → Output: Quantity(12.0, INCHES)
		System.out.println("Convert Feet to Inches: "+(demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: Quantity(1.0, FEET).add(Quantity(12.0, INCHES), FEET) → Output: Quantity(2.0, FEET)
		System.out.println("Addition to Feet: "+(demonstrateLengthAddition(new Length(1.0,LengthUnit.FEET), new Length(36.0,LengthUnit.INCHES), LengthUnit.FEET)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: Quantity(36.0, INCHES).equals(Quantity(1.0, YARDS)) → Output: true
		System.out.println("36.0 Inches Equals to 1.0 Yards: "+demonstrateLengthEquality(new Length(36.0,LengthUnit.INCHES), new Length(1.0,LengthUnit.YARD)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: Quantity(1.0, YARDS).add(Quantity(3.0, FEET), YARDS) → Output: Quantity(2.0, YARDS)
		System.out.println("Addition to Yards: "+(demonstrateLengthAddition(new Length(1.0,LengthUnit.YARD), new Length(3.0,LengthUnit.FEET), LengthUnit.YARD)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: Quantity(2.54, CENTIMETERS).convertTo(INCHES) → Output: Quantity(~1.0, INCHES) (within epsilon)
		System.out.println("Convert Feet to Inches: "+(demonstrateLengthConversion(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: Quantity(5.0, FEET).add(Quantity(0.0, INCHES), FEET) → Output: Quantity(5.0, FEET)
		System.out.println("Addition to Feets: "+(demonstrateLengthAddition(new Length(5.0,LengthUnit.FEET), new Length(0.0,LengthUnit.INCHES), LengthUnit.FEET)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: LengthUnit.FEET.convertToBaseUnit(12.0) → Output: 12.0 (already in base unit)
		System.out.println("Convert Feet to Feets: "+(demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.FEET)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: LengthUnit.INCHES.convertToBaseUnit(12.0) → Output: 1.0 (converted to feet)
		System.out.println("Convert Feet to Inches: "+(demonstrateLengthConversion(36.0, LengthUnit.INCHES, LengthUnit.FEET)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: Weight(1.0, KILOGRAM).equals(Weight(1.0, KILOGRAM)) → Output: true
		System.out.println("1 KG Equals 1 KG: " +
		        demonstrateWeightEquality(
		                new Weight(1.0, WeightUnit.KILOGRAM),
		                new Weight(1.0, WeightUnit.KILOGRAM)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: Weight(1.0, KILOGRAM).equals(Weight(1000.0, GRAM)) → Output: true
		System.out.println("1 KG Equals 1000 GRAM: " +
		        demonstrateWeightEquality(
		                new Weight(1.0, WeightUnit.KILOGRAM),
		                new Weight(1000.0, WeightUnit.GRAM)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: Weight(1.0, KILOGRAM).equals(Weight(2.20462, POUND)) → Output: true (epsilon)
		System.out.println("1 KG Equals 2.20462 POUND: " +
		        demonstrateWeightEquality(
		                new Weight(1.0, WeightUnit.KILOGRAM),
		                new Weight(2.20462, WeightUnit.POUND)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: Weight(500.0, GRAM).equals(Weight(0.5, KILOGRAM)) → Output: true
		System.out.println("500 GRAM Equals 0.5 KG: " +
		        demonstrateWeightEquality(
		                new Weight(500.0, WeightUnit.GRAM),
		                new Weight(0.5, WeightUnit.KILOGRAM)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: Weight(1.0, KILOGRAM).convertTo(GRAM)
		System.out.println("Convert KG to GRAM: " +
		        demonstrateWeightConversion(1.0,
		                WeightUnit.KILOGRAM,
		                WeightUnit.GRAM));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: Weight(2.0, POUND).convertTo(KILOGRAM)
		System.out.println("Convert POUND to KG: " +
		        demonstrateWeightConversion(2.0,
		                WeightUnit.POUND,
		                WeightUnit.KILOGRAM));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: Weight(500.0, GRAM).convertTo(POUND)
		System.out.println("Convert GRAM to POUND: " +
		        demonstrateWeightConversion(500.0,
		                WeightUnit.GRAM,
		                WeightUnit.POUND));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: Weight(1.0, KILOGRAM).add(Weight(1000.0, GRAM))
		System.out.println("Add KG + GRAM: " +
		        demonstrateWeightAddition(
		                new Weight(1.0, WeightUnit.KILOGRAM),
		                new Weight(1000.0, WeightUnit.GRAM)));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: Weight(1.0, KILOGRAM).add(Weight(1000.0, GRAM), GRAM)
		System.out.println("Add to GRAM: " +
		        demonstrateWeightAddition(
		                new Weight(1.0, WeightUnit.KILOGRAM),
		                new Weight(1000.0, WeightUnit.GRAM),
		                WeightUnit.GRAM));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
		//Input: Weight(2.0, KILOGRAM).add(Weight(4.0, POUND), KILOGRAM)
		System.out.println("Add KG + POUND to KG: " +
		        demonstrateWeightAddition(
		                new Weight(2.0, WeightUnit.KILOGRAM),
			                new Weight(4.0, WeightUnit.POUND),
			                	WeightUnit.KILOGRAM));
		System.out.println("----*----*----*----*----*----*----*----*----*----*----*----*----");
	}
}