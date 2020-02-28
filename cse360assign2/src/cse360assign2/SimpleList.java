/*
 * Alec Allen
 * ID: 300
 * Assignment01
 * 
 * This program performs multiple actions centered around an array of 10 integers.
 * It has the capability to add an integer to the array, remove an integer from the
 * array, count the number of integers in the array, search for a certain integer and
 * return the index, and also return a string of each element separated by a space.
 */

public class SimpleList {
	
	int count = 0;
	int[] list = new int[10];
	
/*
* Function "add" inserts the given integer to the front of the array (index 0) and 
* if the array was full prior to insertion, pushes off the last element in the array
* Return value: none
* Parameter: "newAddition" is the new integer value to be added to the array
*/
	public void add(int newAddition) {
		
		for(int iterator = 9; iterator > 0; iterator--) {
			list [iterator] = list[iterator - 1];
		}
		
		list [0] = newAddition;
		
		if(count < 10)
			count++;
	}
/*
 * Function "remove" searches through the array looking for a match to the inputed integer to
 * delete. Once found, the array is moved to fill the empty space.
 * Return value: none
 * Parameter: "numToDelete" is the inputed integer to be searched for and deleted.
*/	
	public void remove(int numToDelete) {
		boolean removed = false;
		
		for(int iterator = 0; iterator < 10 && removed == false; iterator++) {
			
			if(list[iterator] == numToDelete) {
	
				list[iterator] = 0;
				removed = true;
				count--;
				
				for(int secondIterator = iterator; secondIterator < 9; secondIterator++) {
					
					list[secondIterator] = list[secondIterator + 1];
				}
			}
		}
	}
/*
 * Function "count" simply returns the number of elements currently in the array of integers	
 * Return value: number of elements in the list array.
 * Parameter: none
 */
	public int count() {
		
		return count;
	}
/*
 * Function "search" takes in an integer to find inside the array. If the integer is found,
 * the index of the found number is returned. If no integer match is found, -1 is returned.
 * Return value: match index, or -1 if not found
 * Parameter: "numToFind" is the integer to be searched for in the array. 
 */
	public int search(int numToFind) {
		
		for(int iterator = 0; iterator < count - 1; iterator++) {
		
			if(list[iterator] == numToFind) {
				
				return iterator;
			}
		}
		return -1;
	}
/*
 * Function toString returns all elements in the array as a string seperated by a space.
 * Return value: String of all elements in the array
 * Parameter: none
 */
	public String toString() {
		
		String arrayList = "";
		
		for(int iterator = count - 1; iterator >= 0; iterator--) {
			arrayList += list[iterator] + " ";
		}
		
		return arrayList;
	}
}