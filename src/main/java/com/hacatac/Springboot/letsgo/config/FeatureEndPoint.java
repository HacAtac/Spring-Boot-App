package com.hacatac.Springboot.letsgo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
This file is used so that we can add extra endpoints to the actuator endpoint.
Basically what we've done below is this:

1: We've made a class named FeatureEndPoint
2: Created a Map and constructor to make new features inside of the map
3:
 */

@Component
@Endpoint(id = "features")
public class FeatureEndPoint {

    private final Map<String, Feature> featureMap =
            new ConcurrentHashMap<>();

    public FeatureEndPoint(){
        featureMap.put("Department", new Feature(true));
        featureMap.put("User", new Feature(false));
        featureMap.put("Authentication", new Feature(false));
    }

    @ReadOperation
    public Map<String, Feature> features() {
        return featureMap;
    }

    @ReadOperation
    public Feature feature(@Selector String featureName) {
        return featureMap.get(featureName);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature {
        private boolean isEnabled;
    }

}
