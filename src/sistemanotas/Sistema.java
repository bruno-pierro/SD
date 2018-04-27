/*Criado por
  André Barbosa Oliveira RA:20166152
  Bruno Campos de Pierro RA:20899009
  Luiz Herculino RA:20149622
  Raphael Ferrarese RA:21010723

*/
package sistemanotas;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {
        Socket server;    
        ObjectOutputStream out;
        ObjectInputStream in;
        Scanner entrada = new Scanner(System.in);
        
        
        System.out.println("Aluno: ");
        String nome = entrada.nextLine();
        System.out.println("RA: ");
        int ra = entrada.nextInt();
        System.out.println("Operação");
        int op = entrada.nextInt();
        
        
        aluno a = new aluno(ra, nome,"",op);
        
        aluno a1;
        try {
            server = new Socket("127.0.0.1",9600);
            
            out = new ObjectOutputStream(server.getOutputStream());
            out.writeObject(a);
            in = new ObjectInputStream(server.getInputStream()); 
            a1 = (aluno) in.readObject();
                
            
            
            
        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
        }
        
        
    }
    
}
