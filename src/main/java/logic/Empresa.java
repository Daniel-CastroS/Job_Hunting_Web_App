package logic;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
    @jakarta.persistence.Id
    private String id;
    public String getId() { return id; }
    private String correo;
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private int telefono;
    private String clave;
    private boolean aprobada = false;

    public String getNombre() { return nombre; }

    public String getClave() { return clave; }
    public boolean isAprobada() { return aprobada; }
}