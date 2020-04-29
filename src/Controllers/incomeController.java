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

public class incomeController {

    public TextField amountTF;
    public ComboBox<Category> categoryCB;
    public Button confirmIncome;
    public DatePicker dateDP;
    public TextArea noteTA;
    public Button cancelIncomeBtn;

    private ObservableList<Category> incomeList = FXCollections.observableArrayList();

    public void initialize() {
        incomeList.addAll(Category.Balance,Category.Salary,Category.Gifts_I,
                Category.Interest,Category.Selling,Category.Misc_I);

        categoryCB.setItems(incomeList);
    }

    public void confirmIncomeClicked() throws IOException {
        try {
            double amount = Double.parseDouble(amountTF.getText());
            LocalDate localDate = dateDP.getValue();
            String category = categoryCB.getSelectionModel().getSelectedItem().toString();
            String note = noteTA.getText();

            if (amount <= 0) {
                throw new IllegalArgumentException("Please enter a positive number");
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm Transaction");
                alert.setHeaderText("Are you sure about this payment?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    Window newWindow = confirmIncome.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("../FXML/activity_main.fxml"));
                    Parent root = loader.load();
                    mainController main = loader.getController();
                    Locale locale = new Locale("en", "GB");
                    NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
                    main.lblIncomeTotal.setText(cf.format(amount));
                    main.passIncome(amount, localDate, category, note);
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
