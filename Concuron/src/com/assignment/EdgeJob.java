package com.assignment;

public class EdgeJob implements Runnable {
    private generateEdge generateedge;

    public EdgeJob(generateEdge generateedge) {
        this.generateedge = generateedge;
    }

    @Override
    public void run() {
        generateedge.generate();
    }
}
