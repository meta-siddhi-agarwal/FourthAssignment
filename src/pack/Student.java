package pack;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;


public class Student {
	
	//creating array operation class for calling their methods
	ArrOperation arrayOperationObject=new ArrOperation();
		
	//first test function for testing max mirror section function
	@Test
	public void testCaseForMaxMirror(){
		int testArray1[]= {1};
		assertEquals(1, arrayOperationObject.largestMirrorSection(testArray1));
		
		int testArray2[]= {2,2,2,2,2};
		assertEquals(5, arrayOperationObject.largestMirrorSection(testArray2));
		
		int testArray3[]= {1,2,3,4,5};
		assertEquals(1, arrayOperationObject.largestMirrorSection(testArray3));
		
		int testArray4[]= {1,2,1,4,5,4,5,6};
		assertEquals(3, arrayOperationObject.largestMirrorSection(testArray4));
		
		int testArray5[]= {10,20,30,40,30,20,10};
		assertEquals(7, arrayOperationObject.largestMirrorSection(testArray5));

		int testArray6[]= {};
		assertEquals(0, arrayOperationObject.largestMirrorSection(testArray6));
		
		int testArray7[]= {1,2,3,4,3,2,1,5};
		assertEquals(7, arrayOperationObject.largestMirrorSection(testArray7));
		
		int testArray8[]= {5,4,3,2,3,4,5};
		assertEquals(7, arrayOperationObject.largestMirrorSection(testArray8));
		
		int testArray9[]= {1,3,2,1};
		assertEquals(2, arrayOperationObject.largestMirrorSection(testArray9));
		
		int testArray10[]= {1,2,3,8,9,3,2,1};
		assertEquals(3, arrayOperationObject.largestMirrorSection(testArray10));
		
		int testArray11[]= {7,1,4,9,7,4,1};
		assertEquals(2, arrayOperationObject.largestMirrorSection(testArray11));
		
		int testArray12[]= {1,2,1,4};
		assertEquals(3, arrayOperationObject.largestMirrorSection(testArray12));
		
		int testArray13[]= {1,4,5,3,5,4,1};
		assertEquals(7, arrayOperationObject.largestMirrorSection(testArray13));
		

		assertNotEquals(70, arrayOperationObject.largestMirrorSection(testArray13)
		,"Largest mirror section should not be 70");
		
		int testArray14[]= {};
		assertNotEquals(10, arrayOperationObject.largestMirrorSection(testArray14)
		,"Empty error exception");
		
	}
	
	
	//second test function for testing number of clumps in an array function
	@Test
	public void testCaseForNoOfClumps() {
		int testArray1[]= {1, 2, 2, 3, 4, 4};
		assertEquals(2, arrayOperationObject.noOfClumps(testArray1));
		
		int testArray2[]= {1, 1, 2, 1, 1};
		assertEquals(2, arrayOperationObject.noOfClumps(testArray2));
		
		int testArray3[]= {1,1,1,1,1};
		assertEquals(1, arrayOperationObject.noOfClumps(testArray3));
		
		int testArray4[]= {1,1,2,2,2,3,4,4,4,4};
		assertEquals(3, arrayOperationObject.noOfClumps(testArray4));
		
		int testArray5[]= {1, 2, 2, 3, 4, 4};
		assertEquals(2, arrayOperationObject.noOfClumps(testArray5));
		
		int testArray6[]= {1, 2, 3, 4, 5};
		assertEquals(0, arrayOperationObject.noOfClumps(testArray6));
		
		int testArray7[]= {1};
		assertEquals(0, arrayOperationObject.noOfClumps(testArray7));
		
		assertNotEquals(5,arrayOperationObject.noOfClumps(testArray6),
		"No. of clumps should be 0");
	}
	
	//third test function for testing fixXY function
	@Test
	public void testCaseForFixXY(){
		
		int testArray1[]= {5, 4, 9, 4, 9, 5};
		int expectedArray1[]= {9,4,5,4,5,9};
		assertArrayEquals(expectedArray1, arrayOperationObject.fixXY(testArray1, 4, 5));
		
		int testArray2[]= {1, 4, 1, 5};
		int expectedArray2[]= {1,4,5,1};
		assertArrayEquals(expectedArray2, arrayOperationObject.fixXY(testArray2, 4, 5));
		
		int testArray3[]= {1, 4, 1, 5, 5, 4, 1};
		int expectedArray3[]= {1, 4, 5, 1, 1, 4, 5};
		assertArrayEquals(expectedArray3, arrayOperationObject.fixXY(testArray3, 4, 5));
		
		int testArray4[]= {3,7,2,7,2};
		int expectedArray4[]= {3,7,2,7,2};
		assertArrayEquals(expectedArray4, arrayOperationObject.fixXY(testArray4, 7, 2));
		
		int testArray6[]= {1,7,2,3,4,7,2};
		int expectedArray6[]= {1,7,2,3,4,7,2};
		assertArrayEquals(expectedArray6, arrayOperationObject.fixXY(testArray6, 7, 2));
		
		int testArray7[]= {7,2};
		int expectedArray7[]= {7,2};
		assertArrayEquals(expectedArray7, arrayOperationObject.fixXY(testArray7, 7, 2));
		
		int testArray8[]= {7,3,2,7,1,2,7,4,2};
		int expectedArray8[]= {7,2,3,7,2,1,7,2,4};
		assertArrayEquals(expectedArray8, arrayOperationObject.fixXY(testArray8, 7, 2));
		
		int testArray9[]= {-3,-7,-2,-7,-2};
		int expectedArray9[]= {-3,-7,-2,-7,-2};
		assertArrayEquals(expectedArray9, arrayOperationObject.fixXY(testArray9, -7, -2));
		
		
	}
	
	//fourth test function for testing split array function
	@Test
	public void testCaseForSplitArray() {
		int testArray1[]= {1, 1, 1, 2, 1};
		assertEquals(3, arrayOperationObject.splitIndex(testArray1));
		
		int testArray2[]= {2, 1, 1, 2, 1};
		assertEquals(-1, arrayOperationObject.splitIndex(testArray2));
		
		int testArray3[]= {10,10};
		assertEquals(1, arrayOperationObject.splitIndex(testArray3));
		
		int testArray4[]= {0,0,0,0,0};
		assertEquals(2, arrayOperationObject.splitIndex(testArray4));
		
		int testArray5[]= {5};
		assertEquals(-1, arrayOperationObject.splitIndex(testArray5));
		
		assertNotEquals(-1,arrayOperationObject.splitIndex(testArray3),
		"Index should be 1");
	}
	
}
