package ping;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class View_Computer extends JFrame {
    
        // ----- Janela
	private JPanel interna = null;
 
       
        BufferedImage img = null;
        
        private JTable tabela;
        private JScrollPane barraRolagem;
        private final DefaultTableModel model;
        
	public View_Computer() {
		super();
                this.model = new DefaultTableModel();
		//JOptionPane.showMessageDialog(null, "Bem vindo ao teste do algoritmo de mem�rias associativas\nDe in�cio ser�o executados algumas rotinas\nPrimeiro iremos carregar os vetores de entrada e sa�da ja estipulados\nEm seguida a matrizResultado ser� treinada com o algoritmo para uma posterior compara��o e aproxima��o dos valores\nJust relax e acompanhe");
                initialize();
	}
	 
	private void initialize() {
            //this.setSize(300,300);
            //this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/8.png")));
            this.setTitle("Usuarios Cadastrados");
            this.setContentPane(getInterna());
	}


	private JPanel getInterna() {
		if (interna == null) {
			
                    interna = new JPanel();
                    interna.setLayout(null);
                    tabela = new JTable();

                    model.addColumn("IP conectado");
                        /*for (Usuario usuario : lista) {
                            String atv = "";
                            if(usuario.getAtivo() == 2)
                                atv = "NÂO";
                            else
                                atv = "SIM";
                            model.addRow(new Object[]{atv, usuario.getNip(), usuario.getPost_grad(), usuario.getNome_guerra(), usuario.getNome(), usuario.getSetor(), usuario.getRamal()}); 
                        }*/
                    tabela.setModel(model);
                    //tabela.getColumnModel().getColumn(0).setPreferredWidth(1);

                    barraRolagem = new JScrollPane(tabela);
                    barraRolagem.setBounds(0, 0, 800, 800);
                    interna.add(barraRolagem, null);
                    
                   }
		return interna;
	}
        
    public void setStatus(String ip, String hora) {
        model.addRow(new Object[]{ip, hora}); 
    }

        
}