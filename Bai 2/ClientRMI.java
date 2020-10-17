
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import InterfaceRMI;

public class ClientRMI {

	private static InterfaceRMI look_up;

	public static void main(String[] args)
		throws MalformedURLException, RemoteException, NotBoundException {

		look_up = (InterfaceRMI) Naming.lookup("//localhost/MyServer");
		String txt = JOptionPane.showInputDialog("Book Name?");

		String response = look_up.TextSearch(txt);
		JOptionPane.showMessageDialog(null, response);

	}

}


