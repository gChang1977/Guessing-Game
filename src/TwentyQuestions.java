/*
	Provided code by Dan Shervheim
	UMN 1103 TA Fall 2018

	Additions made by student: <YOURX500HERE>
	main(String[] args)
	playLoop(Animal[] animals, Animal answer)
	<ADD ANY OTHER METHODS YOU WRITE HERE>
*/
//Changed by Chan1977(Geng Chang)
import java.io.File;
import java.util.*;
import java.util.Scanner;
import java.util.Random;

public class TwentyQuestions
{
	public static void main(String[] args)
	{

		/*
			Please familiarize yourself with the methods
			available to you from Java's File class.
			https://docs.oracle.com/javase/7/docs/api/java/io/File.html

			Some of them you may find useful are:

			the constructor:
			File fileVar = new File("filepath");

			fileVar.listFiles();
			returns an array of File objects within the folder
			represented by "fileVar".
		*/
		// String path = ("C:\Users\titer_2zejaq3\OneDrive\Desktop\P4 Start Code\Project4StarterCode_v4\Project4\animals")
		File animalFolder = new File("../animals");
		File[] animalTxtFiles = animalFolder.listFiles();

		Animal[] animalList = new Animal[animalTxtFiles.length];

		for(int i = 0; i < animalList.length; i++){
			animalList[i] = new Animal(animalTxtFiles[i]);
		}

		System.out.println("Hello! This is 20 questions, exclusive to animals");
		System.out.println("This is how the game works!");
		System.out.println("First I will think of an animal.");
		System.out.println("Secondly you can ask up to 20 questions.");
		System.out.println("Third you can only ask yes/no questions.");

		Random r = new Random();
		int randomIndex = r.nextInt(animalList.length);

	 	Animal answer = animalList[randomIndex];
		playLoop(animalList, answer);
    }

    private static void playLoop(Animal[] animalList, Animal answer)
    {

			int questionsLeft = 20;

		Scanner input = new Scanner(System.in);
		while(questionsLeft > 0){
			System.out.println("You have "+questionsLeft+" questions left!");
			System.out.println("1) Ask a relational question");
			System.out.println("2) Ask an existential question");
			System.out.println("3) Make a guess");
			System.out.println("4) Lookup an animal in the database");
			System.out.println("5) Quit");
			System.out.println("Enter a number from 1 through 5");
			int num = input.nextInt();
			while(num < 1 || num > 5){
				System.out.println("Enter a number from 1 through 5");
				num = input.nextInt();
			}
			if(num == 1){
			RelationalQuestion rq = new RelationalQuestion(animalList, answer);
			if(rq.AskQuestion()){
				questionsLeft--;
			}
			}
			else if(num == 2){
			ExistentialQuestion eq = new ExistentialQuestion(animalList, answer);
			if(eq.AskQuestion()){
				questionsLeft--;
			}
			}
			else if(num == 3){
				Scanner in = new Scanner(System.in);
				System.out.println("Please Enter your guess!");
				String usersGuess = in.nextLine();
				if(answer.getName().equals(usersGuess)){
					System.out.println("Yes, that is exactly what I was thinking of!");
					return;
				}
				else{
					System.out.println("That is Wrong!!");
					questionsLeft--;
				}
			}
			else if(num == 4){
				Scanner in = new Scanner(System.in);
				int count = 0;
				System.out.println("Enter the name of an animal!");
				String animalName = in.nextLine();
				for(int i = 0; i < animalList.length; i++){
					if(animalList[i].getName().equals(animalName)){
						count++;
					}
				}
				if(count >= 1){
					System.out.println(animalName+" is in the database.");
				}
				else{
					System.out.println(animalName+" is not in the database.");
				}
			}
			else if(num == 5){
				System.out.println("Goodbye!");
				return;
			}
		}

		Scanner in = new Scanner(System.in);
		System.out.println("Make your last guess!");
		String finalGuess = in.nextLine();
		if(answer.getName().equals(finalGuess)){
			System.out.println("Yes, that is exactly what I was thinking of! Congrats!");
			return;
		}
		else {
			System.out.println("unfortunately that was wrong! Bzzzz You lost!");
			return;
		}
    }
}
