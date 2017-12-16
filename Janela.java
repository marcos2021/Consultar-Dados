import javax.swing.*;
import java.awt.*;
public class Janela extends JFrame
{
    public static void main(String[] args) {
       Janela jan = new Janela("Lucio", new Dimension(300,150));
       jan.show();   
    }
    public Janela(String titulo, Dimension tamanho)
    {
        setTitle(titulo);
        setSize(tamanho);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(150,200,0));
    }
}