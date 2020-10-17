
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRMI extends Remote {

    public String TextSearch(String name) throws RemoteException;

}

