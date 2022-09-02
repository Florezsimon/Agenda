package com.simon.agenda.dominio;

public class Agenda {

    private Contacto[] contactos; // array // forma de hacerlo, pedir el tamaño o darle el valor estatico

    public Agenda() {
        this.contactos = new Contacto[50];

    }

    public Agenda(int tamanio) {
        this.contactos = new Contacto[tamanio];


    }

    public void aniadirContacto(Contacto c) { // recorrer los contactos

        if (existeContacto(c)) {
            System.out.println("El nombre para este contacto ya existe"); // antes de ingresar contactos se tiene que hacer la verificacio de el mismo por que no puede haber un repetido
        } else if (agendaLlena()) {
                System.out.println("la agenda esta llena, no es posible agg mas contactos");
            }else{

                boolean encontrado = false;
                for (int i = 0; i < contactos.length && !encontrado; i++) {
                    if (contactos[i] == null) {
                        contactos[i] = c;
                        encontrado = true;
                    }

                }
                if (encontrado) {
                    System.out.println("se ha añadido");
                } else {
                    System.out.println("no se ha podido añadir ");
                }
            }
        }


    public boolean existeContacto(Contacto c) { // corrobora si el contacto existe o no
        for (int i = 0; i < contactos.length; i++) { // si es distinto de null, y el contacto que me ha pasado es igual que yo estoy revisando ahora, que salte true
            if (contactos[i] != null && c.equals(contactos[i])) {
                return true;
            }

        }
        return false;
    }


    public void listarContactos() {

        if(espacioAgenda() == contactos.length){
            System.out.println("no hay contactos que mostrar");

        }else {


            for (int i = 0; i < contactos.length; i++) // verifica si en la lista contactos ya hay algo para empezar a listarlos
                if (contactos[i] != null) {
                    System.out.println(contactos[i]);
                }
        }
    }

    public void buscarPorNombre(String nombre) {
        boolean encontrado = false; // si esta o no el numero en este caso el nombre
        for (int i = 0; i < contactos.length && encontrado; i++) {
            if (contactos[i] != null && contactos[i].getNombre().equalsIgnoreCase(nombre))
                System.out.println("su telefono es" + contactos[i].getTelefono()); // muestra el nombre que se busca
            encontrado = true; // esto verifica que el numero y el nombre nunca van a ser repetidos , no se pueden duplicar los nombres
        }


        if (!encontrado) {
            System.out.println("No se ha encontrado el contacto"); // en caso tal de no encontrarlo, recorre la lista n veces hasta encontrarlo en la posicion n

        }
    }



        public boolean agendaLlena(){  // recorrer de nuevo de incio a final la agenda
            for(int i = 0; i< contactos.length; i++){
                if(contactos[i] == null){

                    return false;  // si encuentra una posicion vacia saltaria false ya que todo deberia de estar lleno

                }

            }
            return true; // esta llena

        }

        public void eliminarContacto(Contacto c){  // existe contacto y añadir, pero de forma contraria
        boolean encontrado = false;
        for( int i=0; i<contactos.length;i++){
            if(contactos[i]!=null && contactos[i].equals(c))
                contactos[i]=null; // se borra el elemento
                encontrado = true; // aca se corrobora si se elimino y sale de este metodo


        }
        if (encontrado){
            System.out.println("no se ha eliminado el contato");
        }

    }

    public  int espacioAgenda (){

        int contadorLibres=0;
        for(int i=0; i<contactos.length; i++){
            if(contactos[i]==null)
                contadorLibres++;
        }
        return contadorLibres;
    }

public  Contacto buscarPorNumero(long numeroAbuscar) {
    Contacto contactoBuscado = null;
    for (Contacto contacto : this.contactos) {
        if (contacto.getTelefono() == numeroAbuscar) {
            contactoBuscado = contacto;
        }
    }
    return  contactoBuscado;
}

public boolean cambiarNumero(long numeroViejo, long numeroNuevo){
        return true;
}


 //public void buscarPorApellido


    }









