import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.format.datetime.DateFormatter;
import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class App {
    private static DiscountService discountService;
    private static UserService userService;
    private static EventService eventService;
    private static BookingService bookingService;
    private static AuditoriumService auditoriumService;
    public static void main(String[] args) throws IOException {
        initServices();
        System.out.println("Menu:\n1. Registration\n2. Book ticket\n3. Show events.\n4. Exit\n");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        switch (id) {
            case 1:
                registration();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                return;
            default:
                return;
        }
    }

    private static void registration() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your first name:");
        String firstName = scanner.nextLine();
        System.out.println("Your last name:");
        String lastName = scanner.nextLine();
        System.out.println("Your birth date:");
        String birthDate = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        User user = new User(firstName,lastName,email);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        user.setBirthDate(LocalDateTime.of(LocalDate.parse(birthDate,formatter),LocalTime.MAX));
        userService.save(user);
    }

    public static void initServices() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("/src/main/resources/spring-context.xml");
        discountService = (DiscountService) ctx.getBean("discountService");
        userService = (UserService) ctx.getBean("userService");
        eventService = (EventService) ctx.getBean("eventService");
       // bookingService = (BookingService) ctx.getBean("bookingService");
        //auditoriumService = (AuditoriumService) ctx.getBean("bookingService");
    }
}
