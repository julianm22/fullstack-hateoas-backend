package com.example.hateoas_backend.repositories;

import com.example.hateoas_backend.domain.Capability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapabilityRepository extends JpaRepository<Capability, Long> {
}
