package edu.unbosque.interpreter.ide;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class Test extends Frame implements ActionListener
{
Button b;
TextArea t;
public Test()
{
setSize(200,200);
setVisible(true);
t=new TextArea("",10,30);
b=new Button("save_To_File");
setLayout(new FlowLayout());
add(t);
add(b);
b.addActionListener(this);
addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
});
}//end of constructor
public void actionPerformed(ActionEvent ae)
{
try
{
String s=t.getText();
if(s.length()>0)
{
FileDialog fd= new FileDialog(this,"Save File As",FileDialog.SAVE);
fd.setFile("temp.txt");
fd.setDirectory("c:\\windows\\temp");
fd.setVisible(true);
String path=fd.getDirectory()+fd.getFile();

FileOutputStream fos=new FileOutputStream(path);
System.out.println(s);
byte[] b=s.getBytes();
fos.write(b);
fos.close();
}
}catch(Exception e){System.out.println(e);}
}
public static void main(String args[])
{
new Test();
}
}