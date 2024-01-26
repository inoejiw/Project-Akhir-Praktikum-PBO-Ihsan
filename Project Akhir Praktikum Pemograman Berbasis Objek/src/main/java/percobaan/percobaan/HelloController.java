package percobaan.percobaan;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

        @FXML
        private Button login;
        @FXML
        private Label wrongLogIn;
        @FXML
        private TextField username;
        @FXML
        private PasswordField password;
        @FXML
        private Button cancelbtn;

        public void userLogIn(ActionEvent event) throws IOException {
            checkLogin();
        }
        private void checkLogin() throws IOException {
            HelloApplication m = new HelloApplication();
            if (username.getText().toString().equals("inujigans") && password.getText().toString().equals("123")) {
                wrongLogIn.setText("Success!");

                m.changeScene("datamhs.fxml");
            } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
                wrongLogIn.setText("Cing Baleg Atuh Boss, Isian Ai Sia");
            } else {
                wrongLogIn.setText(".   Kela Ieu Aya Nu Salah Boss");
            }
        }
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelbtn.getScene().getWindow();
        stage.close();
    }
    }