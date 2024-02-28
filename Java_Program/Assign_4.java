import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Assign_4 {
    static class Player {
        String name;
        LocalDate dob;
        String category;
        int runsScored;
        boolean isRetired;
		int age;

        Player(String name, LocalDate dob, int runsScored, boolean isRetired) {
            this.name = name;
            this.dob = dob;
            this.runsScored = runsScored;
            this.isRetired = isRetired;
            setCategory();
        }

        void setCategory() {
            Period agePeriod = AgeCalculator.calculateAge(dob);
            age = agePeriod.getYears();

            if (age < 25)
                category = "Young";
            else if (age >= 25 && age <= 35)
                category = "Adult";
            else
                category = "Senior";
        }

        void recordRuns(int runs) {
            runsScored += runs;
        }

        void retirePlayer() {
            isRetired = true;
        }

        void displayPlayerInfo() {
            System.out.println("Player Name: " + name);
            System.out.println("Date of Birth: " + dob);
            System.out.println("Age Category: " + category);
            System.out.println("Runs Scored: " + runsScored);
			System.out.println("Age : " + age);
            System.out.println("Player Status: " + (isRetired ? "Retired" : "Active"));
        }
    }

    static class AgeCalculator {
        static Period calculateAge(LocalDate dob) {
            LocalDate currentDate = LocalDate.now();
            return Period.between(dob, currentDate);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Cricket Player Management System");

        System.out.println("Enter player name:");
        String name = scanner.nextLine();

        System.out.println("Enter player date of birth (yyyy-mm-dd):");
        String dobString = scanner.nextLine();
        LocalDate dob = LocalDate.parse(dobString);

        System.out.println("Enter runs scored by the player:");
        int runsScored = scanner.nextInt();

        System.out.println("Is the player retired? (true/false):");
        boolean isRetired = scanner.nextBoolean();

        Player player = new Player(name, dob, runsScored, isRetired);
        player.displayPlayerInfo();

        // Record additional runs
        System.out.println("Enter runs to record:");
        int runs = scanner.nextInt();
        player.recordRuns(runs);
        System.out.println("Runs recorded successfully!");

        player.displayPlayerInfo();
    }
}
