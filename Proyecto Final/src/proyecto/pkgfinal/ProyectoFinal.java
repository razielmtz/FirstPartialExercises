/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkgfinal;
import java.util.*;
import java.io.*;
/**
 *
 * @author Raziel 2
 */
public class ProyectoFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         menu();   
    }
    
    public static void menu(){
        String[][] inventario;
        String opcion,nombre;
        Scanner entrada=new Scanner (System.in);
        System.out.println("Bienvenido a mi tiendita.\nPor favor introduzca una opcion del menu.\n1.\tInventario.\n2.\tVentas.\n3.\tCierre del d�a.\n4.\tSalir.");
        opcion = entrada.nextLine();
        switch (opcion){
            case "1":
                int op=1;
                inventario=inventario();
                nombre=pedirNombreDelArchivo();
                crearArchivo(inventario,nombre);
                System.out.println("\n¿Desea ir a ventas ahora?\n[ 1 ]: Si\n[ cualquier otra tecla ]: No ");
                op = entrada.nextInt();
                if (op==1){
                    Ventas(inventario);
                }
                regresar();
                break;
            case "2":
                
                Ventas();
                regresar();
                break;
            case "3":
                nombre=pedirArchivo();
                leerArchivo(nombre);
                regresar();
                break;
            case "4":
                mensajeSalida2();
                break;
            default:
                mensajeSalida3();
                break;
        }
    }
    public static void regresar(){
        String op;
        Scanner entrada= new Scanner (System.in);
        System.out.println("\nRegresar al menu?\n[ 1 ] : Si\n[ cualquier otra tecla ]: No");
        op= entrada.nextLine();
        switch (op){
            case "1":
                menu();
                break;
            default:
                mensajeSalida();
                break;
        }
        }
    public static void mensajeSalida(){
        System.out.println("Gracias por usar el programa.");
        System.exit(0);
    }

    public static void mensajeSalida2(){

        String op;
        Scanner entrada= new Scanner (System.in);
        System.out.println("�Seguro que desea salir?\n[ 1 ] : No\n[ cualquier otra tecla ]: Si");
        op= entrada.nextLine();
        if (op=="1"){
            menu();
        }
        else {
            mensajeSalida();
        }
        System.exit(0);
    }

    public static void mensajeSalida3(){
        String tecla;
        Scanner entrada= new Scanner (System.in);
        System.out.println("\n\nPor favor indicar con alg�n n�mero que opci�n desea realizar del men�.\nPulse cualquier tecla para proseguir.");
        tecla= entrada.nextLine();
        menu();
    }

    public static String[][] inventario(){
        int mercancia;
        mercancia = pedirNumMercancia();
        String[][] invent= new String[mercancia][4];
        invent=pedirClaveMercancia(invent);
        return invent;
    }

    public static int pedirNumMercancia(){
        int mercancia;
        Scanner entrada=new Scanner (System.in);
        System.out.println("Favor de introducir la cantidad de productos que va a registrar:");
        mercancia = entrada.nextInt();
        return mercancia;
    }

    public static String[][] pedirClaveMercancia(String[][] arreglo){
        int orden=1;
        String clave, descripcion,precio, cantidad;
        Scanner entrada= new Scanner (System.in);
        for (int i = 0; i <arreglo.length;i++){
            for (int j = 0; j < arreglo[0].length; j++) {
                if (j==0){
                    System.out.print("Por favor introducir la cantidad de la mercanc�a\t\t[ "+orden+" ]:");
                    cantidad = entrada.nextLine();
                    //int cantidadInt = Integer.parseInt(cantidad);
                    //System.out.println(cantidadInt) //Aqui te dejo la cantidad convertida a float.
                    arreglo[i][j]= cantidad;  
                    } 
                if (j==1){
                    System.out.print("Por favor introducir la clave de la mercanc�a\t\t\t[ "+orden+" ]:");
                    clave = entrada.nextLine();
                    for (int k = 0; k < i; k++) {
                        while (arreglo [k][1].contains(clave)){
                            System.out.print("Esa clave ya fue introducida previamente.");
                            clave=entrada.nextLine();
                        }
                    }
                    arreglo[i][j]=clave;
                } if (j==2){
                    System.out.print("Por favor introducir la descripci�n de la mercanc�a\t\t[ "+orden+" ]:");
                    descripcion = entrada.nextLine();
                    arreglo [i][j]=descripcion;
                }
                if (j==3){
                    System.out.print("Por favor introducir el precio de la mercancia:\t\t\t[ "+orden+" ]: $");
                    precio = entrada.nextLine();
                    System.out.println("\n");
                    float precioFloat = Float.parseFloat(precio);
                    //System.out.println(precioFloat); Aqui te dejo el precio convertido a float.
                    arreglo[i][j]= precio;                 
            }
            }
            orden++;
            }
        
            return arreglo;
        }
    public static String pedirNombreDelArchivo(){
        String doc, opcion;
        java.util.Date fecha = new Date();
        Scanner entrada = new Scanner (System.in);
        System.out.println("¿Desea guardar el inventario con la fecha de hoy?\n\n[ 1 ]: Si\n[ Otra tecla ]:");
        opcion=entrada.nextLine();
        switch (opcion){
            case "1":
                System.out.println(fecha);
                Calendar c1 = Calendar.getInstance();
                doc = Integer.toString(c1.get(Calendar.DATE));
                return doc;
            default:
                System.out.println("¿Cómo desea guardar el documento?");
                doc=entrada.nextLine();
                return doc;
    }
    }
     public static void crearArchivo(String [][]inventario, String nombre){
        
        File archivo = new File(nombre + ".txt");
       
        if (!archivo.exists())
        {   try {  
            archivo.createNewFile();
            } catch (IOException ex) {
               ex.printStackTrace();
            } 
        }  else {
            System.err.println("Ya existe un archivo con ese nombre.");
            System.out.println("Por favor introduce otro nombre.");
            nombre = pedirNombreDelArchivo();
            crearArchivo(inventario,nombre);
            }
        
        try {
         
            PrintWriter escribir = new PrintWriter (archivo,"utf-8");
            
            escribir.println("Cant\tClave\tDescripción\tPrecio"); 
            for(int i=0;i<inventario.length;i++){ 
                for(int j=0;j<inventario[0].length;j++){ 
                escribir.print(inventario[i][j] + "\t");
                }
                escribir.println();
            }
            escribir.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        System.out.println("El archivo se creó con éxito.");
} 
    public static void leerArchivo(String nombre){
        // Paso 1. Instanciamos un objeto de la clase File y una variable cadena
        File archivo = new File (nombre + ".txt"); //archivo es igual a el nombre que le dimos mas .txt
        String cadena=""; 
        if (!archivo.exists()){ //Si el archivo no existe
            System.err.print("El archivo " + nombre  +" no existe. Por favor elija una de las dos opciones.");  //Mostrar error diciendo que archivo no existe
            regresar(); //Regresar al menu principal
        }
        try {//Par el manejo de excepciones
            //Instanciamos un objeto de la clase FileReader y otro de la clase
            //BufferedReader, los cuales nos serviran para dar lectura al archivo
            //deben estar dentro de try.
           FileReader lectura = new FileReader(archivo);
           BufferedReader bufferL = new BufferedReader(lectura);
           //Paso 2. Recorremos el archivo.
           while (cadena!=null){ //Mientras la cadena no sea nula
               cadena = bufferL.readLine(); //Leemos líena por línea el archivo.
               if(cadena!=null) { //Si no encontramos null dentro del archivo
                   System.out.println(cadena); //Lo muestra en pantalla.
               }
           }
           //Paso 3. Cerramos las instancias de BufferedReader y FileReader.
           bufferL.close();
           lectura.close();
        } catch (Exception e) {
            e.printStackTrace();
        }  
}
    public static String pedirArchivo(){
        String archivo;
        Scanner entrada= new Scanner (System.in);
        System.out.print("Ingrese el nombre del archivo del inventario que desean abrir:");
        archivo=entrada.nextLine();
        return archivo;
    }
    public static void Ventas(String[][] inventario){
        Scanner entrada=new Scanner(System.in);
        boolean ventas = true;
        int cantidadInt,cantidad,CantidadTotal1;
        System.out.println(inventario);
        System.out.println("\n");
        float SumaTotal =0;
        for (int i=0;i<inventario.length;i++){
            for(int j=0;j<inventario.length;j++){
                for(int k = 0;k<inventario.length;k++){
            String clave1=inventario[i][1];
            System.out.println("¿Cuanta cantidad se vendio del articulo?"+clave1+":");
            cantidad=entrada.nextInt();
            String cantidad1=inventario[j][0];
            int cantidadInt1=Integer.parseInt(cantidad1);
            CantidadTotal1= cantidadInt1-cantidad;
            String cantidadString1=Integer.toString(CantidadTotal1);
            inventario[i][0]=cantidadString1;
            System.out.println("Lo restante es:"+inventario[i][0]);
            String precioIndividualString=inventario[k][3];
            float precioIndividualFloat=Float.parseFloat(precioIndividualString);
            SumaTotal=precioIndividualFloat+SumaTotal;
        }
        }
        }System.out.println("Precio Total: $"+SumaTotal+"\n");
        regresar();
        }
}   
