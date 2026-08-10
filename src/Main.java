import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        FoodDonationDAO dao = new FoodDonationDAO();

        while (true) {

            System.out.println("\n================================");
            System.out.println("       FOOD DONATION SYSTEM");
            System.out.println("================================");
            System.out.println("1. Donor");
            System.out.println("2. Volunteer");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                donateFood(sc, dao);

            } else if (choice == 2) {

                volunteerMenu(sc, dao);

            } else if (choice == 3) {

                System.out.println("Thank you for using the system!");
                break;

            } else {

                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }

    // Donor menu
    public static void donateFood(Scanner sc, FoodDonationDAO dao) {

        System.out.println("\n========== DONATE FOOD ==========");

        System.out.print("Donor Name: ");
        String donorName = sc.nextLine();

        System.out.print("Phone Number: ");
        String donorPhone = sc.nextLine();

        System.out.print("Food Name: ");
        String foodName = sc.nextLine();

        System.out.print("Quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        System.out.print("Pickup Location: ");
        String location = sc.nextLine();

        System.out.print("Available Until (YYYY-MM-DD HH:MM:SS): ");
        String availableUntil = sc.nextLine();

        FoodDonation food = new FoodDonation(
                donorName,
                donorPhone,
                foodName,
                quantity,
                location,
                availableUntil
        );

        dao.addDonation(food);
    }

    // Volunteer menu
    public static void volunteerMenu(
            Scanner sc,
            FoodDonationDAO dao) {

        while (true) {

            System.out.println("\n========== VOLUNTEER ==========");
            System.out.println("1. View Available Food");
            System.out.println("2. Collect Food");
            System.out.println("3. Distribute Food");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {

                dao.viewAvailableFood();

            } else if (choice == 2) {

                System.out.print("Enter Food ID to collect: ");
                int foodId = sc.nextInt();

                dao.collectFood(foodId);

            } else if (choice == 3) {

                System.out.print("Enter Food ID to distribute: ");
                int foodId = sc.nextInt();

                dao.distributeFood(foodId);

            } else if (choice == 4) {

                break;

            } else {

                System.out.println("Invalid choice!");
            }
        }
    }
}
