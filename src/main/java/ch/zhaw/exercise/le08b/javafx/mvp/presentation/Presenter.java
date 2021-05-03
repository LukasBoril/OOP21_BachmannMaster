package ch.zhaw.exercise.le08b.javafx.mvp.presentation;


import ch.zhaw.exercise.le08b.javafx.mvp.domain.DomainController;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Presenter {
    @FXML
    Label label;
    @FXML
    TextField input;
    @FXML
    Button button;

    DomainController domainController;

    /**
     * Set the DomainController
     * @param domainController A reference ot the DomainController
     */
    public void init(DomainController domainController) {

        this.domainController = domainController;
        label.setText(domainController.getStudentName());
        button.disableProperty().bind(createButtonBinding());
    }

    /**
     * will be called when button is pressed
     */
    @FXML
    public void onAction() {
        domainController.updateStudent(input.getText());
    }

    /**
     * will be called at Enter
     */
    @FXML
    public void onEnter() {
        if(!input.getText().isEmpty()) {
            domainController.updateStudent(input.getText());
        }
    }

    public void onStudentNameChanged(String studentName) {
        label.setText(studentName);
        input.setText("");
    }

    /**
     * create a BooleanBinding if Text field is empty
     * @return BooleanBinding
     */
    private BooleanBinding createButtonBinding() {
        return new BooleanBinding() {
            {
                super.bind(input.textProperty());
            }

            @Override
            protected boolean computeValue() {
                return input.getText().isEmpty();
            }
        };
    }

}
