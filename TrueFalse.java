import java.util.*;
public class TrueFalse implements Question{
  String question;
  String id;
  List<String> choices;
  public TrueFalse(){
    question = null;
    id = UUID.randomUUID().toString();
    choices = new ArrayList<>();
    choices.add("true");
    choices.add("false");
  }

  public void setQuestion(String str){
    question = str;
  }

  public String displayQuestion(){
    return question;
  }

  public String displayChoices(){
    return "a) true\nb) false\n";
  }

  public String getQuestionId(){
    return id;
  }

  public List<String> getChoices(){
    return choices;
  }

  public void addChoice(String str){
    
  }

  public int getChoiceLimit(){
    return choices.size();
  }
}
