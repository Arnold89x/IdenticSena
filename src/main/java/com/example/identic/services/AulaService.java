package com.example.identic.services;

import com.example.identic.dto.AulaRegistroDTO;
import com.example.identic.models.AulaModel;

import java.util.List;

public interface AulaService {

    AulaModel guardar(AulaRegistroDTO aulaRegistroDTO);

    List<AulaModel> listarAulas();

    AulaModel obtenerPorId(Long id);

    void eliminar(Long id);

    void asignarFicha(Long aulaId, Long fichaId);

    void eliminarRelacion(Long aulaId, Long fichaId);

}
