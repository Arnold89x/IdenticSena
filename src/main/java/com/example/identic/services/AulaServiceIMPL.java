package com.example.identic.services;

import com.example.identic.dto.AulaRegistroDTO;
import com.example.identic.models.AulaModel;
import com.example.identic.models.FichaModel;
import com.example.identic.repositories.AulaRepository;
import com.example.identic.repositories.FichaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaServiceIMPL implements AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private FichaRepository fichaRepository;

    @Override
    public AulaModel guardar(AulaRegistroDTO aulaRegistroDTO) {

        AulaModel aula;

        if (aulaRegistroDTO.getId() != null) {
            aula = aulaRepository.findById(aulaRegistroDTO.getId()).orElse((new AulaModel()));
        } else {
            aula = new AulaModel();
        }
        aula.setNombre(aulaRegistroDTO.getNombre());
        aula.setCapacidad(aulaRegistroDTO.getCapacidad());
        aula.setSede(aulaRegistroDTO.getSede());
        aula.setPiso(aulaRegistroDTO.getPiso());

        return aulaRepository.save(aula);
    }

    @Override
    public List<AulaModel> listarAulas() {
        return aulaRepository.findAll();
    }

    @Override
    public AulaModel obtenerPorId(Long id) {
        return aulaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        aulaRepository.deleteById(id);
    }

    @Override
    public void asignarFicha(Long aulaId, Long fichaId) {

        AulaModel aula = aulaRepository.findById(aulaId).orElseThrow();

        FichaModel ficha = fichaRepository.findById(fichaId).orElseThrow();

        aula.getFichas().add(ficha);

        aulaRepository.save(aula);
    }

    @Override
    public void eliminarRelacion(Long aulaId, Long fichaId){

        AulaModel aula = aulaRepository.findById(aulaId).orElse(null);

        if(aula != null){

            aula.getFichas().removeIf(
                    ficha -> ficha.getId().equals(fichaId)
            );

            aulaRepository.save(aula);
        }
    }
}
