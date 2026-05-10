package com.example.identic.services;

import com.example.identic.dto.FichaRegistroDTO;
import com.example.identic.models.FichaModel;
import com.example.identic.repositories.FichaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaServiceIMPL implements FichaService{

    @Autowired
    private FichaRepository fichaRepository;

    @Override
    public FichaModel guardar(FichaRegistroDTO fichaRegistroDTO){
        FichaModel ficha;
        if(fichaRegistroDTO.getId() != null){
            ficha = fichaRepository.findById(fichaRegistroDTO.getId()).orElse(new FichaModel());
        }else{
            ficha = new FichaModel();
        }

        ficha.setCodigo(fichaRegistroDTO.getCodigo());
        ficha.setEstudiantes(fichaRegistroDTO.getEstudiantes());

        return fichaRepository.save(ficha);
    }

    @Override
    public List<FichaModel> listarFichas() {return fichaRepository.findAll();}

    @Override
    public  FichaModel obtenerPorId(Long id){return  fichaRepository.findById(id).orElse(null);}

    public void eliminar(Long id){fichaRepository.deleteById(id);}

}
