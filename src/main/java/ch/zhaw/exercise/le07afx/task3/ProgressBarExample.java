package ch.zhaw.exercise.le07afx.task3;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProgressBarExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        final Task<Void> task = createTask();

        final ProgressBar bar = new ProgressBar();
        bar.progressProperty().bind(task.progressProperty());

        final Label info = new Label();
        info.textProperty().bind(task.messageProperty());

        new Thread(task).start();

        primaryStage.setScene(new Scene(new VBox(bar, info), 250, 75));
        primaryStage.setTitle("ProgressBarAndTaskExample");
        primaryStage.show();
    }

    private Task<Void> createTask() {
        final Task<Void> task = new Task<Void>() {
            @Override
            public Void call() throws InterruptedException {
                for (int i = 1; i <= 100; i++) {
                    updateProgress(i, 100);
                    updateMessage("Prozent: " + i);
                    Thread.sleep(100);
                }
                return null;
            }
        };
        return task;
    }

    public static void main(String[] args) {
        System.setProperty("prism.lcdtext", "false");
        launch(args);
    }

}
