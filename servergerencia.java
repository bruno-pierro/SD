
package sistemanotas;

import java.net.ServerSocket;
import java.net.Socket;



public class servergerencia {
    
    private static ServerSocket serv;
    private static Socket cli;

    public static void main(String[] args) {
        
        try {
            
            serv = new ServerSocket(9600);
            while(true){
                cli = serv.accept();
                gerencia gerencia = new gerencia(cli);
                gerencia.start();
            }
            
        } catch (Exception e) {
        }
        
        
        
        /*
        ServerSocket serverGerencia;
        Socket sc;
        
        
        try {
            serverGerencia = new ServerSocket(9600);
            while (true) {
                
                sc = new Socket("127.0.0.1",9700);
            
            }
            
        } catch (Exception e) {
            System.out.println("Erro comunicacao server: " +e.getMessage());
        }*/
        
    }
    
}
