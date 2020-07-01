package ui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Renderer extends JApplet
{
    public void init()
    {
        Container Cntnr = getContentPane();
        newModel NwModl = new newModel();
        newRenderer NwRndrer = new newRenderer();
        JList Lst = new JList(NwModl);
        Lst.setCellRenderer(NwRndrer);
        Lst.setVisibleRowCount(1);
        Cntnr.add(new JScrollPane(Lst));
    }
}
      class newModel extends DefaultListModel
       {
           public newModel()
           {
               for(int loop_indx = 0; loop_indx <= 0; loop_indx++)
                    {
                       addElement(new Object[] {""+ loop_indx,new ImageIcon("D:\\DDW assignment\\Images\\facebook.jpg")});
                    }
           }
       }
             class newRenderer extends JLabel implements ListCellRenderer
               {
                  public newRenderer()
                    {
                       setOpaque(true);
                    }
                       public Component getListCellRendererComponent(JList JLst, Object ob1, int indx, boolean isSelected,boolean Focus)
                         {
                             newModel Mdl = (newModel)JLst.getModel();
                             setText((String)((Object[])ob1)[0]);
                             setIcon((Icon)((Object[])ob1)[1]);
                             if(!isSelected)
                          {
                                 setBackground(JLst.getBackground());
                                setForeground(JLst.getForeground());
                              }
                                else
                            {
                                        setBackground(JLst.getSelectionBackground());
                                        setForeground(JLst.getSelectionForeground());
                                    }
                                        return this;
                          }
                }