package com.jiakun.fresh.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;
import java.util.Set;

/**
 * Created by jiakun on 17-5-5.
 */

@JacksonXmlRootElement(localName = "ArrayOfMarkupParameter")
public class MarkupRequest {
    @JacksonXmlProperty(localName = "MarkupParameter")
    private MarkupParameter markupParameter;

    public MarkupParameter getMarkupParameter() {
        return markupParameter;
    }

    public void setMarkupParameter(MarkupParameter markupParameter) {
        this.markupParameter = markupParameter;
    }

    public class MarkupParameter {

        //标识
        @JacksonXmlProperty(localName = "Id")
        private int id;
        @JacksonXmlProperty(localName = "FareType")
        private FareType fareType;
        @JacksonXmlProperty(localName = "TripType")
        private TripType tripType;
        // 航空公司,例如 CZ
        @JacksonXmlProperty(localName = "Airline")
        private String airline;
        //起飞时间
        @JacksonXmlProperty(localName = "DepartureDateTime")
        private String departureDateTime;

        //出发地(机场代码)
        @JacksonXmlProperty(localName = "DepartureAirport")
        private String departureAirport;

        //目的地(机场代码)
        // @JacksonXmlElementWrapper(localName = "Destinations")
        // @JacksonXmlProperty(localName = "string")
        @JacksonXmlProperty(localName = "Destinations")
        private List<String> destinations;
        //所有航段不重复的舱位,例如 Q, Z
        @JacksonXmlElementWrapper(localName = "BookingClasses")
        @JacksonXmlProperty(localName = "string")
        private Set<String> bookingClasses;
        //所有航段不重复的票价基础
        @JacksonXmlProperty(localName = "FareBasises")
        private Set<String> fareBasises;

        //所有航段不重复的航班号,如 CZ338,CZ3061
        @JacksonXmlProperty(localName = "FlightNumbers")
        private Set<String> flightNumbers;
        //所有航段不重复的航空公司
        @JacksonXmlProperty(localName = "MarketAirlines")
        private Set<String> marketAirlines;
        // 所有航段的共享航空公司
        @JacksonXmlProperty(localName = "OperatorAirlines")
        private Set<String> operatorAirlines;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public FareType getFareType() {
            return fareType;
        }

        public void setFareType(FareType fareType) {
            this.fareType = fareType;
        }

        public TripType getTripType() {
            return tripType;
        }

        public void setTripType(TripType tripType) {
            this.tripType = tripType;
        }

        public String getAirline() {
            return airline;
        }

        public void setAirline(String airline) {
            this.airline = airline;
        }

        public String getDepartureDateTime() {
            return departureDateTime;
        }

        public void setDepartureDateTime(String departureDateTime) {
            this.departureDateTime = departureDateTime;
        }

        public String getDepartureAirport() {
            return departureAirport;
        }

        public void setDepartureAirport(String departureAirport) {
            this.departureAirport = departureAirport;
        }

        public List<String> getDestinations() {
            return destinations;
        }

        public void setDestinations(List<String> destinations) {
            this.destinations = destinations;
        }

        public Set<String> getBookingClasses() {
            return bookingClasses;
        }

        public void setBookingClasses(Set<String> bookingClasses) {
            this.bookingClasses = bookingClasses;
        }

        public Set<String> getFareBasises() {
            return fareBasises;
        }

        public void setFareBasises(Set<String> fareBasises) {
            this.fareBasises = fareBasises;
        }

        public Set<String> getFlightNumbers() {
            return flightNumbers;
        }

        public void setFlightNumbers(Set<String> flightNumbers) {
            this.flightNumbers = flightNumbers;
        }

        public Set<String> getMarketAirlines() {
            return marketAirlines;
        }

        public void setMarketAirlines(Set<String> marketAirlines) {
            this.marketAirlines = marketAirlines;
        }

        public Set<String> getOperatorAirlines() {
            return operatorAirlines;
        }

        public void setOperatorAirlines(Set<String> operatorAirlines) {
            this.operatorAirlines = operatorAirlines;
        }
    }

    public enum TripType {
        Oneway("Oneway"),
        Roundtrip("Roundtrip");
        private String desc;

        TripType(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }

    public enum FareType {
        PublishedFare("PublishedFare"),
        ConsoleFare("ConsoleFare");
        private String desc;

        FareType(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }
}
