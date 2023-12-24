package org.example;
import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;

public class LogicClass extends UnicastRemoteObject implements Logic{

    String[] logins = {"superuser", "user"};
    String[] passwords = {"qwerty123", "12345"};

    @Override
    public String sayHello() {return "Klop";}

    @Override
    public boolean message_is_file(String path) throws RemoteException {
        File file = new File(path);
        return file.exists() && file.isFile();
    }

    @Override
    public boolean user_is_logged(String login, String password) throws RemoteException {
        for (int i = 0; i < logins.length; i++){
            System.out.println(login);
            if ((Objects.equals(logins[i], login)) && (Objects.equals(passwords[i], password))){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean user_is_admin(String login, String password) throws RemoteException {
        if ((Objects.equals(logins[0], login)) && (Objects.equals(passwords[0], password))){
            return true;
        }
        return false;
    }

    @Override
    public String get_response(String login, String password, String text) throws RemoteException {
        if (message_is_file(text)){
            if (user_is_admin(login, password)){
                return ("Ваше сообщение получено, это файл : " + text);
            }
            else{
                return ("У вас нет прав на отправку файлов!");
            }
        }
        else {
            return ("Сообщение получено : " + text);
        }
    }


    public LogicClass() throws RemoteException{

    }
}
