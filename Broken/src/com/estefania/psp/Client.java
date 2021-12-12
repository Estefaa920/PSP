package com.estefania.psp;


public class Client extends Thread{

    Broker actions;
    String client;
    int sharesBought;

    public Client(String client, Broker actions) {
        this.client = client;
        this.actions= actions;
    }


    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000+(int) (Math.random()*2000));
                int buyActions = (int) (Math.random()*5);
                if(actions.buy(buyActions)){
                    System.out.println("El cliente ha podido comprar las acciones");
                    sharesBought += buyActions;
                    System.out.println("El cliente " + client + " ha comprado " + buyActions);
                } else {
                    System.out.println("El cliente no ha podido comprar las acciones...");

                }
            } catch (InterruptedException e) {

                System.out.println("El cliente " + client + " ha comprado " + sharesBought + " en total");
                break;
            }


        }



    }
}


