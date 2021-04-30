package ch.zhaw.exercise.le07afx.task04;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class ProgressTask extends Task<Void> {
    private final static long INTERVAL = 50; // Milliseconds

    @Override
    protected Void call() {
        int totalWork = (int) (Math.random() * 200 + 50);
        int workDone = 0;
        while (!isCancelled() && workDone <= totalWork) {
            updateProgress(workDone, totalWork);
            workDone++;
            try {
                Thread.sleep(INTERVAL);
            } catch (InterruptedException ignored) {
            }
        }
        return null;
    }
}

class ProgressPresenter {
    private ProgressTask progressTask;
    private ProgressView progressView;

    public void setProgressView(ProgressView progressView) {
        this.progressView = progressView;
    }

    public void start() {
        if (progressTask == null || !progressTask.isRunning()) {
            progressTask = new ProgressTask();
            // Binding the view with the progressProperty from the progressTask
            progressView.bind(progressTask.progressProperty());
            Thread thread = new Thread(progressTask);
            thread.setDaemon(true);
            thread.start();
        }
    }

    public void stop() {
        if (progressTask != null) {
            progressTask.cancel();
        }
    }
}

/* View */
class ProgressView {
    private final ProgressPresenter presenter;

    private VBox root;
    private ProgressBar progressBar;
    private ProgressIndicator progressIndicator;

    public ProgressView(ProgressPresenter presenter) {
        this.presenter = presenter;
        initView();
    }

    private void initView() {
        root = new VBox(8);
        root.setPadding(new Insets(10));

        Button startButton = new Button("Start");
        startButton.setOnAction(e -> presenter.start());

        root.getChildren().add(startButton);
        Button stopButton = new Button("Stop");
        stopButton.setOnAction(e -> presenter.stop());
        root.getChildren().add(stopButton);

        progressBar = new ProgressBar();
        root.getChildren().add(progressBar);

        progressIndicator = new ProgressIndicator();
        root.getChildren().add(progressIndicator);
    }

    public Pane getUI() {
        return root;
    }

    // Binding the progressProperty from ProgressTask to the Bar and the Indicator
    public void bind(ReadOnlyDoubleProperty progressProperty) {
        progressBar.progressProperty().bind(progressProperty);
        progressIndicator.progressProperty().bind(progressProperty);
    }
}

/* Main */
public class ProgressTaskApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        ProgressPresenter presenter = new ProgressPresenter();
        ProgressView view = new ProgressView(presenter);
        presenter.setProgressView(view);

        Scene scene = new Scene(view.getUI(), 250, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Progress with Binding");
        primaryStage.show();
    }

    public static void main(String[] args) {
        System.setProperty("prism.lcdtext", "false");
        launch(args);
    }
}
