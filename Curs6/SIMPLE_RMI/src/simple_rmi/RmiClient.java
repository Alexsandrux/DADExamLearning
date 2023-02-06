package simple_rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RmiClient {
	public static void main(String args[])
	{
		try {
			RemoteInterface remoteObject = (RemoteInterface)Naming.lookup(args[0]);
			
			int result = remoteObject.productNumbers(11, 10);
			
			System.out.println("Rezultatul calculat de obiectul remote este" + result);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
