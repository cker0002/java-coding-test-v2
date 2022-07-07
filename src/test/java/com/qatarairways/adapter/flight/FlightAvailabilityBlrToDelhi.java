package com.qatarairways.adapter.flight;

import com.qatarairways.adapter.flight.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
/**
 * Test class to test different functions on the result by mocking the required service.
 */
public class FlightAvailabilityBlrToDelhi {
@Mock
 FlightAvailabilityService flightAvailabilityService;

    @BeforeEach
     void init()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void flightAvailabilityBlrToDelhiTest() {
        DateUtility dateUtility = new DateUtilityImpl();
        FlightAvailabilityRequest request = new FlightAvailabilityRequest(Origin.BLR.name(),Destination.DELHI.name(),dateUtility.getDateTime(2022,07,02,10,30,5),10);
        when(flightAvailabilityService.getAvailableFlights(request)).
                thenReturn(List.of(FlightSummary.builder().airlineCode(Airline.AIRINDIA.name())
                        .arrivalTime(dateUtility.getDateTime(2022,07,02,9,30,5))
                        .departureTime(dateUtility.getDateTime(2022,07,02,10,30,5))
                        .averagePriceInUsd(200).cancellationPossible(true).build(),

                        FlightSummary.builder().airlineCode(Airline.INDIGO.name())
                                .arrivalTime(dateUtility.getDateTime(2022,07,02,9,15,5))
                                .departureTime(dateUtility.getDateTime(2022,07,02,10,30,5))
                                .averagePriceInUsd(500).cancellationPossible(false).build(),

                        FlightSummary.builder().airlineCode(Airline.JETAIRWAYS.name())
                                .arrivalTime(dateUtility.getDateTime(2022,07,02,9,45,5))
                                .departureTime(dateUtility.getDateTime(2022,07,02,10,30,5))
                                .averagePriceInUsd(600).cancellationPossible(false).build()));

        Collection<FlightSummary> summary = flightAvailabilityService.getAvailableFlights(request);
        assertThat(summary.isEmpty()).isFalse();
        assertThat(summary.stream().findFirst().get().getAirlineCode().
                equalsIgnoreCase(Airline.AIRINDIA.name())).isTrue();
        assertThat(summary.stream().findFirst().get().getAveragePriceInUsd() == 200).isTrue();
        assertThat(summary.stream().findFirst().get().isCancellationPossible() == true);


        List<FlightSummary> isCancellationPossibleList = summary.stream().filter(s -> s.isCancellationPossible() == Boolean.TRUE).collect(Collectors.toList());
        assertThat(isCancellationPossibleList.isEmpty()).isFalse();
        List<FlightSummary> isCancellationNotPossibleList = summary.stream().filter(s -> s.isCancellationPossible() == Boolean.FALSE).collect(Collectors.toList());
        assertThat(isCancellationNotPossibleList.isEmpty()).isFalse();

        List<FlightSummary> isCancellationPossibleOrNotList = summary.stream().
                filter(s -> s.isCancellationPossible() == Boolean.TRUE || s.isCancellationPossible() == Boolean.FALSE).collect(Collectors.toList());
        assertThat(isCancellationPossibleOrNotList.isEmpty()).isFalse();


        List<FlightSummary> avgPriceSortedAsc = summary.stream().sorted(Comparator.comparing(FlightSummary::getAveragePriceInUsd)).collect(Collectors.toList());
        assertThat(avgPriceSortedAsc.isEmpty()).isFalse();
        assertThat(avgPriceSortedAsc.stream().findFirst().get().getAveragePriceInUsd() == 200).isTrue();

        List<FlightSummary> avgPriceSortedDsc = summary.stream().sorted(Comparator.comparing(FlightSummary::getAveragePriceInUsd).reversed()).collect(Collectors.toList());
        assertThat(avgPriceSortedDsc.isEmpty()).isFalse();
        assertThat(avgPriceSortedDsc.stream().findFirst().get().getAveragePriceInUsd() == 600).isTrue();


    }
}
