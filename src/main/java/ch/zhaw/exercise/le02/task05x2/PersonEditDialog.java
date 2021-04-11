package ch.zhaw.exercise.le02.task05x2;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class PersonEditDialog extends Dialog<Person> {

    public PersonEditDialog() {
        buildUI(null);
    }

    public PersonEditDialog(Person person) {
        buildUI(person);
    }

    private void buildUI(Person person) {
        setTitle("Person Dialog");
        setHeaderText("Add a new Person");

        // Set the icon (must be included in the project).
        setGraphic(new ImageView(this.getClass().getResource("person.png").toString()));

        // Set the button types.
        ButtonType saveButtonType = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        // Create the firstName and lastName labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField firstName = new TextField();
        firstName.setPromptText("First Name");
        TextField lastName = new TextField();
        lastName.setPromptText("Last Name");
        TextField age = new TextField();
        age.setPromptText("Age");

        grid.add(new Label("First Name:"), 0, 0);
        grid.add(firstName, 1, 0);
        grid.add(new Label("Last Name:"), 0, 1);
        grid.add(lastName, 1, 1);
        grid.add(new Label("Age:"), 0, 2);
        grid.add(age, 1, 2);

        Node saveButton = getDialogPane().lookupButton(saveButtonType);
        saveButton.setDisable(true);

        if (person != null) {
            firstName.setText(person.getFirstName());
            lastName.setText(person.getLastName());
            age.setText(String.valueOf(person.getAge()));
            setHeaderText("Edit a Person");
            saveButton.setDisable(false);
        }

        // Enable the save button only if all fields have text
        firstName.textProperty().addListener((observable, oldValue, newValue) -> {
            saveButton.setDisable(newValue.trim().isEmpty() || lastName.getText().trim().isEmpty() || age.getText().trim().isEmpty());
        });

        lastName.textProperty().addListener((observable, oldValue, newValue) -> {
            saveButton.setDisable(newValue.trim().isEmpty() || firstName.getText().trim().isEmpty() || age.getText().trim().isEmpty());
        });

        // force the field to be numeric only
        age.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                age.setText(newValue.replaceAll("[^\\d]", ""));
                saveButton.setDisable(true);
            } else {
                saveButton.setDisable(newValue.trim().isEmpty() || firstName.getText().trim().isEmpty() || lastName.getText().trim().isEmpty());
            }
        });

        getDialogPane().setContent(grid);

        // Request focus on the firstName field by default.
        Platform.runLater(firstName::requestFocus);

        // Convert the result to a person when the login button is clicked.
        setResultConverter(dialogButton -> {
            if (dialogButton == saveButtonType) {
                return new Person(firstName.getText().trim(), lastName.getText().trim(), Integer.parseInt(age.getText().trim()));
            }
            return null;
        });

    }

}
