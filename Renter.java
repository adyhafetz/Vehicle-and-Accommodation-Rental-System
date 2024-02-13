public abstract class Renter
{
    //Attributes
    public String renterName;
    public String renterPhoneNo;
    public String renterIcNo;
    public RentalCompany company;
    protected String bankName;
    protected String bankID;
    
    //Default constructor
    public Renter()
    {
        company = new RentalCompany();
    }
    //Normal constructor
    public Renter(String name, String phone, String ic, RentalCompany company)
    {
        renterName = name;
        renterPhoneNo = phone;
        renterIcNo = ic;
        this.company = company;
    }
    //Mutator method
    public void setRenter(String newName, String newPhone, String newIc, RentalCompany newCompany)
    {
        renterName = newName;
        renterPhoneNo = newPhone;
        renterIcNo = newIc;
        company = newCompany;
    }
    
    public void setBankName(String name)
    {
        bankName = name;
    }

    public void setBankID(String id)
    {
         bankID = id;   
    }
    //Accessor method
    public String getRenterName(){return renterName;}
    public String getRenterPhoneNo(){return renterPhoneNo;}
    public String getRenterIcNo(){return renterIcNo;}
    public RentalCompany getCompany(){return company;}
    public String getBankName(){return bankName;}
    public String getBankId(){return bankID;}
    //Abstract method
    public abstract double calcPrice();
    public abstract String displayReceipt();
    //Display method
    public String toString()
    {
        return "\nRenter Name  : " + renterName +
                "\nPhone Number : " + renterPhoneNo + 
                "\nIC Number    : " + renterIcNo +
                "\nCompany      : " + company.getCompanyName() +
                "\nBank Name    : " + bankName +
                "\nBank ID      : " + bankID ;
    }
}
