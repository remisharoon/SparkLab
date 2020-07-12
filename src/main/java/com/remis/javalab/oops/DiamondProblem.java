package com.remis.javalab.oops;

public class DiamondProblem {

    static interface I0{
        public void whoami();
    }


    static interface I1 extends I0{
        public void whoami();
    }

    static interface I2 extends I0{
        public void whoami();
    }

    static class DiamondClass implements I1, I2{
        public void whoami(){
            System.out.println("Iam the Diamond Class");
        }
    }

    public static void main(String[] args) {

        DiamondClass dc = new DiamondClass();
        dc.whoami();

    }

}
