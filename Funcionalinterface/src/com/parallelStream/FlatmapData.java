package com.parallelStream;

import java.util.List;

public class FlatmapData {
    private String Name;
    private List<String> Locations;

    public FlatmapData(String name, List<String> locations) {
        Name = name;
        Locations = locations;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<String> getLocations() {
        return Locations;
    }

    public void setLocations(List<String> locations) {
        Locations = locations;
    }
}
