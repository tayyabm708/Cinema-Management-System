package com.codewithTayyab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class RegisterScreen extends JFrame{
    JLabel registerTitle;
    JLabel Name;
    JTextField firstName;
    JTextField lastName;
    JLabel BirthDate;
    JTextField birthDay;
    JTextField birthMonth;
    JTextField birthYear;
    JLabel HireDate;
    JTextField hireDay;
    JTextField hireMonth;
    JTextField hireYear;
    JLabel Address;
    JTextField homeNo;
    JTextField streetNo;
    JTextField city;
    JButton Register;
    JButton Update;
    JLabel userLabel;
    JLabel passwordLabel;
    JTextField userName;
    JPasswordField password;
    JComboBox<Integer> bday;
    JComboBox<Integer> bmonth;
    JComboBox<Integer> byear;
    JComboBox<Integer> hday;
    JComboBox<Integer>hmonth;
    JComboBox<Integer> hyear;

    JButton bckBtn1;
    JButton bckBtn2;

    public RegisterScreen(Object obj, Object obj2){
        super("Registration Window");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(25,25,25));
        setLayout(null);

        registerTitle = new JLabel("REGISTRATION");
        registerTitle.setForeground(Color.ORANGE);
        registerTitle.setFont(new Font("Serif", Font.BOLD, 17));
        registerTitle.setBounds(180, 50, 200, 25);
        add(registerTitle);

        Name = new JLabel("Name");
        Name.setForeground(Color.ORANGE);
        Name.setBounds(50, 100, 80, 25);
        add(Name);

        firstName = new HintTextField("First Name");
        firstName.setBounds(140, 100, 100, 25);
        add(firstName);

        lastName = new HintTextField("Last Name");
        lastName.setBounds(245, 100, 100, 25);
        add(lastName);

        BirthDate = new JLabel("Birth Date ");
        BirthDate.setForeground(Color.ORANGE);
        BirthDate.setBounds(50, 140, 80, 25);
        add(BirthDate);


        bday= new JComboBox<>();
        bday.setSelectedItem(null);
        for(int i=1; i<=31; i++){
            bday.addItem(i);
        }
        bday.setBounds(140,140,65,25);
        bday.setBackground(Color.ORANGE);
        bday.setForeground(Color.black);
        add(bday);


        bmonth= new JComboBox<>();
        bmonth.setSelectedItem(null);
        for(int i=1; i<=12; i++){
            bmonth.addItem(i);
        }

        bmonth.setBounds(210,140,65,25);
        bmonth.setBackground(Color.ORANGE);
        bmonth.setForeground(Color.black);
        add(bmonth);

        byear= new JComboBox<>();
        byear.setSelectedItem(null);
        for(int i=1950;i<=2021;i++){
            byear.addItem(i);
        }

        byear.setBounds(280,140,65,25);
        byear.setBackground(Color.ORANGE);
        byear.setForeground(Color.black);
        add(byear);



        HireDate = new JLabel("Hire Date ");
        HireDate.setForeground(Color.ORANGE);
        HireDate.setBounds(50, 180, 80, 25);
        add(HireDate);


        hday= new JComboBox<>();
        hday.setSelectedItem(null);
        for(int i=1; i<=31; i++){
            hday.addItem(i);
        }
        hday.setBounds(140,180,65,25);
        hday.setBackground(Color.ORANGE);
        hday.setForeground(Color.black);
        add(hday);


        hmonth= new JComboBox<>();
        hmonth.setSelectedItem(null);
        for(int i=1; i<=12; i++){
            hmonth.addItem(i);
        }
        hmonth.setBounds(210,180,65,25);
        hmonth.setBackground(Color.ORANGE);
        hmonth.setForeground(Color.BLACK);
        add(hmonth);

        hyear= new JComboBox<>();
        hyear.setSelectedItem(null);
        for(int i=1950;i<=2021;i++){
            hyear.addItem(i);
        }

        hyear.setBounds(280,180,65,25);
        hyear.setBackground(Color.ORANGE);
        hyear.setForeground(Color.black);
        add(hyear);


        Address = new JLabel("Address ");
        Address.setForeground(Color.ORANGE);
        Address.setBounds(50, 220, 80, 25);
        add(Address);

        homeNo = new HintTextField("Home");
        homeNo.setBounds(140, 220, 65, 25);
        add(homeNo);

        streetNo = new HintTextField("Street No.");
        streetNo.setBounds(210, 220, 65, 25);
        add(streetNo);

        city = new HintTextField("City");
        city.setBounds(280, 220, 65, 25);
        add(city);

        userLabel = new JLabel("User Name");
        userLabel.setForeground(Color.ORANGE);
        userLabel.setBounds(50, 260, 80, 25);
        add(userLabel);

        userName = new JTextField();
        userName.setBounds(140, 260, 205, 25);
        add(userName);

        passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.ORANGE);
        passwordLabel.setBounds(50, 300, 80, 25);
        add(passwordLabel);

        password = new JPasswordField();
        password.setBounds(140, 300, 205, 25);
        add(password);

        Register = new JButton("Register");
        Register.setBackground(Color.ORANGE);
        Register.setBounds(192, 350, 100, 25);
        add(Register);

        Update=new JButton("Update");
        Update.setBackground(Color.ORANGE);
        Update.setBounds(192, 350, 100, 25);
        add(Update);
        Update.setVisible(false);

        bckBtn1 = new JButton("<");
        bckBtn1.setBackground(Color.ORANGE);
        bckBtn1.setBounds(20,20, 20, 20);
        bckBtn1.setBorder(null);
        add(bckBtn1);

        bckBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(obj instanceof Administrator || obj2 instanceof Administrator){
                    new AdminScreen();
                    dispose();
                }
                else{
                    new LoginScreen(obj);
                    dispose();
                }
            }
        });

        if(obj instanceof Administrator && obj2!=null){
            registerTitle.setText("UPDATE HERE");
            Register.setVisible(false);
            Update.setVisible(true);
            if(obj2 instanceof TicketSeller ){
                TicketSeller t= (TicketSeller)obj2;
                firstName.setText(t.getFirstName());
                lastName.setText(t.getLastName());
                bday.setSelectedItem(t.getBirthDate().getDay());
                bmonth.setSelectedItem(t.getBirthDate().getMonth());
                byear.setSelectedItem(t.getBirthDate().getYear());
                hday.setSelectedItem(t.getHireDate().getDay());
                hmonth.setSelectedItem(t.getHireDate().getMonth());
                hyear.setSelectedItem(t.getHireDate().getYear());
                homeNo.setText(t.getAddress().getHome());
                streetNo.setText(String.valueOf(t.getAddress().getStreet()));
                city.setText(t.getAddress().getCity());
                userName.setText(t.getUsername());
                password.setText(t.getPassword());
            }
            else if(obj2 instanceof FoodSeller){
                FoodSeller f= (FoodSeller)obj2;
                firstName.setText(f.getFirstName());
                lastName.setText(f.getLastName());
                bday.setSelectedItem(f.getBirthDate().getDay());
                bmonth.setSelectedItem(f.getBirthDate().getMonth());
                byear.setSelectedItem(f.getBirthDate().getYear());
                hday.setSelectedItem(f.getHireDate().getDay());
                hmonth.setSelectedItem(f.getHireDate().getMonth());
                hyear.setSelectedItem(f.getHireDate().getYear());
                homeNo.setText(f.getAddress().getHome());
                streetNo.setText(String.valueOf(f.getAddress().getStreet()));
                city.setText(f.getAddress().getCity());
                userName.setText(f.getUsername());
                password.setText(f.getPassword());

            }
            Update.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    String fn = firstName.getText();
                    String ln = lastName.getText();
                    String bd = bday.getSelectedItem().toString();
                    String bm = bmonth.getSelectedItem().toString();
                    String by = byear.getSelectedItem().toString();
                    String hd = hday.getSelectedItem().toString();
                    String hm = hmonth.getSelectedItem().toString();
                    String hy = hyear.getSelectedItem().toString();
                    String hn = homeNo.getText();
                    String sn = streetNo.getText();
                    String c = city.getText();
                    String un = userName.getText();
                    char[] pass = password.getPassword();
                    String p = String.valueOf(pass);

                    if (fn.isBlank() || ln.isBlank() || bd.isBlank() || bm.isBlank() || by.isBlank() || hd.isBlank() || hm.isBlank() || hy.isBlank() || sn.isBlank() || c.isBlank() || un.isBlank() || p.isBlank() ) {
                        JOptionPane.showMessageDialog(null, "Some Field is Empty ");}
                    else{
                        if (bd.matches("[0-9]+") && bm.matches("[0-9]+") && by.matches("[0-9]+") && hd.matches("[0-9]+") && hm.matches("[0-9]+") && hy.matches("[0-9]+") && sn.matches("[0-9]+")) {
                            if (obj2 instanceof FoodSeller) {
                                FoodSeller f = new FoodSeller(fn, ln, new Date(Integer.parseInt(bd), Integer.parseInt(bm), Integer.parseInt(by)), new Date(Integer.parseInt(hd), Integer.parseInt(hm), Integer.parseInt(hy)), new Address(hn, Integer.parseInt(sn), c), un, p);
                                Filing fi = new Filing();
                                fi.updateFromFile(new FoodSeller(), ((FoodSeller) obj2).getFirstName(), f);
                                JOptionPane.showMessageDialog(null, "The Food Seller record was successfully updated");
                            }
                            else if (obj2 instanceof TicketSeller) {
                                TicketSeller t = new TicketSeller(fn, ln, new Date(Integer.parseInt(bd), Integer.parseInt(bm), Integer.parseInt(by)), new Date(Integer.parseInt(hd), Integer.parseInt(hm), Integer.parseInt(hy)), new Address(hn, Integer.parseInt(sn), c), un, p);
                                Filing fi = new Filing();
                                fi.updateFromFile(new TicketSeller(), ((TicketSeller) obj2).getFirstName(), t);
                                JOptionPane.showMessageDialog(null, "The Ticket Seller record was successfully updated");
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "InCompatible Fields");
                        }

                    }
                }
            });
        }
        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String fn = firstName.getText();
                String ln = lastName.getText();
                String bd = bday.getSelectedItem().toString();
                String bm = bmonth.getSelectedItem().toString();
                String by = byear.getSelectedItem().toString();
                String hd = hday.getSelectedItem().toString();
                String hm = hmonth.getSelectedItem().toString();
                String hy = hyear.getSelectedItem().toString();
                String hn = homeNo.getText();
                String sn = streetNo.getText();
                String c = city.getText();
                String un = userName.getText();
                char[] pass = password.getPassword();
                String p = String.valueOf(pass);

                int no = new Filing().NumberOf(obj);

                if(no<3)
                {
                    if (fn.isBlank() || ln.isBlank() || bd.isBlank() || bm.isBlank() || by.isBlank() || hd.isBlank() || hm.isBlank() || hy.isBlank() || sn.isBlank() || c.isBlank() || un.isBlank() || p.isBlank() ) {
                        JOptionPane.showMessageDialog(null, "Some Field is Empty ");
                    }
                    else{
                        if (bd.matches("[0-9]+") && bm.matches("[0-9]+") && by.matches("[0-9]+") && hd.matches("[0-9]+") && hm.matches("[0-9]+") && hy.matches("[0-9]+") && sn.matches("[0-9]+")) {
                            if (obj instanceof FoodSeller && obj2==null) {
                                FoodSeller f = new FoodSeller(fn, ln, new Date(Integer.parseInt(bd), Integer.parseInt(bm), Integer.parseInt(by)), new Date(Integer.parseInt(hd), Integer.parseInt(hm), Integer.parseInt(hy)), new Address(hn, Integer.parseInt(sn), c), un, p);
                                Register r = new Register();
                                r.Registration(f);
                                JOptionPane.showMessageDialog(null, "Registration Successful");
                                new LoginScreen(obj);
                                dispose();
                            } else if (obj instanceof TicketSeller && obj2==null) {
                                TicketSeller t = new TicketSeller(fn, ln, new Date(Integer.parseInt(bd), Integer.parseInt(bm), Integer.parseInt(by)), new Date(Integer.parseInt(hd), Integer.parseInt(hm), Integer.parseInt(hy)), new Address(hn, Integer.parseInt(sn), c), un, p);
                                Register r = new Register();
                                r.Registration(t);
                                JOptionPane.showMessageDialog(null, "Registration Successful");
                                new LoginScreen(obj);
                                dispose();
                            }
                            else if(obj2 instanceof Administrator ){
                                if (obj instanceof FoodSeller) {
                                    FoodSeller f = new FoodSeller(fn, ln, new Date(Integer.parseInt(bd), Integer.parseInt(bm), Integer.parseInt(by)), new Date(Integer.parseInt(hd), Integer.parseInt(hm), Integer.parseInt(hy)), new Address(hn, Integer.parseInt(sn), c), un, p);
                                    Register r = new Register();
                                    r.Registration(f);
                                    JOptionPane.showMessageDialog(null, "The food seller was successfully added");

                                } else if (obj instanceof TicketSeller) {
                                    TicketSeller t = new TicketSeller(fn, ln, new Date(Integer.parseInt(bd), Integer.parseInt(bm), Integer.parseInt(by)), new Date(Integer.parseInt(hd), Integer.parseInt(hm), Integer.parseInt(hy)), new Address(hn, Integer.parseInt(sn), c), un, p);
                                    Register r = new Register();
                                    r.Registration(t);
                                    JOptionPane.showMessageDialog(null, "The ticket seller was successfully added ");
                                }

                            }
                        }else
                        {
                            JOptionPane.showMessageDialog(null, "InCompatible Fields");
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error ! Maximum Number Of Employees Exist Already");
                }
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public void clearForm(){
        firstName.setText(" ");
        lastName.setText(" ");
        birthDay.setText(" ");
        birthMonth.setText(" ");
        birthYear.setText(" ");
        hireDay.setText(" ");
        hireMonth.setText(" ");
        hireYear.setText(" ");
        homeNo.setText(" ");
        streetNo.setText(" ");
        city.setText(" ");
        userName.setText(" ");
        password.setText(" ");
    }

    class HintTextField extends JTextField implements FocusListener {

        private final String hint;
        private boolean showingHint;

        public HintTextField(final String hint) {
            super(hint);
            this.hint = hint;
            this.showingHint = true;
            super.addFocusListener(this);
        }

        @Override
        public void focusGained(FocusEvent e) {
            if(this.getText().isEmpty()) {
                super.setText("");
                showingHint = false;
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            if(this.getText().isEmpty()) {
                super.setText(hint);
                showingHint = true;
            }
        }

        @Override
        public String getText() {
            return showingHint ? "" : super.getText();
        }
    }
}
