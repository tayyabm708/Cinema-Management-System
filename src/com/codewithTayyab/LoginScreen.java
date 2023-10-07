package com.codewithTayyab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LoginScreen extends JFrame {
    JLabel loginTitle;
    JLabel userLabel;
    JLabel passwordLabel;
    JTextField userName;
    JPasswordField password;
    JButton Login;
    JButton Register;
    JButton bckBtn;

    public LoginScreen(Object obj){
        super("Login Window");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(25,25,25));
        setLayout(null);

        loginTitle = new JLabel("LOGIN");
        loginTitle.setForeground(Color.ORANGE);
        loginTitle.setFont(new Font("Serif", Font.BOLD, 17));
        loginTitle.setBounds(180, 50, 200, 25);
        add(loginTitle);

        userLabel = new JLabel("User Name");
        userLabel.setForeground(Color.ORANGE);
        userLabel.setBounds(50, 100, 80, 25);
        add(userLabel);

        passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.ORANGE);
        passwordLabel.setBounds(50, 140, 80, 25);
        add(passwordLabel);

        userName=new JTextField();
        //userName.setBackground(Color.darkGray);
        userName.setBounds(140, 100, 160, 25);
        add(userName);

        password=new JPasswordField();
        //password.setBackground(Color.darkGray);
        password.setBounds(140, 140, 160, 25);
        add(password);

        Login = new JButton("login");
        Login.setBackground(Color.ORANGE);
        Login.setBounds(100, 200, 100, 25);
        add(Login);

        bckBtn = new JButton("<");
        bckBtn.setBackground(Color.ORANGE);
        bckBtn.setBounds(20,20, 20, 20);
        bckBtn.setBorder(null);
        add(bckBtn);

        bckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StatusScreen();
                dispose();

            }
        });

        Login.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                char [] pass = password.getPassword();
                String p= String.valueOf(pass);

                String resource = obj.getClass().getSimpleName();

                if(new File(resource).isFile()) {
                    if (userName.getText().isBlank() || p.isBlank())
                        JOptionPane.showMessageDialog(null, "Invalid Input");
                    else {
                        if (new Login().LoggingIn(obj, userName.getText(), p)) {

                            JOptionPane.showMessageDialog(null, "Login SuccessFul");
                            if (obj instanceof Administrator) {
                                AdminScreen s = new AdminScreen();
                                dispose();
                            } else if (obj instanceof FoodSeller) {
                                FoodList f = new FoodList(new FoodSeller());
                                dispose();
                            } else if (obj instanceof TicketSeller) {
                                MovieList m = new MovieList(new TicketSeller());
                                dispose();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Login Failed");

                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please Register First");
                }
            }
        });

        Register = new JButton("Register");
        Register.setBackground(Color.ORANGE);
        Register.setBounds(210, 200, 100, 25);
        add(Register);
        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(obj instanceof Administrator)
                {
                    dispose();
                    AdminRegisterScreen ars = new AdminRegisterScreen(obj);
                }
                else {
                    dispose();
                    RegisterScreen rs = new RegisterScreen(obj,null);
                }
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
