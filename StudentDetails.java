import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.List;


class Students{
    String name;
    int rollNo;
    List<String> subjects;
    List<Integer> marks;
    Students(String name , int rollNo){
        this.name = name;
        this.rollNo = rollNo;
        this.subjects = new ArrayList<>();
        this.marks =new LinkedList<>() ;


    }
    void addSubjectMark(String subject, int mark){
        subjects.add(subject);
        marks.add(mark);

    }
    void display(){
        System.out.println("\n-----------------------------------");
        System.out.println("Student Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("-----------------------------------");

        System.out.printf("%-5s %-15s %-10s\n", "S.No", "Subject", "Marks");
        System.out.println("-----------------------------------");

        int total = 0;
        for (int i = 0; i < subjects.size(); i++) {
            System.out.printf("%-5d %-15s %-10d\n", (i + 1), subjects.get(i), marks.get(i));
            total += marks.get(i);
        }

        double average = subjects.size() > 0 ? (double) total / subjects.size() : 0;

        System.out.println("-----------------------------------");
        System.out.printf("%-20s %-10d\n", "Total Marks:", total);
        System.out.printf("%-20s %-10.2f\n", "Average Marks:", average);
        System.out.println("-----------------------------------\n");
    }



}
public class StudentDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Roll Number:");
        int rollNo = sc.nextInt();
        sc.nextLine();
        Students student = new Students(name,rollNo);
        while (true) {
            System.out.print("\nEnter Subject Name (or type 'stop' to finish): ");
            String subject = sc.nextLine();
            if (subject.equalsIgnoreCase("stop")) {
                break;
            }

            System.out.print("Enter Marks for " + subject + ": ");
            int mark = sc.nextInt();
            sc.nextLine(); // clear buffer

            student.addSubjectMark(subject, mark);
        }

        student.display();
        sc.close();


    }
}

