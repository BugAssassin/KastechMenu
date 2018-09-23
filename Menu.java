
import java.util.*;

class StudentRecord {

    int rno;
    String name;

    public StudentRecord(int rno, String name) {
        this.rno = rno;
        this.name = name;

    }
}

public class Menu {

    Scanner in = new Scanner(System.in);
    ArrayList<StudentRecord> r = new ArrayList<>();

    public void addRecord() {
        int rno;
        String name;

        System.out.println("Please enter details of the Student:");
        System.out.println("Enter Student ID:");
        rno = in.nextInt();

        int flag = 0;
       
        for (int i = 0; i < r.size(); i++) {
            if (rno == r.get(i).rno) {
                System.out.println("The student with ID" + rno + "already exists.Please enter valid details");
                flag++;
                addRecord();

            }
        }
        if (flag == 0) {

            System.out.println("Enter Student name:");
            name = in.next();
            StudentRecord s = new StudentRecord(rno, name);
            r.add(s);
            System.out.println("Student with name" + name + "(ID:" + rno + ") has been added successfully");

            menu();
        }

    }

    public void delRecord() {
        int rno;
        int flag = 0;
        String name;
        System.out.println("Please enter the ID of the student record you want to delete");
        rno = in.nextInt();
        if (r.size() == 0) {
            System.out.println("No records to delete");
            menu();
        }
        for (int i = 0; i < r.size(); i++) {
            if (rno == r.get(i).rno) {

                r.remove(i);

                System.out.println("The Student record with ID: " + rno + " has been deleted succesfully");
                flag++;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("The student with ID:" + rno + "doesnot exist.Please enter valid details.");
            delRecord();
        }

        menu();
    }

    public void display() {

        Menu m = new Menu();
        System.out.println("Current Student Records:");

        for (int i = 0; i < r.size(); i++) {
            System.out.print("Student ID: " + r.get(i).rno + ",  ");
            System.out.println("Student Name: " + r.get(i).name + ",   ");

        }
        menu();
    }

    public void menu() {
        Menu m = new Menu();
        System.out.println("1.Add student records");
        System.out.println("2.Delete Student Record");
        System.out.println("3.Display Student Record");
        System.out.println("4.Exit");

        int choice = in.nextInt();

        switch (choice) {
            case 1:
                addRecord();
                break;
            case 2:
                delRecord();
                break;
            case 3:
                display();
                break;
            case 4:
                return;
            default:
                System.out.println("Enter choice from 1-4");

        }

    }

    public static void main(String args[]) {
        ArrayList<StudentRecord> r = new ArrayList<>();
        System.out.println("Welcome to Kastech Training Program");
        Menu m = new Menu();

        m.menu();

    }
}
