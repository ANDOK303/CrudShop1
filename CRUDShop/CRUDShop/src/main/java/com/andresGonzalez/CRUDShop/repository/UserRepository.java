package com.andresGonzalez.CRUDShop.repository;

import com.andresGonzalez.CRUDShop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {



}