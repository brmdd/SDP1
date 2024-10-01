import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main Application
public class CinemaManagementApp {
    private static List<Movie> movies = new ArrayList<>();
    private static List<MovieSchedule> schedules = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Cinema Management System ---");
            System.out.println("1. Add Movie");
            System.out.println("2. Book Ticket");
            System.out.println("3. View Movie Schedules");
            System.out.println("4. Update Cinema Configuration");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addMovie(scanner);
                    break;
                case 2:
                    bookTicket(scanner);
                    break;
                case 3:
                    viewSchedules();
                    break;
                case 4:
                    updateCinemaConfig(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addMovie(Scanner scanner) {
        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();
        System.out.print("Enter movie type (Regular/IMAX): ");
        String type = scanner.nextLine();

        MovieFactory factory;
        if ("IMAX".equalsIgnoreCase(type)) {
            factory = new IMAXMovieFactory();
        } else {
            factory = new RegularMovieFactory();
        }
        Movie movie = factory.createMovie(title);
        movies.add(movie);
        System.out.println("Movie added: " + movie.getTitle() + ", Type: " + movie.getType());
    }

    private static void bookTicket(Scanner scanner) {
        System.out.print("Enter movie title to book: ");
        String title = scanner.nextLine();
        Movie selectedMovie = null;

        // Find the movie from the list
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                selectedMovie = movie;
                break;
            }
        }

        if (selectedMovie == null) {
            System.out.println("Movie not found!");
            return;
        }

        System.out.print("Enter seat number: ");
        String seatNumber = scanner.nextLine();
        System.out.print("Enter snack combo: ");
        String snackCombo = scanner.nextLine();

        TicketBooking booking = new TicketBooking.TicketBookingBuilder()
                .setMovieTitle(selectedMovie.getTitle())
                .setSeatNumber(seatNumber)
                .setSnackCombo(snackCombo)
                .build();

        System.out.println("Booking confirmed for: " + booking.getMovieTitle() + " in seat " + booking.getSeatNumber() + ", Snacks: " + booking.getSnackCombo());

        // Create a movie schedule
        MovieSchedule schedule = new StandardSchedule();
        schedule.setMovie(selectedMovie);
        System.out.print("Enter schedule time: ");
        String scheduleTime = scanner.nextLine();
        schedule.setTime(scheduleTime);
        schedules.add(schedule);
        System.out.println("Scheduled Movie: " + schedule.getMovie().getTitle() + " at " + schedule.getTime());
    }

    private static void viewSchedules() {
        System.out.println("\n--- Movie Schedules ---");
        for (MovieSchedule schedule : schedules) {
            System.out.println("Movie: " + schedule.getMovie().getTitle() + " at " + schedule.getTime());
        }
    }

    private static void updateCinemaConfig(Scanner scanner) {
        CinemaConfig config = CinemaConfig.getInstance();
        System.out.print("Enter new cinema name: ");
        String newName = scanner.nextLine();
        config.setCinemaName(newName);
        System.out.print("Enter number of screens: ");
        int numberOfScreens = scanner.nextInt();
        config.setNumberOfScreens(numberOfScreens);
        System.out.print("Enter operating hours: ");
        scanner.nextLine(); // Consume newline
        String hours = scanner.nextLine();
        config.setOperatingHours(hours);

        System.out.println("Cinema configuration updated.");
        System.out.println("Cinema Name: " + config.getCinemaName());
        System.out.println("Number of Screens: " + config.getNumberOfScreens());
        System.out.println("Operating Hours: " + config.getOperatingHours());
    }
}
