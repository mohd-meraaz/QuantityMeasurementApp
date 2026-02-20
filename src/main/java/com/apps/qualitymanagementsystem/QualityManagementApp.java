package com.apps.qualitymanagementsystem;

public class QualityManagementApp {
	
	public static class Feet{
		// Creating variable to store feet value
		private final double value ;
		
		// Constructor to initialize Feet
		public Feet(double _value){
			this.value = _value;
		}

		public double getValue() {
			return value;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(this==obj) return true;
			if(obj==null || getClass()!=obj.getClass()) return false;
			
			Feet other = (Feet) obj;
			return Double.compare(other.value, this.value) ==0;
		}
	}
	public static void main(String[] args) {
		Feet f1 = new Feet(1.0);
		
		Feet f2 = new Feet(1.0);
		
		System.out.println("Input : 1.0 ft and 1.0 ft");
		System.out.println("Output: Equals (" + f1.equals(f2)+")");
		
	}
	
}
