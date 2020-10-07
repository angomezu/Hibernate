/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hibernateb.Operations;

import com.test.hibernateb.Dao.departamentoDao;
import com.test.hibernateb.modelo.Departamento;
import java.util.Scanner;

/**
 *
 * @author ANGOMEZU
 */
public class OperHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        departamentoDao departamento = new departamentoDao();
        
        Departamento p1 = null;
        int opcion = -1;
        Scanner entrada = new Scanner(System.in);
        String ID, NOMBRE, CANTIDAD_EMPLEADOS, CANTIDAD_CAJAS, ESTADO;
  
        while (opcion !=0){
        
        try{
            System.out.println("Elige una opcion:\n1.-Listar Departamentos" + 
          "\n2.-Buscar un departamento por Id\n" +
                    "3.-Agregar un departamento\n" +
                    "4.-Modificar un departamento\n"+
                    "5.-Eliminar una departamento\n" +
                    "0.-Salir\n");

            opcion = Integer.parseInt(entrada.nextLine());
            
            switch (opcion){
                case 1:
                    System.out.println("\n1.Listado***********");
                    departamento.selectall();
                    break;
                    
                case 2:
                    System.out.println("\n2.Buscar un Departamento por Id***********");
                    System.out.println("Introduce el ID del departamento a buscar:");
                    ID = entrada.nextLine();
                    p1 = new Departamento();
                    p1.setID(new Integer(ID));
                    p1 = departamento.fyndbyId(p1);
                    System.out.println("Registro encontrado:" + p1);
                    break;
                case 3:
                    System.out.println("\n3.Insertar***********");
                    System.out.println("Introduce el nombre del departamento a agregar");
                    NOMBRE = entrada.nextLine();
                    
                    System.out.println("Introduce la cantidad de empleados a agregar");
                    CANTIDAD_EMPLEADOS = entrada.nextLine();
                    
                    System.out.println("Introduce la cantidad de cajas a agregar");
                    CANTIDAD_CAJAS = entrada.nextLine();
                    
                    System.out.println("Introduce el estado del departamento");
                    ESTADO = entrada.nextLine();

                    
                    p1 = new Departamento();
                    p1.setNOMBRE(NOMBRE);
                    p1.setCANTIDAD_EMPLEADOS(CANTIDAD_EMPLEADOS);
                    p1.setCANTIDAD_CAJAS(CANTIDAD_CAJAS);
                    p1.setESTADO(ESTADO); 
                    departamento.Insertar(p1);
                    break;
                case 4:
                    System.out.println("\n4.Modificar***********");
                    //primero buscamos la persona a modificar
                    System.out.println("Introducir el ID del departamento a modificar");
                    ID = entrada.nextLine();
                    p1= new Departamento();
                    p1.setID(new Integer(ID));
                    departamento.fyndbyId(p1);
                    
                    System.out.println("Introduce el nuevo nombre del departamento");
                    NOMBRE = entrada.nextLine();
                    
                    System.out.println("Introduce la nueva cantidad de empleados");
                    CANTIDAD_EMPLEADOS = entrada.nextLine();
                    
                    System.out.println("Introduce la nueva cantidad de cajas");
                    CANTIDAD_CAJAS = entrada.nextLine();
                    
                    System.out.println("introduce el nuevo estado del departamento");
                    ESTADO = entrada.nextLine();
                    
                     p1 = new Departamento();
                    p1.setNOMBRE(NOMBRE);
                    p1.setCANTIDAD_EMPLEADOS(CANTIDAD_EMPLEADOS);
                    p1.setCANTIDAD_CAJAS(CANTIDAD_CAJAS);
                    p1.setESTADO(ESTADO); 
                    departamento.actualizar(p1);
                    break;
                case 5:
                    System.out.println("\n5.Eliminar***********");
                    //buscamos la persona a eliminar
                    System.out.println("Introuce el ID del departamento a eliminar");
                    ID = entrada.nextLine();
                    p1 = new Departamento();
                    p1.setID(new Integer(ID));
                    p1 = departamento.fyndbyId(p1);
                    //Eliminar el registro encontrado
                    departamento.eliminar(p1);
                    break;
                case 0:
                    System.out.println("Salida efectuada");
                    System.exit(0);
                    break;
                    
            
                } 
                    System.out.println("\n");
            
               }catch(Exception ex){
                    System.out.println("Surgio una falla en la ejecucion del programa:" + ex.getMessage());
            }
        
        } 
    }
    
}
