package com.example.hateoas_backend.services;

import com.example.hateoas_backend.domain.Capability;
import com.example.hateoas_backend.exceptions.CapabilityException;
import com.example.hateoas_backend.repositories.CapabilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapabilityService {

    private CapabilityRepository capabilityRepository;

    public CapabilityService(CapabilityRepository capabilityRepository) {
        this.capabilityRepository = capabilityRepository;
    }

    public List<Capability> getAllCapabilities() {
        return capabilityRepository.findAll();
    }

    public Capability findCapabilityById(Long id) {
        return capabilityRepository.findById(id).orElseThrow(() -> new CapabilityException("Capability with ID: " + id + " Not Found"));
    }
}
