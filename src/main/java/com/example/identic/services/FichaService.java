package com.example.identic.services;

import com.example.identic.dto.FichaRegistroDTO;
import com.example.identic.models.FichaModel;

import java.util.List;

public interface FichaService {

    FichaModel guardar(FichaRegistroDTO fichaRegistroDTO);

    List<FichaModel> listarFichas();

    FichaModel obtenerPorId(Long id);

    void eliminar(Long id);

}
