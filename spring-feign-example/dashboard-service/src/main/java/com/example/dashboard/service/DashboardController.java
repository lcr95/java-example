package com.example.dashboard.service;

import com.example.discovery.api.DiscoveredItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DiscoveryServiceClient discoveryServiceClient;

    @GetMapping
    public Map<String, String> getDashboardDetails() {
        Map<String, String> details = new HashMap<>();

        List<DiscoveredItem> discoveredItems = discoveryServiceClient.discover();

        String topScore = discoveredItems.stream()
                .max(Comparator.comparing(DiscoveredItem::getScore))
                .get()
                .getScore();

        String ranking = discoveredItems.stream()
                .sorted(Comparator.comparing(DiscoveredItem::getScore))
                .map(DiscoveredItem::getName)
                .collect(Collectors.joining(","));

        details.put("topScore", topScore);
        details.put("ranking", ranking);
        return details;
    }

}
