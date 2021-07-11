package com.example.dashboard.service;

import com.example.discovery.api.DiscoveryService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "discoveryServiceClient", url = "${discovery.service.host}")
public interface DiscoveryServiceClient extends DiscoveryService {
}
