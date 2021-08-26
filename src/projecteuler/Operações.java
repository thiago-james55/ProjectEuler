/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Pichau
 */
public class Operações {
    
    public static ArrayList<Long> primos = new ArrayList();
    
    public static ArrayList<Long> NumerosPrimos(long input) { // retorna uma ArrayList com um cache definido de numeros primos
        
        //Algoritmo pra listarmos os primos
             
        
        if (Operações.primos.size() < 1) {
            
            Operações.primos.add(2l);
                        
        }
 
        
        
        
        Range: for (long i = Operações.primos.get(Operações.primos.size()-1) ; i <= input; i++) { // range dos numeros que queremos sabem se sao primos

              String testepar = Long.toString(i);
              int teste = Integer.parseInt(Character.toString(testepar.charAt(testepar.length()-1)));

              //Teste Multiplo de 2 - numeros multiplos de 2 nao sao primos - nesse caso testamos o ultimo charAt se for 0,2,4,6,8 da continue pois numeros com esses finais sao multiplos de 2
              if ( teste == 0 || teste == 2 || teste == 4 || teste == 6 || teste == 8 ) {

                   continue;

               } 

               //Teste Divisivel pelos Primos da ArrayList

               long i_double = i;
               long math;

               for (int c= 0; c < Operações.primos.size(); c++) {


                   if (i % Operações.primos.get(c) == 0) { // se o numero (i) for divisivel por algum primo da arraylist , cancela e da continue


                       continue Range;

                   }

                   if (i < Math.pow(Operações.primos.get(c), 2) ) { // se o numero (i) for menor que o primo ao quadrado na arraylist entao ele eh considerado primo

                       //System.out.println(i);
                       Operações.primos.add(i);
                       
                       //if (i >= input) {
                       //  break;  
                       //} 

                           //if (primos.size() == quantidade_primos) { // vamos ir até a quantidade primos selecionada

                            //   break Range;

                           //}

                       continue Range;




                   } // final do teste de caso primo seja menor que ultimo primo ao quadrado



                } // Final do For Primos Size


        } //Final Range
        
        
        
        return Operações.primos;
        
    }
    
    public static long NumeroTriangular(long numero) { // Aqui retorna a posição do numero triangular, usado em um for por exemplo que vai aumentando 
        
        numero = (numero*(numero+1))/2;
        
        return numero;
    }
    
    public static long NumeroDeDivisores(long numero) {
       
        long divisores = 0;
        int range_triangular = 0;
        int incremento = 0;
        
        for (int i = 1; i < Math.sqrt(numero); i++) { // verifica os divisores até a raiz quadrada do numero
                
            if (numero % i == 0) { // se divisivel adiciona 2
                    
                divisores +=2 ;
                    
            } 

        }
        
        if(Math.sqrt(numero) % 1 == 0){ // se a raiz quadrada for inteira adiciona 1
        
            divisores++;
            
        }

        return divisores;
    }
    
}
