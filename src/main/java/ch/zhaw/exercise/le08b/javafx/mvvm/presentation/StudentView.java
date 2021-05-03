package ch.zhaw.exercise.le08b.javafx.mvvm.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class StudentView {
    @FXML
    Label label;
    @FXML
    TextField input;
    @FXML
    Button button;

    private StudentViewModel studentViewModel;

    /**
     * Bind Controls to the View Model
     * @param studentViewModel the Student View Model
     */
    public void setStudentViewModel(StudentViewModel studentViewModel) {
        this.studentViewModel = studentViewModel;
        initBindings();
    }

    private void initBindings() {
        label.textProperty().bind(studentViewModel.labelTextProperty());
        input.textProperty().bindBidirectional(studentViewModel.inputTextProperty());
        button.disableProperty().bind(studentViewModel.buttonDisabledProperty());
    }

    /**
     * will be called when button is pressed
     */
    @FXML
    public void onAction() {
        studentViewModel.changeStudentName();
    }

    /**
     * will be called at Enter
     */
    @FXML
    public void onEnter() {
        studentViewModel.changeStudentName();
    }
}
