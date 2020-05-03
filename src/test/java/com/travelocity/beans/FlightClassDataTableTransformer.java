package com.travelocity.beans;

import java.util.Locale;
import java.util.Map;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

public class FlightClassDataTableTransformer implements TypeRegistryConfigurer {
    
    public Locale locale() {
        return Locale.ENGLISH;
    }
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(Flight.class,
                       new TableEntryTransformer<Flight>() {
                    
            @Override
            
            public Flight transform(Map<String, String> row) throws Throwable{
                          
                            String departureTime = row.get("departureTime");
                            String arrivalTime = row.get("arrivalTime");
                            String airline = row.get("airline");
                            String rating = row.get("rating");
                            String duration = row.get("duration");
                            String numberOfStops = row.get("numberOfStops");
                            String fromAirport = row.get("fromAirport");
                            String toAirport = row.get("toAirport");
                            String price = row.get("price");
                            String typeOfTrip = row.get("typeOfTrip");
                            return new Flight(departureTime, arrivalTime, airline, rating, duration, numberOfStops, fromAirport, toAirport, price, typeOfTrip);
                        }
                    }));
    }
}