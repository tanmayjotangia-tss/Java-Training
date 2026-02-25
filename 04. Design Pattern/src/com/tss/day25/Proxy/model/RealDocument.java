package com.tss.day25.Proxy.model;

public class RealDocument implements IDocument{
    private  String name;

    public RealDocument(String name){
        this.name = name;
        loadFromDisk();
    }

    public void loadFromDisk() {
        System.out.println("RealDocument: Loading " + name + " from disk..");
    }

    @Override
    public String display() throws InterruptedException {
        Thread.sleep(3000);
        return "Displaying document: " + name;
    }
}
