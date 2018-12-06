/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.desafio.model;

import javafx.collections.ObservableList;

/**
 *
 * @author mario
 */
public class Jogador {
    
    private String nome;
    private ObservableList<Personagem> personagems;

    public Jogador() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ObservableList<Personagem> getPersonagems() {
        return personagems;
    }

    public void setPersonagems(ObservableList<Personagem> personagems) {
        this.personagems = personagems;
    }

    @Override
    public String toString() {
        return "Jogador{" + "nome=" + nome + ", personagems=" + personagems + '}';
    }

 
    
    
}
