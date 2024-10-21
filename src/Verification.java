import java.util.Scanner;

public class Verification {
    public static void main(String[] args) {

        boolean isSmsCodeRecieved = false;

       Scanner scanner = new Scanner(System.in);
       String correctPhoneNumber = "+7 *** *** ** **";
       String correctSmsCode = "****";

       String inputPhoneNumber;
       String inputSmsCode;

       while (true)  {
           inputPhoneNumber = scanner.nextLine();
           System.out.println("Enter phoneNumber");

           inputSmsCode = scanner.nextLine();
           System.out.println("Enter SMS code");

           if (inputPhoneNumber.equals(correctPhoneNumber) && inputSmsCode.equals(correctSmsCode)) {
               System.out.println("Welcome to Application");
               break;
               } else {
               System.out.println("Login error, check the correctness of entering the phone number or the code from the SMS message");
           }

       }
// проверить условия смс-кода через boolean
       if (!isSmsCodeRecieved) {
           System.out.println("i didn't recieve code, send it again");
           sendSmsCode();
       }
       if (isSmsCodeRecieved) {
           System.out.println("Welcome to Application");
       }


    }
    private static void sendSmsCode() {
        System.out.println("Sms-code was send again");
    }

}
