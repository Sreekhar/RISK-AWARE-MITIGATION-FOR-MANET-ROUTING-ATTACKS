import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Random;

class Project extends JFrame implements ActionListener
{
ImageIcon i1;
JLabel l1;
JButton jb1,jb2;
Container con;
Project(String str)
	{
	super(str);
	con=getContentPane();
	con.setLayout(null);
	con.setBackground(Color.white);
	i1=new ImageIcon("Sample.png");
	l1=new JLabel("",i1,JLabel.LEFT);
	jb1=new JButton("PRESS HERE -->>");
	jb2=new JButton("EXIT");
	l1.setBounds(90,30,480,90);
	jb1.setBounds(115,180,140,20);
	jb2.setBounds(360,180,80,20);
	con.add(l1);
	con.add(jb1);
	con.add(jb2);
	jb1.addActionListener(this);
	jb2.addActionListener(this);
	}

public void actionPerformed(ActionEvent ae)
	{
	if(ae.getActionCommand().equals("EXIT"))
		{
			JOptionPane.showMessageDialog(this,"CLOSING.\nCLICK OK.");
			System.exit(0);
		}
	else if(ae.getActionCommand().equals("PRESS HERE -->>"))
		{
			JOptionPane.showMessageDialog(this,"PROCESSING YOUR REQUEST.\nCLICK OK.");
			setVisible(false);
			NodesFrame a=new NodesFrame("MOBILE COMPUTING 3.3.1v");
			a.setSize(600,350);
			a.setLocation(200,200);
			a.setResizable(false);
			a.setVisible(true);
		}
	}
}

class NodesFrame extends JFrame implements ActionListener
{
JLabel l1,l2,l3;
JButton jb1,jb2;
JTextField t1;
Container con;
int i;
NodesFrame(String str)
	{
	super(str);
	con=getContentPane();
	con.setLayout(null);
	con.setBackground(Color.white);
	l1=new JLabel("Enter the number of nodes you want to create --> ");
	l2=new JLabel("NOTE : Only 1 attacker possible");
	l3=new JLabel("NOTE : Select nodes between 5-10 only");
	t1=new JTextField();
	jb1=new JButton("NEXT -->>");
	jb2=new JButton("EXIT");
	l1.setBounds(90,1,280,90);
	l2.setBounds(180,230,400,90);
	l3.setBounds(90,30,280,90);
	jb1.setBounds(180,150,100,20);
	jb2.setBounds(350,150,80,20);
	t1.setBounds(380,30,50,30);
	con.add(l1);
	con.add(l2);
	con.add(l3);
	con.add(jb1);
	con.add(jb2);
	con.add(t1);
	jb1.addActionListener(this);
	jb2.addActionListener(this);
	}

public void actionPerformed(ActionEvent ae)
	{
	if(ae.getActionCommand().equals("EXIT"))
		{
			JOptionPane.showMessageDialog(this,"CLOSING.\nCLICK OK.");
			System.exit(0);
		}
	else if(ae.getActionCommand().equals("NEXT -->>"))
		{
			if((t1.getText().trim()).equals(""))
				{
				JOptionPane.showMessageDialog(this,"ENTER A VALID NUMBER BETWEEN 5-10.\nCLICK OK.");
				setVisible(false);
				NodesFrame a=new NodesFrame("MOBILE COMPUTING 3.3.1v");
				a.setSize(600,350);
				a.setLocation(200,200);
				a.setResizable(false);
				a.setVisible(true);
				}
			else if((t1.getText().trim()).equals("5") || (t1.getText().trim()).equals("6") || (t1.getText().trim()).equals("7") || (t1.getText().trim()).equals("8") || (t1.getText().trim()).equals("9") || (t1.getText().trim()).equals("10"))
				{
				setVisible(false);
				i=Integer.parseInt(t1.getText().trim());
				NodesFrameSet nfs=new NodesFrameSet("MOBILE COMPUTING 3.3.1v",i);
				Toolkit tk = Toolkit.getDefaultToolkit();  
				int xSize = ((int) tk.getScreenSize().getWidth());  
				int ySize = ((int) tk.getScreenSize().getHeight());  
				nfs.setSize(xSize,ySize);  				
				nfs.setResizable(false);
				nfs.setVisible(true);
				}
			else
				{
				JOptionPane.showMessageDialog(this,"ENTER A VALID NUMBER BETWEEN 5-10.\nCLICK OK.");
				setVisible(false);
				NodesFrame a=new NodesFrame("MOBILE COMPUTING 3.3.1v");
				a.setSize(600,350);
				a.setLocation(200,200);
				a.setResizable(false);
				a.setVisible(true);
				}
		}
	}
}

class NodesFrameSet extends JFrame implements ActionListener
{
ImageIcon i1,i2;
JLabel l1,l2,l3;
JButton jb1,jb2,jb3;
JCheckBox[] checkBoxes=new JCheckBox[10];
Container con;
int x,y,k,temp;
int[] x1 = new int[10];
int[] y1 = new int[10];
NodesFrameSet(String str,int i)
	{
	super(str);
	k=i;
	con=getContentPane();
	con.setLayout(null);
	con.setBackground(Color.white);
	i1=new ImageIcon("image1.png");
	i2=new ImageIcon("offButton.png");
	l1=new JLabel("",i1,JLabel.LEFT);
	l2=new JLabel("NOTE1 : Drag all the nodes.");
	l3=new JLabel("Drag and Place your nodes at desired position");
	jb1=new JButton("NEXT -->>");
	jb2=new JButton("EXIT");
	jb3=new JButton("BACK");
	for(int j=0;j<i;j++)
		{
		checkBoxes[j]=new JCheckBox(""+j,i2);
		checkBoxes[j].setBounds(90+(j*70),350,55,45);
		checkBoxes[j].setBackground(Color.white);
		con.add(checkBoxes[j]);
		}
	l1.setBounds(300,10,500,90);
	l2.setBounds(460,670,400,90);
	l3.setBounds(430,70,280,90);
	jb1.setBounds(500,640,100,20);
	jb2.setBounds(650,640,80,20);
	jb3.setBounds(350,640,80,20);
	con.add(l1);
	con.add(l2);
	con.add(l3);
	con.add(jb1);
	con.add(jb2);
	con.add(jb3);
	jb1.addActionListener(this);
	jb2.addActionListener(this);
	jb3.addActionListener(this);
	if(i==5)
		{
		checkBoxes[0].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[0].setBounds(me.getX()+90,me.getY()+350,55,45);
			    }
			});
		checkBoxes[0].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[0]=me.getX()+90;
					 y1[0]=me.getY()+350;
			    }
			});
		checkBoxes[1].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[1].setBounds(me.getX()+160,me.getY()+350,55,45);
			    }
			});
		checkBoxes[1].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[1]=me.getX()+160;
					 y1[1]=me.getY()+350;
			    }
			});
		checkBoxes[2].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[2].setBounds(me.getX()+230,me.getY()+350,55,45);
			    }
			});
		checkBoxes[2].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[2]=me.getX()+230;
					 y1[2]=me.getY()+350;
			    }
			});
		checkBoxes[3].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[3].setBounds(me.getX()+300,me.getY()+350,55,45);
			    }
			});
		checkBoxes[3].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[3]=me.getX()+300;
					 y1[3]=me.getY()+350;
			    }
			});
		checkBoxes[4].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[4].setBounds(me.getX()+370,me.getY()+350,55,45);
			    }
			});
		checkBoxes[4].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[4]=me.getX()+370;
					 y1[4]=me.getY()+350;
			    }
			});
		}
	if(i==6)
		{
		checkBoxes[0].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[0].setBounds(me.getX()+90,me.getY()+350,55,45);
			    }
			});
		checkBoxes[0].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[0]=me.getX()+90;
					 y1[0]=me.getY()+350;
			    }
			});
		checkBoxes[1].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[1].setBounds(me.getX()+160,me.getY()+350,55,45);
			    }
			});
		checkBoxes[1].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[1]=me.getX()+160;
					 y1[1]=me.getY()+350;
			    }
			});
		checkBoxes[2].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[2].setBounds(me.getX()+230,me.getY()+350,55,45);
			    }
			});
		checkBoxes[2].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[2]=me.getX()+230;
					 y1[2]=me.getY()+350;
			    }
			});
		checkBoxes[3].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[3].setBounds(me.getX()+300,me.getY()+350,55,45);
			    }
			});
		checkBoxes[3].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[3]=me.getX()+300;
					 y1[3]=me.getY()+350;
			    }
			});
		checkBoxes[4].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[4].setBounds(me.getX()+370,me.getY()+350,55,45);
			    }
			});
		checkBoxes[4].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[4]=me.getX()+370;
					 y1[4]=me.getY()+350;
			    }
			});
		checkBoxes[5].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[5].setBounds(me.getX()+440,me.getY()+350,55,45);
			    }
			});
		checkBoxes[5].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[5]=me.getX()+440;
					 y1[5]=me.getY()+350;
			    }
			});
		}
	if(i==7)
		{
		checkBoxes[0].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[0].setBounds(me.getX()+90,me.getY()+350,55,45);
			    }
			});
		checkBoxes[0].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[0]=me.getX()+90;
					 y1[0]=me.getY()+350;
			    }
			});
		checkBoxes[1].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[1].setBounds(me.getX()+160,me.getY()+350,55,45);
			    }
			});
		checkBoxes[1].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[1]=me.getX()+160;
					 y1[1]=me.getY()+350;
			    }
			});
		checkBoxes[2].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[2].setBounds(me.getX()+230,me.getY()+350,55,45);
			    }
			});
		checkBoxes[2].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[2]=me.getX()+230;
					 y1[2]=me.getY()+350;
			    }
			});
		checkBoxes[3].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[3].setBounds(me.getX()+300,me.getY()+350,55,45);
			    }
			});
		checkBoxes[3].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[3]=me.getX()+300;
					 y1[3]=me.getY()+350;
			    }
			});
		checkBoxes[4].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[4].setBounds(me.getX()+370,me.getY()+350,55,45);
			    }
			});
		checkBoxes[4].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[4]=me.getX()+370;
					 y1[4]=me.getY()+350;
			    }
			});
		checkBoxes[5].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[5].setBounds(me.getX()+440,me.getY()+350,55,45);
			    }
			});
		checkBoxes[5].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[5]=me.getX()+440;
					 y1[5]=me.getY()+350;
			    }
			});
		checkBoxes[6].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[6].setBounds(me.getX()+510,me.getY()+350,55,45);
			    }
			});
		checkBoxes[6].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[6]=me.getX()+510;
					 y1[6]=me.getY()+350;
			    }
			});
		}
	if(i==8)
		{
		checkBoxes[0].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[0].setBounds(me.getX()+90,me.getY()+350,55,45);
			    }
			});
		checkBoxes[0].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[0]=me.getX()+90;
					 y1[0]=me.getY()+350;
			    }
			});
		checkBoxes[1].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[1].setBounds(me.getX()+160,me.getY()+350,55,45);
			    }
			});
		checkBoxes[1].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[1]=me.getX()+160;
					 y1[1]=me.getY()+350;
			    }
			});
		checkBoxes[2].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[2].setBounds(me.getX()+230,me.getY()+350,55,45);
			    }
			});
		checkBoxes[2].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[2]=me.getX()+230;
					 y1[2]=me.getY()+350;
			    }
			});
		checkBoxes[3].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[3].setBounds(me.getX()+300,me.getY()+350,55,45);
			    }
			});
		checkBoxes[3].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[3]=me.getX()+300;
					 y1[3]=me.getY()+350;
			    }
			});
		checkBoxes[4].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[4].setBounds(me.getX()+370,me.getY()+350,55,45);
			    }
			});
		checkBoxes[4].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[4]=me.getX()+370;
					 y1[4]=me.getY()+350;
			    }
			});
		checkBoxes[5].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[5].setBounds(me.getX()+440,me.getY()+350,55,45);
			    }
			});
		checkBoxes[5].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[5]=me.getX()+440;
					 y1[5]=me.getY()+350;
			    }
			});
		checkBoxes[6].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[6].setBounds(me.getX()+510,me.getY()+350,55,45);
			    }
			});
		checkBoxes[6].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[6]=me.getX()+510;
					 y1[6]=me.getY()+350;
			    }
			});
		checkBoxes[7].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[7].setBounds(me.getX()+580,me.getY()+350,55,45);
			    }
			});
		checkBoxes[7].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[7]=me.getX()+580;
					 y1[7]=me.getY()+350;
			    }
			});
		}
	if(i==9)
		{
		checkBoxes[0].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[0].setBounds(me.getX()+90,me.getY()+350,55,45);
			    }
			});
		checkBoxes[0].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[0]=me.getX()+90;
					 y1[0]=me.getY()+350;
			    }
			});
		checkBoxes[1].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[1].setBounds(me.getX()+160,me.getY()+350,55,45);
			    }
			});
		checkBoxes[1].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[1]=me.getX()+160;
					 y1[1]=me.getY()+350;
			    }
			});
		checkBoxes[2].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[2].setBounds(me.getX()+230,me.getY()+350,55,45);
			    }
			});
		checkBoxes[2].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[2]=me.getX()+230;
					 y1[2]=me.getY()+350;
			    }
			});
		checkBoxes[3].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[3].setBounds(me.getX()+300,me.getY()+350,55,45);
			    }
			});
		checkBoxes[3].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[3]=me.getX()+300;
					 y1[3]=me.getY()+350;
			    }
			});
		checkBoxes[4].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[4].setBounds(me.getX()+370,me.getY()+350,55,45);
			    }
			});
		checkBoxes[4].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[4]=me.getX()+370;
					 y1[4]=me.getY()+350;
			    }
			});
		checkBoxes[5].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[5].setBounds(me.getX()+440,me.getY()+350,55,45);
			    }
			});
		checkBoxes[5].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[5]=me.getX()+440;
					 y1[5]=me.getY()+350;
			    }
			});
		checkBoxes[6].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[6].setBounds(me.getX()+510,me.getY()+350,55,45);
			    }
			});
		checkBoxes[6].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[6]=me.getX()+510;
					 y1[6]=me.getY()+350;
			    }
			});
		checkBoxes[7].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[7].setBounds(me.getX()+580,me.getY()+350,55,45);
			    }
			});
		checkBoxes[7].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[7]=me.getX()+580;
					 y1[7]=me.getY()+350;
			    }
			});
		checkBoxes[8].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[8].setBounds(me.getX()+650,me.getY()+350,55,45);
			    }
			});
		checkBoxes[8].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[8]=me.getX()+650;
					 y1[8]=me.getY()+350;
			    }
			});
		}
	if(i==10)
		{
		checkBoxes[0].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[0].setBounds(me.getX()+90,me.getY()+350,55,45);
			    }
			});
		checkBoxes[0].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[0]=me.getX()+90;
					 y1[0]=me.getY()+350;
			    }
			});
		checkBoxes[1].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[1].setBounds(me.getX()+160,me.getY()+350,55,45);
			    }
			});
		checkBoxes[1].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[1]=me.getX()+160;
					 y1[1]=me.getY()+350;
			    }
			});
		checkBoxes[2].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[2].setBounds(me.getX()+230,me.getY()+350,55,45);
			    }
			});
		checkBoxes[2].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[2]=me.getX()+230;
					 y1[2]=me.getY()+350;
			    }
			});
		checkBoxes[3].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[3].setBounds(me.getX()+300,me.getY()+350,55,45);
			    }
			});
		checkBoxes[3].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[3]=me.getX()+300;
					 y1[3]=me.getY()+350;
			    }
			});
		checkBoxes[4].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[4].setBounds(me.getX()+370,me.getY()+350,55,45);
			    }
			});
		checkBoxes[4].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[4]=me.getX()+370;
					 y1[4]=me.getY()+350;
			    }
			});
		checkBoxes[5].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[5].setBounds(me.getX()+440,me.getY()+350,55,45);
			    }
			});
		checkBoxes[5].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[5]=me.getX()+440;
					 y1[5]=me.getY()+350;
			    }
			});
		checkBoxes[6].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[6].setBounds(me.getX()+510,me.getY()+350,55,45);
			    }
			});
		checkBoxes[6].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[6]=me.getX()+510;
					 y1[6]=me.getY()+350;
			    }
			});
		checkBoxes[7].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[7].setBounds(me.getX()+580,me.getY()+350,55,45);
			    }
			});
		checkBoxes[7].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[7]=me.getX()+580;
					 y1[7]=me.getY()+350;
			    }
			});
		checkBoxes[8].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[8].setBounds(me.getX()+650,me.getY()+350,55,45);
			    }
			});
		checkBoxes[8].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[8]=me.getX()+650;
					 y1[8]=me.getY()+350;
			    }
			});
		checkBoxes[9].addMouseMotionListener(new MouseMotionAdapter() {
				 @Override
				public void mouseDragged(MouseEvent me) {
				checkBoxes[9].setBounds(me.getX()+720,me.getY()+350,55,45);
			    }
			});
		checkBoxes[9].addMouseListener(new MouseAdapter() {
				 @Override
				public void mouseReleased(MouseEvent me) {
					 x1[9]=me.getX()+720;
					 y1[9]=me.getY()+350;
			    }
			});
		}
	}

