import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.io.*;

import static java.time.temporal.ChronoUnit.DAYS;

public class BudgetManager {
    public BudgetManager(){}

    public static double totalIncome(){
        double totalIncome =0;
        try(BufferedReader bf= new BufferedReader(new FileReader("Income.txt")))
        {
            while(bf.ready())
            {
                String line= bf.readLine();
                String str[]= line.split(",");
                String checker= str[1];
                SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/YY");
                String date = dateFormat.format(new Date());
                if(checker.charAt(4)==date.charAt(3) && checker.charAt(5)==date.charAt(4))
                {
                    totalIncome+= Double.parseDouble(str[3]);
                }
            }
    }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
        return totalIncome;
    }

    public static double totalExpense()
    {
        double totalExpense= 0;
        try(BufferedReader bf= new BufferedReader(new FileReader("Expense.txt")))
        {
            while(bf.ready())
            {
                String line= bf.readLine();
                String str[]= line.split(",");
                String checker= str[1];
                SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/YY");
                String date = dateFormat.format(new Date());
                if(checker.charAt(4) == date.charAt(3)&&checker.charAt(5)==date.charAt(4))
                {
                    totalExpense+= Double.parseDouble(str[03]);
                }
            }
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }

        return totalExpense;
    }
    public static double TodaysExpense()
    {
        double TodaysExpense=0;
        try(BufferedReader bf= new BufferedReader(new FileReader("Expense.txt")))
        {
            while(bf.ready())
            {
                String line= bf.readLine();
                String str[]= line.split(",");
                String checker= str[1];
                SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/YY");
                String date = dateFormat.format(new Date());
                if(checker.charAt(01)==date.charAt(00)&&checker.charAt(02)==date.charAt(01)&&checker.charAt(4) == date.charAt(3)&&checker.charAt(5)==date.charAt(4))
                {
                        TodaysExpense += Double.parseDouble(str[03]);
                }
            }
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }

        return TodaysExpense;
    }
    public static String Budget()
    {
        double x=   totalIncome()+TodaysExpense()-totalExpense();
        LocalDate today = LocalDate.now();
        LocalDate endOfMonth = today.withDayOfMonth(today.lengthOfMonth());
        long daysBetween = DAYS.between(today, endOfMonth);
        Double budget = Math.ceil(x/daysBetween);
        return Double.toString(budget);

    }
    public static double totalLoan()
    {
        double totalLoan =0;
        try(BufferedReader bf= new BufferedReader(new FileReader("Loan.txt")))
        {
            while(bf.ready())
            {
                String line= bf.readLine();
                String str[]= line.split(",");
                String checker= str[1];
                SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/YY");
                String date = dateFormat.format(new Date());
                if(checker.charAt(4)==date.charAt(3) && checker.charAt(5)==date.charAt(4))
                {
                    totalLoan+= Double.parseDouble(str[3]);
                }
            }
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
        return totalLoan;
    }
}
