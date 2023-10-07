package com.codewithTayyab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatusScreen extends JFrame{
    JLabel statusTitle;
    JButton admin;
    JButton foodSeller;
    JButton ticketSeller;
    JButton user;
    JPanel panel;

    public StatusScreen(){
        super("Login Window");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel=new JPanel();
        add(panel);
        panel.setLayout(null);
        panel.setBackground(new Color(25,25,25));

        statusTitle = new JLabel("Choose your Status");
        statusTitle.setForeground(Color.ORANGE);
        statusTitle.setFont(new Font("Serif", Font.BOLD, 17));
        statusTitle.setBounds(180, 30, 200, 25);

        admin = new JButton("Admin");
        admin.setBackground(Color.ORANGE);
        admin.setBounds(210, 100, 80, 25);
        admin.setBorder(null);

        ticketSeller = new JButton("Ticket Seller");
        ticketSeller.setBackground(Color.ORANGE);
        ticketSeller.setBounds(195, 170, 110, 25);
        ticketSeller.setBorder(null);

        foodSeller= new JButton("Food Seller");
        foodSeller.setBackground(Color.ORANGE);
        foodSeller.setBounds(198, 240, 100, 25);
        foodSeller.setBorder(null);

        user= new JButton("Customer");
        user.setBackground(Color.ORANGE);
        user.setBounds(208, 310, 80, 25);
        user.setBorder(null);

        panel.add(statusTitle);
        panel.add(admin);
        panel.add(ticketSeller);
        panel.add(foodSeller);
        panel.add(user);
        add(panel);

        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new LoginScreen(new Administrator());
                dispose();

            }
        });

        ticketSeller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new LoginScreen(new TicketSeller());
                dispose();

            }
        });
        foodSeller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new LoginScreen(new FoodSeller());
                dispose();

            }
        });

        user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new UserScreen();
                dispose();
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);


    }
}
