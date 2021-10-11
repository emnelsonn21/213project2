import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {

	@Test
	void testIsValid() {
		Date test1 = new Date("2/29/2021");
		boolean expected = false;
		boolean actual = test1.isValid();
		assertEquals(expected, actual);
		
		Date test2 = new Date("3/18/2020");
		expected = false;
		actual = test2.isValid();
		assertEquals(expected, actual);
		
		Date test3 = new Date("4/20/2022");
		expected = false;
		actual = test3.isValid();
		assertEquals(expected, actual);
		
		Date test4 = new Date("4/31/2021");
		expected = false;
		actual = test4.isValid();
		assertEquals(expected, actual);
		
		Date test5 = new Date("3/32/2021");
		expected = false;
		actual = test5.isValid();
		assertEquals(expected, actual);
		
		Date test6 = new Date("13/24/2021");
		expected = false;
		actual = test6.isValid();
		assertEquals(expected, actual);
		
		Date test7 = new Date("0/11/2021");
		expected = false;
		actual = test7.isValid();
		assertEquals(expected, actual);
		
		Date test8 = new Date("10/16/2021");
		expected = true;
		actual = test8.isValid();
		assertEquals(expected, actual);
			
			
	}

}
