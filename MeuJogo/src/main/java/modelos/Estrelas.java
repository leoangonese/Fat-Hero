package modelos;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;

public class Estrelas 
{
    private Image imagem;
    private int x,y;
    private int largura, altura;
    private boolean isVisivel;
    
    //private static final int LARGURA = 938;
    private static int VELOCIDADE = 2; 
    
    public Estrelas(int x, int y)
    {
        this.x = x;
        this.y = y;
        isVisivel = true;
    }
    
    public void load()
    {
        ImageIcon janela = new ImageIcon("res\\estrelas.png");
        imagem = janela.getImage();
        
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
    }
    
    public void update()
    {
        if(this.x < 0)
        {
            this.x = largura;
            Random a = new Random();
            int m = a.nextInt(500);
            this.x = m + 1024;
            Random r = new Random();
            int n = r.nextInt(768);
            this.y = n;
        } else 
        {
            this.x -= VELOCIDADE;
        }
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
        Estrelas.VELOCIDADE = VELOCIDADE;
    }

    public Image getImagem() {
        return imagem;
    }
    
    
    
}
