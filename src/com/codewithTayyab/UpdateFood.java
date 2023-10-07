package com.codewithTayyab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateFood extends JFrame {
    JLabel screenTitle;
    JLabel name;
    JTextField namefield;
    JLabel sprice;
    JTextField spricefield;
    JLabel mprice;
    JTextField mpricefield;
    JLabel lprice;
    JTextField lpricefield;
    JLabel image;
    JLabel imagedisplay;
    JButton updatebtn;
    JButton bckBtn;

    public UpdateFood(Object obj0, Object obj,String val){

        super("Moonlite Theatre");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(25,25,25));
        setLayout(null);

        FoodItem f=(FoodItem) obj;

        screenTitle = new JLabel("UPDATE FOOD");
        screenTitle.setForeground(Color.ORANGE);
        screenTitle.setFont(new Font("Serif", Font.BOLD, 17));
        screenTitle.setBounds(180, 50, 200, 25);
        add(screenTitle);

        name = new JLabel("Name:");
        name.setForeground(Color.ORANGE);
        name.setBounds(50, 100, 80, 25);
        add(name);

        namefield = new JTextField(((FoodItem) obj).getName());
        namefield.setForeground(Color.black);
        namefield.setBounds(150, 100, 100, 25);
        add(namefield);

        sprice = new JLabel("Price(Small)");
        sprice.setForeground(Color.ORANGE);
        sprice.setBounds(50, 140, 100, 25);
        add(sprice);

        spricefield = new JTextField(String.valueOf(((FoodItem) obj).getsPrice()));
        spricefield.setForeground(Color.black);
        spricefield.setBounds(150, 140, 100, 25);
        add(spricefield);

        mprice = new JLabel("Price(Medium)");
        mprice.setForeground(Color.ORANGE);
        mprice.setBounds(50, 180, 100, 25);
        add(mprice);

        mpricefield = new JTextField(String.valueOf(((FoodItem) obj).getmPrice()));
        mpricefield.setForeground(Color.black);
        mpricefield.setBounds(150, 180, 100, 25);
        add(mpricefield);

        lprice = new JLabel("Price(Large)");
        lprice.setForeground(Color.ORANGE);
        lprice.setBounds(50, 220, 80, 25);
        add(lprice);

        lpricefield = new JTextField(String.valueOf(((FoodItem) obj).getmPrice()));
        lpricefield.setForeground(Color.black);
        lpricefield.setBounds(150, 220, 100, 25);
        add(lpricefield);

        FoodItem fu = (FoodItem) obj;
        Icon img= new ImageIcon(fu.getPathname());
        imagedisplay=new JLabel();
        imagedisplay.setIcon(img);
        imagedisplay.setForeground(Color.ORANGE);
        imagedisplay.setBounds(300, 80, 200, 200);
        add(imagedisplay);

        updatebtn= new JButton("Update");
        updatebtn.setBackground(Color.ORANGE);
        updatebtn.setBounds(100,300,100,25);
        add(updatebtn);


        bckBtn = new JButton("<");
        bckBtn.setBackground(Color.ORANGE);
        bckBtn.setBounds(20,20, 20, 20);
        bckBtn.setBorder(null);
        add(bckBtn);

        bckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(obj0 instanceof Administrator) {
                    new AdminScreen();
                    dispose();
                }
                else {
                    new FoodList(new FoodSeller());
                    dispose();
                }

            }
        });

        updatebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String n=namefield.getText();
                String sP=spricefield.getText();
                String mP=mpricefield.getText();
                String lP=lpricefield.getText();
                if (n.isBlank() || sP.isBlank() || mP.isBlank() || lP.isBlank()){
                    JOptionPane.showMessageDialog(null, "Some Field is Empty ");
                }
                else {
                    if(sP.matches("-?\\d+(\\.\\d+)?") && mP.matches("-?\\d+(\\.\\d+)?") && lP.matches("-?\\d+(\\.\\d+)?")) {
                        String trash = imagedisplay.getIcon().toString();
                        FoodItem f = new FoodItem(n, Double.parseDouble(sP), Double.parseDouble(mP), Double.parseDouble(lP), trash);
                        ArrayListFiling a = new ArrayListFiling();
                        a.UpdateFromFileArray(f, val);
                        JOptionPane.showMessageDialog(null, "THe desired item is updated, Refresh to see the updated list");
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, " Please Take Care of Numerics ");
                    }
                }
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
