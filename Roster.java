import java.util.ArrayList;
import java.util.Scanner;

public class Roster {

	static ArrayList<Students> studentList = new ArrayList<Students>();

	 public static void add(String studentID, String firstname, String lastname, String emailaddress, int age, 
	 	int grade1, int grade2, int grade3) {
	 	studentList.add(
				new Students(studentID, firstname, lastname, emailaddress, age, new int[]{grade1,grade2,grade3})
				);
	 }//end method add()

	public static void print_average_grade(String studentID) {
		int total = 0;
		for(Students student : studentList) {
			if(student.getStudentID().equals(studentID)) {
				for(int grade : student.getGrades()) {
					total += grade;
				}//end for
			}//end if
		}//end for

		System.out.printf("%s's grade average: %.2f", studentID, (double) total / 3);
	}//end class print_average_grade()

	public static void print_all() {
	   System.out.println("Printing all students");
		for (Students student: studentList) {
			student.print();
		}//end for
	}//end method print_All()

	public static void remove(String studentID) {
	   boolean isFound = false;
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getStudentID().equals(studentID)) {
				studentList.remove(studentList.get(i));
				isFound = true;
			}
		}//end for

      if(!isFound) {
		   System.out.printf("%s was not found\n", studentID);
      } else {
		   System.out.printf("%s was removed\n", studentID);
      }
    }//end method remove()

   public static void print_invalid_emails() {
      System.out.println("Invalid emails: ");

	   for (int i = 0; i < studentList.size(); i++) {
	      if (studentList.get(i).getEmail().indexOf('@') == -1
            || studentList.get(i).getEmail().indexOf('.') == -1
            || studentList.get(i).getEmail().indexOf(' ') != -1)
	        System.out.printf("%s%n", studentList.get(i).getEmail());
      }//end for
   }//end method print_invalid_emails()


	public static void main(String[] args) {
		String [] students = {"1,John,Smith,John1989@gmail.com,20,88,79,59", 
             "2,Suzan,Erickson,Erickson_1990@gmailcom,19,91,72,85",
             "3,Jack,Napoli,The_lawyer99yahoo.com,19,85,84,87",
             "4,Erin,Black,Erin.black@comcast.net,22,91,98,82",
             "5,Sharina,Jones,sjon323@wgu.edu,35,96,98,86"};

        String studentID = "";
        String firstName = "";
        String lastName = "";
        String email = "";
        int age = 0;
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;


		for (int row = 0; row < students.length; row++)
		{
			
			String[] currentRow = students[row].split(",");
			for (int i = 0; i < currentRow.length; i++){
				switch(i) {
					case 0:
						studentID = currentRow[i];
						break;
					case 1:
						firstName = currentRow[i];
						break;
					case 2:
						lastName = currentRow[i];
						break;
					case 3: 
						email = currentRow[i];
						break;
					case 4:
						age = Integer.parseInt(currentRow[i]);
						break;
					case 5:
						score1 = Integer.parseInt(currentRow[i]);
						break;
					case 6:
						score2 = Integer.parseInt(currentRow[i]);
						break;
					case 7:
						score3 = Integer.parseInt(currentRow[i]);
				}//end switch
			}//end inner for

			Roster.add(studentID, firstName, lastName, email, age, score1, score2, score3);			
		}//end outer for

		Roster.print_all();
		System.out.println("\n");
    Roster.print_invalid_emails();
    System.out.println("\n");
    Roster.print_average_grade("3");
    System.out.println("\n");
    Roster.remove("3");
    System.out.println("\n");
    Roster.remove("3");


   }//end method main()
}//end class StudentTest