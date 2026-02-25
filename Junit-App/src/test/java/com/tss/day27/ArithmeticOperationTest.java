package com.tss.day27;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationTest {
    ArithmeticOperation operation = new ArithmeticOperation();

    @Test
    void add() {
        assertEquals(5,operation.add(2,3));
        assertEquals(7,operation.add(4,3));
        assertTrue(operation.add(2,3)==5);
        assertFalse(operation.add(2,6)==1);
    }

//    @Test
//    void sub() {
//        assertEquals(3,operation.sub(5,2));
//        assertEquals(7,operation.sub(9,2));
//    }
//
//    @Test
//    void mul() {
//        assertEquals(15,operation.mul(5,3));
//        assertEquals(25,operation.mul(5,5));
//    }

    @Test
    void divide() {
        assertEquals(5, operation.divide(15,3));
        assertEquals(3, operation.divide(15,5));
    }

    @Test
    void divideByZero(){
        assertThrows(ArithmeticException.class,()->operation.divide(5,0));
    }

    @Test
    void isInstanceOf(){
        assertInstanceOf(ArithmeticOperation.class,operation);
    }
}