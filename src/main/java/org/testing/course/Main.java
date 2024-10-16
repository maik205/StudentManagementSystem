package org.testing.course;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentService svc = new StudentService();
        while (true) {
            System.out.println("1. Create a student");
            System.out.println("2. Find a student");
            System.out.println("3. Update a student");
            System.out.println("4. Delete a student");
            System.out.println("other. Exit");
            System.out.print("> ");
            int choice = Inputter.inputInt(1, 5);
            switch (choice) {
                case 1:
                    try {
                        svc.addStudent(Inputter.inputStudent());
                    } catch (InvalidStudentException e) {
                        System.out.println("Invalid student");
                    }
                    break;
                case 2:
                    System.out.println(svc.getStudent(Inputter.inputString()));
                    break;
                case 3:
                    Student s = Inputter.inputStudent();
                    try {
                        svc.updateStudent(s.getStdId(), s);
                    } catch (InvalidStudentException e) {
                        System.out.println("Invalid student");
                    }
                    break;
                case 4:
                    try {
                        svc.deleteStudent(Inputter.inputString());
                    } catch (InvalidStudentException e) {
                        System.out.println("Invalid student");
                    }
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}