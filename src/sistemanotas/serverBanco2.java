
package sistemanotas;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class serverBanco2 {

    public static void main(String[] args) {
        
        ServerSocket srv;
        Socket central;
        
        ObjectInputStream inServer;
        aluno a;
   
        try {
            
            srv = new ServerSocket(9800);
            while(true){
                central = srv.accept();
                //Pegando a mensagem do serverGerencia
                inServer = new ObjectInputStream(central.getInputStream());
                a = (aluno) inServer.readObject();
                
                
                
                alunoDAO dao = new alunoDAO();
                if (a.getControle() == 1) {
                    if (dao.adiciona(a)) {
                         JOptionPane.showMessageDialog(null, "Gravado!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Não gravado!");
                    }
                }else if (a.getControle() == 2){
                    a = dao.consulta(a);
                    if ( a != null) {
                        JOptionPane.showMessageDialog(null, a.getNome() + " Encontrado!");
                         
                    } else {
                        JOptionPane.showMessageDialog(null, "Não encontrado!");
                    }
                }else if (a.getControle() == 3){
                    if (dao.exclui(a)) {
                         JOptionPane.showMessageDialog(null, " Excluido!");
                    } else {
                        System.out.println("Não excluido!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Campos faltando");
                }
                
                
                
                central.close();
                        
            }
        } catch (Exception e) {
            System.out.println("Erro aqui"+e.getMessage());
        }
        
    }
        
}
    

