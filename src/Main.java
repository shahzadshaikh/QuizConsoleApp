public class Main {
    public static void main(String[] args) {

        // create a quiz (5 question)
        // create 5 questions from user
        // QuestionService : create, get, delete,
        // Array - String

        //Changes done
        // Roles Done
        // Negative marking Done
        // realtime score Done
        // play again (different question) Done
        // skip question Done
        // set timer


        QuestionService service = new QuestionService();
        //service.displayQuestions();
        //service.playQuiz();
        service.start();
        service.printScore();



    }
}