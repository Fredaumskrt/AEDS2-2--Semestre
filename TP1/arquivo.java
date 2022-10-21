import java.io.RandomAccessFile;

public class arquivo {
    public static void main(String[] args) throws Exception{
        int quantidade = MyIO.readInt();
        double numeros; // numeros com .

        RandomAccessFile raf= new RandomAccessFile("arq.txt", "rw"); // ler e escrever
        

        for(int i = 0; i < quantidade; i++){
            numeros = MyIO.readDouble();
            raf.writeDouble(numeros);
        }
        raf.close();

        raf = new RandomAccessFile("arq.txt", "r");

        for(int i = quantidade -1; i >= 0; i--){
            raf.seek(i*8);
            double num = raf.readDouble();
            if(num == (int)num){
                MyIO.println((int)num);
            } else{
                MyIO.println(num);
            }
        }
        raf.close();
    }
}
    