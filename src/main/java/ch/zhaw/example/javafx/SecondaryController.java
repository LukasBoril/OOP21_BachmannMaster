package ch.zhaw.example.javafx;

import java.io.IOException;
import javafx.fxml.FXML;

/*asdf*/
public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}
