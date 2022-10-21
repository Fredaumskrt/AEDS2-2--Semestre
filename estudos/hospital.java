import java.util.*;

public class hospital {
    public static void main(String[] args) throws Exception {
        String entrada = "";
        int inteiroN = 0;

        // entrada = Integer.parseInt(0);

        int h = 0; // 7 < H < 19
        int m = 0; // 0 <= m <= 60
        int c = 0; // 0 <= M <= 60
        Scanner ler = new Scanner(System.in);

        entrada = ler.nextLine();

        for (int i = 0; i <= 3; i++) {
            int array[] = new int[inteiroN];
            entrada = entrada.replace(" ", "");

            h = ler.nextInt();
            if (h < 7) {
                System.out.print(h);
            } else if (h < 19) {
                System.out.println(h + "");
            } else if (h > 19) {
                break;
            }
        }
        entrada = ler.nextLine();
        // m <= 0 <= 60

        for (int j = 0; j <= entrada.length(); j++) {
            int arrayM[] = new int[inteiroN];

            m = ler.nextInt();

            if (m <= 0) {
                System.out.println(m + "");
                continue;
            } else if (m <= 60) {
                System.out.println(m + "");
                continue;
            }
        }

        for (int k = 0; k <= entrada.length(); k++) {
            int arrayC[] = new int[inteiroN];

            c = ler.nextInt();
            if (c <= 0) {
                System.out.println(c + "");
                continue;
            } else if (c <= 60) {
                System.out.println(c + "");
                continue;
            }
        }
    }

}
