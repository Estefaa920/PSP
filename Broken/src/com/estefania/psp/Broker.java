package com.estefania.psp;

public class Broker {

    private int numShares;
    private int maxShares;


    public Broker(int maxShares) {
        this.maxShares = maxShares;
        numShares = maxShares;
    }

    public synchronized boolean buy(int packet){
        if (numShares >= packet){

            numShares-= packet;

            System.out.println("Se han podido comprar las acciones \n");
            System.out.println("Acciones disponibles: " + numShares);
            notifyAll();
            return true;
        } else {

            System.out.println("No se han podido comprar las acciones");
            notifyAll();

            return false;
        }
    }



    public synchronized void waitUntilNoSharesAvaliable() throws InterruptedException {
       while (numShares > 0) {
           wait();

       }
        notifyAll();
    }

}
