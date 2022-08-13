package company.co;

import company.co.frames;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Client extends JFrame implements ActionListener {

    static JPanel p, p1, p2, p3, p4, p5;
    static JButton b1;
    static JTextField t1;
    static JLabel l1, l2, l3, l4, l5;
    static int day, month;
    static String r;
    public static String z;
    public frames f;

    public Client() {

        this.setSize(550, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        p = new JPanel();
        p.setLayout(new GridLayout(5, 1));

        p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));

        l1 = new JLabel("Welcome to Horoscopes Program");

        p1.add(l1);
        p.add(p1);

        p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.CENTER));
        l2 = new JLabel("Enter your BirthDay");
        p2.add(l2);

        t1 = new JTextField(10);

        p2.add(t1);
        l5 = new JLabel("(day 2,month 6) (0206)");

        p2.add(l5);

        p.add(p2);

        p4 = new JPanel();
        p4.setLayout(new FlowLayout(FlowLayout.CENTER));

        b1 = new JButton("Start");
        b1.addActionListener(this);
        p4.add(b1);

        p.add(p4);

        this.add(p);
    }

    public static void main(String[] args) throws IOException {
        Client f = new Client();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if (o == b1) {

            try {
                r = t1.getText();

                Socket connectionsocket = new Socket("localhost", 7489);

                String sentence = r;

                DataOutputStream outtoserver = new DataOutputStream(connectionsocket.getOutputStream());

                outtoserver.writeBytes(sentence + '\n');

                //InPut From Server
                InputStreamReader ISR2 = new InputStreamReader(connectionsocket.getInputStream());
                BufferedReader infromserver = new BufferedReader(ISR2);
                String x = infromserver.readLine() + "\n";

                f = new frames(x);

                this.setVisible(false);

            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
