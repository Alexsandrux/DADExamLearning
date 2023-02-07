package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RmiClient {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        RemoteInterface serverObj = (RemoteInterface) Naming.lookup(args[0]);

        System.out.println(serverObj.sum(3, 7));
    }
}
