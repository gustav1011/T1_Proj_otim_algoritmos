import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RetanguloConsole {
    public static void main(String[] args) {
        String path = "caso02.txt";
        
        try (Scanner scanner = new Scanner(new File(path))) {
            
            int largura = scanner.nextInt();   // w
            int altura = scanner.nextInt();    // h
            int numeroMinas = scanner.nextInt(); // m
            int c1;
            int c2;

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
            }
        }

            while (scanner.hasNextInt()) {
                c1 = scanner.nextInt(); // Coluna (X)
                c2 = scanner.nextInt(); // Linha (Y)
                
                // Verifica se a coordenada está dentro dos limites da matriz
                if (c2 < altura && c1 < largura) {
                    mapaMinas[c2][c1] = '*'; 
                }
            }

            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < largura; j++) {
                    System.out.print(mapaMinas[i][j]);
                }
                System.out.println(); // Pula linha ao final de cada linha do mapa
            }

        } catch (FileNotFoundException e) {
            System.err.println("Erro: Arquivo não encontrado em " + path);
        }
    }
}
