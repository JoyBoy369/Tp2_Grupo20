package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Consejo;
@Component
public class ListaConsejo {

    public List<Consejo> consejoList;
/*
    public ListaConsejo() {
        consejoList = new ArrayList<>();
        consejoList.add(new Consejo("1-No subestimar la desparasitación", "Las veterinarias Alicia Piorno (M.P559) y Graciela Carbajo (M.P472) coinciden en que desparasitar a los animales es un tema crucial para la salud de los animales y de las personas."));
        consejoList.add(new Consejo("2- Los límites son necesarios para darles seguridad", "Para un perro, la familia que integra es su jauría y en una jauría existen jerarquías"));
        consejoList.add(new Consejo("3-El momento de jugar", "La falta de juego y de paseos provoca la mayoría de los problemas de conducta en los perros"));
        
    }
*/
    public void agregarConsejo(Consejo Consejo) {
        consejoList.add(Consejo);
    }

    public List<Consejo> getConsejoList() {
        return consejoList;
    }

    public void setConsejoList(List<Consejo> consejoList) {
        this.consejoList = consejoList;
    }
}

