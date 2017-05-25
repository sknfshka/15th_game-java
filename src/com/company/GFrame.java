package com.company;

import javax.swing.*;
import java.awt.*;

public class GFrame extends JFrame{
    private GPanel gPanel;
    private JMenuBar jMenuBar;
    private JMenu gameMenu, optionsMenu, helpMenu;
    private JMenuItem newGameItem, exitItem, imageModeItem, signModeItem, aboutProgramm;

    public  GFrame() {
        gPanel = new GPanel(this);

        add(gPanel);

        UIManager.put("OptionPane.yesButtonText", "Да");
        UIManager.put("OptionPane.noButtonText", "Нет");
        UIManager.put("OptionPane.cancelButtonText", "Отмена");
        UIManager.put("OptionPane.okButtonText", "Готово");

        jMenuBar = new JMenuBar();

        createJMenus();

        createJMenuItems();

        setJMenuBar(jMenuBar);

        setPreferredSize(new Dimension(gPanel.getGPanelSize(), gPanel.getGPanelSize() + 52));
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    private void createJMenus() {
        gameMenu = new JMenu("Игра");
        optionsMenu = new JMenu("Опции");
        helpMenu = new JMenu("Помощь");

        jMenuBar.add(gameMenu);
        jMenuBar.add(optionsMenu);
        jMenuBar.add(helpMenu);
    }

    private void createJMenuItems() {
        newGameItem = new JMenuItem("Новая");
        gameMenu.add(newGameItem);

        exitItem = new JMenuItem("Выход");
        gameMenu.add(exitItem);

        exitItem.addActionListener(e -> System.exit(0));

        imageModeItem = new JRadioButtonMenuItem("Изображение", true);
        optionsMenu.add(imageModeItem);

        signModeItem = new JRadioButtonMenuItem("Цифры");
        optionsMenu.add(signModeItem);

        imageModeItem.addActionListener(e -> {
            signModeItem.setSelected(false);
            imageModeItem.setSelected(true);
            gPanel.switchMode();
        });
        signModeItem.addActionListener(e -> {
            imageModeItem.setSelected(false);
            signModeItem.setSelected(true);
            gPanel.switchMode();
        });

        newGameItem.addActionListener(e -> {
            gPanel.startNewGame();
            setRadioEnabled(true);
        });

        aboutProgramm = new JMenuItem("О программе");
        helpMenu.add(aboutProgramm);

        aboutProgramm.addActionListener(e -> showProgrammInfo());
    }

    void setRadioEnabled(boolean enabled) {
        imageModeItem.setEnabled(enabled);
        signModeItem.setEnabled(enabled);
    }

    private void showProgrammInfo() {
        JOptionPane.showMessageDialog(this, "Программа создана в рамках курса \"Технологии программирования\"");
    }
}
