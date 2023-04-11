package tpi135_2023.ingenieria.occ.ues.edu.sv.Delivery.boundary;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import tpi135_2023.ingenieria.occ.ues.edu.sv.Delivery.entity.Comercio;

import java.util.List;

@Stateless
public class ComercioBean {

    @PersistenceContext
    EntityManager em;
    public List<Comercio> ListAll(){
        return em.createNamedQuery("Comercio.findAll").getResultList();
    }

    public void InsertarComercio(Comercio comercio){
        em.persist(comercio );
    }
    public Comercio findcomercioById(Comercio comercio){
        return em.find(Comercio.class, comercio.getIdComercio());
    }




}
