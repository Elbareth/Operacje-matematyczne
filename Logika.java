package javaapplication1;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 *
 * @author izab
 */

class Ilocz extends JFrame{
    private JList lista = null;
    Ilocz(ArrayList<String> iloczyn){
        super("Suma");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(100, 100);        
        lista = new JList(iloczyn.toArray());
        setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
        lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        lista.setLayoutOrientation(JList.VERTICAL);
        lista.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(lista);
        listScroller.setPreferredSize(new Dimension(250, 80));
        add(listScroller);        
        setVisible(true);
    }
}

class Sumka extends JFrame{
    private JList lista = null;
    Sumka(ArrayList<String> suma){
        super("Suma");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(100, 100);        
        lista = new JList(suma.toArray());
        setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
        lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        lista.setLayoutOrientation(JList.VERTICAL);
        lista.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(lista);
        listScroller.setPreferredSize(new Dimension(250, 80));
        add(listScroller);        
        setVisible(true);
    }
}

class ZbiorAFrame extends JFrame{
    private JList lista = null;
    private ArrayList<String> ok;
    ZbiorAFrame(ArrayList <String> zbiorA){        
        super("Usuń element zbioru A");
        ok = zbiorA;
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(100, 100);        
        lista = new JList(zbiorA.toArray());
        setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
        lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        lista.setLayoutOrientation(JList.VERTICAL);
        lista.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(lista);
        listScroller.setPreferredSize(new Dimension(250, 80));
        add(listScroller);
        lista.addListSelectionListener(new Lista());
        setVisible(true);              
    }
    class Lista implements ListSelectionListener{
        @Override
        public void valueChanged(ListSelectionEvent e) {
            int index = lista.getSelectedIndex();            
            if(index != -1){
                ok.remove(index);
                lista.clearSelection();
                index = -1;
                setVisible(false);
                ZbiorAFrame frame = new ZbiorAFrame(ok);
            }
        }            
    }
}

class ZbiorBFrame extends JFrame{
    private JList lista = null;
    private ArrayList<String> ok;
    ZbiorBFrame(ArrayList <String> zbiorB){        
        super("Usuń element zbioru B");
        ok = zbiorB;
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(100, 100);        
        lista = new JList(ok.toArray());
        setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
        lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        lista.setLayoutOrientation(JList.VERTICAL);
        lista.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(lista);
        listScroller.setPreferredSize(new Dimension(250, 80));
        add(listScroller);
        lista.addListSelectionListener(new Lista());
        setVisible(true);              
    }
    class Lista implements ListSelectionListener{
        @Override
        public void valueChanged(ListSelectionEvent e) {
            int index = lista.getSelectedIndex();            
            if(index != -1){
                ok.remove(index);
                lista.clearSelection();
                index = -1;
                setVisible(false);
                ZbiorAFrame frame = new ZbiorAFrame(ok);
            }
        }            
    }
}

class MyFrame extends JFrame{
    private JButton zbiorA = new JButton("Dodaj do zbioru A");
    private JButton zbiorB = new JButton("Dodaj do zbioru B");
    private JButton usunA = new JButton("Usun ze zbioru A");
    private JButton usunB = new JButton("Usun ze zbioru B");
    private JButton suma = new JButton("Suma");
    private JButton iloczyn = new JButton("Iloczyn");
    private JTextField takA = new JTextField();
    private JTextField takB = new JTextField();
    private ArrayList <String> elementA = new ArrayList<String>();
    private ArrayList <String> elementB = new ArrayList<String>();
    public MyFrame(){
        super("Zbiory");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 100);
        setLayout(new GridLayout(2,4));
        add(zbiorA);        
        add(zbiorB);       
        add(usunA);
        add(suma);
        ///Drugi rzad
        add(takA);
        add(takB);
        add(usunB);
        add(iloczyn);
        zbiorA.addActionListener(new ZbiorA());
        zbiorB.addActionListener(new ZbiorB());
        usunA.addActionListener(new UsunA());
        usunB.addActionListener(new UsunB());
        suma.addActionListener(new Suma());
        iloczyn.addActionListener(new Iloczyn());
        setVisible(true);
    }
    class ZbiorA implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String tmp = takA.getText();
            elementA.add(tmp);
            takA.setText("");
       }    
    }
    class ZbiorB implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String tmp = takB.getText();
            elementB.add(tmp);
            takB.setText("");
       }    
    }
    class UsunA implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ZbiorAFrame frame  = new ZbiorAFrame(elementA);
        }
        
    }
    class UsunB implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ZbiorBFrame frame  = new ZbiorBFrame(elementB);
        }
        
    }
    class Suma implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<String> suma = new ArrayList<String>();
            for(String i : elementA){
                suma.add(i);
            }
            for(String i : elementB){
                if(suma.contains(i)){}
                else{
                    suma.add(i);
                }
            }
            Sumka s = new Sumka(suma);
        }        
    }
    class Iloczyn implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList <String> iloczyn  = new ArrayList<String>();
            for(String i : elementA){
                iloczyn.add(i);
            }
            for(String i : elementB){
                if(iloczyn.contains(i)){
                    iloczyn.remove(i);
                }
                else{
                    iloczyn.add(i);
                }
            }
            Ilocz il = new Ilocz(iloczyn);
        }        
    }
}

public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */    
    
    public static void main(String[] args){        
        MyFrame frame = new MyFrame();       
    }  
}
