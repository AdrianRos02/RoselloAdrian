package calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnit_Test {

	 @Test
	    public void shouldCalculateCorrectWhenMultipliedMultipleValues() throws Exception{
	        TestRPN calculator = new TestRPN();
	        assertEquals(calculator.calculate("4 7 * 5 2 * *"), Integer.valueOf(280));
	    }


}
