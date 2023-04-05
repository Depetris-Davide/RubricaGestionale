package rubricagestionale;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MenuPanel extends JPanel {

    private JPanel panel;

    private AddContactPanel addContactPanel;

    private RemoveContactPanel removeContactPanel;

    private ShowContactsPanel showContactsPanel;

    private JButton addContact;

    private JButton removeContact;

    private JButton showContacts;

    private JLabel directory;

    private JLabel credits;

    public MenuPanel() throws IOException {
        panel = this;
        this.setBounds(0, 0, 400, 600);
        this.setLayout(null);

        addContactPanel = new AddContactPanel();

        directory = new JLabel("Directory");
        directory.setBounds(75, 30, 300, 50);
        directory.setFont(new Font("Engravers MT", Font.PLAIN, 30));
        this.add(directory);

        credits = new JLabel("Credits: Depetris Davide");
        credits.setBounds(20, 500, 200, 50);
        credits.setFont(new Font("Georgia", Font.PLAIN, 10));
        panel.add(credits);

        addContact = new JButton("Add Contact");
        addContact.setBounds(95, 130, 200, 50);
        addContact.setFont(new Font("Georgia", Font.PLAIN, 13));
        addContact.setFocusPainted(false);
        addContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent E) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                frame.getContentPane().add(addContactPanel);
                frame.setTitle("Directory - Add Contact");

                panel.setVisible(false);

                addContactPanel.setVisible(true);
            }
        });
        this.add(addContact);

        removeContact = new JButton("Remove Contact");
        removeContact.setBounds(90, 230, 200, 50);
        removeContact.setFont(new Font("Georgia", Font.PLAIN, 13));
        removeContact.setFocusPainted(false);
        removeContact.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent E) {
                try {
                    removeContactPanel = new RemoveContactPanel();

                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                    frame.setTitle("Directory - Remove Contact");
                    frame.getContentPane().add(removeContactPanel);

                    panel.setVisible(false);
                } catch (IOException ex) {
                }
            }
        });
        this.add(removeContact);

        showContacts = new JButton("Show Contacts");
        showContacts.setBounds(90, 330, 200, 50);
        showContacts.setFont(new Font("Georgia", Font.PLAIN, 13));
        showContacts.setFocusPainted(false);
        showContacts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent E) {
                try {
                    showContactsPanel = new ShowContactsPanel();

                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                    frame.setTitle("Directory - Show Contacts");
                    frame.getContentPane().add(showContactsPanel);

                    panel.setVisible(false);

                    showContactsPanel.setVisible(true);
                } catch (IOException ex) {
                }
            }
        });
        this.add(showContacts);
    }

}
