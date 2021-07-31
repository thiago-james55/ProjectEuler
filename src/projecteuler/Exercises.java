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
 * @author retif
 */
public class Exercises {
    
    public static void E01() {
        
        //If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

        //Find the sum of all the multiples of 3 or 5 below 1000.
        
        int soma_total = 0;
        
        for (int c = 0; c < 500;c++) {
            
            if ((3 * c) > 1000 ) {
                
                break;
            }
            
            soma_total += (3*c);
            
        }
        
        OUTER_LOOP: for (int c = 0; c < 500;c++) {
            
            if ((5 * c) >= 1000 ) {
                
                break;
            }
            
            for (int b = 5; b <= 330; b += 5) {
                
                if ((5*c) == (3*b)) {
                    
                    continue OUTER_LOOP;
                    
                }
                
            }
            
            soma_total += (5*c);
        
        } //OUTER LOOP SOMA
        
            System.out.println("Exercício 1 Total = " + soma_total);
        
    } //E01
    
    public static void E02() {
        
        //Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

        //1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

        //By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
        
        int anterior_maior;
        int menor = 0;
        int maior = 1;
        int total = 0;
        int posicao = 1;
        
        
        
          
        while ( (maior + menor) <= 4000000 ){
            
            
            
            anterior_maior = maior;
            
            maior = menor + maior;
            
            menor = anterior_maior;
            
            if ( (maior % 2) == 0) {
                
            total += maior;
                
            }
            
            System.out.println(posicao + "° Fibonnacci: " + maior);
            System.out.println("");
            System.out.println(">>> " + posicao + "° Soma Total: " + total);
            System.out.println("");
            
            posicao++;
            
        }
        
        
    } //E02
    
    public static void E03() {
        
        //The prime factors of 13195 are 5, 7, 13 and 29.
        //What is the largest prime factor of the number 600851475143 ?
        
        ArrayList <Integer> primos = new ArrayList();
        
        
        //primeiros primos base
        primos.add(2);
        primos.add(3);
        primos.add(5);
        primos.add(7);
        primos.add(11);
        //primos.add(13);
        
        long numero = 600851475143l;
        
        Range: for (int i = 12; i < 100000000; i++) {
           
           String testepar = Integer.toString(i);
           int teste = Integer.parseInt(Character.toString(testepar.charAt(testepar.length()-1)));
                      
           //Teste Multiplo de 2
           if ( teste == 0 || teste == 2 || teste == 4 || teste == 6 || teste == 8 ) {
                
                continue;
                
            } 
            
            //Teste Divisivel pelos Primos da ArrayList
            
            long i_double = i;
            long math;
                     
            for (int c= 0; c < primos.size(); c++) {
                
                //System.out.println(primos.get(c));
                
                if (i % primos.get(c) == 0) {
                    
                    
                    continue Range;

                }
                
                if (i < Math.pow(primos.get(c), 2) ) {
                    
                    //System.out.println(i);
                    primos.add(i);
                    
                    math = (long) Math.pow(i, 2);
                    //System.out.println(math);
                                                            
                    if ( numero < math ) {
                        
                        System.out.println("Primo ao quadrado maior que o numero = " + i);                        
                        break Range;
                        
                    } else {
                        
                    continue Range;
                        
                        
                    }
                    
                }
                
            } // Teste Divisivel por primo
           
        
            
        } // Final Laço Range
        
        // Agora temos todos os primos anteriores ao numero
        
        System.out.println("---------------------");
        
        
        // Agora pegamos a ArrayList contendos todos os numeros primos que ao quadrado dao menos que o numero e dividimos o numero por esses primos
        for (int show = 0 ; show < primos.size() ; show++) {
            
            // Aqui o que der divisao zero é numero primo do numero , sendo assim o ultimo numero sera nossa resposta
            if ( numero % primos.get(show) == 0) {
                
                System.out.println(primos.get(show));
                
            } else {
                
            }
            
            
            
            
            
        } // Final Mostrar ArraList
    
    } // Final E03
    
    public static void E04() {
        
        //Largest palindrome product
        
        //A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

        //Find the largest palindrome made from the product of two 3-digit numbers.
        
        // 3-digit number Max 999*999 = 998001
        
        int numero;
        
        String testeNumero;
        String testeNumero2;
        
        ArrayList<Integer> palindromos = new ArrayList<>();
        
        
        
        for (int n1 = 100; n1 < 1000; n1++) { // contador do primeiro numero
            
            for (int n2 = 100; n2 < 1000; n2++) { // contador do segundo numero
                
                numero = n1*n2; // atribui a multiplicação do numero 
                testeNumero = Integer.toString(numero); // atribui o numero para String para comparar os CharAt
                testeNumero2 = "";
                
                for (int inverter = (testeNumero.length() - 1) ; inverter >= 0; inverter-- ) { // atribui o numero invertido ao testeNumero2
                    
                    testeNumero2 += testeNumero.charAt(inverter);
                    
                    
                if (testeNumero.equals(testeNumero2)) {
                
                    palindromos.add(numero); // adiciona o numero na arraylist
                    
                }
                    
                    
                }
                
                Collections.sort(palindromos);
                
                
                
                
                
                
                
                //if ( (testeNumero.charAt(0) == testeNumero.charAt(testeNumero.length()-1)) && (testeNumero.charAt(1) == testeNumero.charAt(testeNumero.length()-2)) && (testeNumero.charAt(2) == testeNumero.charAt(testeNumero.length()-3)) ) { // verifica se o primeiro e  o segundo caracter é igual ao ultimo
               
                //    System.out.println(n1 + " * " + n2 + " = " + testeNumero);
                
                             
                //}
                
                
            }
            
            
            
            
        }
        
                System.out.println(palindromos.get(palindromos.size() - 1));
        
      // Minha primeira resposta foi errado pois eu estava somente dando system out nos palindromos n1 * n2 ai no final aparecia um palindromo da ultima casa , porem em uma multiplicação anterior tinha um palindromo maior!
      // Por isso fiz um arraylist adicionando todos os palindromos e posteriormente organizando-os sort() para arrumar em ordem crescente!
    } // Final E04
    
    
    
}
