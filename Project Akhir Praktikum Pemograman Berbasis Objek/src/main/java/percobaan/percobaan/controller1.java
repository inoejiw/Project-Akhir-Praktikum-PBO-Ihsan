package percobaan.percobaan;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class controller1 {


        @FXML
        private Button logout;


        public void userExit(ActionEvent event) throws IOException {
            HelloApplication m = new HelloApplication();
            m.changeScene("hello-view.fxml");

        }
    }
