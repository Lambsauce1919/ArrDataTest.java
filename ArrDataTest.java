import java.util.*;
public class ArrDataTest {

	public static void main(String[] args) {
		
		ArrayList<String> myData = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		boolean removalCall = false;
		boolean additionCall = false;
		String userResponse;
		int numInp;
		int numberItems;
		
		
		// Prompt user for how many items in list.
		System.out.println("How many items would you like to add?");
			numberItems = inputMismatchInt(scan);
				scan.nextLine(); // Consume any leftovers (yummy)
		
		/* Gathers ArrayList build
		* Demonstrates understanding of ArrayList.sorting. 
		* If null is passed, items will be naturally sorted based upon their data type. 
		*/
		System.out.println("Enter your first item: ");
			for (int i = 0; i < numberItems; i++) {
				String dataInput = scan.next();
					myData.add(dataInput);
				if (numberItems > 0) {
					System.out.println("Enter your next item");}}
						System.out.println("\nHere is your current list unsorted: " + myData 
								+ "\n\nWould you like to sort it? Yes or No");
										userResponse = scan.next();
		
											if (userResponse.equalsIgnoreCase("Yes")) {
													myData.sort(null);
														System.out.println("Here is your list, sorted: " + myData); }
		
											
		
		// Demonstrates understanding of ArrayList.remove() functionality.
	System.out.println("\nWould you like to remove an item from your list?\nYes or No");
		userResponse = scan.next();
			if (userResponse.equalsIgnoreCase("yes")) {
				removalCall = true;
					System.out.println("\nWhich element would you like to remove?\nYou can remove items 0 through " + (myData.size() - 1) + ".");
					numInp = inputMismatchInt(scan);
					numInp = ensureBoundNotExceeded(numInp, (myData.size() - 1), removalCall, additionCall, scan);
							System.out.println("\nYou are removing item: " + myData.get(numInp));
								myData.remove(numInp);
									System.out.println("\nHere's your new list, sorted: \n" + myData);
									removalCall = false;
		}
		
		// Demonstrate a strong understanding of the .add class.
		
		System.out.println("\nWould you like to add a new element in a spot of your chosing?\nYes or No");
			userResponse = scan.next();
				if(userResponse.equalsIgnoreCase("Yes")) {
					additionCall = true;
					System.out.println("What element would you like to add?");
						userResponse = scan.next();
					System.out.println("\nWhere would you like to add the new element? You can add it in this range: 0 through " + (myData.size()) + "." );
						numInp = inputMismatchInt(scan);
						ensureBoundNotExceeded(numInp, (myData.size()), removalCall, additionCall, scan);
						myData.add(numInp, userResponse);
					System.out.println("Here is your new list: " + myData);
					additionCall = false;
				}
	}
	public static int inputMismatchInt(Scanner scan) {
	    boolean canPass = false;
	    int userInp = 0;
	    while (!canPass) {
	        try {
	            userInp = scan.nextInt();  
	            canPass = true;     // Good int, exit n returnin' dat int       
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input, you must enter an integer.");
	            scan.nextLine();   // Consumin' dat wrong stuff
	        }
	    }
	    return userInp;  // Return valid input
	}
	
	public static int ensureBoundNotExceeded(int userInput, int bounds, boolean removalCall, boolean additionCall, Scanner scan) {
	    boolean canSend = false;
	    while (!canSend) {
	        if (removalCall) {
	            if ((userInput >= 0) && (userInput <= bounds)) {
	                canSend = true;
	                System.out.println("\nSuccess! Continuing\n");
	            } else {
	                System.out.println("\nEnter a valid index to remove (0 to " + bounds + "): ");
	                userInput = inputMismatchInt(scan);
	            }
	        } else if (additionCall) {
	            // For addition, the valid range is 0 to bounds (inclusive, where bounds is myData.size())
	            if ((userInput >= 0) && (userInput <= bounds)) {
	                canSend = true;
	                System.out.println("\nSuccess! Continuing\n");
	            } else {
	                System.out.println("\nEnter a valid position to add (0 to " + bounds + "): ");
	                userInput = inputMismatchInt(scan);
	            }
	        } else {
	            System.out.println("Critical Error: Neither removal nor addition call specified.");
	            throw new IllegalStateException("Invalid state in ensureBoundNotExceeded.");
	        }
	    }
	    return userInput;
	}

}
	


