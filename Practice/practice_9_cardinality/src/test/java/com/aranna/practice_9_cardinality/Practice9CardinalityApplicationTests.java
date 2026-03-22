package com.aranna.practice_9_cardinality;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aranna.practice_9_cardinality.model.Engine;
import com.aranna.practice_9_cardinality.model.RegistrationNo;
import com.aranna.practice_9_cardinality.model.Vehicle;
import com.aranna.practice_9_cardinality.model.Wheel;
import com.aranna.practice_9_cardinality.repo.EngineRepo;
import com.aranna.practice_9_cardinality.repo.RegistrationNoRepo;
import com.aranna.practice_9_cardinality.repo.VehicleRepo;
import com.aranna.practice_9_cardinality.repo.WheelRepo;

@SpringBootTest
class Practice9CardinalityApplicationTests {

	@Autowired
	private EngineRepo engineRepo;

	@Autowired
	private RegistrationNoRepo registrationNoRepo;

	@Autowired
	private VehicleRepo vehicleRepo;

	@Autowired
	private WheelRepo wheelRepo;

	@Test
	void contextLoads() {
	}

	// @Test
	// void createEngine(){
	// 	var engine1=Engine.builder().vendorName("Cummins").build();
	// 	engineRepo.save(engine1);
	// 	var engine2=Engine.builder().vendorName("Caterpillar Inc").build();
	// 	engineRepo.save(engine2);
	// 	var engine3=Engine.builder().vendorName("General Electric").build();
	// 	engineRepo.save(engine3);
	// 	System.out.println("\n*****************\nEngines: \n");
	// 	System.out.println(engineRepo.findAll());
	// }

	// @Test
	// void createRegistrationNo(){
	// 	var rid1=RegistrationNo.builder().resgistrationNo(1).build();
	// 	registrationNoRepo.save(rid1);
	// 	var rid2=RegistrationNo.builder().resgistrationNo(2).build();
	// 	registrationNoRepo.save(rid2);
	// 	var rid3=RegistrationNo.builder().resgistrationNo(3).build();
	// 	registrationNoRepo.save(rid3);

	// 	System.out.println("\n*****************\nRIDs: \n");
	// 	System.out.println(registrationNoRepo.findAll());
	// }


	// @Test
	// void createWheel(){
	// 	var wheel1=Wheel.builder().vendorName("Steel Strips Wheel").build();
	// 	wheelRepo.save(wheel1);
	// 	var wheel2=Wheel.builder().vendorName("Ramakrishna Forgings").build();
	// 	wheelRepo.save(wheel2);
	// 	var wheel3=Wheel.builder().vendorName("Sundaram Clayton").build();
	// 	wheelRepo.save(wheel3);

	// 	System.out.println("\n*****************\nWheels: \n");
	// 	System.out.println(wheelRepo.findAll());
	// }



	@Test
	void createVehicle(){
		var vehicle1=Vehicle.builder().engine(engineRepo.findById(1).orElse(null)).wheels(wheelRepo.findAll())
		.registrationNo(registrationNoRepo.findById(1).orElse(null)).build();
		vehicleRepo.save(vehicle1);
		var vehicle2=Vehicle.builder().engine(engineRepo.findById(2).orElse(null)).wheels(wheelRepo.findAll())
		.registrationNo(registrationNoRepo.findById(2).orElse(null)).build();
		vehicleRepo.save(vehicle2);
		var vehicle3=Vehicle.builder().engine(engineRepo.findById(3).orElse(null)).wheels(wheelRepo.findAll())
		.registrationNo(registrationNoRepo.findById(3).orElse(null)).build();
		vehicleRepo.save(vehicle3);

		System.out.println("\n************************************ Vehicles ************************************:");
		for(Vehicle v:vehicleRepo.findAll()){
			System.out.println(v);
		}
	}
}
