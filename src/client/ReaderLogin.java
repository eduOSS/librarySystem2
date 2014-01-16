package client;
//ϵͳ����Ա���Խ��Ĳ�������
import java.awt.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.Timer;
import java.awt.event.*;

import javax.swing.*;
import javax.imageio.*;
public class ReaderLogin extends JFrame implements ActionListener
{
	JMenuBar jmb;
	JToolBar jtb;
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	JMenuItem jmi1,jmi2,jmi3,jmi4;
	JPanel jp1,jp2,jp3,jp4;
	JLabel jp5_lab1,jp5_lab2,jp5_lab3;
	JLabel timeNow;
	JTabbedPane jtp;
	Timer t;
	Font f1 = new Font("����",Font.PLAIN,14);
	Font f2 = new Font("����",Font.PLAIN,12);
	public static void main(String[] args)
	{
		ReaderLogin readerlogin = new ReaderLogin();
	}
	
	public ReaderLogin()
	{
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		jm1 = new JMenu("����");
		jm1.setFont(f1);
		jmi1 = new JMenuItem("��Ա��ѯ");
		jmi1.setFont(f2);
		jmi2 = new JMenuItem("�л��û�");
		jmi2.setFont(f2);
		jmi3 = new JMenuItem("������");
		jmi3.setFont(f2);
		jmi4 = new JMenuItem("�˳�");
		jmi4.setFont(f2);
		
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jm1.add(jmi4);
		
		jm2 = new JMenu("����");
		jm2.setFont(f1);
		jm3 = new JMenu("����");
		jm3.setFont(f1);
		jm4 = new JMenu("��ѯ");
		jm4.setFont(f1);
		//jm5 = new JMenu("ά��");
		//jm5.setFont(f1);
		jm6 = new JMenu("����");
		jm6.setFont(f1);
		
		jmb = new JMenuBar();
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		//jmb.add(jm5);
		jmb.add(jm6);
		
		jtb = new JToolBar();
		jtb.setFloatable(false);
		jb1 = new JButton(new ImageIcon("image/jb1.png"));
		jb1.setToolTipText("Open");
		jb2 = new JButton(new ImageIcon("image/jb2.png"));
		jb2.setToolTipText("New");
		jb3 = new JButton(new ImageIcon("image/jb3.png"));
		jb3.setToolTipText("My information");
		jb4 = new JButton(new ImageIcon("image/jb4.png"));
		jb4.setToolTipText("My book");
		jb5 = new JButton(new ImageIcon("image/jb5.png"));
		jb5.setToolTipText("Check");
		jb6 = new JButton(new ImageIcon("image/jb6.png"));
		jb6.setToolTipText("Exit");
		jtb.add(jb1);
		jtb.add(jb2);
		jtb.add(jb3);
		jtb.add(jb4);
		jtb.add(jb5);
		jtb.add(jb6);
		
		ImageIcon bg = new ImageIcon("image/bg.png");
		jtp = new JTabbedPane();
		jtp.setFont(f1);
		jp1 = new JPanel(new BorderLayout());
		jp1.setBackground(Color.GREEN);
		
		ReaderInfo readerinfo = new ReaderInfo();
		jp1.add(readerinfo);
		jp2 = new JPanel(new BorderLayout());
		jp2.setBackground(Color.ORANGE);
		jp3 = new JPanel(new BorderLayout());
		jp3.setBackground(Color.CYAN);
		
		jtp.add("�ҵ���Ϣ",jp1);
		jtp.add("�ҵ�ͼ����Ϣ",jp2);
		jtp.add("����ͼ��",jp3);
		
		jp4 = new JPanel();
		t = new Timer(1000,this);
		t.start();
		timeNow = new JLabel("��ǰʱ�䣺"+Calendar.getInstance().getTime().toString());
		timeNow.setFont(f2);
		jp4.add(timeNow);
		
		
		Container con = this.getContentPane();
		con.add(jtb,"North");
		con.add(jtp,"Center");
		con.add(jp4,"South");
		this.setJMenuBar(jmb);
		this.setTitle("ͼ�����ϵͳ");
		//this.setSize(w-700, h-100);
		this.setBounds(100, 0, w-1000, h-400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		this.timeNow.setText(Calendar.getInstance().getTime().toString());
	}
}
