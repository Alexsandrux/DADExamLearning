package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RmiServer {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        LocateRegistry.createRegistry(8090);
        RemoteInterface serverObj = new RemoteImpl();

        Naming.rebind(args[0], serverObj);

        System.out.println("Server RMI is waiting for connections...");
    }
}
