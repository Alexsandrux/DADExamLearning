package simple_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ProductImplementation extends UnicastRemoteObject implements RemoteInterface{
	private final static long serialVersionUID = 1L;
	
	protected ProductImplementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int productNumbers(int x, int y) throws RemoteException {
		System.out.println("The result is " + x * y);
		return x * y;
	}
	
	
	

}
