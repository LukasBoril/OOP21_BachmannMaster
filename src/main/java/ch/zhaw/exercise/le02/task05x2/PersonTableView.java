package ch.zhaw.exercise.le02.task05x2;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Optional;

public class PersonTableView extends VBox {

    private TableView<Person> table;
    private TableColumn<Person, String> firstNameColumn;
    private TableColumn<Person, String> lastNameColumn;
    private TableColumn<Person, Integer> ageColumn;
    private final PropertyChangeSupport onDeleteAction;
    private final PropertyChangeSupport onEditAction;

    public PersonTableView() {
        onDeleteAction = new PropertyChangeSupport( this );
        onEditAction = new PropertyChangeSupport( this );
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
        ageColumn.setStyle( "-fx-alignment: CENTER;");
        ageColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        ageColumn.setOnEditCommit(event -> {
                Person person = event.getRowValue();
                person.setAge(event.getNewValue());
        });

        table.getColumns().add(firstNameColumn);
        table.getColumns().add(lastNameColumn);
        table.getColumns().add(ageColumn);
        addButtonsToTable();

        table.setRowFactory(tableView -> {
            final TableRow<Person> row = new TableRow<>();
            Person selectedPerson = table.getSelectionModel().selectedItemProperty().getValue();
            // create a context menu on non empty rows
            row.contextMenuProperty().bind(
                    Bindings.when(row.emptyProperty())
                            .then((ContextMenu)null)
                            .otherwise(createContextMenu(selectedPerson) )
            );
            return row ;
        });

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        setVgrow(table, Priority.ALWAYS);
        getChildren().add(table);
    }

    private ContextMenu createContextMenu(Person selectedPerson) {
        ImageView deleteIcon = new ImageView(new Image(getClass().getResourceAsStream("delete.png")));
        ImageView editIcon = new ImageView(new Image(getClass().getResourceAsStream("edit.png")));

        final ContextMenu contextMenu = new ContextMenu();

        MenuItem delete = new MenuItem("Delete");
        delete.setGraphic(deleteIcon);
        delete.setOnAction(event -> onDeleteAction.firePropertyChange( "delete", selectedPerson, selectedPerson ));

        MenuItem edit = new MenuItem("Edit");
        edit.setGraphic(editIcon);
        edit.setOnAction(event -> onEditAction.firePropertyChange( "edit", selectedPerson, selectedPerson ));

        contextMenu.getItems().addAll(delete, edit);
        return contextMenu;
    }


    /**
     * Add a person to the table
     * @param person the person to add
     */
    public void add(Person person) {
        table.getItems().add(person);
    }

    /**
     * Remove the selected row
     */
    public void removeSelectedRow() {
        Person selectedPerson = table.getSelectionModel().selectedItemProperty().getValue();
        if (confirmDelete(selectedPerson)) {
            table.getItems().remove(selectedPerson);
        }

    }

    public void removeRow(Person person) {
        if (confirmDelete(person)) {
            table.getItems().remove(person);
        }
    }


    /**
     * Get the selected Person
     * @return the selected person in the table
     */
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

    /**
     * Refresh the table with changed data
     */
    public void refresh () {
        table.refresh();
    }

    /**
     * Register a listener in case of a delete from the context menu
     * @param listener callback in case of event
     */
    public void addOnDeleteListener(PropertyChangeListener listener) {
        onDeleteAction.addPropertyChangeListener(listener);
    }

    /**
     * Register a listener in case of a edit from the context menu
     * @param listener callback in case of event
     */
    public void addOnEditListener(PropertyChangeListener listener) {
        onEditAction.addPropertyChangeListener(listener);
    }

    /**
     * Create a column for the action buttons. Prepares a callback for creating the button for each row
     */
    private void addButtonsToTable() {
        TableColumn<Person, Void> actionColumn = new TableColumn<>("Action");
        Callback<TableColumn<Person, Void>, TableCell<Person, Void>> cellFactory = this::getActionTableCell;
        actionColumn.setCellFactory(cellFactory);
        table.getColumns().add(actionColumn);
    }

    /**
     * Create table cell with action buttons
     * @param param current cell
     * @return a table cell with buttons
     */
    private TableCell<Person, Void> getActionTableCell(TableColumn<Person, Void> param) {
        return new TableCell<Person, Void>() {

            private final Button deleteButton;

            {
                deleteButton = new Button("");
                ImageView btnIcon = new ImageView(new Image(getClass().getResourceAsStream("delete.png")));
                deleteButton.setGraphic(btnIcon);
                deleteButton.setOnAction(event -> {
                    removeRow(getTableView().getItems().get(getIndex()));
                });
            }

            @Override
            public void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(deleteButton);
                }
            }
        };
    }

}
