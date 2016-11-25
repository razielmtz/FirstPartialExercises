/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkgfinal;
import java.io.*;
import java.util.*;
/**
 *
 * @author Raziel 2
 */
public class ProyectoFinal {
    public static String[][] productos = new String[100][400];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     menu();   
    }
    public static void menu(){
        String[][] inventario; //Declaramos arreglo de inventario
        String opcion,nombre; //Variables para la opcion del menu seleccionada y el nombre del archivo para guardar
        Scanner entrada=new Scanner (System.in); //Objeto de entrada por teclado
        System.out.println("Bienvenido a mi tiendita.\nPor favor introduzca una opcion del menu.\n1.\tInventario.\n2.\tVentas.\n3.\tCierre del d?a.\n4.\tSalir.");
        opcion = entrada.nextLine(); //Nuestra variable recibe la entrada por teclado
        switch (opcion){
            case "1": //En caso de ser uno ejecutara esto
                int op=1;
                inventario=inventario(); //Nuestro arreglo inventario tomara lo valores obtenidos en el metodo inventario()
                nombre=pedirNombreDelArchivo(); //Utilizaremos el pedir nombre de archivo en caso de ser necesario
                crearArchivo(inventario,nombre); //Se ejecutara el metodo para crear archivo, tomando parametros con los datos del arreglo inventario y el nombre de archvo
                System.out.println("\n¿Desea ir a ventas ahora?\n[ 1 ]: Si\n[ cualquier otra tecla ]: No ");
                op = entrada.nextInt(); //la opcion sera la entrada por teclado para determinar si se desea pasar directamente al siguiente paso
                if (op==1){ //Si la opcion es 1
                    Ventas(inventario); //Ejecutara directamente el metodo ventas
                }
                regresar(); //una vez terminado, se ejecutara el metodo para ver si se desea volver al menu
                break; //Cortamos el ciclo
            case "2": //Si la opcion es 2 ejecutamos esto
                if(productos[0][0]==null) //Si nuestro arreglo global productos esta vario
                {
                    System.out.println("Cree un inventario y vuelva a intentarlo");//
                    menu();//Nos devolvera al menu para crear un inventario
                }
                else
                {
                    Ventas(productos);//Sino ejecutara el metodo ventas, tomando los datos del arreglo productos
                    regresar(); //Ejecuta el metodo para seleccion de volver al menu
                }
                break; //Cortamos el ciclo
            case "3"://Cuando la opcion sea 3:
                nombre=pedirArchivo(); //Pedimos el nombre del archivo a traves del metodo indicado
                leerArchivo(nombre); //Se lee el archivo y se muestra de acuerdo al metodo
                regresar(); //Menu de seleccion de vuelta al menu
                break;//Cortamos ciclo
            case "4": //Cuando la opcion sea 4, ejecutamos el metodo para mensaje de salida
                mensajeSalida2();
                break;//Cortamos el ciclo
            default: //Cuando la opcion sea diferente a todas las anteriores se ejecuta este metodo de mensaje de salida
                mensajeSalida3();
                break; //Cortamos ciclo
        }
    }
    public static void regresar(){ //Metodo para volver al menu
        String op; //Variable para depositar opcion ingresada
        Scanner entrada= new Scanner (System.in); //Crear objeto para entrada por teclado
        System.out.println("\nRegresar al menu?\n[ 1 ] : Si\n[ cualquier otra tecla ]: No"); //Preguntamos al usuario
        op= entrada.nextLine(); //La opcion sera lo que se ingrese por teclado
        switch (op){ //Utilizamos un switch para determinar la opcion anterior
            case "1": //Si la opcion es 1, despliega menu
                menu();
                break; //Se corta el ciclo en caso de ser asi
            default:
                mensajeSalida(); //Si es cualquier otra tecla, ejecuta el metodo de mensaje de salida
                break; //Se corta el ciclo
        }
        }
    public static void mensajeSalida(){
        System.out.println("Gracias por usar el programa."); //Mensaje de salida basico para cuando se elige salir del programa
        System.exit(0);
    }
 
    public static void mensajeSalida2(){
 
        String op; //Declaramos variable para depositar opcion elegida por el usuario
        Scanner entrada= new Scanner (System.in); //Creamos objeto para entrada por teclado
        System.out.println("?Seguro que desea salir?\n[ 1 ] : No\n[ cualquier otra tecla ]: Si"); //Preguntamos en pantalla si continuar con el programa
        op= entrada.nextLine(); //La variable corresponde a la entrada por teclado
        if (op=="1"){ //Si la opcion ingresada es 1, desplegara el menu
            menu();
        }
        else { //Sino ejecuta el metodo de mensaje de salida
            mensajeSalida();
        }
        System.exit(0);
    }
 
    public static void mensajeSalida3(){
        String tecla;
        Scanner entrada= new Scanner (System.in); //Creamos objeto para entrada por teclado
        System.out.println("\n\nPor favor indicar con alg?n n?mero que opci?n desea realizar del men?.\nPulse cualquier tecla para proseguir.");
        tecla= entrada.nextLine();
        menu(); //Ejecutamos de nuevo el menu
    }
 
    public static String[][] inventario(){
        int mercancia;//Declaramos una variable para el numero de mercancia
        mercancia = pedirNumMercancia();//Obtenemos el numero de mercancia
        String[][] invent= new String[mercancia][4]; //Creamos un arreglo para depositar los campos del inventario
        invent=pedirClaveMercancia(invent);//Ese arreglo se llenara con los datos obtenidos en el metodo pedirClaveMercancia(invent)
        for(int i=0;i<mercancia;i++)
        {                           //Utilizamos ciclos for para recorrer tanto nuestro arreglo global productos como el invent
            for(int j=0;j<4;j++)
            {
                productos[i][j]=invent[i][j]; //Asignamos los valores en cada posicion del arreglo invent al arreglo productos
            }
        }
        return invent; //Regresamos el arreglo invent
    }

    public static int pedirNumMercancia(){
        int mercancia;
        Scanner entrada=new Scanner (System.in);//pedimos la cantidad de prodcutos que metera al arreglo
        System.out.println("Favor de introducir la cantidad de productos que va a registrar:");
        mercancia = entrada.nextInt(); //cuando tengamos el numero de productos podremos delimitar el arreglo
        return mercancia;               //y solo pedir los parametros cierta cantidad de veces
    }

    public static String[][] pedirClaveMercancia(String[][] arreglo){
        int orden=1; //Se decalara una variable que sirve para dar un orden.
        String clave, descripcion,precio, cantidad; //Declaramos variables string.
        Scanner entrada= new Scanner (System.in); //Asignamos el escanner con el nombre de entrada.
        for (int i = 0; i <arreglo.length;i++){ // ciclo for que nos servirá para ir rellenando datos del mismo tipo sobre diversos niveles:    [1]precio= 10.0,    [2]precio= 14.0
            for (int j = 0; j < arreglo[0].length; j++) { //ciclo que nos servirá para ir rellenando datos de diversos ripos en un nivel:       [1]cantidad=20,     [1]clave=30
                if (j==0){
                    System.out.print("Por favor introducir la cantidad de la mercanc�a\t\t[ "+orden+" ]:"); //le pedimos al usuario que asigne una cantidad.
                    cantidad = entrada.nextLine(); //asignamos un valor usando el escaner.
                    arreglo[i][j]= cantidad;  //ingresamos la cantidad.
                    } 
                if (j==1){
                    System.out.print("Por favor introducir la clave de la mercanc�a\t\t\t[ "+orden+" ]:"); //Le pedimos al usuario que asigne un artículo.
                    clave = entrada.nextLine(); //Tomamos un valor usando el escaner.
                    for (int k = 0; k < i; k++) {
                        while (arreglo [k][1].contains(clave)){ //Sí el usuario ya usó este artículo le pedirá que ingrese otro artículo
                            System.out.print("Esa clave ya fue introducida previamente.");  
                            clave=entrada.nextLine();////Tomamos un nuevo valor para la variable cantidad.
                        }
                    }
                    arreglo[i][j]=clave; //asignamos cantidad en el arreglo
                } if (j==2){
                    System.out.print("Por favor introducir la descripción de la mercancía\t\t[ "+orden+" ]:"); // Le pedimos al usuario que asigne un valor a la descripción.
                    descripcion = entrada.nextLine(); // el escaner toma el dato y lo gaurda en descripción.
                    arreglo [i][j]=descripcion; //se guarda la descripción en el arreglo
                }
                if (j==3){
                    System.out.print("Por favor introducir el precio de la mercancía:\t\t\t[ "+orden+" ]: $"); //Le pedimos al usaurio que asigne un precio a la mercancía
                    precio = entrada.nextLine(); //Se toma el precio
                    System.out.println("\n");
                    float precioFloat = Float.parseFloat(precio); //Como el maetro nos pide que usemos cada dato con la nomenclatura correcta, tenemos que convertirlo a string para que funcione todo en el arreglo
                    //System.out.println(precioFloat); Aqui te dejo el precio convertido a float.
                    arreglo[i][j]= precio;                 
            }
            }
            orden++; //se va sumando la variable de orden de uno en uno.
            }
        
            return arreglo;
        }
    public static String pedirNombreDelArchivo(){
        String doc, opcion;
        java.util.Date fecha = new Date(); //esta clase como la de escanner nos ayuda crear un fecha y guardarla
        Scanner entrada = new Scanner (System.in);
        System.out.println("¿Desea guardar el inventario con la fecha de hoy?\n\n[ 1 ]: Si\n[ Otra tecla ]:");
        opcion=entrada.nextLine(); //si ya existe esa fecha guardada, entonces el usuario introducira el nombre del archivo
        switch (opcion){
            case "1":
                System.out.println(fecha);
                Calendar c1 = Calendar.getInstance();//nos permite guardar y capturar la fecha del dia
                doc = Integer.toString(c1.get(Calendar.DATE));//DATE se encuentra dentro de la clase de Calendar
                return doc; //en doc se guarda la fecha que obtuvimos de la clase Calendar
            default:
                System.out.println("¿Cómo desea guardar el documento?");
                doc=entrada.nextLine();
                return doc;
    }
    }
     public static void crearArchivo(String [][]inventario, String nombre){
        // Paso 1.- Instanciamos un objeto de la clase File 
        // Al instanciar escribimos como parámetro 
        // El nombre del archivo para manipularlo
        File archivo = new File(nombre + ".txt");
       // Paso 2.- Si no existe el archivo
        if (!archivo.exists())
        {   try { 
            // try nos sirve para manejar excepciones. En caso de que algo
            // pueda salir mal.
            // Creamos un archivo nuevo.
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
        // Paso 3.- Escritura en el archivo
        try {
         // Instanciamos un objeto de la clase PrintWriter
            // como parámetros enviamos el la instancia de File y el formato de
            // archivo de texto
            PrintWriter escribir = new PrintWriter (archivo,"utf-8");
            // Escribimos el contenido del archivo
            escribir.println("Cant\tClave\tDescripción\tPrecio"); 
            for(int i=0;i<inventario.length;i++){ 
                for(int j=0;j<inventario[0].length;j++){ 
                escribir.print(inventario[i][j] + "\t");
                }
                //corremos de nuevo todo el arreglo para escribirlo en el archivo
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
        Scanner entrada= new Scanner (System.in);//por medio del teclado capturaremos el nombre del archivo que quiere ver
        System.out.print("Ingrese el nombre del archivo del inventario que desean abrir:");
        archivo=entrada.nextLine();
        return archivo; //y lo mandaremos para ser analizado
    }
    public static void Ventas(String[][] inventario){
        Scanner entrada=new Scanner(System.in);
        boolean ventas = true;
        int cantidadInt,cantidad,CantidadTotal1;
        for(int i=0;i<inventario.length;i++)
        {
            for(int j=0;j<4;j++)
            {
                productos[i][j]=inventario[i][j];
            }
        }
        System.out.println("\n");
        float SumaTotal =0;
        for (int i=0;i<inventario.length;i++){
            for(int j=0;j<inventario.length;j++){
                for(int k = 0;k<inventario.length;k++){
            String clave1=inventario[j][1]; // se iguala una posicion especifica del arreglo
            System.out.println("¿Cuanta cantidad se vendió del articulo "+clave1+":");
            cantidad=entrada.nextInt(); //Se le asigna un valor a la cantidad en entero
            String cantidad1=inventario[j][0]; //Se toma un valor especifico de la tabla
            int cantidadInt1=Integer.parseInt(cantidad1); //Se convierte a entero este valor especifico
            CantidadTotal1= cantidadInt1-cantidad; // Se restan la cantidad original contra la que se vendió.
            String cantidadString1=Integer.toString(CantidadTotal1); // La cantidad resultante se pasa a string
            inventario[i][0]=cantidadString1; //Se asigna al arreglo la cantidad resultante
            System.out.println("Lo restante es:"+inventario[i][0]); //Se le comenta al usuario cuanto mercancía queda.
            String precioIndividualString=inventario[k][3]; // Se toma un valor especifico
            float precioIndividualFloat=Float.parseFloat(precioIndividualString); //Este valor se convierte de string a float.
            SumaTotal=precioIndividualFloat+SumaTotal; //Este valor se va sumando para que al final se pueda saber cuánto gasto el comprador.
        }
        }
        }System.out.println("Precio Total: $"+SumaTotal+"\n"); //Se le comenta cuanto gasto el usuario.
        regresar(); //llamamos al metodo regresar
        }
}   

