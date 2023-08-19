//importação necessária pra a classe Menu.java
import java.util.Scanner;
public class Menu {

    //#region Atributos, Variáveis & Objetos
    // Atributos
    private boolean isOn = true;
    private String nome = null;
    private String cpf = null;
    private String endereco = null;
    private int idade = 0;
    private String telefone = null;
    private String cargo = null;
    private double salario = 0;

    // Variavéis
    private int idFuncionario;
    private int idCliente;
    private String atributo;

    // Objetos de Classe
    Scanner input = new Scanner(System.in);
    Cliente cliente = new Cliente(nome, cpf, endereco, idade, telefone);
    Funcionario funcionario = new Funcionario(nome, cpf, endereco, idade, telefone, cargo, salario);
    TerminalUtils clear = new TerminalUtils();
    //#endregion

    //#region Menu & Opções
    public void exibirMenu() {
        cliente.criarClientesAutomatico();
        funcionario.criarFuncionarioAutomatico();

        clear.limparTerminal();
        while (isOn) {
            exibirOpcoes();
            int escolha = input.nextInt();
            input.nextLine(); // Limpa o buffer do teclado

            switch (escolha) {
                case 1:
                    exibirMenuCadastro(input);
                    break;
                case 2:
                    exibirMenuListagem(input);
                    break;
                case 3:
                    exibirMenuProcura(input);
                    break;
                case 4:
                    exibirMenuEditar(input);
                    break;
                case 5:
                    exibirMenuExcluir(input);
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    isOn = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        input.close();
    }

    private void exibirOpcoes() {
        System.out.println("============== Menu ==============");
        System.out.println("[1] Cadastrar Clientes/Funcionários");
        System.out.println("[2] Listar Clientes/Funcionários");
        System.out.println("[3] Procurar Clientes/Funcionários");
        System.out.println("[4] Editar Clientes/Funcionários");
        System.out.println("[5] Remover Informações Clientes/Funcionários");
        System.out.println("[0] Sair");
        System.out.println("Selecione a opção que deseja executar: ");
    }
    //#endregion

    //#region SubMenus

    // Submenu de Cadastro
    private void exibirMenuCadastro(Scanner input) {
        clear.limparTerminal();
        System.out.println("=========== Menu de Cadastro ===========");
        System.out.println("[1] Cadastrar Cliente");
        System.out.println("[2] Cadastrar Funcionário");
        System.out.println("[0] Sair");
        System.out.println("Selecione a opção que deseja executar: ");
        int escolhaCadastro = input.nextInt();
        input.nextLine(); // Limpa o buffer do teclado

        switch (escolhaCadastro) {
            case 1:
                clear.limparTerminal();
                cliente.cadastrarNovosClientes();
                break;
            case 2:
                clear.limparTerminal();
                funcionario.cadastrarFuncionario();
                break;
            case 0:
                clear.limparTerminal();
                break;
            default:
                clear.limparTerminal();
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }

    // Submenu de Listagem
    private void exibirMenuListagem(Scanner input) {
        clear.limparTerminal();
        System.out.println("=========== Menu de Listagem ===========");
        System.out.println("[1] Listar Funcionários");
        System.out.println("[2] Listar Clientes");
        System.out.println("[3] Listar todos");
        System.out.println("[0] Voltar ao Menu");
        System.out.println("Selecione a opção que deseja executar: ");
        int escolhaListar = input.nextInt();
        input.nextLine(); // Limpa o buffer do teclado

        switch (escolhaListar) {
            case 1:
                clear.limparTerminal();
                funcionario.imprimirFuncionarios();
                System.out.println("=========== Menu de Listagem ===========");
                System.out.println("[1] Ordenar");
                System.out.println("[0] Voltar ao Menu");
                System.out.println("Selecione a opção que deseja executar: ");
                int escolhaOrdenar = input.nextInt();
                input.nextLine(); // Limpa o buffer do teclado

                if (escolhaOrdenar == 1) {
                    clear.limparTerminal();
                    funcionario.ordenarFuncionariosPorNome();
                } else if (escolhaOrdenar == 0) {
                    clear.limparTerminal();
                }
                break;

            case 2:
                clear.limparTerminal();
                cliente.imprimirClientes();
                System.out.println("=========== Menu de Listagem ===========");
                System.out.println("[1] Ordenar");
                System.out.println("[0] Voltar ao Menu");
                System.out.println("Selecione a opção que deseja executar: ");
                int escolhaOrdenar2 = input.nextInt();
                input.nextLine(); // Limpa o buffer do teclado

                if (escolhaOrdenar2 == 1) {
                    clear.limparTerminal();
                    cliente.ordenarClientesPorNome();
                } else if (escolhaOrdenar2 == 0) {
                    clear.limparTerminal();
                }
                break;
            case 3:
            clear.limparTerminal();
            cliente.imprimirClientes();
            funcionario.imprimirFuncionarios();
            break;
            case 0:
                clear.limparTerminal();
                break;
            default:
                clear.limparTerminal();
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }

    // Submenu de Procurar
    private void exibirMenuProcura(Scanner input) {
        clear.limparTerminal();
        System.out.println("=========== Menu de Procura ===========");
        System.out.println("[1] Procurar Cliente");
        System.out.println("[2] Procurar Funcionário");
        System.out.println("[0] Voltar ao Menu");
        System.out.println("Selecione a opção que deseja executar: ");
        int escolhaProcurar = input.nextInt();
        input.nextLine(); // Limpa o buffer do teclado

        switch (escolhaProcurar) {
            case 1:
                System.out.println("Digite a informação que deseja buscar: ");
                String informacaoCliente = input.nextLine();
                clear.limparTerminal();
                cliente.procurarCliente(informacaoCliente);
                break;
            case 2:
                System.out.println("Digite a informação que deseja buscar: ");
                String informacaoFuncionario = input.nextLine();
                clear.limparTerminal();
                funcionario.procurarFuncionario(informacaoFuncionario);
                break;
            case 0:
                clear.limparTerminal();
                break;
            default:
                clear.limparTerminal();
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }

    // Submenu de Editar
    private void exibirMenuEditar(Scanner input) {
        clear.limparTerminal();
        System.out.println("=========== Menu de Edição ===========");
        System.out.println("[1] Editar Cliente");
        System.out.println("[2] Editar Funcionário");
        System.out.println("[0] Voltar ao Menu");
        System.out.println("Selecione a opção que deseja executar: ");
        int escolhaEditar = input.nextInt();
        input.nextLine(); // Limpa o buffer do teclado

        switch (escolhaEditar) {

            case 1:
                clear.limparTerminal();
                cliente.imprimirClientes();
                System.out.println("Digite o ID do cliente:");
                idCliente = input.nextInt();
    
                input.nextLine();
                System.out.println("Digite o atributo do Cliente(nome, idade, endereço, telefone, cpf):");
                atributo = input.nextLine();
                cliente.alterarInformacaoCliente(idCliente - 1, atributo);
                break;
            case 2:
                clear.limparTerminal();
                funcionario.imprimirFuncionarios();
                System.out.println("Digite o ID do Funcionário:");

                idFuncionario= input.nextInt();
                System.out.println("Digite o atributo do funcionário(nome, idade, endereço, telefone, cpf, cargo, salário):");
                input.nextLine();
                atributo = input.nextLine();

                funcionario.alterarInformacaoFuncionario(idFuncionario - 1, atributo);
            case 0:
                clear.limparTerminal();
                break;
        }   
    }

    // Submenu de Excluir
    private void exibirMenuExcluir(Scanner input) {
        clear.limparTerminal();
        System.out.println("============== Menu de Remoção ==============");
        System.out.println("[1] Excluir informações de Cliente");
        System.out.println("[2] Excluir informações de Funcionário");
        System.out.println("[0] Voltar ao Menu");
        System.out.println("Selecione a opção que deseja executar: ");
        int escolhaExcluir = input.nextInt();
        input.nextLine(); // Limpa o buffer do teclado

        switch (escolhaExcluir) {

            case 1:
                clear.limparTerminal();
                cliente.imprimirClientes();
                System.out.println("Digite o ID do cliente"); 
                idCliente = input.nextInt();
                input.nextLine();
                System.out.println("Digite o atributo do Cliente(nome, idade, endereço, telefone, cpf):");
                atributo = input.nextLine();
                System.out.println("Digite [y] para sim.");
                System.out.println("Digite [n] para não.");
                String escolhaRemoverCliente = input.nextLine();
                if(escolhaRemoverCliente.equalsIgnoreCase("y")){
                cliente.removerInformacaoCliente(idCliente - 1, atributo);
                System.out.println("Operação realizada.");
                break;
                }
                else if (escolhaRemoverCliente.equalsIgnoreCase("n")){
                    System.out.println("Operação não realizada.");
                    break;
                }
                break;
            case 2:
                clear.limparTerminal();
                funcionario.imprimirFuncionarios();
                System.out.println("Digite o ID do Funcionário: ");
                idFuncionario = input.nextInt();
                input.nextLine();
                System.out.println("Digite o atributo do funcionário(nome, idade, endereço, telefone, cpf, cargo, salário):");
                atributo = input.nextLine();
                System.out.println("Digite [y] para sim.");
                System.out.println("Digite [n] para não.");
                String escolhaRemoverFuncionario = input.nextLine();
                if(escolhaRemoverFuncionario.equalsIgnoreCase("y")){
                    System.out.println("Operação realizada.");
                    funcionario.removerInformacaoFuncionario(idFuncionario - 1, atributo);
                    break;
                }
                else if (escolhaRemoverFuncionario.equalsIgnoreCase("n")){
                    System.out.println("Operação não realizada.");
                    break;
                }
                break;
            case 0:
                clear.limparTerminal();
                break;
        }
    }
    //#endregion
}
