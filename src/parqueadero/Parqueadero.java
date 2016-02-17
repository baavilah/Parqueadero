/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero;

/**
 *
 * @author Alex
 */

public class Parqueadero {
     public static String[] parqueadero1 = new String [87];
     public static int[] tiempo = new int [87];
     public static int dineroDia;   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String puesto = "V";
    
        for(int i = 0; i<87; i++){   
            parqueadero1[i] = puesto;
        }
        System.out.println();
        for(int i = 0; i<87; i++){
         int contador = 0;
         tiempo[i] = contador;
        }
        parqueaderoFuncional();
    }
    public static void ingresoCarro(String placa, int horaEntrada){
        for(int i=0; i<parqueadero1.length; i++){
            if("V".equals(parqueadero1[i])){
                parqueadero1[i] = placa;
                tiempo[i] = horaEntrada;
                System.out.println("Por favor parquée en el puesto: "+(i+1));
                break;
            }
        } 
    }
    public static void salidaCarro(String placa, int horaSalida){
        int tarifa = 10000;
        int horaEntrada = 0;
        for(int i=0; i<parqueadero1.length; i++){
            if(parqueadero1[i].equals(placa)){
                parqueadero1[i] = "V";
                horaEntrada = tiempo[i];
                break;
            }
        }
        int tiempo = horaSalida - horaEntrada;
        int cobro = tiempo*tarifa;
        dineroDia += cobro;
        System.out.println("Debe pagar: $"+cobro);
    }
    public static void dineroDia(){
        System.out.println("Dinero recibido el dia de hoy es: "+dineroDia);
    }
    public static void puestosLibres(){
        System.out.println("Los puestos vacios son: ");
        for(int i=0; i<parqueadero1.length; i++){
            if("V".equals(parqueadero1[i])){
                System.out.print(i+1+" ");   
            }
        }
    }
    public static void parqueaderoFuncional(){
       java.util.Scanner lectura = new java.util.Scanner(System.in);
       String letra;
       String placa;
       int horaEntrada;
       System.out.println("Para el ingreso de un auto escriba: I\nPara la salida de un auto escriba: S\nPara ver el dinero cobrado hoy escriba: D");
       System.out.println("Para ver los puestos libres escriba: P\nPara finalizar el programa escriba: E");
       letra = lectura.nextLine();
       switch(letra){
           case "I":
               System.out.println("Escriba la placa del carro: ");
               placa = lectura.nextLine();
               System.out.println("Escriba la hora de entrada: ");
               horaEntrada = lectura.nextInt();
               System.out.println();
               ingresoCarro(placa, horaEntrada);
               break;
           case "S": 
               System.out.println("Escriba la placa del carro: ");
               placa = lectura.nextLine();
               System.out.println("Escriba la hora de salida: ");
               horaEntrada = lectura.nextInt();
               System.out.println();
               salidaCarro(placa, horaEntrada);
               break;
           case "D": 
               System.out.println();
               dineroDia();
               break;
           case "P":
               System.out.println();
               puestosLibres();
               break;
           case "E":
               System.exit(0); 
           default: break;
       }
       System.out.println();
       parqueaderoFuncional();
    }
}
