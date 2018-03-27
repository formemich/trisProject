package mylib;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JGradientPanel extends JPanel {

	private Color color1, color2;

	public JGradientPanel(Color color1, Color color2) {
		this.color1 = color1;
		this.color2 = color2;
	}
	
	public JGradientPanel() {
		this.color1 = Color.LIGHT_GRAY;
		this.color2 = Color.DARK_GRAY;
	}
	
	public void setColors(Color color1, Color color2) {
		this.color1 = color1;
		this.color2 = color2;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		int w = getWidth();
		int h = getHeight();
		GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, w, h);
	}
}