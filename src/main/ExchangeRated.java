package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class ExchangeRated extends JFrame {

	private static double WON_AMERICA = 1230 ;
	private static double WON_JAPAN = 979 ;
	
	private JPanel contentPane;
	private JTextField moneyValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExchangeRated frame = new ExchangeRated();
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
	public ExchangeRated() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		moneyValue = new JTextField();
		moneyValue.setBounds(60, 98, 114, 35);
		contentPane.add(moneyValue);
		moneyValue.setColumns(10);
		
		JComboBox Money = new JComboBox();
		Money.setModel(new DefaultComboBoxModel(new String[] {"달러", "엔"}));
		Money.setBounds(190, 100, 80, 35);
		contentPane.add(Money);
		
		JLabel lblNewLabel = new JLabel("결과값 출력");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(300, 95, 124, 28);
		contentPane.add(lblNewLabel);
		
		JButton Exchange = new JButton("환산하기");
		Exchange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String exMoney = Money.getSelectedItem().toString();
				System.out.println(exMoney);
				int mv = Integer.parseInt(moneyValue.getText());
				
				if(exMoney.equals("달러")) {
					double Dollar = mv * WON_AMERICA ;
					double ResultDollar = Math.floor(Dollar);
					System.out.println(ResultDollar);
					lblNewLabel.setText(Double.toString(ResultDollar));
				} else {
					double En = mv * WON_JAPAN ;
					double ResultEn = Math.floor(En);
					System.out.println(ResultEn);
					lblNewLabel.setText(Double.toString(ResultEn));
				}
				
			}
		});
		Exchange.setBounds(156, 170, 105, 28);
		contentPane.add(Exchange);
		
		
	}
}
