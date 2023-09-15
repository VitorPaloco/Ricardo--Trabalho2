package OO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Executar {

    private static Scanner ler = new Scanner(System.in);
    private static List<Funcionario> funcionarios = new ArrayList<>();

    public static void main(String[] args) {
        limpaTela();
        menu();
    }

    public static void menu() {
        boolean continuar = true;
        while (continuar) {

            System.out.println("|--------------- Menu ---------------|");
            System.out.println("|                                    |");
            System.out.println("| Opção 1: Registrar Funcionário     |");
            System.out.println("| Opção 2: Registrar Sênior          |");
            System.out.println("| Opção 3: Editar funcionários       |");
            System.out.println("| Opção 4: Excluir funcionários      |");
            System.out.println("| Opção 5: Checar funcionários       |");
            System.out.println("| Opção 6: Checar cronograma         |");
            System.out.println("| Opção 7: Sair                      |");
            System.out.println("|                                    |");
            System.out.println("|------------------------------------|");
            System.out.println();
            System.out.print("O que deseja fazer: ");

            int escolha = ler.nextInt();

            switch (escolha) {
                case 1:
                    registrarFunc();
                    break;
                case 2:
                    registrarSen();
                    break;
                case 3:
                    editarFunc();
                    break;
                case 4:
                    excluirFunc();
                    break;
                case 5:
                    checarFunc();
                    break;
                case 6:
                    checarCrono();
                    break;
                case 7:
                    System.out.println("Programa finalizado.");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção Inválida!");
            }
        }
    }



    private static void registrarFunc() {
        System.out.println();
        System.out.println("|--------------- REGISTRAR ---------------|");
        System.out.println("|                                         |");
        System.out.println("|   Digite as informações do Funcionário  |");
        System.out.println("|                                         |");
        System.out.println("|-----------------------------------------|");
        System.out.println();

        System.out.print("Nome: ");
        String nome = ler.next();

        System.out.print("CPF: ");
        String cpf = ler.next();

        System.out.print("Salário: ");
        double salario = ler.nextDouble();

        Funcionario funcionario = new Funcionario(nome, cpf, salario);
        funcionarios.add(funcionario);

        System.out.println();
        System.out.println("Registro efetuado com sucesso");
        tempo();
        limpaTela();
    }

    private static void registrarSen() {
        System.out.println();
        System.out.println("|--------------- REGISTRAR ---------------|");
        System.out.println("|                                         |");
        System.out.println("|      Digite as informações do Sênior    |");
        System.out.println("|                                         |");
        System.out.println("|-----------------------------------------|");
        System.out.println();

        System.out.print("Nome: ");
        String nome = ler.next();

        System.out.print("CPF: ");
        String cpf = ler.next();

        System.out.print("Salário: ");
        double salario = ler.nextDouble();

        System.out.print("Equipe responsável: ");
        int equipeResponsavel = ler.nextInt();

        Senior senior = new Senior(nome, cpf, salario, equipeResponsavel);
        funcionarios.add(senior);

        System.out.println();
        System.out.println("Registro efetuado com sucesso");
        tempo();
        limpaTela();
    }

    private static void editarFunc() {
        System.out.println();
        System.out.println("|----------------- EDITAR ----------------|");
        System.out.println("|                                         |");
        System.out.println("|        Digite o CPF do funcionário      |");
        System.out.println("|                                         |");
        System.out.println("|-----------------------------------------|");
        String busca = ler.next();

        Funcionario funcionarioParaEditar = null;

        for (Funcionario func : funcionarios) {
            if (func.getCpf().equals(busca)) {
                funcionarioParaEditar = func;
                break;
            }
        }

        if (funcionarioParaEditar != null) {
            System.out.println("Funcionário encontrado, informe as novas informações:");
            System.out.println();
            System.out.print("Novo nome: ");
            String novoNome = ler.next();

            System.out.print("Novo CPF: ");
            String novoCpf = ler.next();

            System.out.print("Novo salário: ");
            double novoSalario = ler.nextDouble();

            if (funcionarioParaEditar instanceof Senior) {
                Senior seniorParaEditar = (Senior) funcionarioParaEditar;

                System.out.print("Nova equipe responsável: ");
                int novaEquipeResponsavel = ler.nextInt();

                seniorParaEditar.setEquipeResponsavel(novaEquipeResponsavel);
            }

            funcionarioParaEditar.setNome(novoNome);
            funcionarioParaEditar.setCpf(novoCpf);
            funcionarioParaEditar.setSalario(novoSalario);

            System.out.println("Registro atualizado com sucesso");
        }
        else {
            System.out.println("Registro não encontrado");
        }
        tempo();
        limpaTela();
    }

    private static void excluirFunc() {
        System.out.println();
        System.out.println("|---------------- EXCLUIR ----------------|");
        System.out.println("|                                         |");
        System.out.println("|        Digite o CPF do funcionário      |");
        System.out.println("|                                         |");
        System.out.println("|-----------------------------------------|");
        String busca = ler.next();

        Funcionario funcionarioParaExcluir = null;

        for (Funcionario func : funcionarios) {
            if (func.getCpf().equals(busca)) {
                funcionarioParaExcluir = func;
                break;
            }
        }
        if (funcionarioParaExcluir != null) {
            funcionarios.remove(funcionarioParaExcluir);
            System.out.println("Registro excluído com sucesso");
        } else {
            System.out.println("Registro não encontrado");
        }
        tempo();
        limpaTela();
    }

    private static void checarFunc() {
        System.out.println();
        System.out.println("|------------- LISTA DE FUNCIONÁRIOS -------------|");
        System.out.println("|                                                 |");
        for (Funcionario func : funcionarios) {
            if (func instanceof Senior) {
                System.out.println("                " + func.getNome() + ": Senior");
            }
            else {
                System.out.println("                " + func.getNome() + ": Funcionário");
            }
        }
        System.out.println("|                                                 |");
        System.out.println("|-------------------------------------------------|");
        System.out.println();
        System.out.println("Pressione Enter para voltar ao menu");
        ler.nextLine();
        ler.nextLine();
        tempo();
        limpaTela();
    }

    private static void checarCrono() {
        Funcionario funcionario = new Funcionario();
        Senior senior = new Senior();
        System.out.println();
        System.out.println("|----------------- CRONOGRAMA ----------------|");
        System.out.println("|                                             |");
        System.out.println("|                 FUNCIONÁRIOS                |");
        System.out.println("|                                             |");
        System.out.println(funcionario.rotinaDeTrabalho());
        System.out.println("|                                             |");
        System.out.println("|                   SÊNIORS                   |");
        System.out.println("|                                             |");
        System.out.println(senior.rotinaDeTrabalho());
        System.out.println("|---------------------------------------------|");
        System.out.println();
        System.out.println("Pressione Enter para voltar ao menu");
        ler.nextLine();
        ler.nextLine();
        tempo();
        limpaTela();
    }

    public static void limpaTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void tempo() {
        System.out.println();
        System.out.println("Voltando ao Menu");
        System.out.print("Aguarde");
        try {
            for (int i = 0; i < 4; i++) {
                Thread.sleep(1000);
                System.out.print(" . ");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


