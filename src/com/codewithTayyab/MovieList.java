package com.codewithTayyab;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MovieList extends JFrame{
    JLabel imglabel;
    JLabel screenTitle;
    JTable table;
    JScrollPane scroll;
    JButton addbtn;
    JButton updatebtn;
    JButton deletebtn;
    JButton refreshbtn;
    JButton addtocart;
    JButton buynow;
    JTextArea cart;
    String s=" ";
    String[] rowFields;
    ArrayList<MovieItem> store = new ArrayList <MovieItem>();
    String[] headers = {"Name", "Genre", "Standard Price", "Executive Price", "Rating", "Image"};
    JButton bckBtn;

    public MovieList(Object obj) {
        super("Movie Screen");
        setSize(810, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(25,25,25));

        screenTitle = new JLabel("MOVIE LIST");
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

        table = new JTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(headers);
        ArrayListFiling lf = new ArrayListFiling();
        MovieItem m = new MovieItem();
        ArrayList<Object> list = lf.readFromFileArray(m);
        Object[] rowData = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof MovieItem) {
                rowData[0] = ((MovieItem) list.get(i)).getName();
                rowData[1] = ((MovieItem) list.get(i)).getGenre();
                rowData[2] = ((MovieItem) list.get(i)).getStandardTicket();
                rowData[3] = ((MovieItem) list.get(i)).getExecutiveTicket();
                rowData[4] = ((MovieItem) list.get(i)).getRating();
                Icon img = new ImageIcon(((MovieItem) list.get(i)).getPath());
                imglabel = new JLabel();
                imglabel.setIcon(img);
                rowData[5] = imglabel;
                model.addRow(rowData);
            }
        }
        table.getColumn("Image").setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                return (Component) value;
            }
        });
        table.setModel(model);
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumn("Name").setCellRenderer(dtcr);
        table.getColumn("Genre").setCellRenderer(dtcr);
        table.getColumn("Standard Price").setCellRenderer(dtcr);
        table.getColumn("Executive Price").setCellRenderer(dtcr);
        table.getColumn("Rating").setCellRenderer(dtcr);
        table.getTableHeader().setBackground(Color.ORANGE);
        table.getTableHeader().setForeground(Color.black);

        table.setRowHeight(200);
        table.setBackground(new Color(25,25,25));
        table.setForeground(Color.ORANGE);
        table.setFillsViewportHeight(true);

        scroll = new JScrollPane(table);
        scroll.setBounds(0, 50, 800, 600);
        add(scroll);



        addbtn = new JButton("Add Movie");
        addbtn.setBackground(Color.ORANGE);
        addbtn.setBounds(50, 680, 100, 25);
        add(addbtn);


        updatebtn = new JButton("Update");
        updatebtn.setBackground(Color.ORANGE);
        updatebtn.setBounds(200, 680, 100, 25);
        add(updatebtn);

        deletebtn = new JButton("Delete Movie");
        deletebtn.setBackground(Color.ORANGE);
        deletebtn.setBounds(350, 680, 150, 25);
        add(deletebtn);

        refreshbtn = new JButton("Refresh Changes");
        refreshbtn.setBackground(Color.ORANGE);
        refreshbtn.setBounds(550, 680, 150, 25);
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
            table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            cart=new JTextArea();
            cart.setText("Cart is empty");
            cart.setBackground(Color.ORANGE);
            cart.setBounds(210, 680, 130, 70);
            add(cart);

            addtocart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    int row=table.getSelectedRow();
                    String n=table.getValueAt(row,0).toString();
                    String g=table.getValueAt(row,1).toString();
                    double sT=Double.parseDouble(table.getValueAt(row,2).toString());
                    double eT=Double.parseDouble(table.getValueAt(row,3).toString());
                    float  r=Float.parseFloat(table.getValueAt(row,4).toString());
                    JLabel templabel = (JLabel) model.getValueAt(row, 5);
                    String p = templabel.getIcon().toString();
                    cart.setText(s+System.lineSeparator()+table.getValueAt(row,0).toString()+System.lineSeparator()+"\n");
                    s= s+table.getValueAt(row,0).toString();

                    MovieItem obj= new MovieItem(n,g,sT,eT,r,p);
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
                    Invoice i=new Invoice(obj,store);
                    dispose();
                }
            });

        }

        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(obj instanceof Administrator) {
                    new AddMovie(new Administrator());
                    dispose();
                }
                else {
                    new AddMovie(new TicketSeller());
                    dispose();
                }
            }
        });

        updatebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Please Select a row to update");
                } else {
                    String value = table.getModel().getValueAt(row, 0).toString();
                    rowFields = new String[table.getColumnCount()];
                    for (int i = 0; i < table.getColumnCount(); i++) {
                        if (i == 5) {
                            JLabel templabel = (JLabel) model.getValueAt(row, i);
                            String trash = templabel.getIcon().toString();
                            System.out.println(trash);
                            rowFields[i] = trash;
                        } else {
                            rowFields[i] = table.getValueAt(row, i).toString();
                        }
                        System.out.println(rowFields[i]);
                    }
                    String n = rowFields[0];
                    String g = rowFields[1];
                    double st = Double.parseDouble(rowFields[2]);
                    double et = Double.parseDouble(rowFields[3]);
                    float r = Float.parseFloat(rowFields[4]);
                    String path = rowFields[5];
                    MovieItem f = new MovieItem(n, g, st, et, r, path);
                    UpdateMovie uf = new UpdateMovie(obj,f, value);
                    dispose();
                }
            }
        });

        deletebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayListFiling a = new ArrayListFiling();
                MovieItem f= new MovieItem();
                int row=table.getSelectedRow();
                System.out.println(row);
                if(row==-1){
                    JOptionPane.showMessageDialog(null,"Please Select a row to Delete");
                }
                else{
                    String value=table.getModel().getValueAt(row,0).toString();
                    a.deleteFromFileArray(f,value);
                    JOptionPane.showMessageDialog(null,"THe desired item is deleted, Refresh to see the updated list");
                }
            }
        });

        refreshbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Administrator a=new Administrator();
                new MovieList(a);
                dispose();
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
