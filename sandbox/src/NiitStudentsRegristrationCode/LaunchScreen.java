package NiitStudentsRegristrationCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchScreen {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class LaunchScreenGui extends JFrame implements ActionListener {

    // INITIALIZATIONS
    JLabel label = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JButton button = new JButton();
    ImageIcon image = new ImageIcon("Pics/Project Illustration 2.png");


    void forMethod(){}
    public LaunchScreenGui(){

        // FRAME
        setTitle("LaunchPage");
        setSize(800,500);
        setLocationRelativeTo(null);
        setVisible(true);

    JPanel panel = new JPanel() {
        protected void paintComponent(Graphics g) {
            if (g instanceof Graphics2D) {
                final int R = 100;
                final int G = 100;
                final int B = 100;
                Paint p = new GradientPaint(0.3f, 1.0f, new Color(R, G, B, 0),
                                getWidth(), getHeight(), new Color(117, 169, 252, 255), false);
                Graphics2D g2d = (Graphics2D)g;
                g2d.setPaint(p);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            } else {
                super.paintComponent(g);
            }
        }
    };
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
    add(panel);

    // LABELS
        label.setText("NIIT");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("old sport 01 college ncv", Font.PLAIN, 89));
        label.setForeground(new java.awt.Color(72, 5, 80));
        panel.add(Box.createRigidArea(new Dimension(0,100)));
        panel.add(label);

        label2.setText("The Leading Skills and Talent Development Corporation building Manpower tools for global industry requirements.");
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setForeground(new java.awt.Color(1, 3, 31));
        label2.setFont(new Font("Sanson", Font.PLAIN, 13));
        panel.add(Box.createRigidArea(new Dimension(0,1)));
        panel.add(label2);

        // BUTTON
        button.setLayout(new GridLayout(2,0));
        button.setText("NEXT");
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0,90)));
        button.setFont(new Font("Segoe UI", Font.BOLD, 25));
        button.setBackground(new java.awt.Color(22, 222, 212, 37));
        panel.add(button);

        button.addActionListener(e -> {
            new SignUpAndSignInGui();
            setVisible(false);
        });

        // BACKGROUND IMAGE
        label3.setIcon(image);
        label3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0,0)));
        panel.add(label3);

}
    public static void main(String[] args) {
        LaunchScreenGui launchScreenGui = new LaunchScreenGui();
        launchScreenGui.forMethod();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
