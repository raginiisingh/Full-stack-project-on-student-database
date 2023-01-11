package com.raginicodes.fullstack.repository;

import com.raginicodes.fullstack.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userrepository extends JpaRepository<user,Long> {
}
