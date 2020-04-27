package Controllers;

import Objects.Type;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

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
//        typeCB.getItems().addAll(Type.Income, Type.Expense);

    }

    public void confirmTransactionBtnClicked(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../FXML/activity_main.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        ((Stage) confirmTransactionBtn.getScene().getWindow()).close();
    }


    public void selectCategoryBtnClicked(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../FXML/activity_category.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
