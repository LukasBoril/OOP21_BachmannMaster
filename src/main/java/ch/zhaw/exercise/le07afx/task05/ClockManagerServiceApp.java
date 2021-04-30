package ch.zhaw.exercise.le07afx.task05;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;



/* Model */
class Clock {
    private long startTime;

    public long getTime() {
        return System.currentTimeMillis() - startTime;
    }

    public void reset() {
        startTime = System.currentTimeMillis();
    }
}


/* View */
class ClockView
{
    private final ClockPresenter presenter;
    private VBox root;
    private Label timeLabel;

    public ClockView(ClockPresenter presenter) {
        this.presenter = presenter;
        initView();
    }

    private void initView() {
        root = new VBox(8);
        root.setPadding(new Insets(10));
        timeLabel = new Label();
        root.getChildren().add(timeLabel);

        Button startButton = new Button("Start");
        startButton.setOnAction(e -> presenter.start());
        startButton.setMaxWidth(Double.MAX_VALUE);
        root.getChildren().add(startButton);

        Button stopButton = new Button("Stop");
        stopButton.setOnAction(e -> presenter.stop());
        stopButton.setMaxWidth(Double.MAX_VALUE);
        root.getChildren().add(stopButton);

        Button nullButton = new Button("Null");
        nullButton.setOnAction(e -> presenter.reset());
        nullButton.setMaxWidth(Double.MAX_VALUE);
        root.getChildren().add(nullButton);

        Button endButton = new Button("End");
        endButton.setMaxWidth(Double.MAX_VALUE);
        endButton.setOnAction(e -> presenter.exit());
        root.getChildren().add(endButton);
    }

    public Pane getUI() {
        return root;
    }

    public void showTime(long elapsedTime) {
        long seconds = elapsedTime / 1000;
        long milliSecs = elapsedTime % 1000;
        String prefix;
        if (milliSecs < 10) {
            prefix = "00";
        }
        else if (milliSecs < 100) {
            prefix = "0";
        } else {
            prefix = "";
        }
        timeLabel.setText(seconds + ":" + prefix + milliSecs);
    }
}

class TickerTask extends Task<Long> {
    private final static long UPDATE_INTERVAL = 10; // Milliseconds

    private final Clock clock;

    public TickerTask(Clock clock) {
        this.clock = clock;
    }

    protected Long call() {
        while (!isCancelled()) {
            updateValue(clock.getTime());
            try {
                Thread.sleep(UPDATE_INTERVAL);
            } catch (InterruptedException ignored) {
            }
        }
        return clock.getTime();
    }
}



class TickerService extends Service<Long> {
    private final Clock clock;

    public TickerService(Clock clock) {
        this.clock = clock;
    }

    @Override
    protected Task<Long> createTask() {
        return new TickerTask(clock);
    }
}

class ClockPresenter {
    private TickerService tickerService;
    private final Stage primaryStage;
    protected Clock clock;
    protected ClockView clockView;

    public ClockPresenter(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setModelAndView(Clock clock, ClockView view) {
        this.clock = clock;
        this.clockView = view;
        tickerService = new TickerService(clock);
        tickerService.valueProperty().addListener((obs, oldVal, newVal) -> show(newVal));
    }

    private void show(Long newVal) {
        if (newVal != null) {
            clockView.showTime(newVal);
        }
    }


    public void start() {
        if (!tickerService.isRunning()) {
            clock.reset();
            tickerService.reset();
            tickerService.start();
        }
    }

    public void stop() {
        tickerService.cancel();
    }

    public void exit() {
        primaryStage.close();
    }

    public void reset() {
        clock.reset();
        clockView.showTime(clock.getTime());
    }
}

/* Main */
public class ClockManagerServiceApp extends Application {

    ClockPresenter clockPresenter;
    ClockView clockView;

    public void start(Stage primaryStage) {
        clockPresenter = new ClockPresenter(primaryStage);
        clockView = new ClockView(clockPresenter);
        Clock clock = new Clock();
        clockPresenter.setModelAndView(clock, clockView);
        clockPresenter.reset();

        Scene scene = new Scene(clockView.getUI());

        primaryStage.setOnCloseRequest((event) -> {
            Platform.exit();
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Start/stop watch with Service");
        primaryStage.show();
    }

    public static void main(String[] args) {
        System.setProperty("prism.lcdtext", "false");
        launch(args);
    }
}
