/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author 09096418
 */
public class IconModel {

    private JLabel iconLabel = null;

    public IconModel(int x, int y, int h, int w) {
        iconLabel = new JLabel();
        iconLabel.setBorder(null);
        iconLabel.setBounds(x, y, h, w);
        iconLabel.setIcon(new ImageIcon(getClass().getResource("/img/48/Delete-icon.png")));
    }

    /**
     * @return the iconLabel
     */
    public JLabel getIconLabel() {
        return iconLabel;
    }

    /**
     * @param iconLabel the iconLabel to set
     */
    public void setIconLabel(JLabel iconLabel) {
        this.iconLabel = iconLabel;
    }

    public void setBounds(int x, int y, int h, int w) {
        iconLabel.setBounds(x, y, h, w);
    }

    public void setIcon(ImageIcon imageIcon) {
        iconLabel.setIcon(imageIcon);
    }

}
