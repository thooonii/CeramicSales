package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class ConfigurarDescuentos extends JDialog implements ActionListener {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JTextField txtDesc1;
	private JTextField txtDesc2;
	private JTextField txtDesc3;
	private JTextField txtDesc4;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurarDescuentos dialog = new ConfigurarDescuentos();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		});
	}
		
	/**
	 * Create the dialog.
	 */
	public ConfigurarDescuentos() {
		setResizable(false);
		setModal(true);
		getContentPane().setBackground(new Color(100, 149, 237));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarDescuentos.class.getResource("/gui/iconos/1613243.png")));
		setTitle("Configurar porcentajes de descuento");
		setBounds(100, 100, 529, 231);
		setDefaultCloseOperation(0);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("1 a 5 unidades");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 22, 112, 14);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("6 a 10 unidades");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 67, 112, 14);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_4 = new JLabel("11 a 15 unidades");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 112, 112, 14);
		getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_6 = new JLabel("M\u00E1s de 15 unidades");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(10, 157, 129, 14);
		getContentPane().add(lblNewLabel_6);
		
		txtDesc1 = new JTextField();
		txtDesc1.setBounds(132, 12, 121, 34);
		getContentPane().add(txtDesc1);
		txtDesc1.setColumns(10);
		
		txtDesc2 = new JTextField();
		txtDesc2.setBounds(132, 57, 121, 34);
		getContentPane().add(txtDesc2);
		txtDesc2.setColumns(10);
		
		txtDesc3 = new JTextField();
		txtDesc3.setBounds(132, 102, 121, 34);
		getContentPane().add(txtDesc3);
		txtDesc3.setColumns(10);
		
		txtDesc4 = new JTextField();
		txtDesc4.setBounds(132, 147, 121, 34);
		getContentPane().add(txtDesc4);
		txtDesc4.setColumns(10);
		
		lblNewLabel_1 = new JLabel("%");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(265, 22, 21, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_3 = new JLabel("%");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(265, 67, 21, 14);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_5 = new JLabel("%");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(265, 112, 21, 14);
		getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_7 = new JLabel("%");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(265, 157, 21, 14);
		getContentPane().add(lblNewLabel_7);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setIcon(new ImageIcon(ConfigurarDescuentos.class.getResource("/gui/iconos/Save.png")));
		btnAceptar.setBounds(386, 12, 121, 34);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setIcon(new ImageIcon(ConfigurarDescuentos.class.getResource("/gui/iconos/Delete.png")));
		btnCancelar.setBounds(386, 57, 121, 34);
		getContentPane().add(btnCancelar);
		
		//Mostrando los valores de los porcentajes al cargar la ventana
		txtDesc1.setText("" + MenuPrincipal.porcentaje1);
		txtDesc2.setText("" + MenuPrincipal.porcentaje2);
		txtDesc3.setText("" + MenuPrincipal.porcentaje3);
		txtDesc4.setText("" + MenuPrincipal.porcentaje4);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);					
		}
		
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		//Grabando los valores de los porcentajes nuevos en las variables globales
		MenuPrincipal.porcentaje1 = Double.parseDouble(txtDesc1.getText());
		MenuPrincipal.porcentaje2 = Double.parseDouble(txtDesc2.getText());
		MenuPrincipal.porcentaje3 = Double.parseDouble(txtDesc3.getText());
		MenuPrincipal.porcentaje4 = Double.parseDouble(txtDesc4.getText());
		
		//Mostrando aviso de cambio realizado
		JOptionPane.showInternalMessageDialog(null, "Cambio Realizado con Éxito", "Aviso", 1, null);
				
		//Cerrando la ventana luego del cambio realizado
		dispose();
	}
	
}
