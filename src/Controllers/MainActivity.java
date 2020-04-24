package Controllers;

import Objects.Type;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class MainActivity {
    public Button addTransactionBtn;
    public TableView<Transaction> transactionTV;
    public TableColumn<Transaction, Date> dateTC;
    public TableColumn<Transaction, Type> typeTC;
    public TableColumn<Transaction, Double> amountTC;
    public TableColumn<Transaction, String> noteTC;
    public Label incomeLbl;
    public Label expenseLbl;
    public Label balanceLbl;



    public void initialize() {
       try{
        changeText();
        dateTC.setCellValueFactory(new PropertyValueFactory<>("Date"));
        typeTC.setCellValueFactory(new PropertyValueFactory<>("Type"));
        amountTC.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        noteTC.setCellValueFactory(new PropertyValueFactory<>("Note"));
    } catch (NullPointerException e) {
        Alert alert = new Alert(Alert.AlertType.NONE,
                " ", ButtonType.OK);
        alert.showAndWait();

    }
    }


    public void changeText() {
        // This method wraps text in the note column rather than it all being on one line.
       try{
        noteTC.setCellFactory(noteTC -> {
            TableCell<Transaction, String> cell = new TableCell<>();
            Text text = new Text();
            cell.setGraphic(text);
            cell.setPrefHeight(Region.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(noteTC.widthProperty());
            text.textProperty().bind(cell.itemProperty());
            return cell;
        });
    } catch (NullPointerException e) {
        Alert alert = new Alert(Alert.AlertType.NONE,
                " ", ButtonType.OK);
        alert.showAndWait();

    }
    }

    public void addTransactionBtnClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/activity_transaction.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        ((Stage)addTransactionBtn.getScene().getWindow()).close();


    }

}