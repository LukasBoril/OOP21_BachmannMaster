package ch.zhaw.exercise.le08b.console.mvc.presentation;


import java.util.Scanner;

public class View {
    Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    /**
     * Callback from Observable
     *
     * @param studentName the student name
     */

    public void onStudentNameChanged(String studentName) {

        printStudent(studentName);
    }

    /**
     * Output to Console
     *
     * @param studentName the student name
     */
    void printStudent(String studentName) {
        System.out.println("Student from Property Change Listener: ");
        System.out.println("Name: " + studentName);
    }

    /**
     * Input from Console
     */
    public void readConsole() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("enter new student name, 0 for exit");
                System.out.println();
                String name = scanner.next();
                if (name.equals("0")) break;

                controller.updateStudent(name);
            }
        }
        System.out.println("Exit ");
    }
}
