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
    private String idCorreo;
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private int telefono;
}