public void actionPerformed(ActionEvent ae)
	{
	if(ae.getActionCommand().equals("EXIT"))
		{
			JOptionPane.showMessageDialog(this,"CLOSING.\nCLICK OK.");
			System.exit(0);
		}
	else if(ae.getActionCommand().equals("BACK"))
		{
			JOptionPane.showMessageDialog(this,"BACK TO THE PREVIOUS FRAME");
			setVisible(false);
			NodesFrame a=new NodesFrame("MOBILE COMPUTING 3.3.1v");
			a.setSize(600,350);
			a.setLocation(200,200);
			a.setResizable(false);
			a.setVisible(true);
		}
	else if(ae.getActionCommand().equals("NEXT -->>"))
		{
		for(int j=0;j<k;j++)
			{
			if(x1[j]==0 && y1[j]==0)
				{
				JOptionPane.showMessageDialog(this,"Drag all the nodes.\nCLICK OK.");
				setVisible(false);
				NodesFrameSet nfs=new NodesFrameSet("MOBILE COMPUTING 3.3.1v",k);
				Toolkit tk = Toolkit.getDefaultToolkit();  
				int xSize = ((int) tk.getScreenSize().getWidth());  
				int ySize = ((int) tk.getScreenSize().getHeight());  
				nfs.setSize(xSize,ySize);  				
				nfs.setResizable(false);
				nfs.setVisible(true);
				break;
				}
			else
				temp=1;
			}
			if(temp==1)
			{
				setVisible(false);
				NodeSet ns=new NodeSet("MOBILE COMPUTING 3.3.1v",k,x1,y1);
				Toolkit tk = Toolkit.getDefaultToolkit();  
				int xSize = ((int) tk.getScreenSize().getWidth());  
				int ySize = ((int) tk.getScreenSize().getHeight());  
				ns.setSize(xSize,ySize);  				
				ns.setResizable(false);
				ns.setVisible(true);
			}
		}
	}
}

class NodeSet extends JFrame implements ActionListener
{
ImageIcon i1,i2,i3,i4;
JLabel l1,l2,l3;
JButton jb1,jb2,jb3;
int x,y,k,temp=0,StartNode,EndNode;
JCheckBox[] checkBoxes=new JCheckBox[10];
int[] x2 = new int[10];
int[] y2 = new int[10];
Container con;
NodeSet(String str,int i,int[] x1,int[] y1)
	{
	super(str);
	k=i;
	con=getContentPane();
	con.setLayout(null);
	con.setBackground(Color.white);
	i1=new ImageIcon("image1.png");
	i2=new ImageIcon("offButton.png");
	i3=new ImageIcon("StartNode.jpg");
	i4=new ImageIcon("EndNode.png");
	l1=new JLabel("",i1,JLabel.LEFT);
	l2=new JLabel("NOTE : Only 1 attacker possible");
	l3=new JLabel("Click on NEXT button");
	jb1=new JButton("NEXT -->>");
	jb2=new JButton("EXIT");
	jb3=new JButton("BACK");
	for(int j=0;j<i;j++)
		{
		if(j==0)
			{
			checkBoxes[j]=new JCheckBox("StartNode");
			checkBoxes[j].setIcon(i3);
			checkBoxes[j].setBounds(x1[j],y1[j],105,45);
			x2[j]=x1[j];
			y2[j]=y1[j];
			StartNode=j;
			checkBoxes[j].setBackground(Color.white);
			con.add(checkBoxes[j]);
			checkBoxes[j].addActionListener(this);
			}
		else if(j==(i-1))
			{
			checkBoxes[j]=new JCheckBox("EndNode");
			checkBoxes[j].setIcon(i4);
			checkBoxes[j].setBounds(x1[j],y1[j],105,45);
			x2[j]=x1[j];
			y2[j]=y1[j];
			EndNode=j;
			checkBoxes[j].setBackground(Color.white);
			con.add(checkBoxes[j]);
			checkBoxes[j].addActionListener(this);
			}
		else
			{
			checkBoxes[j]=new JCheckBox(""+j,i2);
			checkBoxes[j].setBounds(x1[j],y1[j],55,45);
			x2[j]=x1[j];
			y2[j]=y1[j];
			checkBoxes[j].setBackground(Color.white);
			con.add(checkBoxes[j]);
			checkBoxes[j].addActionListener(this);
			}
		}
	l1.setBounds(300,10,500,90);
	l2.setBounds(460,670,400,90);
	l3.setBounds(440,70,320,90);
	jb1.setBounds(500,640,100,20);
	jb2.setBounds(650,640,80,20);
	jb3.setBounds(350,640,80,20);
	con.add(l1);
	con.add(l2);
	con.add(l3);
	con.add(jb1);
	con.add(jb2);
	con.add(jb3);
	jb1.addActionListener(this);
	jb2.addActionListener(this);
	jb3.addActionListener(this);
	}

public void actionPerformed(ActionEvent ae)
	{
	if(ae.getActionCommand().equals("EXIT"))
		{
			JOptionPane.showMessageDialog(this,"CLOSING.\nCLICK OK.");
			System.exit(0);
		}
	else if(ae.getActionCommand().equals("BACK"))
		{
			JOptionPane.showMessageDialog(this,"BACK TO THE PREVIOUS FRAME");
			setVisible(false);
			NodesFrameSet nfs=new NodesFrameSet("MOBILE COMPUTING 3.3.1v",k);
			Toolkit tk = Toolkit.getDefaultToolkit();  
			int xSize = ((int) tk.getScreenSize().getWidth());  
			int ySize = ((int) tk.getScreenSize().getHeight());  
			nfs.setSize(xSize,ySize);  				
			nfs.setResizable(false);
			nfs.setVisible(true);
		}
	else if(ae.getActionCommand().equals("NEXT -->>"))
		{
				setVisible(false);
				NetworkSet nes=new NetworkSet("MOBILE COMPUTING 3.3.1v",x2,y2,k,StartNode,EndNode);
				Toolkit tk = Toolkit.getDefaultToolkit();  
				int xSize = ((int) tk.getScreenSize().getWidth());  
				int ySize = ((int) tk.getScreenSize().getHeight());  
				nes.setSize(xSize,ySize);  				
				nes.setResizable(false);
				nes.setVisible(true);
		}
	}
}

class NetworkSet extends JFrame implements ActionListener
{
ImageIcon i1,i2,i3,i4;
JLabel l1,l2,l3;
JButton jb1,jb2,jb3,jb4;
int size,k,temp=0,StartNode,EndNode;
JCheckBox[] checkBoxes=new JCheckBox[10];
int[] x2 = new int[10];
int[] y2 = new int[10];
public static int[] path = new int[10];
int[] connect = new int[10];
Container con;
NetworkSet(String str,int[] x1,int[] y1,int i,int StartNode1,int EndNode1)
	{
	super(str);
	k=i;
	StartNode=StartNode1;
	EndNode=EndNode1;
	con=getContentPane();
	con.setLayout(null);
	con.setBackground(Color.white);
	i1=new ImageIcon("image1.png");
	i2=new ImageIcon("offButton.png");
	i3=new ImageIcon("StartNode.jpg");
	i4=new ImageIcon("EndNode.png");
	l1=new JLabel("",i1,JLabel.LEFT);
	l2=new JLabel("NOTE : Only 1 attacker possible");
	l3=new JLabel("To mention the network path . PRESS HERE ==>> ");
	jb1=new JButton("NEXT -->>");
	jb2=new JButton("CLOSE");
	jb4=new JButton("CLICK");
	for(int j=0;j<i;j++)
		{
		if(j == StartNode)
			{
			checkBoxes[j]=new JCheckBox("StartNode",i3,false);
			checkBoxes[j].setBounds(x1[j],y1[j],105,45);
			x2[j]=x1[j];
			y2[j]=y1[j];
			checkBoxes[j].setBackground(Color.white);
			con.add(checkBoxes[j]);
			}
		else if(j == EndNode)
			{
			checkBoxes[j]=new JCheckBox("EndNode",i4,false);
			checkBoxes[j].setBounds(x1[j],y1[j],105,45);
			x2[j]=x1[j];
			y2[j]=y1[j];
			checkBoxes[j].setBackground(Color.white);
			con.add(checkBoxes[j]);
			}
		else
			{
			checkBoxes[j]=new JCheckBox(""+j,i2,false);
			checkBoxes[j].setBounds(x1[j],y1[j],55,45);
			x2[j]=x1[j];
			y2[j]=y1[j];
			checkBoxes[j].setBackground(Color.white);
			con.add(checkBoxes[j]);
			}
		}
	l1.setBounds(300,10,500,90);
	l2.setBounds(460,670,400,90);
	l3.setBounds(340,70,300,90);
	jb1.setBounds(430,640,100,20);
	jb2.setBounds(580,640,80,20);
	jb4.setBounds(650,105,80,20);
	con.add(l1);
	con.add(l2);
	con.add(l3);
	con.add(jb1);
	con.add(jb2);
	con.add(jb4);
	jb1.addActionListener(this);
	jb2.addActionListener(this);
	jb4.addActionListener(this);
	}

public void actionPerformed(ActionEvent ae)
	{
	if(ae.getActionCommand().equals("CLOSE"))
		{
			JOptionPane.showMessageDialog(this,"CLOSING.\nCLICK OK.");
			System.exit(0);
		}
	else if(ae.getActionCommand().equals("CLICK"))
		{
		if(temp == 0)
			{
			Path pt=new Path("PATH",k,StartNode,EndNode);
			pt.setSize(310,640);  				
			pt.setLocation(700,60);
			pt.setResizable(false);
			pt.setVisible(true);
			temp++;
			}
		else 
			{
			JOptionPane.showMessageDialog(this,"VALUES ALREADY ENTERED, WANT TO UPDATE, PRESS BACK.");
			temp=0;
			}
		}
	else if(ae.getActionCommand().equals("NEXT -->>"))
		{
			int j,z=1,temp1=1;
			connect[0]=0;
			for(int y=0;y<k-1;y++)
				{
 				for(j=0;j<k-1;j++)
					{
					if((path[j] == temp1) && (path[j] != StartNode) && (path[j] != EndNode))
						{
							connect[z]=j;
							z++;
							temp1++;
							break;
						}
					}
				}
			for(j=0;j<k;j++)
				{
				if((path[j] == EndNode))
					{
						connect[z]=path[j];
						z++;
						break;
					}
				}
			size=z-1;
			if(temp == 0)
			{
				JOptionPane.showMessageDialog(this,"Assign a path first.");
			}
			else if((size+1) == k)
			{
				JOptionPane.showMessageDialog(this,"LEAVE ATLEAST ONE NODE FOR THE ATTACKER.");
				setVisible(false);
				NetworkSet nes=new NetworkSet("MOBILE COMPUTING 3.3.1v",x2,y2,k,StartNode,EndNode);
				Toolkit tk = Toolkit.getDefaultToolkit();  
				int xSize = ((int) tk.getScreenSize().getWidth());  
				int ySize = ((int) tk.getScreenSize().getHeight());  
				nes.setSize(xSize,ySize);  				
				nes.setResizable(false);
				nes.setVisible(true);
			}
			else
			{
				setVisible(false);
				Connect cn=new Connect("MOBILE COMPUTING 3.3.1v",x2,y2,k,StartNode,EndNode,connect,size);
				Toolkit tk = Toolkit.getDefaultToolkit();  
				int xSize = ((int) tk.getScreenSize().getWidth());  
				int ySize = ((int) tk.getScreenSize().getHeight());  
				cn.setSize(xSize,ySize);  				
				cn.setResizable(false);
				cn.setVisible(true);
			}
		}
	}
}

