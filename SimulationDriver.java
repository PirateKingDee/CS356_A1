import java.util.*;
public class SimulationDriver{
  public static char[] randomAnswer(Question q){
  	Random rand = new Random();
  	int choiceLimit = rand.nextInt(q.getChoiceLimit())+1;
  	char[] choices = new char[choiceLimit];
  	int numChoice = q.getChoices().size();
  	Set<Character> choiceSet = new HashSet<Character>();
  	for(int i = 0; i < choices.length; i++){
  		char possibleChoice = numToChar(rand.nextInt(numChoice));
  		while(choiceSet.contains(possibleChoice)){
  			possibleChoice = numToChar(rand.nextInt(numChoice));
  		}
  		choices[i] = possibleChoice;
  		choiceSet.add(possibleChoice);
  	}
    return choices;
  }

  public static char numToChar(int num){
    return (char)(num+97);
  }

  public static Student[] createStudents(int amount){
  	Student[] students = new Student[amount];
  	for(int i = 0; i < amount; i++){
  		students[i] = new Student();
  	}
  	return students;
  }

  public static void simulateStudentSubmitAnswers(IVoteService service, Question question, Student[] students){
  	System.out.println(question.displayQuestion());
  	System.out.println(question.displayChoices());
  	for(int i = 0; i < students.length; i++){
  		char[] madeChoices = randomAnswer(question);
  		System.out.println("student"+i+": "+Arrays.toString(madeChoices));
      service.submitAnswer(question.getQuestionId(), students[i], madeChoices);
    }
  }

  public static void main(String[] args){
  	//create 30 student for testing
    final int MAX_STUDENT = 30;
    Student[] students = createStudents(MAX_STUDENT);

    //Create three different type of questions
    Question multipleQ = new MultipleChoice();
    Question trueFalseQ = new TrueFalse();
    Question singleQ = new SingleChoice();

    IVoteService iVote = new IVoteService1();

    //Simulate User to create questions
    multipleQ.setQuestion("What is/are your favorite color");
    multipleQ.addChoice("red");
    multipleQ.addChoice("green");
    multipleQ.addChoice("yellow");

    trueFalseQ.setQuestion("Is today a good day?");

    singleQ.setQuestion("What is today's day");
    singleQ.addChoice("Monday");
    singleQ.addChoice("Tuesday");
    singleQ.addChoice("Wednesday");
    singleQ.addChoice("Thursday");
    singleQ.addChoice("Friday");

    //configure questions to ivote service
    iVote.configureNewQuestion(multipleQ);
    iVote.configureNewQuestion(trueFalseQ);
    iVote.configureNewQuestion(singleQ);

    simulateStudentSubmitAnswers(iVote, multipleQ, students);
    System.out.println("Result: \n"+iVote.displayResult(multipleQ.getQuestionId()));

    simulateStudentSubmitAnswers(iVote, trueFalseQ, students);
    System.out.println("Result: \n"+iVote.displayResult(trueFalseQ.getQuestionId()));

    simulateStudentSubmitAnswers(iVote, singleQ, students);
    System.out.println("Result: \n"+iVote.displayResult(singleQ.getQuestionId()));  
    
  }
}
