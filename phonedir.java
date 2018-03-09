
import java.util.*;

public class phonedir {
	public static void main(String [] args) {
		LinkedList <Directory> directoryList = new LinkedList<Directory>();
		String[] arr = new String[8];
		arr[0] = "a";
		arr[1] = "d";
		arr[2] = "f"; 
		arr[3] = "l";
		arr[4] = "n";
		arr[5] = "p";
	    arr[6] = "q";
	    arr[7] = "s";
		int currentDirectory = -1;
		Scanner input = new Scanner(System.in);
		String command = "";
	
		
		do {
			directoryCommands();
			
			System.out.println("Enter a command from the list above (q to quit): ");
			command = input.nextLine();
			
			if (command.equals("a")) {
				if (directoryList.size() == 0) {
					System.out.println("No Current Record");
					System.out.println();
				}
				else {
				printList(directoryList);
				}
			}
			
			else if (command.equals("d")) {
				if (currentDirectory < 0) {
					System.out.println("No Current Record");
					System.out.println();
				}
				else {
				System.out.println("Deleted: "+ directoryList.get(currentDirectory));
				directoryList.remove(currentDirectory);
				currentDirectory = noCurrentRecord(currentDirectory);
				}
			}
			
			else if (command.equals("f")) {
				if (currentDirectory < 0) {
					System.out.println("No Current Record");
					System.out.println();
				}
				else {
					System.out.println("Enter the new first name: ");
					String x = input.nextLine();
					directoryList.get(currentDirectory).setFirst(x);
					System.out.println("Current record is: " + directoryList.get(currentDirectory).toString());
				}
			}
			
			else if(command.equals("l")) {
				if (currentDirectory < 0) {
					System.out.println("No Current Record");
					System.out.println();
				}
				else {
					System.out.println("Enter the new last name: ");
					String y = input.nextLine();
					directoryList.get(currentDirectory).setLast(y);	
					System.out.println("Current record is: " + directoryList.get(currentDirectory).toString());
					directoryList.sort(null);
				}
			}
			
			else if (command.equals("n")) {
				System.out.println("Enter the first name: ");
				String first = input.nextLine();
				System.out.println("Enter the last name: ");
				String last = input.nextLine();
				System.out.println("Enter the phone number: ");
				String phone = input.nextLine();
				currentDirectory = addToList(directoryList, currentDirectory, new Directory(first,last,phone));
				System.out.println("Current record is: " + directoryList.get(currentDirectory).toString());
			}
			
			else if (command.equals("p")) {
				if (currentDirectory < 0) {
					System.out.println("No Current Record");
					System.out.println();
				}
				else {
					System.out.println("Enter the new phone number of the current directory: ");
					String z = input.nextLine();
					directoryList.get(currentDirectory).setNumber(z);
				}
			}
			
			else if (command.equals("s")) {
				printList(directoryList);
				System.out.println("Enter first name: ");
				String a = input.nextLine();
				System.out.println("Enter last name: ");
				String b = input.nextLine();
				for (int i = 0; i < directoryList.size(); i++) {
					if (directoryList.get(i).getFirst().equals(a) && directoryList.get(i).getLast().equals(b)) {
						currentDirectory = i;
						System.out.println("Current record is: " + directoryList.get(currentDirectory));
						break;
					}
					else if (isNotFound(directoryList, a, b)) {
						System.out.println("No matching record found");
						break;
					}
				}
				
			}
			
			else if (illegalCommand(arr,command)) {
				System.out.println("Illegal command");
				System.out.println();
			}
			
		} while (command.equals("q") == false);
		
		
	}
	
	
	public static int addToList(LinkedList<Directory> directoryList, int currentDirectory, Directory d) {
		int size = directoryList.size();
		if (size==0) {
			directoryList.addFirst(d);
			currentDirectory = directoryList.indexOf(d);
		}
		
		else {
		for (int i = 0; i< size; i++) {
			if (d.compareTo(directoryList.get(i)) < 0) {//b     // a b
				directoryList.add(i, d);
				currentDirectory = directoryList.indexOf(d);
				break ;
			}
			
			else if (d.compareTo(directoryList.get(i)) == 0) {
				directoryList.add(i, d);
				currentDirectory = directoryList.indexOf(d);
				break;
			}
			else if (i == size-1)  {
				directoryList.addLast(d);
				currentDirectory = directoryList.indexOf(d);
				break;
			}
				
			
		}
		
		
		}
		return currentDirectory;
	}
	
	//pre: no parameters
	//post: prints the directory commands for the user to input
	public static void directoryCommands() {
		System.out.println();
		System.out.println("a    Show all records");
		System.out.println("d    Delete the current record");
		System.out.println("f    Change the first name in the current record");
		System.out.println("l    Change the last name in the current record");
		System.out.println("n    Add a new record");
		System.out.println("p    Change the phone number in the current record");
		System.out.println("q    Quit");
		System.out.println("s    Select a record from the record list to become the current record");
		System.out.println();
	}
	
	//pre: first parameter must be of type string and type array, right parameter must be of one string character
	//post: determines whether the user input is illegal command or not.
	public static boolean illegalCommand(String[] arr, String command) {
		boolean isIllegal = false;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(command)) {
				count++;
			}
		}
		if (count == 0) {
			isIllegal = true;
		}
		else {
			isIllegal = false;
		}
		return isIllegal;
	}
	//pre: linked list must be of type Directory
	//post: prints the elements in the linked list
	public static void printList(LinkedList<Directory> directoryList) {
		System.out.println();
		System.out.println("First Name    Last Name    Phone Number");
		System.out.println("----------    --------      -----------");
		for(int index = 0; index< directoryList.size(); index++) {
			System.out.println(directoryList.get(index).toString());
		}
	}
	//pre: linked list must be of type Directory, both string parameters should be names that could be found in the linked list
	//post: determines whether the user input name is found in the linked list.
	public static boolean isNotFound(LinkedList<Directory> directoryList, String a, String b) {
		boolean isNotfound = false;
		int count = 0;
		for (int i = 0; i < directoryList.size(); i++) {
			if (directoryList.get(i).getFirst().equals(a) && directoryList.get(i).getLast().equals(b)) {
				count++;
			}
			
		}
		if (count == 0) {
			isNotfound = true;
		}
		else {
			isNotfound = false;
		}
		return isNotfound;
	}
	//pre: must be of type int parameter
	//post: sets currentDirectory equal to -1 when a record is deleted.
	public static int noCurrentRecord(int currentDirectory) {
		return currentDirectory = -1;
	}

}

	


