//Importações necessárias para a classe Cliente.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

// Classe dedicada aos clientes
public class Cliente {

    //#region Atributos de Classes e Encapsulamento

    // Lista de clientes
    private ArrayList<Cliente> clientes = new ArrayList<>();
    //Scanner da classe
    Scanner input = new Scanner(System.in);

    // Atributos do cliente
    protected String nome;
    protected String cpf;
    protected String endereco;
    protected int idade;
    protected String telefone;

    //Encapsulamento dos Atributos
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Construtor
    public Cliente(String nome, String cpf, String endereco, int idade, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.idade = idade;
        this.telefone = telefone;
    }
    
    //#endregion

    //#region Metódos da Classe

    // Método que deixa cadastrado e armazenado os 7 primeiros objetos
    public void criarClientesAutomatico() {
        clientes.add(new Cliente("Roan", "123.331.312-12", "Rua A", 18, "1111"));
        clientes.add(new Cliente("Pedro", "123.331.312-12", "Rua b", 19, "9999"));
        clientes.add(new Cliente("Alice", "123.331.312-12", "Rua c", 20, "22222"));
        clientes.add(new Cliente("David", "123.331.312-12", "Rua d", 29999, "3333"));
        clientes.add(new Cliente("Andre", "123.331.312-12", "Rua e", 22123, "4444"));
        
    }

    

    // Método para cadastrar novos clientes
    public void cadastrarNovosClientes() {
        
        System.out.println("====== Cadastro de Clientes ======");
        System.out.println("");
        System.out.println("Digite a quantidade de clientes.");
        int quantidade = input.nextInt();
        input.nextLine();
        
        for(int i = 0; i<quantidade;i++){
        System.out.println("Cadastre o " + (i+1) + "° cliente.");
        System.out.println("Digite o nome do cliente:");
        String nome = input.nextLine();

        System.out.println("Digite o CPF do cliente:");
        String cpf = input.nextLine();

        System.out.println("Digite o endereço do cliente:");
        String endereco = input.nextLine();

        int idade = 0;
        boolean idadeValida = false;
        while (!idadeValida) {
            try {
                System.out.println("Digite a idade do cliente:");
                idade = input.nextInt();
                idadeValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Idade inválida. Digite um valor numérico.");
                input.nextLine();
            }
        }

        input.nextLine(); // Limpa o buffer do teclado

        System.out.println("Digite o telefone do cliente:");
        String telefone = input.nextLine();

        // Cria um novo objeto Cliente e adiciona à lista de clientes
        Cliente novoCliente = new Cliente(nome, cpf, endereco, idade, telefone);
        clientes.add(novoCliente);

        System.out.println("Cliente cadastrado com sucesso!");

        System.out.println("");
    }
    }

    // Método para imprimir os clientes da lista
    public void imprimirClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("====== Lista de Clientes ======");
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println("Cliente °" + (i + 1) + ":");
                System.out.println("Nome: " + clientes.get(i).getNome());
                System.out.println("CPF: " + clientes.get(i).getCpf());
                System.out.println("Endereço: " + clientes.get(i).getEndereco());
                System.out.println("Idade: " + clientes.get(i).getIdade());
                System.out.println("Telefone: " + clientes.get(i).getTelefone());
                System.out.println();
            }
        }
    }

    // Método para procurar um cliente com base em uma informação fornecida
    public void procurarCliente(Object informacao) {
        boolean clienteEncontrado = false;
       
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(informacao) || cliente.getCpf().equals(informacao)
                || cliente.getEndereco().equals(informacao) || String.valueOf(cliente.getIdade()).equals(informacao)
                || cliente.getTelefone().equals(informacao)) {
            	
                System.out.println("Cliente encontrado:");
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("CPF: " + cliente.getCpf());
                System.out.println("Endereço: " + cliente.getEndereco());
                System.out.println("Idade: " + cliente.getIdade());
                System.out.println("Telefone: " + cliente.getTelefone());
                System.out.println();

                clienteEncontrado = true;
            	}
        	}
        if (!clienteEncontrado) {
            System.out.println("Cliente não encontrado.");
        }
    }

    // Método para alterar uma informação do cliente
    public void alterarInformacaoCliente(int numeroCliente, String atributo) {
        if (numeroCliente >= 0 && numeroCliente < clientes.size()) {
            Cliente cliente = clientes.get(numeroCliente);

            switch (atributo) {
                case "nome":
                    System.out.println("Digite o novo nome:");
                    String novoNome = input.nextLine();
                    cliente.setNome(novoNome);
                    System.out.println("Nome do cliente alterado com sucesso.");
                    break;
                    
                case "cpf":
                    System.out.println("Digite o novo CPF:");
                    String novoCpf = input.nextLine();
                    cliente.setCpf(novoCpf);
                    input.nextLine();
                    System.out.println("CPF do cliente alterado com sucesso.");
                    break;
                    
                case "endereco":
                    System.out.println("Digite o novo endereço:");
                    String novoEndereco = input.nextLine();
                    cliente.setEndereco(novoEndereco);
                    System.out.println("Endereço do cliente alterado com sucesso.");
                    break;
                    
                case "idade":
                    boolean idadeValida = false;
                    while (!idadeValida) {
                        try {
                            System.out.println("Digite a nova idade:");
                            int novaIdade = input.nextInt();
                            cliente.setIdade(novaIdade);
                            System.out.println("Idade do cliente alterada com sucesso.");
                            idadeValida = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Idade inválida. Digite um valor numérico.");
                   
                        }
                        break;
                    }
                    
                    
                case "telefone":
                    System.out.println("Digite o novo telefone:");
                    String novoTelefone = input.nextLine();
                    cliente.setTelefone(novoTelefone);
                    System.out.println("Telefone do cliente alterado com sucesso.");
                    break;
                default:
                    System.out.println("Atributo inválido.");
                    break;
            }
        } else {
            System.out.println("Número de cliente inválido.");
        }
    }

    // Método para remover uma informação do cliente
    public void removerInformacaoCliente(int numeroCliente, String atributo) {
        if (numeroCliente >= 0 && numeroCliente < clientes.size()) {
            Cliente cliente = clientes.get(numeroCliente);

            switch (atributo) {
                case "nome":
                    cliente.setNome(null);
                    System.out.println("Nome do cliente removido com sucesso.");
                    break;
                case "cpf":
                    cliente.setCpf(null);
                    System.out.println("CPF do cliente removido com sucesso.");
                    break;
                case "endereco":
                    cliente.setEndereco(null);
                    System.out.println("Endereço do cliente removido com sucesso.");
                    break;
                case "idade":
                    cliente.setIdade(0);
                    System.out.println("Idade do cliente removida com sucesso.");
                    break;
                case "telefone":
                    cliente.setTelefone(null);
                    System.out.println("Telefone do cliente removido com sucesso.");
                    break;
                default:
                    System.out.println("Atributo inválido.");
                    break;
            }
        } else {
            System.out.println("Número de cliente inválido.");
        }
    }

    // Método para ordenar os clientes por nome
    public void ordenarClientesPorNome() {
        Collections.sort(clientes, new Comparator<Cliente>() {
            public int compare(Cliente c1, Cliente c2) {
                return c1.getNome().compareTo(c2.getNome());
            }
        });

        System.out.println("Lista de clientes ordenada por nome:");
        imprimirClientes();
    }
   //#endregion
}
