/*Part 2*/
public class Student{
	/*Your code here*/
	String firstName;
    String surname;
    String gender;
    int id;
    int age;

    public Student(String firstName, String surname, String gender, int id, int age) {
        this.firstName = firstName;
        this.surname = surname;
        this.gender = gender;
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName + " " + surname + " (" + id + ") is a " + gender.toLowerCase() + " of age " + age + ".";
    }
}