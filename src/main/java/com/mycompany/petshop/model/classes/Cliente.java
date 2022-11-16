package com.mycompany.petshop.model.classes;

import java.util.ArrayList;

public class Cliente {
  private ArrayList<Animal> animais;
  private String nome;

    public Cliente(ArrayList<Animal> animais, String nome) {
        this.animais = animais;
        this.nome = nome;
    }

    public Cliente(String nome) {
        this.animais = new ArrayList<Animal>();
        this.nome = nome;
    }

    public ArrayList<Animal> getAnimais() {
        return animais;
    }

    public void listAnimais(){
      System.out.println("Animais de "+this.nome);
      for(Animal animal : animais){
        System.out.println(" - " + animal.getNome());
      }
      System.out.println("\n");
    }

    public void addAnimal(Animal animal){
      animais.add(animal);
    }

    public void setAnimais(ArrayList<Animal> animais) {
        this.animais = animais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
  
  
}