package NiitStudentsRegristrationCode;

import javax.swing.*;
import java.awt.*;

public class UpdateSlidePage {

        public static void main(String[] args) {

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    class UpdateSlidePageGui extends JFrame {

        JLabel label3 = new JLabel();
        JLabel header = new JLabel();
        JButton firstButton = new JButton();
        JButton mobUpdate = new JButton();
        JButton lasUpdate = new JButton();
        JLabel logo = new JLabel();
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenu menu2 = new JMenu("View");
        JMenu menu3 = new JMenu("Help");
        JMenuItem items4 = new JMenuItem(("Save"));
        ImageIcon image = new ImageIcon("Pics/Project Illustration 3.png");


        void myMethod() {
        }

        public UpdateSlidePageGui() {

            setSize(800, 500);
            setLocationRelativeTo(null);
            setResizable(true);
            setTitle("Update Slide");
            setVisible(true);

            // MENU
            menuBar.add(menu);
            menuBar.add(menu2);
            menuBar.add(menu3);
            menu.add(items4);
            setJMenuBar(menuBar);

            menuBar.setBackground(new java.awt.Color(228, 218, 236));
            menu.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            menu2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            menu3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            items4.setFont(new Font("Segoe UI", Font.PLAIN, 11));

            // MENU ITEMS THAT NEED FUNCTIONALITIES
            JMenuItem items = new JMenuItem("Exit");
            menu.add(items);
            items.addActionListener(event -> System.exit(0));
            items.setFont(new Font("Segoe UI", Font.PLAIN, 11));

            JMenuItem items5 = new JMenuItem("Return to Previous");
            items5.setFont(new Font("Segoe UI", Font.PLAIN, 11));
            menu.add(items5);
            items5.addActionListener(e -> {
                new StudentsProfileSlidePageGui();
                setVisible(false);
            });

            // UNDO
            JMenuItem items2 = new JMenuItem("Undo");
            items2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
            menu2.add(items2);
            items2.addActionListener(e -> {
                menu2.add(items2);
                items2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
            });

            // PANEL
            JPanel panel = new JPanel() {
                protected void paintComponent(Graphics g) {
                    if (g instanceof Graphics2D) {
                        final int R = 100;
                        final int G = 100;
                        final int B = 100;
                        Paint p = new GradientPaint(0.3f, 1.0f, new Color(R, G, B, 0),
                                getWidth(), getHeight(), new Color(117, 169, 252, 255), false);
                        Graphics2D g2d = (Graphics2D) g;
                        g2d.setPaint(p);
                        g2d.fillRect(0, 0, getWidth(), getHeight());
                    } else {
                        super.paintComponent(g);
                    }
                }
            };
            panel.setLayout(null);
            add(panel);

            // LABELS
            header.setText("What Would you like to Update?");
            header.setFont(new Font("Segoe Ui", Font.PLAIN, 22));
            header.setForeground(new java.awt.Color(72, 5, 80));
            header.setSize(500, 70);
            header.setLocation(50, 30);
            panel.add(header);

            // FIRST NAME
            firstButton.setText("FirstName");
            firstButton.setFont(new Font("Segoe Ui", Font.BOLD, 15));
            firstButton.setSize(150, 40);
            firstButton.setLocation(50, 100);
            firstButton.setFocusable(false);
            firstButton.setForeground(new java.awt.Color(0, 0, 0, 255));
            firstButton.setBackground(new java.awt.Color(204, 190, 245, 255));
            panel.add(firstButton);
            firstButton.addActionListener(e -> {
                new FirstUpdateGui();
                setVisible(false);
            });

            // LAST NAME
            lasUpdate.setText("LastName");
            lasUpdate.setFont(new Font("Segoe Ui", Font.BOLD, 15));
            lasUpdate.setSize(150, 40);
            lasUpdate.setLocation(50, 160);
            lasUpdate.setFocusable(false);
            lasUpdate.setForeground(new java.awt.Color(0, 0, 0, 255));
            lasUpdate.setBackground(new java.awt.Color(204, 190, 245, 255));
            panel.add(lasUpdate);
            lasUpdate.addActionListener(e -> {
                new LastUpdateGui();
                setVisible(false);
            });

            // PHONE NO
            mobUpdate.setText("Phone NO");
            mobUpdate.setFont(new Font("Segoe Ui", Font.BOLD, 15));
            mobUpdate.setSize(150, 40);
            mobUpdate.setLocation(50, 220);
            mobUpdate.setFocusable(false);
            mobUpdate.setForeground(new java.awt.Color(0, 0, 0, 255));
            mobUpdate.setBackground(new java.awt.Color(204, 190, 245, 255));
            panel.add(mobUpdate);
            mobUpdate.addActionListener(e -> {
                new UpdateProfilesGui();
                setVisible(false);
            });

            // LABELS
            logo.setText("NIIT");
            logo.setFont(new Font("old sport 01 college ncv", Font.PLAIN, 35));
            logo.setForeground(new java.awt.Color(72, 5, 80));
            logo.setSize(90, 60);
            logo.setLocation(50, 600);
            panel.add(logo);

            // BACKGROUND IMAGE
            label3.setIcon(image);
            label3.setSize(1000, 1000);
            label3.setLocation(130, 230);
            panel.add(label3);

        }

        public static void main(String[] args) {
           UpdateSlidePageGui updateSlidePageGui = new UpdateSlidePageGui();
           updateSlidePageGui.myMethod();
        }
    }
