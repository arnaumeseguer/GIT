package org.entdes.todolist;

import java.util.ArrayList;
import java.util.List;

public class GestorTasques {
    private List<Tasca> llista = new ArrayList<>();
    private int nombreTasques;

    public int afegirTasca(String descripcio) throws Exception {
        validarSiExisteixTasca(descripcio);
        Tasca tasca = new Tasca(descripcio);
        llista.add(tasca);
        nombreTasques++;
        return tasca.getId();
    }

    private void validarSiExisteixTasca(String descripcio) throws Exception {

        for (Tasca tasca : llista) {
            if (tasca.getDescripcio().equals(descripcio)) {
                throw new Exception("La tasca ja existeix");
            }
        }
    }

    public void eliminarTasca(int id) {
        llista.removeIf(tasca -> tasca.getId() == id);
    }

    public void marcarCompletada(int id) throws Exception {
        Tasca tascaModificada = null;
        for (Tasca tasca : llista) {
            if (tasca.getId() == id) {
                tasca.setCompletada(true);
                tascaModificada = tasca;
                break;
            }
        }
        if (tascaModificada == null)
            throw new Exception("La tasca no existeix");        
    }

    public void modificarTasca(int id, String novaDescripcio, Boolean completada) throws Exception {
        validarSiExisteixTasca(novaDescripcio);
        Tasca tascaModificada = null;
        for (Tasca tasca : llista) {
            if (tasca.getId() == id) {
                tasca.setCompletada(completada == null ? false : completada);
                tascaModificada = tasca;
                break;
            }
        }
        if (tascaModificada == null)
            throw new Exception("La tasca no existeix");

    }

    public Tasca obtenirTasca(int id) throws Exception {
        for (Tasca tasca : llista) {
            if (tasca.getId() == id) {
                return tasca;
            }
        }
        throw new Exception("La tasca no existeix");
    }

    public int getNombreTasques() {
        return nombreTasques;
    }

    public List<Tasca> llistarTasques() {
        return llista;
    }

    public List<Tasca> llistarTasquesPerDescripcio(String filtreDescripcio) {

        return filtrarPerDescripcio(filtreDescripcio, llistarTasques());
    }

    private List<Tasca> filtrarPerDescripcio(String filtreDescripcio, List<Tasca> tasques) {
        List<Tasca> tasquesFiltrades = new ArrayList<>();
        for (Tasca tasca : tasques) {
            if (tasca.getDescripcio().startsWith(filtreDescripcio)) {
                tasquesFiltrades.add(tasca);
            }
        }
        return tasques;
    }
}