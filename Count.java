/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadingdemo;

import java.util.*;

/**
 *
 * @author shah khairil
 */
class Count extends Thread{
    
    int n;
    float rangeMin = (float) 1.00;
    float rangeMax = (float) 1000.00;
    
    Count(int n)
    {
        super("my extending thread");
        this.n = n;
        System.out.println("my thread created " + this);
        start();
    }
    
    @Override
    public void run()
    {
        
        Random r = new Random();
  
        try
        {
            for(int i=0; i<n;i++)
            {
                float numX = (float) (rangeMin + (rangeMax - rangeMin) * r.nextFloat()); 
                float numY = (float) (rangeMin + (rangeMax - rangeMin) * r.nextFloat());
                
                
                
                System.out.println("Printing the X-axis " + numX);
                System.out.println("Printing the Y-axis " + numY);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("my thread interupted");
        }
        System.out.println("My thread run is over");
    }
}
