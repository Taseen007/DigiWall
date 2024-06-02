import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoanFrame extends JFrame{
    private JButton jButton3;;
    private JLabel jLabel1, jLabel2, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel3;
    private JPanel jPanel1, jPanel2, jPanel3;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField jTextField1;
    private com.toedter.calendar.JDateChooser jDateChooser1,jDateChooser2;
    private JTextField textField1;
    private List<Loan> Loans;

    public LoanFrame() {
        Loans = new ArrayList<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser1.setDate(new Date());
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
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

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new Color(51, 153, 255));

        jPanel2.setBackground(new Color(102, 204, 255));

        jLabel1.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ADD LOANS");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addGap(248, 248, 248))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        );

        jLabel2.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Loan Date :-");

        jLabel3.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Return Date:-");

        textField1.setText("");

        jLabel5.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Amount:-");

        jLabel6.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("From:-");

        jTextField1.setText("");
        jDateChooser2.setDate(new Date());
        jButton3.setText("Add");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    addLoan(evt);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                clearFields();
                loadLoans();
                jLabel8.setText(Double.toString(BudgetManager.totalLoan()));
                Repository.refresh();
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
                                                .addComponent(jDateChooser1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                                .addGap(34, 34, 34)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jDateChooser2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jButton3)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                                        .addComponent(jLabel6))
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addGap(3, 3, 3))
                                                        .addComponent(jDateChooser1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textField1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jDateChooser2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
        );

        jPanel3.setBackground(new Color(153, 255, 255));

        jTable1.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "From", "Loan Date", "Return Date", "Amount"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Expenses: ");

        jLabel4.setFont(new Font("Segoe UI", 1, 14));
        jLabel4.setText("Loans: ");
        jLabel7.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Total Loan:-");

        jLabel8.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText(Double.toString(BudgetManager.totalLoan()));

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
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
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
        loadLoans();
    }

    private void addLoan(ActionEvent evt) {
        try {
            Date gd = jDateChooser2.getDate();
            Date d= jDateChooser1.getDate();
            SimpleDateFormat dateform= new SimpleDateFormat("dd/MM/YY");
            String loandate= dateform.format(gd);
            String returnDate= dateform.format(d);
            String description = jTextField1.getText();
            String amountStr = textField1.getText();

            double amount = Double.parseDouble(amountStr);
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be positive.");
            }

            Loan Loan = new Loan(description, amount ,loandate, returnDate);
            Loans.add(Loan);
            savetoFileLoan();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid amount. Please enter a numeric value.");
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred.", e);
        }
    }

    public void savetoFileLoan()
    {
        try(PrintWriter writer=new PrintWriter(new BufferedWriter(new FileWriter("Loan.txt",true)))){
            Loan Loan= Loans.get(Loans.size()-1);
            writer.println(Loan.getDescription()+", "+Loan.getDate()+", "+Loan.getReturnDate()+", "+Loan.getAmount());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    public void clearFields()
    {
        jTextField1.setText("");
        textField1.setText("");
        jDateChooser2.setDate(new Date());
        jDateChooser1.setDate(new Date());
    }
    public void loadLoans() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing data

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Loan.txt"))) {
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
