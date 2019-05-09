package operations;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * A class dedicated to the parameterized tests
 * of the method powerOfTwo of IntegerOperations class
 * @author natalia
 *
 */

@RunWith(Parameterized.class)
public class IntegerOperationsParameterizedTest {

	@Parameter (value = 0)
	public int number;

	@Parameter (value = 1)
	public int product;

	IntegerOperations intOp = new IntegerOperations();

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{1,2}, {2,4}, {3,8}, {4, 16}, {5,32}};
		return Arrays.asList(data);
	}

	@Test
	public void test_powerOfTwo_zeroInput() {
		Assert.assertEquals(product, intOp.powerOfTwo(number));
	}

}
