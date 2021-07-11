package com.example.discovery.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/discovery")
public interface DiscoveryService {

    @GetMapping
    List<DiscoveredItem> discover();

}
