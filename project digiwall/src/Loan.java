public class Loan extends Transactions{
    private String returnDate;
    Loan(String from, double amount, String date, String returnDate)
    {
        super(amount,date,from);
        this.returnDate= returnDate;
    }

    public String getReturnDate() {
        return returnDate;
    }
}