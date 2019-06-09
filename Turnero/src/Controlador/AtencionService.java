/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Atencion;
import Modelo.Atendedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Jusot
 */
public class AtencionService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientesR");
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public Atencion GuardarAtencion(Atencion atencion) {
        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        atencion = em.merge(atencion);

        em.getTransaction().commit();
        em.close();
        return atencion;
    }
    public List<Atencion> listarAtenciones() {
        EntityManager em = getEntityManager();

        Query query = em.createQuery("SELECT u FROM Atencion u");
        List<Atencion> resp = (List<Atencion>) query.getResultList();

        em.close();
        return resp;
    }
    
}
