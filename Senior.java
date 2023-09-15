package OO;

public class Senior extends Funcionario {
    private int equipeResponsavel;

    public Senior() {
    }

    public Senior(String nome, String cpf, double salario, int equipeResponsavel) {
        super(nome, cpf, salario);
        this.equipeResponsavel = equipeResponsavel;
    }

    public int getEquipeResponsavel() {
        return equipeResponsavel;
    }

    public void setEquipeResponsavel(int equipeResponsavel) {
        this.equipeResponsavel = equipeResponsavel;
    }

    @Override
    public String rotinaDeTrabalho() {
        System.out.println("| 07:15 --> Chegada                           |");
        System.out.println("| 07:30 --> Revisão das metas                 |");
        System.out.println("| 08:00 --> Monitoramento                     |");
        System.out.println("| 10:00 --> Pausa                             |");
        System.out.println("| 10:15 --> Retomada                          |");
        System.out.println("| 11:30 --> Finalização                       |");
        System.out.println("| 12:00 --> Entrega de Relatório              |");
        return "|                                             |";
    }
}
