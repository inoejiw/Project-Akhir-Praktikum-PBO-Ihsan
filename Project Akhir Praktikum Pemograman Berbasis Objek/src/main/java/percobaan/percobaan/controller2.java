package percobaan.percobaan;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.*;

public class controller2 {
    @FXML
    TextField tfnim;
    @FXML
    TextField tfnama;
    @FXML
    TextField tfalamat;
    @FXML
    Button btnsubmit;
    @FXML
    TableView tvDataMahasiswa;
    @FXML
    Button btnsave;
    @FXML
    Button btnload;

    @FXML
    public void onButton(ActionEvent e) {
        if (e.getTarget().equals(btnsubmit)) {
            ObservableList<MahasiswaModel> data = tvDataMahasiswa.getItems();
            data.add(new MahasiswaModel(
                    tfnim.getText(),
                    tfnama.getText(),
                    tfalamat.getText()
            ));
            tfnim.setText("");
            tfnama.setText("");
            tfalamat.setText("");
        } else if (e.getTarget().equals(btnsave)) {
            try {
                ObservableList<MahasiswaModel> data =
                        tvDataMahasiswa.getItems();
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("data-mahasiswa.dat"));
                for (int i = 0; i < data.size(); i++) {
                    writer.write(String.valueOf(data.get(i).getNim()) +
                            "," + String.valueOf(data.get(i).getNama()) +
                            "," + String.valueOf(data.get(i).getAlamat()));
                    writer.newLine();
                }
                writer.close();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("SUCCES");
                alert.setContentText("Sukses Simpan Data");
                alert.showAndWait();
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("Error IOException" + ex.getMessage());
                alert.showAndWait();
            }
        } else if (e.getTarget().equals(btnload)) {
            try {
                ObservableList<MahasiswaModel> data =
                        tvDataMahasiswa.getItems();
                data.clear();
                BufferedReader reader = new BufferedReader(
                        new FileReader("data-mahasiswa.dat"));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] temp = line.split(",");
                    MahasiswaModel mahasiswaModel = new MahasiswaModel(temp[0], temp[2]);
                    data.add(mahasiswaModel);
                }
                reader.close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("SUCCES");
                alert.setContentText("Sukses Load Data");
                alert.showAndWait();
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("Error IOException" + ex.getMessage());
                alert.showAndWait();
            }
        }
    }
    @FXML
    public void userLogOut(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("hello-view.fxml");
    }
}