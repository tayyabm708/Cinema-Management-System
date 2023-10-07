package com.codewithTayyab;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AddFood extends JFrame{
    JLabel screenTitle;
    JLabel name;
    JTextField namefield;
    JLabel sprice;
    JTextField spricefield;
    JLabel mprice;
    JTextField mpricefield;
    JLabel lprice;
    JTextField lpricefield;
    JLabel imagedisplay;
    JButton choosePoster;
    JButton addbtn;
    JButton bckBtn;

    public AddFood(Object obj){
        super("Moonlite Theatre");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(25,25,25));
        setLayout(null);


        screenTitle = new JLabel("ADD FOOD");
        screenTitle.setForeground(Color.ORANGE);
        screenTitle.setFont(new Font("Serif", Font.BOLD, 17));
        screenTitle.setBounds(180, 50, 200, 25);
        add(screenTitle);

        name = new JLabel("Name:");
        name.setForeground(Color.ORANGE);
        name.setBounds(50, 100, 80, 25);
        add(name);


        namefield = new JTextField();
        namefield.setForeground(Color.black);
        namefield.setBounds(150, 100, 100, 25);
        add(namefield);


        sprice = new JLabel("Price(Small)");
        sprice.setForeground(Color.ORANGE);
        sprice.setBounds(50, 140, 100, 25);
        add(sprice);

        spricefield = new JTextField();
        spricefield.setForeground(Color.black);
        spricefield.setBounds(150, 140, 100, 25);
        add(spricefield);

        mprice = new JLabel("Price(Medium)");
        mprice.setForeground(Color.ORANGE);
        mprice.setBounds(50, 180, 100, 25);
        add(mprice);

        mpricefield = new JTextField();
        mpricefield.setForeground(Color.black);
        mpricefield.setBounds(150, 180, 100, 25);
        add(mpricefield);

        lprice = new JLabel("Price(Large)");
        lprice.setForeground(Color.ORANGE);
        lprice.setBounds(50, 220, 80, 25);
        add(lprice);

        lpricefield = new JTextField();
        lpricefield.setForeground(Color.black);
        lpricefield.setBounds(150, 220, 100, 25);
        add(lpricefield);

        imagedisplay=new JLabel();
        imagedisplay.setBackground(Color.ORANGE);
        imagedisplay.setBounds(300, 100, 200, 150);
        add(imagedisplay);

        choosePoster=new JButton("Choose poster");
        choosePoster.setBackground(Color.ORANGE);
        choosePoster.setBounds(310,260,120,25);
        add(choosePoster);

        addbtn= new JButton("Add food");
        addbtn.setBackground(Color.ORANGE);
        addbtn.setBounds(100,300,100,25);
        add(addbtn);


        bckBtn = new JButton("<");
        bckBtn.setBackground(Color.ORANGE);
        bckBtn.setBounds(20,20, 20, 20);
        bckBtn.setBorder(null);
        add(bckBtn);

        bckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(obj instanceof Administrator) {
                    new AdminScreen();
                    dispose();
                }
                else {
                    new FoodList(new FoodSeller());
                    dispose();
                }

            }
        });

        choosePoster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser file=new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter=new FileNameExtensionFilter("JPEG file","jpg","jpeg");
                file.addChoosableFileFilter(filter);
                int result=file.showSaveDialog(null);
                if(result==JFileChooser.APPROVE_OPTION){
                    File selectedFile=file.getSelectedFile();
                    String path=selectedFile.getAbsolutePath();
                    ImageIcon img=new ImageIcon(path);
                    imagedisplay.setIcon(img);
                }
                else if(result==JFileChooser.CANCEL_OPTION){
                    JOptionPane.showMessageDialog(null,"No file selected");
                }


            }
        });

        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String n=namefield.getText();
                String sP=spricefield.getText();
                String mP=mpricefield.getText();
                String lP=lpricefield.getText();
                if (n.isBlank() || sP.isBlank() || mP.isBlank() || lP.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Some Field is Empty ");}
                else{
                    if(sP.matches("-?\\d+(\\.\\d+)?+") && mP.matches("-?\\d+(\\.\\d+)?") && lP.matches("-?\\d+(\\.\\d+)?")){
                        if(imagedisplay.getIcon()==null){
                            JOptionPane.showMessageDialog(null,"Please select an image");
                        }
                        String trash=imagedisplay.getIcon().toString();
                        FoodItem f= new FoodItem(n, Double.parseDouble(sP),Double.parseDouble(mP),Double.parseDouble(lP),trash);
                        ArrayListFiling a=new ArrayListFiling();
                        a.writeToFileArray(f);
                        JOptionPane.showMessageDialog(null,"THe desired item is added, Refresh to see the updated list");
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
