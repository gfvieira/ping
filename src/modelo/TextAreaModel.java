/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author 09096418
 */
public class TextAreaModel {

    private JTextField textField = null;

    public TextAreaModel(int x, int y, int h, int w, String text) {
        textField = new JTextField(text);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setEditable(false);
        textField.setBackground(new Color(0, 100, 0));
        textField.setForeground(Color.WHITE);
        textField.setBounds(x, y, h, w);
        textField.setFont(new Font("Arial", Font.BOLD, 14));
        textField.setBorder(new LineBorder(Color.BLACK, 0, true));
    }

    /**
     * @return the textArea
     */
    public JTextField getTextField() {
        return textField;
    }

    /**
     * @param textArea the textArea to set
     */
    public void setTextField(JTextField textArea) {
        this.textField = textArea;
    }

}
