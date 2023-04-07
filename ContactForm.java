import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {

    JTextField name_field, email_field;
    JRadioButton male, female;
    JCheckBox check;

    public ContactForm() {

        super("My First Java App"); //tittle app
        super.setBounds(200, 100, 350, 300); //px frame
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //"x" to close

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(5, 2, 2, 10)); //menge cols and rows in window

        JLabel name = new JLabel("Enter your name: ");
        JTextField name_field = new JTextField("", 1);
        JLabel email = new JLabel("Enter your emain: ");
        JTextField email_field = new JTextField("@", 1);

        // add button
        container.add(name);
        container.add(name_field);
        container.add(email);
        container.add(email_field);

        // add text to button
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        JCheckBox check = new JCheckBox("Enter", false);
        JButton send_button = new JButton("Send");

        male.setSelected(true);
        container.add(male);
        container.add(female);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        container.add(check);
        container.add(send_button);

        //action buttons
        send_button.addActionListener(new ButtonEventManager());

    }

    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String name = name_field.getText();
            String email = email_field.getText();

            String isMale = "Male";
            if(!male.isSelected())
                isMale = "Female";

            boolean checkBox = check.isSelected();


            // window show mess.
            JOptionPane.showMessageDialog(null, "Your email: " + email +
                    "\nYour sex: " + isMale + "\nConfirm?" + checkBox, "Moin, " + name +
                    "!", JOptionPane.PLAIN_MESSAGE);
        }
    }

}




