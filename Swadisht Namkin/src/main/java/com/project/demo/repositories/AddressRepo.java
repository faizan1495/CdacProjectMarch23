package com.project.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entities.Address;
@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

}
