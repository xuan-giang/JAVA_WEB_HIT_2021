package com.example.btvn5.repository;

import com.example.btvn5.model.Redirect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RedirectRepository extends JpaRepository<Redirect, Long> {
    Optional<Redirect> findBySubUrl(String subUrl);
}
