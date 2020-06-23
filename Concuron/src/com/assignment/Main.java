package com.assignment;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Main {


    //generate random point object until n times
    static Point[] generateRandomPoint(int n) {
        //create new Point object array with size of n
        Point[] x=new Point[n];
        //intialize random g
        Random g=new Random() ;

        //loop until n times
        for(int i=0;i<n;i++){
            //generate random float point in 1000*1000 region
            float xcoord=g.nextFloat()*1000;
            float ycoord=g.nextFloat()*1000;

            //add the random float point into Point object
            x[i]=new Point(xcoord,ycoord);
        }
        //return Point object array
    return x;
    }


    public static void main(String[] args) {
	// write your code here

        // create an object of Scanner
        Scanner input = new Scanner(System.in);

        // take input from the user
        System.out.print("Enter n: ");
        int n = input.nextInt();

        Point[] arrayofpoint=generateRandomPoint(n);
        Map<Point,Point> map = new ConcurrentHashMap<>();

        for(int i=0;i<arrayofpoint.length;i++){
            System.out.println(arrayofpoint[i]);
        }

        generateEdge edge=new generateEdge(arrayofpoint,map);

        System.out.print("Enter t: ");
        int t = input.nextInt();

        Thread thread[] = new Thread[t];
        for (int i = 0; i < t; i++)
        {
            thread[i] = new Thread(new EdgeJob(edge), "Thread " + i);
        }
        for (int i = 0; i < t; i++)
        {
            thread[i].start();
        }








    }
}
