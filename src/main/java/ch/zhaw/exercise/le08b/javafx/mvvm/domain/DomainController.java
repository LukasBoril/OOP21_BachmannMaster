package ch.zhaw.exercise.le08b.javafx.mvvm.domain;

/**
 * Larman Domain Controller with one system operation
 */
public class DomainController {
    StudentModel studentModel;

    public DomainController(StudentModel studentModel) {
        this.studentModel = studentModel;
    }

    /**
     * system operation
     * @param name the name of the student to update
     */
    public void updateStudent(String name) {
        studentModel.setName(name);
    }

    public String getStudentName() {
        return studentModel.getName();
    }
}
