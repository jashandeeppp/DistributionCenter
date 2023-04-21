package com.cpan282.distributionCenter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cpan282.distributionCenter.model.DistributionCentre;
import com.cpan282.distributionCenter.model.Item;
import com.cpan282.distributionCenter.repository.DistributionCentreRepository;
import com.cpan282.distributionCenter.repository.ItemRepository;

@SpringBootApplication
public class DistributionCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributionCenterApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(ItemRepository itemRepository, DistributionCentreRepository dcRepository){
		return args -> {
			var distributionCentre1 = dcRepository.save(
				DistributionCentre.builder()
				.name("Dior Centre")
				.latitude(10.0)
				.longitude(10.9)
				.itemsAvailable(3).build());
			
		var distributionCentre2 = dcRepository.save(
					DistributionCentre.builder()
					.name("Stone Store")
					.latitude(60.0)
					.longitude(64.9)
					.itemsAvailable(3).build());

		var distributionCentre3 = dcRepository.save(
				DistributionCentre.builder()
				.name("General Cloth")
				.latitude(12.0)
				.longitude(18.9)
				.itemsAvailable(3).build());

		
		var distributionCentre4 = dcRepository.save(
			DistributionCentre.builder()
			.name("Eaton Center")
			.latitude(26.078)
			.longitude(30.92)
			.itemsAvailable(3).build());


			itemRepository.save(
				Item.builder()
				.name("TShirt")
				.yearOfCreation(2023)
				.price(1050)
				.quantity(10)
				.brandFrom("Dior")
				.distributionCentre(distributionCentre1).build());

			itemRepository.save(
				Item.builder()
				.name("Pant")
				.yearOfCreation(2022)
				.price(2000)
				.quantity(20)
				.brandFrom("Balenciaga")
				.distributionCentre(distributionCentre1).build());

			
			itemRepository.save(
				Item.builder()
				.name("Jacket")
				.yearOfCreation(2022)
				.price(2000)
				.quantity(20)
				.brandFrom("Stone Island")
				.distributionCentre(distributionCentre1).build());

			itemRepository.save(
				Item.builder()
				.name("Shirt")
				.yearOfCreation(2025)
				.price(2055)
				.quantity(80)
				.brandFrom("Stone Island")
				.distributionCentre(distributionCentre2).build());

			itemRepository.save(
				Item.builder()
				.name("TShirt")
				.yearOfCreation(2023)
				.price(1050)
				.quantity(10)
				.brandFrom("Dior")
				.distributionCentre(distributionCentre2).build());
			
			itemRepository.save(
				Item.builder()
				.name("Shoes")
				.yearOfCreation(2023)
				.price(1500)
				.quantity(40)
				.brandFrom("Stone Island")
				.distributionCentre(distributionCentre2).build());
				
			itemRepository.save(
				Item.builder()
				.name("Pant")
				.yearOfCreation(2022)
				.price(2000)
				.quantity(20)
				.brandFrom("Balenciaga")
				.distributionCentre(distributionCentre3).build());

			itemRepository.save(
				Item.builder()
				.name("Coat Pant")
				.yearOfCreation(2022)
				.price(2000)
				.quantity(20)
				.brandFrom("Stone Island")
				.distributionCentre(distributionCentre3).build());
			
			itemRepository.save(
				Item.builder()
				.name("TShirt")
				.yearOfCreation(2023)
				.price(1050)
				.quantity(10)
				.brandFrom("Dior")
				.distributionCentre(distributionCentre3).build());

			itemRepository.save(
				Item.builder()
				.name("Jacket")
				.yearOfCreation(2022)
				.price(2000)
				.quantity(20)
				.brandFrom("Stone Island")
				.distributionCentre(distributionCentre4).build());
		
			itemRepository.save(
				Item.builder()
				.name("Tie")
				.yearOfCreation(2023)
				.price(1050)
				.quantity(20)
				.brandFrom("Balenciaga")
				.distributionCentre(distributionCentre4).build());
			
			itemRepository.save(
				Item.builder()
				.name("Blazer")
				.yearOfCreation(2022)
				.price(2000)
				.quantity(20)
				.brandFrom("Dior")
				.distributionCentre(distributionCentre4).build());
		};
	}

}