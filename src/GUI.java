/*
 * MIT License
 * 
 * Copyright (c) 2021 Morgan McFord
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
*/

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import java.awt.TextField;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;
import javax.swing.SpinnerNumberModel;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;

public class GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/PassGen.jpg"));
		setTitle("Password Generator by Morgan McFord");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 492);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Password Generator");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		panel.setOpaque(false);
		tabbedPane.addTab("Random String", null, panel, null);
		
		JLabel passwordLabel = new JLabel("Number of Passwords");
		passwordLabel.setBounds(86, 103, 133, 13);
		panel.add(passwordLabel);
		
		JSpinner noPasswordsSlider = new JSpinner();
		noPasswordsSlider.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		noPasswordsSlider.setBounds(245, 95, 42, 29);
		panel.add(noPasswordsSlider);
		
		JLabel lengthLabel = new JLabel("Length");
		lengthLabel.setBounds(86, 133, 96, 13);
		panel.add(lengthLabel);
		
		JSpinner lengthSlider = new JSpinner();
		lengthSlider.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		lengthSlider.setBounds(245, 133, 42, 29);
		panel.add(lengthSlider);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 227, 729, 176);
		panel.add(scrollPane);
		
		JTextPane textOutput = new JTextPane();
		scrollPane.setViewportView(textOutput);
		textOutput.setForeground(Color.WHITE);
		textOutput.setBackground(Color.BLACK);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setColumnHeaderView(textArea);
		textArea.setToolTipText("Starting Phrase for the password");
		textArea.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		JRadioButton IncludeLFArrow = new JRadioButton("<");
		IncludeLFArrow.setOpaque(false);
		IncludeLFArrow.setBounds(335, 99, 42, 21);
		panel.add(IncludeLFArrow);
		
		JRadioButton IncludeRFArrow = new JRadioButton(">");
		IncludeRFArrow.setOpaque(false);
		IncludeRFArrow.setBounds(335, 129, 42, 21);
		panel.add(IncludeRFArrow);
		
		JRadioButton IncludeLFBracket = new JRadioButton("(");
		IncludeLFBracket.setOpaque(false);
		IncludeLFBracket.setBounds(379, 99, 42, 21);
		panel.add(IncludeLFBracket);
		
		JRadioButton IncludeRFBracket = new JRadioButton(")");
		IncludeRFBracket.setOpaque(false);
		IncludeRFBracket.setBounds(379, 129, 42, 21);
		panel.add(IncludeRFBracket);
		
		JRadioButton IncludeLine = new JRadioButton("|");
		IncludeLine.setOpaque(false);
		IncludeLine.setBounds(423, 99, 42, 21);
		panel.add(IncludeLine);
		
		JRadioButton IncludeSpeechMark = new JRadioButton("\"");
		IncludeSpeechMark.setOpaque(false);
		IncludeSpeechMark.setBounds(423, 129, 42, 21);
		panel.add(IncludeSpeechMark);
		
		JRadioButton IncludeBSlash = new JRadioButton("\\");
		IncludeBSlash.setOpaque(false);
		IncludeBSlash.setBounds(467, 99, 42, 21);
		panel.add(IncludeBSlash);
		
		JButton createButton = new JButton("Create");
		createButton.setBackground(Color.WHITE);
		createButton.setBounds(303, 179, 96, 20);
		panel.add(createButton);
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				String passover = String.valueOf(lengthSlider.getValue()) + "," + String.valueOf(noPasswordsSlider.getValue());
				String exclusions = "";
				
				if(IncludeLFArrow.isSelected())
				{
					exclusions = (exclusions + "<" + " ");
				}
				
				if(IncludeRFArrow.isSelected())
				{
					exclusions = (exclusions + ">" + " ");
				}
				
				if(IncludeLFBracket.isSelected())
				{
					exclusions = (exclusions + "(" + " ");
				}
				
				if(IncludeRFBracket.isSelected())
				{
					exclusions = (exclusions + ")" + " ");
				}
				
				if(IncludeLine.isSelected())
				{
					exclusions = (exclusions + "|" + " ");
				}
				
				if(IncludeSpeechMark.isSelected())
				{
					exclusions = (exclusions + "\"" + " ");
				}
				
				if(IncludeBSlash.isSelected())
				{
					exclusions = (exclusions + "\\" + " ");
				}
				
				String startphrase = textArea.getText();
				
				Main.Generator(passover,exclusions,startphrase);
				
				String output = Main.passwords;
				
				
				textOutput.setText(output);
			}
		});
		
		JPanel dictionary = new JPanel();
		dictionary.setBackground(Color.WHITE);
		tabbedPane.addTab("Dictionary", null, dictionary, null);
		dictionary.setLayout(null);
		
		JScrollPane dicScrollPane = new JScrollPane();
		dicScrollPane.setBounds(23, 74, 714, 326);
		dictionary.add(dicScrollPane);
		
		JSpinner numberOfWordsSlider = new JSpinner();
		numberOfWordsSlider.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		numberOfWordsSlider.setBounds(104, 34, 42, 29);
		dictionary.add(numberOfWordsSlider);
		
		JLabel numberOfWordsLabel = new JLabel("No.Words");
		numberOfWordsLabel.setBounds(23, 41, 96, 13);
		dictionary.add(numberOfWordsLabel);
		
		JTextPane dictionaryOutput = new JTextPane();
		dictionaryOutput.setForeground(Color.WHITE);
		dictionaryOutput.setBackground(Color.BLACK);
		dicScrollPane.setViewportView(dictionaryOutput);
		
		JTextArea textInputDic = new JTextArea();
		dicScrollPane.setColumnHeaderView(textInputDic);
		textInputDic.setToolTipText("Starting Phrase for the password");
		textInputDic.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		JLabel excludeLabel = new JLabel("Exclude:");
		excludeLabel.setBounds(332, 79, 89, 13);
		panel.add(excludeLabel);
		
		JSpinner numberOfPasswordsSlider = new JSpinner();
		numberOfPasswordsSlider.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		numberOfPasswordsSlider.setBounds(365, 34, 42, 29);
		dictionary.add(numberOfPasswordsSlider);
		
		JLabel numberOfPasswordsLabel = new JLabel("Number of passwords");
		numberOfPasswordsLabel.setBounds(233, 42, 139, 13);
		dictionary.add(numberOfPasswordsLabel);
		
		JLabel additionalTextLabel = new JLabel("Password(s) starting phrase");
		additionalTextLabel.setToolTipText("This Phrase will appear at the start of your generated passwords, this can help identify what they are used for");
		additionalTextLabel.setBounds(53, 214, 166, 13);
		panel.add(additionalTextLabel);
		
		JRadioButton addNumButton = new JRadioButton("Add Numers to end");
		addNumButton.setSelected(true);
		addNumButton.setBounds(441, 37, 166, 23);
		dictionary.add(addNumButton);
		
		JButton dictionaryCreateButton = new JButton("Create");
		dictionaryCreateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String startphrase = textInputDic.getText();
				int numberOfWords = (int) numberOfWordsSlider.getValue();
				int numberOfPasswords = (int) numberOfPasswordsSlider.getValue();
				Boolean numbers;
				
				
				if(addNumButton.isSelected()) {
					numbers = true;
				}
				
				else {
					numbers = false;
					
				}
				
				
				try {
					Main.GeneratorTwo(numberOfWords,numberOfPasswords,startphrase,numbers);
					
					String output = Main.passwords;
					
					
					dictionaryOutput.setText(output);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		dictionaryCreateButton.setBackground(Color.WHITE);
		dictionaryCreateButton.setBounds(625, 38, 96, 20);
		dictionary.add(dictionaryCreateButton);		
		
		
		
	}
}
