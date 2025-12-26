package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@Tag(name = "Vehicle Management", description = "Operations for managing vehicles in the service ledger")
@SecurityRequirement(name = "Bearer Authentication")
public class VehicleController {
    
    private final VehicleService vehicleService;
    
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    
    @PostMapping
    @Operation(
        summary = "Register Vehicle",
        description = "Register a new vehicle in the system with unique VIN"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Vehicle registered successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Vehicle.class))),
        @ApiResponse(responseCode = "400", description = "Invalid vehicle data or duplicate VIN"),
        @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public Vehicle registerVehicle(
        @Parameter(description = "Vehicle registration data", required = true)
        @RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }
    
    @GetMapping("/{id}")
    @Operation(
        summary = "Get Vehicle by ID",
        description = "Retrieve vehicle information by its unique identifier"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Vehicle found",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Vehicle.class))),
        @ApiResponse(responseCode = "404", description = "Vehicle not found"),
        @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public Vehicle getVehicleById(
        @Parameter(description = "Vehicle ID", required = true)
        @PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }
    
    @GetMapping("/vin/{vin}")
    @Operation(
        summary = "Get Vehicle by VIN",
        description = "Retrieve vehicle information by its Vehicle Identification Number"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Vehicle found",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Vehicle.class))),
        @ApiResponse(responseCode = "404", description = "Vehicle not found"),
        @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public Vehicle getVehicleByVin(
        @Parameter(description = "Vehicle Identification Number", required = true)
        @PathVariable String vin) {
        return vehicleService.getVehicleByVin(vin);
    }
    
    @GetMapping("/owner/{ownerId}")
    @Operation(
        summary = "List Vehicles by Owner",
        description = "Retrieve all vehicles owned by a specific owner"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Vehicles retrieved successfully",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public List<Vehicle> getVehiclesByOwner(
        @Parameter(description = "Owner ID", required = true)
        @PathVariable Long ownerId) {
        return vehicleService.getVehiclesByOwner(ownerId);
    }
    
    @PutMapping("/{id}/deactivate")
    @Operation(
        summary = "Deactivate Vehicle",
        description = "Mark a vehicle as inactive, preventing new service entries"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Vehicle deactivated successfully"),
        @ApiResponse(responseCode = "404", description = "Vehicle not found"),
        @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public void deactivateVehicle(
        @Parameter(description = "Vehicle ID", required = true)
        @PathVariable Long id) {
        vehicleService.deactivateVehicle(id);
    }
}
