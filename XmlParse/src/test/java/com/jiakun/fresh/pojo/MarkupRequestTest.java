package com.jiakun.fresh.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

/**
 * Created by jiakun on 17-5-5.
 */
public class MarkupRequestTest {
    @Test
    public void produceXmlFromPojo() {
        MarkupRequest markupRequest = new MarkupRequest();
        MarkupRequest.MarkupParameter markupParameter = markupRequest.new MarkupParameter();
        markupParameter.setId(1);
        markupParameter.setFareType(MarkupRequest.FareType.PublishedFare);
        markupParameter.setTripType(MarkupRequest.TripType.Oneway);
        markupParameter.setAirline("CZ");
        markupParameter.setDepartureDateTime("2015-10-22T02:25:00.1189703+08:00");
        markupParameter.setDepartureAirport("PUS");
        markupParameter.setDestinations(Lists.newArrayList("CAN"));
        markupParameter.setBookingClasses(Sets.newHashSet("Q", "Z"));
        markupParameter.setFareBasises(Sets.newHashSet("NP2Q10", "NP2Q20"));
        markupParameter.setFlightNumbers(Sets.newHashSet("CZ338", "CZ3061"));
        markupParameter.setMarketAirlines(Sets.newHashSet("CZ"));
        markupParameter.setMarketAirlines(Sets.newHashSet("FM"));
        markupRequest.setMarkupParameter(markupParameter);

        XmlMapper xmlMapper = new XmlMapper();
        //添加XML 的header
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        try {
            final String s = xmlMapper.writeValueAsString(markupRequest);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}