package com.example.discovery.service;

import com.example.discovery.api.DiscoveredItem;
import com.example.discovery.api.DiscoveryService;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DiscoveryController implements DiscoveryService {
    @Override
    public List<DiscoveredItem> discover() {
        List<DiscoveredItem> discoveredItems = new ArrayList<>();

        // return some random value
        discoveredItems.add(new DiscoveredItem("id1", "Jason", "5000"));
        discoveredItems.add(new DiscoveredItem("id2", "Max", "500"));
        discoveredItems.add(new DiscoveredItem("id3", "Matt", "1000"));

        return discoveredItems;
    }
}
