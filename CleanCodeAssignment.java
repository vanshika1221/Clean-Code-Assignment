import java.util.*;
import java.io.*;
class CleanCodeAssignment {
      //Function for finding index of elements according to their position in sorted order
	  static int[] reducedArray(int[] inputElements,int arraySize)
	  {
		int[] outputResult = new int[arraySize];
		int currentPosition = 0;
		for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) 
		{
			int minimumElement = Integer.MAX_VALUE;
			int index = -1;
			// Find the minimum element and keep its position of occurrence
			for (int position = 0; position < arraySize; position++) 
			{
				if (minimumElement > inputElements[position]) {
					minimumElement = inputElements[position];
					index = position;
				}
			}
			// Update the result at minimum index element with new Position
			outputResult[index] = currentPosition;
			
			// Increment the new position
			currentPosition++;
			
			// Update the original element at current minimum element with maximum value possible, so that it won't be minimum in further iteration
			inputElements[index] = Integer.MAX_VALUE;
		}

		return outputResult;
	}
	static void printArray(int[] resultantArrayOfIndexes,int arraySize)
	{
		for (int printIndex=0;printIndex<arraySize;printIndex++) 
		{
			System.out.print(resultantArrayOfIndexes[printIndex] + " ");
		}
	}
}
//Main Class
class Main
{
	public static void main(String[] args)
	{
	Scanner sc=new Scanner(System.in);
        int arraySize;
        System.out.println("Enter Size of Array: ");
        arraySize=sc.nextInt();
        int inputElements[]=new int[arraySize];  
    
        // Taking Input from the user
        System.out.println("Enter Elements: ");
        for(int arrayIndex=0;arrayIndex<arraySize;arrayIndex++)
        {
            inputElements[arrayIndex]=sc.nextInt();
        }
    
        //Creating Object for the CleanCodeAssignment Class and calling the functions of that class
        CleanCodeAssignment obj = new CleanCodeAssignment();
        int[] resultantArrayOfIndexes = obj.reducedArray(inputElements,arraySize);
        System.out.println("\nOutput is: ");
	obj.printArray(resultantArrayOfIndexes,arraySize);
	}
}

