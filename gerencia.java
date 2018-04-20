
package sistemanotas;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class gerencia extends Thread{

    Socket cli;
    
    
    public gerencia (Socket cli){
        this.cli = cli;
    }
    
    public void run(){
        
        Socket server;
        
        try {
            Scanner inCliente = new Scanner(cli.getInputStream());
            PrintStream outCliente = new PrintStream(cli.getOutputStream());            
            
            String msgCliente = inCliente.nextLine();
            System.out.println(msgCliente);
            
            server = new Socket("127.0.0.1",9700);
            PrintStream outServer = new PrintStream(server.getOutputStream());
            Scanner inServer = new Scanner(server.getInputStream());
            
            outServer.println(msgCliente);
            
            String msgServer = inServer.nextLine();
            System.out.println(msgServer);   

            outCliente.println(msgServer);
            
            server.close();
            cli.close();
            
        } catch (Exception e) {
                System.out.println("ErroGerencia:"+e.getMessage());
        }
        
    }

    
}
