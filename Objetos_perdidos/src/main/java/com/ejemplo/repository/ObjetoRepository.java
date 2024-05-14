// ObjetoRepository.java

package com.ejemplo.repository;

import com.ejemplo.model.Objeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjetoRepository extends JpaRepository<Objeto, Long> {
}
