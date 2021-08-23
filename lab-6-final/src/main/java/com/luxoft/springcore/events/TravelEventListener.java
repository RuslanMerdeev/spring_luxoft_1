package com.luxoft.springcore.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TravelEventListener {

    @EventListener
    public void arrivalToDestination(TravelEvent travelEvent) {
        System.out.println(travelEvent.getPerson().getName() + " has arrived to " + travelEvent.getTravellingDestination());
    }

}
