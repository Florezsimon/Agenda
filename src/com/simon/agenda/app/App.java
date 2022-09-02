package com.simon.agenda.app;

import com.simon.agenda.dominio.Agenda;
import com.simon.agenda.dominio.Contacto;

import java.util.InputMismatchException;
import java.util.Scanner;


public class App {


    public static void main(String[]args){
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("");// en caso de usar nombres compuestos
        boolean  salir = false;
        int opcion; // guardaremos la opcion del usuario


        while (!salir){

            System.out.println("1. añadir contacto");
            System.out.println("2. listar contacto");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Existe contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Contactos disponible");
            System.out.println("7. Agendallena");
            System.out.println("8. buscar por telefono");
            System.out.println("9. Salir");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                Agenda AgendaTelefonica  = new  Agenda(50);
                String nombre;
                int telefono;

                Contacto c;

                switch (opcion){
                    case 1:

                        System.out.println("Escribir un nombre");
                        nombre = sn.next();   // devuelve el siguiente token/palabra en la entrada como cadena
                        sn.nextLine();

                        System.out.println("Escribir un numero telefonico");
                        telefono = sn.nextInt();

                        c = new Contacto(nombre, telefono);

                        AgendaTelefonica.aniadirContacto(c);
                        break;


                    case 2:
                        AgendaTelefonica.listarContactos(); // no hay que pedir nada, solo imprime
                        break;
                    case 3:
                        System.out.println("Escribe un nombre");
                        nombre = sn.next();
                        AgendaTelefonica.buscarPorNombre(nombre);
                        break;


                    case 4:
                        System.out.println("Escribe un nombre");
                        nombre = sn.next();

                        c = new Contacto(nombre, 0);  // con el nombre se puede eliminar el contacto

                        if (AgendaTelefonica.existeContacto(c)){
                            System.out.println("Existe contacto");
                        }else{
                            System.out.println("no existe");
                        }
                        break;


                    case 5:

                        System.out.println("Escribe un nombre");
                        nombre = sn.next();

                        c = new Contacto(nombre, 0);  // con el nombre se puede eliminar el contacto

                        AgendaTelefonica.eliminarContacto(c);

                        break;

                    case 6:
                        System.out.println("tiene"+AgendaTelefonica.espacioAgenda()+"contactos libres");
                        break;

                    case 7:


                        if(AgendaTelefonica.agendaLlena()){
                            System.out.println("Esta llena");
                        }else{
                            System.out.println("tiene espacio ");
                        }

                    case 8:
                       System.out.println("ingrese nombre");
                       telefono = sn.nextInt();
                       AgendaTelefonica.buscarPorNumero(telefono);
                       break;

                }

            } catch (InputMismatchException e){
                System.out.println("debes insertar un numero");
                sn.next();
            }
        }
    }

}
