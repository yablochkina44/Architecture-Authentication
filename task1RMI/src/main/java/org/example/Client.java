package org.example;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class Client {
    protected Logic logic;

    public Client(final Logic logic) throws RemoteException{
        this.logic = logic;
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("Введите ваш логин");
            String login = in.nextLine();
            System.out.println("Введите ваш пароль");
            String password = in.nextLine();
            System.out.println("Введите текст или путь к файлу");
            String text = in.nextLine();
            if (logic.user_is_logged(login, password)) {
                System.out.println(logic.get_response(login, password, text));
            }
            else{
                System.out.println("Неверный логин или пароль");
            }

        }

    }

    public static void main(String[] args) {
        String host = (args.length < 1) ? null: args[0];
        int port = 8080;
        try {
            Registry registry = LocateRegistry.getRegistry(host, port);
            System.out.println("registry : " + host + ":" + port);
            Logic service = (Logic) registry.lookup("HelloServer");
            new Client(service);
        } catch (Exception e){
            System.err.println("ClientConnect excp: " + e.toString());
            e.printStackTrace();
        }
    }
}
