public class Vehicle extends Renter
{
    //Attributes
    private String renterLicenseExp;
    private char rentalType;
    private char vehicleType;
    private char vehicleModel;
    private int vehicleDuration;
    private String vehicleName;
    private double vehiclePrice;
    
    //Default constructor
    public Vehicle()
    {
        super();
    }
    //Normal constructor
    public Vehicle(String name, String phone, String ic, RentalCompany company, String renterLicenseExp, char rentalType, char vehicleType, char vehicleModel, 
                   int vehicleDuration)
    {
        super(name,phone,ic,company);
        this.renterLicenseExp = renterLicenseExp;
        this.rentalType = rentalType;
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.vehicleDuration = vehicleDuration;
    }
    //Mutator method
    public void setVehicle(String newRenterLicenseExp, char newRentalType, char newVehicleType, char newVehicleModel, int newVehicleDuration)
    {
        renterLicenseExp = newRenterLicenseExp;
        rentalType = newRentalType;
        vehicleType = newVehicleType;
        vehicleModel = newVehicleModel;
        vehicleDuration = newVehicleDuration;
    }
    //Accessor method
    public String getRenterLicenseExp(){return renterLicenseExp;}
    public char getRentalType(){return rentalType;}
    public char getVehicleType(){return vehicleType;}
    public char getVehicleModel(){return vehicleModel;}
    public int getVehicleDuration(){return vehicleDuration;}
    public String getVehicleName(){return vehicleName;}
    public double getVehiclePrice(){return vehiclePrice;}
    //Processing method
    public double driver() //Driver charge for Lorry rental
    {
        if(super.getCompany().getCompanyName().equals("BigWheels")) 
            return 100.0*vehicleDuration;
        else
            return 0.0;
    }
    
    public double calcPrice() // Set vehicle name, vehicle price and return total price including 7% tax
    {
        switch(rentalType)
        {
            case 'H':
                if(super.getCompany().getCompanyName() == "SwiftDrive")
                 {
                    if(vehicleType == 'C' && vehicleModel == 'S')
                    {
                        vehicleName = "Perodua Axia";
                        vehiclePrice = 7.0;
                    }
                    else if(vehicleType == 'C' && vehicleModel == 'P')
                    {
                        vehicleName = "Honda Jazz";
                        vehiclePrice = 10.0;
                    }
                    else if(vehicleType == 'S' && vehicleModel == 'S')
                    {
                        vehicleName = "Perodua Bezza";
                        vehiclePrice = 12.0;
                    }
                    else if(vehicleType == 'S' && vehicleModel == 'P')
                    {
                        vehicleName = "Honda City";
                        vehiclePrice = 15.0;
                    }    
                }
                else if(super.getCompany().getCompanyName() == "CarrierGo")  
                {
                    if(vehicleType == 'M' && vehicleModel == 'S')
                    {
                        vehicleName = "Perodua Alza";
                        vehiclePrice = 25.0;
                    }
                    else if(vehicleType == 'M' && vehicleModel == 'P')
                    {
                        vehicleName = "Honda Odyssey";
                        vehiclePrice = 28.0;
                    }
                    else if(vehicleType == 'V' && vehicleModel == 'C')
                    {
                        vehicleName = "Nissan NV200";
                        vehiclePrice = 27.0;
                    }
                    else if(vehicleType == 'V' && vehicleModel == 'P')
                    {
                        vehicleName = "Nissan NV200";
                        vehiclePrice = 30.0;
                    }
                }
                break;
            
            case 'D':
                if(super.getCompany().getCompanyName() == "SwiftDrive")
                {
                    if(vehicleType == 'C' && vehicleModel == 'S')
                    {
                        vehicleName = "Perodua Axia";
                        vehiclePrice = 90.0;
                    }
                    else if(vehicleType == 'C' && vehicleModel == 'P')
                    {
                        vehicleName = "Honda Jazz";
                        vehiclePrice = 110.0;
                    }
                    else if(vehicleType == 'S' && vehicleModel == 'S')
                    {
                        vehicleName = "Perodua Bezza";
                        vehiclePrice = 130.0;
                    }
                    else if(vehicleType == 'S' && vehicleModel == 'P')
                    {
                        vehicleName = "Honda City";
                        vehiclePrice = 150.0;
                    }    
                }  
                else if(super.getCompany().getCompanyName() == "CarrierGo")
                {
                    if(vehicleType == 'M' && vehicleModel == 'S')
                    {
                        vehicleName = "Perodua Alza";
                        vehiclePrice = 280.0;
                    }
                    else if(vehicleType == 'M' && vehicleModel == 'P')
                    {
                        vehicleName = "Honda Odyssey";
                        vehiclePrice = 300;
                    }
                    else if(vehicleType == 'V' && vehicleModel == 'C')
                    {
                        vehicleName = "Nissan NV200";
                        vehiclePrice = 280.0;
                    }
                    else if(vehicleType == 'V' && vehicleModel == 'P')
                    {
                        vehicleName = "Nissan NV200";
                        vehiclePrice = 320.0;
                    }
                }
                else if(super.getCompany().getCompanyName() == "BigWheels")
                {
                    if(vehicleModel == 'F')
                    {
                        vehicleName = "Hino 300 Series";
                        vehiclePrice = 480.0;
                    }            
                    else if(vehicleModel == 'T')
                    {
                        vehicleName = "Hino 500 Series";
                        vehiclePrice = 820.0;
                    }
                }
                break;
        }
        
        return (vehiclePrice*vehicleDuration+driver())*1.07;
    }
    //Display method
    public String displayReceipt()
    {
        String type = "";
        if(rentalType == 'H'){type = "Hour ";}
        else if(rentalType == 'D'){type = "Day  ";}
        
        String driver = "";
        if(driver() != 0.0)
        {
            driver = "\n  Driver Charge               RM" + String.format("%.2f",driver());
        }
        
        return "\n ============================================ " +
                "\n        Car Rental And Accommodation         " + 
                "\n             Owned & Operated By :           " +
                "\n         " + getCompany().toString() +
                "\n --------------------------------------------" +
                "\n  Renter Name  : " + renterName +
                "\n  Phone Number : " + renterPhoneNo + "\n" +
                
                "\n  Vehicle                     " + vehicleName +
                "\n  Rental " + type + "                " + vehicleDuration +
                "\n  Rental Price                RM" + String.format("%.2f",vehiclePrice) + driver +
                "\n                             ----------------" +
                "\n  Total Payment               RM" + String.format("%.2f",calcPrice()) +
                "\n --------------------------------------------" +
                "\n                                             " +
                "\n   * your total payment is included 7% tax   " +
                "\n                ~ Thank you ~                " + 
                "\n ============================================" +
                "\n ";
    }
}
