package training.epam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main{
  public static void main(String[] args){
    Student[] students = {
      new Student("Ivanova Iryna Petrovna", "3.2.1999", "+375295589260", "Minsk", "RFE", 4, 42),
      new Student("Cerlukevich Maria Ivanovna", "24.11.1999", "+375293243037", "Pinsk", "FEMI", 4, 44),
      new Student("Ivanov Ivan Ivanovich", "28.5.1999", "+375294560656", "Vitebsk", "FEMI", 4, 44),
      new Student("Russky Vladimir Ilyich", "3.4.1997", "+375292738440", "Mogilev", "MMF", 5, 51),
      new Student("Pansky Zbignew Stanislavovich", "14.7.2000", "+375298273048", "Grodno", "RFE", 2, 22),
      new Student("Pankratova Olga Sergeevna", "16.10.2000", "+375293838581", "Pinsk", "MMF", 3, 31),
      new Student("Pygachev Boris Egorovich", "5.2.1998", "+375299265349", "Babruysk", "FIC", 2, 23),
      new Student("Svetlakova Snejana Denisovna", "12.12.1999", "+375299484471", "Minsk", "RFE", 3, 32),
      new Student("Dobryj Mikhail Markovich", "29.3.2000", "+375295327675", "Mogilev", "FIC", 2, 23),
      new Student("Ivanov Kiryl Nikitich", "11.11.2001", "+375297997805", "Minsk", "FIC", 1, 13),
    };
    
    //I must use final(or effectively final) variables in lambdas, so I've decided to use some more {} brackets
    //first subtask
    {
      final String faculty = "FEMI";
      List<Student> studentsListByFaculty = 
        Arrays.stream(students).filter(student -> student.getFaculty()==faculty).collect(Collectors.toList());
      for(Student student : studentsListByFaculty)
        System.out.println(student);
    }
    
    //second subtask
    for(Faculty faculty : Faculty.values()){
      for(int i = 1; i <= 5; i++){
        final int course = i;
        List<Student> studentsListByFacultyAndGroupNumber = 
          Arrays.stream(students).
          filter(student -> student.getCourseNumber()==course).
          filter(student -> student.getFaculty()==faculty.toString()).collect(Collectors.toList());
        for(Student student : studentsListByFacultyAndGroupNumber)
          System.out.println(student);
      }
    }
    
    //third subtask
    {
      final int year = 1999;
      List<Student> studentsBornAfterYear = 
        Arrays.stream(students).
        filter(student -> Integer.parseInt(student.getBirthDate().split("\\.")[2]) > year).collect(Collectors.toList());
      for(Student student : studentsBornAfterYear)
        System.out.println(student);
    }
    
    //fourth subtask
    {
      final int groupNumber = 44;
      List<Student> studentsListByGroupNumber = 
        Arrays.stream(students).
        filter(student -> student.getGroupNumber()==groupNumber).collect(Collectors.toList());
      for(Student student : studentsListByGroupNumber)
        System.out.println(student);
    }
  }
}