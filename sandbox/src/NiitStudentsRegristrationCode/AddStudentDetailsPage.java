package NiitStudentsRegristrationCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddStudentDetailsPage {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class AddStudentsDetailsPageGui extends JFrame implements ActionListener {

    JLabel header = new JLabel();
    JLabel label3 = new JLabel();
    JLabel firstName = new JLabel();
    JLabel lastname = new JLabel();
    JLabel pNumber = new JLabel();
    JLabel gender = new JLabel();
    JLabel City = new JLabel();
    JLabel userName = new JLabel();
    JLabel emailLabel = new JLabel();
    JLabel courseOfStudy = new JLabel();
    JLabel logo = new JLabel();
    JTextField firstname = new JTextField();
    String[] genders = {"Male", "Female"};
    JComboBox<String> genderComboBox = new JComboBox<>(genders);

    String[] cities = {"Ibadan", "Lagos", "Abuja", "PortHarcourt", "Kaduna"};
    JComboBox<String> cityComboBox = new JComboBox<>(cities);

    JTextField lastName = new JTextField();
    JTextField email = new JTextField();
    JTextField username = new JTextField();
    JTextField CourseOfStudy = new JTextField();
    JTextField mob = new JTextField();
    JButton submit = new JButton();
    JButton reset = new JButton();
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("File");
    JMenu menu2 = new JMenu("View");
    JMenu menu3 = new JMenu("Help");
    ImageIcon image = new ImageIcon("Pics/Project Illustration 3.png");

    void myMethod() {
    }

    public AddStudentsDetailsPageGui() {

        setSize(800, 500);
        setLocationRelativeTo(null);
        setResizable(true);
        setTitle("Add Student");
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
            firstname.setText("");
            lastName.setText("");
            mob.setText("");
            username.setText("");
            email.setText("");
            CourseOfStudy.setText("");
        });

        // VIEW HELP
        JMenuItem items3 = new JMenuItem("View Help");
        menu3.add(items3);
        items3.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        items3.addActionListener(e -> {
            new ViewHelpPageGui();
            setVisible(false);
        });

        // SAVE
        JMenuItem items4 = new JMenuItem(("Save"));
        menu.add(items4);
        items4.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        items4.addActionListener(e -> {
            if (e.getSource() == submit) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                //Creating Connection Object
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NiitStudentsRecords", "root", "753357wizomotoso.")) {

                    //Prepared Statement
                    PreparedStatement pStatement = conn.prepareStatement("insert into Niitstudents " +
                            "(firstname, lastName, mob, username, email, CourseOfStudy, genders, cities) VALUES (?, ?, ?, ?, ?, ?, ?,?)");
                    System.out.println(pStatement);

                    //Specifying the values of it's parameter
                    pStatement.setString(1, firstname.getText());
                    pStatement.setString(2, lastName.getText());
                    pStatement.setString(3, mob.getText());
                    pStatement.setString(4, username.getText());
                    pStatement.setString(5, email.getText());
                    pStatement.setString(6, CourseOfStudy.getText());
                    pStatement.setString(7, Objects.requireNonNull(genderComboBox.getSelectedItem()).toString());
                    pStatement.setString(8, Objects.requireNonNull(cityComboBox.getSelectedItem()).toString());
                    int i = pStatement.executeUpdate();
                    System.out.println(i);
                    // DIALOG BOX
                    JOptionPane.showMessageDialog(null, "Details Successfully Stored");

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
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

        // LABELS AND TEXT FIELDS
        header.setText("Registration Form");
        header.setFont(new Font("Segoe Ui", Font.BOLD, 35));
        header.setForeground(new java.awt.Color(72, 5, 80));
        header.setSize(400, 70);
        header.setLocation(100, 30);
        panel.add(header);

        // First Name
        firstName.setText("FirstName");
        firstName.setFont(new Font("Segoe Ui", Font.PLAIN, 20));
        firstName.setSize(100, 20);
        firstName.setLocation(100, 120);
        panel.add(firstName);

        firstname.setFont(new Font("Arial", Font.PLAIN, 15));
        firstname.setSize(200, 20);
        firstname.setColumns(30);
        firstname.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        firstname.setBackground(new java.awt.Color(238, 226, 248));
        firstname.setLocation(100, 150);
        panel.add(firstname);

        //---------------------------------------------------------------

        // Last Name
        lastname.setText("LastName");
        lastname.setFont(new Font("Segoe Ui", Font.PLAIN, 20));
        lastname.setSize(100, 20);
        lastname.setLocation(100, 180);
        panel.add(lastname);

        lastName.setFont(new Font("Arial", Font.PLAIN, 15));
        lastName.setSize(200, 20);
        lastName.setColumns(30);
        lastName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        lastName.setBackground(new java.awt.Color(238, 226, 248));
        lastName.setLocation(100, 210);
        panel.add(lastName);

        //---------------------------------------------------------------

        // Mobile
        pNumber.setText("Mobile");
        pNumber.setFont(new Font("Segoe Ui", Font.PLAIN, 20));
        pNumber.setSize(100, 20);
        pNumber.setLocation(100, 240);
        panel.add(pNumber);

        mob.setFont(new Font("Arial", Font.PLAIN, 15));
        mob.setColumns(30);
        mob.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        mob.setBackground(new java.awt.Color(238, 226, 248));
        mob.setSize(200, 20);
        mob.setLocation(100, 270);
        panel.add(mob);

        //---------------------------------------------------------------

        // Username
        userName.setText("Username");
        userName.setFont(new Font("Segoe Ui", Font.PLAIN, 20));
        userName.setSize(100, 20);
        userName.setLocation(100, 300);
        panel.add(userName);

        username.setFont(new Font("Arial", Font.PLAIN, 15));
        username.setColumns(30);
        username.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        username.setBackground(new java.awt.Color(238, 226, 248));
        username.setSize(200, 20);
        username.setLocation(100, 330);
        panel.add(username);

        //---------------------------------------------------------------

        // EMAIL
        emailLabel.setText("Email");
        emailLabel.setFont(new Font("Segoe Ui", Font.PLAIN, 20));
        emailLabel.setSize(100, 20);
        emailLabel.setLocation(100, 360);
        panel.add(emailLabel);

        email.setFont(new Font("Arial", Font.PLAIN, 15));
        email.setColumns(30);
        email.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        email.setBackground(new java.awt.Color(238, 226, 248));
        email.setSize(200, 20);
        email.setLocation(100, 390);
        panel.add(email);

        //---------------------------------------------------------------`

        // COURSE OF STUDY
        courseOfStudy.setText("Course");
        courseOfStudy.setFont(new Font("Segoe Ui", Font.PLAIN, 20));
        courseOfStudy.setSize(100, 20);
        courseOfStudy.setLocation(500, 120);
        panel.add(courseOfStudy);

        CourseOfStudy.setFont(new Font("Arial", Font.PLAIN, 15));
        CourseOfStudy.setColumns(30);
        CourseOfStudy.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        CourseOfStudy.setBackground(new java.awt.Color(238, 226, 248));
        CourseOfStudy.setSize(200, 20);
        CourseOfStudy.setLocation(500, 150);
        panel.add(CourseOfStudy);

        //---------------------------------------------------------------`

//          Gender Label
        gender.setText("Gender");
        gender.setFont(new Font("Segoe Ui", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(500, 180);
        gender.setBackground(new java.awt.Color(0, 0, 0));
        panel.add(gender);

        genderComboBox.setSize(100, 20);
        genderComboBox.setFont(new Font("Segoe Ui", Font.BOLD, 13));
        genderComboBox.setLocation(500, 210);
        panel.add(genderComboBox);

        //---------------------------------------------------------------`

        // City
        City.setText("City of Residence");
        City.setFont(new Font("Segoe Ui", Font.PLAIN, 20));
        City.setSize(200, 100);
        City.setLocation(500, 200);
        City.setBackground(new java.awt.Color(0, 0, 0));
        panel.add(City);

        cityComboBox.setSize(100, 20);
        cityComboBox.setFont(new Font("Segoe Ui", Font.BOLD, 13));
        cityComboBox.setLocation(500, 270);
        panel.add(cityComboBox);


        // SUBMIT AND RESET BUTTONS

        submit.setText("Submit");
        submit.setFont(new Font("Segoe Ui", Font.BOLD, 15));
        submit.setSize(100, 40);
        submit.setLocation(500, 350);
        submit.setFocusable(false);
        submit.setForeground(new java.awt.Color(0, 0, 0, 255));
        submit.setBackground(new java.awt.Color(204, 190, 245, 255));
        panel.add(submit);

        reset.setText("Reset");
        reset.setFont(new Font("Arial", Font.BOLD, 15));
        reset.setSize(100, 40);
        reset.setLocation(610, 350);
//            reset.addActionListener(this);
        reset.setFocusable(false);
        reset.setForeground(new java.awt.Color(0, 0, 0, 255));
        reset.setBackground(new java.awt.Color(204, 190, 245, 255));
        panel.add(reset);

        // LABELS
        logo.setText("NIIT");
        logo.setFont(new Font("old sport 01 college ncv", Font.PLAIN, 35));
        logo.setForeground(new java.awt.Color(72, 5, 80));
        logo.setSize(90, 60);
        logo.setLocation(100, 600);
        panel.add(logo);

        submit.addActionListener(this);
        reset.addActionListener(this);

        // BACKGROUND IMAGE
        label3.setIcon(image);
        label3.setSize(1000, 1000);
        label3.setLocation(130, 230);
        panel.add(label3);


    }

    public static void main(String[] args) {
        AddStudentsDetailsPageGui addStudentsDetailsPageGui = new AddStudentsDetailsPageGui();
        addStudentsDetailsPageGui.myMethod();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Pattern MyPattern1 = Pattern.compile("[0-9]{11}");
        Matcher MyMatcher1 = MyPattern1.matcher(mob.getText());
        boolean MyBoolean1 = MyMatcher1.matches();
        if (!MyBoolean1)
        {
            JOptionPane.showMessageDialog(this, "Mobile Number is either > or < than 11 Numbers");
        }

        Pattern MyPattern = Pattern.compile("^[a-z0-9-]+[@][a-z]+[.][a-z]+$");
        Matcher MyMatcher = MyPattern.matcher(email.getText());
        boolean MyBoolean = MyMatcher.matches();
        if (!MyBoolean) {
            JOptionPane.showMessageDialog(this, "Email-id incorrect.Pls make sure you follow the Email naming protocol");
        } else {

            if (e.getSource() == submit) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                //Creating Connection Object
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NiitStudentsRecords", "root", "753357wizomotoso.")) {

                    //Prepared Statement
                    PreparedStatement pStatement = conn.prepareStatement("insert into Niitstudents " +
                            "(firstname, lastName, mob, username, email, CourseOfStudy, genders, cities) VALUES (?, ?, ?, ?, ?, ?, ?,?)");
                    System.out.println(pStatement);

                    //Specifying the values of it's parameter
                    pStatement.setString(1, firstname.getText());
                    pStatement.setString(2, lastName.getText());
                    pStatement.setString(3, mob.getText());
                    pStatement.setString(4, username.getText());
                    pStatement.setString(5, email.getText());
                    pStatement.setString(6, CourseOfStudy.getText());
                    pStatement.setString(7, Objects.requireNonNull(genderComboBox.getSelectedItem()).toString());
                    pStatement.setString(8, Objects.requireNonNull(cityComboBox.getSelectedItem()).toString());
                    int i = pStatement.executeUpdate();
                    System.out.println(i);
                    // DIALOG BOX
                    JOptionPane.showMessageDialog(null, "Details Successfully Stored");

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            if (e.getSource() == reset) {

                //Clearing Fields
                firstname.setText("");
                lastName.setText("");
                mob.setText("");
                username.setText("");
                email.setText("");
                CourseOfStudy.setText("");
            }
        }
    }
}



