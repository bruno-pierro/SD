/*Criado por
  André Barbosa Oliveira RA:20166152
  Bruno Campos de Pierro RA:20899009
  Luiz Herculino RA:20149622
  Raphael Ferrarese RA:21010723

*/
package sistemanotas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class alunoDAO {
    
    // a conexão com o banco de dados
        private Connection connection;

        public alunoDAO() {
            this.connection = new ConnectionFactory().getConnection();
        }    
        
    public boolean adiciona(aluno l){

            // cria um preparedStatement
            String sql = "insert into aluno" +
                    " (ra,nome,telefone)" +
                    " values (?,?,?)";
            try{
            PreparedStatement stmt = connection.prepareStatement(sql);

            // preenche os valores
            stmt.setLong(1, l.getRa());
            stmt.setString(2, l.getNome());
            stmt.setString(3, l.getTelefone());

            // executa
            stmt.execute();
            stmt.close();
            connection.close();
            
            }catch(Exception e){
                return false;
            }
            
            return true;
    }
    public aluno consulta(aluno l){

            // cria um preparedStatement
            String sql = "select * from aluno" +
                    " where ra=?";
                    
            try{
            PreparedStatement stmt = connection.prepareStatement(sql);

            // preenche os valores
            stmt.setLong(1, l.getRa());
            

            // executa
            ResultSet rs = stmt.executeQuery();
            rs.next();
            
            aluno a = new aluno();
            a.setRa(rs.getLong("ra"));
            a.setNome(rs.getString("nome"));
            
            
            stmt.close();
            connection.close();
            return a;
            }catch(Exception e){
                return null;
            }
            
    }
    
     public boolean exclui(aluno l){

            // cria um preparedStatement
            String sql = "delete from aluno" +
                    " where ra=?";
                    
            try{
            PreparedStatement stmt = connection.prepareStatement(sql);

            // preenche os valores
            stmt.setLong(1, l.getRa());
            

            // executa
            stmt.execute();
            stmt.close();
            connection.close();
            
            }catch(Exception e){
                return false;
            }
            
            return true;
    }
}
