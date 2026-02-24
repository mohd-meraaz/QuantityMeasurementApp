package com.apps.quantitymeasurementapp;

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