package client;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class MainDefault extends JFrame implements ActionListener
{
	
	JPanel jp1,jp2,jp3;
	JButton jb1,jb2,jb3,jb4;
	JTextField jtf;
	JLabel jl;
	JTable jt;
	JScrollPane jsp;
	Vector rowData, cloumnNames;
	
	PreparedStatement ps = null;
	Connection con = null;
	ResultSet rs = null;
	
	public static void main(String[] args)
	{
		MainDefault md = new MainDefault();
	}
	
	public MainDefault()
	{
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jb1 = new JButton("查询");
		jb2 = new JButton("添加");
		jb3 = new JButton("修改");
		jb4 = new JButton("删除");
		
		jtf = new JTextField(10);
		jl  = new JLabel("请输入名字");
		
		jp1.add(jl);
		jp1.add(jtf);
		jp1.add(jb1);
		
		
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		
		
		rowData = new Vector();
		cloumnNames = new Vector();
		cloumnNames.add("学号");
		cloumnNames.add("学号");
		cloumnNames.add("学号");
		cloumnNames.add("学号");
		cloumnNames.add("学号");
		cloumnNames.add("学号");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8","root","root");
			ps = con.prepareStatement("select * from stus");
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Vector hang = new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getString(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				
				rowData.add(hang);
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(con!=null)con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		jt = new JTable(rowData, cloumnNames);
		jsp = new JScrollPane(jt);
		
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.SOUTH);
		this.add(jsp,BorderLayout.CENTER);
		
		this.setTitle("管理系统");
		//this.setSize(400, 300);
		this.setBounds(400, 100,400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}


	public void actionPerformed(ActionEvent arg0) 
	{
		
		
		
		
		
	}
}
