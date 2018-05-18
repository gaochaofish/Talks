package testsocket;

import testsocket.bean.User;
import testsocket.dao.impl.DaoImpl;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

public class Register {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_3;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;

    /**
     * Launch the application.
     */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

    /**
     * Create the application.
     */
    public Register() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("\u6CE8\u518C\u754C\u9762");
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        JLabel label = new JLabel("\u8D26\u53F7");
        label.setBounds(113, 43, 69, 20);
        frame.getContentPane().add(label);

        textField = new JTextField();
        textField.setBounds(263, 40, 146, 26);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel label_1 = new JLabel("\u5BC6\u7801");
        label_1.setBounds(113, 85, 69, 20);
        frame.getContentPane().add(label_1);

        JLabel label_2 = new JLabel("\u5BC6\u7801\u786E\u8BA4");
        label_2.setBounds(113, 130, 69, 20);
        frame.getContentPane().add(label_2);

        JLabel label_3 = new JLabel("\u6CE8\u518C\u7801");
        label_3.setBounds(113, 172, 69, 20);
        frame.getContentPane().add(label_3);

        textField_3 = new JTextField();
        textField_3.setBounds(263, 169, 146, 26);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        final JButton button = new JButton("\u6CE8\u518C");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                DaoImpl dao=new DaoImpl();

                if(!passwordField.getText().equals(passwordField_1.getText())) {
                    JOptionPane.showMessageDialog(null, "两次密码必须相同！！！", "error", JOptionPane.ERROR_MESSAGE);



                }
                else {
                    User user=new User(textField.getText(),passwordField.getText());

                    boolean temp=false;
                    try {
                        temp=dao.register(user);
                    } catch (PropertyVetoException e1) {
                        e1.printStackTrace();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                    if(temp)
                        JOptionPane.showMessageDialog(null, "注册成功", "ok", JOptionPane.ERROR_MESSAGE);

                }

            }
        });
        button.setBounds(174, 230, 115, 29);
        frame.getContentPane().add(button);

        passwordField = new JPasswordField();
        passwordField.setBounds(263, 82, 148, 26);
        frame.getContentPane().add(passwordField);

        passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(263, 127, 146, 26);
        frame.getContentPane().add(passwordField_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 284, 478, 160);
        frame.getContentPane().add(scrollPane);

        JTextArea textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
    }
}
