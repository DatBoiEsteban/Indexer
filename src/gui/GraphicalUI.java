package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import constants.IGuiConsts;
import fileManager.DirectoryLoader;
import IndexSearch.*;

public class GraphicalUI extends JFrame implements IGuiConsts {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JLabel TitleText;
	private JLabel BackgroundIMG;
	private JButton SearchButton;
	private JTextField SearchText;
	private DirectoryLoader DL;
	private TfIdf_Indexer TFIDF;

	public GraphicalUI() {
		FilePathPopUp fp =new FilePathPopUp();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setPreferredSize(new java.awt.Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);

		initComponents();
		this.setVisible(true);
		this.DL = new DirectoryLoader(fp.getFilePath());
		this.TFIDF = TfIdf_Indexer.getInstance(this.DL.getArr());
		Object[][] as = TFIDF.getIndex();
		for(int i = 0; i<as.length; i++) {
			for(int j = 0; j<as[i].length; j++) {
				System.out.println(as[i][j].toString());
			}
		}
		
	}

	private void initComponents() {

		SearchText = new JTextField();
		TitleText = new JLabel();
		SearchButton = new JButton();
		BackgroundIMG = new JLabel();

		SearchText.setBounds(SEARCHBAR_X_LOCATION, SEARCHBAR_Y_LOCATION, SEARCHBAR_WIDTH, SEARCHBAR_HEIGHT);
		SearchText.setFont(TEXT_FONT);
		SearchText.setForeground(TEXT_COLOR);

		TitleText.setFont(TITLE_FONT);
		TitleText.setForeground(TITLE_COLOR);
		TitleText.setText(TITLE);
		TitleText.setBounds(TITLE_X_LOCATION, TITLE_Y_LOCATION, TITLE_WIDTH, TITLE_HEIGHT);
		// TitleText.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));

		SearchButton.setFont(TEXT_FONT);
		SearchButton.setForeground(TEXT_COLOR);
		SearchButton.setText(BUTTON_TEXT);
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SearchButtonActionPerformed(evt);
			}
		});
		SearchButton.setBounds(BUTTON_X_LOCATION, BUTTON_Y_LOCATION, BUTTON_WIDTH, BUTTON_HEIGHT);

		BackgroundIMG.setIcon(WINDOW_BACKGROUND);
		BackgroundIMG.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		this.getContentPane().add(SearchText);
		this.getContentPane().add(TitleText);
		this.getContentPane().add(SearchButton);
		this.getContentPane().add(BackgroundIMG);

		this.pack();
	}

	private void SearchButtonActionPerformed(ActionEvent evt) {
		/*
		 * leer archivos
		 * realizar tf-idf
		 * cosine o manhattan
		 * abrir ventana
		 * cerrar esta ventana
		 * 
		 */
		
	}
}
