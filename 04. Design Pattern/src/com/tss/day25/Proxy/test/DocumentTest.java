package com.tss.day25.Proxy.test;

import com.tss.day25.Proxy.model.IDocument;
import com.tss.day25.Proxy.model.ProtectionProxyDocument;
import com.tss.day25.Proxy.model.VirtualProxyDocument;

public class DocumentTest {
    static void main() throws InterruptedException {
        System.out.println("--- Virtual Proxy ---");
        IDocument virtualDoc = new VirtualProxyDocument("file1.pdf");
        System.out.println(virtualDoc.display());

        System.out.println("\n--- Protection Proxy ---");
        IDocument protectionDoc = new ProtectionProxyDocument("file2.pdf", "admin");
        System.out.println(protectionDoc.display());
    }
}
