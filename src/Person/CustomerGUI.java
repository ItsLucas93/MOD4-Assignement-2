package Person;

import javax.swing.*;
import java.awt.event.*;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class CustomerGUI extends JFrame {

    private JButton button;
    
    public CustomerGUI(){
        createPanel();
    }

    public void createPanel(){
        setTitle("Customer List");

        setSize(200, 800);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        panel2.add(new JLabel("Customers"));
        for (PreferredCustomer cust : PreferredCustomer.Customers) {
            JPanel panel = new JPanel();
            JButton button2;
            JLabel spend, reduc;
            //panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(new JLabel("ID: "+cust.getCustomerNumber()));
            panel.add(new JLabel("Name: "+cust.getName()));
            panel.add(new JLabel("Address: "+cust.getAddress()));
            panel.add(new JLabel("Phone: "+cust.getPhone()));
            panel.add(new JLabel("Mailing: "+cust.getMailingList()));
            panel.add(spend = new JLabel("Spending: "+cust.getPurchaseTotal()));
            panel.add(reduc = new JLabel("Reduction: "+cust.getReduction()));

            panel.add(button2 = new JButton("Add Money (+100)"));
            button2.addActionListener(new ActionListener(){ 
                public void actionPerformed(ActionEvent e){
                    cust.setPurchasePrice(100);
                    spend.setText("Spending: "+cust.getPurchaseTotal());
                    reduc.setText("Reduction: "+cust.getReduction());
                }
            });
            panel2.add(panel);

        }

        add(panel2);

        setVisible(true);
    }
}
