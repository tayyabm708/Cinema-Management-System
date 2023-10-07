package com.codewithTayyab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserScreen extends JFrame {
    JLabel screenTitle;
    JButton MovieCorner ;
    JButton FoodCorner;

    JButton bckBtn;




    public UserScreen(){
        super("Food Screen");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.black);
        setLayout(null);

        screenTitle = new JLabel("Where would you like to go ");
        screenTitle.setForeground(Color.ORANGE);
        screenTitle.setFont(new Font("Serif", Font.BOLD, 17));
        screenTitle.setBounds(140, 50, 200, 25);

        MovieCorner = new JButton("Movie Mania");
        MovieCorner.setBackground(Color.ORANGE);
        MovieCorner.setBounds(180, 100, 110, 25);

        FoodCorner = new JButton("Food Dash");
        FoodCorner.setBackground(Color.ORANGE);
        FoodCorner.setBounds(180, 150, 110, 25);

        bckBtn = new JButton("<");
        bckBtn.setBackground(Color.ORANGE);
        bckBtn.setBounds(20,20, 20, 20);
        bckBtn.setBorder(null);

        add(screenTitle);
        add(MovieCorner);
        add(FoodCorner);
        add(bckBtn);

        bckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StatusScreen();
                dispose();

            }
        });


        MovieCorner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new MovieList(new User());
                dispose();

            }
        });

        FoodCorner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new FoodList(new User());
                dispose();

            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
