package simple_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote{
	public int productNumbers(int x, int y) throws RemoteException;
}