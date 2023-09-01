package com.project.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.entities.LocalUser;

public interface LocalUserRepo extends JpaRepository<LocalUser, String> {

	Optional<LocalUser> findById(String userId);

}
