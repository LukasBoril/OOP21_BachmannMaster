package ch.zhaw.exercise.le08b.console.mvc.domain;

/**
 * Larman Domain Controller with one system operation
 */
public class DomainController {
    StudentModel studentModel;

    public DomainController(StudentModel studentModel) {
        this.studentModel = studentModel;
    }

    /**
     * system operation updateStudent
     * @param name the name of the student to update
     */
    public void updateStudent(String name) {
        this.studentModel.setName(name);
    }
}
