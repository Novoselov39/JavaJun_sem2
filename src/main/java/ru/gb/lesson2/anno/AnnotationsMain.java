package ru.gb.lesson2.anno;


import ru.gb.lesson2.anno.lib.ObjectCreator;
import ru.gb.lesson2.anno.lib.Random;
import ru.gb.lesson2.hw.Homework;
import ru.gb.lesson2.hw.RandomDate;
import java.util.Date;

public class AnnotationsMain {

  public static void main(String[] args) {
    Person rndPerson = ObjectCreator.createObj(Person.class);
    System.out.println("age1 = " + rndPerson.age1);
    System.out.println("age2 = " + rndPerson.age2);
    System.out.println("date = " + rndPerson.date);


    // extPerson.isAssignableFrom(ExtPerson.class) // true
    // extPerson.isAssignableFrom(Person.class) // false
    // person.isAssignableFrom(ExtPerson.class) // true

//    Person p = new Person();
//    Person ep = new ExtPerson();

//    System.out.println(p.getClass().isAssignableFrom(Person.class)); // true
//    System.out.println(p.getClass().isAssignableFrom(ExtPerson.class)); // true
//
//    System.out.println(ep.getClass().isAssignableFrom(Person.class)); // false
//    System.out.println(ep.getClass().isAssignableFrom(ExtPerson.class)); // true

  }

  public static class ExtPerson extends Person {

  }

  public static class Person {
    public int getAge1() {
      return age1;
    }

    public void setAge1(int age1) {
      this.age1 = age1;
    }

    public int getAge2() {
      return age2;
    }

    public void setAge2(int age2) {
      this.age2 = age2;
    }

    public String getAge3() {
      return age3;
    }

    public void setAge3(String age3) {
      this.age3 = age3;
    }

    public Date getDate() {
      return date;
    }

    public void setDate(Date date) {
      this.date = date;
    }

    @Random // рандомное число в диапазоне [0, 100)
    private int age1;

    @Random(min = 50, max = 51) // рандомное число в диапазоне [50, 51) => 50
    private int age2;

    @Random
    private String age3;

    @RandomDate
    private Date date;



  }

}
