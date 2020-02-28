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
* if the array was full prior to insertion, list size is increased by 50%
* Return value: none
* Parameter: "newAddition" is the new integer value to be added to the array
*/
	public void add(int newAddition) {
		
		//if list is full, creates new list with 50% more space.
		if(count == list.length) {
			
			int[] tempList = new int[list.length + (list.length / 2)];
			
			for(int i = 0; i < list.length; i++) {
				tempList[i] = list[i];
			}
			
			list = new int[tempList.length];
			for(int i = 0; i < count; i++) {
				list[i] = tempList[i];
			}
		
		}
		
		for(int iterator = count - 1; iterator > 0; iterator--) {
			list [iterator] = list[iterator - 1];
		}
		
		list [0] = newAddition;
		count++;
	}
/*
 * Function "remove" searches through the array looking for a match to the inputed integer to
 * delete. Once found, the array is moved to fill the empty space. If the list has more than 25%
 * empty space, those empty spaces are removed
 * Return value: none
 * Parameter: "numToDelete" is the inputed integer to be searched for and deleted.
*/	
	public void remove(int numToDelete) {
		boolean removed = false;
		
		for(int iterator = 0; iterator < count && removed == false; iterator++) {
			
			if(list[iterator] == numToDelete) {
	
				list[iterator] = 0;
				removed = true;
				count--;
				
				for(int secondIterator = iterator; secondIterator < count - 1; secondIterator++) {
					
					list[secondIterator] = list[secondIterator + 1];
				}
			}
		}
		
		//if list has more than 25% empty spaces, delete 25% of list
		if(count <= (int)(.75 * list.length) && list.length >= 1) {
			
			int[] tempList = new int[(int)(list.length * .75)];
			
			for(int i = 0; i < list.length; i++) {
				tempList[i] = list[i];
			}
			
			list = new int[tempList.length];
			for(int i = 0; i < count; i++) {
				list[i] = tempList[i];
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
 * Function "append" takes in an integer to add the the end of the list. If the list is full then the 
 * list is expanded 50%.
 * Parameter: "newAddition" is the integer to be added to the end of the list.
 */
	public void append(int newAddition) {
		
		//if list is full, expand the list by 50%
		if(count == list.length) {
			
			int[] tempList = new int[list.length + (list.length / 2)];
			for(int i = 0; i < list.length; i++) {
				tempList[i] = list[i];
			}
			
			list = tempList;
		}
		
		list[count + 1] = newAddition;
	}
	
/*
 * Function "first" returns the first integer in the list. If the list is empty, returns -1
 * Parameter: none	
 */
	public int first() {
		
		if(count == 0) {
			
			return -1;
			
		}else {
			
			return list[0];
		}
	}

/*
 * Function "last" returns the last integer in the list. If the list is empty, returns -1
 * Parameter: none	
 */	
	public int last() {
		
		if(count == 0) {
			
			return -1;
			
		} else {
			
			return list[count - 1];
		}
	}
	
/*
 * Function "size" returns the current size of the list
 * Parameter: none
 */
	public int size() {
		
		return count;
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