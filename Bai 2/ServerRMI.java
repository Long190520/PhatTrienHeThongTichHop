
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import InterfaceRMI;
public class ServerRMI extends UnicastRemoteObject implements InterfaceRMI{

    private static final long serialVersionUID = 1L;

    protected ServerRMI() throws RemoteException {

        super();

    }
    @Override
    public String TextSearch(String name) throws RemoteException{
    	String m = null;
    	try {
			
			File f = new File("C:\\Users\\USER\\18078031_LePhamHoangLong\\Bai2\\src\\1.txt");
			FileReader fr = new FileReader(f);
			//
			BufferedReader br = new BufferedReader(fr);
			Scanner c = new Scanner(f,"UTF-8");
			while(c.hasNextLine()) {
			String line = c.nextLine();
			if(line.contentEquals(name)) {
				m = " tim thay sach ";
			}
			}
			if(m == null) {
				m = " Khong tim thay sach ";
			}
			c.close();
			fr.close();
			br.close();	
        }
		catch(IOException ex) {
			ex.printStackTrace();
		}
        System.err.println(name + " dang tim kiem!");
        return "Book name :" + name +m;

    }
    public static void main(String[] args){

        try {
            Naming.rebind("//localhost/MyServer", new ServerRMI());
            System.err.println("Server ready");
        } catch (Exception e) {

            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();

        }

    }

}
