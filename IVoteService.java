public interface IVoteService{
  public String configureNewQuestion(Question question);
  public void deleteQuestion(String questionId);
  public void submitAnswer(String questionId, Student student, char[] letter);
  public String displayResult(String questionId);
}
