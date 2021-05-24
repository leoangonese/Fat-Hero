package modelos;

import Fase.Fase;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class Container extends JFrame
{
    public Container()
    {
        //Adicionado novo da janela e tamanho da janela
        add(new Fase());
        setTitle("Fat Hero");
        setSize(1024,728);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        ImageIcon icone = new ImageIcon("res\\fatHero.png");
        this.setIconImage(icone.getImage());
        //TRAVAR mover janela e alterar resolução
        //(colocando em tela cheia ou não)
        this.setResizable(false);
        setVisible(true);
        
    }
    
    
    public static void main(String []args)
    {
        new Container();
    }
}
