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
import java.util.Collection;

public class mainController {
    public Button addIncomeBtn, addExpenseBtn;
    public Label incomeLbl, expenseLbl, balanceLbl;
    public TableColumn<Transaction, LocalDate> dateTC;
    public TableColumn<Transaction, Type> typeTC;
    public TableColumn<Transaction, Category> categoryTC;
    public TableColumn<Transaction, Double> amountTC;
    public TableView<Transaction> transactionTV;

    private ObservableList<Transaction> transactionList = FXCollections.observableArrayList();

    public void initialize() {
        dateTC.setCellValueFactory(new PropertyValueFactory<>("Date"));
        typeTC.setCellValueFactory(new PropertyValueFactory<>("Type"));
        amountTC.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        categoryTC.setCellValueFactory(new PropertyValueFactory<>("Category"));

        transactionTV.setItems(transactionList);
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

    public void passTransaction(Type type, double amount, LocalDate localDate, Category category, String note) {
        for (int i = 0; i < 1; i++) {
            Transaction transaction;
            if (type.equals(Type.Expense)) {
                transaction = new Transaction(Type.Expense, localDate, category, amount, note);
            } else {
                transaction = new Transaction(Type.Income, localDate, category, amount, note);
            }
            transactionList.add(transaction);
        }
    }
}
