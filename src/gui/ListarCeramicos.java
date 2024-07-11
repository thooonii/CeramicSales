package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class ListarCeramicos extends JDialog implements ActionListener {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea txtListadoCeramico;
	private JButton btnCerrar;
	private JButton btnListar;
	private JScrollPane scrollPane;

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
					ListarCeramicos dialog = new ListarCeramicos();
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
	public ListarCeramicos() {
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarCeramicos.class.getResource("/gui/iconos/1613243.png")));
		setTitle("Listado de Cer\u00E1micos");
		setBounds(100, 100, 512, 427);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(100, 149, 237));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(0);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 474, 321);
		contentPanel.add(scrollPane);
			
		txtListadoCeramico = new JTextArea();
		txtListadoCeramico.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtListadoCeramico.setEditable(false);
		scrollPane.setViewportView(txtListadoCeramico);
		
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCerrar.setIcon(new ImageIcon(ListarCeramicos.class.getResource("/gui/iconos/Delete.png")));
		btnCerrar.setBounds(112, 343, 108, 34);
		contentPanel.add(btnCerrar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnListar.setIcon(new ImageIcon(ListarCeramicos.class.getResource("/gui/iconos/Lists.png")));
		btnListar.setBounds(248, 343, 108, 34);
		contentPanel.add(btnListar);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedBtnListar(ActionEvent e) {
		txtListadoCeramico.setText("LISTADO DE CERAMICOS\n\n");
		
		//LLAMANDO A LOS MÉTODOS QUE LISTAN EN EL MODELO
		listadoModelo0();
		listadoModelo1();
		listadoModelo2();
		listadoModelo3();
		listadoModelo4();
		
		//COLOCANDO EL CURSOR EN LA PRIMERA POSICION DEL JTEXTAREA
		txtListadoCeramico.setCaretPosition(0);
	}
	
	//MÉTODOS PARA LISTAR POR MODELO
	void listadoModelo0() {
		txtListadoCeramico.append("Modelo    :  " + MenuPrincipal.modelo0 + "\n");
		txtListadoCeramico.append("Precio    :  " + "S/." +MenuPrincipal.precio0 + "\n");
		txtListadoCeramico.append("Ancho     :  " + MenuPrincipal.ancho0 +" cm"+"\n");
		txtListadoCeramico.append("Largo     :  " + MenuPrincipal.largo0 +" cm"+"\n");
		txtListadoCeramico.append("Espesor   :  " + MenuPrincipal.espesor0 +" mm"+"\n");
		txtListadoCeramico.append("Contenido :  " + MenuPrincipal.contenido0 + "\n\n\n");
	}
	
	void listadoModelo1() {
		txtListadoCeramico.append("Modelo    :  " + MenuPrincipal.modelo1 + "\n");
		txtListadoCeramico.append("Precio    :  " + "S/." +MenuPrincipal.precio1 + "\n");
		txtListadoCeramico.append("Ancho     :  " + MenuPrincipal.ancho1 +" cm"+"\n");
		txtListadoCeramico.append("Largo     :  " + MenuPrincipal.largo1 +" cm"+"\n");
		txtListadoCeramico.append("Espesor   :  " + MenuPrincipal.espesor1 +" mm"+"\n");
		txtListadoCeramico.append("Contenido :  " + MenuPrincipal.contenido1 + "\n\n\n");
	}
	
	void listadoModelo2() {
		txtListadoCeramico.append("Modelo    : " + MenuPrincipal.modelo2 + "\n");
		txtListadoCeramico.append("Precio    : " + "S/." +MenuPrincipal.precio2 + "\n");
		txtListadoCeramico.append("Ancho     : " + MenuPrincipal.ancho2 +" cm"+"\n");
		txtListadoCeramico.append("Largo     : " + MenuPrincipal.largo0 +" cm"+"\n");
		txtListadoCeramico.append("Espesor   : " + MenuPrincipal.espesor2 +" mm"+"\n");
		txtListadoCeramico.append("Contenido : " + MenuPrincipal.contenido2 + "\n\n\n");
	}
	
	void listadoModelo3() {
		txtListadoCeramico.append("Modelo    :  " + MenuPrincipal.modelo3 + "\n");
		txtListadoCeramico.append("Precio    :  " + "S/." +MenuPrincipal.precio3 + "\n");
		txtListadoCeramico.append("Ancho     :  " + MenuPrincipal.ancho3 +" cm"+"\n");
		txtListadoCeramico.append("Largo     :  " + MenuPrincipal.largo3 +" cm"+"\n");
		txtListadoCeramico.append("Espesor   :  " + MenuPrincipal.espesor3 +" mm"+"\n");
		txtListadoCeramico.append("Contenido :  " + MenuPrincipal.contenido3 + "\n\n\n");
	}
	
	void listadoModelo4() {
		txtListadoCeramico.append("Modelo    :  " + MenuPrincipal.modelo4 + "\n");
		txtListadoCeramico.append("Precio    :  " + "S/." +MenuPrincipal.precio4 + "\n");
		txtListadoCeramico.append("Ancho     :  " + MenuPrincipal.ancho4 +" cm"+"\n");
		txtListadoCeramico.append("Largo     :  " + MenuPrincipal.largo4 +" cm"+"\n");
		txtListadoCeramico.append("Espesor   :  " + MenuPrincipal.espesor4 +" mm"+"\n");
		txtListadoCeramico.append("Contenido :  " + MenuPrincipal.contenido4 + "\n\n\n");
	}
		
}
