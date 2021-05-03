package ch.zhaw.exercise.le08b.javafx.mvvm.presentation;

import ch.zhaw.exercise.le08b.javafx.mvvm.domain.DomainController;
import ch.zhaw.exercise.le08b.javafx.mvvm.domain.StudentModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MvvmApp extends Application {

    private StudentModel studentModel;
    private DomainController domainController;
    StudentViewModel studentViewModel;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Initialize the Domain Layer and the ViewModel
        initApp();

        //create a root and load fxml code
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentView.fxml"));
        Parent root = loader.load();

        // get the StudentView and bind it with the ViewModel
        StudentView studentView = (StudentView) loader.getController();
        studentView.setStudentViewModel(studentViewModel);

        //add root to the window and show it
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void initApp() {
        studentModel = new StudentModel(1, "Felix Muster");
        domainController = new DomainController(studentModel);
        studentViewModel = new StudentViewModel(domainController);
        studentModel.addPropertyChangeListener( e -> {
                studentViewModel.onStudentNameChanged(e.getNewValue().toString());
        });
    }
}
