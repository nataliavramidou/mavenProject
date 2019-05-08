package operations;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;

/**
 * This is a test class that challenges the functionality
 * of the IntegerOperations class
 * @author natalia
 *
 */
public class IntegerOperationsTest {
	IntegerOperations intOp = new IntegerOperations();
	
	@Test
	public void test_reverseSign_positive() {
		Assert.assertEquals(8, intOp.reverseSign(-8));
	}
	
	@Test
	public void test_reverseSign_negative() {
		Assert.assertEquals(-7, intOp.reverseSign(7));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_addNumbers_negativeInput_exception() {
		intOp.add(3, -4);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_addNumbers_integerOverflow_exception() {
		intOp.add(Integer.MAX_VALUE, 27);
	}
	
	@Test
	public void test_add_positive() {
		Assert.assertEquals(77, intOp.add(9, 68));
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test 
	public void test_powerOfTwo_negativeInput_RuleException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("-2 is not a positive integer.");
		intOp.powerOfTwo(-2);
	}
	
	@Test
	public void test_powerOfTwo_overflow_RuleException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("31^2 causes an integer overflow.");
		intOp.powerOfTwo(31);
	}
	
}
