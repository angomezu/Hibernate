/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hibernateb.Dao;

import com.test.hibernateb.modelo.Departamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author GERSON
 */


public class departamentoDao {
    
    protected EntityManager em;
    private EntityManagerFactory tran = null;
    
    
    public departamentoDao (){
    
        tran = Persistence.createEntityManagerFactory("HibernateB");
    
    }
    
    public Departamento fyndbyId(Departamento p){
        em = getEntityManager();
        return em.find(Departamento.class, p.getID());
    }
    
    
    private EntityManager getEntityManager(){
        
        return tran.createEntityManager();     
    
    }
    
    
    public void selectall(){
    
    //Iniciamos variable que contiene la sentencia a ejecutar
        String hql = "SELECT p from Departamento p";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        List<Departamento> lista = query.getResultList();
        for (Departamento p : lista){
        System.out.print(p + "\n");
        }
        
    }

    
    
    
    public void Insertar (Departamento departamento){
    
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(departamento);
            em.getTransaction().commit();
            

        }catch (Exception ex){
        
            System.out.println("Error al insertar el objeto:" + ex.getMessage());
        
        
        }finally{
        
        if(em !=null){
            em.close();
            }
        
        }
    }

        
     public void actualizar (Departamento departamento){
     try{
         em = getEntityManager();
         em.getTransaction().begin();
         em.merge(departamento);
         em.getTransaction().commit();
         
     
     }catch (Exception ex){
     
         System.out.println("Error al actualizar el objeto:"+ex.getMessage());
     
     
        }finally{
            if(em !=null){
                
                em.close();
            
            }
        }  
         
     }
    
    
    public void eliminar (Departamento departamento){
    try{
        em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(departamento));
        em.getTransaction().commit();

   
    
    }catch (Exception ex){
        System.out.println("Error al eliminar el objeto persona:"+ ex.getMessage());
    
    
        }finally{
    
        if(em !=null){
            em.close();
            
            }
        
        }
    
    }
    
    
}
