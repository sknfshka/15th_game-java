package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GFrame extends JFrame{
    private GPanel gPanel;
    JMenuBar jMenuBar;
    JMenu gameMenu, optionsMenu;
    JMenuItem newGameItem, exitItem, imageModeItem, signModeItem;

    public  GFrame() {
        gPanel = new GPanel(this);

        add(gPanel);

        jMenuBar = new JMenuBar();

        gameMenu = new JMenu("Игра");
        optionsMenu = new JMenu("Опции");

        jMenuBar.add(gameMenu);
        jMenuBar.add(optionsMenu);

        newGameItem = new JMenuItem("Новая");
        gameMenu.add(newGameItem);
        exitItem = new JMenuItem("Выход");
        gameMenu.add(exitItem);

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        imageModeItem = new JRadioButtonMenuItem("Изображение", true);
        optionsMenu.add(imageModeItem);
        signModeItem = new JRadioButtonMenuItem("Цифры");
        optionsMenu.add(signModeItem);
        imageModeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signModeItem.setSelected(false);
                imageModeItem.setSelected(true);
                gPanel.switchMode();
            }
        });
        signModeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imageModeItem.setSelected(false);
                signModeItem.setSelected(true);
                gPanel.switchMode();
            }
        });

        newGameItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gPanel.startNewGame();
                setRadioEnabled(true);
            }
        });

        setJMenuBar(jMenuBar);

        setPreferredSize(new Dimension(gPanel.getGPanelSize(), gPanel.getGPanelSize() + 52));
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    void setRadioEnabled(boolean enabled) {

        imageModeItem.setEnabled(enabled);
        signModeItem.setEnabled(enabled);
    }
}
