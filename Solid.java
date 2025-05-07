import java.util.*;

// Interface Segregation + Liskov Substitution
interface Message {
    String getContent();
}

// Open/Closed Principle
class EmailMessage implements Message {
    private String content;

    public EmailMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return "Email: " + content;
    }
}

// Open/Closed Principle
class SMSMessage implements Message {
    private String content;

    public SMSMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return "SMS: " + content;
    }
}

// Single Responsibility Principle
class NotificationSender {
    public void send(Message message) {
        System.out.println("Sending -> " + message.getContent());
    }
}

// Single Responsibility Principle
class NotificationLogger {
    public void log(Message message) {
        System.out.println("Logged -> " + message.getContent());
    }
}

// Dependency Inversion Principle
public class Solid {
    public static void main(String[] args) {
        List<Message> messages = Arrays.asList(
            new EmailMessage("Welcome to our app!"),
            new SMSMessage("Your OTP is 123456")
        );

        NotificationSender sender = new NotificationSender();
        NotificationLogger logger = new NotificationLogger();

        for (Message msg : messages) {
            sender.send(msg);
            logger.log(msg);
        }
    }
}
