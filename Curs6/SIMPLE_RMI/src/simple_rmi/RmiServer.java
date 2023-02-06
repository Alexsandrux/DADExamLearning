package simple_rmi;

import java.rmi.registry.LocateRegistry;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class RmiServer {
	public static  void main(String args[]) {
		
		
		try {
			LocateRegistry.createRegistry(1099);
			
			RemoteInterface Server = new ProductImplementation();
			Naming.rebind(args[0], Server);
			
			System.out.println("Server waiting.....");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
