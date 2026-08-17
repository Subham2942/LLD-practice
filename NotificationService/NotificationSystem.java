import java.util.*;

interface Notification {
    String getContent();
}

class SimpleNotification implements Notification {
    private String content;
    public SimpleNotification(String content) {
        this.content = "[SIMPLE]" + content;
    }

    @Override
    public String getContent() {
        return content;
    }
}

class EmailNotification implements Notification {
    private String content;
    public EmailNotification(String content) {
        this.content = "[EMAIL]" + content;
    }

    @Override
    public String getContent() {
        return content;
    }
}

// Decorator Design Pattern

abstract class NotificationDecorator implements Notification {
    protected Notification notification;
    public NotificationDecorator(Notification notification) {
        this.notification = notification;
    }
}

class TimeStampDecorator extends NotificationDecorator {
    public TimeStampDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public String getContent() {
        return "[2026-08-16 21:50:00] : " + notification.getContent();
    }
}


// Observable Design Pattern

interface Observer {
    void update();
}


interface Observable{

    void addObservers(Observer observer);

    void removeObservers(Observer observer);

    void notifyObservers();
}

class NotificationObservable implements Observable{
    private Notification notification = null;

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObservers(Observer Ob) {
        observers.add(Ob);
    }

    @Override
    public void removeObservers(Observer Ob) {
        observers.remove(Ob);
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
        notifyObservers();
    }

    public Notification getNotification() {
        return this.notification;
    }
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// Notification Service
// Singleton class

class NotificationService {
    private NotificationObservable observable;
    private static NotificationService instance = null;
    private List<Notification> notifs = new ArrayList<>();

    private NotificationService() {
        observable = new NotificationObservable();
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public NotificationObservable getObservable() {
        return observable;
    }

    public void sendNotification(Notification notification) {
        notifs.add(notification);
        observable.setNotification(notification);
    }
}

// CONCRETE OBSERVER


class Logger implements Observer {

    private NotificationObservable observable;
    public Logger() {
        this.observable = NotificationService.getInstance().getObservable();
        observable.addObservers(this);
    }

    public void update() {
        String content = observable.getNotification().getContent();
        System.out.println("LOGGING: " + content);
    }
}

interface NotificationStrategy {
    void sendNotification(String content);
}

class EmailStrategy implements NotificationStrategy {
    private String Email;
    public EmailStrategy(String Email) {
        this.Email = Email;
    }
    @Override
    public void sendNotification(String content) {
        System.out.println("Sending Notification to " + Email + ": \n" + content);
    }
}

class SMSStrategy implements NotificationStrategy {
    private String phoneNo;
    public SMSStrategy(String PhoneNo) {
        this.phoneNo = PhoneNo;
    }
    @Override
    public void sendNotification(String content) {
        System.out.println("Sending Notification to " + phoneNo + ": \n" + content);
    }
}

class NotificationEngine implements Observer {
    private NotificationObservable observable;
    List<NotificationStrategy> strategies = new ArrayList<>();
    public NotificationEngine() {
        this.observable = NotificationService.getInstance().getObservable();
        observable.addObservers(this);
    }

    public NotificationEngine(NotificationObservable observable) {
        this.observable = observable;
        observable.addObservers(this);
    }

    public void addNotificationStrategy(NotificationStrategy strategy) {
        strategies.add(strategy);
    }

    public void removeNotificationStrategy(NotificationStrategy strategy) {
        strategies.remove(strategy);
    }

    @Override
    public void update() {
        String notificationContent = observable.getNotification().getContent();
        for (NotificationStrategy strategy : strategies) {
            strategy.sendNotification(notificationContent );
        }
    }

}

public class NotificationSystem {



    public static void main(String[] args) {
        NotificationEngine engine = new NotificationEngine();
        NotificationService service = NotificationService.getInstance();
        Logger logger = new Logger();

        engine.addNotificationStrategy(new EmailStrategy("random.person@gmail.com"));
        engine.addNotificationStrategy(new SMSStrategy("+91 9876543210"));

        Notification N1 = new TimeStampDecorator(new SimpleNotification("New Video Just dropped !!"));
        Notification N2 = new TimeStampDecorator(new SimpleNotification("Somebody liked your post!!"));
        Notification N3 = new TimeStampDecorator(new SimpleNotification("Somebody replied to your comment"));
        Notification N4 = new TimeStampDecorator(new EmailNotification("Somebody replied to your EMAIL!!"));

        service.sendNotification(N1);
        service.sendNotification(N2);
        service.sendNotification(N3);
        service.sendNotification(N4);
    }
}