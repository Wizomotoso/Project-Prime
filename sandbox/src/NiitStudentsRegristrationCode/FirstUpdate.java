package NiitStudentsRegristrationCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstUpdate {

        public static void main(String[] args) {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    class FirstUpdateGui extends JFrame implements ActionListener {

        JLabel header = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();
        JLabel label6 = new JLabel();
        JTextField username = new JTextField();
        JTextField newNumber = new JTextField();
        JButton update = new JButton();
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenu menu2 = new JMenu("View");
        JMenu menu3 = new JMenu("Help");
        ImageIcon image = new ImageIcon("Pics/Project Illustration 2.png");


        String driverName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/NiitStudentsRecords";
        String userName = "root";
        String password = "753357wizomotoso.";

        void myMethod(){}

        public FirstUpdateGui() {

            setTitle("Update Profile");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800, 500);
            setLocationRelativeTo(null);
            setResizable(true);
            setVisible(true);

// MENU
            menuBar.add(menu);
            menuBar.add(menu2);
            menuBar.add(menu3);
            setJMenuBar(menuBar);

            menuBar.setBackground(new java.awt.Color(228, 218, 236));
            menu.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            menu2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            menu3.setFont(new Font("Segoe UI", Font.PLAIN, 12));


            // MENU ITEMS THAT NEED FUNCTIONALITIES
            JMenuItem items = new JMenuItem("Exit");
            menu.add(items);
            items.addActionListener(event -> System.exit(0));
            items.setFont(new Font("Segoe UI", Font.PLAIN, 11));

            JMenuItem items5 = new JMenuItem("Return to Previous");
            items5.setFont(new Font("Segoe UI", Font.PLAIN, 11));
            menu.add(items5);
            items5.addActionListener(e -> {
                new UpdateSlidePageGui();
                setVisible(false);
            });

            // VIEW HELP
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

            header.setText("NIIT");
            header.setForeground(new java.awt.Color(72, 5, 80));
            header.setSize(320, 80);
            header.setLocation(100, 50);
            header.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            header.setFont(new Font("old sport 01 college ncv", Font.PLAIN, 55));
            panel.add(header);

            // Label4
            label4.setText("UPDATE STUDENT PROFILE");
            label4.setForeground(new java.awt.Color(72, 5, 80));
            label4.setFont(new Font("Product", Font.BOLD, 20));
            label4.setSize(300, 100);
            label4.setLocation(100, 90);
            panel.add(label4);

            // Label5
            label5.setText("Enter Username");
            label5.setForeground(new java.awt.Color(72, 5, 80));
            label5.setFont(new Font("Segoe Ui", Font.ITALIC, 13));
            label5.setSize(300, 100);
            label5.setLocation(100, 140);
            panel.add(label5);

            // Text Field
            username.setFont(new Font("Segoe Ui", Font.PLAIN, 15));
            username.setSize(200, 30);
            username.setColumns(30);
            username.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            username.setBackground(new java.awt.Color(238, 226, 248));
            username.setLocation(100, 200);
            panel.add(username);

            // Label5
            label6.setText("Enter new Firstname");
            label6.setForeground(new java.awt.Color(72, 5, 80));
            label6.setFont(new Font("Segoe Ui", Font.ITALIC, 13));
            label6.setSize(300, 100);
            label6.setLocation(330, 140);
            panel.add(label6);

            // Text Field
            newNumber.setFont(new Font("Segoe Ui", Font.PLAIN, 15));
            newNumber.setSize(200, 30);
            newNumber.setColumns(30);
            newNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            newNumber.setBackground(new java.awt.Color(238, 226, 248));
            newNumber.setLocation(330, 200);
            panel.add(newNumber);

            // ENTER
            update.setText("Update");
            update.setFont(new Font("Segoe Ui", Font.BOLD, 15));
            update.setSize(100, 40);
            update.setLocation(100, 250);
            update.setFocusable(false);
            update.setForeground(new java.awt.Color(0, 0, 0, 255));
            update.setBackground(new java.awt.Color(204, 190, 245, 255));
            panel.add(update);
            update.addActionListener(this);

            // BACKGROUND IMAGE
            label3.setIcon(image);
            label3.setSize(1000, 1000);
            label3.setLocation(130, 230);
            panel.add(label3);
        }

        public void actionPerformed(ActionEvent ae)
        {
            update = (JButton)ae.getSource();
            System.out.println("Updating Table Properties.......");

            try {
                Class.forName(driverName);
                // establish connection
                Connection con = DriverManager.getConnection(url, userName, password);
                Statement stmt = con.createStatement();
                System.out.println(newNumber);
                stmt.execute("UPDATE Niitstudents SET firstname ='" + newNumber.getText() + "'where username = '" + username.getText() + "'");

                JOptionPane.showMessageDialog(null, "Record is updated...");
                stmt.close();
                con.close();
            } catch (SQLException | ClassNotFoundException se) {
                JOptionPane.showMessageDialog(null, se);
            }
        }

        public static void main(String[] args) {
            FirstUpdateGui firstUpdateGui = new FirstUpdateGui();
            firstUpdateGui.myMethod();
        }
    }

