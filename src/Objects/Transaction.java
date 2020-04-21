package Objects;

import java.util.Date;

public class Transaction {

    private Type type;
    private Date date;
    private Double amount;
    private String note;

    public Transaction(Type type, Date date, Double amount, String note) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.note = note;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
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

    public String toString() {
        return " Date: " + date + " Amount: £" + amount + " Type: " + type + " Note: " + note;
    }
}
