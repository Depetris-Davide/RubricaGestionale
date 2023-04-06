package rubricagestionale;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import javax.swing.*;

public class AddContactPanel extends JPanel {

    private JPanel panel;

    private JLabel directory;

    private JLabel credits;

    private JLabel name;

    private JLabel surname;

    private JLabel telephone;

    private JTextField nameIn;

    private JTextField surnameIn;

    private JTextField telephoneIn;

    private JButton add;

    private JButton back;

    public AddContactPanel() {
        panel = this;
        this.setBounds(0, 0, 400, 600);
        this.setLayout(null);

        directory = new JLabel("Directory");
        directory.setBounds(75, 30, 300, 50);
        directory.setFont(new Font("Engravers MT", Font.PLAIN, 30));
        this.add(directory);

        credits = new JLabel("Credits: Depetris Davide");
        credits.setBounds(20, 500, 200, 50);
        credits.setFont(new Font("Georgia", Font.PLAIN, 10));
        this.add(credits);

        name = new JLabel("Name:");
        name.setBounds(50, 130, 200, 50);
        name.setFont(new Font("Georgia", Font.PLAIN, 15));
        this.add(name);

        surname = new JLabel("Surname:");
        surname.setBounds(50, 230, 200, 50);
        surname.setFont(new Font("Georgia", Font.PLAIN, 15));
        this.add(surname);

        telephone = new JLabel("Telephone:");
        telephone.setBounds(50, 330, 200, 50);
        telephone.setFont(new Font("Georgia", Font.PLAIN, 15));
        this.add(telephone);

        nameIn = new JTextField();
        nameIn.setBounds(130, 140, 200, 30);
        nameIn.setFont(new Font("Georgia", Font.PLAIN, 15));
        this.add(nameIn);

        surnameIn = new JTextField();
        surnameIn.setBounds(130, 240, 200, 30);
        surnameIn.setFont(new Font("Georgia", Font.PLAIN, 15));
        this.add(surnameIn);

        telephoneIn = new JTextField();
        telephoneIn.setBounds(130, 340, 200, 30);
        telephoneIn.setFont(new Font("Georgia", Font.PLAIN, 15));
        this.add(telephoneIn);

        add = new JButton("Add");
        add.setBounds(90, 420, 100, 30);
        add.setFont(new Font("Georgia", Font.PLAIN, 13));
        add.setFocusPainted(false);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent E) {
                try {
                    FileWriter fileout = new FileWriter("directory.txt", true);
                    fileout.write(nameIn.getText() + ";" + surnameIn.getText() + ";" + telephoneIn.getText() + "\n");
                    fileout.close();

                    LinkedList<String> lines = new LinkedList<String>();

                    try ( BufferedReader reader = new BufferedReader(new FileReader("directory.txt"))) {
                        String line;

                        while ((line = reader.readLine()) != null) {
                            lines.add(line);
                        }

                    }

                    Collections.sort(lines, new Comparator<String>() {
                        public int compare(String o1, String o2) {
                            String name1 = o1.split(";")[0];

                            String name2 = o2.split(";")[0];

                            return name1.compareTo(name2);
                        }

                    });

                    try ( FileWriter writer = new FileWriter("directory.txt")) {
                        for (String line : lines) {
                            writer.write(line + "\n");
                        }
                    }

                    nameIn.setText("");

                    surnameIn.setText("");

                    telephoneIn.setText("");

                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                    frame.setTitle("Directory - Menu");

                    MenuPanel menuPanel = (MenuPanel) frame.getContentPane().getComponent(0);

                    menuPanel.setVisible(true);

                    panel.setVisible(false);
                } catch (IOException ex) {
                }
            }
        });
        this.add(add);

        back = new JButton("Back");
        back.setBounds(200, 420, 100, 30);
        back.setFont(new Font("Georgia", Font.PLAIN, 13));
        back.setFocusPainted(false);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent E) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                frame.setTitle("Directory - Menu");

                MenuPanel menuPanel = (MenuPanel) frame.getContentPane().getComponent(0);

                menuPanel.setVisible(true);

                panel.setVisible(false);
            }
        });
        this.add(back);
        this.setVisible(true);
    }

}
