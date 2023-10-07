package com.codewithTayyab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffScreen extends JFrame {
    JLabel screenTitle;
    JLabel option;
    JComboBox selectEmployee;
    JLabel choice;
    JComboBox selectChoice;
    JButton lock;
    JLabel label1;
    JTextField text1;
    JButton button;
    JButton bckBtn;

    public StaffScreen(){
        super("Moonlite Theatre");
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(25,25,25));
        setLayout(null);

        screenTitle = new JLabel("Manage Staff Here");
        screenTitle.setForeground(Color.ORANGE);
        screenTitle.setFont(new Font("Serif", Font.BOLD, 17));
        screenTitle.setBounds(200, 50, 200, 25);
        add(screenTitle,BorderLayout.CENTER);


        JLabel option= new JLabel("Select Employee");
        option.setForeground(Color.ORANGE);
        option.setBounds(150, 140, 110, 25);
        add(option);

        selectEmployee= new JComboBox();
        selectEmployee.setSelectedItem(null);
        selectEmployee.setBounds(270,140,100,25);
        selectEmployee.setBackground(Color.ORANGE);
        selectEmployee.setForeground(Color.black);
        selectEmployee.addItem("Ticket Seller");
        selectEmployee.addItem("Food Seller");
        add(selectEmployee);

        JLabel choose= new JLabel("Choose");
        choose.setForeground(Color.ORANGE);
        choose.setBounds(150, 190, 110, 25);
        add(choose);

        selectChoice= new JComboBox();
        selectChoice.setSelectedItem(null);
        selectChoice.setBounds(270,190,100,25);
        selectChoice.setBackground(Color.ORANGE);
        selectChoice.setForeground(Color.black);
        selectChoice.addItem("Add");
        selectChoice.addItem("Update");
        selectChoice.addItem("Delete");
        add(selectChoice);

        lock= new JButton("OK");
        lock.setBackground(Color.ORANGE);
        lock.setBounds(230, 240, 70, 25);
        add(lock);

        label1=new JLabel("Enter name");
        label1.setForeground(Color.ORANGE);
        label1.setBounds(150, 290, 110, 25);
        add(label1);
        label1.setVisible(false);

        text1= new JTextField();
        text1.setForeground(Color.black);
        text1.setBounds(270, 290, 100, 25);
        add(text1);
        text1.setVisible(false);

        button=new JButton();
        button.setBackground(Color.ORANGE);
        button.setForeground(Color.black);
        button.setBounds(230, 340, 80, 25);
        add(button);
        button.setVisible(false);


        bckBtn = new JButton("<");
        bckBtn.setBackground(Color.ORANGE);
        bckBtn.setBounds(20,20, 20, 20);
        bckBtn.setBorder(null);
        add(bckBtn);

        bckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminScreen();
                dispose();
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int index1 = selectEmployee.getSelectedIndex();
                int index2 = selectChoice.getSelectedIndex();


                //Update Ticket Seller
                if(index1==0 && index2==1){
                    Filing f= new Filing();
                    Object o=f.searchFromFile(new TicketSeller(),text1.getText());
                    if(o!=null){
                        TicketSeller t= (TicketSeller) o;
                        System.out.println("Here");
                        System.out.println(t.getFirstName());
                        new RegisterScreen(new Administrator(),t);
                        dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"The ticket Seller does not exist");
                    }
                }

                //Update Food Seller
                else if(index1==1 & index2==1){
                    Filing f= new Filing();
                    Object o=f.searchFromFile(new FoodSeller(),text1.getText());
                    if(o!=null){
                        FoodSeller obj= (FoodSeller) o;
                        RegisterScreen r=new RegisterScreen(new Administrator(),obj);
                        dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"The Food Seller does not exist");
                    }

                }
                //Delete Ticket Seller
                else if(index1==0 && index2==2){
                    String name=text1.getText();
                    Filing f= new Filing();
                    Object o=f.searchFromFile(new TicketSeller(),text1.getText());
                    if(o!=null){
                        f.deleteFromFile(new TicketSeller(), name);
                        JOptionPane.showMessageDialog(null,"Ticket Seller Successfully Deleted");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"The Ticket Seller does not exist");
                    }

                }
                //Delete Food Seller
                else if(index1==1 && index2==2){
                    String name=text1.getText();
                    Filing f= new Filing();
                    Object o=f.searchFromFile(new FoodSeller(),text1.getText());
                    if(o!=null){
                        f.deleteFromFile(new FoodSeller(), name);
                        JOptionPane.showMessageDialog(null,"Food Seller Successfully Deleted");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"The Food Seller does not exist");
                    }

                }
            }
        });




        lock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int index1 = selectEmployee.getSelectedIndex();
                int index2 = selectChoice.getSelectedIndex();

                //Add Ticket Seller
                if(index1==0 && index2==0){
                    label1.setVisible(false);
                    text1.setVisible(false);
                    button.setVisible(false);
                    RegisterScreen r=new RegisterScreen(new TicketSeller(),new Administrator());
                    dispose();
                }
                //Add Food Seller
                else if(index1==1 && index2==0){
                    label1.setVisible(false);
                    text1.setVisible(false);
                    button.setVisible(false);
                    RegisterScreen r=new RegisterScreen(new FoodSeller(),new Administrator());
                    dispose();

                }
                //update
                else if(index2==1){
                    label1.setVisible(true);
                    text1.setVisible(true);
                    button.setText("Update");
                    button.setVisible(true);
                }
                //delete
                else if(index2==2){
                    label1.setVisible(true);
                    text1.setVisible(true);
                    button.setText("Delete");
                    button.setVisible(true);

                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);






    }

}
