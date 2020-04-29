package Controllers;

import Objects.Category;
import Objects.Transaction;
import Objects.Type;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;

import java.time.LocalDate;

public class mainController {
    public Button addIncomeBtn, addExpenseBtn;
    public Label incomeLbl, expenseLbl, balanceLbl;
    public TableColumn<Transaction, LocalDate> dateTC;
    public TableColumn<Transaction, Type> typeTC;
    public TableColumn<Transaction, Category> categoryTC;
    public TableColumn<Transaction, Double> amountTC;
    public TableView<Transaction> transactionTV;
    public Label lblExpensesTotal;
    public Label lblIncomeTotal;



    public void initialize() {
        dateTC.setCellValueFactory(new PropertyValueFactory<>("Date"));
        typeTC.setCellValueFactory(new PropertyValueFactory<>("Type"));
        amountTC.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        categoryTC.setCellValueFactory(new PropertyValueFactory<>("Category"));
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

    public void passExpense(double amount, LocalDate localDate, String category, String note) {

    }

    public void passIncome(double amount, LocalDate localDate, String category, String note) {
    }
}
