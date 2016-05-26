# sum_of_popular

java exercise


Problem: 
	Given an array of integers, find the sum of the most common integer. 
	Example:  (1, 2, 3, 4, 5,1, 8) returns 2 (as 1+1 = 2) . 
	Response instructions: 

Provide 2 solutions, one implemented in Java and the other solution described in paragraph form.  
	One approach shall be optimised for runtime.  
	The other solution shall be optimised for space.  
	It is your choice as to which one is implemented and which one is described. 

For each solution, state: 
	- any assumptions (if any),  
	- the average runtime complexity  
	- space complexity (memory usage)  

Solution Details: 

The response should include 3 files:  
                  1. README.txt – shall explain the two approaches (including runtime and space/memory calculation). 
                  2. One source code file (.java) with the solution. The code should be documented and clearly written. The program should be executed from the command line and not have any GUI or take any user input. 
                  3. One source code file (.java) with the necessary unit tests covering the common usecases.     



To run program:
1. cd ${PROJ_DIR}/bin/main
2. java com.mac.service.NumberService arg0 arg1 ...

-------

Optimised for runtime (using HashMap)

	Solution: 
	Create a Hashmap to store unique numbers and it's the total count of occurence from the array of integers. Iterate through the array and store the current element to the map with count=1 if it does not exist or increment count if exists. Find out the number that has the highest occurence by iterating through the HashMaps keyset. To get the sum of the most common integer in the array, multiply the most common integer with the number of occurence and return.
	
	Assumptions:
	- Accepts negative values and returns a negative sum
	- Returns 0 if array is null or empty or all integers occurred once each
	- In case of multiple numbers being the most common, it will return the sum of the first integer.
	
	Runtime complexity:
	O(n) when iterating through the array to store values in to the map
	O(n) when iterating through the Map's keyset, where n is the number of unique numbers 
	
	Space/memory complexity:
	O(n) where n is the number of unique numbers, however, map stores objects so this will take a lot of memory compared to using arrays


-------

Optimised for space (using array w/ code solution)

	Solution: 
	Without using maps or lists and using only arrays to determine the most common integer. Sort the array in-place and iterate. If the current element is the same as the previous element increment counter by 1. If not, reset currentCount to 1.
	
	Assumptions:
	- Accepts negative values and returns a negative sum
	- Returns 0 if array is null or empty or all integers occurred once each
	- In case of multiple numbers being the most common, it will return the sum of the smallest integer.
	
	Runtime complexity:
	Array.sort uses quicksort has O(n log n) average and O(n^2) worst case performance
	O(n) when iterating through the array to determine the most common integer
	
	Space/memory complexity:
	O(n) in stack memory, no objects created
	
