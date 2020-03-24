package training.epam;

public class Student extends Person{
  private String faculty;
  private int courseNumber, groupNumber;
  
  public void setFaculty(String faculty){
    this.faculty = faculty;
  }
  public void setCourseNumber(int courseNumber){
    this.courseNumber = courseNumber;
  }
  public void setGroupNumber(int groupNumber){
    this.groupNumber = groupNumber;
  }
  
  public String getFaculty(){
    return faculty;
  }
  public int getCourseNumber(){
    return courseNumber;
  }
  public int getGroupNumber(){
    return groupNumber;
  }
  
  Student(String fullName, String birthDate, String faculty, int courseNumber, int groupNumber){
    super(fullName, birthDate);
    this.faculty = faculty;
    this.courseNumber = courseNumber;
    this.groupNumber = groupNumber;
  }
  Student(String fullName, String birthDate, String phoneNumber, String address, String faculty, int courseNumber, int groupNumber){
    this(fullName, birthDate, faculty, courseNumber, groupNumber);
    setPhoneNumber(phoneNumber);
    setAddress(address);
  }
  
  @Override
  public String toString(){
    return super.toString()
      + "\nfaculty: " + faculty
      + "\ncourse number: " + courseNumber
      + "\ngroup number: " + groupNumber;
  }
}