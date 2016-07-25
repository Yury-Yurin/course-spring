package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.service.AuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yury on 7/25/16.
 */
public class AuditoriumServiceImpl implements AuditoriumService {

    public Set<Auditorium> auditoriums = new HashSet<>();

    @Nonnull
    @Override
    public Set<Auditorium> getAll() {
        return auditoriums;
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        Auditorium[] au = (Auditorium[]) auditoriums.toArray();
        for(int i=0; i < au.length; i++)
            if(au[i].getName().equals(name))
                return au[i];
        return null;
    }
}
