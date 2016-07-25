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
        return 0;
    }
}
