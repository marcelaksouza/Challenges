/*The problem
A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

Write a function:
class Solution { public int solution(int N); }
that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..2,147,483,647].
*/

package TimedTests;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class binarygap {
	//return the index of a string array
	public static int findIndex(String[] array, String value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}
	public static ArrayList<Integer> getGaps(String[] binaryArray, ArrayList<Integer> gaps){
		//find the first index
				int firstIndex = findIndex(binaryArray,"1");
				
				//if the index exist
				if(firstIndex > -1 ) {
					//copy the rest of the array
					String[] secondHalf = Arrays.copyOfRange(binaryArray, firstIndex+1, binaryArray.length);

					//find the second index
					int secondIndex = findIndex(secondHalf, "1");
					    
					    //check if index exist
						if (secondIndex > -1 ) {
						    //add the gap to the array list
							gaps.add(secondIndex);
							
							//if the length of the second half is bigger then 0
							if (Arrays.copyOfRange(secondHalf, secondIndex, secondHalf.length).length >0 ) {       // keep going
								return getGaps(Arrays.copyOfRange(secondHalf, secondIndex, secondHalf.length), gaps);
							}
						}
						gaps.add(0);
						//else return gaps
						return gaps;
				}
				return gaps;
	}
	
	public static int solution(int N) {
        //transform int into binary
        ArrayList<Integer> gaps = new ArrayList<Integer>();
        String binaryNumber = Integer.toBinaryString(N);
        
  		
        //add to an array
        String[] binaryArray = binaryNumber.split("");
        System.out.println(Arrays.toString(binaryArray));
        
        
        //check the range
        if (N > 1 && N < 2147483647){
            //get all gaps
            ArrayList<Integer> allGaps = getGaps(binaryArray, gaps );
            
            System.out.println(Arrays.toString(allGaps.toArray()));
           return Collections.max(allGaps);
		} 
        return 0;
    }
	
	
	public static void main(String[] args) {
		System.out.println(solution(15));
		System.out.println(solution(32));
		System.out.println(solution(258));
		System.out.println(solution(1041));
		
	}

}