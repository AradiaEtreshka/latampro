package com.ctf.latampro.repository;

import com.ctf.latampro.model.entity.AppUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
