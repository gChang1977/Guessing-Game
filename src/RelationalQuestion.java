/*
	Provided code by Dan Shervheim
	UMN 1103 TA Fall 2018

	Additions made by student: <YOURX500HERE>
	AskQuestion()
	<ADD ANY OTHER METHODS YOU WRITE HERE>
*/
//Changed by Chan1977(Geng Chang)
import java.util.*;
import java.util.Scanner;

public class RelationalQuestion extends Question
{
	RelationalQuestion(Animal[] animals, Animal answer)
	{
		super(animals, answer);
	}

	public boolean AskQuestion()
	{
		// offer the player choices
		System.out.println("What do you want to know?");
		System.out.println("\t1. Is it heavier than another animal?");
		System.out.println("\t2. Is it taller than another animal?");
		System.out.println("\t3. Is it longer than another animal?");
		System.out.println("\t4. Is it faster than another animal?");
		System.out.println("\t5. Is it heavier than <x> lbs");
		System.out.println("\t6. Is it taller than <x> feet");
		System.out.println("\t7. Is it longer than <x> feet");
		System.out.println("\t8. Is it faster than <x> mph?");
		System.out.println("\t9. Go back");

		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number from 1 to 9");
		int num = input.nextInt();
		while(num < 1 || num > 9){
			System.out.println("Enter a number from 1 to 9");
			num = input.nextInt();
		}
		if(num == 9){
			return false;
		}
		else if(num == 8){
			System.out.println("What is the speed you want to know?");
			double x = input.nextDouble();
			while (x < 0){
				System.out.println("Please enter a positive number");
				x = input.nextDouble();
			}
			if(x < answer.getSpeed() && x >= 0){
				System.out.println("The animal is faster than "+x+" mph");
				return true;
			}
			else if(x > answer.getSpeed()){
				System.out.println("The animal is slower than "+x+" mph");
				return true;
			}
			else if(x == answer.getSpeed()){
				System.out.println("The animal is the same speed as "+x+" mph");
				return true;
			}
		}
		else if(num == 7){
			System.out.println("What is the Length you want to know?");
			double x = input.nextDouble();
			while (x < 0){
				System.out.println("Please enter a positive number");
				x = input.nextDouble();
			}
			if(x < answer.getLength() && x >= 0){
				System.out.println("The animal is longer than "+x+" feet");
				return true;
			}
			else if(x > answer.getLength()){
				System.out.println("The animal is smaller "+x+" feet");
				return true;
			}
			else if(x == answer.getLength()){
				System.out.println("The animal is the same size as "+x+" feet");
				return true;
			}
		}
		else if(num == 6){
			System.out.println("What is the Height you want to know?");
			double x = input.nextDouble();
			while (x < 0){
				System.out.println("Please enter a positive number");
				x = input.nextDouble();
			}
			if(x < answer.getSpeed() && x >= 0){
				System.out.println("The animal is taller than "+x+" feet");
				return true;
			}
			else if(x > answer.getSpeed()){
				System.out.println("The animal is shorter than "+x+" feet");
				return true;
			}
			else if(x == answer.getSpeed()){
				System.out.println("The animal is the same hight as "+x+" feet");
				return true;
			}
		}
		else if(num == 5){
			System.out.println("What is the Weight you want to know?");
			double x = input.nextDouble();
			while (x < 0){
				System.out.println("Please enter a positive number");
				x = input.nextInt();
			}
			if(x < answer.getWeight() && x >= 0){
				System.out.println("The animal is heavier than "+x+" pounds");
				return true;
			}
			else if(x > answer.getWeight()){
				System.out.println("The animal is lighter than "+x+" pounds");
				return true;
			}
			else if(x == answer.getWeight()){
				System.out.println("The animal is the same weight as "+x+" pounds");
				return true;
			}
		}
		while(num == 4){
			Scanner in = new Scanner(System.in);
			System.out.println("What animal would you like to compare speed with?");
			String compAnimal = in.nextLine();
			if(getIndexByName(compAnimal) < 0){
				System.out.println(compAnimal+"Does not exist in the data.");
				System.out.println("Input 1 to go back to questions");
				System.out.println("Input 2 to try agian with a different name");
				int retryNum = input.nextInt();
				while(retryNum > 2 || retryNum < 1){
					System.out.println("Plug in 1 or 2!");
					retryNum = input.nextInt();
				}
				if(retryNum == 1){
					return false;
				}
				else if(retryNum == 2){
					num = 4;
				}
			}
			if((getIndexByName(compAnimal)) >= 0){
				if(answer.getSpeed() < animals[getIndexByName(compAnimal)].getSpeed()){
					System.out.println("The animal is slower than "+compAnimal);
					return true;
				}
				else if(answer.getSpeed() > animals[getIndexByName(compAnimal)].getSpeed()){
					System.out.println("The animal is faster than "+compAnimal);
				return true;
				}
				else if(answer.getSpeed() == animals[getIndexByName(compAnimal)].getSpeed()){
					System.out.println("The animal is the same speed as "+compAnimal);
				return true;
				}
			}
		}
		while(num == 3){
			Scanner in = new Scanner(System.in);
			System.out.println("What animal would you like to compare length with?");
			String compAnimal = in.nextLine();
			if(getIndexByName(compAnimal) < 0){
				System.out.println(compAnimal+"Does not exist in the data.");
				System.out.println("Input 1 to go back to questions");
				System.out.println("Input 2 to try agian with a different name");
				int retryNum = input.nextInt();
				while(retryNum > 2 || retryNum < 1){
					System.out.println("Plug in 1 or 2!");
					retryNum = input.nextInt();
				}
				if(retryNum == 1){
					return false;
				}
				else if(retryNum == 2){
					num = 3;
				}
			}
			if((getIndexByName(compAnimal)) >= 0){
				if(answer.getLength() < animals[getIndexByName(compAnimal)].getLength()){
					System.out.println("The animal is shorter than "+compAnimal);
					return true;
				}
				else if(answer.getLength() > animals[getIndexByName(compAnimal)].getLength()){
					System.out.println("The animal is longer than "+compAnimal);
				return true;
				}
				else if(answer.getLength() == animals[getIndexByName(compAnimal)].getLength()){
					System.out.println("The animal is the same length as "+compAnimal);
				return true;
				}
			}
		}
		while(num == 2){
			Scanner in = new Scanner(System.in);
			System.out.println("What animal would you like to compare height with?");
			String compAnimal = in.nextLine();
			if(getIndexByName(compAnimal) < 0){
				System.out.println(compAnimal+"Does not exist in the data.");
				System.out.println("Input 1 to go back to questions");
				System.out.println("Input 2 to try agian with a different name");
				int retryNum = input.nextInt();
				while(retryNum > 2 || retryNum < 1){
					System.out.println("Plug in 1 or 2!");
					retryNum = input.nextInt();
				}
				if(retryNum == 1){
					return false;
				}
				else if(retryNum == 2){
					num = 2;
				}
			}
			if((getIndexByName(compAnimal)) >= 0){
				if(answer.getHeight() < animals[getIndexByName(compAnimal)].getHeight()){
					System.out.println("The animal is shorter than "+compAnimal);
					return true;
				}
				else if(answer.getHeight() > animals[getIndexByName(compAnimal)].getHeight()){
					System.out.println("The animal is taller than "+compAnimal);
				return true;
				}
				else if(answer.getHeight() == animals[getIndexByName(compAnimal)].getHeight()){
					System.out.println("The animal is the same height as "+compAnimal);
				return true;
				}
			}
		}
		while(num == 1){
			Scanner in = new Scanner(System.in);
			System.out.println("What animal would you like to compare weight with?");
			String compAnimal = in.nextLine();
			if(getIndexByName(compAnimal) < 0){
				System.out.println(compAnimal+"Does not exist in the data.");
				System.out.println("Input 1 to go back to questions");
				System.out.println("Input 2 to try agian with a different name");
				int retryNum = input.nextInt();
				while(retryNum > 2 || retryNum < 1){
					System.out.println("Plug in 1 or 2!");
					retryNum = input.nextInt();
				}
				if(retryNum == 1){
					return false;
				}
				else if(retryNum == 2){
					num = 1;
				}
			}
			if((getIndexByName(compAnimal)) >= 0){
				if(answer.getWeight() < animals[getIndexByName(compAnimal)].getWeight()){
					System.out.println("The animal is lighter than "+compAnimal);
					return true;
				}
				else if(answer.getWeight() > animals[getIndexByName(compAnimal)].getWeight()){
					System.out.println("The animal is heavier than "+compAnimal);
				return true;
				}
				else if(answer.getWeight() == animals[getIndexByName(compAnimal)].getWeight()){
					System.out.println("The animal is the same weight as "+compAnimal);
				return true;
				}
			}
		}
		return false;
	}
}
