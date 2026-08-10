public class FoodDonation{
    private String donorName;
    private String donorPhone;
    private String foodName;
    private int quantity;
    private String location;
    private String availableuntil;

    public FoodDonation(String donorName, String donorPhone, String foodName, int quantity, String location, String availableuntil) {
        this.donorName = donorName;
        this.donorPhone = donorPhone;
        this.foodName = foodName;
        this.quantity = quantity;
        this.location = location;
        this.availableuntil = availableuntil;
    }

    public String getdonorName(){
        return donorName;
    }
    public String getdonorPhone(){
        return donorPhone;
    }
    public String getfoodName(){
        return foodName;
    }
    public int getquantity(){
        return quantity;
    }
    public String getlocation(){
        return location;
    }
    public String getavailableuntil(){
        return availableuntil;
    }


}
