package com.tss.day25.Proxy.model;

public class VirtualProxyDocument implements IDocument{
    private RealDocument realDocument;
    private String name;

    public VirtualProxyDocument(String name){
        this.name = name;
    }

    @Override
    public String display() throws InterruptedException {
        if(realDocument == null){
            realDocument = new RealDocument(name);
        }
        return realDocument.display();
    }
}
