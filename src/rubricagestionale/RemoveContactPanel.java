package rubricagestionale;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.*;

public class RemoveContactPanel extends JPanel {

    private JPanel panel;

    private final JLabel directory;

    private final JLabel credits;

    private final JButton back;

    private JButton contact;

    private StringTokenizer st;

    private String s;

    private String n, c, t;

    private int i;

    private final JScrollPane scrollPane;

    private final JPanel buttonPanel;

    private final BufferedReader fileinb;

    public RemoveContactPanel() throws FileNotFoundException, IOException {
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

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 90, 370, 310);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        fileinb = new BufferedReader(new FileReader("directory.txt"));

        do {
            s = fileinb.readLine();
            if (s != null) {
                st = new StringTokenizer(s, ";");
                n = st.nextToken();
                c = st.nextToken();
                t = st.nextToken();

                String lineToRemove = n + ";" + c + ";" + t;

                contact = new JButton("<html>Remove number " + t + ":<br>" + n + " " + c + "</html>");
                contact.setFont(new Font("Georgia", Font.PLAIN, 15));
                contact.setAlignmentX(Component.CENTER_ALIGNMENT);
                contact.setFocusPainted(false);
                contact.setMaximumSize(new Dimension(320, 60));
                contact.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            BufferedReader filein = new BufferedReader(new FileReader("directory.txt"));
                            String s, newS = "";
                            do {
                                s = filein.readLine();
                                if (s != null) {
                                    if (!s.equals(lineToRemove)) {
                                        newS += s + "\n";
                                    }
                                }
                            } while (s != null);
                            filein.close();

                            FileWriter fileout = new FileWriter("directory.txt", false);
                            fileout.write("");
                            fileout.close();

                            fileout = new FileWriter("directory.txt", true);
                            fileout.write(newS);
                            fileout.close();

                            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                            frame.setTitle("Directory - Menu");

                            MenuPanel menuPanel = (MenuPanel) frame.getContentPane().getComponent(0);

                            menuPanel.setVisible(true);

                            panel.setVisible(false);
                        } catch (IOException ex) {
                        }
                    }
                });

                buttonPanel.add(contact);
                buttonPanel.add(Box.createVerticalStrut(10));

                i++;
            }
        } while (s != null);

        buttonPanel.setPreferredSize(new Dimension(340, i * 60));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setViewportView(buttonPanel);
        scrollPane.setVisible(true);
        this.add(scrollPane);

        back = new JButton("Back");
        back.setBounds(145, 420, 100, 30);
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
