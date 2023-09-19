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

public class ExistentialQuestion extends Question
{
	ExistentialQuestion(Animal[] animals, Animal answer)
	{
		super(animals, answer);
	}

	public boolean AskQuestion()
	{
		// offer choices to player
		System.out.println("What do you want to know?");
		System.out.println("\t1. Does it have <x>?");
		System.out.println("\t2. Can it <x>?");
		System.out.println("\t3. Is it <x>?");
		System.out.println("\t4. Does it eat <x>?");
		System.out.println("\t5. Go back");

		/*
			Setup a new scanner to read input from the player

			If they typed in 5, then return false (this question should
			not count against the players 20).

			otherwise, prompt the user to enter an input for x and
			call the appropriate functions of the "answer" variable,
			passing in x.

			Print the result to the terminal, and return true.

			Hint: if the user typed in 3, then you will probably need to call
			answer.isX(something here);
		*/
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number from 1 to 5");
		int num = input.nextInt();
		while(num < 1 || num > 5){
			System.out.println("Enter a number from 1 to 5");
			num = input.nextInt();
		}
		if(num == 5){
			System.out.println("Thank You!");
			return false;
		}
		else if(num == 4){
			Scanner in = new Scanner(System.in);
			System.out.println("What do you think it eats?");
			String x = in.nextLine();
			if(answer.eatsX(x)){
				System.out.println("The animal eats "+x);
				return true;
			}
			else if(!(answer.eatsX(x))){
				System.out.println("The animal does not eat "+x);
				return true;
			}
		}
		else if(num == 3){
			Scanner in = new Scanner(System.in);
			System.out.println("Is the animal ____? Finish the question");
			String x = in.nextLine();
			if(answer.isX(x)){
				System.out.println("The animal is "+x);
				return true;
			}
			else if(!(answer.isX(x))){
				System.out.println("The animal is not "+x);
				return true;
			}
		}
		else if(num == 2){
			Scanner in = new Scanner(System.in);
			System.out.println("What do you think it can do?");
			String x = in.nextLine();
			if(answer.canX(x)){
				System.out.println("The animal can "+x);
				return true;
			}
			else if(!(answer.canX(x))){
				System.out.println("The animal can not "+x);
				return true;
			}
		}
		else if(num == 1){
			Scanner in = new Scanner(System.in);
			System.out.println("What do you think it have?");
			String x = in.nextLine();
			if(answer.hasX(x)){
				System.out.println("The animal have "+x);
				return true;
			}
			else if(!(answer.hasX(x))){
				System.out.println("The animal does not have "+x);
				return true;
			}
		}
		return false;
	}
}
