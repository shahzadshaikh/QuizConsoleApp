import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Scanner;

class InvalidException extends Exception
{
    public InvalidException(String msg)
    {
        super(msg);
    }
}
public class Login extends QuestionService {
    String uname;
    String pass;

    int mode;

    public void initiate() {
        System.out.println("Welcome to Quize App");
        System.out.println("select login mode : ");
        System.out.print("1. user ");
        System.out.println("2. admin");
        Scanner scan = new Scanner(System.in);
        mode = scan.nextInt();
    }

    public void modeverify(){
        if(mode==2){
            System.out.println("UNDER CONSTRUCTION!!");
            System.exit(0);
        }
    }
    public void input() {
        System.out.println("enter user name :");
        Scanner scan = new Scanner(System.in);
        uname = scan.next();
        System.out.println("enter password :");
        pass = scan.next();
    }

    public void verify() throws InvalidException {
        if (uname.equalsIgnoreCase("Shahzad") && pass.equals("12345")) {
            playQuiz();
        } else {
            InvalidException iv = new InvalidException("invalid credentials !! try again");
            System.out.println(iv.getMessage());
            throw iv;
            //System.out.println("invalid credentials try again");
            //input();
        }
    }
}
    class App {
        public void initiate1() {
            Login login = new Login();
            login.initiate();
            login.modeverify();
            try {
                login.input();
                login.verify();
            } catch (InvalidException iv) {
                try {
                    login.input();
                    login.verify();
                } catch (InvalidException iv1) {
                    try {
                        login.input();
                        login.verify();
                    } catch (Exception e) {
                        System.out.println("You're BLOCKED");
                        System.exit(0);
                    }
                }
            }
        }
    }
