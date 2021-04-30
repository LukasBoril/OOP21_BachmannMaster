package ch.zhaw.exercise.le07afx.task01;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class JavaFXThreads extends Application {
    public void start(Stage primaryStage) {
        System.out.println("start: thread = " + Thread.currentThread().getName());
        GroupTree.dumpAll();
        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class GroupTree {

    private static ThreadGroup getRoot() {
        ThreadGroup result = Thread.currentThread().getThreadGroup();
        while (result.getParent() != null) {
            result = result.getParent();
        }
        return result;
    }

    private static void dump(ThreadGroup group, int blanks) {
        for (int i = 0; i < blanks; i++) {
            System.out.print(" ");
        }
        System.out.println(group);

        int numberOfThreads = group.activeCount();
        Thread[] threadList = new Thread[numberOfThreads];
        int threadNumber = group.enumerate(threadList, false);
        for (int i = 0; i < threadNumber; i++) {
            for (int j = 0; j < blanks + 3; j++) {
                System.out.print(" ");
            }
            System.out.println(threadList[i]);
        }

        int numberOfGroups = group.activeGroupCount();
        ThreadGroup[] threadgroupList = new ThreadGroup[numberOfGroups];
        int threadgroupNumber = group.enumerate(threadgroupList, false);
        for (int i = 0; i < threadgroupNumber; i++) {
            dump(threadgroupList[i], blanks + 3);
        }
    }

    public static void dumpAll() {
        dump(getRoot(), 1);
    }
}
