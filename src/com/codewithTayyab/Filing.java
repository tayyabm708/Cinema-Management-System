package com.codewithTayyab;

import java.io.*;

public class Filing implements Serializable {
    public Filing(){
    }

    public void writeToFile(Object o){
        String resource=o.getClass().getSimpleName();
        try
        {
            ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream(resource,true));
            output.writeObject(o);
            output.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public int NumberOf(Object o){
        int no = -1;
        String resource=o.getClass().getSimpleName();
        boolean EndOfFile=false;
        try {
            FileInputStream fis = new FileInputStream(resource);
            ObjectInputStream input = null;
            while (!EndOfFile) {
                no++;
                input = new ObjectInputStream(fis);
                if(o instanceof Administrator){
                    Administrator temp = (Administrator) input.readObject();
                }
                else if(o instanceof FoodSeller){
                    FoodSeller temp = (FoodSeller) input.readObject();
                }
                else if(o instanceof TicketSeller){
                    TicketSeller temp = (TicketSeller) input.readObject();
                }
            }
            input.close();
        }
        catch(EOFException i){
            EndOfFile=true;
        }
        catch(FileNotFoundException e){
            return 0;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return no;
    }

    public boolean deleteFromFile(Object o, String name){
        String resource=o.getClass().getSimpleName();
        boolean EndOfFile=false;
        Object [] array = new Object[3];
        int ignore = -1;
        int x = 0;
        try {
            FileInputStream fis = new FileInputStream(resource);
            ObjectInputStream input = null;
            while (!EndOfFile) {
                input = new ObjectInputStream(fis);
                Object temp;
                temp=input.readObject();
                array[x]=temp;
                x++;
            }
            input.close();
        }
        catch(EOFException e){
            EndOfFile=true;
            int no = NumberOf(o);
            no--;
            if (o instanceof FoodSeller) {
                for (int i = 0; i <= no; i++) {
                    FoodSeller temp = (FoodSeller) array[i];
                    if (temp.getFirstName().equalsIgnoreCase(name)) {
                        ignore = i;
                        try {
                            new FileOutputStream(resource).close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int j = 0; j <= no; j++) {
                            if(j==ignore)
                                continue;
                            else
                                writeToFile(array[j]);
                        }
                        return true;
                    }
                }
            }
            if (o instanceof TicketSeller) {
                for (int i = 0; i <= no; i++) {
                    TicketSeller temp = (TicketSeller) array[i];
                    if (temp.getFirstName().equalsIgnoreCase(name)) {
                        ignore = i;
                        try {
                            new FileOutputStream(resource).close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int j = 0; j <= no; j++) {
                            if(j==ignore)
                                continue;
                            writeToFile(array[j]);
                        }
                        return true;
                    }
                }
            }
        }

        catch(FileNotFoundException e){
            return false;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateFromFile(Object o,String name ,Object u){
        String resource=o.getClass().getSimpleName();
        boolean EndOfFile=false;
        Object [] array = new Object[3];
        int ignore = -1;
        int x = 0;
        try {
            FileInputStream fis = new FileInputStream(resource);
            ObjectInputStream input = null;
            while (!EndOfFile) {
                input = new ObjectInputStream(fis);
                Object temp;
                temp=input.readObject();
                array[x]=temp;
                x++;
            }
            input.close();
        }
        catch(EOFException e){
            EndOfFile=true;
            int no = NumberOf(o);
            no--;
            if (o instanceof FoodSeller) {
                for (int i = 0; i <= no; i++) {
                    FoodSeller temp = (FoodSeller) array[i];
                    if (temp.getFirstName().equalsIgnoreCase(name)) {
                        array[i]=u;
                        try {
                            new FileOutputStream(resource).close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int j = 0; j <= no; j++) {
                            writeToFile(array[j]);
                        }
                        return true;
                    }
                }
            }
            if (o instanceof TicketSeller) {
                for (int i = 0; i <= no; i++) {
                    TicketSeller temp = (TicketSeller) array[i];
                    if (temp.getFirstName().equalsIgnoreCase(name)) {
                        array[i]=u;
                        try {
                            new FileOutputStream(resource).close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        for (int j = 0; j <= no; j++) {
                            writeToFile(array[j]);
                        }
                        return true;
                    }
                }
            }
        }
        catch(FileNotFoundException e){
            return false;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean readFromFile(Object o,String u ,String p){
        String resource= o.getClass().getSimpleName();
        boolean EndOfFile=false;
        try {
            FileInputStream fis = new FileInputStream(resource);
            ObjectInputStream input = null;
            while (!EndOfFile) {
                input = new ObjectInputStream(fis);
                if(o instanceof Administrator){
                    Administrator temp = (Administrator) input.readObject();
                    if(temp.getUsername().equalsIgnoreCase(u) && temp.getPassword().equals(p))
                        return true;
                }
                else if(o instanceof FoodSeller){
                    FoodSeller temp = (FoodSeller) input.readObject();
                    if(temp.getUsername().equalsIgnoreCase(u) && temp.getPassword().equals(p))
                        return true;
                }
                else if(o instanceof TicketSeller){
                    TicketSeller temp = (TicketSeller) input.readObject();
                    if(temp.getUsername().equalsIgnoreCase(u) && temp.getPassword().equals(p))
                        return true;
                }
            }
            input.close();
        }
        catch(EOFException i){
            EndOfFile=true;
        }
        catch(FileNotFoundException e){
            return false;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Object searchFromFile(Object o,String n){
        String resource=o.getClass().getSimpleName();
        boolean EndOfFile=false;
        try {
            FileInputStream fis = new FileInputStream(resource);
            ObjectInputStream input = null;
            while (!EndOfFile) {
                input = new ObjectInputStream(fis);
                if(o instanceof FoodSeller){
                    FoodSeller temp = (FoodSeller) input.readObject();
                    if(temp.getFirstName().equalsIgnoreCase(n))
                        return temp;
                }
                else if(o instanceof TicketSeller){
                    TicketSeller temp = (TicketSeller) input.readObject();
                    if(temp.getFirstName().equalsIgnoreCase(n))
                        return temp;
                }
            }
            input.close();
        }
        catch(EOFException i){
            EndOfFile=true;
            return null;
        }
        catch(FileNotFoundException e){
            return false;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void displayFromFile(Object o){
        String resource=o.getClass().getSimpleName();
        boolean EndOfFile=false;
        try {
            FileInputStream fis = new FileInputStream(resource);
            ObjectInputStream input = null;
            while (!EndOfFile) {
                input = new ObjectInputStream(fis);
                if(o instanceof Administrator){
                    Administrator temp = (Administrator) input.readObject();
                    System.out.println(temp.getFirstName()+temp.getLastName());
                }
                else if(o instanceof FoodSeller){
                    FoodSeller temp = (FoodSeller) input.readObject();
                    System.out.println(temp.getFirstName()+temp.getLastName());
                }
                else if(o instanceof TicketSeller){
                    TicketSeller temp = (TicketSeller) input.readObject();
                    System.out.println(temp.getFirstName()+temp.getLastName());
                }
            }
            input.close();
        }
        catch(EOFException i){
            EndOfFile=true;
        }
        catch(FileNotFoundException e){
            return;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
