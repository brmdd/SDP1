package assignment4;

import assignment4.ChainOfResponsibilityPattern.Approver;
import assignment4.ChainOfResponsibilityPattern.Director;
import assignment4.ChainOfResponsibilityPattern.Manager;
import assignment4.ChainOfResponsibilityPattern.TeamLead;
import assignment4.CommandPattern.Light;
import assignment4.CommandPattern.LightOnCommand;
import assignment4.CommandPattern.RemoteControl;
import assignment4.IteratorPattern.Playlist;
import assignment4.IteratorPattern.Song;
import assignment4.MediatorPattern.ChatMediator;
import assignment4.MediatorPattern.ChatRoom;
import assignment4.MediatorPattern.RegularUser;
import assignment4.MediatorPattern.User;
import assignment4.MementoPattern.VersionControl;
import assignment4.ObserverPattern.CurrentConditionsDisplay;
import assignment4.ObserverPattern.WeatherStation;
import assignment4.StatePattern.Order;
import assignment4.StrategyPattern.CreditCardPayment;
import assignment4.StrategyPattern.ShoppingCart;
import assignment4.TemplateMethodPattern.PDFReportGenerator;
import assignment4.TemplateMethodPattern.ReportGenerator;
import assignment4.VisitorPattern.Shape;
import assignment4.VisitorPattern.AreaCalculator;
import assignment4.VisitorPattern.Circle;
import assignment4.VisitorPattern.Visitor;
import assignment4.VisitorPattern.Rectangle;
import assignment4.MementoPattern.Document;


public class Main {
    public static void main(String[] args) {
        // Strategy Pattern Example
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100);

        // Observer
        WeatherStation station = new WeatherStation();
        CurrentConditionsDisplay display = new CurrentConditionsDisplay();
        station.addObserver(display);
        station.setMeasurements(25.0f, 65.0f, 1013.0f);

        // Command
        Light livingRoomLight = new Light();
        LightOnCommand lightOn = new LightOnCommand(livingRoomLight);
        RemoteControl remote = new RemoteControl();
        remote.setCommand(lightOn);
        remote.pressButton();

        // State
        Order order = new Order();
        order.printStatus();
        order.nextState();
        order.printStatus();
        order.nextState();
        order.printStatus();

        // Chain
        Approver teamLead = new TeamLead();
        Approver manager = new Manager();
        Approver director = new Director();
        teamLead.setNextApprover(manager);
        manager.setNextApprover(director);
        teamLead.approveExpense(300);
        teamLead.approveExpense(2000);

        // Mediator
        ChatMediator chatMediator = new ChatRoom();
        User user1 = new RegularUser(chatMediator, "User1");
        User user2 = new RegularUser(chatMediator, "User2");
        chatMediator.addUser(user1);
        chatMediator.addUser(user2);
        user1.send("Hello from User1");

        // Memento
        Document doc = new Document();
        VersionControl vc = new VersionControl();
        doc.setContent("Version 1");
        vc.saveState(doc.save());
        doc.setContent("Version 2");
        doc.restore(vc.getSavedState());
        System.out.println("Restored Content: " + doc.getContent());

        // Visitor
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4,6 );
        Visitor areaCalculator = new AreaCalculator();
        circle.accept(areaCalculator);
        rectangle.accept(areaCalculator);

        // Template
        ReportGenerator pdfReport = new PDFReportGenerator();
        pdfReport.generateReport();

        // Iterator
        Playlist playlist = new Playlist();
        playlist.addSong(new Song("Song 1"));
        playlist.addSong(new Song("Song 2"));
        playlist.addSong(new Song("Song 3"));
        for (Song song : playlist) {
            System.out.println("Playing: " + song.getName());
        }
    }
}
