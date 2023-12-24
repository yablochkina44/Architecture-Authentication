package org.example;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Logic extends Remote{
    String sayHello() throws RemoteException;

    boolean message_is_file(String path) throws RemoteException;
    boolean user_is_logged(String login, String password) throws RemoteException;
    boolean user_is_admin(String login, String password) throws RemoteException;
    String get_response(String login, String password, String text) throws RemoteException;

}
