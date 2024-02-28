import java.util.*;
import java.time.LocalDate;
import java.time.Period;

public class cricManage {
    String name, type, country, dobString;
    int num, runs, wickets;

    public void set() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a Player Type (batsman/bowler): ");
        type = sc.nextLine();

        System.out.println("Enter a Player Name: ");
        name = sc.nextLine();

        System.out.println("Enter a Player Country Name : ");
        country = sc.nextLine();

        System.out.println("Enter a Player Jersey Number: ");
        num = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Enter player date of birth (yyyy-mm-dd):");
        dobString = sc.nextLine();
        LocalDate dob = LocalDate.parse(dobString);

        if (type.equals("batsman")) {
            System.out.println("Enter Players Runs: ");
            runs = Integer.parseInt(sc.nextLine());
        } else if (type.equals("bowler")) {
            System.out.println("Enter Players Wickets: ");
            wickets = Integer.parseInt(sc.nextLine());
        }
    }

    void getData() {
        Period agePeriod = AgeCalculator.calculateAge(LocalDate.parse(dobString));
        int age = agePeriod.getYears();
        System.out.println("Player Name: " + name);
        System.out.println("Player Country: " + country);
        System.out.println("Player Jersey Number: " + num);
        System.out.println("Player Type: " + type);
        System.out.println("Age: " + age);

        if (type.equals("batsman")) {
            System.out.println("Player Runs: " + runs);
        } else if (type.equals("bowler")) {
            System.out.println("Player Wickets: " + wickets);
        }
    }

    static class AgeCalculator {
        static Period calculateAge(LocalDate dob) {
            LocalDate currentDate = LocalDate.now();
            return Period.between(dob, currentDate);
        }
    }

    public static void main(String[] args) {
        cricManage c = new cricManage();
        c.set();
        c.getData();
    }
}
