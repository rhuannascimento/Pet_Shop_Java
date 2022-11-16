/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.petshop;

/**
 *
 * @author Rhuan
 */
public class PETSHOP {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("José");

        Animal gato = new Animal("Gatinho");
        Animal cachorro = new Animal("Doguinho");

        cliente.addAnimal(gato);
        cliente.addAnimal(cachorro);

    }
}
