
package modelos;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Player 
{
    private int x, y;
    private int dx, dy;
    private Image imagem;
    private int altura, largura;
    private List <Ataques> ataques;
    private boolean isVisivel;
    
    public Player()
    {
        this.x = 100;
        this.y = 100;
        isVisivel = true;
        
        ataques = new ArrayList<Ataques>();
    }
    
    public void load()
    {
        //Adicionando imagem ao personagem
        ImageIcon janela = new ImageIcon("res\\fatHero.png");
        imagem = janela.getImage();
        
        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
    }
    //Mover imagem do personagem
    public void update()
    {
        x += dx;
        y += dy;
    }
    
    public void ataqueSimples()
    {
        this.ataques.add(new Ataques(x+largura, y + (altura/2)));
    }
    
    public Rectangle getBounds()
    {
        return new Rectangle (x,y,largura,altura);
    }
    
    public void keyPressed(KeyEvent tecla)
    {
        int codigo = tecla.getKeyCode();
        
        if(codigo == KeyEvent.VK_A)
        {
            ataqueSimples();
        }
        
        if(codigo == KeyEvent.VK_UP)
        {
            dy = -3;
        }
        if(codigo == KeyEvent.VK_DOWN)
        {
            dy = 3;
        }
        if(codigo == KeyEvent.VK_LEFT)
        {
            dx = -3;
        }
        if(codigo == KeyEvent.VK_RIGHT)
        {
            dx = 3;
        }
    }
    
        public void keyReleased(KeyEvent tecla)
    {
        int codigo = tecla.getKeyCode();
        
        if(codigo == KeyEvent.VK_UP)
        {
            dy = 0;
        }
        if(codigo == KeyEvent.VK_DOWN)
        {
            dy = 0;
        }
        if(codigo == KeyEvent.VK_LEFT)
        {
            dx = 0;
        }
        if(codigo == KeyEvent.VK_RIGHT)
        {
            dx = 0;
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

    public Image getImagem() 
    {
        return imagem;
    }

    public List<Ataques> getAtaques() 
    {
        return ataques;
    }

    public boolean isIsVisivel() 
    {
        return isVisivel;
    }

    public void setIsVisivel(boolean isVisivel) 
    {
        this.isVisivel = isVisivel;
    }
    
    
    
    
}