class Connect extends JFrame implements ActionListener
{
ImageIcon i1,i2,i3,i4,i5;
JLabel l1,l2,l3;
JButton jb1,jb2,jb3,jb4;
int size,k,temp=0,attacker,StartNode,EndNode;
JCheckBox[] checkBoxes=new JCheckBox[10];
int[] x2 = new int[10];
int[] y2 = new int[10];
int[] x3 = new int[10];
int[] y3 = new int[10];
int[] connect = new int[10];
Graphics g;
JTable jt;
JScrollPane scrollPane;
Container con;
Connect(String str,int[] x1,int[] y1,int i,int StartNode1,int EndNode1,int[] connect1,int size1)
	{
	super(str);
	k=i;
	StartNode=StartNode1;
	EndNode=EndNode1;
	size=size1;
	con=getContentPane();
	con.setLayout(null);
	con.setBackground(Color.white);
	i1=new ImageIcon("image1.png");
	i2=new ImageIcon("offButton.png");
	i3=new ImageIcon("StartNode.jpg");
	i4=new ImageIcon("EndNode.png");
	i5=new ImageIcon("attacker.png");
	l1=new JLabel("",i1,JLabel.LEFT);
	l2=new JLabel("NOTE : Only 1 attacker possible");
	l3=new JLabel("CLICK HERE TO VIEW THE ROUTING TABLES(BEFORE ATTACK) -->> ");
	jb1=new JButton("NEXT -->>");
	jb2=new JButton("EXIT");
	jb3=new JButton("BACK");
	jb4=new JButton("CLICK");
	for(int j=0;j<i;j++)
		{
		connect[j]=connect1[j];
		if(j == StartNode)
			{
			checkBoxes[j]=new JCheckBox("StartNode",i3,false);
			checkBoxes[j].setBounds(x1[j],y1[j],105,45);
			x2[j]=x1[j];
			y2[j]=y1[j];
			checkBoxes[j].setBackground(Color.white);
			con.add(checkBoxes[j]);
			}
		else if(j == EndNode)
			{
			checkBoxes[j]=new JCheckBox("EndNode",i4,false);
			checkBoxes[j].setBounds(x1[j],y1[j],105,45);
			x2[j]=x1[j];
			y2[j]=y1[j];
			checkBoxes[j].setBackground(Color.white);
			con.add(checkBoxes[j]);
			}
		else
			{
			checkBoxes[j]=new JCheckBox(""+j,i2,false);
			checkBoxes[j].setBounds(x1[j],y1[j],55,45);
			x2[j]=x1[j];
			y2[j]=y1[j];
			checkBoxes[j].setBackground(Color.white);
			con.add(checkBoxes[j]);
			}
		}
	for(int j=0;j<i;j++)
		{
		x3[j]=x1[connect1[j]]+15;
		y3[j]=y1[connect1[j]]+45;
		}
	l1.setBounds(300,10,500,90);
	l2.setBounds(460,670,400,90);
	l3.setBounds(320,70,400,90);
	jb1.setBounds(500,640,100,20);
	jb2.setBounds(650,640,80,20);
	jb3.setBounds(350,640,80,20);
	jb4.setBounds(700,105,80,20);
	con.add(l1);
	con.add(l2);
	con.add(l3);
	con.add(jb1);
	con.add(jb2);
	con.add(jb3);
	con.add(jb4);
	jb1.addActionListener(this);
	jb2.addActionListener(this);
	jb3.addActionListener(this);
	jb4.addActionListener(this);
	}

public void paint(Graphics g)
	{
	super.paint(g);
    g.setColor(Color.BLACK);
	g.drawPolyline(x3,y3,size+1);
	}

public void actionPerformed(ActionEvent ae)
	{
	if(ae.getActionCommand().equals("EXIT"))
		{
			JOptionPane.showMessageDialog(this,"CLOSING.\nCLICK OK.");
			System.exit(0);
		}
	else if(ae.getActionCommand().equals("BACK"))
		{
			JOptionPane.showMessageDialog(this,"BACK TO THE PREVIOUS FRAME");
			setVisible(false);
			NetworkSet nes=new NetworkSet("MOBILE COMPUTING 3.3.1v",x2,y2,k,StartNode,EndNode);
			Toolkit tk = Toolkit.getDefaultToolkit();  
			int xSize = ((int) tk.getScreenSize().getWidth());  
			int ySize = ((int) tk.getScreenSize().getHeight());  
			nes.setSize(xSize,ySize);  				
			nes.setResizable(false);
			nes.setVisible(true);
		}
	else if(ae.getActionCommand().equals("CLICK"))
		{
		int m=size+1;
		switch (m)
			{
            case 3:		Table ts=new Table("STARTNODE.B",size,connect);
						ts.setSize(250,200);  				
						ts.setLocation(0,0);
						ts.setResizable(false);
						ts.setVisible(true);
						Table8 te=new Table8("ENDNODE.B",size,connect);
						te.setSize(250,200);  				
						te.setLocation(0,210);
						te.setResizable(false);
						te.setVisible(true);
						Table1 t1=new Table1("NODE.B"+connect[1],size,connect);
						t1.setSize(250,200);  				
						t1.setLocation(260,0);
						t1.setResizable(false);
						t1.setVisible(true);
						break;
            case 4:		ts=new Table("STARTNODE.B",size,connect);
						ts.setSize(250,200);  				
						ts.setLocation(0,0);
						ts.setResizable(false);
						ts.setVisible(true);
						te=new Table8("ENDNODE.B",size,connect);
						te.setSize(250,200);  				
						te.setLocation(0,210);
						te.setResizable(false);
						te.setVisible(true);
						t1=new Table1("NODE.B"+connect[1],size,connect);
						t1.setSize(250,200);  				
						t1.setLocation(260,0);
						t1.setResizable(false);
						t1.setVisible(true);
						Table2 t2=new Table2("NODE.B"+connect[2],size,connect);
						t2.setSize(250,200);  				
						t2.setLocation(520,0);
						t2.setResizable(false);
						t2.setVisible(true);
					    break;
            case 5: 	Table3 t3=new Table3("NODE.B"+connect[3],size,connect);
						t3.setSize(250,200);  				
						t3.setLocation(260,210);
						t3.setResizable(false);
						t3.setVisible(true);
            			ts=new Table("STARTNODE.B",size,connect);
						ts.setSize(250,200);  				
						ts.setLocation(0,0);
						ts.setResizable(false);
						ts.setVisible(true);
						te=new Table8("ENDNODE.B",size,connect);
						te.setSize(250,200);  				
						te.setLocation(0,210);
						te.setResizable(false);
						te.setVisible(true);
						t1=new Table1("NODE.B"+connect[1],size,connect);
						t1.setSize(250,200);  				
						t1.setLocation(260,0);
						t1.setResizable(false);
						t1.setVisible(true);
						t2=new Table2("NODE.B"+connect[2],size,connect);
						t2.setSize(250,200);  				
						t2.setLocation(520,0);
						t2.setResizable(false);
						t2.setVisible(true);
					    break;
            case 6:		Table4 t4=new Table4("NODE.B"+connect[4],size,connect);
						t4.setSize(250,200);  				
						t4.setLocation(520,210);
						t4.setResizable(false);
						t4.setVisible(true);
            			t3=new Table3("NODE.B"+connect[3],size,connect);
						t3.setSize(250,200);  				
						t3.setLocation(260,210);
						t3.setResizable(false);
						t3.setVisible(true);
            			ts=new Table("STARTNODE.B",size,connect);
						ts.setSize(250,200);  				
						ts.setLocation(0,0);
						ts.setResizable(false);
						ts.setVisible(true);
						te=new Table8("ENDNODE.B",size,connect);
						te.setSize(250,200);  				
						te.setLocation(0,210);
						te.setResizable(false);
						te.setVisible(true);
						t1=new Table1("NODE.B"+connect[1],size,connect);
						t1.setSize(250,200);  				
						t1.setLocation(260,0);
						t1.setResizable(false);
						t1.setVisible(true);
						t2=new Table2("NODE.B"+connect[2],size,connect);
						t2.setSize(250,200);  				
						t2.setLocation(520,0);
						t2.setResizable(false);
						t2.setVisible(true);
					    break;
            case 7: 	Table5 t5=new Table5("NODE.B"+connect[5],size,connect);
						t5.setSize(250,200);  				
						t5.setLocation(0,420);
						t5.setResizable(false);
						t5.setVisible(true);
            			t4=new Table4("NODE.B"+connect[4],size,connect);
						t4.setSize(250,200);  				
						t4.setLocation(520,210);
						t4.setResizable(false);
						t4.setVisible(true);
            			t3=new Table3("NODE.B"+connect[3],size,connect);
						t3.setSize(250,200);  				
						t3.setLocation(260,210);
						t3.setResizable(false);
						t3.setVisible(true);
            			ts=new Table("STARTNODE.B",size,connect);
						ts.setSize(250,200);  				
						ts.setLocation(0,0);
						ts.setResizable(false);
						ts.setVisible(true);
						te=new Table8("ENDNODE.B",size,connect);
						te.setSize(250,200);  				
						te.setLocation(0,210);
						te.setResizable(false);
						te.setVisible(true);
						t1=new Table1("NODE.B"+connect[1],size,connect);
						t1.setSize(250,200);  				
						t1.setLocation(260,0);
						t1.setResizable(false);
						t1.setVisible(true);
						t2=new Table2("NODE.B"+connect[2],size,connect);
						t2.setSize(250,200);  				
						t2.setLocation(520,0);
						t2.setResizable(false);
						t2.setVisible(true);
					    break;
            case 8: 	Table6 t6=new Table6("NODE.B"+connect[6],size,connect);
						t6.setSize(250,200);  				
						t6.setLocation(260,420);
						t6.setResizable(false);
						t6.setVisible(true);
						t5=new Table5("NODE.B"+connect[5],size,connect);
						t5.setSize(250,200);  				
						t5.setLocation(0,420);
						t5.setResizable(false);
						t5.setVisible(true);
            			t4=new Table4("NODE.B"+connect[4],size,connect);
						t4.setSize(250,200);  				
						t4.setLocation(520,210);
						t4.setResizable(false);
						t4.setVisible(true);
            			t3=new Table3("NODE.B"+connect[3],size,connect);
						t3.setSize(250,200);  				
						t3.setLocation(260,210);
						t3.setResizable(false);
						t3.setVisible(true);
            			ts=new Table("STARTNODE.B",size,connect);
						ts.setSize(250,200);  				
						ts.setLocation(0,0);
						ts.setResizable(false);
						ts.setVisible(true);
						te=new Table8("ENDNODE.B",size,connect);
						te.setSize(250,200);  				
						te.setLocation(0,210);
						te.setResizable(false);
						te.setVisible(true);
						t1=new Table1("NODE.B"+connect[1],size,connect);
						t1.setSize(250,200);  				
						t1.setLocation(260,0);
						t1.setResizable(false);
						t1.setVisible(true);
						t2=new Table2("NODE.B"+connect[2],size,connect);
						t2.setSize(250,200);  				
						t2.setLocation(520,0);
						t2.setResizable(false);
						t2.setVisible(true);
					    break;
            case 9:		Table7 t7=new Table7("NODE.B"+connect[7],size,connect);
						t7.setSize(250,200);  				
						t7.setLocation(520,420);
						t7.setResizable(false);
						t7.setVisible(true);
            			t6=new Table6("NODE.B"+connect[6],size,connect);
						t6.setSize(250,200);  				
						t6.setLocation(260,420);
						t6.setResizable(false);
						t6.setVisible(true);
						t5=new Table5("NODE.B"+connect[5],size,connect);
						t5.setSize(250,200);  				
						t5.setLocation(0,420);
						t5.setResizable(false);
						t5.setVisible(true);
            			t4=new Table4("NODE.B"+connect[4],size,connect);
						t4.setSize(250,200);  				
						t4.setLocation(520,210);
						t4.setResizable(false);
						t4.setVisible(true);
            			t3=new Table3("NODE.B"+connect[3],size,connect);
						t3.setSize(250,200);  				
						t3.setLocation(260,210);
						t3.setResizable(false);
						t3.setVisible(true);
            			ts=new Table("STARTNODE.B",size,connect);
						ts.setSize(250,200);  				
						ts.setLocation(0,0);
						ts.setResizable(false);
						ts.setVisible(true);
						te=new Table8("ENDNODE.B",size,connect);
						te.setSize(250,200);  				
						te.setLocation(0,210);
						te.setResizable(false);
						te.setVisible(true);
						t1=new Table1("NODE.B"+connect[1],size,connect);
						t1.setSize(250,200);  				
						t1.setLocation(260,0);
						t1.setResizable(false);
						t1.setVisible(true);
						t2=new Table2("NODE.B"+connect[2],size,connect);
						t2.setSize(250,200);  				
						t2.setLocation(520,0);
						t2.setResizable(false);
						t2.setVisible(true);
					    break;
			}
		}
	else if(ae.getActionCommand().equals("NEXT -->>"))
		{
			setVisible(false);
			Connect1 cn1=new Connect1("MOBILE COMPUTING 3.3.1v",x2,y2,k,StartNode,EndNode,connect,size);
			Toolkit tk = Toolkit.getDefaultToolkit();  
			int xSize = ((int) tk.getScreenSize().getWidth());  
			int ySize = ((int) tk.getScreenSize().getHeight());  
			cn1.setSize(xSize,ySize);  				
			cn1.setResizable(false);
			cn1.setVisible(true);
		}
	}
}

class Table extends JFrame
{
int size;
JTable jt;
JScrollPane scrollPane;
Container con;
int[] connect = new int[10];
Table(String s,int size1,int[] connect1)
	{
	super(s);
	size=size1;
	for(int j=0;j<size;j++)
		{
		connect[j]=connect1[j];
		}
	int cols=3,temp=1;
	int rows=size;
	String head[]=new String[cols];
	String data[][]=new String[rows][cols];
	head[0]="Des";
	head[1]="Next";
	head[2]="Dis";
	for(int a=0;a<rows-1;a++)
		{
		for(int b=0;b<cols;b++)
			{
			if(b == 0)
				{
				data[a][b]=""+connect[a+1];
				}
			if(b == 1)
				{
				data[a][b]=""+connect[1];
				}
			if(b == 2)
				{
				data[a][b]=""+temp;
				temp++;
				}
			}
		}
	for(int a=0;a<cols;a++)
		{
		if(a == 0)
			{
			data[rows-1][a]="EndNode";
			}
		if(a == 1)
			{
			data[rows-1][a]=""+connect[1];
			}
		if(a == 2)
			{
			data[rows-1][a]=""+temp;
			}
		}
	jt=new JTable(data,head);
	int x=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	int y=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	scrollPane = new JScrollPane(jt,y,x);
	con=getContentPane();
	con.setLayout(new BorderLayout());
	con.add(scrollPane);
	}
}

class Table1 extends JFrame
{
int size;
JTable jt;
JScrollPane scrollPane;
Container con;
int[] connect = new int[10];
Table1(String s,int size1,int[] connect1)
	{
	super(s);
	size=size1+1;
	for(int j=0;j<size;j++)
		{
		connect[j]=connect1[j];
		}
	int cols=3,temp1=1,temp2=1;
	int rows=size;
	String head[]=new String[cols];
	String data[][]=new String[rows][cols];
	head[0]="Des";
	head[1]="Next";
	head[2]="Dis";
	for(int a=0;a<rows-1;a++)
		{
		for(int b=0;b<cols;b++)
			{
			if(b == 0)
				{
				if(a == 0)
					{
					data[a][b]="StartNode";
					}
				else if(a == 1)
					{
					data[a][b]="1";
					}
				else
					{
					data[a][b]=""+connect[a];
					}
				}
			if(b == 1)
				{
				if(a == 1)
					{
					data[a][b]="1";
					}
				else
					{
					if(a<1)
						{
						data[a][b]="StartNode";
						}
					if(a>1)
						{
						data[a][b]=""+connect[2];
						}
					}
				}
			if(b == 2)
				{
				if(a == 1)
					{
					data[a][b]="0";
					}
				else
					{
					if(a<1)
						{
						data[a][b]=""+temp1;
						temp1--;
						}
					if(a>1)
						{
						data[a][b]=""+temp2;
						temp2++;
						}
					}
				}
			}
		}
	for(int a=0;a<cols;a++)
		{
		if(a == 0)
			{
			data[rows-1][a]="EndNode";
			}
		if(a == 1)
			{
			if(size == 3)
				{
				data[rows-1][a]="EndNode";
				}
			else
				{
				data[rows-1][a]=""+connect[2];
				}
			}
		if(a == 2)
			{
			data[rows-1][a]=""+temp2;
			}
		}
	jt=new JTable(data,head);
	int x=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	int y=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	scrollPane = new JScrollPane(jt,y,x);
	con=getContentPane();
	con.setLayout(new BorderLayout());
	con.add(scrollPane);
	}
}

class Table2 extends JFrame
{
int size;
JTable jt;
JScrollPane scrollPane;
Container con;
int[] connect = new int[10];
Table2(String s,int size1,int[] connect1)
	{
	super(s);
	size=size1+1;
	for(int j=0;j<size;j++)
		{
		connect[j]=connect1[j];
		}
	int cols=3,temp1=2,temp2=1;
	int rows=size;
	String head[]=new String[cols];
	String data[][]=new String[rows][cols];
	head[0]="Des";
	head[1]="Next";
	head[2]="Dis";
	for(int a=0;a<rows-1;a++)
		{
		for(int b=0;b<cols;b++)
			{
			if(b == 0)
				{
				if(a == 0)
					{
					data[a][b]="StartNode";
					}
				else if(a == 2)
					{
					data[a][b]="2";
					}
				else
					{
					data[a][b]=""+connect[a];
					}
				}
			if(b == 1)
				{
				if(a == 2)
					{
					data[a][b]="2";
					}
				else
					{
					if(a<2)
						{
						data[a][b]=""+connect[1];
						}
					if(a>2)
						{
						data[a][b]=""+connect[3];
						}
					}
				}
			if(b == 2)
				{
				if(a == 2)
					{
					data[a][b]="0";
					}
				else
					{
					if(a<2)
						{
						data[a][b]=""+temp1;
						temp1--;
						}
					if(a>2)
						{
						data[a][b]=""+temp2;
						temp2++;
						}
					}
				}
			}
		}
	for(int a=0;a<cols;a++)
		{
		if(a == 0)
			{
			data[rows-1][a]="EndNode";
			}
		if(a == 1)
			if(size == 4)
				{
				data[rows-1][a]="EndNode";
				}
			else
				{
				data[rows-1][a]=""+connect[3];
				}
		if(a == 2)
			{
			data[rows-1][a]=""+temp2;
			}
		}
	jt=new JTable(data,head);
	int x=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	int y=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	scrollPane = new JScrollPane(jt,y,x);
	con=getContentPane();
	con.setLayout(new BorderLayout());
	con.add(scrollPane);
	}
}

