package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.ExchangeDB;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Regist extends JFrame {

	private JPanel contentPane;
	private JTextField text_ID;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Regist frame = new Regist();
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
	public Regist() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		text_ID = new JTextField();
		text_ID.setLocation(150, 47);
		text_ID.setSize(200, 27);
		text_ID.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(text_ID, BorderLayout.CENTER);
		text_ID.setColumns(10);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(150, 108, 200, 27);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(150, 169, 200, 27);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(40, 50, 59, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(31, 115, 79, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호 확인");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2.setBounds(12, 169, 119, 18);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = text_ID.getText();
				String pw = textField.getText();
				String rePW = textField_1.getText();
				
				String resultId = id.trim().replaceAll(" ", "");
				String resultPw = pw.trim().replaceAll(" ", "");
				String resultRePW = rePW.trim().replaceAll(" ", "");
				
				ExchangeDB eDB = new ExchangeDB();
				eDB.insert(resultId, resultRePW);
				boolean idDuplicate = eDB.idDuplicate(resultId);
				
				if(idDuplicate == true) {
					text_ID.setText("");
					textField.setText("");
					textField_1.setText("");
					JOptionPane.showMessageDialog(contentPane, "아이디가 중복됩니다.", "회원가입 불가", 
	        				 JOptionPane.WARNING_MESSAGE);
				} else {
//					JOptionPane.showMessageDialog(contentPane, resultId +"님, 환영합니다..", "로그인", JOptionPane.INFORMATION_MESSAGE);
					if(resultId.equals("") || resultPw.equals("") || resultRePW.equals("")) {
						JOptionPane.showMessageDialog(contentPane, "안돼 임마", "회원가입 불가", JOptionPane.WARNING_MESSAGE);
					} else { 
						if(pw.equals(rePW)) {
							JOptionPane.showMessageDialog(contentPane, resultId +"님, 어서오세요.", "로그인", JOptionPane.INFORMATION_MESSAGE);
					}	else {
						JOptionPane.showMessageDialog(contentPane, "비밀번호를 확인하세요", "회원가입 불가", JOptionPane.WARNING_MESSAGE);
					}
				}	
				}
				
//				if(resultId.equals("") || resultPw.equals("") || resultRePW.equals("")) {
//					JOptionPane.showMessageDialog(contentPane, "안돼 임마", "회원가입 불가", JOptionPane.WARNING_MESSAGE);
//				} else { 
//					if(pw.equals(rePW)) {
//						JOptionPane.showMessageDialog(contentPane, resultId +"님, 어서오세요.", "로그인", JOptionPane.INFORMATION_MESSAGE);
//				}	else {
//					JOptionPane.showMessageDialog(contentPane, "비밀번호를 확인하세요", "회원가입 불가", JOptionPane.WARNING_MESSAGE);
//				}
//			}	
					
		}
	});
		btnNewButton.setBounds(195, 220, 105, 28);
		contentPane.add(btnNewButton);
	}

}
