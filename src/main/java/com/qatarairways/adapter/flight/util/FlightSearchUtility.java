package com.qatarairways.adapter.flight.util;

import com.qatarairways.adapter.flight.FlightAvailabilityRequest;
import com.qatarairways.adapter.flight.FlightSummary;
import com.qatarairways.flights.FlightDetails;

import java.util.List;

/**
 * Provides utility functions for flight search activities.
 */
public interface FlightSearchUtility {

    public List<FlightDetails> loadFlights();

    public List<FlightSummary> searchFlights(FlightAvailabilityRequest request);
}
