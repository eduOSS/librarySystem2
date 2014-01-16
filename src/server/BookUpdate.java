package server;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

 import javax.swing.*;
import javax.swing.event.*;
public class BookUpdate extends JDialog implements ActionListener
{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7;
	JButton jb1,jb2;
	JPanel jp1,jp2,jp3;
	BookModel bm;
	public BookUpdate(BookModel sm, int rowNums)
	{
		super();
		jl1 = new JLabel("���");
		jl2 = new JLabel("����");
		jl3 = new JLabel("����");
		jl4 = new JLabel("������");
		jl5 = new JLabel("���");
		jl6 = new JLabel("����");
		jl7 = new JLabel("�Ƿ���");
		
		jtf1 = new JTextField();
		jtf1.setText((String)sm.getValueAt(rowNums, 0));
		jtf1.setEditable(false);
		jtf2 = new JTextField();
		jtf2.setText((String)sm.getValueAt(rowNums, 1));
		jtf3 = new JTextField();
		jtf3.setText((String)sm.getValueAt(rowNums, 2));
		jtf4 = new JTextField();
		jtf4.setText((String)sm.getValueAt(rowNums, 3));
		jtf5 = new JTextField();
		jtf5.setText((String)sm.getValueAt(rowNums, 4));
		jtf6 = new JTextField();
		jtf6.setText((String)sm.getValueAt(rowNums, 5));
		jtf7 = new JTextField();
		jtf7.setText("1");
		
		jb1 = new JButton("�޸�");
		jb1.addActionListener(this);
		jb2 = new JButton("ȡ��");
		jb2.addActionListener(this);
		
		jp1 = new JPanel();
		jp1.setLayout(new GridLayout(7,1));
		jp2 = new JPanel();
		jp2.setLayout(new GridLayout(7,1));
		jp3 = new JPanel();
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		jp1.add(jl7);
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		jp2.add(jtf7);
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2, BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);
		this.setSize(350, 250);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==jb1)
		{
			SqlHelp sq = new SqlHelp();
			String strupdate = "update allbooks set bookName=?,bookAuthor=?,bookPublicName=?,bookIntroduction=?,bookPublicDate=?,bookInOut=? where bookId=?";
			
			try 
			{
				sq.ps = sq.ct.prepareStatement(strupdate);
				
				sq.ps.setString(1, jtf2.getText());
				sq.ps.setString(2, jtf3.getText());
				sq.ps.setString(3, jtf4.getText());
				sq.ps.setString(4, jtf5.getText());
				sq.ps.setString(5, jtf6.getText());
				sq.ps.setString(6, jtf7.getText());
				sq.ps.setString(7, jtf1.getText());
				
				sq.ps.executeUpdate();
				
				this.dispose();
				
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
			finally
			{
				sq.close();
			}
		}
		else if(arg0.getSource()==jb2)
		{
			this.dispose();
		}
		

		
	}

}
