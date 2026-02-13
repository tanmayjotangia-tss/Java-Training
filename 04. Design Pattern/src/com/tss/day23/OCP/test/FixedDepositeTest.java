package com.tss.day23.OCP.test;

import com.tss.day23.OCP.model.Diwali;
import com.tss.day23.OCP.model.FDDetailPrinter;
import com.tss.day23.OCP.model.FixedDeposite;
import com.tss.day23.OCP.model.NewYear;

public class FixedDepositeTest {
    static void main() {
        FixedDeposite fd1 = new FixedDeposite(101,3,10000,new Diwali());
        FixedDeposite fd2 = new FixedDeposite(102,5,20000,new NewYear());

        FDDetailPrinter.displayFDDetails(fd1);
    }
}
