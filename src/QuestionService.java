import javax.print.attribute.Size2DSyntax;
import java.util.Scanner;

public class QuestionService {

    Question[] questions = new Question[5];
    String selection[] = new String[5];
    char select;
    String uname;
    String pass;
    int score=0;
    public QuestionService()
    {
        questions[0] = new Question(1, "size of int", "2", "6", "4", "8", "4");
        questions[1] = new Question(2, "size of double", "2", "6", "4", "8", "8");
        questions[2] = new Question(3, "size of char", "2", "6", "4", "8", "2");
        questions[3] = new Question(4, "size of long", "2", "6", "4", "8", "8");
        questions[4] = new Question(5, "size of boolean", "1", "2", "4", "8", "1");


    }

    public void displayQuestions()
    {
        for(Question question : questions) {
            System.out.println(question.toString());
        }

    }
    public void start(){
        System.out.println("Welcome to Quize App");
        System.out.println("select login mode : ");
        System.out.print("1. user ");
        System.out.println("2. admin");
        try{
        Scanner scan = new Scanner(System.in);
        int mode=scan.nextInt();
        if(mode==1){
          Usermanagment();
        }else if(mode==2){
            System.out.println("admin mode");
            System.exit(0);
            }else{
            System.out.println("invalid input ! try again");
            start();
        }
        }catch(Exception e){
            System.out.println("please enter number value :");
        }
        start();
    }
    public void Usermanagment() {
        System.out.println("enter user name :");
        Scanner scan = new Scanner(System.in);
        uname = scan.next();
        System.out.println("enter password :");
        pass = scan.next();
        verify();
    }

    public void verify(){
        if(uname.equalsIgnoreCase("Shahzad") && pass.equals("12345")){
            playQuiz();
        }else {
            System.out.println("invalid credentials try again");
            Usermanagment();
        }
        }
    public void playQuiz() {
        int i = 0;
        for (Question q : questions) {
            System.out.print("Question " + (i + 1) + " : ");
            System.out.println(q.getQuestion());
            System.out.println(q.getOpt1());
            System.out.println(q.getOpt2());
            System.out.println(q.getOpt3());
            System.out.println(q.getOpt4());

            System.out.println("skip the question: y/n");
            Scanner sc2 = new Scanner(System.in);
            String str2 = sc2.nextLine();
            if (str2.equals("y")) {
                i++;
            } else if (str2.equals("n")) {
                System.out.println("type the right answer:");
                Scanner sc = new Scanner(System.in);
                selection[i] = sc.nextLine().trim();
                String answer = q.getAnswer();
                String selAnswer = selection[i];
                i++;

                if (answer.equals(selAnswer)) {
                    score++;
                } else {
                    score--;
                }
                System.out.println("live score is " + score);
            }else{
                System.out.println("invalid input! try again");
                playQuiz();
            }
        }
        PlayAgain();
    }
    public void PlayAgain(){
        System.out.println("want to play again: y/n");
        Scanner sc1 = new Scanner(System.in);
        String str= sc1.nextLine();
        if(str.equalsIgnoreCase("y")){
            playQuiz();
        } else if (str.equalsIgnoreCase("n")) {
            System.out.println("thanks for playing !!!");
            printScore();
            System.exit(0);
        } else {
            System.out.println("invalid Input! try again");
            PlayAgain();
        }
    }

    public void printScore(){

        System.out.println("final result : " + score);
    }
}