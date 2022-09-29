import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private  static List<Bejegyzes> bejegyzesek=new ArrayList<>();
    public static void main(String[] args) {
        Bejegyzes bejegyzes1=new Bejegyzes("Troll tanár","Idén egy vizsgaremeket sem fogok átengedni, hogy mindenkinek ősszel kelljen vizsgáznia.");
        Bejegyzes bejegyzes2 =new Bejegyzes("Junior fejlesztö","Azt hiszi, hogy programozni fog, de valójában bugfixál, és oktatási felületről tanul..");
        bejegyzesek.add(bejegyzes1);
        bejegyzesek.add(bejegyzes2);
        System.out.println(bejegyzes1);
        System.out.println(bejegyzes2);
        try {
            bejegyzesfelvetel();
        }
        catch (InputMismatchException e){
            System.out.println("nem pozitív egész számot adtál meg");
        }
        String fajlnev="bejegyzesek.csv";
        try {
            bejegyzesfajlbol(fajlnev);
        }
        catch (FileNotFoundException e){
            System.out.println("a fajl nem talalhato");
        }catch (IOException e){
            System.out.println("hiba a beolvasáskor");
            e.printStackTrace();
        }

    }
    private static void bejegyzesfajlbol(String fajlnév) throws IOException {
        FileReader fr=new FileReader(fajlnév);
        BufferedReader br =new BufferedReader(fr);
        String sor=br.readLine();
        while (sor!=null&&sor.equals("")){
            String[] adatok=sor.split(";");
            sor=br.readLine();
        }
        br.close();
    }
    private static void bejegyzesfelvetel(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Hány bejegyzést szeretne felvenni?: ");
        int db=sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < db; i++) {
            System.out.printf("%d. bejegyzés szerzője?: ",(i+1));
            String szerzo=sc.nextLine();
            System.out.printf("%d. bejegyzés tartalma?: ",(i+1));
            String tartalom=sc.nextLine();
            Bejegyzes bejegyzes=new Bejegyzes(szerzo,tartalom);
            bejegyzesek.add(bejegyzes);
        }
    }
}
