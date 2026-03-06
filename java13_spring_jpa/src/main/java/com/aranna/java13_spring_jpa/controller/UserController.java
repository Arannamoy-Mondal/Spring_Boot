package com.aranna.java13_spring_jpa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aranna.java13_spring_jpa.dto.PassportRequest;
import com.aranna.java13_spring_jpa.dto.RoleRequest;
import com.aranna.java13_spring_jpa.dto.UserRequest;
import com.aranna.java13_spring_jpa.dto.VehicleRequest;
import com.aranna.java13_spring_jpa.model.Passport;
import com.aranna.java13_spring_jpa.model.Role;
import com.aranna.java13_spring_jpa.model.User;
import com.aranna.java13_spring_jpa.model.Vehicle;
import com.aranna.java13_spring_jpa.repo.PassportRepo;
import com.aranna.java13_spring_jpa.repo.RoleRepo;
import com.aranna.java13_spring_jpa.repo.UserRepo;
import com.aranna.java13_spring_jpa.repo.VehicleRepo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

    private final VehicleRequest vehicleRequest;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;

    UserController(VehicleRequest vehicleRequest) {
        this.vehicleRequest = vehicleRequest;
    }

    @GetMapping("/user")
    public List<User> userFindAll() {
        return userRepo.findAll();
    }

    @PostMapping("/user")
    public ResponseEntity<?> userCreate(@RequestBody UserRequest entity) {
        try {
            System.out.println(entity);
            User user = User.builder().name(entity.getName()).build();
            Set<Role> roles = new HashSet<>();
            for (String role : entity.getRoles()) {
                roles.add(roleRepo.findByRoleName(role));
            }
            // List<Vehicle> vehicle=new ArrayList<>();
            Vehicle vehicle = vehicleRepo.findById(entity.getVehicleId()).orElse(null);
            user.setVehicle(vehicle);
            // for(Integer vehicleId:entity.getVehicleId()){

            // }
            Passport passport = passportRepo.findByIdAndCountry(entity.getPassportId(), entity.getCountry());
            user.setRoles(roles);
            user.setPassport(passport);
            userRepo.save(user);
            System.out.println(entity);
            // return 
            return ResponseEntity.status(HttpStatus.OK).body(userRepo.findAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/role")
    public List<Role> roleCreate(@RequestBody RoleRequest roleRequest) {
        Role role = Role.builder()
                .roleName(roleRequest.getRoleName()).build();
        roleRepo.save(role);
        return roleRepo.findAll();
    }

    @GetMapping("/role")
    public List<Role> roleGet() {
        return roleRepo.findAll();
    }

    @Autowired
    private PassportRepo passportRepo;

    @PostMapping("/passport")
    public List<Passport> passporCreate(@RequestBody PassportRequest passportRequest) {
        Passport passport = Passport.builder()
                .country(passportRequest.getCountry())
                .build();
        passportRepo.save(passport);
        return passportRepo.findAll();
    }

    @Autowired
    private VehicleRepo vehicleRepo;

    @PostMapping("/vehicle")
    public ResponseEntity<?> vehicleCreate(@RequestBody VehicleRequest vehicleRequest) {
        try {
            System.out.println(vehicleRequest.getVehicleType().toUpperCase() + " "
                    + com.aranna.java13_spring_jpa.constant.Vehicle.SUV);
            Vehicle vehicle = Vehicle.builder()
                    .model(vehicleRequest.getModel())
                    // .vehicleType(vehicleRequest.getVehicleType())
                    .build();

            if (vehicleRequest.getVehicleType().toUpperCase().equals(com.aranna.java13_spring_jpa.constant.Vehicle.SEDAN
                    .toString())) {
                vehicle.setVehicleType(com.aranna.java13_spring_jpa.constant.Vehicle.SEDAN);
            } else if (vehicleRequest.getVehicleType()
                    .toUpperCase().equals(com.aranna.java13_spring_jpa.constant.Vehicle.SUV
                            .toString())) {
                vehicle.setVehicleType(com.aranna.java13_spring_jpa.constant.Vehicle.SUV);
            }

            else if (vehicleRequest.getVehicleType()
                    .toUpperCase().equals(com.aranna.java13_spring_jpa.constant.Vehicle.SEDAN
                            .toString())) {
                vehicle.setVehicleType(com.aranna.java13_spring_jpa.constant.Vehicle.SEDAN);
            } else {
                vehicle.setVehicleType(com.aranna.java13_spring_jpa.constant.Vehicle.UNKNOWN);
            }

            vehicleRepo.save(vehicle);
            return ResponseEntity.status(HttpStatus.OK).body(vehicleRepo.findAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

}
