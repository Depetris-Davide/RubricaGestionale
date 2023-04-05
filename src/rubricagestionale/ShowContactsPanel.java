package rubricagestionale;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.*;
import javax.swing.border.AbstractBorder;

public class ShowContactsPanel extends JPanel {

    private JPanel panel;

    private final JLabel directory;

    private final JLabel credits;

    private final JButton back;

    private JLabel contact;

    private StringTokenizer st;

    private String s;

    private String n, c, t;

    private int i;

    private final JScrollPane scrollPane;

    private final JPanel buttonPanel;

    private final BufferedReader fileinb;

    public ShowContactsPanel() throws FileNotFoundException, IOException {
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

                contact = new JLabel("<html>Contatto " + (i + 1) + ":<br>Nome: " + n + "<br>Cognome: " + c + "<br>Telefono: " + t + "</html>");
                contact.setFont(new Font("Georgia", Font.PLAIN, 15));
                switch ((int) (Math.random() * 3)) {
                    case 0:
                        contact.setBackground(new Color(254, 74, 73));
                        break;
                    case 1:
                        contact.setBackground(new Color(38, 190, 191));
                        break;
                    case 2:
                        contact.setBackground(new Color(255, 164, 29));
                        break;
                }
                contact.setOpaque(true);
                contact.setForeground(Color.white);
                contact.setAlignmentX(Component.CENTER_ALIGNMENT);
                contact.setMaximumSize(new Dimension(300, 110));

                buttonPanel.add(contact);
                buttonPanel.add(Box.createVerticalStrut(10));

                i++;
            }
        } while (s != null);

        buttonPanel.setPreferredSize(new Dimension(340, i * 110));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

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
