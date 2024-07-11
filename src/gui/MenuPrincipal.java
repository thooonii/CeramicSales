package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class MenuPrincipal extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
    private JMenu mnMantenimiento;
    private JMenu mnVentas;
    private JMenu mnConfiguracion;
    private JMenu mnAyuda;
    private JMenuItem mntmSalir;
    private JMenuItem mntmConsultarCeramico;
    private JMenuItem mntmModificarCeramico;
    private JMenuItem mntmListarCeramicos;
    private JMenuItem mntmVenderCeramico;
    private JMenuItem mntmGenerarReportes;
    private JMenuItem mntmConfigurarDescuentos;
    private JMenuItem mntmConfigurarObsequios;
    private JMenuItem mntmConfigurarCantidadOptima;
    private JMenuItem mntmConfigurarCuotaDiaria;
    private JMenuItem mntmAcercaDeTienda;
	
    
	//Declarando Variables Globales
	// Datos mínimos del primer producto
	public static String modelo0 = "Cinza Plus";
	public static double precio0 = 92.56;
	public static double ancho0 = 62.0;
	public static double largo0 = 62.0;
	public static double espesor0 = 8;
	public static int contenido0 = 6;
	
	// Datos mínimos del segundo producto
	public static String modelo1 = "Luxury";
	public static double precio1 = 42.77;
	public static double ancho1 = 60;
	public static double largo1 = 60;
	public static double espesor1 = 8.5;
	public static int contenido1 = 4;
	
	// Datos mínimos del tercer producto
	public static String modelo2 = "Austria";
	public static double precio2 = 52.45;
	public static double ancho2 = 45;
	public static double largo2 = 45;
	public static double espesor2 = 6.5;
	public static int contenido2 = 12;
	
	// Datos mínimos del cuarto producto
	public static String modelo3 = "Yungay Mix";
	public static double precio3 = 55.89;
	public static double ancho3 = 80;
	public static double largo3 = 120;
	public static double espesor3 = 6.8;
	public static int contenido3 = 9;
	
	// Datos mínimos del quinto producto
	public static String modelo4 = "Thalía";
	public static double precio4 = 45;
	public static double ancho4 = 45;
	public static double largo4 = 11.8;
	public static double espesor4 = 7.2;
	public static int contenido4 = 10;
	
	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	
	// Obsequio
	public static String tipoObsequio = "Lapicero";
	public static int obsequioCantidad1 = 2;
	public static int obsequioCantidad2 = 3;
	public static int obsequioCantidad3 = 4;
	
	// Cantidad óptima de unidades vendidas por día
	public static int cantidadOptima = 10;
	
	// Cuota diaria
	public static double cuotaDiaria = 30000;
	
	
	//VARIABLES PUBLIC STATICS GLOBALES NUEVAS
	//importe acumulado de ventas por modelo
	public static double importeAcumulado0, importeAcumulado1, importeAcumulado2,
	importeAcumulado3, importeAcumulado4, importeAcumuladoTotal;
	
	//porcentaje de cuota diria por modelo
	public static double porcentajeCuota0, porcentajeCuota1, porcentajeCuota2,
	porcentajeCuota3, porcentajeCuota4, porcentajeCuotaTotal;
	
	//contador de cantidad acumulada de ventas por modelo
	public static int contadorVenta0, contadorVenta1, contadorVenta2, contadorVenta3,
	contadorVenta4, contadorVentaTotal;
	
	//cantidad acumulada de unidades vendidas por modelo
	public static int cantUniVendidas0, cantUniVendidas1, cantUniVendidas2,
	cantUniVendidas3, cantUniVendidas4;

	
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
					MenuPrincipal frame = new MenuPrincipal();
					frame.setExtendedState(MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/gui/iconos/1613243.png")));
		setTitle("Tienda 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 374);
		setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/gui/iconos/Documents.png")));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/gui/iconos/Exit.png")));
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/gui/iconos/Search.png")));
		menuBar.add(mnMantenimiento);
		
		mntmConsultarCeramico = new JMenuItem("Consultar Ceramico");
		mntmConsultarCeramico.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/gui/iconos/Monitor.png")));
		mntmConsultarCeramico.addActionListener(this);
		mnMantenimiento.add(mntmConsultarCeramico);
		
		mntmModificarCeramico = new JMenuItem("Modificar Ceramico");
		mntmModificarCeramico.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/gui/iconos/Refresh.png")));
		mntmModificarCeramico.addActionListener(this);
		mnMantenimiento.add(mntmModificarCeramico);
		
		mntmListarCeramicos = new JMenuItem("Listar Ceramicos");
		mntmListarCeramicos.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/gui/iconos/Properties.png")));
		mntmListarCeramicos.addActionListener(this);
		mnMantenimiento.add(mntmListarCeramicos);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/gui/iconos/Payment.png")));
		menuBar.add(mnVentas);
		
		mntmVenderCeramico = new JMenuItem("Vender");
		mntmVenderCeramico.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/gui/iconos/Full basket.png")));
		mntmVenderCeramico.addActionListener(this);
		mnVentas.add(mntmVenderCeramico);
		
		mntmGenerarReportes = new JMenuItem("Generar Reportes");
		mntmGenerarReportes.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/gui/iconos/Price list.png")));
		mntmGenerarReportes.addActionListener(this);
		mnVentas.add(mntmGenerarReportes);
		
		mnConfiguracion = new JMenu("Configuraci\u00F3n");
		mnConfiguracion.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/gui/iconos/Gear.png")));
		menuBar.add(mnConfiguracion);
		
		mntmConfigurarDescuentos = new JMenuItem("Configurar Descuentos");
		mntmConfigurarDescuentos.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/gui/iconos/Label.png")));
		mntmConfigurarDescuentos.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarDescuentos);
		
		mntmConfigurarObsequios = new JMenuItem("Configurar Obsequios");
		mntmConfigurarObsequios.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/gui/iconos/Gift.png")));
		mntmConfigurarObsequios.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarObsequios);
		
		mntmConfigurarCantidadOptima = new JMenuItem("Configurar Cantidad Optima");
		mntmConfigurarCantidadOptima.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/gui/iconos/Application form.png")));
		mntmConfigurarCantidadOptima.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCantidadOptima);
		
		mntmConfigurarCuotaDiaria = new JMenuItem("Configurar Cuota Diaria");
		mntmConfigurarCuotaDiaria.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/gui/iconos/Cash register.png")));
		mntmConfigurarCuotaDiaria.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCuotaDiaria);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/gui/iconos/Info.png")));
		menuBar.add(mnAyuda);
		
		mntmAcercaDeTienda = new JMenuItem("Acerca de la Tienda");
		mntmAcercaDeTienda.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/gui/iconos/User group.png")));
		mntmAcercaDeTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaDeTienda);
		
		//COLOCANDO UNA IMAGEN DE FONDO
		PanelFondo p = new PanelFondo();
		p.setBorder(new EmptyBorder(5,5,5,5));
		p.setLayout(new BorderLayout(0,0));
		setContentPane(p);
		p.setLayout(null);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == mntmAcercaDeTienda) {
			actionPerformedMntmAcercaDeTienda(e);
		}
		
		if (e.getSource() == mntmConfigurarCuotaDiaria) {
			actionPerformedMntmConfigurarCuotaDiaria(e);
		}
		
		if (e.getSource() == mntmConfigurarCantidadOptima) {
			actionPerformedMntmConfigurarCantidadOptima(e);
		}
		
		if (e.getSource() == mntmConfigurarObsequios) {
			actionPerformedMntmConfigurarObsequios(e);
		}
		
		if (e.getSource() == mntmConfigurarDescuentos) {
			actionPerformedMntmConfigurarDescuentos(e);
		}
		
		if (e.getSource() == mntmGenerarReportes) {
			actionPerformedMntmGenerarReportes(e);
		}
		
		if (e.getSource() == mntmVenderCeramico) {
			actionPerformedMntmVenderCeramico(e);
		}
		
		if (e.getSource() == mntmListarCeramicos) {
			actionPerformedMntmListarCeramicos(e);
		}
		
		if (e.getSource() == mntmModificarCeramico) {
			actionPerformedMntmModificarCeramico(e);
		}
		
		if (e.getSource() == mntmConsultarCeramico) {
			actionPerformedMntmConsultarCeramico(e);
		}
		
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	
  	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	    }
	
  	protected void actionPerformedMntmConsultarCeramico(ActionEvent e) {
		ConsultarCeramico consultarCeramico = new ConsultarCeramico();
		consultarCeramico.setLocationRelativeTo(this);
		consultarCeramico.setVisible(true);
	    }
	
  	protected void actionPerformedMntmModificarCeramico(ActionEvent e) {
		ModificarCeramico modificarCeramico = new ModificarCeramico();
		modificarCeramico.setLocationRelativeTo(this);
		modificarCeramico.setVisible(true);
	    }
	
  	protected void actionPerformedMntmListarCeramicos(ActionEvent e) {
		ListarCeramicos listarCeramicos = new ListarCeramicos();
		listarCeramicos.setLocationRelativeTo(this);
		listarCeramicos.setVisible(true);
	    }
	
  	protected void actionPerformedMntmVenderCeramico(ActionEvent e) {
		VenderCeramico venderCeramico = new VenderCeramico();
		venderCeramico.setLocationRelativeTo(this);
		venderCeramico.setVisible(true);
	    }
	
  	protected void actionPerformedMntmGenerarReportes(ActionEvent e) {
		GenerarReportes generarReportes = new GenerarReportes();
		generarReportes.setLocationRelativeTo(this);
		generarReportes.setVisible(true);
	    }
	
  	protected void actionPerformedMntmConfigurarDescuentos(ActionEvent e) {
		ConfigurarDescuentos configurarDescuentos = new ConfigurarDescuentos();
		configurarDescuentos.setLocationRelativeTo(this);
		configurarDescuentos.setVisible(true);
	    }
	
  	protected void actionPerformedMntmConfigurarObsequios(ActionEvent e) {
		ConfigurarObsequios configurarObsequios = new ConfigurarObsequios();
		configurarObsequios.setLocationRelativeTo(this);
		configurarObsequios.setVisible(true);
	    }
	
  	protected void actionPerformedMntmConfigurarCantidadOptima(ActionEvent e) {
		ConfigurarCantidadOptima configurarCantidadOptima = new ConfigurarCantidadOptima();
		configurarCantidadOptima.setLocationRelativeTo(this);
		configurarCantidadOptima.setVisible(true);
	    }
	
  	protected void actionPerformedMntmConfigurarCuotaDiaria(ActionEvent e) {
		ConfigurarCuotaDiaria configurarCuotaDiaria = new ConfigurarCuotaDiaria();
		configurarCuotaDiaria.setLocationRelativeTo(this);
		configurarCuotaDiaria.setVisible(true);
	    }
	
  	protected void actionPerformedMntmAcercaDeTienda(ActionEvent e) {
		AcercaDeTienda acercaDeTienda = new AcercaDeTienda();
		acercaDeTienda.setLocationRelativeTo(this);
		acercaDeTienda.setVisible(true);
	    }
  	
}
