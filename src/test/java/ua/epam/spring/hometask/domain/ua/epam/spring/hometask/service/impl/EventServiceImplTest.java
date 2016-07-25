package ua.epam.spring.hometask.domain.ua.epam.spring.hometask.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.EventRating;
import ua.epam.spring.hometask.service.EventService;

import java.io.IOException;

/**
 * Created by yury on 7/25/16.
 */
public class EventServiceImplTest {
    @Before
    public void init() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("/src/main/resources/spring-context.xml");
        eventService = (EventService) ctx.getBean("eventService");
    }

    EventService eventService;

    @Test
    public void saveEventTest() {
        Event event = new Event("Book",345.5, EventRating.HIGH);
        eventService.save(event);
        Assert.assertTrue(eventService.getAll().size()==1);
    }

   @Test
    public void removeEventTest() {
       Event event = new Event("Book",345.5,EventRating.HIGH);
       eventService.save(event);
       Assert.assertTrue(eventService.getAll().size()==1);
       eventService.remove(event);
       Assert.assertTrue(eventService.getAll().size()==0);
    }
     @Test
    public void getEventByIdTest() {
        Event event1 = new Event("Book",345.5,EventRating.HIGH);
        Event event2 = new Event("Reservation",350.75,EventRating.HIGH);
        eventService.save(event1);
         eventService.save(event2);
        Event newEvent = eventService.getById((long)1);
        Assert.assertEquals(event2,newEvent);
    }

    @Test
    public void getUserByEmailTest() throws IOException {
        Event event1 = new Event("Book",345.5,EventRating.HIGH);
        Event event2 = new Event("Reservation",350.75,EventRating.HIGH);
        eventService.save(event1);
        eventService.save(event2);
        Event newEvent = eventService.getByName("Reservation");
        Assert.assertEquals(event2,newEvent);
    }

}
