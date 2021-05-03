package ch.zhaw.exercise.le08b.console.mvc.presentation;


import ch.zhaw.exercise.le08b.console.mvc.domain.DomainController;

/**
 * Frontend Controller
 */
public class Controller {
    DomainController domainController;

    public Controller(DomainController domainController) {
        this.domainController = domainController;
    }

    public void updateStudent(String name) {
        domainController.updateStudent(name);
    }
}
