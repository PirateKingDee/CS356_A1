import java.util.UUID;
public class Student{
  private String id;
  public Student(){
    id = UUID.randomUUID().toString();
  }
  public String toString(){
    return id;
  }
}
