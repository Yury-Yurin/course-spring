package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.service.EventService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by yury on 7/25/16.
 */
public class EventServiceImpl implements EventService {

    private Long countId = new Long(0);
    HashMap<Long,Event> events = new HashMap<>();

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        for(Long i=new Long(0); i<events.size(); i++) {
            Event event = events.get(i);
            if(event.getName().equals(name))
                return event;
        }
        return null;
    }

    @Override
    public Event save(@Nonnull Event object) {
        events.put(countId,object);
        countId ++;
        return null;
    }

    @Override
    public void remove(@Nonnull Event object) {
        for(Long i=new Long(0);i <events.size(); i++) {
            if(events.get(i).equals(object))
                events.remove(i);
        }
    }

    @Override
    public Event getById(@Nonnull Long id) {
        return events.get(id);
    }

    @Nonnull
    @Override
    public Collection<Event> getAll() {
        return events.values();
    }
}
