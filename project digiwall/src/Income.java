
    import java.util.*;

    public class Income extends Transactions {
        private String Frequency;

        Income(String Frequency,double amount, String date, String description)
        {
            super(amount,date,description);
            this.Frequency= Frequency;
        }

        public String getFrequency() {
            return Frequency;
        }

        public void setFrequency(String frequency) {
            Frequency = frequency;
        }

    }
