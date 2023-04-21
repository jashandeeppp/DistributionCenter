package com.cpan282.distributionCenter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cpan282.distributionCenter.model.DistributionCentre;
import com.cpan282.distributionCenter.model.Item;

public interface DistributionCentreRepository extends CrudRepository<DistributionCentre, Integer> {
}
