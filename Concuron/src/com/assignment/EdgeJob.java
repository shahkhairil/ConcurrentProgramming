package com.assignment;

public class EdgeJob implements Runnable {
    private generateEdge generateedge;

    public EdgeJob(generateEdge generateedge) {
        this.generateedge = generateedge;
    }

    @Override
    public void run() {

//        System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
        generateedge.generate();
//        System.out.println(generateedge.getEdgemap());

    }
}
