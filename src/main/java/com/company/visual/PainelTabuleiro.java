package com.company.visual;

import com.company.modelo.Tabuleiro;

import javax.swing.*;
import java.awt.*;

public class PainelTabuleiro extends JPanel {
    PainelTabuleiro(Tabuleiro tabuleiro) {

        setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

        tabuleiro.paraCada(c -> add(new BotaoCampo(c)));
        tabuleiro.registrarObservadores(e -> {
            SwingUtilities.invokeLater(() -> {
                if (e) {
                    JOptionPane.showMessageDialog(this, "Gahou :)");
                } else {
                    JOptionPane.showMessageDialog(this, "Perder :)");
                }

                tabuleiro.reiniciar();
            });
        });
    }
}
