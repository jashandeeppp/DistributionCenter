package com.cpan282.distributionCenter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpan282.distributionCenter.model.DistributionCentre;
import com.cpan282.distributionCenter.model.Item;
import com.cpan282.distributionCenter.repository.DistributionCentreRepository;
import com.cpan282.distributionCenter.repository.ItemRepository;


@RestController
@RequestMapping("/api/distribution") 
public class DistributionCentreController {
   private final DistributionCentreRepository dcRepository;
   private final ItemRepository itemRepository;

   public DistributionCentreController(DistributionCentreRepository dcRepository, ItemRepository itemRepository){
        this.dcRepository = dcRepository;
        this.itemRepository = itemRepository;
   }

   @GetMapping
   public List<DistributionCentre> getAllCentres(){
      return (List<DistributionCentre>) dcRepository.findAll();
   }

   @GetMapping("/{id}/items")
   public List<Item> getItemsForCentre(@PathVariable int id){
      var currentDistributionCentre = dcRepository.findById(id);
      var items = currentDistributionCentre.get().getItems();
      return items;
   }

   @PostMapping("/{id}/items")
   public Item addItemToCentre(@PathVariable int id, @RequestBody Item item) {
      var currentDistributionCentre = dcRepository.findById(id);
      item.setDistributionCentre(currentDistributionCentre.get());
      var savedItem = itemRepository.save(item);
      return savedItem;
   }

   @DeleteMapping("/{id}/deleteitem")
   public void deleteItem(@PathVariable("id") int id) {
      itemRepository.deleteById(id);
   }

   @GetMapping("/{name}/{brand}")
   public List searchItem(@PathVariable("name") String name, @PathVariable("brand") String brand){
      var items = itemRepository.findByNameAndBrandFrom(name, brand);
      return items;
   }
   @GetMapping("/centres/{name}/{brand}")
   public List searchCentreByItem(@PathVariable("name") String name, @PathVariable("brand") String brand){
      var items = itemRepository.findByNameAndBrandFrom(name, brand);
      List centres = new ArrayList<>();
      for (Item item : items) {
         centres.add(item.getDistributionCentre());
      }
      return centres;
   }
}