/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.desafio.model;

import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author mario
 */
public class Personagem {

    private final SimpleDoubleProperty forca;
    private final SimpleDoubleProperty defesa;

    public Personagem(Double forca, Double defesa) {
        this.forca = new SimpleDoubleProperty(forca);
        this.defesa = new SimpleDoubleProperty(defesa);
    }

    public SimpleDoubleProperty forcaProperty() {
        return forca;
    }

    public SimpleDoubleProperty defesaProperty() {
        return defesa;
    }

    public Double getForca() {
        return forca.get();
    }

    public void setForca(Double forca) {
        this.forca.set(forca);
    }

    public Double getDefesa() {
        return defesa.get();
    }

    public void setDefesa(Double defesa) {
        this.defesa.set(defesa);
    }

    @Override
    public String toString() {
        return "Personagem{" + "forca=" + forca + ", defesa=" + defesa + '}';
    }
}
