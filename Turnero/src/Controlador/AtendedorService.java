/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Atencion;
import Modelo.Atendedor;
import Modelo.Cliente;
import static java.time.Instant.now;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Jusot
 */
public class AtendedorService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientesR");

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Atendedor guardarAtendedor(Atendedor atendedor) {
        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        atendedor = em.merge(atendedor);

        em.getTransaction().commit();
        em.close();
        return atendedor;
    }

    public List<Atendedor> listarAtendedores() {
        EntityManager em = getEntityManager();

        Query query = em.createQuery("SELECT u FROM Atendedor u");
        List<Atendedor> resp = (List<Atendedor>) query.getResultList();

        em.close();
        return resp;
    }

    public Atendedor consultarAtendedor(long identificador) {
        EntityManager em = getEntityManager();

        Atendedor resp = em.find(Atendedor.class, identificador);

        em.close();
        return resp;
    }
    public Atendedor clienteAtendido(long identificador, long id){
        EntityManager em = getEntityManager();    
        Cliente resp = em.find(Cliente.class, identificador);
        resp.actualizarAtendido("si");
        em.getTransaction().begin();
        resp = em.merge(resp);
        em.getTransaction().commit();
        em.close();
        EntityManager em1 = getEntityManager();
        Atendedor resp1= em1.find(Atendedor.class, id);
        Atencion r= new Atencion(resp.getID(), resp.getNombre(), resp.getTipoServicio(), resp.getPrioridad(), resp1.getNroAsesor(), resp1.getNombre(), resp.getHora(), resp.getNroTurno());
        AtencionService e= new AtencionService();
        e.GuardarAtencion(r);
        return resp1;
    }
    
}
