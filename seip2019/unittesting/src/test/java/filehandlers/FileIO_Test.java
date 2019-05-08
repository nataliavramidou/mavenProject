package filehandlers;


import org.junit.Assert;
import org.junit.Test;

/**
 * This class challenges the functionality
 * of the FileIO class
 * @author natalia
 *
 */

public class FileIO_Test {
	
	FileIO file = new FileIO();
	
	
	/**
	 * the method test_getLinesArray
	 * checks if the result of the readFile method of FileIO
	 * class when the file that is read has valid inputs
	 * is the expected array (the variable validLines)
	 */
	@Test
	public void test_getLinesArray() {
	    int[] validLines = {3, 4, 6, 25, 9, 0, 4, 64};
		Assert.assertArrayEquals(validLines, file.readFile("src/test/resources/valid_inputs"));
	}
	
	/**
	 * the method test_getLinesArray_filepathNotExist_exception
	 * checks the result of the readFile method of FileIO
	 * class when the filepath that it takes as an argument does
	 * not exist, and expects that an IllegalArgumentExcpetion
	 * will be thrown
	 */
	@Test (expected = IllegalArgumentException.class)
	public void test_getLinesArray_filepathNotExist_exception() {
		file.readFile("src/test/resources/somefile");
	}
	
	/**
	 * the method test_getLinesArray_invalidIntegers_exception
	 * checks the result of the readFile method of FileIO
	 * class when the file that is read has invalid inputs
	 * and expects that NumberFormatException
	 * will be thrown
	 */
	@Test (expected = NumberFormatException.class)
	public void test_getLinesArray_invalidIntegers_exception() {
		file.readFile("src/test/resources/invalid_inputs");
	}

}
