/*Criado por
  André Barbosa Oliveira RA:20166152
  Bruno Campos de Pierro RA:20899009
  Luiz Herculino RA:20149622
  Raphael Ferrarese RA:21010723

*/
package sistemanotas;

import java.io.Serializable;


public class aluno implements Serializable {
    private long ra;
    private String nome;
    private String telefone;
    private int controle;

    public long getRa() {
        return ra;
    }

    public void setRa(long ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public int getControle() {
        return controle;
    }

    public void setControle(int controle) {
        this.controle = controle;
    }
    
    
    public aluno() {
    }
    
    
    
    
    public aluno(long ra, String nome, String telefone,int controle) {
        this.ra = ra;
        this.nome = nome;
        this.telefone = telefone;
        this.controle = controle;
    }
    
    
    
}
