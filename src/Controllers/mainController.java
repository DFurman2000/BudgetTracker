package Controllers;

import Objects.Category;
import Objects.Transaction;
import Objects.Type;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class mainController {
    public Label expenseLbl, balanceLbl;
    public Label lblExpensesTotal;
    public Label lblIncomeTotal;
    public ListView<Transaction> transactionLV;
    public Button addTransactionBtn, viewDetailsBtn;
    public MenuItem closeBtn;


    ArrayList<Transaction> E = new ArrayList<>();
    private ObservableList<Transaction> t = FXCollections.observableArrayList(E);

    Locale locale = new Locale("en", "GB");
    NumberFormat cf = NumberFormat.getCurrencyInstance(locale);

    public void initialize() {
        transactionLV.setItems(t);
    }

    public void addTransactionBtnClicked(ActionEvent actionEvent) {
        try {
            Window mainWindow = addTransactionBtn.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../FXML/activity_transaction.fxml"));
            Parent root = loader.load();
            transactionController transaction = loader.getController();
            mainWindow.getScene().setRoot(root);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void passTransaction(Type type, double amount, LocalDate localDate, Category category, String note) {
        Transaction transaction = new Transaction(type, localDate, category, amount, note);
        t.addAll(transaction);
        if (type == Type.Expense) {
            lblExpensesTotal.setText(String.valueOf(cf.format(amount)));
        } else {
            lblIncomeTotal.setText(String.valueOf(cf.format(amount)));
        }
    }

    public void viewDetails() {
        try {
            Transaction t = transactionLV.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Payment Details");
            alert.setHeaderText("Information about your Payment");
            alert.setContentText("Type: " + t.getType() + "\n" + "Amount: £" + t.getAmount() + "\n" + "Date of Transaction: "
                    + t.getDate() + "\n" + "Category: " + t.getCategory() + "\n" + "Note: " + t.getNote());
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a payment", ButtonType.OK);
            alert.showAndWait();
        }
    }

    public void closeBtnClicked(ActionEvent actionEvent) {
        ((Stage)viewDetailsBtn.getScene().getWindow()).close();

    }
}