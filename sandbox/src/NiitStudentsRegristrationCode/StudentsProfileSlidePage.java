package NiitStudentsRegristrationCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentsProfileSlidePage {

        public static void main(String[] args) {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    class StudentsProfileSlidePageGui extends JFrame implements ActionListener {

        // INITIALIZATIONS
        JLabel label3 = new JLabel();
        JButton button = new JButton();
        JButton button2 = new JButton();
        JButton button3 = new JButton();
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenu menu2 = new JMenu("View");
        JMenu menu3 = new JMenu("Help");
        JMenuItem items4 = new JMenuItem(("Save"));
        ImageIcon image = new ImageIcon("Pics/Project Illustration 2.png");


        void forMethod(){}
        public StudentsProfileSlidePageGui(){

            // FRAME
            setTitle("Student Page");
            setSize(800,500);
            setLocationRelativeTo(null);
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

            // RETURN TO MAIN
            JMenuItem items5 = new JMenuItem("Return to Previous");
            items5.setFont(new Font("Segoe UI", Font.PLAIN, 11));
            menu.add(items5);
            items5.addActionListener(e -> {
                new SignUpAndSignInGui();
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

            // View Help
            JMenuItem items3 = new JMenuItem("View Help");
            menu3.add(items3);
            items3.setFont(new Font("Segoe UI", Font.PLAIN, 11));
            items3.addActionListener(e -> {
                new ViewHelpPageGui();
                setVisible(false);
            });

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

            // BUTTONS
            button.setText("VIEW STUDENT PROFILE");
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setFocusable(false);
            button.setForeground(new java.awt.Color(0, 0, 0, 255));
            button.setBackground(new java.awt.Color(204, 190, 245, 255));
            panel.add(Box.createRigidArea(new Dimension(0,80)));
            button.setFont(new Font("Segoe UI", Font.BOLD, 30));
            panel.add(button);

            button.addActionListener(e -> {
                new ViewProfilesGui();
                setVisible(false);
            });

            button2.setText("UPDATE STUDENT PROFILE");
            button2.setAlignmentX(Component.CENTER_ALIGNMENT);
            button2.setFocusable(false);
            button2.setForeground(new java.awt.Color(0, 0, 0, 255));
            button2.setBackground(new java.awt.Color(204, 190, 245, 255));
            panel.add(Box.createRigidArea(new Dimension(0,30)));
            button2.setFont(new Font("Segoe UI", Font.BOLD, 30));
            panel.add(button2);

            button2.addActionListener(e -> {
                new UpdateSlidePageGui();
                setVisible(false);
            });

            button3.setText("DELETE STUDENT PROFILE");
            button3.setAlignmentX(Component.CENTER_ALIGNMENT);
            button3.setFocusable(false);
            button3.setForeground(new java.awt.Color(0, 0, 0, 255));
            button3.setBackground(new java.awt.Color(204, 190, 245, 255));
            panel.add(Box.createRigidArea(new Dimension(0,30)));
            button3.setFont(new Font("Segoe UI", Font.BOLD, 30));
            button3.addActionListener(e -> {
                new DeleteProfileGui();
                setVisible(false);
            });
            panel.add(button3);

            // BACKGROUND IMAGE
            label3.setIcon(image);
            label3.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(Box.createRigidArea(new Dimension(0,0)));
            panel.add(label3);

        }
        public static void main(String[] args) {
           StudentsProfileSlidePageGui studentsProfileSlidePageGui = new StudentsProfileSlidePageGui();
           studentsProfileSlidePageGui.forMethod();
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
