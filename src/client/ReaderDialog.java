package client;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

 import javax.swing.*;
import javax.swing.event.*;

import server.SqlHelp;
public class ReaderDialog extends JDialog implements ActionListener
{
	JLabel jl1,jl2,jl3,jl4;
	JTextField jtf1,jtf2,jtf3,jtf4;
	JButton jb1,jb2;
	JPanel jp1,jp2,jp3;
	
	public ReaderDialog()
	{
		super();
		jl1 = new JLabel("编号");
		jl2 = new JLabel("性别");
		jl3 = new JLabel("名字");
		jl4 = new JLabel("学院");
		
		
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		jtf4 = new JTextField();
				
		jb1 = new JButton("添加");
		jb1.addActionListener(this);
		jb2 = new JButton("取消");
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

		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);

		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2, BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);
		this.setSize(300, 200);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==jb1)
		{
			SqlHelp sq = new SqlHelp();
			String strinsert = "insert into reader values(?,?,?,?)";
			
			try 
			{
				sq.ps = sq.ct.prepareStatement(strinsert);
				
				sq.ps.setString(1, jtf1.getText());
				sq.ps.setString(2, jtf2.getText());
				sq.ps.setString(3, jtf3.getText());
				sq.ps.setString(4, jtf4.getText());

				
				sq.ps.executeUpdate();
				
				this.dispose();
				
			} catch (SQLException e) 
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