class Table3 extends JFrame
{
int size;
JTable jt;
JScrollPane scrollPane;
Container con;
int[] connect = new int[10];
Table3(String s,int size1,int[] connect1)
	{
	super(s);
	size=size1+1;
	for(int j=0;j<size;j++)
		{
		connect[j]=connect1[j];
		}
	int cols=3,temp1=3,temp2=1;
	int rows=size;
	String head[]=new String[cols];
	String data[][]=new String[rows][cols];
	head[0]="Des";
	head[1]="Next";
	head[2]="Dis";
	for(int a=0;a<rows-1;a++)
		{
		for(int b=0;b<cols;b++)
			{
			if(b == 0)
				{
				if(a == 0)
					{
					data[a][b]="StartNode";
					}
				else if(a == 3)
					{
					data[a][b]="3";
					}
				else
					{
					data[a][b]=""+connect[a];
					}
				}
			if(b == 1)
				{
				if(a == 3)
					{
					data[a][b]="3";
					}
				else
					{
					if(a<3)
						{
						data[a][b]=""+connect[2];
						}
					if(a>3)
						{
						data[a][b]=""+connect[4];
						}
					}
				}
			if(b == 2)
				{
				if(a == 3)
					{
					data[a][b]="0";
					}
				else
					{
					if(a<3)
						{
						data[a][b]=""+temp1;
						temp1--;
						}
					if(a>3)
						{
						data[a][b]=""+temp2;
						temp2++;
						}
					}
				}
			}
		}
	for(int a=0;a<cols;a++)
		{
		if(a == 0)
			{
			data[rows-1][a]="EndNode";
			}
		if(a == 1)
			if(size == 5)
				{
				data[rows-1][a]="EndNode";
				}
			else
				{
				data[rows-1][a]=""+connect[4];
				}
		if(a == 2)
			{
			data[rows-1][a]=""+temp2;
			}
		}
	jt=new JTable(data,head);
	int x=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	int y=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	scrollPane = new JScrollPane(jt,y,x);
	con=getContentPane();
	con.setLayout(new BorderLayout());
	con.add(scrollPane);
	}
}

class Table4 extends JFrame
{
int size;
JTable jt;
JScrollPane scrollPane;
Container con;
int[] connect = new int[10];
Table4(String s,int size1,int[] connect1)
	{
	super(s);
	size=size1+1;
	for(int j=0;j<size;j++)
		{
		connect[j]=connect1[j];
		}
	int cols=3,temp1=4,temp2=1;
	int rows=size;
	String head[]=new String[cols];
	String data[][]=new String[rows][cols];
	head[0]="Des";
	head[1]="Next";
	head[2]="Dis";
	for(int a=0;a<rows-1;a++)
		{
		for(int b=0;b<cols;b++)
			{
			if(b == 0)
				{
				if(a == 0)
					{
					data[a][b]="StartNode";
					}
				else if(a == 4)
					{
					data[a][b]="4";
					}
				else
					{
					data[a][b]=""+connect[a];
					}
				}
			if(b == 1)
				{
				if(a == 4)
					{
					data[a][b]="4";
					}
				else
					{
					if(a<4)
						{
						data[a][b]=""+connect[3];
						}
					if(a>4)
						{
						data[a][b]=""+connect[5];
						}
					}
				}
			if(b == 2)
				{
				if(a == 4)
					{
					data[a][b]="0";
					}
				else
					{
					if(a<4)
						{
						data[a][b]=""+temp1;
						temp1--;
						}
					if(a>4)
						{
						data[a][b]=""+temp2;
						temp2++;
						}
					}
				}
			}
		}
	for(int a=0;a<cols;a++)
		{
		if(a == 0)
			{
			data[rows-1][a]="EndNode";
			}
		if(a == 1)
			if(size == 6)
				{
				data[rows-1][a]="EndNode";
				}
			else
				{
				data[rows-1][a]=""+connect[5];
				}
		if(a == 2)
			{
			data[rows-1][a]=""+temp2;
			}
		}
	jt=new JTable(data,head);
	int x=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	int y=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	scrollPane = new JScrollPane(jt,y,x);
	con=getContentPane();
	con.setLayout(new BorderLayout());
	con.add(scrollPane);
	}
}

class Table5 extends JFrame
{
int size;
JTable jt;
JScrollPane scrollPane;
Container con;
int[] connect = new int[10];
Table5(String s,int size1,int[] connect1)
	{
	super(s);
	size=size1+1;
	for(int j=0;j<size;j++)
		{
		connect[j]=connect1[j];
		}
	int cols=3,temp1=5,temp2=1;
	int rows=size;
	String head[]=new String[cols];
	String data[][]=new String[rows][cols];
	head[0]="Des";
	head[1]="Next";
	head[2]="Dis";
	for(int a=0;a<rows-1;a++)
		{
		for(int b=0;b<cols;b++)
			{
			if(b == 0)
				{
				if(a == 0)
					{
					data[a][b]="StartNode";
					}
				else if(a == 5)
					{
					data[a][b]="5";
					}
				else
					{
					data[a][b]=""+connect[a];
					}
				}
			if(b == 1)
				{
				if(a == 5)
					{
					data[a][b]="5";
					}
				else
					{
					if(a<5)
						{
						data[a][b]=""+connect[4];
						}
					if(a>5)
						{
						data[a][b]=""+connect[6];
						}
					}
				}
			if(b == 2)
				{
				if(a == 5)
					{
					data[a][b]="0";
					}
				else
					{
					if(a<5)
						{
						data[a][b]=""+temp1;
						temp1--;
						}
					if(a>5)
						{
						data[a][b]=""+temp2;
						temp2++;
						}
					}
				}
			}
		}
	for(int a=0;a<cols;a++)
		{
		if(a == 0)
			{
			data[rows-1][a]="EndNode";
			}
		if(a == 1)
			if(size == 7)
				{
				data[rows-1][a]="EndNode";
				}
			else
				{
				data[rows-1][a]=""+connect[6];
				}
		if(a == 2)
			{
			data[rows-1][a]=""+temp2;
			}
		}
	jt=new JTable(data,head);
	int x=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	int y=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	scrollPane = new JScrollPane(jt,y,x);
	con=getContentPane();
	con.setLayout(new BorderLayout());
	con.add(scrollPane);
	}
}

class Table6 extends JFrame
{
int size;
JTable jt;
JScrollPane scrollPane;
Container con;
int[] connect = new int[10];
Table6(String s,int size1,int[] connect1)
	{
	super(s);
	size=size1+1;
	for(int j=0;j<size;j++)
		{
		connect[j]=connect1[j];
		}
	int cols=3,temp1=6,temp2=1;
	int rows=size;
	String head[]=new String[cols];
	String data[][]=new String[rows][cols];
	head[0]="Des";
	head[1]="Next";
	head[2]="Dis";
	for(int a=0;a<rows-1;a++)
		{
		for(int b=0;b<cols;b++)
			{
			if(b == 0)
				{
				if(a == 0)
					{
					data[a][b]="StartNode";
					}
				else if(a == 6)
					{
					data[a][b]="6";
					}
				else
					{
					data[a][b]=""+connect[a];
					}
				}
			if(b == 1)
				{
				if(a == 6)
					{
					data[a][b]="6";
					}
				else
					{
					if(a<6)
						{
						data[a][b]=""+connect[5];
						}
					if(a>6)
						{
						data[a][b]=""+connect[7];
						}
					}
				}
			if(b == 2)
				{
				if(a == 6)
					{
					data[a][b]="0";
					}
				else
					{
					if(a<6)
						{
						data[a][b]=""+temp1;
						temp1--;
						}
					if(a>6)
						{
						data[a][b]=""+temp2;
						temp2++;
						}
					}
				}
			}
		}
	for(int a=0;a<cols;a++)
		{
		if(a == 0)
			{
			data[rows-1][a]="EndNode";
			}
		if(a == 1)
			if(size == 8)
				{
				data[rows-1][a]="EndNode";
				}
			else
				{
				data[rows-1][a]=""+connect[7];
				}
		if(a == 2)
			{
			data[rows-1][a]=""+temp2;
			}
		}
	jt=new JTable(data,head);
	int x=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	int y=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	scrollPane = new JScrollPane(jt,y,x);
	con=getContentPane();
	con.setLayout(new BorderLayout());
	con.add(scrollPane);
	}
}

class Table7 extends JFrame
{
int size;
JTable jt;
JScrollPane scrollPane;
Container con;
int[] connect = new int[10];
Table7(String s,int size1,int[] connect1)
	{
	super(s);
	size=size1+1;
	for(int j=0;j<size;j++)
		{
		connect[j]=connect1[j];
		}
	int cols=3,temp1=7,temp2=1;
	int rows=size;
	String head[]=new String[cols];
	String data[][]=new String[rows][cols];
	head[0]="Des";
	head[1]="Next";
	head[2]="Dis";
	for(int a=0;a<rows-1;a++)
		{
		for(int b=0;b<cols;b++)
			{
			if(b == 0)
				{
				if(a == 0)
					{
					data[a][b]="StartNode";
					}
				else if(a == 7)
					{
					data[a][b]="7";
					}
				else
					{
					data[a][b]=""+connect[a];
					}
				}
			if(b == 1)
				{
				if(a == 7)
					{
					data[a][b]="7";
					}
				else
					{
					if(a<7)
						{
						data[a][b]=""+connect[6];
						}
					if(a>7)
						{
						data[a][b]=""+connect[8];
						}
					}
				}
			if(b == 2)
				{
				if(a == 7)
					{
					data[a][b]="0";
					}
				else
					{
					if(a<7)
						{
						data[a][b]=""+temp1;
						temp1--;
						}
					if(a>7)
						{
						data[a][b]=""+temp2;
						temp2++;
						}
					}
				}
			}
		}
	for(int a=0;a<cols;a++)
		{
		if(a == 0)
			{
			data[rows-1][a]="EndNode";
			}
		if(a == 1)
			if(size == 9)
				{
				data[rows-1][a]="EndNode";
				}
			else
				{
				data[rows-1][a]=""+connect[8];
				}
		if(a == 2)
			{
			data[rows-1][a]=""+temp2;
			}
		}
	jt=new JTable(data,head);
	int x=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	int y=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	scrollPane = new JScrollPane(jt,y,x);
	con=getContentPane();
	con.setLayout(new BorderLayout());
	con.add(scrollPane);
	}
}

class Table8 extends JFrame
{
int size;
JTable jt;
JScrollPane scrollPane;
Container con;
int[] connect = new int[10];
Table8(String s,int size1,int[] connect1)
	{
	super(s);
	size=size1+1;
	for(int j=0;j<size;j++)
		{
		connect[j]=connect1[j];
		}
	int cols=3,temp=size-1;
	int rows=size;
	String head[]=new String[cols];
	String data[][]=new String[rows][cols];
	head[0]="Des";
	head[1]="Next";
	head[2]="Dis";
	for(int a=0;a<rows-1;a++)
		{
		for(int b=0;b<cols;b++)
			{
			if(b == 0)
				{
				if(a == 0)
					{
					data[a][b]="StartNode";
					}
				else
					{
					data[a][b]=""+connect[a];
					}
				}
			if(b == 1)
				{
				data[a][b]=""+connect[size-2];
				}
			if(b == 2)
				{
				data[a][b]=""+temp;
				temp--;
				}
			}
		}
	jt=new JTable(data,head);
	int x=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	int y=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	scrollPane = new JScrollPane(jt,y,x);
	con=getContentPane();
	con.setLayout(new BorderLayout());
	con.add(scrollPane);
	}
}

class Connect1 extends JFrame implements ActionListener,ItemListener
{
ImageIcon i1,i2,i3,i4,i5;
JLabel l1,l2,l3;
JButton jb1,jb2,jb3;
int size,k,temp=0,attacker,StartNode,EndNode;
JCheckBox[] checkBoxes=new JCheckBox[10];
int[] x2 = new int[10];
int[] y2 = new int[10];
int[] x3 = new int[10];
int[] y3 = new int[10];
int[] connect = new int[10];
Graphics g;
Container con;
Connect1(String str,int[] x1,int[] y1,int i,int StartNode1,int EndNode1,int[] connect1,int size1)
	{
	super(str);
	k=i;
	StartNode=StartNode1;
	EndNode=EndNode1;
	size=size1;
	con=getContentPane();
	con.setLayout(null);
	con.setBackground(Color.white);
	i1=new ImageIcon("image1.png");
	i2=new ImageIcon("offButton.png");
	i3=new ImageIcon("StartNode.jpg");
	i4=new ImageIcon("EndNode.png");
	i5=new ImageIcon("attacker.png");
	l1=new JLabel("",i1,JLabel.LEFT);
	l2=new JLabel("NOTE : Only 1 attacker possible");
	l3=new JLabel("Select the attacker Node");
	jb1=new JButton("NEXT -->>");
	jb2=new JButton("EXIT");
	jb3=new JButton("BACK");
	for(int j=0;j<i;j++)
		{
		connect[j]=connect1[j];
		if(j == StartNode)
			{
			checkBoxes[j]=new JCheckBox("StartNode",i3,false);
			checkBoxes[j].setBounds(x1[j],y1[j],105,45);
			x2[j]=x1[j];
			y2[j]=y1[j];
			checkBoxes[j].setBackground(Color.white);
			con.add(checkBoxes[j]);
			checkBoxes[j].addItemListener(this);
			}
		else if(j == EndNode)
			{
			checkBoxes[j]=new JCheckBox("EndNode",i4,false);
			checkBoxes[j].setBounds(x1[j],y1[j],105,45);
			x2[j]=x1[j];
			y2[j]=y1[j];
			checkBoxes[j].setBackground(Color.white);
			con.add(checkBoxes[j]);
			checkBoxes[j].addItemListener(this);
			}
		else
			{
			checkBoxes[j]=new JCheckBox(""+j,i2,false);
			checkBoxes[j].setBounds(x1[j],y1[j],55,45);
			x2[j]=x1[j];
			y2[j]=y1[j];
			checkBoxes[j].setBackground(Color.white);
			con.add(checkBoxes[j]);
			checkBoxes[j].addItemListener(this);
			}
		}
	for(int j=0;j<i;j++)
		{
		x3[j]=x1[connect1[j]]+15;
		y3[j]=y1[connect1[j]]+45;
		}
	l1.setBounds(300,10,500,90);
	l2.setBounds(460,670,400,90);
	l3.setBounds(470,70,300,90);
	jb1.setBounds(500,640,100,20);
	jb2.setBounds(650,640,80,20);
	jb3.setBounds(350,640,80,20);
	con.add(l1);
	con.add(l2);
	con.add(l3);
	con.add(jb1);
	con.add(jb2);
	con.add(jb3);
	jb1.addActionListener(this);
	jb2.addActionListener(this);
	jb3.addActionListener(this);
	}

public void paint(Graphics g)
	{
	super.paint(g);
    g.setColor(Color.BLACK);
	g.drawPolyline(x3,y3,size+1);
	}

public void itemStateChanged(ItemEvent ir)
	{
	for(int j=0;j<k;j++)
		{
		if((checkBoxes[j].isSelected()==true) && (temp==0))
			{
			checkBoxes[j].setSelectedIcon(i5);
			checkBoxes[j].setText("Attacker");
			checkBoxes[j].setBounds(x2[j],y2[j],105,45);
			attacker=j;
			temp++;
			break;
			}
		}
	}

public void actionPerformed(ActionEvent ae)
	{
	if(ae.getActionCommand().equals("EXIT"))
		{
			JOptionPane.showMessageDialog(this,"CLOSING.\nCLICK OK.");
			System.exit(0);
		}
	else if(ae.getActionCommand().equals("BACK"))
		{
			JOptionPane.showMessageDialog(this,"BACK TO THE PREVIOUS FRAME");
			Connect cn=new Connect("MOBILE COMPUTING 3.3.1v",x2,y2,k,StartNode,EndNode,connect,size);
			Toolkit tk = Toolkit.getDefaultToolkit();  
			int xSize = ((int) tk.getScreenSize().getWidth());  
			int ySize = ((int) tk.getScreenSize().getHeight());  
			cn.setSize(xSize,ySize);  				
			cn.setResizable(false);
			cn.setVisible(true);
		}
	else if(ae.getActionCommand().equals("NEXT -->>"))
		{
			setVisible(false);
			ConnectAttack ca=new ConnectAttack("MOBILE COMPUTING 3.3.1v",x2,y2,x3,y3,k,StartNode,EndNode,attacker,connect,size);
			Toolkit tk = Toolkit.getDefaultToolkit();  
			int xSize = ((int) tk.getScreenSize().getWidth());  
			int ySize = ((int) tk.getScreenSize().getHeight());  
			ca.setSize(xSize,ySize);  				
			ca.setResizable(false);
			ca.setVisible(true);
		}
	}
}

