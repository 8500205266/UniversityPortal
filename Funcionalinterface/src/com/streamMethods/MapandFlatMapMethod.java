package com.streamMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;


class Institute
{
    String name;

    List<String> locations;

    public Institute(String name, List<String> locations)
    {
        this.name = name;
        this.locations = locations;
    }

    public String getName()
    {
        return name;
    }

    public List<String> getLocations()
    {
        return locations;
    }
}

public class MapandFlatMapMethod
{
    public static void main(String[] args)
    {
        List<Institute> instituteList = new ArrayList<>();

        instituteList.add(new Institute("IIM", Arrays.asList("Bangalore", "Ahmedabad", "Kozhikode", "Lucknow")));
        instituteList.add(new Institute("IIT", Arrays.asList("Delhi", "Mumbai", "Kharagpur")));
        instituteList.add(new Institute("NIFT", Arrays.asList("Hyderabad", "Mumbai", "Patna", "Bangalore")));

        //map method
        final Stream<Object> names = instituteList.stream().map(new Function<Institute, Object>() {
            @Override
            public Object apply(Institute institute) {
                return institute.getName();
            }
        });
        names.forEach(s-> System.out.println(s));

        //FlatMap

        final Stream<Object> locations = instituteList.stream().flatMap(new Function<Institute, Stream<?>>() {
            @Override
            public Stream<?> apply(Institute institute) {
                return institute.getLocations().stream();
            }
        });
            locations.forEach(s-> System.out.println(s));
    }
}