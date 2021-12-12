package com.estefania.psp;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        Broker broker = new Broker(10);
        Client maria = new Client("Maria", broker);
        Client vanesa = new Client("Vanesa", broker);
        Client luis = new Client("Luis", broker);
        Client alberto = new Client("Alberto", broker);


        maria.start();
        vanesa.start();
        luis.start();
        alberto.start();

        broker.waitUntilNoSharesAvaliable();

        maria.interrupt();
        vanesa.interrupt();
        luis.interrupt();
        alberto.interrupt();

        maria.join();
        vanesa.join();
        luis.join();
        alberto.join();

    }
}
