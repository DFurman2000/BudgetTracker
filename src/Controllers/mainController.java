package Controllers;

import Objects.Category;
import Objects.Transaction;
import Objects.Type;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Window;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class mainController {
    public Button addTransactionBtn, viewPaymentBtn;
    public Label incomeLbl, expenseLbl, balanceLbl;
    public Label lblExpensesTotal;
    public Label lblIncomeTotal;
    public ListView<Transaction> transactionLV;
    public Transaction e, i;

    ArrayList<Transaction> E = new ArrayList<>();
    private ObservableList<Transaction> t = FXCollections.observableArrayList(E);
    private DecimalFormat df = new DecimalFormat("0.00");

    public void initialize() {
        transactionLV.setItems(t);
    }

    public void addTransactionBtnClicked() {
        try {
            Window mainWindow = addTransactionBtn.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../FXML/activity_transaction.fxml"));
            Parent root = loader.load();
            transactionController transaction = loader.getController();
            mainWindow.getScene().setRoot(root);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.showAndWait();
        }
    }


    public void passTransaction(Type type, double amount, LocalDate localDate, Category category, String note) {
        Transaction transaction = new Transaction(type, localDate, category, amount, note);
        t.addAll(transaction);
        if (type == Type.Expense) {
            lblExpensesTotal.setText("Income: £" + String.valueOf(df.format(amount)));
        } else {
            lblIncomeTotal.setText("Income: " + String.valueOf(df.format(amount)));
        }
    }

    public void viewPayment() {
        try {
            Transaction t = transactionLV.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Payment Details");
            alert.setHeaderText("Information about a Payment");
            alert.setContentText("Type: " + t.getType() + "\n" + "Amount: £" + t.getAmount() + "\n" + "Date of Transaction: "
                    + t.getDate() + "\n" + "Category: " + t.getCategory() + "\n" + "Note: " + t.getNote());
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a payment", ButtonType.OK);
            alert.showAndWait();
        }
    }
}