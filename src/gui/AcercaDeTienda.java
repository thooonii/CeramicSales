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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class AcercaDeTienda extends JDialog implements ActionListener {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblTiendaCeramica;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_4;
	private JButton btnCerrar;

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
					AcercaDeTienda dialog = new AcercaDeTienda();
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
	public AcercaDeTienda() {
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AcercaDeTienda.class.getResource("/gui/iconos/1613243.png")));
		setTitle("Acerca de Tienda");
		setBounds(100, 100, 450, 364);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(100, 149, 237));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(0);
		contentPanel.setLayout(null);
		
		lblTiendaCeramica = new JLabel("Tienda 1.0");
		lblTiendaCeramica.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiendaCeramica.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTiendaCeramica.setBounds(10, 11, 414, 33);
		contentPanel.add(lblTiendaCeramica);
		
		lblNewLabel_1 = new JLabel("Autores");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(138, 68, 171, 25);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Anthony Abel Alanya");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(129, 112, 180, 21);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_4 = new JLabel("Jim Ramos Hinostroza");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(129, 216, 180, 25);
		contentPanel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("\u00C1ngel Orlando Minaya");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(129, 163, 180, 25);
		contentPanel.add(lblNewLabel_5);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCerrar.setIcon(new ImageIcon(AcercaDeTienda.class.getResource("/gui/iconos/Delete.png")));
		btnCerrar.setBounds(183, 281, 107, 33);
		contentPanel.add(btnCerrar);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.GRAY);
		separator.setBounds(10, 55, 414, 2);
		contentPanel.add(separator);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
}
