public class Students {
   //declarations
	private String studentID;
	private String firstName;
	private String lastName;
	private String email;
	private int age;
	private int[] grades = new int[3];

	//constructor
	public Students(String studentID, String firstName, String lastName, String email, int age, int[] grades) {
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.grades = grades;
	}

	//accessors
	public String getStudentID() {
		return studentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	public int[] getGrades() {
		return grades;
	}

	//mutators

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGrades(int[] grades) {
		this.grades = grades;
	}

	public void print() {
		System.out.printf("%s\t%s%s\t%s%s\t%s%s\t{",
			this.getStudentID(),
			"First Name: ",
			this.getFirstName(),
			"Last Name: ",
			this.getLastName(),
			"Email: ",
			this.getEmail()
		);

		for (int i = 0; i < this.grades.length; i++) {
      if (i < 2)
        System.out.printf("%3d,", grades[i]);
      else
        System.out.printf("%3d", grades[i]);
    }
		System.out.printf("}\t");
	}

}