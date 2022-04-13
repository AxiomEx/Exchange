package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.ExchangeDB;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField text_loginID;
	private JTextField textField;
	private JButton RegiBtn;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		text_loginID = new JTextField();
		text_loginID.setHorizontalAlignment(SwingConstants.CENTER);
		text_loginID.setBounds(106, 85, 200, 32);
		contentPane.add(text_loginID, BorderLayout.CENTER);
		text_loginID.setColumns(10);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(106, 140, 200, 32);
		contentPane.add(textField);
		
		JButton LoginBtn = new JButton("로그인");
		LoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String loginID = text_loginID.getText();
	      		String loginPW = textField.getText();
				
	      		System.out.println(loginID);
	      		System.out.println(loginPW);
	      		
	      		ExchangeDB eDB = new ExchangeDB();
	      		int loginResult = eDB.loginER(loginID, loginPW);
	      		if(loginResult == 1000) {
	      			ExchangeRated ER = new ExchangeRated();
	      			ER.setVisible(true);
	      			setVisible(false);
	      			System.out.println("다른 창");
	      		} else {
	      			JOptionPane.showMessageDialog(contentPane, "없는 아이디이거나 틀린 비밀번호입니다.", "회원가입 불가", JOptionPane.WARNING_MESSAGE);
	      			System.out.println("실패");
	      		}
	      		
			}
		});
		LoginBtn.setBounds(318, 95, 110, 69);
		contentPane.add(LoginBtn);
		
		RegiBtn = new JButton("회원가입");
		RegiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Regist rf = new Regist();
	            rf.setVisible(true);
	            setVisible(false);
			}
		});
		RegiBtn.setBounds(156, 181, 105, 28);
		contentPane.add(RegiBtn);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(29, 85, 82, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(20, 135, 82, 32);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("환율 계산기");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel_2.setBounds(139, 23, 167, 32);
		contentPane.add(lblNewLabel_2);
	}
}
