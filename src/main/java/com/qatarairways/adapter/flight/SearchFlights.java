package com.qatarairways.adapter.flight;

import com.qatarairways.adapter.flight.util.*;

import java.util.List;
import java.util.stream.Collectors;

public class SearchFlights {
    public static void main(String[] args) {

        DateUtility dateUtility = new DateUtilityImpl();
        FlightSearchUtility searchUtility = new FlightSearchUtilityImpl();
        FlightAvailabilityRequest request = new FlightAvailabilityRequest
                ("BLR", "DELHI", dateUtility.getDateTime
                        (2022, 07, 02, 10, 30, 5),
                        10);
        List<FlightSummary> flightSummaryList = searchUtility.searchFlights(request);

        List<FlightSummary> isCancellationPossibleList = flightSummaryList.stream().
                filter(s -> s.isCancellationPossible() == Boolean.TRUE).collect(Collectors.toList());
        System.out.println(isCancellationPossibleList);

        List<FlightSummary> isCancellationNotPossibleList = flightSummaryList.stream().
                filter(s -> s.isCancellationPossible() == Boolean.FALSE).collect(Collectors.toList());
        System.out.println(isCancellationNotPossibleList);

    }
}