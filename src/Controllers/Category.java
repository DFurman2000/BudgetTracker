package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class Category {
    public Button confirmCategoryBtn;

    public void confirmCategoryBtnClicked(ActionEvent actionEvent) throws IOException {
        Window categoryWindow = confirmCategoryBtn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../FXML/activity_transaction.fxml"));
        Parent root = loader.load();
        Transaction transaction = loader.getController();
        categoryWindow.getScene().setRoot(root);
    }
}
