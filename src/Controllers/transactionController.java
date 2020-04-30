package Controllers;

import Objects.Category;
import Objects.Type;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Window;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Optional;

public class transactionController {

    public TextField amountTF;
    public ComboBox<Category> categoryCB;
    public Button confirmTransaction;
    public DatePicker dateDP;
    public TextArea noteTA;
    public Button cancelTransactionBtn;
    public ComboBox<Type> TypeCB;
    public Button cancelIncomeBtn;
    public Button confirmIncome;

    private ObservableList<Category> incomeList = FXCollections.observableArrayList();
    private ObservableList<Type> select = FXCollections.observableArrayList();
    private ObservableList<Category> expenseList = FXCollections.observableArrayList();
    private DecimalFormat df = new DecimalFormat("0.00");

    public void initialize() {
        select.addAll(Type.Income, Type.Expense);
        TypeCB.setItems(select);

    }

    public void AddSelectType(ActionEvent actionEvent) {
        int SelectTypeSelectionNumber = TypeCB.getSelectionModel().getSelectedIndex();
        if (SelectTypeSelectionNumber == 0){
            incomeList.addAll(Category.Balance,Category.Salary,Category.Gifts_I,
                    Category.Interest,Category.Selling,Category.Misc_I);
            categoryCB.setItems(incomeList);

        } else if (SelectTypeSelectionNumber == 1){
            expenseList.addAll(Category.Entertainment,Category.Food_Drink,Category.Shopping,Category.Bills,Category.Health,
                    Category.Transport,Category.Gifts_E,Category.Family,Category.Education,Category.Misc_E);
            categoryCB.setItems(expenseList);

        }

    }
    public void confirmIncomeClicked() throws IOException {
        try {
            Type type = TypeCB.getSelectionModel().getSelectedItem();
            double amount = Double.parseDouble(amountTF.getText());
            LocalDate localDate = dateDP.getValue();
            Category category = categoryCB.getSelectionModel().getSelectedItem();
            String note = noteTA.getText();

            if (amount <= 0) {
                throw new IllegalArgumentException("Please enter a positive number");
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm Transaction");
                alert.setHeaderText("Are you sure about this payment?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get()== ButtonType.OK) {
                    Window newWindow = confirmIncome.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("../FXML/activity_main.fxml"));
                    Parent root = loader.load();
                    mainController main = loader.getController();
                    main.passTransaction(type, amount, localDate, category, note);
                    newWindow.getScene().setRoot(root);
                }
            }
        } catch (Exception e) {
            Alert error = new Alert(Alert.AlertType.ERROR, "Please add the correct transaction details", ButtonType.OK);
            error.showAndWait();
        }
    }

    public void cancelIncomeClicked() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancel Transaction");
        alert.setHeaderText("Are you sure about cancelling this transaction?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.get() == ButtonType.OK) {
            Window newWindow = cancelIncomeBtn.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../FXML/activity_main.fxml"));
            Parent root = loader.load();
            newWindow.getScene().setRoot(root);
        }
    }





}

