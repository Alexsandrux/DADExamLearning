package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote{
    public int sum(int a, int b) throws RemoteException;
}
