import java.util.Scanner;
class Isolado {

    public static void main(String[] args) {
        
        String input = "";

        while(true) {

            input = System.out.readLine();

            if(input.length() == 1 && input.compareTo("0") == 0) break;

            input = System.out.readLine();

            String s_nums[] = input.split(" ");
            
            for(int i = 0; i < s_nums.length; i++) {

                int count = 0;

                for(int j = 0; j < s_nums.length; j++) {

                    if(s_nums[i].compareTo(s_nums[j]) == 0) count++;
                }

                if(count % 2 != 0) {

                    System.out.println(s_nums[i]);
                    break;
                }
            }
        }
    }
}