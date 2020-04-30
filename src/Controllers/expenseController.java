package Controllers;

import Objects.Category;
import Objects.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Window;

import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Optional;

public class expenseController {

    public TextField amountTF;
    public ComboBox<Category> categoryCB;
    public Button confirmExpense;
    public DatePicker dateDP;
    public TextArea noteTA;
    public Button cancelExpenseBtn;

    private ObservableList<Category> expenseList = FXCollections.observableArrayList();

    public void initialize() {
        expenseList.addAll(Category.Entertainment,Category.Food_Drink,Category.Shopping,Category.Bills,Category.Health,
                Category.Transport,Category.Gifts_E,Category.Family,Category.Education,Category.Misc_E);

        categoryCB.setItems(expenseList);
    }

    public void confirmExpenseClicked() throws IOException {
        try {
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
                if (result.get() == ButtonType.OK) {
                    Window newWindow = confirmExpense.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("../FXML/activity_main.fxml"));
                    Parent root = loader.load();
                    mainController main = loader.getController();
                    Locale locale = new Locale("en", "GB");
                    NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
                    main.lblExpensesTotal.setText(cf.format(amount));
//                    main.passExpense(amount, localDate, category, note);

                    newWindow.getScene().setRoot(root);
                }
            }
        } catch (Exception e) {
            Alert error = new Alert(Alert.AlertType.ERROR, "Please add the correct transaction details", ButtonType.OK);
            error.showAndWait();
        }
    }

    public void cancelExpenseClicked() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancel Transaction");
        alert.setHeaderText("Are you sure about cancelling this transaction?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.get() == ButtonType.OK) {
            Window newWindow = cancelExpenseBtn.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../FXML/activity_main.fxml"));
            Parent root = loader.load();
            newWindow.getScene().setRoot(root);
        }
    }
}