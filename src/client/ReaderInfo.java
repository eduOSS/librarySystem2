package client;
import java.awt.*;
import javax.swing.*;
public class ReaderInfo extends JPanel
{
	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2,jl3,jl4,jls;
	JButton jb1;
	JTextField jtf1,jtf2,jtf3,jtf4;
	JScrollPane jsp;
	public ReaderInfo()
	{
		jls = new JLabel("������Ϣ");
		jl1 = new JLabel("��ţ�");
		jl2 = new JLabel("������");
		jl3 = new JLabel("�Ա�");
		jl4 = new JLabel("ѧԺ��");
		jb1 = new JButton("�޸�");
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		jtf4 = new JTextField();
		
		jp1 = new JPanel();
		jp1.add(jls,BorderLayout.WEST);
		jp2 = new JPanel(new GridLayout(4,1));
		jp2.add(jl1);
		jp2.add(jtf1);
		jp2.add(jl2);
		jp2.add(jtf2);
		jp2.add(jl3);
		jp2.add(jtf3);
		jp2.add(jl4);
		jp2.add(jtf4);
		jsp = new JScrollPane();
		jsp.add(jp2);
		jp3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp3.add(jb1);
		
		this.setLayout(new BorderLayout());
		this.add(jp1, BorderLayout.NORTH);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);
		this.setVisible(true);
		
		
		
		
	}

}
