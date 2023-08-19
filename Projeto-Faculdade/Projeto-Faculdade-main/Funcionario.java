//Importações necessárias para a classe.
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;

//Classe filha do Cliente.java
public class Funcionario extends Cliente {

//Atributos da classe 
    private double salario;
    private String cargo;

//ArrayList da classe Funcionario
    ArrayList<Funcionario> cadastroFuncionario = new ArrayList<>();

//Scanner usado na classe filha
    Scanner input = new Scanner(System.in);

//Construtor da classe filha
    public Funcionario(String nome, String cpf, String endereco, int idade, String telefone, String cargo, double salario) {
        super(nome, cpf, endereco, idade, telefone);
        this.cargo = cargo;
        this.salario = salario;
    }

  //Encapsulamento dos atributos específicos da classe filha  
    public String getCargo() {
    	return cargo;
    }
    
    public void setCargo(String cargo) {
    	this.cargo = cargo;
    }
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    //Metodo usado para criar os funcionarios automaticamente
    public void criarFuncionarioAutomatico(){
        cadastroFuncionario.add(new Funcionario("Maicon", "212121", "rua a", 12223, "131313", "Vendedor", 122220));
        cadastroFuncionario.add(new Funcionario("Luiz", "1212313", "rua A", 9, "131313", "Gerente", 9000));

    }

    //Metodo usado para cadastro de funcionarios
    public void cadastrarFuncionario() {
        System.out.println("====== Cadastro de Funcionários ======");
        System.out.println("");
        System.out.println("Digite a quantidade de funcionários.");
        int quantidade = input.nextInt();
        input.nextLine();
        
        for(int i = 0; i<quantidade;i++){
        System.out.println("Cadastre o " + (i+1) + "° funcionário.");
        System.out.println("Digite o nome do funcionário:");
        nome = input.nextLine();

        System.out.println("Digite o CPF do funcionário:");
        Integer.parseInt( cpf =input.nextLine());

        System.out.println("Digite o endereço do funcionário:");
        endereco = input.nextLine();

        int idade = 0;
        boolean idadeValida = false;
        while (!idadeValida) {
            try {
                System.out.println("Digite a idade do funcionário:");
                idade = input.nextInt();
                idadeValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Idade inválida. Digite um valor numérico.");
                input.nextLine();
            }
        }
        System.out.println("Digite o telefone do funcionário:");
        telefone = input.next();

        input.nextLine();

        System.out.println("Digite o cargo do funcionário:");
        String cargo = input.nextLine();

        double salario = 0;
        boolean salarioValido = false;
        while (!salarioValido) {
            try {
                System.out.println("Digite o salário do funcionário:");
                salario = input.nextDouble();
                salarioValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Idade inválida. Digite um valor numérico.");
                input.nextLine();
            }
        }
        input.nextLine();
        Funcionario novoFuncionario = new Funcionario(nome, cpf, endereco, idade, telefone, cargo, salario);
        cadastroFuncionario.add(novoFuncionario);
        }
    }
    //Imprimir funcionario cadastrado
    public void imprimirFuncionarios() {
        for (int i = 0; i < cadastroFuncionario.size(); i++) {
            Cliente cliente = cadastroFuncionario.get(i);
            if (cliente instanceof Funcionario) {
                Funcionario funcionario = (Funcionario) cliente;
                System.out.println("FUNCIONÁRIO " + (i + 1) + "°");
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("CPF: " + funcionario.getCpf());
                System.out.println("Idade: " + funcionario.getIdade());
                System.out.println("Endereço: " + funcionario.getEndereco());
                System.out.println("Cargo: " + funcionario.getCargo());
                System.out.println("Salário: " + funcionario.getSalario());
                System.out.println("");
            }
        }
    }
  //Agrupar funcionarios por ordem alfabética 
    public void ordenarFuncionariosPorNome() {
        Collections.sort(cadastroFuncionario, new Comparator<Funcionario>() {
            public int compare(Funcionario f1, Funcionario f2) {
                return f1.getNome().compareTo(f2.getNome());
            }
        });

        System.out.println("Lista de funcionários ordenada por nome:");
        imprimirFuncionarios();
    }
    
