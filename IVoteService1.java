import java.util.*;
public class IVoteService1 implements IVoteService{
  Map<String, Question> questions;
  Map<String, Map<String, ArrayList<Character>>> studentRecords;
  Map<String, Map<Character, Integer>> answerRecords;

  public IVoteService1(){
    questions = new HashMap<>();
    studentRecords = new HashMap<>();
    answerRecords = new HashMap<>();
  }

  public String configureNewQuestion(Question question){
    String questionId = question.getQuestionId();
    questions.put(questionId, question);
    int choiceNum = question.getChoices().size();
    char c = 'a';
    Map<Character, Integer> records = new HashMap<>();
    Map<String, ArrayList<Character>> students = new HashMap<>();
    studentRecords.put(questionId, students);
    for(int i = 0;  i < choiceNum; i++ ){
      records.put(c, 0);
      c++;
    }
    answerRecords.put(questionId, records);
    return questionId;
  }

  public void deleteQuestion(String questionId){
    if(questions.containsKey(questionId)){
      questions.remove(questionId);
    }
    if(studentRecords.containsKey(questionId)){
      studentRecords.remove(questionId);
    }
    if(answerRecords.containsKey(questionId)){
      answerRecords.remove(questionId);
    }
  }

  public void submitAnswer(String questionId, Student student, char[] letter){
  
    if(studentRecords.get(questionId) != null && studentRecords.get(questionId).size()>0 && studentRecords.get(questionId).containsKey(student.toString())){
      ArrayList<Character> previousAnswer = studentRecords.get(questionId).get(student);
      for(int i = 0; i < previousAnswer.size(); i++){
      	answerRecords.get(questionId).put(previousAnswer.get(i), answerRecords.get(questionId).get(previousAnswer.get(i))-1);
      }

    }
    // String newAnswer = questions.get(questionId).getChoices().get(letter);
    ArrayList<Character> answers = new ArrayList<>();
    for(int i = 0; i < letter.length; i++){
    	answers.add(letter[i]);
    	answerRecords.get(questionId).put(letter[i], answerRecords.get(questionId).get(letter[i])+1);
    }
    studentRecords.get(questionId).put("Student testing", new ArrayList<Character>());
    studentRecords.get(questionId).put(student.toString(), answers);

  }

  public String displayResult(String questionId){
    Map records = answerRecords.get(questionId);
    Set<Character> keys = records.keySet();
    String result = "";
    for(char letter : keys){
      result += letter + ": " + records.get(letter) + "\n";
    }
    return result;
  }
}
