package rubricagestionale;

public class Contatto {
    private String nome;
    
    private String cognome;
    
    private Integer telefono;

    public Contatto(String nome, String cognome, Integer telefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
    }

    public Contatto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    
}