class ConnectAttack extends JFrame implements ActionListener
{
ImageIcon i1,i2,i3,i4,i5;
JLabel l1,l2,l4,l5,l6,l7,l8,l9,l10;
JButton jb1,jb2,jb3,jb4;
int size,k,temp=0,attacker,StartNode,EndNode;
JCheckBox[] checkBoxes=new JCheckBox[10];
int[] x2 = new int[10];
int[] y2 = new int[10];
int[] x3 = new int[10];
int[] y3 = new int[10];
int[] xa = new int[20];
int[] ya = new int[20];
int[] connect = new int[10];
Graphics g;
Container con;
ConnectAttack(String str,int[] x1,int[] y1,int[] x4,int[] y4,int i,int StartNode1,int EndNode1,int attacker1,int[] connect1,int size1)
	{
	super(str);
	k=i;
	StartNode=StartNode1;
	EndNode=EndNode1;
	attacker=attacker1;
	size=size1+1;
	con=getContentPane();
	con.setLayout(null);
	con.setBackground(Color.white);
	i1=new ImageIcon("image1.png");
	i2=new ImageIcon("offButton.png");
	i3=new ImageIcon("StartNode.jpg");
	i4=new ImageIcon("EndNode.png");
	i5=new ImageIcon("attacker.png");
	l1=new JLabel("",i1,JLabel.LEFT);
	l2=new JLabel("NOTE : Only 1 attacker possible");
	l4=new JLabel("Original link");
	l5=new JLabel("Attacker's link");
	l6=new JLabel("Fake link");
	l7=new JLabel("CLICK HERE TO VIEW THE ROUTING TABLES(AFTER ATTACK) -->> ");
	l8=new JLabel("StartNode -->>  "+StartNode);
	l9=new JLabel("EndNode   -->>  "+EndNode);
	l10=new JLabel("Attacker  -->>  "+attacker);
	jb1=new JButton("NEXT -->>");
	jb2=new JButton("EXIT");
	jb3=new JButton("BACK");
	jb4=new JButton("CLICK");
	for(int j=0;j<i;j++)
		{
		connect[j]=connect1[j];
		if(j == StartNode)
			{
			checkBoxes[j]=new JCheckBox("StartNode",i3,false);
			checkBoxes[j].setBounds(x1[j],y1[j],105,45);
			x2[j]=x1[j];
			y2[j]=y1[j];
			x3[j]=x4[j];
			y3[j]=y4[j];
			checkBoxes[j].setBackground(Color.white);
			con.add(checkBoxes[j]);
			}
		else if(j == EndNode)
			{
			checkBoxes[j]=new JCheckBox("EndNode",i4,false);
			checkBoxes[j].setBounds(x1[j],y1[j],105,45);
			x2[j]=x1[j];
			y2[j]=y1[j];
			x3[j]=x4[j];
			y3[j]=y4[j];
			checkBoxes[j].setBackground(Color.white);
			con.add(checkBoxes[j]);
			}
		else if(j == attacker1)
			{
			checkBoxes[j]=new JCheckBox("Attacker",i5,false);
			checkBoxes[j].setBounds(x1[j],y1[j],105,45);
			x2[j]=x1[j];
			y2[j]=y1[j];
			x3[j]=x4[j];
			y3[j]=y4[j];
			checkBoxes[j].setBackground(Color.white);
			con.add(checkBoxes[j]);
			}
		else
			{
			checkBoxes[j]=new JCheckBox(""+j,i2,false);
			checkBoxes[j].setBounds(x1[j],y1[j],55,45);
			x2[j]=x1[j];
			y2[j]=y1[j];
			x3[j]=x4[j];
			y3[j]=y4[j];
			checkBoxes[j].setBackground(Color.white);
			con.add(checkBoxes[j]);
			}
		}
	for(int j=0,k=0;k<(i*2);j++)
		{
		xa[k]=x1[attacker1]+15;
		ya[k]=y1[attacker1]+45;
		k++;
		xa[k]=x1[j]+15;
		ya[k]=y1[j]+45;
		k++;
		}
	l1.setBounds(300,10,500,90);
	l2.setBounds(460,670,400,90);
	l4.setBounds(820,110,100,20);
	l5.setBounds(820,140,100,20);
	l6.setBounds(820,170,100,20);
	l7.setBounds(320,70,400,90);
	l8.setBounds(820,200,200,20);
	l9.setBounds(820,230,200,20);
	l10.setBounds(820,260,200,20);
	jb4.setBounds(700,105,80,20);
	jb1.setBounds(500,640,100,20);
	jb2.setBounds(650,640,80,20);
	jb3.setBounds(350,640,80,20);
	con.add(l1);
	con.add(l2);
	con.add(l4);
	con.add(l5);
	con.add(l6);
	con.add(l7);
	con.add(l8);
	con.add(l9);
	con.add(l10);
	con.add(jb1);
	con.add(jb2);
	con.add(jb3);
	con.add(jb4);
	jb1.addActionListener(this);
	jb2.addActionListener(this);
	jb3.addActionListener(this);
	jb4.addActionListener(this);
	}

public void paint(Graphics g)
	{
	super.paint(g);
    g.setColor(Color.BLACK);
	g.drawPolyline(x3,y3,size);
	g.setColor(Color.RED);
	g.drawPolyline(xa,ya,(k)*2);
	g.setColor(Color.BLUE);
	g.drawLine(x2[attacker]+15,y2[attacker]+45,x2[EndNode]+15,y2[EndNode]+45);
    g.setColor(Color.BLACK);
	g.drawLine(920,150,970,150);
	g.setColor(Color.RED);
	g.drawLine(920,180,970,180);
	g.setColor(Color.BLUE);
	g.drawLine(920,210,970,210);
	}

public void actionPerformed(ActionEvent ae)
	{
	if(ae.getActionCommand().equals("EXIT"))
		{
			JOptionPane.showMessageDialog(this,"CLOSING.\nCLICK OK.");
			System.exit(0);
		}
	else if(ae.getActionCommand().equals("BACK"))
		{
			JOptionPane.showMessageDialog(this,"BACK TO THE PREVIOUS FRAME");
			setVisible(false);
			Connect cn=new Connect("MOBILE COMPUTING 3.3.1v",x2,y2,k,StartNode,EndNode,connect,size);
			Toolkit tk = Toolkit.getDefaultToolkit();  
			int xSize = ((int) tk.getScreenSize().getWidth());  
			int ySize = ((int) tk.getScreenSize().getHeight());  
			cn.setSize(xSize,ySize);  				
			cn.setResizable(false);
			cn.setVisible(true);
		}
	else if(ae.getActionCommand().equals("CLICK"))
		{
		size=size-1;
		int m=size+1;
		switch (m)
			{
            case 3:		TableA ts=new TableA("STARTNODE.A",attacker,size,connect);
						ts.setSize(250,200);  				
						ts.setLocation(0,0);
						ts.setResizable(false);
						ts.setVisible(true);
						TableA8 te=new TableA8("ENDNODE.A",attacker,size,connect);
						te.setSize(250,200);  				
						te.setLocation(0,210);
						te.setResizable(false);
						te.setVisible(true);
						TableA1 t1=new TableA1("NODE.A"+connect[1],attacker,size,connect);
						t1.setSize(250,200);  				
						t1.setLocation(260,0);
						t1.setResizable(false);
						t1.setVisible(true);
						break;
            case 4:		ts=new TableA("STARTNODE.A",attacker,size,connect);
						ts.setSize(250,200);  				
						ts.setLocation(0,0);
						ts.setResizable(false);
						ts.setVisible(true);
						te=new TableA8("ENDNODE.A",attacker,size,connect);
						te.setSize(250,200);  				
						te.setLocation(0,210);
						te.setResizable(false);
						te.setVisible(true);
						t1=new TableA1("NODE.A"+connect[1],attacker,size,connect);
						t1.setSize(250,200);  				
						t1.setLocation(260,0);
						t1.setResizable(false);
						t1.setVisible(true);
						TableA2 t2=new TableA2("NODE.A"+connect[2],attacker,size,connect);
						t2.setSize(250,200);  				
						t2.setLocation(520,0);
						t2.setResizable(false);
						t2.setVisible(true);
					    break;
            case 5: 	TableA3 t3=new TableA3("NODE.A"+connect[3],attacker,size,connect);
						t3.setSize(250,200);  				
						t3.setLocation(260,210);
						t3.setResizable(false);
						t3.setVisible(true);
            			ts=new TableA("STARTNODE.A",attacker,size,connect);
						ts.setSize(250,200);  				
						ts.setLocation(0,0);
						ts.setResizable(false);
						ts.setVisible(true);
						te=new TableA8("ENDNODE.A",attacker,size,connect);
						te.setSize(250,200);  				
						te.setLocation(0,210);
						te.setResizable(false);
						te.setVisible(true);
						t1=new TableA1("NODE.A"+connect[1],attacker,size,connect);
						t1.setSize(250,200);  				
						t1.setLocation(260,0);
						t1.setResizable(false);
						t1.setVisible(true);
						t2=new TableA2("NODE.A"+connect[2],attacker,size,connect);
						t2.setSize(250,200);  				
						t2.setLocation(520,0);
						t2.setResizable(false);
						t2.setVisible(true);
					    break;
            case 6:		TableA4 t4=new TableA4("NODE.A"+connect[4],attacker,size,connect);
						t4.setSize(250,200);  				
						t4.setLocation(520,210);
						t4.setResizable(false);
						t4.setVisible(true);
            			t3=new TableA3("NODE.A"+connect[3],attacker,size,connect);
						t3.setSize(250,200);  				
						t3.setLocation(260,210);
						t3.setResizable(false);
						t3.setVisible(true);
            			ts=new TableA("STARTNODE.A",attacker,size,connect);
						ts.setSize(250,200);  				
						ts.setLocation(0,0);
						ts.setResizable(false);
						ts.setVisible(true);
						te=new TableA8("ENDNODE.A",attacker,size,connect);
						te.setSize(250,200);  				
						te.setLocation(0,210);
						te.setResizable(false);
						te.setVisible(true);
						t1=new TableA1("NODE.A"+connect[1],attacker,size,connect);
						t1.setSize(250,200);  				
						t1.setLocation(260,0);
						t1.setResizable(false);
						t1.setVisible(true);
						t2=new TableA2("NODE.A"+connect[2],attacker,size,connect);
						t2.setSize(250,200);  				
						t2.setLocation(520,0);
						t2.setResizable(false);
						t2.setVisible(true);
					    break;
            case 7: 	TableA5 t5=new TableA5("NODE.A"+connect[5],attacker,size,connect);
						t5.setSize(250,200);  				
						t5.setLocation(0,420);
						t5.setResizable(false);
						t5.setVisible(true);
            			t4=new TableA4("NODE.A"+connect[4],attacker,size,connect);
						t4.setSize(250,200);  				
						t4.setLocation(520,210);
						t4.setResizable(false);
						t4.setVisible(true);
            			t3=new TableA3("NODE.A"+connect[3],attacker,size,connect);
						t3.setSize(250,200);  				
						t3.setLocation(260,210);
						t3.setResizable(false);
						t3.setVisible(true);
            			ts=new TableA("STARTNODE.A",attacker,size,connect);
						ts.setSize(250,200);  				
						ts.setLocation(0,0);
						ts.setResizable(false);
						ts.setVisible(true);
						te=new TableA8("ENDNODE.A",attacker,size,connect);
						te.setSize(250,200);  				
						te.setLocation(0,210);
						te.setResizable(false);
						te.setVisible(true);
						t1=new TableA1("NODE.A"+connect[1],attacker,size,connect);
						t1.setSize(250,200);  				
						t1.setLocation(260,0);
						t1.setResizable(false);
						t1.setVisible(true);
						t2=new TableA2("NODE.A"+connect[2],attacker,size,connect);
						t2.setSize(250,200);  				
						t2.setLocation(520,0);
						t2.setResizable(false);
						t2.setVisible(true);
					    break;
            case 8: 	TableA6 t6=new TableA6("NODE.A"+connect[6],attacker,size,connect);
						t6.setSize(250,200);  				
						t6.setLocation(260,420);
						t6.setResizable(false);
						t6.setVisible(true);
						t5=new TableA5("NODE.A"+connect[5],attacker,size,connect);
						t5.setSize(250,200);  				
						t5.setLocation(0,420);
						t5.setResizable(false);
						t5.setVisible(true);
            			t4=new TableA4("NODE.A"+connect[4],attacker,size,connect);
						t4.setSize(250,200);  				
						t4.setLocation(520,210);
						t4.setResizable(false);
						t4.setVisible(true);
            			t3=new TableA3("NODE.A"+connect[3],attacker,size,connect);
						t3.setSize(250,200);  				
						t3.setLocation(260,210);
						t3.setResizable(false);
						t3.setVisible(true);
            			ts=new TableA("STARTNODE.A",attacker,size,connect);
						ts.setSize(250,200);  				
						ts.setLocation(0,0);
						ts.setResizable(false);
						ts.setVisible(true);
						te=new TableA8("ENDNODE.A",attacker,size,connect);
						te.setSize(250,200);  				
						te.setLocation(0,210);
						te.setResizable(false);
						te.setVisible(true);
						t1=new TableA1("NODE.A"+connect[1],attacker,size,connect);
						t1.setSize(250,200);  				
						t1.setLocation(260,0);
						t1.setResizable(false);
						t1.setVisible(true);
						t2=new TableA2("NODE.A"+connect[2],attacker,size,connect);
						t2.setSize(250,200);  				
						t2.setLocation(520,0);
						t2.setResizable(false);
						t2.setVisible(true);
					    break;
            case 9:		TableA7 t7=new TableA7("NODE.A"+connect[7],attacker,size,connect);
						t7.setSize(250,200);  				
						t7.setLocation(520,420);
						t7.setResizable(false);
						t7.setVisible(true);
            			t6=new TableA6("NODE.A"+connect[6],attacker,size,connect);
						t6.setSize(250,200);  				
						t6.setLocation(260,420);
						t6.setResizable(false);
						t6.setVisible(true);
						t5=new TableA5("NODE.A"+connect[5],attacker,size,connect);
						t5.setSize(250,200);  				
						t5.setLocation(0,420);
						t5.setResizable(false);
						t5.setVisible(true);
            			t4=new TableA4("NODE.A"+connect[4],attacker,size,connect);
						t4.setSize(250,200);  				
						t4.setLocation(520,210);
						t4.setResizable(false);
						t4.setVisible(true);
            			t3=new TableA3("NODE.A"+connect[3],attacker,size,connect);
						t3.setSize(250,200);  				
						t3.setLocation(260,210);
						t3.setResizable(false);
						t3.setVisible(true);
            			ts=new TableA("STARTNODE.A",attacker,size,connect);
						ts.setSize(250,200);  				
						ts.setLocation(0,0);
						ts.setResizable(false);
						ts.setVisible(true);
						te=new TableA8("ENDNODE.A",attacker,size,connect);
						te.setSize(250,200);  				
						te.setLocation(0,210);
						te.setResizable(false);
						te.setVisible(true);
						t1=new TableA1("NODE.A"+connect[1],attacker,size,connect);
						t1.setSize(250,200);  				
						t1.setLocation(260,0);
						t1.setResizable(false);
						t1.setVisible(true);
						t2=new TableA2("NODE.A"+connect[2],attacker,size,connect);
						t2.setSize(250,200);  				
						t2.setLocation(520,0);
						t2.setResizable(false);
						t2.setVisible(true);
					    break;
			}
		}
	else if(ae.getActionCommand().equals("NEXT -->>"))
		{
			setVisible(false);
//			DecisionModule dm=new DecisionModule("MOBILE COMPUTING 3.3.1v",x2,y2,x3,y3,k,StartNode,EndNode,attacker,connect,size);
			Calculation c=new Calculation("MOBILE COMPUTING 3.3.1v",x2,y2,x3,y3,k,StartNode,EndNode,attacker,connect,size);
			Toolkit tk = Toolkit.getDefaultToolkit();  
			int xSize = ((int) tk.getScreenSize().getWidth());  
			int ySize = ((int) tk.getScreenSize().getHeight());  
			c.setSize(xSize,ySize);  				
			c.setResizable(false);
			c.setVisible(true);
		}
	}
}

