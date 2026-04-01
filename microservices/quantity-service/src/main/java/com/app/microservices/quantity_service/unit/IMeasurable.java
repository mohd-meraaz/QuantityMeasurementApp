package com.app.microservices.quantity_service.unit;

@FunctionalInterface
interface SupportsArithmetic{
    boolean isSupported();
}

public interface IMeasurable {
	SupportsArithmetic supportsArithmetic = ()-> true;

	double getConversionFactor();
	double convertToBaseUnit(double value);
	double convertFromBaseUnit(double baseValue);
	String getUnitName();
	String getMeasurableType();
	
	default boolean supportsArithmetic() {
		return supportsArithmetic.isSupported();
	}
	
	default void validateOperationSupport(String operation) {};
}