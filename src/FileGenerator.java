import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileGenerator {
    public static void generateFile(long filSize) {
        String filename = "banchmarck.txt";
        if (!Files.exists(Paths.get(filename))) {
            System.out.println("Criando arquivo");
            String linhabase = "Esta e uma linha de teste para o arquivo de benchmark.\n";
            long tamanho = filSize * 1024 * 1024;
            try {
                long tamanhoAtual = 0;
                BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                while (tamanhoAtual < tamanho) {
                    writer.write(linhabase);
                    tamanhoAtual += linhabase.length();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File has created in " + Paths.get(filename));
        }
    }

}
