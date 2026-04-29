package com.vanessa.habitus.repository;

import com.vanessa.habitus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
