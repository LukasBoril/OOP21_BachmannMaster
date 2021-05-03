package ch.zhaw.exercise.le08b.javafx.mvvm.presentation;

import ch.zhaw.exercise.le08b.javafx.mvvm.domain.DomainController;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentViewModel {
    private final StringProperty labelText = new SimpleStringProperty("default");
    private final StringProperty inputText = new SimpleStringProperty();
    private final BooleanProperty buttonDisabled = new SimpleBooleanProperty();

    private final DomainController domainController;

    public StudentViewModel(DomainController domainController) {
        this.domainController = domainController;
        buttonDisabled.bind(inputText.isEmpty());
        labelText.set(domainController.getStudentName());
    }

    public void changeStudentName() {
        if(inputText.get() != null && !inputText.get().trim().isEmpty()) {
            domainController.updateStudent(inputText.get().trim());
        }
    }

    public void onStudentNameChanged(String studentName) {
        labelText.set(studentName);
        inputText.set("");
    }

    public StringProperty labelTextProperty() {
        return labelText;
    }

    public StringProperty inputTextProperty() {
        return inputText;
    }

    public BooleanProperty buttonDisabledProperty() {
        return buttonDisabled;
    }


}
