package com.assignment;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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

        //initialize point array
        Point[] arrayofpoint=generateRandomPoint(n);
        //initialize map to hold the edge
        Map<Point,Point> map = new ConcurrentHashMap<>();

        for(int i=0;i<arrayofpoint.length;i++){
            System.out.println(arrayofpoint[i]);
        }

        generateEdge edge=new generateEdge(arrayofpoint,map);

        System.out.print("Enter t: ");
        int t = input.nextInt();

        System.out.print("Enter m (in second): ");
        int m = input.nextInt();


        //initialize executor service
        ExecutorService executor = Executors.newCachedThreadPool();

        //Create and launch t threads
        for (int i = 0; i < t; i++) {
            executor.execute(new EdgeJob(edge));
        }
        //if interrupted(a thread cannot create edge after 20 tries), shutdown
        if(Thread.currentThread().isInterrupted()){
            executor.shutdownNow();
        }

        //stop application after certain interval
        executor.shutdown();
        try {
            if (!executor.awaitTermination(m, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }


        //print the edge created
        edge.printEdge();







    }
}
