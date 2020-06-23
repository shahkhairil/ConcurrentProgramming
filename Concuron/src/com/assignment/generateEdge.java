package com.assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class generateEdge {
    private final Lock edgeLock = new ReentrantLock();
    private Point[] pointsarray;
    private Map<Point,Point> edgemap=new ConcurrentHashMap<>();
    private int totaledge=0;

    public int getTotaledge() {
        return totaledge;
    }

    public Map<Point, Point> getEdgemap() {
        return edgemap;
    }

    public generateEdge(Point[] pointsarray, Map<Point, Point> edgemap) {
        this.pointsarray = pointsarray;
        this.edgemap = edgemap;
    }

    public void printEdge(){
        for (Map.Entry entry : edgemap.entrySet())
        {
            System.out.println("Point : " + entry.getKey() + " with Point " + entry.getValue());
        }
    }

    public synchronized void generate()
    {
        edgeLock.lock();
        int currentthreadedge=0;
        try {
            int counter = 0;

            //try create edge for 20 times
            while (counter < 20) {
                Random j = new Random();
                int randomindex1 = j.nextInt(this.pointsarray.length);
                int randomindex2 = j.nextInt(this.pointsarray.length);

                //check if same index selected
                if (randomindex1 != randomindex2) {

                    //check key
                    boolean checkkey1 = edgemap.containsKey(pointsarray[randomindex1]);
                    boolean checkkey2 = edgemap.containsKey(pointsarray[randomindex2]);
                    //check value
                    boolean checkval1 = edgemap.containsValue(pointsarray[randomindex1]);
                    boolean checkval2 = edgemap.containsValue(pointsarray[randomindex2]);

                    //check if not already in the map, put combination of point in map
                    if (!checkkey1 && !checkval1 && !checkkey2 && !checkval2) {
                        edgemap.putIfAbsent(pointsarray[randomindex1], pointsarray[randomindex2]);

                        //
                        currentthreadedge++;
                        totaledge++;
                    }

                }
                counter++;
            }
            //current thread edge equal 0 after 20 time try, break thread
            if (currentthreadedge == 0) {
                Thread.currentThread().interrupt();
            } else {
                System.out.println(Thread.currentThread().getName() + " Successfully run");
                System.out.println("Edge created for this thread: " + currentthreadedge);
                System.out.println("Total edge Created: " + totaledge);
            }


        }finally
        {




            edgeLock.unlock();
        }
    }
}

