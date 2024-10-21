import javax.mail.internet.MimeMessage;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
public class EmailService {
    private static String PASSWORD;
    private static String EMAIL;
    private static void sendReceipt(String recipientEmail, String subscriptionDetails) {
        EmailService emailService = new EmailService(EMAIL, PASSWORD);
        String subject = "Your subscription receipt";
    String content = "Thank you for you subscription!\n\nDetails:\n";

        try {
        emailService.sendReceipt(recipientEmail, subject, content);
    } catch (Exception e) {
        System.err.println("Failed to send email: " + e.getMessage());
    }
}
private final String username;
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

        public void sendReceipt(String email, String subject, String receiptContent) {
            //установка свойств подключения к почтовому серверу
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.yandex.ru");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            try {
                Message message = new MimeMessage(session);
                message.setFrom("evil_eye91@mail.ru");
                message.setRecipients(Message.RecipientType.TO, "evil_eye91@mail.ru");
                message.setRecipients(Message.RecipientType.CC, "sasko@5485@gmail.com");
                message.setRecipients(Message.RecipientType.BCC, "sergey.egorov@pivotal.com");
                message.setSubject("send check");

                transport.send(message);
                System.out.println("Receipt sent successfully!");
            } catch (MessagingException e) {
                e.printStackTrace();


            }
        }
    }
}
