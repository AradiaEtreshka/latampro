package com.ctf.latampro.repository;

import com.ctf.latampro.model.entity.Hints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HintsRepository extends JpaRepository<Hints, Long> {

}
