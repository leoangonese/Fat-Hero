package modelos;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Inimigo1 
{
    private Image imagem;
    private int x,y;
    private int largura, altura;
    private boolean isVisivel;
    
    //private static final int LARGURA = 938;
    private static int VELOCIDADE = 2; 
    
    public Inimigo1(int x, int y)
    {
        this.x = x;
        this.y = y;
        isVisivel = true;
    }
    
    public void load()
    {
        ImageIcon janela = new ImageIcon("res\\inimigo1.png");
        imagem = janela.getImage();
        
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
    }
    
    public void update()
    {
        this.x -= VELOCIDADE;
        //if(this.x > LARGURA)
       // {
            //isVisivel = false;
        //}
    }
    
    public Rectangle getBounds()
    {
        return new Rectangle (x,y,largura,altura);
    }

    public int getX() 
    {
        return x;
    }

    public int getY() 
    {
        return y;
    }

    public boolean isIsVisivel() 
    {
        return isVisivel;
    }

    public void setIsVisivel(boolean isVisivel) 
    {
        this.isVisivel = isVisivel;
    }

    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public static void setVELOCIDADE(int VELOCIDADE) 
    {
        Inimigo1.VELOCIDADE = VELOCIDADE;
    }

    public Image getImagem() {
        return imagem;
    }
    
    
    
}
