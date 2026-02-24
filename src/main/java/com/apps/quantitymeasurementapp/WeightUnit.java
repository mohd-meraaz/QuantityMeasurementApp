package com.apps.quantitymeasurementapp;

public enum WeightUnit {
	KILOGRAM(1000.0),
	GRAM(1.0),
	MILLIGRAM(0.001),
	TONNE(1_000_000.0),
	POUND(453.592);
	
	private double conversion;
	
	WeightUnit(double conversion){
		this.conversion = conversion;
	}
	
	public double getConversion() {
		return conversion;
	}
	
	public double convertToBaseUnit(double value) {
		return ((value*this.getConversion())*100.0)/100.0;
	}
}