package ru.gb.lesson2.hw;

import lombok.Data;
import ru.gb.lesson2.anno.AnnotationsMain;
import ru.gb.lesson2.anno.lib.ObjectCreator;

import java.nio.channels.Pipe;
import java.util.Date;

public class Homework {

  /**
   * В существующий класс ObjectCreator добавить поддержку аннотации RandomDate (по аналогии с Random):
   * 1. Аннотация должна обрабатываться только над полями типа java.util.Date
   * 2. Проверить, что min < max
   * 3. В поле, помеченной аннотацией, нужно вставлять рандомную дату,
   * UNIX-время которой находится в диапазоне [min, max)
   *
   * 4. *** Добавить поддержку для типов Instant, ...
   * 5. *** Добавить атрибут Zone и поддержку для типов LocalDate, LocalDateTime
   */

  /**
   * Примечание:
   * Unix-время - количество милисекунд, прошедших с 1 января 1970 года по UTC-0.
   */



  public static void main(String[] args) {
//    long t = 1704067200000L;
    AnnotationsMain.Person rndPerson = ObjectCreator.createObj(AnnotationsMain.Person.class);

    System.out.println("date = " + rndPerson.getDate());

//    LocalDate.ofInstant(date.toInstant(), ZoneOffset.of("Moscow"))
  }





}


