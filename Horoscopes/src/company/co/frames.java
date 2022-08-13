package company.co;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author CraZinEsS
 */
public class frames extends JFrame {
    Client cl;
    private JPanel p1;
    private JLabel l1, l2;

    public frames(String x) {
        this.setTitle("Resault Of Calculator");
        this.setSize(800, 850);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        setLocationRelativeTo(null);

        p1.setLayout(new FlowLayout());
        // l1.setFont(new Font("",Font.BOLD,40));
        //   l1.setForeground(Color.blue);

        l1 = new JLabel("Your Sign is  "+x);
        l1.setFont(new Font("Calibri", Font.PLAIN, 30));
        l1.setForeground(Color.WHITE);

        p1.add(l1);

        p1.setBackground(Color.BLACK);

        ImageIcon image = new ImageIcon ("C:\\Users\\Commandor\\Desktop\\img1.JPEG");
        l2= new JLabel();
        l2.setIcon(image);
        p1.add(l2);


        this.add(p1);

    }
}