class Calculation extends JFrame implements ActionListener
{
ImageIcon i1;
JLabel l1;
JButton jb1,jb2,jb3,jb4,jb5;
int size,k,attacker,StartNode,EndNode;
int[] x2 = new int[10];
int[] y2 = new int[10];
int[] x3 = new int[10];
int[] y3 = new int[10];
int[] xa = new int[20];
int[] ya = new int[20];
int[] connect = new int[10];
Container con;
Calculation(String str,int[] x1,int[] y1,int[] x4,int[] y4,int i,int StartNode1,int EndNode1,int attacker1,int[] connect1,int size1)
	{
	super(str);
	k=i;
	StartNode=StartNode1;
	EndNode=EndNode1;
	attacker=attacker1;
	size=size1;
	con=getContentPane();
	con.setLayout(null);
	con.setBackground(Color.white);
	for(int j=0;j<i;j++)
		{
		connect[j]=connect1[j];
		x2[j]=x1[j];
		y2[j]=y1[j];
		x3[j]=x4[j];
		y3[j]=y4[j];
		}
	for(int j=0,k=0;k<(i*2);j++)
		{
		xa[k]=x1[attacker1]+15;
		ya[k]=y1[attacker1]+45;
		k++;
		xa[k]=x1[j]+15;
		ya[k]=y1[j]+45;
		k++;
		}
	i1=new ImageIcon("step.png");
	l1=new JLabel("",i1,JLabel.LEFT);
	jb1=new JButton("STEP 1");
	jb2=new JButton("STEP 2");
	jb3=new JButton("STEP 3");
	jb4=new JButton("STEP 4");
	jb5=new JButton("EXIT");
	l1.setBounds(300,30,700,300);
	jb1.setBounds(340,320,80,20);
	jb2.setBounds(460,320,80,20);
	jb3.setBounds(600,320,80,20);
	jb4.setBounds(720,320,80,20);
	jb5.setBounds(520,620,100,20);
	con.add(l1);
	con.add(jb1);
	con.add(jb2);
	con.add(jb3);
	con.add(jb4);
	con.add(jb5);
	jb1.addActionListener(this);
	jb2.addActionListener(this);
	jb3.addActionListener(this);
	jb4.addActionListener(this);
	jb5.addActionListener(this);
	}

public void actionPerformed(ActionEvent ae)
	{
	if(ae.getActionCommand().equals("EXIT"))
		{
			JOptionPane.showMessageDialog(this,"CLOSING.\nCLICK OK.");
			System.exit(0);
		}
	else if(ae.getActionCommand().equals("STEP 1"))
		{
			if(k == 5)
			{
				Evidence e=new Evidence("EVIDENCE COLLECTION");
				e.setSize(600,350);
				e.setLocation(200,200);
				e.setResizable(false);
				e.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"EVIDENCE COLLECTION IS DONE.");
			}
		}
	else if(ae.getActionCommand().equals("STEP 2"))
		{
			if(k == 5)
			{
				Risk r=new Risk("RISK ASSESSMENT");
				r.setSize(600,350);
				r.setLocation(200,200);
				r.setResizable(false);
				r.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"RISK IS ASSESSED.");
			}
		}
	else if(ae.getActionCommand().equals("STEP 3"))
		{
			JOptionPane.showMessageDialog(this,"PROCESSING YOUR REQUEST.\nCLICK OK.");
			k=k--;
			DecisionModule dm=new DecisionModule("MOBILE COMPUTING 3.3.1v",x2,y2,x3,y3,k,StartNode,EndNode,attacker,connect,size);
			Toolkit tk = Toolkit.getDefaultToolkit();  
			int xSize = ((int) tk.getScreenSize().getWidth());  
			int ySize = ((int) tk.getScreenSize().getHeight());  
			dm.setSize(xSize,ySize);  				
			dm.setResizable(false);
			dm.setVisible(true);
		}
	else if(ae.getActionCommand().equals("STEP 4"))
		{
			JOptionPane.showMessageDialog(this,"RESPONSE IS DONE.");
		}
	}
}

class Evidence extends JFrame
{
JLabel[] l1=new JLabel[5];
JLabel[] l2=new JLabel[5];
JLabel[] l3=new JLabel[5];
JLabel l4,l5,l6;
Container con;
Evidence(String str)
	{
	super(str);
	con=getContentPane();
	con.setLayout(null);
	con.setBackground(Color.white);
	l1[0]=new JLabel("EVIDENCE 1 = 0.8");
	l1[1]=new JLabel("EVIDENCE 2 = 0");
	l1[2]=new JLabel("EVIDENCE 3 = 0.6");
	l1[3]=new JLabel("EVIDENCE 4 = 0.5");
	l1[4]=new JLabel("EVIDENCE 5 = 0.5");
	l2[0]=new JLabel("EVIDENCE 1 = 0.8");
	l2[1]=new JLabel("EVIDENCE 2 = 0");
	l2[2]=new JLabel("EVIDENCE 3 = 0");
	l2[3]=new JLabel("EVIDENCE 4 = 0");
	l2[4]=new JLabel("EVIDENCE 5 = 0");
	l3[0]=new JLabel("EVIDENCE 1 = 0.8");
	l3[1]=new JLabel("EVIDENCE 2 = 0");
	l3[2]=new JLabel("EVIDENCE 3 = 0.16");
	l3[3]=new JLabel("EVIDENCE 4 = 0");
	l3[4]=new JLabel("EVIDENCE 5 = 0");
	l4=new JLabel("START NODE");
	l5=new JLabel("NODE 1");
	l6=new JLabel("NODE 2");
	l4.setBounds(110,1,480,90);
	l5.setBounds(270,1,480,90);
	l6.setBounds(400,1,480,90);
	l1[0].setBounds(90,30,480,90);
	l1[1].setBounds(90,60,480,90);
	l1[2].setBounds(90,90,480,90);
	l1[3].setBounds(90,120,480,90);
	l1[4].setBounds(90,150,480,90);
	l2[0].setBounds(250,30,480,90);
	l2[1].setBounds(250,60,480,90);
	l2[2].setBounds(250,90,480,90);
	l2[3].setBounds(250,120,480,90);
	l2[4].setBounds(250,150,480,90);
	l3[0].setBounds(390,30,480,90);
	l3[1].setBounds(390,60,480,90);
	l3[2].setBounds(390,90,480,90);
	l3[3].setBounds(390,120,480,90);
	l3[4].setBounds(390,150,480,90);
	for(int i=0;i<5;i++)
		{
		con.add(l1[i]);
		}
	for(int i=0;i<5;i++)
		{
		con.add(l2[i]);
		}
	for(int i=0;i<5;i++)
		{
		con.add(l3[i]);
		}
	con.add(l4);
	con.add(l5);
	con.add(l6);
	}
}

class Risk extends JFrame
{
JLabel l1,l2,l3,l4,l5;
Container con;
Risk(String str)
	{
	super(str);
	con=getContentPane();
	con.setLayout(null);
	con.setBackground(Color.white);
	l1=new JLabel("RISK OF START NODE = 0.4534");
	l2=new JLabel("RISK OF NODE 1 = -0.01005");
	l3=new JLabel("RISK OF NODE 2 = -0.096");
	l4=new JLabel("UPPER THRESHOLD = 1");
	l5=new JLabel("LOWER THRESHOLD = -0.0017");
	l1.setBounds(110,60,480,90);
	l2.setBounds(110,110,480,90);
	l3.setBounds(110,160,480,90);
	l4.setBounds(360,85,480,90);
	l5.setBounds(360,135,480,90);
	con.add(l1);
	con.add(l2);
	con.add(l3);
	con.add(l4);
	con.add(l5);
	}
}

class TableA extends JFrame
{
int size,attacker;
JTable jt;
JScrollPane scrollPane;
Container con;
int[] connect = new int[10];
TableA(String s,int attacker1,int size1,int[] connect1)
	{
	super(s);
	size=size1;
	attacker=attacker1;
	for(int j=0;j<size;j++)
		{
		connect[j]=connect1[j];
		}
	int cols=3,temp=1;
	int rows=size;
	String head[]=new String[cols];
	String data[][]=new String[rows][cols];
	head[0]="Des";
	head[1]="Next";
	head[2]="Dis";
	for(int a=0;a<rows-1;a++)
		{
		for(int b=0;b<cols;b++)
			{
			if(b == 0)
				{
				data[a][b]=""+connect[a+1];
				}
			if(b == 1)
				{
				if(a==0)
					{
					data[a][b]=""+connect[1];
					}
				else
					{
					data[a][b]=""+attacker;
					}
				}
			if(b == 2)
				{
				if((Integer.parseInt(data[a][0]) == connect[1]))
					{
					data[a][b]="1";
					}
				else
					{
					data[a][b]="2";
					}
				}
			}
		}
	for(int a=0;a<cols;a++)
		{
		if(a == 0)
			{
			data[rows-1][a]="EndNode";
			}
		if(a == 1)
			{
			if(size == 2)
				{
				data[rows-1][a]=""+connect[1];
				}
			else
				{
				data[rows-1][a]=""+attacker;
				}
			}
		if(a == 2)
			{
			if(size == 2)
				{
				data[rows-1][a]="1";
				}
			else
				{
				data[rows-1][a]="2";
				}
			}
		}
	jt=new JTable(data,head);
	int x=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	int y=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	scrollPane = new JScrollPane(jt,y,x);
	con=getContentPane();
	con.setLayout(new BorderLayout());
	con.add(scrollPane);
	}
}

class TableA1 extends JFrame
{
int size,attacker;
JTable jt;
JScrollPane scrollPane;
Container con;
int[] connect = new int[10];
TableA1(String s,int attacker1,int size1,int[] connect1)
	{
	super(s);
	attacker=attacker1;
	size=size1+1;
	for(int j=0;j<size;j++)
		{
		connect[j]=connect1[j];
		}
	int cols=3;
	int rows=size;
	String head[]=new String[cols];
	String data[][]=new String[rows][cols];
	head[0]="Des";
	head[1]="Next";
	head[2]="Dis";
	for(int a=0;a<rows-1;a++)
		{
		for(int b=0;b<cols;b++)
			{
			if(b == 0)
				{
				if(a == 0)
					{
					data[a][b]="StartNode";
					}
				else if(a == 1)
					{
					data[a][b]="1";
					}
				else
					{
					data[a][b]=""+connect[a];
					}
				}
			if(b == 1)
				{
				if(a == 1)
					{
					data[a][b]="1";
					}
				else
					{
					if(a<1)
						{
						data[a][b]="StartNode";
						}
					if(a>1)
						{
						if(Integer.parseInt(data[a][0]) == connect[2])
							{
							data[a][b]=""+connect[2];
							}
						else
							{
							data[a][b]=""+attacker;
							}
						}
					}
				}
			if(b == 2)
				{
				if(a == 1)
					{
					data[a][b]="0";
					}
				else
					{
					if(a<1)
						{
						data[a][b]="1";
						}
					if(a>1)
						{
						if((Integer.parseInt(data[a][0]) == connect[2]))
							{
							data[a][b]="1";
							}
						else
							{
							data[a][b]="2";
							}
						}
					}
				}
			}
		}
	for(int a=0;a<cols;a++)
		{
		if(a == 0)
			{
			data[rows-1][a]="EndNode";
			}
		if(a == 1)
			{
			if(size == 3)
				{
				data[rows-1][a]="EndNode";
				}
			else
				{
				data[rows-1][a]="attacker";
				}
			}
		if(a == 2)
			{
			if(size == 3)
				{
				data[rows-1][a]="1";
				}
			else
				{
				data[rows-1][a]="2";
				}
			}
		}
	jt=new JTable(data,head);
	int x=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	int y=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	scrollPane = new JScrollPane(jt,y,x);
	con=getContentPane();
	con.setLayout(new BorderLayout());
	con.add(scrollPane);
	}
}

class TableA2 extends JFrame
{
int size,attacker;
JTable jt;
JScrollPane scrollPane;
Container con;
int[] connect = new int[10];
TableA2(String s,int attacker1,int size1,int[] connect1)
	{
	super(s);
	size=size1+1;
	attacker=attacker1;
	for(int j=0;j<size;j++)
		{
		connect[j]=connect1[j];
		}
	int cols=3;
	int rows=size;
	String head[]=new String[cols];
	String data[][]=new String[rows][cols];
	head[0]="Des";
	head[1]="Next";
	head[2]="Dis";
	for(int a=0;a<rows-1;a++)
		{
		for(int b=0;b<cols;b++)
			{
			if(b == 0)
				{
				if(a == 0)
					{
					data[a][b]="StartNode";
					}
				else if(a == 2)
					{
					data[a][b]="2";
					}
				else
					{
					data[a][b]=""+connect[a];
					}
				}
			if(b == 1)
				{
				if(a == 2)
					{
					data[a][b]="2";
					}
				else
					{
					if(a<2)
						{
						if(a == 0)
							{
							data[a][b]=""+attacker;
							}
						else
							{
							data[a][b]=""+connect[1];
							}
						}
					if(a>2)
						{
						if(Integer.parseInt(data[a][0]) == connect[3])
							{
							data[a][b]=""+connect[3];
							}
						else
							{
							data[a][b]=""+attacker;
							}
						}
					}
				}
			if(b == 2)
				{
				if(a == 2)
					{
					data[a][b]="0";
					}
				else
					{
					if(a<2)
						{
						if(a == 1)
							{
							data[a][b]="1";
							}
						else
							{
							data[a][b]="2";
							}
						}
					if(a>2)
						{
						if((Integer.parseInt(data[a][0]) == connect[3]))
							{
							data[a][b]="1";
							}
						else
							{
							data[a][b]="2";
							}
						}
					}
				}
			}
		}
	for(int a=0;a<cols;a++)
		{
		if(a == 0)
			{
			data[rows-1][a]="EndNode";
			}
		if(a == 1)
			{
			if(size == 4)
				{
				data[rows-1][a]="EndNode";
				}
			else
				{
				data[rows-1][a]="attacker";
				}
			}
		if(a == 2)
			{
			if(size == 4)
				{
				data[rows-1][a]="1";
				}
			else
				{
				data[rows-1][a]="2";
				}
			}
		}
	jt=new JTable(data,head);
	int x=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	int y=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	scrollPane = new JScrollPane(jt,y,x);
	con=getContentPane();
	con.setLayout(new BorderLayout());
	con.add(scrollPane);
	}
}

