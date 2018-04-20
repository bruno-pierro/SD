package sistemanotas;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


public class serverBanco {
    
      
    
    public static void main(String[] args) {
        
        ArrayList<String> banco;
        
        ServerSocket srv;
        Socket central;
        banco = new ArrayList<>();
        
        try {
            
            srv = new ServerSocket(9700);
            while(true){
                central = srv.accept();
                Scanner in = new Scanner(central.getInputStream());
                PrintStream out = new PrintStream(central.getOutputStream());
                
                String msg = in.nextLine();
                banco.add(msg);
                System.out.println(msg);
                
                out.println("add");
                
                central.close();
                        
            }
        } catch (Exception e) {
            System.out.println("Erro aqui"+e.getMessage());
        }
        
    }
    
}
