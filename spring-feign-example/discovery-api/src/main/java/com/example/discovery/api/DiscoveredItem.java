package com.example.discovery.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
@Data
public class DiscoveredItem {
    private String id;
    private String name;
    private String score;
}
