package com.example.labpractice;
// class to Explore the undamentals of Java.


public class JavaPractice {
    public static void main(String[] args) {

        // this is a Comment
        // data types n Java: String,int,float,char,boolean

        String name = "rimel";
        // Type Casting
        // Automatic Casting.
        int myInt = 9;
        double myDouble = myInt;
        // Narowing Casting
        int converted = (int) myDouble;
        System.out.println(myDouble);

        // Maths module in Java.

        Math.max(50,20);
        Math.min(5,10);
        Math.sqrt(64);
        Math.abs(-4.7);

        // Booleans
        boolean True = true;
        boolean False = false;

        // IF Else Statments
        int x = 0;
        if(20 > 18){
            x = 10;
        } else {
            x = 20;
        }

        System.out.println(x);

        // Shorthand If Else:

        int time = 20;
        String result = (time<18) ? "Good Day" : "Good Evening";
        System.out.println(result);

        // Loops in java

        int i = 0;
        while (i<5){
            i++;
        }

        for (int y=0;y<5;y++){
            System.out.println(i);
        }

        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        for (String z : cars) {
            System.out.println(z);
        }

    }
}
