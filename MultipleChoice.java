import java.util.*;
public class MultipleChoice implements Question{
  private String question;
  private List<String> choices;
  private String id;


  public MultipleChoice(){
    question = null;
    id = UUID.randomUUID().toString();
    choices = new ArrayList<String>();
  }

  public void setQuestion(String str){
    question = str;
  }

  public String displayQuestion(){
    return question;
  }

  public String displayChoices(){
    String answers = "";
    char letter = 'a';
    for(String choice : choices){
      answers += Character.toString(Character.toUpperCase(letter)) + ") " + choice + "\n";
      letter ++;
    }
    return answers;
  }

  public String getQuestionId(){
    return id;
  }

  public List<String> getChoices(){
    return choices;
  }

  public void addChoice(String str){
    choices.add(str);
  }

  public int getChoiceLimit(){
    return choices.size();
  }
}
