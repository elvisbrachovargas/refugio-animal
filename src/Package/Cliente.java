package Package;

import java.util.ArrayList;
import java.util.List;

//herencia desde PERSONA //Y abstraccion
public class Cliente extends Persona {
    private List<Mascota> mascotas = new ArrayList<Mascota>();

    public Cliente(String nombre) {
        super(nombre);
    }

    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }
}
