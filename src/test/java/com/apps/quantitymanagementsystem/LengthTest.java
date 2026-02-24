package com.apps.quantitymanagementsystem;

import org.junit.jupiter.api.Test;

import com.apps.qualitymanagementsystem.Length;

import static org.junit.jupiter.api.Assertions.*;

public class LengthTest {

    @Test
    public void testEquality_FeetToFeet_SameValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.INCH);
        Length l2 = new Length(1.0, Length.LengthUnit.INCH);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_FeetToInch_Equivalent() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCH);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_InchToFeet_Equivalent() {
        Length l1 = new Length(12.0, Length.LengthUnit.INCH);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_DifferentValues() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(2.0, Length.LengthUnit.FEET);
        assertFalse(l1.equals(l2));
    }

    @Test
    public void testEquality_NullComparison() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        assertFalse(l1.equals(null));
    }

    @Test
    public void testEquality_SameReference() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(l1.equals(l1));
    }

    @Test
    public void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Length(1.0, null);
        });
    }
}