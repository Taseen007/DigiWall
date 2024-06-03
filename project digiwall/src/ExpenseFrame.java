
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.text.*;

public class ExpenseFrame extends JFrame {
    private JButton jButton3;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1, jLabel2, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel3;
    private JPanel jPanel1, jPanel2, jPanel3;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField jTextField1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private JTextField textField1;
    private List<Expense> expenses;

    public ExpenseFrame() {
        expenses = new ArrayList<>();
        jDateChooser1 = new JDateChooser();
        jDateChooser1.setDate(new Date());
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jComboBox1 = new JComboBox<>();
        jLabel3 = new JLabel();
        textField1 = new JTextField();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jTextField1 = new JTextField();
        jButton3 = new JButton();
        jPanel3 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jLabel4 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();

        setTitle("Expenses");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new Color(51, 153, 255));

        jPanel2.setBackground(new Color(102, 204, 255));

        jLabel1.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ADD EXPENSES");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(224, 224, 224)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        );

        jLabel2.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Category :-");
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"", "Food", "Clothes", "Accessories", "Travel", "Fees", "Study", "Miscellaneous","Loan Return"}));
        jLabel3.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Date:-");
        textField1.setText("");
        jLabel5.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Amount:-");

        jLabel6.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Description :-");

        jTextField1.setText("");

        jButton3.setText("Add");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    String category = (String) jComboBox1.getSelectedItem();
                    Date d= jDateChooser1.getDate();
                    SimpleDateFormat dateform= new SimpleDateFormat("dd/MM/YY");
                    String date= dateform.format(d);
                    String description = jTextField1.getText();
                    double amount = Double.parseDouble(textField1.getText());
                    if(BudgetManager.totalExpense()>(BudgetManager.totalIncome()+BudgetManager.totalLoan()))
                    {
                        throw new IllegalArgumentException("You Do Not Have Sufficient Balance");
                    }
                    if (category == null || category.isEmpty()) {
                        throw new IllegalArgumentException("Category cannot be empty");
                    }
                    if (description.isEmpty()) {
                        throw new IllegalArgumentException("Description cannot be empty");
                    }

                    Expense expense = new Expense(category, amount, date, description);
                    expenses.add(expense);
                    savetoFileexpense();
                    clearFields();
                    loadExpenses();
                    jLabel8.setText(Double.toString(BudgetManager.totalExpense()));
                    if(BudgetManager.TodaysExpense()>=Double.parseDouble(BudgetManager.Budget()))
                    {
                        JOptionPane.showMessageDialog(new JFrame(),"You are exceeding Budget","Alert",JOptionPane.WARNING_MESSAGE);
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jDateChooser1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                                .addGap(21, 21, 21))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButton3)
                                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel6)
                                                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 574, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jDateChooser1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel2)
                                                                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(textField1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
        );

        jPanel3.setBackground(new Color(153, 255, 255));

        jTable1.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Category", "Date", "Description", "Amount"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Expenses: ");

        jLabel7.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Total Expense:-");
        jLabel8.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText(Double.toString(BudgetManager.totalExpense()));
        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                .addGap(98, 98, 98)))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        loadExpenses();
    }
    public void savetoFileexpense() {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("Expense.txt", true)))) {
            Expense expense = expenses.get(expenses.size() - 1);
            writer.println(expense.getCatagory() + ", " + expense.getDate() + ", " + expense.getDescription() + ", " + expense.getAmount());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearFields() {
        jTextField1.setText("");
        textField1.setText("");
        jDateChooser1.setDate(new Date());
        jComboBox1.setSelectedItem(1);
    }

    public void loadExpenses() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing data

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Expense.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(", ");
                model.addRow(data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}