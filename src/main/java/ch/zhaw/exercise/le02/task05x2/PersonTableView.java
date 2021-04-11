package ch.zhaw.exercise.le02.task05x2;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.util.converter.IntegerStringConverter;

import java.util.Optional;

public class PersonTableView extends VBox {

    private TableView<Person> table;
    private TableColumn<Person, String> firstNameColumn;
    private TableColumn<Person, String> lastNameColumn;
    private TableColumn<Person, Integer> ageColumn;

    public PersonTableView() {
        buildUI();
    }

    private void buildUI() {

        table = new TableView<Person>();
        table.setEditable(true);

        firstNameColumn = new TableColumn<Person, String>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameColumn.setOnEditCommit(event -> {
                Person person = event.getRowValue();
                person.setFirstName(event.getNewValue());
        });


        lastNameColumn = new TableColumn<Person, String>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setOnEditCommit(event -> {
                Person person = event.getRowValue();
                person.setLastName(event.getNewValue());
        });

        ageColumn = new TableColumn<Person, Integer>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));
        ageColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        ageColumn.setOnEditCommit(event -> {
                Person person = event.getRowValue();
                person.setAge(event.getNewValue());
        });

        table.getColumns().add(firstNameColumn);
        table.getColumns().add(lastNameColumn);
        table.getColumns().add(ageColumn);

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        getChildren().add(table);

    }

    public void add(Person person) {
        table.getItems().add(person);
    }

    public void removeSelectedRow() {
        Person selectedPerson = table.getSelectionModel().selectedItemProperty().getValue();
        if (confirmDelete(selectedPerson)) {
            table.getItems().remove(selectedPerson);
        }

    }

    public ReadOnlyObjectProperty<Person> getSelectedItemProperty () {
        return table.getSelectionModel().selectedItemProperty();
    }

    private boolean confirmDelete(Person selectedPerson) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Do you want delete the person " +
                selectedPerson.getFirstName() + " " +
                selectedPerson.getLastName() + "  ?");

        Optional<ButtonType> result = alert.showAndWait();
        return result.filter(buttonType -> buttonType == ButtonType.OK).isPresent();
    }

    public void refresh () {
        table.refresh();
    }
}
