import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class BanchmarckIO {
    private static final String FILENAME = "banchmarck.txt";
    private static long time_init, time_end;

    public static void banchmarckFileReadMethods() {
        usingOdVersion();
        usingNIO();
        usingNIO2();

    }

    private static void usingOdVersion() {

        Path path = Paths.get(FILENAME);

        time_init = System.currentTimeMillis();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))) {
            while (bufferedReader.readLine() != null)
                ;
            bufferedReader.close();
            time_end = System.currentTimeMillis();

            System.out.println("JAVA IO classico- Demorou: " + (time_end - time_init) + " ms");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private static void usingNIO() {
        Path path = Paths.get(FILENAME);
        time_init = System.currentTimeMillis();
        try (FileChannel channel = FileChannel.open(path, StandardOpenOption.READ)) {

            ByteBuffer buffer = ByteBuffer.allocate(16384);
            while (channel.read(buffer) != -1) {
                buffer.flip();
                buffer.clear();
            }
            channel.close();
            time_end = System.currentTimeMillis();
            System.out.println("JAVA NIO channel- Demorou: " + (time_end - time_init) + " ms");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private static void usingNIO2() {
        Path path = Paths.get(FILENAME);
        time_init = System.currentTimeMillis();
        try {
            List<String> linhas = Files.readAllLines(path);
        } catch (IOException | SecurityException e) {
            e.getStackTrace();
        }
        time_end = System.currentTimeMillis();
        System.out.println("JAVA NIO2 all lines- Demorou: " + (time_end - time_init) + " ms");
    }
}