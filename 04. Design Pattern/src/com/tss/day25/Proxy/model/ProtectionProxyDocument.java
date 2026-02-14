package com.tss.day25.Proxy.model;

public class ProtectionProxyDocument implements IDocument{
    private RealDocument realDocument;
    private String name;
    private String userRole;

    public ProtectionProxyDocument(String name, String userRole){
        this.name=name;
        this.userRole=userRole;
    }

    @Override
    public String display() throws InterruptedException {
        if("admin".equalsIgnoreCase(userRole)){
            if(realDocument==null) realDocument = new RealDocument(name);
            return realDocument.display();
        }else{
            return "Access Denied";
        }
    }
}
