import java.util.Scanner;

public class alienigena {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] alien = { "A", "B", "C", "D" };

        int x = sc.nextInt();

        while(x != 0){
            int tmp = x*x;
            String resp = "";

            while(tmp != 0){
                resp = alien[tmp%4] + resp;
                tmp/=4;
            }
            System.out.println(resp);
            x = sc.nextInt();
        }
    }
}
