
import java.util.*;
    public abstract class Transactions {
        private String description;
        private double amount;
        private String date;

        Transactions(double amount, String date, String description)
        {
            this.amount=amount;
            this.date=date;
            this.description=description;
        }
        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

