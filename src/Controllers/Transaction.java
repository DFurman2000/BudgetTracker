package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Transaction {
    public Button confirmTransactionBtn;

    public void confirmTransactionBtnClicked(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../FXML/activity_main.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void IncomebtnClick(ActionEvent actionEvent) {

    }

    public void ExpensebtnClick(ActionEvent actionEvent) {
    }

    public void CategorybtnClick(ActionEvent actionEvent) {
    }

}
