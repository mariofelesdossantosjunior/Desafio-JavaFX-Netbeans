/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mario.desafio.controller;

import com.mario.desafio.model.Jogador;
import com.mario.desafio.model.Personagem;
import java.awt.HeadlessException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author mario
 */
public class JogoController implements Initializable {

    @FXML
    private Label lbPrimeiroJogador;
    @FXML
    private Label lbSegundoJogador;
    @FXML
    private Label lbGanhador;

    /**
     * Tabela Primeiro Jogador
     */
    @FXML
    private TableView<Personagem> tbPersonagem01;
    @FXML
    private TableColumn<Personagem, Double> forcaCol01;
    @FXML
    private TableColumn<Personagem, Double> defesaCol01;

    /**
     * Tabela Segundo Jogador
     */
    @FXML
    private TableView<Personagem> tbPersonagem02;
    @FXML
    private TableColumn<Personagem, Double> forcaCol02;
    @FXML
    private TableColumn<Personagem, Double> defesaCol02;

    /**
     * Variaveis de controle
     */
    private final int qtdCartas = 5;
    private final Jogador jogadorUm = new Jogador();
    private final Jogador jogadorDois = new Jogador();

    @FXML
    private void atacarP1(ActionEvent event) {
        Personagem personUm = tbPersonagem01.getSelectionModel().getSelectedItem();
        Personagem personDois = tbPersonagem02.getSelectionModel().getSelectedItem();

        System.out.println("Força 01: " + personUm.getForca());
        System.out.println("Defesa 02: " + personDois.getDefesa());

        if (personUm.getForca() > personDois.getDefesa()) {
            jogadorDois.getPersonagems().remove(personDois);
            jogadorUm.getPersonagems().add(personDois);
            lbGanhador.setText("Jogador Um Ganhou!");
        } else if (personUm.getForca() < personDois.getDefesa()) {
            jogadorUm.getPersonagems().remove(personUm);
            jogadorDois.getPersonagems().add(personUm);
            lbGanhador.setText("Jogador Dois Ganhou!");
        } else {
            lbGanhador.setText("Empatou!");
        }

        tbPersonagem01.refresh();
        tbPersonagem02.refresh();

        verificaGanhador();

    }

    @FXML
    private void atacarP2(ActionEvent event) {
        Personagem personUm = tbPersonagem01.getSelectionModel().getSelectedItem();
        Personagem personDois = tbPersonagem02.getSelectionModel().getSelectedItem();

        System.out.println("Força 02: " + personDois.getForca());
        System.out.println("Defesa 01: " + personUm.getDefesa());

        if (personDois.getForca() > personUm.getDefesa()) {
            jogadorUm.getPersonagems().remove(personUm);
            jogadorDois.getPersonagems().add(personUm);
            lbGanhador.setText("Jogador Dois Ganhou!");
        } else if (personDois.getForca() < personUm.getDefesa()) {
            jogadorDois.getPersonagems().remove(personDois);
            jogadorUm.getPersonagems().add(personDois);
            lbGanhador.setText("Jogador Um Ganhou!");
        } else {
            lbGanhador.setText("Empatou!");
        }

        tbPersonagem01.refresh();
        tbPersonagem02.refresh();

        verificaGanhador();

    }

    private void verificaGanhador() throws HeadlessException {
        if (jogadorUm.getPersonagems().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O Segundo Jogador Venceu!");
            novoJogo();

        } else if (jogadorDois.getPersonagems().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O Primeiro Jogador Venceu!");
            novoJogo();
        } else {
            System.out.println("Segue o jogo");
        }
    }

    @FXML
    private void novoJogo(ActionEvent event) {
        novoJogo();
    }

    private void novoJogo() throws HeadlessException {
        String nomeJogadorUm = JOptionPane.showInputDialog("Digite o nome do primeiro jogador:");
        String nomeJogadorDois = JOptionPane.showInputDialog("Digite o nome do segundo jogador:");

        jogadorUm.setNome(nomeJogadorUm);
        jogadorUm.setPersonagems(FXCollections.observableArrayList());

        jogadorDois.setNome(nomeJogadorDois);
        jogadorDois.setPersonagems(FXCollections.observableArrayList());

        lbPrimeiroJogador.setText(jogadorUm.getNome());
        lbSegundoJogador.setText(jogadorDois.getNome());

        if (tbPersonagem01.getItems() != null || tbPersonagem02.getItems() != null) {
            tbPersonagem01.getItems().clear();
            tbPersonagem02.getItems().clear();
        }
    }

    /**
     * Gerando personagens para os jogadores
     */
    @FXML
    private void gerarPersonagens(ActionEvent event) {

        for (int i = 0; i < qtdCartas; i++) {
            jogadorUm.getPersonagems().add(new Personagem(gerador(), gerador()));
        }

        for (int i = 0; i < qtdCartas; i++) {
            jogadorDois.getPersonagems().add(new Personagem(gerador(), gerador()));
        }

        tbPersonagem01.setItems(jogadorUm.getPersonagems());
        tbPersonagem02.setItems(jogadorDois.getPersonagems());

        tbPersonagem01.getSelectionModel().selectFirst();
        tbPersonagem02.getSelectionModel().selectFirst();
    }

    private double gerador() {
        return 1 + (int) (Math.random() * 100);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        forcaCol01.setCellValueFactory(new PropertyValueFactory<>("forca"));
        defesaCol01.setCellValueFactory(new PropertyValueFactory<>("defesa"));
        forcaCol02.setCellValueFactory(new PropertyValueFactory<>("forca"));
        defesaCol02.setCellValueFactory(new PropertyValueFactory<>("defesa"));
    }

}
