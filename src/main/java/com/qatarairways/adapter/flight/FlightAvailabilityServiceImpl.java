package com.qatarairways.adapter.flight;

import com.qatarairways.adapter.flight.util.FlightSearchUtility;
import com.qatarairways.adapter.flight.util.FlightSearchUtilityImpl;

import java.util.Collection;
import java.util.List;

/**
 * Provides implementation for FlightAvailabilityService interface to search flights based on the request.
 */
public class FlightAvailabilityServiceImpl implements FlightAvailabilityService{
    @Override
    public Collection<FlightSummary> getAvailableFlights(FlightAvailabilityRequest request) {
        FlightSearchUtility searchUtility = new FlightSearchUtilityImpl();
        List<FlightSummary> flightSummaryList =  searchUtility.searchFlights(request);

        return flightSummaryList;
    }
}
