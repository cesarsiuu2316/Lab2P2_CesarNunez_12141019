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
                    System.out.print("Nombre científico: ");
                    String nci;
                    do{
                        nci = input.nextLine();
                    }while(regAnimales.contains(nci));
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
                    System.out.print("Edad: ");
                    int ed = input.nextInt();
                    regAnimales.add(new Animales(nci, nc, ha, al, rd, dg, ed));                    
                    break;
                }

                case 2:{ // listar animales
                    System.out.print("1) Por posición\n"
                            + "2) Todos los animales\n"
                            + "3) Por nombre científico\n"
                            + "Ingrese una opción: ");
                    int opcion = input.nextInt();
                    
                    switch(opcion){
                        case 1:{
                            System.out.print("Ingrese la posición: ");
                            int pos = input.nextInt();                            
                            System.out.println((regAnimales.get(pos)).toString());
                            break;
                        }
                        
                        case 2:{
                            for (Animales regAnimale : regAnimales) {
                                System.out.println(regAnimale.toString());
                            }
                            break;
                        }
                        
                        case 3:{
                            System.out.print("Nombre científico: ");
                            //for (Animales regAnimale : regAnimales) {
                                //if(regAnimale.equals(nc))
                            //}
                            break;
                        }
                    }
                    break;
                }

                case 3:{

                    break;
                }

                case 4:{

                    break;
                }

                case 5:{

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
        System.out.println("1) Agregar animal\n"
                        + "2) Listar animales\n"
                        + "3) Modificar animales\n"
                        + "4) Alimentar animales\n"
                        + "5) Eliminar animal\n"
                        + "6) Salir");
        return input.nextInt();
    }
    
}
