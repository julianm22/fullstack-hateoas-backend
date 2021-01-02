package com.example.hateoas_backend.resources;

import com.example.hateoas_backend.domain.Capability;
import com.example.hateoas_backend.services.CapabilityService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@RestController
@RequestMapping("/dashboard")
@CrossOrigin
public class CapabilityController {

    private CapabilityService capabilityService;

    public CapabilityController(CapabilityService capabilityService) {
        this.capabilityService = capabilityService;
    }

    @GetMapping
    public CollectionModel<EntityModel<Capability>> getAllCapabilities() {
        List<EntityModel<Capability>> capabilities = capabilityService.getAllCapabilities().stream()
                .map(capability -> new EntityModel<>(
                        capability,
                        linkTo(methodOn(CapabilityController.class).getCapability(capability.getId())).withRel("getThisCapability"),
                        linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities")
                )).collect(Collectors.toList());

        return new CollectionModel<>(capabilities);
    }

    @GetMapping("/{id}")
    public EntityModel<?> getCapability(@PathVariable Long id) {
        Capability capability = capabilityService.findCapabilityById(id);

        return new EntityModel<>(capability, linkTo(methodOn(CapabilityController.class).getCapability(id)).withRel("getThisCapability"));
    }

    @PostMapping
    public Object createCapability(@RequestBody Capability capability) {

        Capability newCapability = capabilityService.saveCapability(capability);

        return new EntityModel<>(
                capability,
                linkTo(methodOn(CapabilityController.class).getCapability(newCapability.getId())).withRel("getThisCapability"),
                linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities")
        );
    }

}
