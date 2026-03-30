import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RetanguloConsole {
    public static void main(String[] args) {
        String path = "caso01.txt";
        
        try (Scanner scanner = new Scanner(new File(path))) {
            
            int largura = scanner.nextInt();   // w
            int altura = scanner.nextInt();    // h
            int numeroMinas = scanner.nextInt(); // m

            System.out.println("Config: Largura=" + largura + " Altura=" + altura + " Minas=" + numeroMinas);

            char[][] mapaMinas = new char[altura][largura];

            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < largura; j++) {
                    if (i == 0 || i == altura - 1) {
                        mapaMinas[i][j] = '-';
                    } else if (j == 0 || j == largura - 1) {
                        mapaMinas[i][j] = '|';
                    } else {
                        mapaMinas[i][j] = ' ';
                    }
                    System.out.print(mapaMinas[i][j]);
                }
                System.out.println(); 
            }

            while (scanner.hasNextInt()) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                System.out.print(mapaMinas[y][x] = '*');
            }

        } catch (FileNotFoundException e) {
            System.err.println("Erro: Arquivo não encontrado em " + path);
        }
    }
}
