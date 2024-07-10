package ru.gb.lesson1.hw;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Homework {

  private static class Department {
    private String name;

    public Department(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return "Department{" +
              "name='" + name + '\'' +
              '}';
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
// TODO: геттеры, сеттеры
  }

  private static class Person {
    private String name;

    @Override
    public String toString() {
      return "Person{" +
              "name='" + name + '\'' +
              ", age=" + age +
              ", salary=" + salary +
              ", depart=" + depart +
              '}';
    }

    private int age;
    private double salary;
    private Department depart;

    public Person(String name, int age, double salary, Department depart) {
      this.name = name;
      this.age = age;
      this.salary = salary;
      this.depart = depart;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    public double getSalary() {
      return salary;
    }

    public void setSalary(double salary) {
      this.salary = salary;
    }

    public Department getDepart() {
      return depart;
    }

    public void setDepart(Department depart) {
      this.depart = depart;
    }
    // TODO: геттеры, сеттеры
  }

  public static void main(String[] args) {

    List<Person> listPerson =generatePerson(3);
    System.out.println(listPerson);
//    System.out.println(findMostYoungestPerson(listPerson));
//    System.out.println(findMostExpensiveDepartment(listPerson));
//    System.out.println(groupByDepartment(listPerson));
//    System.out.println(groupByDepartmentName(listPerson));
//    System.out.println(getDepartmentOldestPerson(listPerson));
    System.out.println(cheapPersonsInDepartment(listPerson));
  }

  private static List<Person> generatePerson(int count)  {
    List<String> namePerson = List.of("Tolstoy", "Bulgakov", "Dostoevskii", "Gogol", "Martin", "Hugo", "Duma");
    List<String> nameDepartment = List.of("marketing",
            "logistics" ,
            "production",
            "commercial");
    List<Person> listPeople = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      Person person =new Person(getRandom(namePerson),
              ThreadLocalRandom.current().nextInt(18, 50),
              ThreadLocalRandom.current().nextInt(35000, 100000)*1.0,
              new Department(getRandom(nameDepartment)));

      listPeople.add(person);
    }
    return listPeople;
  }


  private static <T> T getRandom(List<? extends T> items) {
    int randomIndex = ThreadLocalRandom.current().nextInt(0, items.size());
    return items.get(randomIndex);
  }



  /**
   * Найти самого молодого сотрудника
   */
  static Optional<Person> findMostYoungestPerson(List<Person> people) {
    // FIXME: ваша реализация здесь
    Optional<Person> min = people.stream()
            .min(Comparator.comparingInt(Person::getAge));
    return min;


  }

  /**
   * Найти департамент, в котором работает сотрудник с самой большой зарплатой
   */
  static Optional<Department> findMostExpensiveDepartment(List<Person> people) {
    // FIXME: ваша реализация здесь
    Person answer =  people.stream()
            .max(Comparator.comparing(Person::getSalary)).get();


    return Optional.ofNullable(answer.getDepart());
  }

  /**
   * Сгруппировать сотрудников по департаментам
   */
  static Map<Department, List<Person>> groupByDepartment(List<Person> people) {
    // FIXME: ваша реализация здесь
    return people.stream()
            .collect(Collectors.groupingBy(Person::getDepart));

  }

  /**
   * Сгруппировать сотрудников по названиям департаментов
   */
  static Map<String, List<Person>> groupByDepartmentName(List<Person> people) {
    // FIXME: ваша реализация здесь
    return people.stream()
            .collect(Collectors.groupingBy(o -> o.getDepart().getName()));


  }

  /**
   * В каждом департаменте найти самого старшего сотрудника
   */
  static Map<String, Person> getDepartmentOldestPerson(List<Person> people) {
    // FIXME: ваша реализация здесь
    return people.stream()
            .collect(Collectors.toMap(
                    o -> o.getDepart().getName(),
                    Function.identity(),
                    (a,b)-> {
                      if (a.getAge()>b.getAge()){
                        return a;
                      }
                      return b;
                    }
            ));
  }

  /**
   * *Найти сотрудников с минимальными зарплатами в своем отделе
   * (прим. можно реализовать в два запроса)
   */
  static List<Person> cheapPersonsInDepartment(List<Person> people) {
    // FIXME: ваша реализация здесь

    return people.stream()
            .collect(Collectors.toMap(
                    Person::getDepart,
                    Function.identity(),
                    (a,b)->{
                      if (a.getSalary()<b.getSalary()){
                        return a;
                      }
                      return b;
                    }
            ))
            .values()
            .stream()
            .toList();



  }

}
