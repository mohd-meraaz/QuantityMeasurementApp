package com.apps.quantitymeasurementapp;

public class Length {
	private double value;
	private LengthUnit len;
	private static final double EPSILON = 0.01;
	
	public enum LengthUnit{
		FEET(12.0),
		INCHES(1.0),
		YARD(36.0),
		CENTIMETERS(0.393701);
		
		private double conversion;
		
		LengthUnit(double conversion){
			this.conversion = conversion;
		}
		
		public double getConversion() {
			return conversion;
		}
	}
	
	public Length(double value, LengthUnit len) {
		if(Double.isNaN(value)) {
			throw new IllegalArgumentException("Invalid value!");
		}
		this.value = value;
		this.len = len;
	}
	
	private double ConvertToBaseUnit() {
		return ((this.value*this.len.getConversion())*100.0)/100.0;
	}
	
	public boolean compare(Length len) {
		return Math.abs(this.ConvertToBaseUnit() - len.ConvertToBaseUnit()) < EPSILON;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		
		if(obj==null || obj.getClass()!=this.getClass()) {
			return false;
		}
		
		return this.compare((Length)obj);
	}
	
	@Override
	public String toString() {
		return "Length [value=" + this.value + ", len=" + len + "]";
	}

	public Length convertTo(LengthUnit unit) {
		double result = (this.value*len.getConversion())/unit.getConversion();
		return new Length(result,unit);
	}
	
	public Length add(Length l1) {
		l1 = l1.convertTo(this.len);
		return new Length(this.value+l1.value,this.len);
	}
	
	public Length add(Length l1, LengthUnit unit) {
		Length length1 = addAndConvert(l1,unit);
		Length length2 = addAndConvert(this, len);
		return length1.add(length2);
	}
	
	private Length addAndConvert(Length length, LengthUnit targetUnit) {
		double baseValue = length.value*length.len.getConversion();
		double convertToBase = convertFromBaseToTargetUnit(baseValue, targetUnit);
		return new Length(convertToBase,targetUnit);
	}
	
	private double convertFromBaseToTargetUnit(double inches, LengthUnit targetUnit) {
		return inches/targetUnit.getConversion();
	}
	
	public static void main(String args[]) {
		Length len1 = new Length(1,Length.LengthUnit.INCHES);
		Length len2 = new Length(1,Length.LengthUnit.INCHES);
		System.out.println(len1.equals(len2));
		
		Length len3 = new Length(1.0,Length.LengthUnit.YARD);
		Length len4 = new Length(36.0,Length.LengthUnit.INCHES);
		System.out.println(len3.equals(len4));
		
		Length len5 = new Length(100.0,Length.LengthUnit.CENTIMETERS);
		Length len6 = new Length(39.37,Length.LengthUnit.INCHES);
		System.out.println(len5.equals(len6));
	}
}