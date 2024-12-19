package com.example.socksinstock.repository;

import com.example.socksinstock.model.Socks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с носками.
 */
@Repository
public interface SocksRepository extends JpaRepository<Socks, Integer> {
}
