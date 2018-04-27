/*Criado por
  André Barbosa Oliveira RA:20166152
  Bruno Campos de Pierro RA:20899009
  Luiz Herculino RA:20149622
  Raphael Ferrarese RA:21010723

*/
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
        
        
        
        
        
    }
    
}
