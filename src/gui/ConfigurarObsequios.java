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

public class ConfigurarObsequios extends JDialog implements ActionListener {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JTextField txtTipoObsequio;
	private JTextField txtObsequio1;
	private JTextField txtObsequio2;
	private JTextField txtObsequio3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_1;
	private JButton btnCancelar;
	private JButton btnAceptar;

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
					ConfigurarObsequios dialog = new ConfigurarObsequios();
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
	public ConfigurarObsequios() {
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarObsequios.class.getResource("/gui/iconos/1613243.png")));
		getContentPane().setBackground(new Color(100, 149, 237));
		setTitle("Configurar obsequios");
		setBounds(100, 100, 541, 234);
		setDefaultCloseOperation(0);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Tipo de obsequio");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 21, 109, 14);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("1 a 5 unidades");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 67, 109, 14);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("6 a 10 unidades");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 113, 109, 14);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_1 = new JLabel("11 a m\u00E1s unidades");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 159, 109, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtTipoObsequio = new JTextField();
		txtTipoObsequio.setBounds(129, 10, 131, 34);
		getContentPane().add(txtTipoObsequio);
		txtTipoObsequio.setColumns(10);
		
		txtObsequio1 = new JTextField();
		txtObsequio1.setBounds(129, 56, 131, 34);
		getContentPane().add(txtObsequio1);
		txtObsequio1.setColumns(10);
		
		txtObsequio2 = new JTextField();
		txtObsequio2.setBounds(129, 102, 131, 34);
		getContentPane().add(txtObsequio2);
		txtObsequio2.setColumns(10);
		
		txtObsequio3 = new JTextField();
		txtObsequio3.setBounds(129, 148, 131, 34);
		getContentPane().add(txtObsequio3);
		txtObsequio3.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setIcon(new ImageIcon(ConfigurarObsequios.class.getResource("/gui/iconos/Save.png")));
		btnAceptar.setBounds(402, 11, 117, 34);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setIcon(new ImageIcon(ConfigurarObsequios.class.getResource("/gui/iconos/Delete.png")));
		btnCancelar.setBounds(402, 57, 117, 34);
		getContentPane().add(btnCancelar);
		
		//Mostrando los obsequios al cargar la ventana
		txtTipoObsequio.setText("" + MenuPrincipal.tipoObsequio);
		txtObsequio1.setText("" + MenuPrincipal.obsequioCantidad1);
		txtObsequio2.setText("" + MenuPrincipal.obsequioCantidad2);
		txtObsequio3.setText("" + MenuPrincipal.obsequioCantidad3);	
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
		//Grabando los valores de los obsequios y tipos de obsequios
		//nuevos en las variables globales
		MenuPrincipal.tipoObsequio = (txtTipoObsequio.getText());
		MenuPrincipal.obsequioCantidad1 = Integer.parseInt(txtObsequio1.getText());
		MenuPrincipal.obsequioCantidad2 = Integer.parseInt(txtObsequio2.getText());
		MenuPrincipal.obsequioCantidad3 = Integer.parseInt(txtObsequio3.getText());
		
		//Mostrando aviso de cambio realizado
		JOptionPane.showInternalMessageDialog(null, "Cambio Realizado con Éxito", "Aviso", 1, null);
						
		//Cerrando la ventana luego del cambio realizado
		dispose();
	}
	
}

