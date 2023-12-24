package org.example;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            Logic stub = new LogicClass();
            Registry registry = LocateRegistry.createRegistry(8080);
            registry.bind("HelloServer", stub);
            System.out.println("Server is ready");
        } catch (Exception e){
            System.err.println("Server excp " + e.toString());
            e.printStackTrace();
        }
    }
}
