package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.DiscountService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DiscountServiceImpl implements DiscountService {


    public void setDiscountStrategies(ArrayList<String> discountStrategies) {
        this.discountStrategies = discountStrategies;
    }

    ArrayList<String> discountStrategies;


    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        if(365*2-user.getBirthDate().getDayOfYear()+airDateTime.getDayOfYear() <=5 ) return (byte) DiscountStrategy.calcDiscount("birthday");
        if(event.getAirDates().contains(airDateTime)) return (byte) DiscountStrategy.calcDiscount("eventOnHolidays");
        if(numberOfTickets == (long)10) return (byte) DiscountStrategy.calcDiscount("10tickets");
        return 0;
    }
}
