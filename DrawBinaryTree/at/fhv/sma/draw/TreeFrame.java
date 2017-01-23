package at.fhv.sma.draw;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * The frame reprenting the GUI.
 * 
 * @author Sebastian Malin
 *
 */
public class TreeFrame extends Frame {
	
	private int _width = 1500;
	private int _height = 1200;

	private static final long serialVersionUID = 1L;
	
	private Integer[] _tree = {null, 5, 2, 6, 1, null, 8, 9, 3};

	public TreeFrame() throws HeadlessException {
		super();
		init();
	}

	public TreeFrame(GraphicsConfiguration gc) {
		super(gc);
		init();
	}

	public TreeFrame(String title) throws HeadlessException {
		super(title);
		init();
	}

	public TreeFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		init();
	}

	public void init() {
		setLayout(new BorderLayout());
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		setSize(_width, _height);
		add(new TreePanel(_tree, _width), BorderLayout.CENTER);
		setVisible(true);
	}

}
