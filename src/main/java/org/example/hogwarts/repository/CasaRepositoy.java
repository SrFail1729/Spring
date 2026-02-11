package org.example.hogwarts.repository;

import org.example.hogwarts.model.Casa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasaRepositoy extends JpaRepository<Casa,Long> {
}
