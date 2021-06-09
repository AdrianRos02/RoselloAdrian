package calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnit_Test {

	 @Test
	    public void pruebaMultiplicar() throws Exception{
	        TestRPN calculator = new TestRPN();
	        assertEquals(calculator.calculate("4 5 * 5 2 * *"), Integer.valueOf(200));
	    }
	 public void pruebaMultiplicar2() throws Exception{
	        TestRPN calculator = new TestRPN();
	        assertEquals(calculator.calculate("4 5 * 5 2 * "), Integer.valueOf(200));
	    }



}
