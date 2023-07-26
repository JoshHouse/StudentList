package StudentList;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StudentApplication {
	public static void main(String args[]) 
	{
		int choice, studentCount = 0, strLength, commaIndex;
		Student[] StudentArray = new Student[100];
		String input;
		Scanner fileInput;
		File inFile = new File("assg4_input.txt");
		try
		{
			fileInput = new Scanner(inFile);

			while(fileInput.hasNextLine())
			{
				char gender;
				String id, name, dOb, major;
				

				input = fileInput.nextLine();
				
				strLength = input.length();
				commaIndex = input.indexOf(",");
				id = input.substring(0, commaIndex);
				input = input.substring(commaIndex+1, strLength);
				
				strLength = input.length();
				commaIndex = input.indexOf(",");
				name = input.substring(0, commaIndex);
				input = input.substring(commaIndex+1, strLength);
				
				strLength = input.length();
				commaIndex = input.indexOf(",");
				gender = input.charAt(0);
				input = input.substring(commaIndex+1, strLength);
				
				strLength = input.length();
				commaIndex = input.indexOf(",");
				if (commaIndex > 0)
				{
					dOb = input.substring(0, commaIndex);
					major = input.substring(commaIndex+1, strLength);
				
					StudentArray[studentCount] = new Student(id, name, gender, dOb, major);
					
				}
				else 
				{
					
					dOb = input.substring(0, strLength);
					
					StudentArray[studentCount] = new Student(id, name, gender, dOb);
				}
				studentCount++;


			}
			fileInput.close();
		}
		/**
		 * Catch statement to catch IOException
		 */
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		
		
		
		Scanner keyboard = new Scanner(System.in);
		while (true)
		{
			System.out.println("1. Search student by id");
			System.out.println("2. Search student by name");
			System.out.println("3. Change student major");
			System.out.println("4. Exit");
			choice = keyboard.nextInt();
			
			if(choice == 1)
			{
				String enteredId;
				
				try
				{
					System.out.println("Enter the students id: ");
					enteredId = keyboard.next();
					int index = Student.StudentSearchById(StudentArray, studentCount, enteredId);
					System.out.println(StudentArray[index]);					
				}
				catch(StudentNotFoundException x)
				{
					System.out.println("Error: " + x.getMessage());
				}
			}
			else if (choice == 2)
			{
				String enteredName;
				try
				{
					System.out.println("Enter the students name: ");
					enteredName = keyboard.nextLine();
					int index = Student.StudentSearchByName(StudentArray, studentCount, enteredName);
					System.out.println(StudentArray[index]);
					
				}
				catch(StudentNotFoundException x)
				{
					System.out.println("Error: " + x.getMessage());
				}
			}
			else if (choice == 3)
			{
				String id, newMajor;
				try
				{
					System.out.println("Enter the id of the student who's major you would like to change: ");
					id = keyboard.next();
					int index = Student.StudentSearchById(StudentArray, studentCount, id);
					System.out.println("What major would you like to change to?");
					newMajor = keyboard.nextLine();
					StudentArray[index].setMajor(newMajor);
				}
				catch(StudentNotFoundException x)
				{
					System.out.println("Error: " + x.getMessage());
				}
			}
			else if (choice == 4)
			{
				break;
			}
			
		}
		keyboard.close();
	}

	}
