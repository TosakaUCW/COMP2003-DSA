import java.io.*;
import java.util.Scanner;

public class SMS {

    public static void main(String[] args) {
        AVLTree studentTree = new AVLTree();

        try {
            loadStudentDataFromFile(studentTree, "studentList.txt");
        } catch (IOException e) {
            System.err.println("Failed loading file: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command (q<ID>, u<ID>, or e to exit):");
            String command = scanner.nextLine();

            // Query command
            if (command.startsWith("q")) {
                int id = Integer.parseInt(command.substring(1));
                Node result = studentTree.findNode(id);
                if (result != null) {
					Student student = result.getStudent();
					String gender = student.gender.equals("M") ? "male" : "female";
					
					String message = student.firstName + " " 
								+ student.surname + " "
								+ "(" + id + ") is a "
								+ gender
								+ " of age " + student.age + ".";
					System.out.println(message);
                } else {
                    System.out.println("No records found.");
                }
            }
            // Unenrollment command
            else if (command.startsWith("u")) {
                int id = Integer.parseInt(command.substring(1));
                Node result = studentTree.findNode(id);
                if (result != null) {
                    Student student = result.getStudent();
					
					String message = student.firstName + " " 
								+ student.surname + " "
								+ "(" + id + ") is unenrolled.";
					System.out.println(message);
					
                    studentTree.deleteNode(id);
                } else {
                    System.out.println("No records found.");
                }
            }
            // Exit command
            else if (command.equals("e")) {
                System.out.println("Exiting program.");
                break;
            }
        }
        scanner.close();
    }

    private static void loadStudentDataFromFile(AVLTree tree, String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String firstName = parts[0];
            String surname = parts[1];
            String gender = parts[2];
            int id = Integer.parseInt(parts[3]);
            int age = Integer.parseInt(parts[4]);

            Student student = new Student(firstName, surname, gender, id, age);
            tree.insertNode(student);
        }
        reader.close();
        // System.out.println("Loading success.");
    }
}
