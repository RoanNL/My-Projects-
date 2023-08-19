//Importações necessárias para a classe TerminalUtils.java
import java.io.IOException;

public class TerminalUtils {

    //Método que aplica a limpeza no terminal
    public void limparTerminal() {
        try {
            // Obtém o nome do sistema operacional
            String os = System.getProperty("os.name").toLowerCase();

            ProcessBuilder processBuilder;
            if (os.contains("win")) {
                // Comando para limpar o terminal no Windows
                processBuilder = new ProcessBuilder("cmd", "/c", "cls");
            } else {
                // Comando para limpar o terminal em Unix/Linux/Mac
                processBuilder = new ProcessBuilder("clear");
            }
            // Cria e inicia o processo de limpeza do terminal
            Process process = processBuilder.inheritIO().start();

            // Aguarda a conclusão do processo
            int result = process.waitFor();

            if (result != 0) {
                // Imprime uma mensagem de erro caso a limpeza do terminal não seja bem-sucedida
                System.out.println("Não foi possível limpar o terminal.");
            }
        } catch (IOException | InterruptedException e) {
            // Captura e trata exceções de entrada/saída e interrupção
            System.out.println("Erro ao limpar o terminal: " + e.getMessage());
        }
    }
}
