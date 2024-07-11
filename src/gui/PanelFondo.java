package gui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFondo extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the panel.
	 */
	public PanelFondo() {
		  this.setSize(600,400);		
	}
	
	@Override
	public void paintComponent(Graphics g) 	{                 
	Dimension tamanio = getSize();
	ImageIcon imagenfondo = new ImageIcon(getClass().getResource("/gui/fondo/fondo0.png"));
	g.drawImage(imagenfondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
	setOpaque(false);
	super.paintComponent(g);
	}
	
}
