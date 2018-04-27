/*Criado por
  André Barbosa Oliveira RA:20166152
  Bruno Campos de Pierro RA:20899009
  Luiz Herculino RA:20149622
  Raphael Ferrarese RA:21010723

*/
package sistemanotas;


//import java.sql.ConnectionFactory;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    public java.sql.Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/alunos", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
}