    //Procurar funcionário ou informações sobre o mesmo
    public void procurarFuncionario(Object informacao) {
        boolean funcionarioEncontrado = false;
       
        for (Funcionario funcionario : cadastroFuncionario) {
            if (funcionario.getNome().equals(informacao) || funcionario.getCpf().equals(informacao)
                || funcionario.getEndereco().equals(informacao) || String.valueOf(funcionario.getIdade()).equals(informacao)
                || funcionario.getTelefone().equals(informacao) || funcionario.getCargo().equals(informacao)
                || String.valueOf(funcionario.getSalario()).equals(informacao)) {
            	
                System.out.println("Funcionário encontrado:");
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("CPF: " + funcionario.getCpf());
                System.out.println("Endereço: " + funcionario.getEndereco());
                System.out.println("Idade: " + funcionario.getIdade());
                System.out.println("Telefone: " + funcionario.getTelefone());
                System.out.println("Cargo: " + funcionario.getCargo());
                System.out.println("Salário: " + funcionario.getSalario());
                System.out.println();

                funcionarioEncontrado = true;
            	}
        	}
        if (!funcionarioEncontrado) {
            System.out.println("Funcionário não encontrado.");
        }
    }

//Alterar dados do funcionário
    public void alterarInformacaoFuncionario(int numeroFuncionario, String atributo) {
        if (numeroFuncionario >= 0 && numeroFuncionario < cadastroFuncionario.size()) {
            Funcionario funcionario = cadastroFuncionario.get(numeroFuncionario);

            switch (atributo) {
                case "nome":
                    System.out.println("Digite o novo nome:");
                    String novoNome = input.nextLine();
                    funcionario.setNome(novoNome);
                    System.out.println("Nome do funcionário alterado com sucesso.");
                    break;
                    
                case "cpf":
                    System.out.println("Digite o novo CPF:");
                    String novoCpf = input.nextLine();
                    funcionario.setCpf(novoCpf);
                    input.nextLine();
                    System.out.println("CPF do funcionário alterado com sucesso.");
                    break;
                    
                case "endereco":
                    System.out.println("Digite o novo endereço:");
                    String novoEndereco = input.nextLine();
                    funcionario.setEndereco(novoEndereco);
                    System.out.println("Endereço do funcionário alterado com sucesso.");
                    break;
                    
                case "idade":
                    int novaIdade = 0;

                    boolean idadeValida = false;
                    while (!idadeValida) {
                        try {
                            System.out.println("Digite a nova idade:");
                            novaIdade = input.nextInt();
                            funcionario.setIdade(novaIdade);
                            System.out.println("Idade do funcionário alterada com sucesso.");
                            idadeValida = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Idade inválida. Digite um valor numérico.");
                   
                        }
                        break;
                    }
                    
                    
                case "telefone":
                    System.out.println("Digite o novo telefone:");
                    String novoTelefone = input.nextLine();
                    funcionario.setTelefone(novoTelefone);
                    System.out.println("Telefone do funcionário alterado com sucesso.");
                    break;
                default:
                    System.out.println("Atributo inválido.");
                    break;
                    
                case "cargo":
                    System.out.println("digite o novo cargo do funcionário:");
                    String novoCargo = input.nextLine();
                    funcionario.setCargo(novoCargo);
                    System.out.println("Cargo alterado com sucesso.");
                    break;
                case "salario":
                    boolean salarioValido = false;
                    while (!salarioValido) {
                        try {
                            System.out.println("Digite o novo salário:");
                            int novoSalario = input.nextInt();
                            funcionario.setSalario(novoSalario);
                            System.out.println("Salário do funcionário alterado com sucesso.");
                            salarioValido = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Salário inválido. Digite um valor numérico.");
                   
                        }
                        break;
                    }
            }
        } else {
            System.out.println("Número de funcionário inválido.");
        }
    }
//Retirar dados do funcionário 
    public void removerInformacaoFuncionario(int numeroFuncionario, String atributo) {
        if (numeroFuncionario >= 0 && numeroFuncionario < cadastroFuncionario.size()) {
            Funcionario funcionario = cadastroFuncionario.get(numeroFuncionario);

            switch (atributo) {
                case "nome":
                    funcionario.setNome(null);
                    System.out.println("Nome do funcionário removido com sucesso.");
                    break;
                case "cpf":
                    funcionario.setCpf(null);
                    System.out.println("CPF do funcionário removido com sucesso.");
                    break;
                case "endereco":
                    funcionario.setEndereco(null);
                    System.out.println("Endereço do funcionário removido com sucesso.");
                    break;
                case "idade":
                    funcionario.setIdade(0);
                    System.out.println("Idade do funcionário removida com sucesso.");
                    break;
                case "telefone":
                    funcionario.setTelefone(null);
                    System.out.println("Telefone do funcionário removido com sucesso.");
                    break;
                case "cargo":
                    funcionario.setCargo(null);
                    System.out.println("O cargo do funcionário foi removido com sucesso.");
                    break;
                case "salario":
                    funcionario.setSalario(0);
                    System.out.println("O salário do funcionário foi removido com sucesso.");
                default:
                    System.out.println("Atributo inválido.");
                    break;
            }
        } else {
            System.out.println("Número de funcionário inválido.");
        }
}
}
