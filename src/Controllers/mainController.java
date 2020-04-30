package Controllers;

import Objects.Category;
import Objects.Transaction;
import Objects.Type;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;

import java.time.LocalDate;
import java.util.ArrayList;

public class mainController {
    public Button addIncomeBtn, addExpenseBtn;
    public Label incomeLbl, expenseLbl, balanceLbl;
    public Label lblExpensesTotal;
    public Label lblIncomeTotal;
    public ListView<Transaction> transactionLV;
    public Transaction e, i;


    private ObservableList<Transaction> t = FXCollections.observableArrayList();


    public void initialize() {
        transactionLV.setItems(t);
    }

    public void addIncomeBtnClicked() {
        try {
            Window mainWindow = addIncomeBtn.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../FXML/activity_income.fxml"));
            Parent root = loader.load();
            incomeController income = loader.getController();
            mainWindow.getScene().setRoot(root);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addExpenseBtnClicked() {
        try {
            Window newWindow = addExpenseBtn.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../FXML/activity_expense.fxml"));
            Parent root = loader.load();
            expenseController expense = loader.getController();

            newWindow.getScene().setRoot(root);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void passExpense(double amount, LocalDate localDate, Category category, String note) {
        Transaction transaction = new Transaction(Type.Expense, localDate, category, amount, note);
        t.addAll(transaction);
    }

    public void passIncome(double amount, LocalDate localDate, Category category, String note) {
        Transaction transaction = new Transaction(Type.Income, localDate, category, amount, note);
        t.addAll(transaction);
    }

}