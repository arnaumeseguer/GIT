package org.entdes.todolist;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GestorTasquesTest {

    GestorTasques gestor;

    @BeforeEach
    void setUp(){
        gestor = new GestorTasques();
    }


    @Test
    void testAfegirTasca() throws Exception {

        
        int id = gestor.afegirTasca("nova tasca");
        
        int numTasques = gestor.llistarTasques().size();
        assertEquals(1, numTasques);
        Tasca tasca1 = gestor.obtenirTasca(id);
        assertEquals("nova tasca", tasca1.getDescripcio());
        

    }


    @Test
    void testAfegirTasca2() throws Exception {

    
        int id = gestor.afegirTasca("nova tasca 2");
        int numTasques = gestor.llistarTasques().size();
        assertEquals(1, numTasques);
        Tasca tasca1 = gestor.obtenirTasca(id);
        assertEquals("nova tasca 2", tasca1.getDescripcio());
    

    }

    @Test
    void testAfegirTascaExistent() throws Exception {
        gestor.afegirTasca("nova tasca");
        Exception ex = assertThrows(Exception.class, ()-> gestor.afegirTasca("nova tasca"));
        
    
        }


    @Test
    void testEliminarTasca() throws Exception {
        int id = gestor.afegirTasca("nova tasca");
        gestor.eliminarTasca(id);
        int numTasques = gestor.llistarTasques().size();
        assertEquals(0, numTasques);
        
    }
/* 
    @Test
    void testEliminarTasca2() throws Exception {
        gestor.eliminarTasca(999);
        exception
        assertThrows(Exception., executable)(0, numTasques);
        
    }
*/

    @Test
    void testMarcarCompletada() throws Exception {
        int id = gestor.afegirTasca("nova tasca");
        gestor.marcarCompletada(id);
        Tasca tasca = gestor.obtenirTasca(id);
        assertEquals(true, tasca.isCompletada());
        
    }


    @Test
    void testModificarTasca() throws Exception{
        int id = gestor.afegirTasca("nova tasca");
        gestor.modificarTasca(id, "tasca modificada", null);
        Tasca tasca = gestor.obtenirTasca(id);

    }


    @Test
    void testObtenirTasca() throws Exception{
        int id = gestor.afegirTasca("nova tasca");
        Tasca tasca = gestor.obtenirTasca(id);
        assertEquals("nova tasca", tasca.getDescripcio());
        
    }

    @Test
    void testObtenirTascaInexistent() throws Exception{
        assertThrows(Exception.class , ()-> gestor.obtenirTasca(999));
        
    }


    @Test
    void testLlistarTasques() throws Exception {
        int id = gestor.afegirTasca("nova tasca");
        

        
    }


    @Test
    void testLlistarTasquesPerDescripcio()throws Exception {
        int id = gestor.afegirTasca("nova tasca");
        List<Tasca> llista = gestor.llistarTasquesPerDescripcio("nova");
        assertEquals(1, llista.size());
        assertEquals("nova tasca", llista.get(0).getDescripcio(), "La descripció de la tasca filtrada no és la correcta");
        
    }


    @Test
    void testGetNombreTasques() throws Exception{
        gestor.afegirTasca("nova tasca");
        gestor.afegirTasca("nova tasca 2");
        gestor.afegirTasca("nova tasca 3");
        assertEquals(3, gestor.getNombreTasques());
        

        
    }


}