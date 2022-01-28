package lab2p2_cesarnunez_12141019;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab2P2_CesarNunez_12141019 {
    
    private static ArrayList<Animales> regAnimales = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        
        // animales por defecto 
        regAnimales.add(new Animales("Panthera pardus", "Leopardo", "selvas tropicales", "animales de medio tamaño", 
                "tiene manchas y puede rugir", "África, Oriente Medio y Asia", 20));
        regAnimales.add(new Animales("Canis lupus", "Lobo", "selvas y témpanos de hielo", "carne", 
                "colmillos y cola larga", "Eurasia y América del Norte", 7));
        regAnimales.add(new Animales("Aptenodytes forsteris", "Pinguino Eperador", "Zonas heladas", "peces", 
                "Aves blancas y negras que no vuelan", "Antártida", 17));
        
        // menu
        while(true){
            switch(menu()){
                case 1:{                      
                    agregarAnimales();
                    break;
                }

                case 2:{ // listar animales
                    System.out.print("1) Por posición\n"
                            + "2) Todos los animales\n"
                            + "3) Por nombre científico\n"
                            + "Ingrese una opción: ");
                    int opcion = input.nextInt();
                    System.out.println();
                    
                    switch(opcion){
                        case 1:{
                            System.out.print("Ingrese la posición: ");
                            int pos = input.nextInt();     
                            System.out.println();
                            System.out.println((regAnimales.get(pos)).toString());
                            break;
                        }
                        
                        case 2:{
                            int i = 1;
                            for (Animales Animales : regAnimales) {
                                System.out.println(i + ") " + Animales.toString());
                                i++;
                            }
                            break;
                        }
                        
                        case 3:{
                            System.out.print("Nombre científico: ");
                            input.nextLine();
                            String nc = input.nextLine();
                            System.out.println();
                            for (Animales animal : regAnimales) {
                                if((animal.getnCientifico()).equals(nc)){
                                    System.out.println(animal.toString());
                                }
                            }
                            break;
                        }
                    }
                    break;
                }

                case 3:{ // modificar animales
                    input.nextLine();
                    System.out.print("Nombre científico: ");
                    String nc = input.nextLine();
                    int pos = -1;
                    for (Animales animal : regAnimales) {
                        if(animal.getnCientifico().equals(nc)){
                            pos = regAnimales.indexOf(animal);
                        }
                    }
                    System.out.print("\n1) Editar 1 atributo\n"
                            + "2) Editar todos los atributos\n"
                            + "Ingrese una opción: ");
                    int opcion = input.nextInt();
                    if(pos == -1){
                        opcion = pos;
                    }
                    System.out.println();
                    
                    switch(opcion){
                        case -1:{
                            System.out.println("El animal no se encuentra en la lista!");
                            break;
                        }
                        
                        case 1:{
                            editarAtributo(pos);
                            break;
                        }
                        
                        case 2:{
                            editarTodosAtributos(pos);
                            break;
                        }
                    }
                    break;
                }

                case 4:{ // alimentar
                    System.out.print("Posición del animal que se alimentará: ");
                    int pos = input.nextInt();
                    System.out.print("Posición del animal que será devorado: ");
                    int pos2 = input.nextInt();
                    if(pos < regAnimales.size() && pos >= 0 && pos != pos2){
                        regAnimales.get(pos).setVida(regAnimales.get(pos).getVida() + (regAnimales.get(pos2).getVida()));
                        eliminar(pos2);
                    }else{
                        System.out.println("Las posiciones son inválidas!");
                    }
                    break;
                }

                case 5:{
                    System.out.print("Posición del animal que desea eliminar: ");
                    int pos = input.nextInt();
                    eliminar(pos);
                    break;
                }

                case 6:{
                    System.exit(0);
                    break;
                }

                default:{
                    System.out.println("Ingrese una opción correcta!");
                }                
            } // switch
        } // while
        
    } // main
    
    public static int menu(){
        System.out.print("\n1) Agregar animal\n"
                        + "2) Listar animales\n"
                        + "3) Modificar animales\n"
                        + "4) Alimentar animales\n"
                        + "5) Eliminar animal\n"
                        + "6) Salir\n"
                        + "Ingrese una opción: ");
        int opcion = input.nextInt();
        System.out.println();
        return opcion;
    }
    
    public static void agregarAnimales(){   
        input.nextLine();
        String nci = "";
        boolean encontrado = false;
        while(encontrado == false){
            encontrado = true;
            System.out.print("Nombre científico: ");
            nci = input.nextLine();
            for (Animales animal : regAnimales) {
                if(animal.getnCientifico().equals(nci)){
                    encontrado = false;
                }
            }
        }
        System.out.print("Nombre común: ");
        String nc = input.nextLine();
        System.out.print("Hábitat: ");
        String ha = input.nextLine();
        System.out.print("Alimentación: ");
        String al = input.nextLine();
        System.out.print("Rasgos descriptivos: ");
        String rd = input.nextLine();
        System.out.print("Distribución geográfica: ");
        String dg = input.nextLine();
        System.out.print("Vida: ");
        int ed;
        do{
            ed = input.nextInt();
        }while(ed <= 0);
        regAnimales.add(new Animales(nci, nc, ha, al, rd, dg, ed));    
    }
    
    public static void editarAtributo(int pos){
        System.out.print("1) Nombre científico\n"
                + "2) Nombre común\n"
                + "3) Hábitat\n"
                + "4) Alimentación\n"
                + "5) Rasgos descriptivos\n"
                + "6) Distribución Geográfica\n"
                + "7) Vida\n"
                + "Ingrese una opción: ");
        int op = input.nextInt();
        input.nextLine();
        System.out.println();
        switch(op){
            case 1:{
                System.out.print("Nombre científico: ");
                regAnimales.get(pos).setnCientifico(input.nextLine());
                break;
            }
            case 2:{
                System.out.print("Nombre común: ");
                regAnimales.get(pos).setnComun(input.nextLine());
                break;
            }
            case 3:{
                System.out.print("Hábitat: ");
                regAnimales.get(pos).setHabitat(input.nextLine());
                break;
            }
            case 4:{
                System.out.print("Alimentación: ");
                regAnimales.get(pos).setAlimentacion(input.nextLine());
                break;
            }
            case 5:{
                System.out.print("Rasgos descriptivos: ");
                regAnimales.get(pos).setRasgos(input.nextLine());
                break;
            }
            case 6:{
                System.out.print("Distribución geográfica: ");
                regAnimales.get(pos).setGeografica(input.nextLine());
                break;
            }
            case 7:{
                int vida;
                do{
                    System.out.print("Vida: ");
                    vida = input.nextInt();
                }while(vida <= 0);
                regAnimales.get(pos).setVida(vida);
                break;
            }
        } // switch
    } // editarAtributo
    
    public static void editarTodosAtributos(int pos){
        input.nextLine();
        System.out.print("Nombre Cientifico: ");
        regAnimales.get(pos).setnCientifico(input.nextLine());
        System.out.print("Nombre Comun: ");
        regAnimales.get(pos).setnComun(input.nextLine());
        System.out.print("Habitat: ");
        regAnimales.get(pos).setHabitat(input.nextLine());
        System.out.print("Alimentacion: ");
        regAnimales.get(pos).setAlimentacion(input.nextLine());
        System.out.print("Rasgos descriptivos: ");
        regAnimales.get(pos).setRasgos(input.nextLine());
        System.out.print("Distribucion Geografica: ");
        regAnimales.get(pos).setGeografica(input.nextLine());
        int vida;
        do{
            System.out.print("Vida: ");
            vida = input.nextInt();
        }while(vida <= 0);
        regAnimales.get(pos).setVida(vida);
    }
    
    public static void eliminar(int pos){
        regAnimales.remove(pos);
    }
    
}
