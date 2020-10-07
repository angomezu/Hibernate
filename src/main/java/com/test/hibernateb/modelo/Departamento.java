/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hibernateb.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author PC
 */

@Entity
@Table(name="Departamento")



public class Departamento implements Serializable{
    
     @Id
     @SequenceGenerator(name="dep_sec", sequenceName="SEC_DEPARTAMENTO", allocationSize = 1 )
     @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dep_sec")
     @Column(name="ID")
     private Integer ID;
    
     @Column (name="NOMBRE")
     private String NOMBRE;
     
     @Column (name="CANTIDAD_EMPLEADOS")
     private String CANTIDAD_EMPLEADOS;
     
     @Column (name="CANTIDAD_CAJAS")
     private String CANTIDAD_CAJAS;
     
     @Column (name="ESTADO")
     private String ESTADO;
     

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getCANTIDAD_EMPLEADOS() {
        return CANTIDAD_EMPLEADOS;
    }

    public void setCANTIDAD_EMPLEADOS(String CANTIDAD_EMPLEADOS) {
        this.CANTIDAD_EMPLEADOS = CANTIDAD_EMPLEADOS;
    }

    public String getCANTIDAD_CAJAS() {
        return CANTIDAD_CAJAS;
    }

    public void setCANTIDAD_CAJAS(String CANTIDAD_CAJAS) {
        this.CANTIDAD_CAJAS = CANTIDAD_CAJAS;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    @Override
    public String toString() {
        return "Departamento{" + "ID=" + ID + ", NOMBRE=" + NOMBRE + ", CANTIDAD_EMPLEADOS=" + CANTIDAD_EMPLEADOS + ", CANTIDAD_CAJAS=" + CANTIDAD_CAJAS + ", ESTADO=" + ESTADO + '}';
    }
    
     
     
    
    
    
    
    
}
