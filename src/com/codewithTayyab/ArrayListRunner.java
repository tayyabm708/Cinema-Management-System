package com.codewithTayyab;

public class ArrayListRunner {
    public static void main(String[] args) {
        ArrayListFiling a= new ArrayListFiling();
        MovieItem m1= new MovieItem("Moana","Animation",500,1000,4.5f,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\moana.jpeg");
        MovieItem m2= new MovieItem("Frozen","Animation",600,800,5.2f,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\frozen.jpeg");
        MovieItem m3= new MovieItem("Brave","Animation",550,1000,7.2f,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\brave.jpeg");
        MovieItem m4= new MovieItem("Abominable","Adventure",600,1200,7.6f,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\abominable.jpeg");
        MovieItem m5= new MovieItem("Beauty and the beast","Fantasy",620,1050,6f,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\beauty.jpeg");
        MovieItem m6= new MovieItem("Big Hero 6","Fiction",700,1000,7.5f,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\kungfupanda3.jpeg");
        MovieItem m7= new MovieItem("Cars","Animation",550,900,7.1f,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\bighero6.jpeg");
        MovieItem m8= new MovieItem("Finding Nemo","Family",500,1200,6.8f,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\cars.jpeg");
        MovieItem m9= new MovieItem("Inside out","Family",550,1000,6.2f,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\findingnemo.jpeg");
        MovieItem m10= new MovieItem("Kung fu Panda 3","Action/Comedy",700,1400,8.2f,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\insideout.jpeg");
        MovieItem m11= new MovieItem("Lion King","Family",530,1100,6.3f,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\lionking.jpeg");
        MovieItem m12= new MovieItem("Ratatouille","Adventure",630,1000,5.2f,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\ratatouille.jpeg");
        MovieItem m13= new MovieItem("Tangled","Fantasy",500,800,5.6f,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\tangled.jpeg");
        MovieItem m14= new MovieItem("Toy Story 4","Animation",530,1100,6.3f,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\toystory4.jpeg");
        MovieItem m15= new MovieItem("Up","family",630,1000,5.2f,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\up.jpeg");
        MovieItem m16= new MovieItem("Wall E","Fantasy",500,800,5.6f,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\walle.jpeg");
        MovieItem m17= new MovieItem("Wrack It Ralph","Animation",500,800,5.1f,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\wreckitralph.jpeg");
        MovieItem m18= new MovieItem("Zootopia","Adventure",500,800,6.2f,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\zootopia.jpeg");


        a.writeToFileArray(m1);
        a.writeToFileArray(m2);
        a.writeToFileArray(m3);
        a.writeToFileArray(m4);
        a.writeToFileArray(m5);
        a.writeToFileArray(m6);
        a.writeToFileArray(m7);
        a.writeToFileArray(m8);
        a.writeToFileArray(m9);
        a.writeToFileArray(m10);
        a.writeToFileArray(m11);
        a.writeToFileArray(m12);
        a.writeToFileArray(m13);
        a.writeToFileArray(m14);
        a.writeToFileArray(m15);
        a.writeToFileArray(m16);
        a.writeToFileArray(m17);
        a.writeToFileArray(m18);
        a.displayArray(m1);

        FoodItem f1= new FoodItem("Waffle Fries", 30, 40, 70,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\1.jpg");
        FoodItem f2= new FoodItem("Double-Double", 30, 40, 70,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\2.jpg");
        FoodItem f3= new FoodItem("French Fries", 30, 40, 70,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\3.jpg");
        FoodItem f4= new FoodItem("Chicken Popeyes", 30, 40, 70,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\4.jpg");
        FoodItem f5= new FoodItem("Chicken Sandwich", 30, 40, 70,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\5.jpg");
        FoodItem f6= new FoodItem(" Curly Fries", 30, 40, 70,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\6.jpg");
        FoodItem f7= new FoodItem("Blizzard", 30, 40, 70,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\7.jpg");
        FoodItem f8= new FoodItem("Tacos", 30, 40, 70,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\8.jpg");
        FoodItem f9= new FoodItem("Soft Tacos", 30, 40, 70,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\9.jpg");
        FoodItem f10= new FoodItem("Biscuit", 30, 40, 70,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\10.jpg");
        FoodItem f11= new FoodItem("Cheese Curds ", 30, 40, 70,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\11.jpg");
        FoodItem f12= new FoodItem("Pop Corn", 30, 40, 70,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\12.jpg");
        FoodItem f13= new FoodItem("Cheese Corns", 30, 40, 70,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\13.jpg");
        FoodItem f14= new FoodItem("Lays", 30, 40, 70,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\14.jpg");
        FoodItem f15= new FoodItem("Cold Drinks", 30, 40, 70,"E:\\COMSATS\\SEMESTER # 03\\OOP\\OOP PRACTICE\\SEMESTER PROJECTS\\Theatre Management System\\src\\Images\\images.jpg");


        a.writeToFileArray(f1);
        a.writeToFileArray(f2);
        a.writeToFileArray(f3);
        a.writeToFileArray(f4);
        a.writeToFileArray(f5);
        a.writeToFileArray(f6);
        a.writeToFileArray(f7);
        a.writeToFileArray(f8);
        a.writeToFileArray(f9);
        a.writeToFileArray(f10);
        a.writeToFileArray(f11);
        a.writeToFileArray(f12);
        a.writeToFileArray(f13);
        a.writeToFileArray(f14);
        a.writeToFileArray(f15);
        a.displayArray(f1);

    }
}
