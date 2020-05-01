package Objects;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Transaction implements Serializable {

    private Type type;
    private LocalDate date;
    private Category category;
    private Double amount;
    private String note;
    private DecimalFormat df = new DecimalFormat("0.00");

    public Transaction(Type type, LocalDate date, Category category, Double amount, String note) {
        this.type = type;
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.note = note;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getAmount() {
        return Double.parseDouble(df.format(amount));
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    Locale locale = new Locale("en", "GB");
    NumberFormat cf = NumberFormat.getCurrencyInstance(locale);


    public String toString() {
        return "Type: " + type + ",    Date: " + date + ",    Amount: "  + cf.format(amount) + ",    Category: " + category;
    }
}
