package com.company;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class generateEdge {
    private final Lock edgeLock = new ReentrantLock();
    private Point[] pointsarray;

    public generateEdge(Point[] pointsarray) {
        this.pointsarray = pointsarray;
    }

    public void generate()
    {
        edgeLock.lock();
        try
        {
            Random j=new Random();
            int randomindex1=j.nextInt(this.pointsarray.length);
            int randomindex2=j.nextInt(this.pointsarray.length);
            if(randomindex1!=randomindex2){
                System.out.println("new Edge created");
                System.out.println(pointsarray[randomindex1]+" with  "+pointsarray[randomindex2]);

            }
        }  finally
        {
//            System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
            edgeLock.unlock();
        }
    }
}

