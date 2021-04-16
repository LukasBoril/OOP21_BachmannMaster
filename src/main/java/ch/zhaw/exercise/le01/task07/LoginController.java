package ch.zhaw.exercise.le01.task07;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class LoginController {

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField nameField;

    @FXML
    public void handleSubmitButtonAction(ActionEvent actionEvent) {
        System.out.println("Sign in button user input: "
                + nameField.getText() + " Password: "
                + passwordField.getText());
    }
}
