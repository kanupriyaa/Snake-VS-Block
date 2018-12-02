package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Main;
import sample.Leaderboard;

public class Controller {
    @FXML
    public Label Start;
    public Button Button1;
    public Button Button2;
    public Stage st;
    public void Clicked(){
//        Leaderboard.main(new String[]{});

    }
    public void leaderboard() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Leaderboard.fxml"));
        Scene Lb = new Scene(root, 400,800);
        Stage stage = (Stage) Start.getScene().getWindow();
        stage.setScene(Lb);

    }

}
