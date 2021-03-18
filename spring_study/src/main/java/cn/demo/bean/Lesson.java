package cn.demo.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lesson {

  private long id;
  private String name;
  private String teacher;
  private String location;
  private long startweek;
  private long endweek;
  private long day;
  private long time;
  private String mode;

}
