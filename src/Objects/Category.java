package Objects;

public enum Category {
    Entertainment("Entertainment"),
    Food_Drink("Food and Drink"),
    Shopping("Shopping"),
    Bills("Bills"),
    Health("Health and Wellbeing"),
    Transport("Transport"),
    Gifts_E("Gifts"),
    Family("Family"),
    Education("Education"),
    Misc_E("Misc"),

    Balance("Balance"),
    Salary("Salary"),
    Gifts_I("Gifts"),
    Interest("Interest"),
    Selling("Selling"),
    Misc_I("Misc");

    private String category;

    Category(String category) {
        this.category = category;
    }

    public String category() {
        return category;
    }

    @Override
    public String toString() {
        return category;
    }
}

