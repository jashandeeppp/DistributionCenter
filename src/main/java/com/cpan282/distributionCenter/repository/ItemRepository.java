package com.cpan282.distributionCenter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cpan282.distributionCenter.model.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {
    List<Item> findByNameAndBrandFrom(String name, String brand);
}
