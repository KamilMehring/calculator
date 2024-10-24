package kalkulator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAddOne(){
        Calculator sut = new Calculator();
        sut.add(1);
        assertEquals(1, sut.getState());
    }

    @Test
    public void testMultOneByTwo(){
        Calculator sut = new Calculator();
        sut.setState(1);
        sut.mult(2);
        assertEquals(2, sut.getState());
    }

    @Test
    public void testAddZero(){
        Calculator sut = new Calculator();
        sut.add(0);
        assertEquals(0, sut.getState());
    }

    @Test
    public void testAddNegativeNumber(){
        Calculator sut = new Calculator();
        sut.add(-5);
        assertEquals(-5, sut.getState());
    }

    @Test
    public void testAddOverflow(){
        Calculator sut = new Calculator();
        sut.setState(Integer.MAX_VALUE);
        sut.add(1);
        assertEquals(Integer.MIN_VALUE, sut.getState());
    }

    @Test
    public void testMultByZero(){
        Calculator sut = new Calculator();
        sut.setState(5);
        sut.mult(0);
        assertEquals(0, sut.getState());
    }

    @Test
    public void testMultByNegativeNumber(){
        Calculator sut = new Calculator();
        sut.setState(4);
        sut.mult(-2);
        assertEquals(-8, sut.getState());
    }

    @Test
    public void testMultOverflow(){
        Calculator sut = new Calculator();
        sut.setState(Integer.MAX_VALUE);
        sut.mult(2);
        assertEquals(-2, sut.getState());
    }

    @Test
    public void testSubtraction(){
        Calculator sut = new Calculator();
        sut.setState(5);
        sut.sub(3);
        assertEquals(2, sut.getState());
    }

    @Test
    public void testSubtractionWithNegativeResult(){
        Calculator sut = new Calculator();
        sut.setState(2);
        sut.sub(5);
        assertEquals(-3, sut.getState());
    }

    @Test
    public void testDivision(){
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.div(2);
        assertEquals(5, sut.getState());
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero(){
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.div(0);
    }

    @Test
    public void testStoreAndRecallMemory(){
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.storeInMemory();
        assertEquals(10, sut.recallFromMemory());
    }

    @Test
    public void testClearMemory(){
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.storeInMemory();
        sut.clearMemory();
        assertEquals(0, sut.recallFromMemory());
    }

    @Test
    public void testAddMemory(){
        Calculator sut = new Calculator();
        sut.setState(5);
        sut.storeInMemory();
        sut.setState(10);
        sut.addMemory();
        assertEquals(15, sut.getState());
    }

    @Test
    public void testMultMemory(){
        Calculator sut = new Calculator();
        sut.setState(3);
        sut.storeInMemory();
        sut.setState(4);
        sut.multMemory();
        assertEquals(12, sut.getState());
    }
}
