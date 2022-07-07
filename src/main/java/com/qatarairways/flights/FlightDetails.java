package com.qatarairways.flights;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
public class FlightDetails {
    private final int noOfSeats;
    private final String origin;
    private final String destination;
    private final Date arrivalTime;
    private final Date departureTime;
    private final String airLineCode;
}
