package Controllers;

import Objects.Type;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

public class Transaction {
    public Button confirmTransactionBtn, selectCategoryBtn;
    public ChoiceBox<Type> typeCB;
    public DatePicker dateDP;
    public TextField amountTF;
    public TextArea noteTA;


    public void initialize() {
        typeCB.getItems().addAll(Type.Income, Type.Expense);
    }

    public void confirmTransactionBtnClicked(javafx.event.ActionEvent actionEvent) throws IOException {
        Window mainWindow = confirmTransactionBtn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../FXML/activity_main.fxml"));
        Parent root = loader.load();
        MainActivity mainActivity = loader.getController();
        mainWindow.getScene().setRoot(root);
    }

    public void selectCategoryBtnClicked(javafx.event.ActionEvent actionEvent) throws IOException {
        Window categoryWindow = selectCategoryBtn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../FXML/activity_category.fxml"));
        Parent root = loader.load();
        Category category = loader.getController();
        categoryWindow.getScene().setRoot(root);
    }
}
