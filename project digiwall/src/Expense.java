import java.util.*;
class Expense extends Transactions {
    private String category;

    public Expense(String category, double amount, String date, String description) {
        super(amount, date, description);
        this.category = category;
    }

    public String getCatagory() {
        return category;
    }
}