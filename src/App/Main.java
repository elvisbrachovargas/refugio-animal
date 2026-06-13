package App;


import Service.RefugioService;

public class Main {
    public static void main(String[] args) {
        RefugioService refugio = new RefugioService();
        refugio.iniciar();
    }
}