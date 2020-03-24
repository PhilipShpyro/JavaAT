package training.epam;

public class Person{
  private int id;
  private static int idCounter = 0;
  private String fullName, birthDate, phoneNumber, address;
  
  public int getId(){
    return id;
  }
  final public String getFullName(){
    return fullName;
  }
  final public String getBirthDate(){
    return birthDate;
  }
  final public String getPhoneNumber(){
    return phoneNumber;
  }
  final public String getAddress(){
    return address;
  }
  
  final public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }
  final public void setAddress(String address){
    this.address = address;
  }
  
  Person(String fullName, String birthDate){
    id = idCounter++;
    this.fullName = fullName;
    this.birthDate = birthDate;
  }
  
  @Override
  public String toString(){
    return "*********************\nid: " + id
      + "\nfull name: " + fullName
      + "\nbirth date: " + birthDate
      + "\nphone: " + (phoneNumber!=null?phoneNumber:"not defined")
      + "\naddress: " + (address!=null?address:"not defined");
  }
}