package pack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrOperation {
	
	//scanner obj. for taking inputs
	static Scanner scannerObject=new Scanner(System.in);
	
	//isValid will control the loop
	static boolean isValid=true;	
	
	//global array
	static int array[];
	
	//global variable size of array
	static int sizeOfArray;

	//creating class obj. for calling non-static methods from static methods
	static ArrOperation arrOperationObject=new ArrOperation();
	
	public static void main(String[] args) {
		
		
		while(isValid) {
			try {
				System.out.println("Select which operation to perform\n"
				+"1.Size of the largest mirror section\n"
				+"2.No. of clumps in the array\n"
				+"3.Solve fixXY problem\n"
				+"4.Split array\n"+"5.Exit");
				
				int input=scannerObject.nextInt();
				
				switch(input){
				
				//case 1 wil print size of the largest mirror section in an array
					case 1:
						sizeOfArray=arraySize();
						if(sizeOfArray==0)throw new AssertionError("Empty array");
						array=inputArray(sizeOfArray);
						int largestMirrorSectionSize=arrOperationObject.largestMirrorSection(array);
						System.out.println("Size of largest mirror section is "+largestMirrorSectionSize);
						break;
						
				//case 2 wil print no. of clumps  in an array		
					case 2:
						sizeOfArray=arraySize();
						if(sizeOfArray==0)throw new AssertionError("Empty array");
						array=inputArray(sizeOfArray);
						int countClumps=arrOperationObject.noOfClumps(array);
						System.out.println("No. of clumps in the input array is "+countClumps);
						break;
						
			   //case 3 will rearrange array elements and solve x, y problem
					case 3:
						sizeOfArray=arraySize();
						if(sizeOfArray==0)throw new AssertionError("Empty array");
						array=inputArray(sizeOfArray);
						System.out.println("Enter value of x");
						int x=scannerObject.nextInt();
						System.out.println("Enter value of y");
						int y=scannerObject.nextInt();
						int fixedArray[]=arrOperationObject.fixXY(array, x, y);
						System.out.println("Resultant array is ");
						for(int fixedArrayIndex=0;fixedArrayIndex<fixedArray.length;fixedArrayIndex++) {
							System.out.print(fixedArray[fixedArrayIndex]+" ");
						}
						System.out.println();
						break;
				
				//case 4 wil return index of array where leftsum=rightsum
					case 4:
						sizeOfArray=arraySize();
						if(sizeOfArray==0)throw new AssertionError("Empty array");
						array=inputArray(sizeOfArray);
						int indexOfSplit=arrOperationObject.splitIndex(array);
						System.out.println("Index of splitted array is "+indexOfSplit);
					    break;
					    
			    //case 5 for terminating the program
					case 5:
						System.out.println("Program ended successfully");
						isValid=false;
						break;
						
				//default test case for handling int edge cases
					default:
						System.out.println("Please select valid option");
				}
			}
			catch(Exception e) {
				System.out.println("Please enter valid input");
				scannerObject.nextLine();
			}			
		}		
	}
	

/**
 * will take array size from user
 * @return the size of the input array
 */	
static int arraySize() {
	System.out.println("Enter size of input array");
	int sizeOfArray=scannerObject.nextInt();
	return sizeOfArray;
}


/**
 * will take array input from user
 * @param size of the input array
 * @return the array of given size
 */
static	int [] inputArray(int size) {
	System.out.println("Enter elements in array");
	int array[]=new int[size];
	for(int arrayIndex=0;arrayIndex<size;arrayIndex++) {
		array[arrayIndex]=scannerObject.nextInt();
	}
	return array;
}
	

/**
 * will display no. of clumps in an array
 * @param inputArray provided from which no. of clumps to evaluate
 * @return no. of clumps in the given array
 */
 int noOfClumps(int inputArray[]) {
	int tempClump=0;
	int clump=0;
	for(int arrayIndex=0;arrayIndex<inputArray.length-1;arrayIndex++) {
		if(inputArray[arrayIndex]==inputArray[arrayIndex+1]) {
			tempClump=tempClump+2;
//			arrayIndex++;
		}
		else {
			if(tempClump>=2)clump++;
			tempClump=0;
		}
	}
	if(tempClump>=2)clump++;
	return clump;
}

 /**
  * will alter positions of y with other numbers
  * @param inputArray provided by the user
  * @param x variable whose position is fixed
  * @param y variable whose position can be altered
  * @return modified array
  */
int[] fixXY(int inputArray[] ,int x, int y) {
	List<Integer> indexOfX=new ArrayList<>();
	int countX=0,countY=0;
	for(int inputArrayIndex=0;inputArrayIndex<inputArray.length;inputArrayIndex++) {
		if(inputArray[inputArrayIndex]==x)countX++;
		else if(inputArray[inputArrayIndex]==y)countY++;
	}
	if(countX!=countY)throw new AssertionError("Unequal no. of x and y");
	
	for(int inputArrayIndex=0;inputArrayIndex<inputArray.length-1;inputArrayIndex++) {
		if(inputArray[inputArrayIndex]==x && inputArray[inputArrayIndex+1]==x) {
			throw new AssertionError("X cannot be adjacent");
		}
	}
	
	if(inputArray[inputArray.length-1]==x) {
		throw new AssertionError("X cannot be at the end of the array");
	}
	
	for(int arrayIndex=0;arrayIndex<inputArray.length;arrayIndex++) {
	  if(inputArray[arrayIndex]==x)indexOfX.add(arrayIndex);
	}
	int index=0;
	for(int arrayIndex=0;arrayIndex<inputArray.length;arrayIndex++) {
		if(inputArray[arrayIndex]==y) {
			int swapIndex=indexOfX.get(index)+1;
			int temp=inputArray[swapIndex];
			inputArray[swapIndex]=y;
			inputArray[arrayIndex]=temp;
			index++;
			if(arrayIndex<(swapIndex+1))arrayIndex=swapIndex+1;
		}
	}
	return inputArray;
}


/**
 * will split array at index where leftsum=rightsum 
    and return it else return -1
 * @param inputArray provided be the user
 * @return the index at which leftsum=rightsum or -1
 */
int splitIndex(int inputArray[]) {
	int leftIndex=0,rightIndex=inputArray.length-1;
	int leftsum=inputArray[0],rightsum=inputArray[inputArray.length-1];
	while(leftIndex<=rightIndex) {		
		if(leftsum==rightsum && leftIndex+1==rightIndex)return rightIndex;

		
		if(leftsum<rightsum) {
			
			leftIndex++;
			leftsum+=inputArray[leftIndex];
		}
		else if(rightsum<leftsum) {
			
			rightIndex--;
			rightsum+=inputArray[rightIndex];
		}
		else {
			
			leftIndex++;
			rightIndex--;
			leftsum+=inputArray[leftIndex];
			rightsum+=inputArray[rightIndex];
		}
		
	}
	return -1;
}


/**
 * will find max no. of mirror section in an array
 * @param maxMirror input array provided by the user
 * @return largest mirror section as integer
 */
int largestMirrorSection(int maxMirror[]) {
//	if(maxMirror.length==1)return 1;
	int largestMirror=1;
	for(int maxMirrorIndex=0;maxMirrorIndex<maxMirror.length;maxMirrorIndex++) {
		int firstLoopStartIndex=maxMirrorIndex;
		int firstLoopEndIndex=maxMirror.length-1;
		int noOfMirror=0;
		int reversedMaxMirrorIndex=maxMirror.length-1;
		
		while(firstLoopStartIndex<maxMirror.length
				&& firstLoopEndIndex>=0 ) {
			if(maxMirror[firstLoopStartIndex]==maxMirror[firstLoopEndIndex]) {
				if( firstLoopEndIndex==firstLoopStartIndex && noOfMirror>0)
					noOfMirror++;
				else if(firstLoopEndIndex==firstLoopStartIndex && noOfMirror<=0) {}
				else noOfMirror++;
				firstLoopStartIndex++;
				firstLoopEndIndex--;
			}
			
			else {
				largestMirror=Math.max(noOfMirror, largestMirror);
				firstLoopEndIndex--;
				noOfMirror=0;
			}
		}
		largestMirror=Math.max(noOfMirror, largestMirror);
		int secondLoopStartIndex=0;
		int secondLoopEndIndex=maxMirror.length-1;
		noOfMirror=0;
		while(secondLoopStartIndex<maxMirror.length-1 ) {
			if(maxMirror[secondLoopStartIndex]==maxMirror[secondLoopEndIndex]) {
				if(secondLoopEndIndex==secondLoopStartIndex && noOfMirror>0)
				noOfMirror++;
				else if(secondLoopEndIndex==secondLoopStartIndex && noOfMirror<=0) {}
				else noOfMirror++;
				secondLoopStartIndex++;
				secondLoopEndIndex--;
			}
			else {
				largestMirror=Math.max(noOfMirror, largestMirror);
				secondLoopStartIndex++;
				noOfMirror=0;
			}
		}
		largestMirror=Math.max(noOfMirror, largestMirror);		
	}
	return largestMirror;
}
}
