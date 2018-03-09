1. Purpose: To gain experience with Linked List and to be able to use the Java Library

2. Solution & Algorithm: The way I developed this program is quite straightforward. I incorporated the entire code inside a do while loop so that
						the program can re-run after a command has been entered. I made several static methods inside the phonedir class such as 
						NoCurrentRecord, directoryCommands, illegalCommands, and addToList that respond to the conditions of the command requirement
						I made a linked list of type Directory which contains the first name, last, name, and phone number of each person. The respective
						methods inside the Directory class are used appropriately in order to add, sort, delete, and change the field values. 
						
3. Data Structure: LinkedLists

4. Description of I/O: To use the program, follow the set commands listed in the output. Type in one of these commands to perform a specified function.
					  Once you enter a command and fill in all the necessary information asked, the command list will pop up again for you to enter the 
					  next command. To exit the program, enter 'q' and the program will terminate. 

5. Purpose of each Class: the phonedir class serves as a driver class that runs the program. The class itself has a variety of static methods which are called
						 onto the main method. The class creates any necessary objects, incorporates the algorithm for the program, and specifies the 
					     data structures used. The Directory class is the class thats used in the linked list. It consists of 3 string field values:
						 first name, last name, and phone number. The class has all the accessor and mutator methods including some other functions 
					     that are needed to make the program run accordingly.