class TableA3 extends JFrame
{
int size,attacker;
JTable jt;
JScrollPane scrollPane;
Container con;
int[] connect = new int[10];
TableA3(String s,int attacker1,int size1,int[] connect1)
	{
	super(s);
	size=size1+1;
	attacker=attacker1;
	for(int j=0;j<size;j++)
		{
		connect[j]=connect1[j];
		}
	int cols=3;
	int rows=size;
	String head[]=new String[cols];
	String data[][]=new String[rows][cols];
	head[0]="Des";
	head[1]="Next";
	head[2]="Dis";
	for(int a=0;a<rows-1;a++)
		{
		for(int b=0;b<cols;b++)
			{
			if(b == 0)
				{
				if(a == 0)
					{
					data[a][b]="StartNode";
					}
				else if(a == 3)
					{
					data[a][b]="3";
					}
				else
					{
					data[a][b]=""+connect[a];
					}
				}
			if(b == 1)
				{
				if(a == 3)
					{
					data[a][b]="3";
					}
				else
					{
					if(a<3)
						{
						if(a == 2)
							{
							data[a][b]=""+connect[2];
							}
						else
							{
							data[a][b]=""+attacker;
							}
						}
					if(a>3)
						{
						if(Integer.parseInt(data[a][0]) == connect[4])
							{
							data[a][b]=""+connect[4];
							}
						else
							{
							data[a][b]=""+attacker;
							}
						}
					}
				}
			if(b == 2)
				{
				if(a == 3)
					{
					data[a][b]="0";
					}
				else
					{
					if(a<3)
						{
						if(a == 2)
							{
							data[a][b]="1";
							}
						else
							{
							data[a][b]="2";
							}
						}
					if(a>3)
						{
						if((Integer.parseInt(data[a][0]) == connect[4]))
							{
							data[a][b]="1";
							}
						else
							{
							data[a][b]="2";
							}
						}
					}
				}
			}
		}
	for(int a=0;a<cols;a++)
		{
		if(a == 0)
			{
			data[rows-1][a]="EndNode";
			}
		if(a == 1)
			{
			if(size == 5)
				{
				data[rows-1][a]="EndNode";
				}
			else
				{
				data[rows-1][a]="attacker";
				}
			}
		if(a == 2)
			{
			if(size == 5)
				{
				data[rows-1][a]="1";
				}
			else
				{
				data[rows-1][a]="2";
				}
			}
		}
	jt=new JTable(data,head);
	int x=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	int y=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	scrollPane = new JScrollPane(jt,y,x);
	con=getContentPane();
	con.setLayout(new BorderLayout());
	con.add(scrollPane);
	}
}

class TableA4 extends JFrame
{
int size,attacker;
JTable jt;
JScrollPane scrollPane;
Container con;
int[] connect = new int[10];
TableA4(String s,int attacker1,int size1,int[] connect1)
	{
	super(s);
	size=size1+1;
	attacker=attacker1;
	for(int j=0;j<size;j++)
		{
		connect[j]=connect1[j];
		}
	int cols=3;
	int rows=size;
	String head[]=new String[cols];
	String data[][]=new String[rows][cols];
	head[0]="Des";
	head[1]="Next";
	head[2]="Dis";
	for(int a=0;a<rows-1;a++)
		{
		for(int b=0;b<cols;b++)
			{
			if(b == 0)
				{
				if(a == 0)
					{
					data[a][b]="StartNode";
					}
				else if(a == 4)
					{
					data[a][b]="4";
					}
				else
					{
					data[a][b]=""+connect[a];
					}
				}
			if(b == 1)
				{
				if(a == 4)
					{
					data[a][b]="4";
					}
				else
					{
					if(a<4)
						{
						if(a == 3)
							{
							data[a][b]=""+connect[3];
							}
						else
							{
							data[a][b]=""+attacker;
							}
						}
					if(a>4)
						{
						if(Integer.parseInt(data[a][0]) == connect[5])
							{
							data[a][b]=""+connect[5];
							}
						else
							{
							data[a][b]=""+attacker;
							}
						}
					}
				}
			if(b == 2)
				{
				if(a == 4)
					{
					data[a][b]="0";
					}
				else
					{
					if(a<4)
						{
						if(a == 3)
							{
							data[a][b]="1";
							}
						else
							{
							data[a][b]="2";
							}
						}
					if(a>4)
						{
						if((Integer.parseInt(data[a][0]) == connect[5]))
							{
							data[a][b]="1";
							}
						else
							{
							data[a][b]="2";
							}
						}
					}
				}
			}
		}
	for(int a=0;a<cols;a++)
		{
		if(a == 0)
			{
			data[rows-1][a]="EndNode";
			}
		if(a == 1)
			{
			if(size == 6)
				{
				data[rows-1][a]="EndNode";
				}
			else
				{
				data[rows-1][a]="attacker";
				}
			}
		if(a == 2)
			{
			if(size == 6)
				{
				data[rows-1][a]="1";
				}
			else
				{
				data[rows-1][a]="2";
				}
			}
		}
	jt=new JTable(data,head);
	int x=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	int y=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	scrollPane = new JScrollPane(jt,y,x);
	con=getContentPane();
	con.setLayout(new BorderLayout());
	con.add(scrollPane);
	}
}

class TableA5 extends JFrame
{
int size,attacker;
JTable jt;
JScrollPane scrollPane;
Container con;
int[] connect = new int[10];
TableA5(String s,int attacker1,int size1,int[] connect1)
	{
	super(s);
	size=size1+1;
	attacker=attacker1;
	for(int j=0;j<size;j++)
		{
		connect[j]=connect1[j];
		}
	int cols=3;
	int rows=size;
	String head[]=new String[cols];
	String data[][]=new String[rows][cols];
	head[0]="Des";
	head[1]="Next";
	head[2]="Dis";
	for(int a=0;a<rows-1;a++)
		{
		for(int b=0;b<cols;b++)
			{
			if(b == 0)
				{
				if(a == 0)
					{
					data[a][b]="StartNode";
					}
				else if(a == 5)
					{
					data[a][b]="5";
					}
				else
					{
					data[a][b]=""+connect[a];
					}
				}
			if(b == 1)
				{
				if(a == 5)
					{
					data[a][b]="5";
					}
				else
					{
					if(a<5)
						{
						if(a == 4)
							{
							data[a][b]=""+connect[4];
							}
						else
							{
							data[a][b]=""+attacker;
							}
						}
					if(a>5)
						{
						if(Integer.parseInt(data[a][0]) == connect[6])
							{
							data[a][b]=""+connect[6];
							}
						else
							{
							data[a][b]=""+attacker;
							}
						}
					}
				}
			if(b == 2)
				{
				if(a == 5)
					{
					data[a][b]="0";
					}
				else
					{
					if(a<5)
						{
						if(a == 4)
							{
							data[a][b]="1";
							}
						else
							{
							data[a][b]="2";
							}
						}
					if(a>5)
						{
						if((Integer.parseInt(data[a][0]) == connect[6]))
							{
							data[a][b]="1";
							}
						else
							{
							data[a][b]="2";
							}
						}
					}
				}
			}
		}
	for(int a=0;a<cols;a++)
		{
		if(a == 0)
			{
			data[rows-1][a]="EndNode";
			}
		if(a == 1)
			{
			if(size == 7)
				{
				data[rows-1][a]="EndNode";
				}
			else
				{
				data[rows-1][a]="attacker";
				}
			}
		if(a == 2)
			{
			if(size == 7)
				{
				data[rows-1][a]="1";
				}
			else
				{
				data[rows-1][a]="2";
				}
			}
		}
	jt=new JTable(data,head);
	int x=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	int y=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	scrollPane = new JScrollPane(jt,y,x);
	con=getContentPane();
	con.setLayout(new BorderLayout());
	con.add(scrollPane);
	}
}

class TableA6 extends JFrame
{
int size,attacker;
JTable jt;
JScrollPane scrollPane;
Container con;
int[] connect = new int[10];
TableA6(String s,int attacker1,int size1,int[] connect1)
	{
	super(s);
	size=size1+1;
	attacker=attacker1;
	for(int j=0;j<size;j++)
		{
		connect[j]=connect1[j];
		}
	int cols=3;
	int rows=size;
	String head[]=new String[cols];
	String data[][]=new String[rows][cols];
	head[0]="Des";
	head[1]="Next";
	head[2]="Dis";
	for(int a=0;a<rows-1;a++)
		{
		for(int b=0;b<cols;b++)
			{
			if(b == 0)
				{
				if(a == 0)
					{
					data[a][b]="StartNode";
					}
				else if(a == 6)
					{
					data[a][b]="6";
					}
				else
					{
					data[a][b]=""+connect[a];
					}
				}
			if(b == 1)
				{
				if(a == 6)
					{
					data[a][b]="6";
					}
				else
					{
					if(a<6)
						{
						if(a == 5)
							{
							data[a][b]=""+connect[5];
							}
						else
							{
							data[a][b]=""+attacker;
							}
						}
					if(a>6)
						{
						if(Integer.parseInt(data[a][0]) == connect[7])
							{
							data[a][b]=""+connect[7];
							}
						else
							{
							data[a][b]=""+attacker;
							}
						}
					}
				}
			if(b == 2)
				{
				if(a == 6)
					{
					data[a][b]="0";
					}
				else
					{
					if(a<6)
						{
						if(a == 5)
							{
							data[a][b]="1";
							}
						else
							{
							data[a][b]="2";
							}
						}
					if(a>6)
						{
						if((Integer.parseInt(data[a][0]) == connect[7]))
							{
							data[a][b]="1";
							}
						else
							{
							data[a][b]="2";
							}
						}
					}
				}
			}
		}
	for(int a=0;a<cols;a++)
		{
		if(a == 0)
			{
			data[rows-1][a]="EndNode";
			}
		if(a == 1)
			{
			if(size == 8)
				{
				data[rows-1][a]="EndNode";
				}
			else
				{
				data[rows-1][a]="attacker";
				}
			}
		if(a == 2)
			{
			if(size == 8)
				{
				data[rows-1][a]="1";
				}
			else
				{
				data[rows-1][a]="2";
				}
			}
		}
	jt=new JTable(data,head);
	int x=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	int y=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	scrollPane = new JScrollPane(jt,y,x);
	con=getContentPane();
	con.setLayout(new BorderLayout());
	con.add(scrollPane);
	}
}

class TableA7 extends JFrame
{
int size,attacker;
JTable jt;
JScrollPane scrollPane;
Container con;
int[] connect = new int[10];
TableA7(String s,int attacker1,int size1,int[] connect1)
	{
	super(s);
	size=size1+1;
	attacker=attacker1;
	for(int j=0;j<size;j++)
		{
		connect[j]=connect1[j];
		}
	int cols=3;
	int rows=size;
	String head[]=new String[cols];
	String data[][]=new String[rows][cols];
	head[0]="Des";
	head[1]="Next";
	head[2]="Dis";
	for(int a=0;a<rows-1;a++)
		{
		for(int b=0;b<cols;b++)
			{
			if(b == 0)
				{
				if(a == 0)
					{
					data[a][b]="StartNode";
					}
				else if(a == 7)
					{
					data[a][b]="7";
					}
				else
					{
					data[a][b]=""+connect[a];
					}
				}
			if(b == 1)
				{
				if(a == 7)
					{
					data[a][b]="7";
					}
				else
					{
					if(a<7)
						{
						if(a == 6)
							{
							data[a][b]=""+connect[6];
							}
						else
							{
							data[a][b]=""+attacker;
							}
						}
					if(a>7)
						{
						if(Integer.parseInt(data[a][0]) == connect[8])
							{
							data[a][b]=""+connect[8];
							}
						else
							{
							data[a][b]=""+attacker;
							}
						}
					}
				}
			if(b == 2)
				{
				if(a == 7)
					{
					data[a][b]="0";
					}
				else
					{
					if(a<7)
						{
						if(a == 6)
							{
							data[a][b]="1";
							}
						else
							{
							data[a][b]="2";
							}
						}
					if(a>7)
						{
						if((Integer.parseInt(data[a][0]) == connect[8]))
							{
							data[a][b]="1";
							}
						else
							{
							data[a][b]="2";
							}
						}
					}
				}
			}
		}
	for(int a=0;a<cols;a++)
		{
		if(a == 0)
			{
			data[rows-1][a]="EndNode";
			}
		if(a == 1)
			{
			if(size == 9)
				{
				data[rows-1][a]="EndNode";
				}
			else
				{
				data[rows-1][a]="attacker";
				}
			}
		if(a == 2)
			{
			if(size == 9)
				{
				data[rows-1][a]="1";
				}
			else
				{
				data[rows-1][a]="2";
				}
			}
		}
	jt=new JTable(data,head);
	int x=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	int y=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	scrollPane = new JScrollPane(jt,y,x);
	con=getContentPane();
	con.setLayout(new BorderLayout());
	con.add(scrollPane);
	}
}

class TableA8 extends JFrame
{
int size,attacker;
JTable jt;
JScrollPane scrollPane;
Container con;
int[] connect = new int[10];
TableA8(String s,int attacker1,int size1,int[] connect1)
	{
	super(s);
	size=size1+1;
	attacker=attacker1;
	for(int j=0;j<size;j++)
		{
		connect[j]=connect1[j];
		}
	int cols=3,temp=size-2;
	int rows=size;
	String head[]=new String[cols];
	String data[][]=new String[rows][cols];
	head[0]="Des";
	head[1]="Next";
	head[2]="Dis";
	for(int a=0;a<rows-1;a++)
		{
		for(int b=0;b<cols;b++)
			{
			if(b == 0)
				{
				if(a == 0)
					{
					data[a][b]="0";
					}
				else
					{
					data[a][b]=""+connect[a];
					}
				}
			if(b == 1)
				{
				if(Integer.parseInt(data[a][0]) == connect[temp])
					{
					data[a][b]=""+connect[temp];
					}
				else
					{
					data[a][b]=""+attacker;
					}
				}
			if(b == 2)
				{
				if((Integer.parseInt(data[a][0]) == connect[temp]))
					{
					data[a][b]="1";
					}
				else
					{
					data[a][b]="2";
					}
				}
			}
		}
	jt=new JTable(data,head);
	int x=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	int y=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	scrollPane = new JScrollPane(jt,y,x);
	con=getContentPane();
	con.setLayout(new BorderLayout());
	con.add(scrollPane);
	}
}

