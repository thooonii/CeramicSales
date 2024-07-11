package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class ConfigurarCantidadOptima extends JDialog implements ActionListener {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCantidadOptima;
	private JButton btnAceptar;
	private JButton btnCerrar;
	private JLabel lblNewLabel;

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
					ConfigurarCantidadOptima dialog = new ConfigurarCantidadOptima();
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
	public ConfigurarCantidadOptima() {
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarCantidadOptima.class.getResource("/gui/iconos/1613243.png")));
		setTitle("Configurar cantidad \u00F3ptima");
		setBounds(100, 100, 576, 135);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(100, 149, 237));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(0);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Cantidad \u00F3ptima de unidades vendidas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(6, 16, 229, 14);
		contentPanel.add(lblNewLabel);
		
		txtCantidadOptima = new JTextField();
		txtCantidadOptima.setBounds(232, 6, 122, 33);
		contentPanel.add(txtCantidadOptima);
		txtCantidadOptima.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setIcon(new ImageIcon(ConfigurarCantidadOptima.class.getResource("/gui/iconos/Save.png")));
		btnAceptar.setBounds(432, 7, 122, 33);
		contentPanel.add(btnAceptar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCerrar.setIcon(new ImageIcon(ConfigurarCantidadOptima.class.getResource("/gui/iconos/Delete.png")));
		btnCerrar.setBounds(432, 52, 122, 33);
		contentPanel.add(btnCerrar);
		
		//Mostrando los valores
		txtCantidadOptima.setText("" + MenuPrincipal.cantidadOptima);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		//Grabando la cantidad optima
		MenuPrincipal.cantidadOptima = Integer.parseInt(txtCantidadOptima.getText());
		
		//Mostrando aviso de cambio realizado
		JOptionPane.showInternalMessageDialog(null, "Cambio Realizado con Éxito", "Aviso", 1, null);
		
		//Cerrando la ventana luego del cambio realizado
		dispose();
	}
	
}
