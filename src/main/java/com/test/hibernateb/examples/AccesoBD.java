/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hibernateb.examples;

import com.test.hibernateb.modelo.Departamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author ANGOMEZU
 */
public class AccesoBD {
    
     
        protected EntityManager em;
    private EntityManagerFactory tran = null;
    
    
    public AccesoBD (){
    
        tran = Persistence.createEntityManagerFactory("HibernateB");
    
    }
    
      
    
    private EntityManager getEntityManager(){
        
        return tran.createEntityManager();     
    
    }
        
        
    public void consultar(){
    em = getEntityManager();
    String sql = "SELECT * FROM DEPARTAMENTO";
    Query query = em.createNativeQuery(sql,Departamento.class);
    List<Departamento> lista = query.getResultList();
    for (Departamento p : lista){
        System.out.print(p + "\n");
        }
    }
    
    
    public void Insertar(Integer ID, String NOMBRE, String CANTIDAD_EMPLEADOS, String CANTIDAD_CAJAS, String ESTADO){
        
        try{
        em=getEntityManager();
        em.getTransaction().begin();
        String sql = "INSERT INTO DEPARTAMENTO(ID,NOMBRE,CANTIDAD_EMPLEADOS,CANTIDAD_CAJAS,ESTADO)VALUES(?,?,?,?,?,?,?)";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, ID);
        query.setParameter(2, NOMBRE);
        query.setParameter(3, CANTIDAD_EMPLEADOS);
        query.setParameter(4, CANTIDAD_CAJAS);
        query.setParameter(5, ESTADO);
        query.executeUpdate();
        em.getTransaction().commit();
        System.out.println("Inserción de departamento con exito");
    
        }catch(Exception ex){
        System.out.println("Sucedio un error en el programa " + ex.getMessage());
        
        
        }finally{
    
        if(em !=null){
            em.close();
            
            }
    
        }
    
    
    }
  
    public void actualizar(String NOMBRE, String CANTIDAD_EMPLEADOS, String CANTIDAD_CAJAS, String ESTADO,Integer ID){
        try{ 
            em=getEntityManager();
            em.getTransaction().begin();
            String sql = "UPDATE DEPARTAMENTO SET NOMBRE=?,CANTIDAD_EMPLEADOS=?,CANTIDAD_CAJAS=?,ESTADO=? WHERE ID=?";
            Query query = em.createNativeQuery(sql);
            query.setParameter(1, NOMBRE);
            query.setParameter(2, CANTIDAD_EMPLEADOS);
            query.setParameter(3, CANTIDAD_CAJAS);
            query.setParameter(4, ESTADO);
            query.setParameter(5, ID);
            query.executeUpdate();
            em.getTransaction().commit();
            System.out.println("Actualización de departamento con exito");
    
        }catch(Exception ex){
            System.out.println("Sucedio un error en el programa " + ex.getMessage());
                
        }finally{
        if(em !=null){
            em.close();
            
            }
                      
        }
    
    }
    
  
 
    public void eliminar(Integer ID) {
    
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            String sql = "DELETE FROM DEPARTAMENTO WHERE ID = ?";
            Query query = em.createNativeQuery(sql).setParameter(1, ID);
            query.executeUpdate();
            em.getTransaction().commit();
            System.out.println("Borrado de departamento satisfactorio");
           
        }catch(Exception ex){
            
            System.out.println("Sucedio un error en el programa"+ex.getMessage());
       
        }finally{
    
        if(em !=null){
            em.close();
            
            }
    
        }
             
        
    }


}
    
    

