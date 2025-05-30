public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        if (!cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF deve conter exatamente 11 dígitos numéricos.");
        }
        this.nome = nome;
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setNome(String nome) {
        this.nome = nome;
    } 
    public void setCpf(String cpf) {
        if (!cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF deve conter exatamente 11 dígitos numéricos.");
        }
        this.cpf = cpf;
    }
    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf;
    }
}
