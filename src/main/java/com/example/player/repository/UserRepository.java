package com.example.player.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.player.web.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
