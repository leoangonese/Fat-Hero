package Fase;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import modelos.Ataques;
import modelos.Estrelas;
import modelos.Inimigo1;
import modelos.Player;

public class Fase extends JPanel implements ActionListener
{
    private Image fundo;
    private Player player;
    private Timer timer;
    private List<Inimigo1> inimigo1;
    private List<Estrelas> estrelas;
    private boolean emJogo;
    
    public Fase()
    {
        setFocusable(true);
        setDoubleBuffered(true);
        
        ImageIcon janela = new ImageIcon("res\\fundo.png");
        fundo = janela.getImage();
        
        player = new Player();
        player.load();
        
        addKeyListener(new TecladoAdapter());
        
        //Velocidade do jogo
        timer = new Timer(5,this);
        timer.start();
        
        inicializarInimigos();
        inicializarEstrelas();
        emJogo = true;
    }
    
    public void inicializarInimigos()
    {
        int coordenadas [ ] = new int [40]; 
        inimigo1 = new ArrayList<Inimigo1>();
        
        for(int i = 0; i < coordenadas.length; i++)
        {
            int x = (int)(Math.random() * 8000+1024);
            int y = (int)(Math.random() * 650+30);
            inimigo1.add(new Inimigo1(x,y));
        }
    }
    
    public void inicializarEstrelas()
    {
        int coordenadas [ ] = new int [100]; 
        estrelas = new ArrayList<Estrelas>();
        
        for(int i = 0; i < coordenadas.length; i++)
        {
            int x = (int)(Math.random() * 1024+0);
            int y = (int)(Math.random() * 768+30);
            estrelas.add(new Estrelas(x,y));
        }
    }
    
    public void paint(Graphics g)
    {
        Graphics2D grafico = (Graphics2D) g;
        
        if(emJogo == true)
        {
            grafico.drawImage(fundo, 0, 0, null);
            
            for(int p = 0; p < estrelas.size(); p++)
        {
            Estrelas q = estrelas.get(p);
            q.load();
            grafico.drawImage(q.getImagem(), q.getX(), q.getY(), this);
        }
            
            
        grafico.drawImage(player.getImagem(), player.getX(), player.getY(), this);
        
        List<Ataques> ataques = player.getAtaques();
        for(int i = 0; i < ataques.size(); i++)
        {
            Ataques m = ataques.get(i);
            m.load();
            grafico.drawImage(m.getImagem(), m.getX(), m.getY(), this);
        }
        
        for(int o = 0; o < inimigo1.size(); o++)
        {
            Inimigo1 in = inimigo1.get(o);
            in.load();
            grafico.drawImage(in.getImagem(), in.getX(),in.getY(), this);
        }
        }
        else
        {
            ImageIcon fimJogo = new ImageIcon("res\\fimdejogo.png");
            grafico.drawImage(fimJogo.getImage(), 0,0, null);
        }
                
        
        
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        player.update();
        
        for(int p = 0;p < estrelas.size();p++)
        {
            Estrelas on = estrelas.get(p);
            if(on.isIsVisivel())
            {
                on.update();
            }
            else
            {
                estrelas.remove(p);
            }
        }
        
        List<Ataques> ataques = player.getAtaques();
        for(int i = 0; i < ataques.size(); i++)
        {
            Ataques m = ataques.get(i);
            if(m.isIsVisivel())
            {
                m.update();
            }
            else
            {
                ataques.remove(i);
            }
        }
        
        for(int o = 0; o < inimigo1.size(); o++)
        {
            Inimigo1 in = inimigo1.get(o);
            if(in.isIsVisivel())
            {
                in.update();
            }
            else
            {
                inimigo1.remove(o);
            }
        }
        checarColisoes();
        repaint();
    }
    
    public void checarColisoes()
    {
        Rectangle formaNaruto = player.getBounds();
        Rectangle formaInimigo1;
        Rectangle formaAtaque;
        
        for(int i = 0; i < inimigo1.size(); i++)
        {
            Inimigo1 tempInimigo1 = inimigo1.get(i);
            formaInimigo1 = tempInimigo1.getBounds();
            
            if(formaNaruto.intersects(formaInimigo1))
            {
                player.setIsVisivel(false);
                tempInimigo1.setIsVisivel(false);
                emJogo = false;
            }
        }
        
        List<Ataques> ataques = player.getAtaques();
        for(int j = 0; j < ataques.size(); j++)
        {
            Ataques tempAtaque = ataques.get(j);
            formaAtaque = tempAtaque.getBounds();
            for(int o = 0; o < inimigo1.size(); o++)
            {
                Inimigo1 tempInimigo1 = inimigo1.get(o);
                formaInimigo1 = tempInimigo1.getBounds();
                if(formaAtaque.intersects(formaInimigo1))
                {
                    tempInimigo1.setIsVisivel(false);
                    tempAtaque.setIsVisivel(false);
                }
            }
        }
    }

    
    private class TecladoAdapter extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            player.keyPressed(e);
        }
        @Override
        public void keyReleased(KeyEvent e)
        {
            player.keyReleased(e);
        }
    }
  
}
