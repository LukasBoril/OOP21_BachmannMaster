package ch.zhaw.exercise.le08b.javafx.mvp.presentation;

import ch.zhaw.exercise.le08b.javafx.mvp.domain.StudentModel;
import ch.zhaw.exercise.le08b.javafx.mvp.domain.DomainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MvpApp extends Application {

    private StudentModel studentModel;
    private DomainController domainController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Initialize the Domain Layer and the ViewModel
        initApp();

        //create a root and load fxml code
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentView.fxml"));
        Parent root = loader.load();

        // get the Presenter and bind it with the domainController
        Presenter presenter = (Presenter) loader.getController();
        presenter.init(domainController);
        studentModel.addPropertyChangeListener( e -> presenter.onStudentNameChanged(e.getNewValue().toString()));

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

    }
}
