import javax.mail.*;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {
    private static final String PASSWORD = "your_password";
    private static final String EMAIL = "your_email@example.com";

    private static void sendReceipt(String recipientEmail, String messageBody) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.example.com"); //заменить на нужный хост или добавить еще хосты
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(PASSWORD, EMAIL);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(recipientEmail));
            message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse(recipientEmail));
            message.setSubject("Receipt");
            message.setText(messageBody);

            Transport.send(message);
            System.out.println("email sent successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        sendReceipt("recipient@example.com", "your recipient check here, thanks for subscription!");
    }
}


        /*EmailService emailService = new EmailService(EMAIL, PASSWORD);
        String subject = "Your subscription receipt";
    String content = "Thank you for you subscription!\n\nDetails:\n";
         */

        /*try {
           //тут будет стековерфлов Ты в методе вызываешь этот же метод Плюс он статический и не должен вызываться на объекте
        emailService.sendReceipt(recipientEmail, subject, content);//в методе 2 параметра, а тут 3
    } catch (Exception e) {
        System.err.println("Failed to send email: " + e.getMessage());
    }
}/*
/*private final String username;
    private final String password;

    public EmailService(String username, String password) {
        this.username = username;
        this.password = password;
    }
    class Message {
        public Message(Session session) {
        }
        private Authenticator authenticator;
        private final String EMAIL = "evil_eye91@mail.ru";
        private final String PASSWORD = "мой пароль";
*/
           /*
            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom("evil_eye91@mail.ru");
                message.setRecipients(MimeMessage.RecipientType.TO, "evil_eye91@mail.ru");
                message.setRecipients(MimeMessage.RecipientType.CC, "sasko@5485@gmail.com");
                message.setRecipients(MimeMessage.RecipientType.BCC, "sergey.egorov@pivotal.com");
                message.setSubject("send check");
                //transport не объявлен
                Transport.send(message);
                System.out.println("Receipt sent successfully!");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            */



