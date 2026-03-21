package logic;

import logic.Caracteristica;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Oferente {
    @jakarta.persistence.Id
    private String id;

    public String getId() {
        return id;
    }

    private String correo;
    private String nombre;
    private String primerApellido;
    private String ubicacion;
    private String nacionalidad;
    private int telefono;
    private String clave;
    private boolean aprobado = false;

    public String getNombre() { return nombre; }

    public String getClave() { return clave; }
    public boolean isAprobado() { return aprobado; }

    private ArrayList<Caracteristica> caracteristicas;
}
