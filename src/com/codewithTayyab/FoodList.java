package com.codewithTayyab;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FoodList extends JFrame {
    JPanel panel;
    JLabel imglabel;
    JLabel screenTitle;
    JTable foodtable;
    JScrollPane scroll;
    JButton addbtn;
    JButton updatebtn;
    JButton deletebtn;
    JButton refreshbtn;
    JButton addtocart;
    JButton buynow;
    JTextArea cart;
    String s=" ";
    String rowFields[];
    ArrayList<FoodItem> store = new ArrayList <FoodItem>();
    String[] headers = { "Name", "Price(small)","Price(medium)","Price(large)","Image"};
    JButton bckBtn;



    public FoodList(Object obj){
        super("Food Screen");
        setSize(810,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(25,25,25));


        screenTitle = new JLabel("FOOD LIST");
        screenTitle.setForeground(Color.ORANGE);
        screenTitle.setFont(new Font("Serif", Font.BOLD, 17));
        screenTitle.setBounds(320, 10, 200, 25);
        add(screenTitle);

        bckBtn = new JButton("<");
        bckBtn.setBackground(Color.ORANGE);
        bckBtn.setBounds(20,20, 20, 20);
        bckBtn.setBorder(null);
        add(bckBtn);

        bckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(obj instanceof Administrator)
                {
                    new AdminScreen();
                    dispose();

                }
                else{
                    new StatusScreen();
                    dispose();
                }

            }
        });

        foodtable=new JTable();

        DefaultTableModel model=(DefaultTableModel) foodtable.getModel();

        model.setColumnIdentifiers(headers);
        ArrayListFiling lf= new ArrayListFiling();
        FoodItem m=new FoodItem();
        ArrayList<Object> list= lf.readFromFileArray(m);
        Object[] rowData = new Object[5];

        for(int i=0; i<list.size(); i++){
            if(list.get(i) instanceof FoodItem){
                rowData[0]=((FoodItem) list.get(i)).getName();
                rowData[1]=((FoodItem) list.get(i)).getsPrice();
                rowData[2]=((FoodItem) list.get(i)).getmPrice();
                rowData[3]=((FoodItem) list.get(i)).getlPrice();
                Icon img= new ImageIcon(((FoodItem) list.get(i)).getPathname());
                imglabel=new JLabel();
                imglabel.setIcon(img);
                rowData[4]=imglabel;
                model.addRow(rowData);
            }
        }
        foodtable.getColumn("Image").setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                return (Component) value;
            }
        });
        // foodtable.getColumn("Image").setMaxWidth(400);
        foodtable.setModel(model);
        DefaultTableCellRenderer dtcr= new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        foodtable.getColumn("Name").setCellRenderer(dtcr);
        foodtable.getColumn("Price(small)").setCellRenderer(dtcr);
        foodtable.getColumn("Price(medium)").setCellRenderer(dtcr);
        foodtable.getColumn("Price(large)").setCellRenderer(dtcr);
        foodtable.getColumn("Image").setPreferredWidth(60);
        foodtable.getTableHeader().setBackground(Color.ORANGE);
        foodtable.getTableHeader().setForeground(Color.black);

        foodtable.setRowHeight(200);
        foodtable.setBackground(new Color(25,25,25));
        foodtable.setForeground(Color.ORANGE);
        //foodtable.setPreferredScrollableViewportSize(new Dimension(100,200));
        foodtable.setFillsViewportHeight(true);

        scroll=new JScrollPane(foodtable);
        scroll.setBounds(0,50,800,600);
        // scroll.setMaximumSize(new Dimension(200,200));
        add(scroll);

        addbtn= new JButton("Add food");
        addbtn.setBackground(Color.ORANGE);
        addbtn.setBounds(100,680,100,25);
        add(addbtn);

        updatebtn= new JButton("Update");
        updatebtn.setBackground(Color.ORANGE);
        updatebtn.setBounds(250,680,100,25);
        add(updatebtn);

        deletebtn= new JButton("Delete food");
        deletebtn.setBackground(Color.ORANGE);
        deletebtn.setBounds(400,680,100,25);
        add(deletebtn);

        refreshbtn= new JButton("Refresh Changes");
        refreshbtn.setBackground(Color.ORANGE);
        refreshbtn.setBounds(550,680,150,25);
        add(refreshbtn);


        if(obj instanceof User){
            addbtn.setVisible(false);
            updatebtn.setVisible(false);
            deletebtn.setVisible(false);
            refreshbtn.setVisible(false);

            addtocart=new JButton("Add to cart");
            addtocart.setBackground(Color.ORANGE);
            addtocart.setBounds(100, 680, 100, 25);
            add(addtocart);
            buynow = new JButton("Buynow");
            buynow.setBackground(Color.ORANGE);
            buynow.setBounds(350, 680, 100, 25);
            add(buynow);
            foodtable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            cart=new JTextArea();
            cart.setText("Cart is empty");
            cart.setBackground(Color.ORANGE);
            cart.setBounds(210, 680, 130, 70);
            add(cart);

            addtocart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    int row=foodtable.getSelectedRow();
                    String n=foodtable.getValueAt(row,0).toString();
                    double sP=Double.parseDouble(foodtable.getValueAt(row,1).toString());
                    double mP=Double.parseDouble(foodtable.getValueAt(row,2).toString());
                    double lP=Double.parseDouble(foodtable.getValueAt(row,3).toString());

                    JLabel templabel = (JLabel) model.getValueAt(row, 4);
                    String p = templabel.getIcon().toString();
                    cart.setText(s+System.lineSeparator()+foodtable.getValueAt(row,0).toString()+System.lineSeparator()+"\n");
                    s= s+foodtable.getValueAt(row,0).toString();

                    FoodItem obj= new FoodItem(n,sP,mP,lP,p);
                    //to handle duplicate clicks
                    boolean isPresent=false;
                    for(int i=0; i<store.size(); i++ ) {
                        if (store.get(i).getName().equals(n)) {
                            isPresent=true;
                        }
                    }
                    if(!isPresent){
                        store.add(obj);
                    }

                }
            });

            buynow.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    InvoiceFood i=new InvoiceFood(obj,store);
                    dispose();
                }
            });
        }

        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(obj instanceof Administrator) {
                    new AddFood(new Administrator());
                    dispose();
                }
                else {
                    new AddFood(new FoodSeller());
                    dispose();
                }
            }
        });

        updatebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row = foodtable.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Please Select a row to update");
                } else {
                    String value = foodtable.getModel().getValueAt(row, 0).toString();
                    rowFields = new String[foodtable.getColumnCount()];
                    for (int i = 0; i < foodtable.getColumnCount(); i++) {
                        if (i == 4) {
                            JLabel templabel = (JLabel) model.getValueAt(row, i);
                            String trash = templabel.getIcon().toString();
                            System.out.println(trash);
                            rowFields[i] = trash;
                        } else {
                            rowFields[i] = foodtable.getValueAt(row, i).toString();
                        }
                        System.out.println(rowFields[i]);
                    }

                    String n = rowFields[0];
                    double sP = Double.parseDouble(rowFields[1]);
                    double mP = Double.parseDouble(rowFields[2]);
                    double lP = Double.parseDouble(rowFields[3]);
                    String path = rowFields[4];
                    FoodItem f = new FoodItem(n, sP, mP, lP, path);
                    UpdateFood uf = new UpdateFood(obj,f, value);
                    dispose();
                }
            }
        });

        deletebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayListFiling a = new ArrayListFiling();
                FoodItem f= new FoodItem();
                int row=foodtable.getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(null,"Please Select a row to Delete");
                }
                else{
                    String value=foodtable.getModel().getValueAt(row,0).toString();
                    a.deleteFromFileArray(f,value);
                    JOptionPane.showMessageDialog(null,"THe desired item is deleted, Refresh to see the updated list");
                }
            }
        });

        refreshbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Administrator a=new Administrator();
                FoodList f3=new FoodList(a);
                dispose();
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
