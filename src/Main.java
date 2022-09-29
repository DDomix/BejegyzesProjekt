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
        try {
            bejegyzesfelvetel();
        }
        catch (InputMismatchException e){
            System.out.println("nem pozitív egész számot adtál meg");
        }
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