class DecisionModule extends JFrame implements ActionListener
{
ImageIcon i1,i2,i3,i4,i5;
JLabel l1,l4,l5,l6,l7,l8,l9,l10;
JButton jb4,jb2;
int size,k,temp=0,attacker,StartNode,EndNode;
JCheckBox[] checkBoxes=new JCheckBox[10];
int[] x2 = new int[10];
int[] y2 = new int[10];
int[] x3 = new int[10];
int[] y3 = new int[10];
int[] xa = new int[20];
int[] ya = new int[20];
int[] connect = new int[10];
Graphics g;
Container con;
DecisionModule(String str,int[] x1,int[] y1,int[] x4,int[] y4,int i,int StartNode1,int EndNode1,int attacker1,int[] connect1,int size1)
	{
	super(str);
	k=i;
	StartNode=StartNode1;
	EndNode=EndNode1;
	attacker=attacker1;
	size=size1+1;
	con=getContentPane();
	con.setLayout(null);
	con.setBackground(Color.white);
	i1=new ImageIcon("image1.png");
	i2=new ImageIcon("offButton.png");
	i3=new ImageIcon("StartNode.jpg");
	i4=new ImageIcon("EndNode.png");
	i5=new ImageIcon("attacker.png");
	l1=new JLabel("",i1,JLabel.LEFT);
	l4=new JLabel("Original link");
	l5=new JLabel("Attacker's link");
	l6=new JLabel("Fake link");
	l7=new JLabel("CLICK HERE TO ISOLATE THE CONNECTIONS(AFTER RISK CALC.) -->> ");
	l8=new JLabel("StartNode -->>  "+StartNode);
	l9=new JLabel("EndNode   -->>  "+EndNode);
	l10=new JLabel("Attacker  -->>  "+attacker);
	jb2=new JButton("CLOSE");
	jb4=new JButton("CLICK");
	for(int j=0;j<i;j++)
		{
		connect[j]=connect1[j];
		if(j == StartNode)
			{
			checkBoxes[j]=new JCheckBox("StartNode",i3,false);
			checkBoxes[j].setBounds(x1[j],y1[j],105,45);
			x2[j]=x1[j];
			y2[j]=y1[j];
			x3[j]=x4[j];
			y3[j]=y4[j];
			checkBoxes[j].setBackground(Color.white);
			con.add(checkBoxes[j]);
			}
		else if(j == EndNode)
			{
			checkBoxes[j]=new JCheckBox("EndNode",i4,false);
			checkBoxes[j].setBounds(x1[j],y1[j],105,45);
			x2[j]=x1[j];
			y2[j]=y1[j];
			x3[j]=x4[j];
			y3[j]=y4[j];
			checkBoxes[j].setBackground(Color.white);
			con.add(checkBoxes[j]);
			}
		else if(j == attacker1)
			{
			checkBoxes[j]=new JCheckBox("Attacker",i5,false);
			checkBoxes[j].setBounds(x1[j],y1[j],105,45);
			x2[j]=x1[j];
			y2[j]=y1[j];
			x3[j]=x4[j];
			y3[j]=y4[j];
			checkBoxes[j].setBackground(Color.white);
			con.add(checkBoxes[j]);
			}
		else
			{
			checkBoxes[j]=new JCheckBox(""+j,i2,false);
			checkBoxes[j].setBounds(x1[j],y1[j],55,45);
			x2[j]=x1[j];
			y2[j]=y1[j];
			x3[j]=x4[j];
			y3[j]=y4[j];
			checkBoxes[j].setBackground(Color.white);
			con.add(checkBoxes[j]);
			}
		}
	for(int j=0,k=0;k<(i*2);j++)
		{
		xa[k]=x1[attacker1]+15;
		ya[k]=y1[attacker1]+45;
		k++;
		xa[k]=x1[j]+15;
		ya[k]=y1[j]+45;
		k++;
		}
	l1.setBounds(300,10,500,90);
	l4.setBounds(820,110,100,20);
	l5.setBounds(820,140,100,20);
	l6.setBounds(820,170,100,20);
	l7.setBounds(320,70,430,90);
	l8.setBounds(820,200,200,20);
	l9.setBounds(820,230,200,20);
	l10.setBounds(820,260,200,20);
	jb4.setBounds(715,105,80,20);
	jb2.setBounds(500,640,80,20);
	con.add(l1);
	con.add(l4);
	con.add(l5);
	con.add(l6);
	con.add(l7);
	con.add(l8);
	con.add(l9);
	con.add(l10);
	con.add(jb4);
	con.add(jb2);
	jb4.addActionListener(this);
	jb2.addActionListener(this);
	}

public void paint(Graphics g)
	{
	super.paint(g);
    g.setColor(Color.BLACK);
	g.drawPolyline(x3,y3,size);
	g.setColor(Color.RED);
	g.drawPolyline(xa,ya,(k)*2);
	g.setColor(Color.BLUE);
	g.drawLine(x2[attacker]+15,y2[attacker]+45,x2[EndNode]+15,y2[EndNode]+45);
    g.setColor(Color.BLACK);
	g.drawLine(920,150,970,150);
	g.setColor(Color.RED);
	g.drawLine(920,180,970,180);
	g.setColor(Color.BLUE);
	g.drawLine(920,210,970,210);
	}

public void actionPerformed(ActionEvent ae)
	{
	if(ae.getActionCommand().equals("CLOSE"))
		{
			JOptionPane.showMessageDialog(this,"CLOSING.\nCLICK OK.");
			setVisible(false);
		}
	else if(ae.getActionCommand().equals("CLICK"))
		{
		Random r = new Random();
		switch (size)
			{
            case 3:		JOptionPane.showMessageDialog(this,"NO ISOLATION OF CONNECTIONS REQUIRED.");
						break;
            case 4:		JOptionPane.showMessageDialog(this,"ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.");
					    break;
            case 5: 	int i2=r.nextInt(3)+1;
						if(i2 == 1)
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[1]+" AND ATTACKER CONNECTION IS REQUIRED.");
							}
						else if(i2 == 2)
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF ENDNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[size-2]+" AND ATTACKER CONNECTION IS REQUIRED.");
							}
						else
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF ENDNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.");
							}
					    break;
            case 6:		int i3=r.nextInt(4)+1;
						if(i3 == 1)
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[1]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF NODE"+connect[2]+" AND ATTACKER CONNECTION IS REQUIRED.");
							}
						else if(i3 == 2)
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF ENDNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[size-3]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF NODE"+connect[size-2]+" AND ATTACKER CONNECTION IS REQUIRED.");
							}
						else if(i3 == 3)
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[1]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF ENDNODE AND ATTACKER CONNECTION IS REQUIRED.");
							}
						else
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF ENDNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[size-2]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.");
							}
					    break;
            case 7: 	int i4=r.nextInt(5)+1;
						if(i4 == 1)
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[1]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF NODE"+connect[2]+" AND ATTACKER CONNECTION IS REQUIRED.\n 4. ISOLATION OF NODE"+connect[3]+" AND ATTACKER CONNECTION IS REQUIRED.");
							}
						else if(i4 == 2)
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF ENDNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[size-4]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF NODE"+connect[size-3]+" AND ATTACKER CONNECTION IS REQUIRED.\n 4. ISOLATION OF NODE"+connect[size-2]+" AND ATTACKER CONNECTION IS REQUIRED.");
							}
						else if(i4 == 3)
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[1]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF NODE"+connect[2]+" AND ATTACKER CONNECTION IS REQUIRED.\n 4. ISOLATION OF ENDNODE AND ATTACKER CONNECTION IS REQUIRED.");
							}
						else if(i4 == 4)
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF ENDNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[size-2]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF NODE"+connect[size-3]+" AND ATTACKER CONNECTION IS REQUIRED.\n 4. ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.");
							}
						else
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF ENDNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[size-2]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF NODE"+connect[1]+" AND ATTACKER CONNECTION IS REQUIRED.\n 4. ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.");
							}
					    break;
            case 8: 	int i5=r.nextInt(6)+1;
						if(i5 == 1)
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[1]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF NODE"+connect[2]+" AND ATTACKER CONNECTION IS REQUIRED.\n 4. ISOLATION OF NODE"+connect[3]+" AND ATTACKER CONNECTION IS REQUIRED.\n 5. ISOLATION OF NODE"+connect[4]+" AND ATTACKER CONNECTION IS REQUIRED.");
							}
						else if(i5 == 2)
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF ENDNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[size-5]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF NODE"+connect[size-4]+" AND ATTACKER CONNECTION IS REQUIRED.\n 4. ISOLATION OF NODE"+connect[size-3]+" AND ATTACKER CONNECTION IS REQUIRED.\n 5. ISOLATION OF NODE"+connect[size-2]+" AND ATTACKER CONNECTION IS REQUIRED.");
							}
						else if(i5 == 3)
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[1]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF NODE"+connect[2]+" AND ATTACKER CONNECTION IS REQUIRED.\n 4. ISOLATION OF NODE"+connect[3]+" AND ATTACKER CONNECTION IS REQUIRED.\n 5. ISOLATION OF ENDNODE AND ATTACKER CONNECTION IS REQUIRED.");
							}
						else if(i5 == 4)
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF ENDNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[size-4]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF NODE"+connect[size-3]+" AND ATTACKER CONNECTION IS REQUIRED.\n 4. ISOLATION OF NODE"+connect[size-2]+" AND ATTACKER CONNECTION IS REQUIRED.\n 5. ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.");
							}
						else if(i5 == 5)
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF ENDNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[size-4]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.\n 4. ISOLATION OF NODE"+connect[1]+" AND ATTACKER CONNECTION IS REQUIRED.\n 5. ISOLATION OF NODE"+connect[2]+" AND ATTACKER CONNECTION IS REQUIRED.");
							}
						else
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF ENDNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[size-4]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF NODE"+connect[size-3]+" AND ATTACKER CONNECTION IS REQUIRED.\n 4. ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.\n 5. ISOLATION OF NODE"+connect[1]+" AND ATTACKER CONNECTION IS REQUIRED.");
							}
					    break;
            case 9:		int i6=r.nextInt(7)+1;
						if(i6 == 1)
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[1]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF NODE"+connect[2]+" AND ATTACKER CONNECTION IS REQUIRED.\n 4. ISOLATION OF NODE"+connect[3]+" AND ATTACKER CONNECTION IS REQUIRED.\n 5. ISOLATION OF NODE"+connect[4]+" AND ATTACKER CONNECTION IS REQUIRED.\n 6. ISOLATION OF NODE"+connect[5]+" AND ATTACKER CONNECTION IS REQUIRED.");
							}
						else if(i6 == 2)
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF ENDNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[size-6]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF NODE"+connect[size-5]+" AND ATTACKER CONNECTION IS REQUIRED.\n 4. ISOLATION OF NODE"+connect[size-4]+" AND ATTACKER CONNECTION IS REQUIRED.\n 5. ISOLATION OF NODE"+connect[size-3]+" AND ATTACKER CONNECTION IS REQUIRED.\n 6. ISOLATION OF NODE"+connect[size-2]+" AND ATTACKER CONNECTION IS REQUIRED.");
							}
						else if(i6 == 3)
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[1]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF NODE"+connect[2]+" AND ATTACKER CONNECTION IS REQUIRED.\n 4. ISOLATION OF NODE"+connect[3]+" AND ATTACKER CONNECTION IS REQUIRED.\n 5. ISOLATION OF NODE"+connect[4]+" AND ATTACKER CONNECTION IS REQUIRED.\n 6. ISOLATION OF ENDNODE AND ATTACKER CONNECTION IS REQUIRED.");
							}
						else if(i6 == 4)
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF ENDNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[size-5]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF NODE"+connect[size-4]+" AND ATTACKER CONNECTION IS REQUIRED.\n 4. ISOLATION OF NODE"+connect[size-3]+" AND ATTACKER CONNECTION IS REQUIRED.\n 5. ISOLATION OF NODE"+connect[size-2]+" AND ATTACKER CONNECTION IS REQUIRED.\n 6. ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.");
							}
						else if(i6 == 5)
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[1]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF NODE"+connect[2]+" AND ATTACKER CONNECTION IS REQUIRED.\n 4. ISOLATION OF NODE"+connect[3]+" AND ATTACKER CONNECTION IS REQUIRED.\n 5. ISOLATION OF ENDNODE AND ATTACKER CONNECTION IS REQUIRED.\n 6. ISOLATION OF NODE"+connect[size-2]+" AND ATTACKER CONNECTION IS REQUIRED.");
							}
						else if(i6 == 6)
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF ENDNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[1]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF NODE"+connect[size-4]+" AND ATTACKER CONNECTION IS REQUIRED.\n 4. ISOLATION OF NODE"+connect[size-3]+" AND ATTACKER CONNECTION IS REQUIRED.\n 5. ISOLATION OF NODE"+connect[size-2]+" AND ATTACKER CONNECTION IS REQUIRED.\n 6. ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.");
							}
						else
							{
							JOptionPane.showMessageDialog(this,"1. ISOLATION OF ENDNODE AND ATTACKER CONNECTION IS REQUIRED.\n 2. ISOLATION OF NODE"+connect[size-4]+" AND ATTACKER CONNECTION IS REQUIRED.\n 3. ISOLATION OF NODE"+connect[size-3]+" AND ATTACKER CONNECTION IS REQUIRED.\n 4. ISOLATION OF STARTNODE AND ATTACKER CONNECTION IS REQUIRED.\n 5. ISOLATION OF NODE"+connect[1]+" AND ATTACKER CONNECTION IS REQUIRED.\n 6. ISOLATION OF NODE"+connect[2]+" AND ATTACKER CONNECTION IS REQUIRED.");
							}
					    break;
			}
		}
	}
}

class Path extends JFrame implements ActionListener
{
JLabel l1,l2,l3,l4;
JLabel[] label=new JLabel[10];
JTextField[] text=new JTextField[10];
JButton jb1;
int k,size,StartNode,EndNode;
Container con;
Path(String str,int i,int StartNode1,int EndNode1)
	{
	super(str);
	k=i;
	StartNode=StartNode1;
	EndNode=EndNode1;
	con=getContentPane();
	con.setLayout(null);
	con.setBackground(Color.white);
	l1=new JLabel("SET THE PATH SEQUENTIAL ORDER(FROM 1)");
	l2=new JLabel("NOTE :  ");
	l3=new JLabel("IF YOU DON'T WANT TO GIVE CONNECTION.");
	l4=new JLabel("PRESS -1");
	for(int a=0;a<i;a++)
		{
		size=40*(a+1);
		label[a]=new JLabel("NODE "+a+" -->> ");
		if(a == StartNode1)
			{
			text[a]=new JTextField("StartNode");
			}
		else if(a == EndNode1)
			{
			text[a]=new JTextField("EndNode");
			}
		else
			{
			text[a]=new JTextField();
			}
		label[a].setBounds(60,size,80,20);
		text[a].setBounds(160,size,80,20);
		con.add(label[a]);
		con.add(text[a]);
		}
	jb1=new JButton("NEXT -->>");
	l1.setBounds(30,20,250,20);
	l2.setBounds(130,size+80,50,20);
	l3.setBounds(30,size+100,250,20);
	l4.setBounds(125,size+120,70,20);
	jb1.setBounds(100,size+40,100,20);
	con.add(l1);
	con.add(l2);
	con.add(l3);
	con.add(l4);
	con.add(jb1);
	jb1.addActionListener(this);
	}

public void actionPerformed(ActionEvent ae)
	{
	if(ae.getActionCommand().equals("NEXT -->>"))
		{
		for(int a=0;a<k;a++)
			{
			if(text[a].getText().equals(""))
				{
				JOptionPane.showMessageDialog(this,"Assign all values.");
				setVisible(false);
				Path pt=new Path("PATH",k,StartNode,EndNode);
				pt.setSize(300,650);  				
				pt.setLocation(700,50);
				pt.setResizable(false);
				pt.setVisible(true);
				break;
				}
			else if(text[a].getText().equals("StartNode"))
				{
				NetworkSet.path[a]=StartNode;
				}
			else if(text[a].getText().equals("EndNode"))
				{
				NetworkSet.path[a]=EndNode;
				}
			else if((Integer.parseInt(text[a].getText().trim()) != -1))
				{
				NetworkSet.path[a]=Integer.parseInt(text[a].getText().trim());
				}
			else
				NetworkSet.path[a]=11;
			}
		setVisible(false);
		}
	}
}

class MainClass
{
public static void main(String args[])
	{
	Project p=new Project("MOBILE COMPUTING 3.3.1v");
	p.setSize(600,350);
	p.setLocation(250,250);
	p.setResizable(false);
	p.setVisible(true);
	}
}