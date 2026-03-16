package logic;

import org.springframework.beans.factory.annotation.Autowired;
import data.EmpresasRepository;

@org.springframework.stereotype.Service

public class Service {
    @Autowired
    private EmpresasRepository Empresas;

    public Iterable<Empresa> empresasAll() {
        return Empresas.findAll();
    }

    public void empresasAdd(Empresa empresa) {
        if(Empresas.existsById(empresa.getIdCorreo())) {
            throw new IllegalArgumentException("La empresa ya existe");
        }
        Empresas.save(empresa);
    }
}