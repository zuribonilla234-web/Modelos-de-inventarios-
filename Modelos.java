package modeloinventarios;
import java.util.Scanner;

public class ModeloInventarios;

    public static void main(String[]args) {
        Scanner lector = new Scanner (System.in);
        int opcion = 0;

        do {
            System.out.println("SISTEMA DE MODELOS DE INVENTARIO");
            System.out.println("1.Modelo clasico EOQ");
            System.out.println("2.Modelo de inventario con descuento");
            System.out.println("3.Salir");
            System.out.println("Seleccione solo una opcion pls: ");
            opcion = lector.nextInt();

            if  (opcion == 1) {
                modeloClasico(lector);
            }else if (opcion == 2);
                modeloConDescuento(lector);
            } else if (opcion == 3);
                System.out.println("Mil gracias por usar este programa.");
                System.out.println("Saliento, bye...");
           }else {
                System.out.println("Opcion no valida, intenta de nuevo pls");
           }

        }while (opcion !=3);

        lector.close();
    }
    public static void modeloClasico(Scanner lector) {
        System.out.println("MODELO CLASICO EOQ");
        
        System.out.println ("Ingresa el indice de la demanda D: ");
        int dem = lector.nextInt();

        System.out.println("Ingresa el cosot de ordenar K: ");
        int costOrdn = lector.nextInt();

        System.out.println("Ingresa el costo de almacenamiento H: ");
        double costAlm =lector.nextDouble();

        System.out.println(Ingresa el tiempo de entrega (dias pls): );
        int tEntrga = lector.nextInt();

        double cantidadOptima = Math.sqrt((2 * costOrdn)/ costAlm);

        double tiempoOptimo = cantidadOptima / dem;
             
        double n = tEntrga / tiempoOptimo;
        int nEntero = (int) n; 
        double tiempoEspera = tEntrga - (nEntero * tiempoOptimo);
        int puntoReorden = (int) (tiempoEspera * dem);


        System.out.println("RESULTADOS");
        System.out.println("Cantidad de pedido optimo: " + Math.round(cantidadOptima) + " unidades");
        System.out.println("Tiempo optimo entre pedidos To: " + String.format("%.2f", tiempoOptimo) + " dias");
        System.out.println("Valor de n: " + nEntero);
        System.out.println("Punto de reorden: " + puntoReorden + " unidades");
        
    }
    
     //MODELO DE INV DESC.
    public static void modeloConDescuento(Scanner lector) {
        System.out.println("MODELO DE INVENTARIO CON DESCUENTO");
        System.out.println();
        
        System.out.print("Ingrese el indice de la demanda D:");
        int demanda = lector.nextInt();
        
        System.out.print("Ingrese el costo de ordenar K:");
        int costoOrden = lector.nextInt();
        
        System.out.print("Ingrese el porcentaje de almacenamiento %:");
        int porcentajeAlmacen = lector.nextInt();

        System.out.print("¿Cuantos precios quiere evaluar?:");
        int numPrecios = lector.nextInt();
        
        System.out.println(" Evaluacion de precios");
        
        
        for (int i = 1; i <= numPrecios; i++) {
            System.out.println("\n>>> Precio " + i + " <<<");
            
            System.out.print("Ingresa el costo unitario C: $");
            double costoUnitario = lector.nextDouble();

            double costoAlmacen = (costoUnitario * porcentajeAlmacen) / 100.0;
            
            
            double cantidadOptima = Math.sqrt((2 * demanda * costoOrden) / costoAlmacen);
            
            
            double costoCompra = demanda * costoUnitario;
            double costoOrdenar = (demanda * costoOrden) / cantidadOptima;
            double costoAlmacenar = (costoAlmacen * cantidadOptima) / 2;
            double costoTotal = costoCompra + costoOrdenar + costoAlmacenar;
            
            
            System.out.println("  Costo de almacenamiento: $" + String.format("%.2f", costoAlmacen));
            System.out.println("  Cantidad optima: " + Math.round(cantidadOptima) + " unidades");
            System.out.println("  Costo total anual: $" + String.format("%.2f", costoTotal));
        }
        
}