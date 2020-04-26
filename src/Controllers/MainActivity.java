package Controllers;

import Objects.Type;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    public void initialize() {
        changeText();
        dateTC.setCellValueFactory(new PropertyValueFactory<>("Date"));
        typeTC.setCellValueFactory(new PropertyValueFactory<>("Type"));
        amountTC.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        noteTC.setCellValueFactory(new PropertyValueFactory<>("Note"));
    }

    public void changeText() {
        // This method wraps text in the note column rather than it all being on one line.
        noteTC.setCellFactory(noteTC -> {
            TableCell<Transaction, String> cell = new TableCell<>();
            Text text = new Text();
            cell.setGraphic(text);
            cell.setPrefHeight(Region.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(noteTC.widthProperty());
            text.textProperty().bind(cell.itemProperty());
            return cell;
        });
    }

    public void addTransactionBtnClicked(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../FXML/activity_transaction.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        ((Stage)addTransactionBtn.getScene().getWindow()).close();
    }
}