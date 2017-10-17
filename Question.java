import java.util.List;
public interface Question{
  public void setQuestion(String str);
  public String displayQuestion();
  public String displayChoices();
  public String getQuestionId();
  public int getChoiceLimit();
  public List<String> getChoices();
  public void addChoice(String str);
}
