package server;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class BookInfo extends JPanel implements ActionListener
{
	JPanel p1,p2,p3,p4,p5;
	JLabel jl1,jl2;
	JTextField jtf;
	JButton jb1,jb2,jb3,jb4,jb5;
	JTable jtable;
	JScrollPane jsp;
	BookModel bk,addbook;
	public BookInfo()
	{
		p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jl1 = new JLabel("������ͼ�����֣�");
		jtf = new JTextField(20);
		jb1 = new JButton("��ѯ");
		p1.add(jl1);
		p1.add(jtf);
		p1.add(jb1);
		//zhongjian
		
		bk = new BookModel();
		String[] paras = {"1"};
		bk.query("select bookId,bookName,bookAuthor,bookPublicName,bookIntroduction,bookPublicDate from allbooks where 1=?", paras);
		jtable = new JTable(bk.rows,bk.colums);
		p2 = new JPanel(new BorderLayout());
		jsp = new JScrollPane(jtable);
		//p2.add(jsp);
		
		//xia
		p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jl2 = new JLabel("�ܼ�¼����"+jtable.getRowCount()+"��");
		p3.add(jl2);
		p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jb2 = new JButton("��ϸ��Ϣ");
		jb3 = new JButton("���");
		jb3.addActionListener(this);
		jb4 = new JButton("�޸�");
		jb4.addActionListener(this);
		jb5 = new JButton("ɾ��");
		jb5.addActionListener(this);
		p4.add(jb2);
		p4.add(jb3);
		p4.add(jb4);
		p4.add(jb5);
		p5 = new JPanel(new BorderLayout());
		p5.add(p3,"West");
		p5.add(p4,"East");
		
		this.setLayout(new BorderLayout());
		this.add(p1,BorderLayout.NORTH);
		this.add(jsp,BorderLayout.CENTER);
		this.add(p5,BorderLayout.SOUTH);
		this.setBackground(Color.PINK);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(jb5==arg0.getSource())
		{
			int selRowNum=jtable.getSelectedRow();
			String bookNo =(String)bk.getValueAt(selRowNum,0);
			if(bk.delebook(bookNo))
			{
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "ɾ�����ɹ�");
				
			}
			
			String[] paras = {"1"};
			String sql = "select bookId,bookName,bookAuthor,bookPublicName,bookIntroduction,bookPublicDate from allbooks where 1=?";
			bk = new BookModel();
			bk.query(sql, paras);
			jtable.setModel(bk);
		}
        if(jb3==arg0.getSource())
		{
			BookDialog bd = new BookDialog();
			//���±��
			
			
		}
        if(arg0.getSource()==jb4)
        {
        	int rowNums = this.jtable.getSelectedRow();
        	if(rowNums == -1)
        	{
        		JOptionPane.showMessageDialog(this,"��ѡ��һ��");
        		return;
        	}
        	BookUpdate bup = new BookUpdate(bk,rowNums);
        	
        }
		
	}
}
