package com.codewithTayyab;

import java.io.*;
import java.util.ArrayList;

public class ArrayListFiling {

    public ArrayListFiling(){
    }

    public void writeToFileArray(Object ob){
        ArrayList<Object> list =readFromFileArray(ob);
        list.add(ob);
        String resource=ob.getClass().getSimpleName();
        try{
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(resource));
            output.writeObject(list);
            output.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<Object> readFromFileArray(Object w){
        String resource=w.getClass().getSimpleName();
        File obj= new File(resource);
        try {
            if(obj.createNewFile()){
                System.out.println("File created");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Object> list = new ArrayList <Object>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(resource));
            list = (ArrayList<Object>) input.readObject();
        }
        catch (EOFException | FileNotFoundException e) {
            return list;
        }
        catch(ClassCastException | ClassNotFoundException | IOException c)
        {
            c.printStackTrace();
        }
        return list;
    }

    public void saveChanges(Object ob,ArrayList<Object> list){
        String resource=ob.getClass().getSimpleName();
        File obj= new File(resource);
        try{
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(resource));
            output.writeObject(list);
            output.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public boolean deleteFromFileArray(Object ob,String del)
    {
        String resource=ob.getClass().getSimpleName();
        File obj= new File(resource);
        try {
            if(obj.createNewFile()){
                System.out.println("File created");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ArrayList<Object> list = readFromFileArray(ob);
            if(ob instanceof FoodItem){
                for(Object o : list){
                    FoodItem com = (FoodItem) o;
                    if(com.getName().equalsIgnoreCase(del)){
                        list.remove(o);
                        saveChanges(new FoodItem(),list);
                        return true;
                    }
                }
            }
            else if(ob instanceof MovieItem){
                for(Object o : list){
                    MovieItem com = (MovieItem) o;
                    if(com.getName().equalsIgnoreCase(del)){
                        list.remove(o);
                        saveChanges(new MovieItem(),list);
                        return true;
                    }
                }
            }
        }
        catch(ClassCastException c)
        {
            c.printStackTrace();
        }
        return false;
    }

    public boolean UpdateFromFileArray(Object ob,String del)
    {
        String resource=ob.getClass().getSimpleName();
        File obj= new File(resource);
        try {
            if(obj.createNewFile()){
                System.out.println("File created");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ArrayList<Object> list = readFromFileArray(ob);
            int i = 0;
            if(ob instanceof FoodItem){
                for(Object o : list){
                    FoodItem com = (FoodItem) o;
                    if(com.getName().equalsIgnoreCase(del)){
                        list.set(i,ob);
                        saveChanges(new FoodItem(),list);
                        return true;
                    }
                    i++;
                }
            }
            else if(ob instanceof MovieItem){
                for(Object o : list){
                    MovieItem com = (MovieItem) o;
                    if(com.getName().equalsIgnoreCase(del)){
                        list.set(i,ob);
                        saveChanges(new MovieItem(),list);
                        return true;
                    }
                    i++;
                }
            }
        }

        catch(ClassCastException c)
        {
            c.printStackTrace();
        }
        return false;
    }

    public void displayArray(Object v ){
        ArrayList<Object> list = readFromFileArray(v);
        for(Object s :list){
            if(s instanceof FoodItem){
                System.out.println(s.toString());
            }
            if(s instanceof MovieItem){
                System.out.println(s.toString());
            }
        }
    }
}
