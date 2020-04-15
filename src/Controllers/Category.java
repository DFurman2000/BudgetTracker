package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class Category {
    public Button confirmCategoryBtn;
    public ListView<String> categoryLV;


    public void confirmCategoryBtnClicked(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../FXML/activity_category.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        ((Stage) confirmCategoryBtn.getScene().getWindow()).close();
    }


    ObservableList<String> categories = FXCollections.observableArrayList();

}