package com.codewithTayyab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminScreen extends JFrame {
    JLabel screenTitle;
    JButton movielist;
    JButton foodlist;
    JButton staff;
    JPanel panel;
    JButton bckBtn;

    public AdminScreen(){
        super("Moonlite Theatre");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel=new JPanel();
        add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.black);

        screenTitle = new JLabel("Where would you like to go");
        screenTitle.setForeground(Color.ORANGE);
        screenTitle.setFont(new Font("Serif", Font.BOLD, 17));
        screenTitle.setBounds(155, 50, 200, 25);

        movielist = new JButton("Manage Movie List");
        movielist.setBackground(Color.ORANGE);
        movielist.setBounds(168, 150, 150, 25);

        foodlist= new JButton("Manage Food List");
        foodlist.setBackground(Color.ORANGE);
        foodlist.setBounds(172, 200, 140, 25);

        staff= new JButton("Manage Staff");
        staff.setBackground(Color.ORANGE);
        staff.setBounds(180, 250, 120, 25);

        bckBtn = new JButton("<");
        bckBtn.setBackground(Color.ORANGE);
        bckBtn.setBounds(20,20, 20, 20);
        bckBtn.setBorder(null);

        panel.add(screenTitle);
        panel.add(movielist);
        panel.add(foodlist);
        panel.add(staff);
        panel.add(bckBtn);
        add(panel);


        bckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StatusScreen();
                dispose();
            }
        });

        movielist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new MovieList(new Administrator());
                dispose();

            }
        });

        foodlist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new FoodList(new Administrator());
                dispose();

            }
        });

        staff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new StaffScreen();
                dispose();
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);



    }

}
