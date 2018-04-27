/*Criado por
  André Barbosa Oliveira RA:20166152
  Bruno Campos de Pierro RA:20899009
  Luiz Herculino RA:20149622
  Raphael Ferrarese RA:21010723

*/
package sistemanotas;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class gerencia extends Thread{

    Socket cli;
    Socket server;
    Socket server2;
    Socket server3;
    ObjectInputStream inServer;
    ObjectInputStream inCliente;
    aluno a;
    static int cont = 0;
    
    public gerencia (Socket cli){
        this.cli = cli;
    }
    
    public void run(){
        
                
        try {
            
            //Pegando a mensagem do cliente e repassando para o server
            inCliente = new ObjectInputStream(cli.getInputStream());
            a = (aluno) inCliente.readObject();
            
            if (a.getControle() == 1){
            
            server = new Socket("127.0.0.1",9700);
            try(ObjectOutputStream oos = new ObjectOutputStream(server.getOutputStream())){
                oos.writeObject(a);
                
            }
            server2 = new Socket("127.0.0.1",9800);
            try(ObjectOutputStream oos = new ObjectOutputStream(server2.getOutputStream())){
                oos.writeObject(a);
            }
            server3 = new Socket("127.0.0.1",9900);
                       
            try(ObjectOutputStream oos = new ObjectOutputStream(server3.getOutputStream())){
                oos.writeObject(a);
            }
            }else if(a.getControle() == 2){
               
                int ser = cont;
                cont = (cont+1) %3 ;
                if (  ser == 0){
                server = new Socket("127.0.0.1",9700);
                try(ObjectOutputStream oos = new ObjectOutputStream(server.getOutputStream())){
                oos.writeObject(a);
                }}
                else if( ser == 1){
                server2 = new Socket("127.0.0.1",9800);
                try(ObjectOutputStream oos = new ObjectOutputStream(server2.getOutputStream())){
                oos.writeObject(a);
                }        
                }else{
                server3 = new Socket("127.0.0.1",9900);
                try(ObjectOutputStream oos = new ObjectOutputStream(server3.getOutputStream())){
                oos.writeObject(a);
                }        
                }
                
                
                
                
            
            }else if (a.getControle() == 3){
            
            server = new Socket("127.0.0.1",9700);
            try(ObjectOutputStream oos = new ObjectOutputStream(server.getOutputStream())){
                oos.writeObject(a);
            }
            server2 = new Socket("127.0.0.1",9800);
            try(ObjectOutputStream oos = new ObjectOutputStream(server2.getOutputStream())){
                oos.writeObject(a);
            }
            server3 = new Socket("127.0.0.1",9900);
                       
            try(ObjectOutputStream oos = new ObjectOutputStream(server3.getOutputStream())){
                oos.writeObject(a);
            }
            }else{
                JOptionPane.showMessageDialog(null, "Não foi passado Controle");
            }
            
            
            
            server.close();
            server2.close();
            server3.close();
            cli.close();
            
        } catch (Exception e) {
                System.out.println("ErroGerencia:"+e.getMessage());
        }
        
    }

    
}
