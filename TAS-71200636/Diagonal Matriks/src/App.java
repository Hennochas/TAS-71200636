import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        //Baca File
        File file = new File("src/soal.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        //Baca File Perbaris
        for (int i = 0; i < line.length(); i++) {
            System.out.println(line.charAt(i));
        }
        //print
        System.out.println("\n");

    }
}
