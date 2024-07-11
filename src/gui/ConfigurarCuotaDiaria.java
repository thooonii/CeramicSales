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

public class ConfigurarCuotaDiaria extends JDialog implements ActionListener {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCuotaDiaria;
	private JLabel lblCuotaDiariaEsperada;
	private JButton btnAceptar;
	private JButton btnCancelar;

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
					ConfigurarCuotaDiaria dialog = new ConfigurarCuotaDiaria();
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
	public ConfigurarCuotaDiaria() {
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarCuotaDiaria.class.getResource("/gui/iconos/1613243.png")));
		setTitle("Configurar cuota diaria");
		setBounds(100, 100, 550, 139);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(100, 149, 237));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(0);
		contentPanel.setLayout(null);
		
		lblCuotaDiariaEsperada = new JLabel("Cuota diaria esperada (S/.)");
		lblCuotaDiariaEsperada.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCuotaDiariaEsperada.setBounds(6, 18, 168, 14);
		contentPanel.add(lblCuotaDiariaEsperada);
		
		
		txtCuotaDiaria = new JTextField();
		txtCuotaDiaria.setBounds(164, 8, 121, 33);
		contentPanel.add(txtCuotaDiaria);
		txtCuotaDiaria.setColumns(10);
		
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setIcon(new ImageIcon(ConfigurarCuotaDiaria.class.getResource("/gui/iconos/Save.png")));
		btnAceptar.setBounds(407, 9, 121, 33);
		contentPanel.add(btnAceptar);
		
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setIcon(new ImageIcon(ConfigurarCuotaDiaria.class.getResource("/gui/iconos/Delete.png")));
		btnCancelar.setBounds(407, 54, 121, 33);
		contentPanel.add(btnCancelar);
		
		//Mostrando valores cuota diaria
		txtCuotaDiaria.setText("" + MenuPrincipal.cuotaDiaria);
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
		//Grabando cuota diaria
		MenuPrincipal.cuotaDiaria = Double.parseDouble(txtCuotaDiaria.getText());
		
		//Mostrando aviso de cambio realizado
		JOptionPane.showInternalMessageDialog(null, "Cambio Realizado con Éxito", "Aviso", 1, null);
		
		//Cerrando la ventana luego del cambio realizado
		dispose();		
	}

}
