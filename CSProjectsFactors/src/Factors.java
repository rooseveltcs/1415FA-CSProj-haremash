import java.util.ArrayList;
import java.util.Scanner;


public class Factors {

	public static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {
		getNumsOrQuit();
	}
	
	public static void getNumsOrQuit() {
		System.out.println("Input one number between 1 and 100 to get all of its factors.");
		System.out.println("Input multiple numbers to get the Greatest Common Denominator.");
		System.out.println("Input 'quit' to quit the program.");
		while(console.hasNextInt()) {
			ArrayList<Integer> input = numOrNums(console.nextLine());
			if(input.size() == 1) {
				getFactors(input.get(0));
			} else {
				getGDC(input);
			}
		}
		if(console.hasNext()) {
			if(console.next().equalsIgnoreCase("quit")) {
				System.out.println("Thanks for playing");
			} else {
				errorRestart();
			}
		}	
	}
	
	public static ArrayList<Integer> numOrNums(String toFind) {
		ArrayList<Integer> toReturn = new ArrayList<Integer>();
		String toSearch = toFind;
		if(toSearch.contains(" ")) {
			toSearch = toSearch + " ";
			while(toSearch.contains(" ")) {
				try {
					toReturn.add(Integer.parseInt(toSearch.substring(0, toSearch.indexOf(" "))));
					toSearch = toSearch.substring(toSearch.indexOf(" ") + 1);
				} catch(NumberFormatException e) {
					errorRestart();
				}
			}
		} else {
			try {
				toReturn.add(Integer.parseInt(toFind));
			} catch(NumberFormatException e) {
				errorRestart();
			}
		}
		return toReturn;
	}
		
	public static ArrayList<Integer> getFactors(int num) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		if(num <= 100 && num >= 1) {
			System.out.println("Finding factors of the number " + num + "...");
			for(int i = num; i > 0; i--) {
				if(num % i == 0) {
					values.add(i);
					System.out.print(i + " ");
				}
			}
			System.out.println();
		} else {
			errorRestart();
		}
		return values;
	}
	
	public static int getGDC(ArrayList<Integer> gdc) {
		int GDC = 1;
		if(withinRange(gdc)) {	
			System.out.println("Finding the Greatest Common Denominator of " + gdc.toString() + "...");
			for(int i = 1; i <= getSmallest(gdc); i++) {
				boolean isGDC = true;
				for(int num = 0; num < gdc.size(); num++) {
					if(gdc.get(num) % i != 0) {
						isGDC = false;
					}
				}
				if(isGDC) {
					GDC = i;
				}
			}
			System.out.println("Greatest Common Denominator is " + GDC);		
		} else {
			errorRestart();
		}
		return GDC;
	}
	
	public static int getSmallest(ArrayList<Integer> list) {
		int smallest = list.get(0);
		for(int i = 1; i < list.size(); i++) {
			if(list.get(i) < smallest) {
				smallest = list.get(i);
			}
		}
		return smallest;
	}
	
	public static boolean withinRange(ArrayList<Integer> toCheck) {
		boolean withinRange = true;
		for(int i = 0; i < toCheck.size(); i++) {
			if(toCheck.get(i) > 100 || toCheck.get(i) < 1) {
				withinRange = false;
			}
		}
		return withinRange;
	}
	
	public static void errorRestart() {
		System.out.println("ERROR input invalid, please try again");
		System.out.println();
		getNumsOrQuit();
	}
	
}