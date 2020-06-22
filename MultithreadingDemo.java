/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadingdemo;

import java.util.Scanner;

/**
 *
 * @author shah khairil
 */
public class MultithreadingDemo {

    /**
     * @param args the command line arguments
     */
    
//    public void run(){
//        System.out.println("My thread is in running state.");
//    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner myObj = new Scanner(System.in);
        
        System.out.println("Enter n");
        int n = myObj.nextInt();
        
//        System.out.println("Enter t");
//        int t = myObj.nextInt();
//        
//        System.out.println("Enter m");
//        int m = myObj.nextInt();
        
        Count cnt = new Count(n);
        try
        {
            while(cnt.isAlive())
            {
                System.out.println("Main thread will be alive till the child thread is live");
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("Main thread interupted");
        }
        System.out.println("Main thread's run is over");
        
    }
    
}
