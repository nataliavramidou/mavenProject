package operations;

import org.junit.Assert;
import org.junit.Test;

import filehandlers.FileIO;

import static org.mockito.Mockito.*;

/**
 * this class challenges the functionality of
 * ArrayOperrations class
 * @author natalia
 *
 */
public class ArrayOperrationsTest {
	FileIO file = mock(FileIO.class);
	IntegerOperations int_op = mock(IntegerOperations.class);
	
	ArrayOperrations array_op = new ArrayOperrations(file, int_op);
	
	/**
	 * the method test_findMaxInFile checks 
	 * the result of the readFile method of FileIO
	 * class when the file that is read has valid inputs
	 * (it should be a new array that has as values the numbers 
	 * of the file valid_inputs)
	 * and then asserts "64" value as the expected 
	 * maximum value of the array 
	 * that the method findMaxInFile
	 * of the class ArrayOperrations will return
	 * when it is called	 * 
	 */
	@Test 
	public void test_findMaxInFile() {		
		when(file.readFile("src/test/resources/valid_inputs")).thenReturn(new int[] {3, 4, 6, 25, 9, 0, 4, 64});
		
		Assert.assertEquals(64, array_op.findMaxInFile("src/test/resources/valid_inputs"));
	}
	
	/**
	 * the method test_findMaxInFile_emptyArray_exception
	 * checks the result of the readFile method of FileIO
	 * class when the file that is read is an empty file
	 * (it should be a new empty array) and expects that
	 * IllegalArgumentException will be thrown when 
	 * the method findMaxInFile of the class ArrayOperrations 
	 * will be called
	 */
	@Test (expected = IllegalArgumentException.class)
	public void test_findMaxInFile_emptyArray_exception() {
		when(file.readFile("src/test/resources/empty_file")).thenReturn(new int[] {});
		
		array_op.findMaxInFile("src/test/resources/empty_file");
	}
	
	/**
	 * the method test_reverseArray checks 
	 * the result of the readFile method of FileIO
	 * class when the file that is read has valid inputs
	 * (it should be a new array that has as values the numbers 
	 * of the file valid_inputs),
	 * then checks the result of the reverseSign method
	 * when it is called for each element of the array.
	 * Then it asserts the variable reversedArray the expected 
	 * array that the method reverseArray
	 * of the class ArrayOperrations will return
	 * when it is called 
	 */
	@Test 
	public void test_reverseArray() {		
		int [] reversedArray = {-3, -4, -6, -25, -9, -0, -4, -64};
		when(file.readFile("src/test/resources/valid_inputs")).thenReturn(new int[] {3, 4, 6, 25, 9, 0, 4, 64});
		
		when(int_op.reverseSign(3)).thenReturn(-3);
		when(int_op.reverseSign(4)).thenReturn(-4);
		when(int_op.reverseSign(6)).thenReturn(-6);
		when(int_op.reverseSign(25)).thenReturn(-25);
		when(int_op.reverseSign(9)).thenReturn(-9);
		when(int_op.reverseSign(0)).thenReturn(-0);
		when(int_op.reverseSign(4)).thenReturn(-4);
		when(int_op.reverseSign(64)).thenReturn(-64);
		
		Assert.assertArrayEquals(reversedArray, array_op.reverseArray("src/test/resources/valid_inputs"));
	}
	
	/**
	 * the method test_reverseArray_emptyArray_exception
	 * checks the result of the readFile method of FileIO
	 * class when the file that is read is an empty file
	 * (it should be a new empty array) and expects that
	 * IllegalArgumentException will be thrown when 
	 * the method reverseArray of the class ArrayOperrations 
	 * will be called
	 */
	@Test (expected = IllegalArgumentException.class)
	public void test_reverseArray_emptyArray_exception() {
		when(file.readFile("src/test/resources/empty_file")).thenReturn(new int[] {});
		
		array_op.reverseArray("src/test/resources/empty_file");
	}

}
