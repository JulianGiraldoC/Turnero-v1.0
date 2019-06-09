/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author JulianGiraldo
 */
public class ClientesService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientesR");

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Cliente guardarCliente(Cliente cliente) {
        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        cliente = em.merge(cliente);

        em.getTransaction().commit();
        em.close();
        return cliente;
    }

    public List<Cliente> listarClientes() {
        EntityManager em = getEntityManager();

        Query query = em.createQuery("SELECT u FROM Cliente u");
        List<Cliente> resp = (List<Cliente>) query.getResultList();

        em.close();
        return resp;
    }

    public Cliente consultarCliente(long identificador) {
        EntityManager em = getEntityManager();

        Cliente resp = em.find(Cliente.class, identificador);

        em.close();
        return resp;
    }

}
