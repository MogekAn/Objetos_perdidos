// ObjetoService.java

package com.ejemplo.service;

import com.ejemplo.model.Objeto;
import com.ejemplo.repository.ObjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ObjetoService {

    @Autowired
    private ObjetoRepository objetoRepository;

    public List<Objeto> findAll() {
        return objetoRepository.findAll();
    }

    public Optional<Objeto> findById(Long id) {
        return objetoRepository.findById(id);
    }

    public Objeto save(Objeto objeto) {
        return objetoRepository.save(objeto);
    }

    public void deleteById(Long id) {
        objetoRepository.deleteById(id);
    }
}
