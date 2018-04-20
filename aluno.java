
package sistemanotas;


public class aluno {
    private long ra;
    private String nome;
    private String telefone;

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
    
    
    
    
    public aluno() {
    }
    
    
    
    
    public aluno(long ra, String nome, String telefone) {
        this.ra = ra;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    
    
}
