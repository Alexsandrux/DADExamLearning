package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteImpl extends UnicastRemoteObject implements RemoteInterface {
    private static final long serialVersionUID = 1L;

    public RemoteImpl() throws RemoteException {
        super();
    }

    @Override
    public int sum(int a, int b) throws RemoteException {
        return a +b;
    }
}
