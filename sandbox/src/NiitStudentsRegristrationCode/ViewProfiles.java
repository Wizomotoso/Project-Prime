package NiitStudentsRegristrationCode;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewProfiles {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class ViewProfilesGui extends JFrame implements ActionListener {
    JFrame frame1 = new JFrame();
    static JTable table;

    JLabel header = new JLabel();
    JLabel label3 = new JLabel();
    JLabel label4 = new JLabel();
    JLabel label5 = new JLabel();
    JTextField email = new JTextField();
    JButton enter = new JButton();
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("File");
    JMenu menu2 = new JMenu("View");
    JMenu menu3 = new JMenu("Help");
    ImageIcon image = new ImageIcon("Pics/Project Illustration 2.png");


    String driverName = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/NiitStudentsRecords";
    String userName = "root";
    String password = "753357wizomotoso.";
    String[] columnNames = {"firstname", "lastName", "mob", "username", "email", "CourseOfStudy", "genders", "cities"};

    void myMethod(){}

    public ViewProfilesGui() {

        setTitle("Database Search Result");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setResizable(true);
        setTitle("View Profile");
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
            new StudentsProfileSlidePageGui();
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
        label4.setText("VIEW STUDENT PROFILE");
        label4.setForeground(new java.awt.Color(72, 5, 80));
        label4.setFont(new Font("Product", Font.BOLD, 20));
        label4.setSize(300, 100);
        label4.setLocation(100, 90);
        panel.add(label4);

        // Label5
        label5.setText("Enter your Username");
        label5.setForeground(new java.awt.Color(72, 5, 80));
        label5.setFont(new Font("Segoe Ui", Font.ITALIC, 13));
        label5.setSize(300, 100);
        label5.setLocation(100, 140);
        panel.add(label5);

        // Text Field
        email.setFont(new Font("Segoe Ui", Font.PLAIN, 15));
        email.setSize(200, 30);
        email.setColumns(30);
        email.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        email.setBackground(new java.awt.Color(238, 226, 248));
        email.setLocation(100, 200);
        panel.add( email);

        // ENTER
        enter.setText("Enter");
        enter.setFont(new Font("Segoe Ui", Font.BOLD, 15));
        enter.setSize(100, 40);
        enter.setLocation(100, 250);
        enter.setFocusable(false);
        enter.setForeground(new java.awt.Color(0, 0, 0, 255));
        enter.setBackground(new java.awt.Color(204, 190, 245, 255));
        panel.add(enter);
        enter.addActionListener(this);

        // BACKGROUND IMAGE
        label3.setIcon(image);
        label3.setSize(1000, 1000);
        label3.setLocation(130, 230);
        panel.add(label3);


    }

    public void actionPerformed(ActionEvent ae)
    {
        enter = (JButton)ae.getSource();
        System.out.println("Showing Table Data.......");
        showTableData();
    }

    public void showTableData()
    {

        frame1 = new JFrame("Database Search Result");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String textValue = email.getText();
        String firstname;
        String lastName;
        String mob;
        String username;
        String email;
        String CourseOfStudy;
        String genders;
        String cities;
        try
        {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, userName, password);
            String sql = "select * from Niitstudents where username = '"+ textValue + "'";

            System.out.println(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            int i =0;
            if(rs.next())
            {
                firstname = rs.getString("firstname");
                lastName = rs.getString("lastName");
                mob = rs.getString("mob");
                username = rs.getString("username");
                email = rs.getString("email");
                CourseOfStudy = rs.getString("CourseOfStudy");
                genders = rs.getString("genders");
                cities = rs.getString("cities");
                model.addRow(new Object[] {firstname, lastName, mob, username, email, CourseOfStudy, genders, cities});

                i++;
            }
            if(i <1)
            {
                JOptionPane.showMessageDialog(null, "No Record Found","Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            if(i ==1)
            {
                System.out.println(i+" Record Found");
            }
            else
            {
                System.out.println(i+" Records Found");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        frame1.add(scroll);
        frame1.setSize(800,500);
        frame1.setResizable(false);
        frame1.setVisible(true);

        JPanel panel2 = new JPanel() {
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
        panel2.setLayout(null);
        frame1.add(panel2);

        table.setBackground(new java.awt.Color(238, 226, 248));
        table.setForeground(new java.awt.Color(72, 5, 80));
        table.setFont(new Font("Segoe UI", Font.BOLD, 10));
        table.setSize(300, 33);

    }

    public static void main(String[] args) {
        ViewProfilesGui viewProfilesGui = new ViewProfilesGui();
        viewProfilesGui.myMethod();
    }
}