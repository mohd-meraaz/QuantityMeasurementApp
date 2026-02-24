package com.apps.quantitymeasurementapp;

public class Weight {
	private double value;
	private WeightUnit weigthUnit;
	private static final double EPSILON = 0.01;
	
	public Weight(double value, WeightUnit weigthUnit) {
		if(Double.isNaN(value)) {
			throw new IllegalArgumentException("NaN value!");
		}
		if(weigthUnit==null) {
			throw new IllegalArgumentException("NaN value!");
		}
		this.value = value;
		this.weigthUnit = weigthUnit;
	}
	
	public boolean compare(Weight input) {
		return Math.abs(this.weigthUnit.convertToBaseUnit(this.value) - input.weigthUnit.convertToBaseUnit(input.value))<EPSILON;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		
		if(obj==null || obj.getClass()!=this.getClass()) {
			return false;
		}
		
		return this.compare((Weight)obj);
	}
	
	
	@Override
	public String toString() {
		return "Weight [value=" + value + ", weigthUnit=" + weigthUnit + "]";
	}
	
	//convertTo
	public Weight convertTo(WeightUnit unit) {
		double converted = ((this.value*this.weigthUnit.getConversion())/unit.getConversion());
		return new Weight(converted,unit);
	}
	//add
	public Weight add(Weight weight) {
		weight = weight.convertTo(this.weigthUnit);
		return new Weight((this.value+weight.value),this.weigthUnit);
	}
	
	//add
	public Weight add(Weight weight, WeightUnit unit) {
		Weight weight1 = addAndConvert(weight, unit);
		Weight weight2 = addAndConvert(this, unit);
		return weight1.add(weight2);
	}
	
	private Weight addAndConvert(Weight weight, WeightUnit targetUnit) {
		double baseValue = weight.value*weight.weigthUnit.getConversion();
		double convertToBase = convertFromBaseToTargetUnit(baseValue, targetUnit);
		return new Weight(convertToBase,targetUnit);
	}
	
	private double convertFromBaseToTargetUnit(double values, WeightUnit targetUnit) {
		return values/targetUnit.getConversion();
	}

	public static void main(String args[]) {
		Weight we1 = new Weight(12.0, WeightUnit.KILOGRAM);
		Weight we2 = new Weight(12000.0, WeightUnit.GRAM);
		
		System.out.println(we1.equals(we2));
		
		System.out.println(we1.convertTo(WeightUnit.GRAM));
		
		System.out.println(we2.add(we1));
		
		System.out.println(we1.add(we2, WeightUnit.MILLIGRAM));
	}
}