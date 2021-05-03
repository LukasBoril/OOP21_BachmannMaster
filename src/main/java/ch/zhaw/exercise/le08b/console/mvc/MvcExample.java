package ch.zhaw.exercise.le08b.console.mvc;

import ch.zhaw.exercise.le08b.console.mvc.domain.DomainController;
import ch.zhaw.exercise.le08b.console.mvc.domain.StudentModel;
import ch.zhaw.exercise.le08b.console.mvc.presentation.Controller;
import ch.zhaw.exercise.le08b.console.mvc.presentation.View;

public class MvcExample {

    View view;

    public static void main(String[] args) {
        new MvcExample().run();
    }

    public void run() {
        StudentModel studentModel = new StudentModel(1, "Felix Muster");
        DomainController domainController = new DomainController(studentModel);
        Controller controller = new Controller(domainController);
        View view = new View(controller);
        studentModel.addPropertyChangeListener( e -> {
            view.onStudentNameChanged(e.getNewValue().toString());
        });

        view.readConsole();
    }
}


