package OO;

public class Funcionario {
    private String nome;
    private String cpf;
    private double salario;

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String rotinaDeTrabalho() {
        System.out.println("| 07:15 --> Chegada                           |");
        System.out.println("| 07:30 --> Revisão das metas                 |");
        System.out.println("| 08:00 --> Construção                        |");
        System.out.println("| 10:00 --> Pausa                             |");
        System.out.println("| 10:15 --> Retomada                          |");
        System.out.println("| 11:30 --> Finalização                       |");
        return "|                                             |";
    }


}
