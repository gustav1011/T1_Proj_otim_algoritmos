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
                        mapaMinas[i][j] = '.';
                    }
                }
            }

            while (scanner.hasNextInt()) {
                c1 = scanner.nextInt(); // Coluna (X)
                c2 = scanner.nextInt(); // Linha (Y)

                if (c2 < altura && c1 < largura) {
                    mapaMinas[c2][c1] = '*';
                }
            }

            // imprime mapa
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < largura; j++) {
                    System.out.print(mapaMinas[i][j]);
                }
                System.out.println();
            }

            // ✅ AGORA ESTÁ NO LUGAR CERTO
            int maiorArea = verificaArea(mapaMinas, largura);
            System.out.println("\nMaior área livre: " + maiorArea);

        } catch (FileNotFoundException e) {
            System.err.println("Erro: Arquivo não encontrado em " + path);
        }
    }

    // ✅ precisa ser static
    public static int verificaArea(char[][] mapa, int largura) {
        int[] altura = new int[largura];

        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < largura; j++) {
                if (mapa[i][j] == '*') {
                    altura[j] = 0;
                } else {
                    altura[j] += 1;
                }
            }
        }

        // ✅ imprime alturas (pra debug)
        System.out.print("Alturas: ");
        for (int h : altura) {
            System.out.print(h + " ");
        }
        System.out.println();

        return 0;
    }
}