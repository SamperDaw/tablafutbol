/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author DAW-A
 */
public class Crud {
    
     public static List<Futbolistas> getFutbolistas() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM Futbolistas";
        Query q = manager.createNativeQuery(sql, Futbolistas.class); //método para consultas en SQL
        List<Futbolistas> futbolistasBD = q.getResultList();

        return futbolistasBD;
    }
     
    

    public static int destroyFutbolistas(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        EntityManager manager = factory.createEntityManager();
        String sql = "DELETE from Futbolistas f WHERE f.id = " + id;
        Query q = manager.createQuery(sql);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate(); //para las consultas de modif. datos se usa el método executeUpdate
        manager.getTransaction().commit();
        return filasAfectadas;
    }

    public static Futbolistas getFutbolista(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT f FROM Futbolistas f WHERE f.id=" + id; //consulta en JPQL 
        Query q = manager.createQuery(sql, Futbolistas.class); //método para consultas en JPQL
        Futbolistas futbolistasBD = (Futbolistas) q.getSingleResult();
        return futbolistasBD;
    }

    public static int actualizaFutbolistas(Futbolistas miFutbolista) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Futbolistas f SET f.nombre = :nombre, f.apellidos = :apellidos, f.dorsal = :dorsal, f.equipo = :equipo WHERE f.id = :id";
        Query q = manager.createQuery(sql, Futbolistas.class);
        q.setParameter("nombre", miFutbolista.getNombre());
        q.setParameter("apellidos", miFutbolista.getApellidos());
        q.setParameter("dorsal", miFutbolista.getDorsal());
        q.setParameter("equipo", miFutbolista.getEquipo());
        q.setParameter("id", miFutbolista.getId());
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        //manager.close();
        return filasAfectadas;
    }

    public static void insertaFutbolista(Futbolistas futbolista) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();       
        manager.merge(futbolista);
        manager.getTransaction().commit();
    }
}
