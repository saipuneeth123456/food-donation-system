import java.sql.Connection;
import java.sql.PreparedStatement;

public class FoodDonationDAO {

    public void addDonation(FoodDonation food) {

        String sql = "INSERT INTO food_donations " +
                     "(donor_name, donor_phone, food_name, quantity, location, available_until, status) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, food.getdonorName());
            ps.setString(2, food.getdonorPhone());
            ps.setString(3, food.getfoodName());
            ps.setInt(4, food.getquantity());
            ps.setString(5, food.getlocation());
            ps.setString(6, food.getavailableuntil());
            ps.setString(7, "AVAILABLE");

            ps.executeUpdate();

            System.out.println("Food donated successfully!");

            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error while donating food");
            e.printStackTrace();
        }
    }

    public void viewAvailableFood() {

    String sql = "SELECT * FROM food_donations WHERE status = 'AVAILABLE'";

    try {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        var rs = ps.executeQuery();

        System.out.println("\n========== AVAILABLE FOOD ==========");

        while (rs.next()) {

            System.out.println("Food ID       : " + rs.getInt("id"));
            System.out.println("Donor Name    : " + rs.getString("donor_name"));
            System.out.println("Food Name     : " + rs.getString("food_name"));
            System.out.println("Quantity      : " + rs.getInt("quantity"));
            System.out.println("Location      : " + rs.getString("location"));
            System.out.println("Available Till: " + rs.getString("available_until"));
            System.out.println("------------------------------------");
        }

        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {

        System.out.println("Error while viewing food");
        e.printStackTrace();
    }
}

public void collectFood(int foodId) {

    String sql = "UPDATE food_donations " +
                 "SET status = 'COLLECTED' " +
                 "WHERE id = ? AND status = 'AVAILABLE'";

    try {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, foodId);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Food collected successfully!");
        } else {
            System.out.println("Food not available or invalid Food ID.");
        }

        ps.close();
        con.close();

    } catch (Exception e) {
        System.out.println("Error while collecting food");
        e.printStackTrace();
    }
}

public void distributeFood(int foodId) {

    String sql = "UPDATE food_donations " +
                 "SET status = 'DISTRIBUTED' " +
                 "WHERE id = ? AND status = 'COLLECTED'";

    try {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, foodId);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Food distributed successfully!");
        } else {
            System.out.println("Food is not collected or invalid Food ID.");
        }

        ps.close();
        con.close();

    } catch (Exception e) {
        System.out.println("Error while distributing food");
        e.printStackTrace();
    }
}
}
