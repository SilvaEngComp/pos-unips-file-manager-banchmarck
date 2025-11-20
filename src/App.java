public class App {
    public static void main(String[] args) throws Exception {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        FileGenerator.generateFile(200L);
        BanchmarckIO.banchmarckFileReadMethods();

    }
}
