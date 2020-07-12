package com.remis.javalab.oops;

public class RuntimePolymorphism {

    static class Animal{
        public void whoami(){
            System.out.println("I am an Animal");
        }
    }

    static class Bear extends Animal{
        @Override
        public void whoami(){
            System.out.println("I am a Bear");
        }
    }

    public static void main (String[] args){

        Animal animal = new Animal();
        Animal bear = new Bear();
        Bear bear2 = new Bear();

        animal.whoami();
        bear.whoami();
        bear2.whoami();

    }

}
