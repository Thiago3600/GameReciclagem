package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import model.latas;
import model.lixoTipo;


public class Janela extends JPanel{

    public int width;
    public int height;
    public int widthGame;
    public int heightGame;
    public int widthHelp;
    public int heightHelp;
    public ImageIcon fundo = new ImageIcon(getClass().getResource("/image/muro.jpg"));
    public ImageIcon plank = new ImageIcon(getClass().getResource("/image/plank.png"));
    public ImageIcon pause = new ImageIcon(getClass().getResource("/image/pause.png"));
    
    public Font fonte, fonteHelp, titulo, menu;
    
    int a, b, c, d, e;
    
    
    public Janela(int width, int height){
        setHeight(height);
        setWidth(width);
        setWidthHelp(getWidth()-getWidthGame());
        setHeightHelp(getHeight());
        setWidthGame(getWidth()-220);
        setHeightGame(getHeight()-220);
        
        fonte = new Font("Arial", Font.PLAIN, 28);
        fonteHelp = new Font("Arial", Font.BOLD, 18);
        titulo = new Font("Arial", Font.BOLD, 120);
        menu = new Font("Arial", Font.PLAIN, 80);
        
    }

    public int getWidthGame() {
        return widthGame;
    }

    public void setWidthGame(int widthGame) {
        this.widthGame = widthGame;
    }

    public int getHeightGame() {
        return heightGame;
    }

    public void setHeightGame(int heightGame) {
        this.heightGame = heightGame;
    }
      
    public int getWidth() {
        return width;
        
    }

    public final void setWidth(int width) {
        this.width = width;
    }

   
    public int getHeight() {
        return height;
    }

    public final void setHeight(int height) {
        this.height = height;
    }

    public int getWidthHelp() {
        return widthHelp;
    }

    public void setWidthHelp(int widthHelp) {
        this.widthHelp = widthHelp;
    }

    public int getHeightHelp() {
        return heightHelp;
    }

    public void setHeightHelp(int heightHelp) {
        this.heightHelp = heightHelp;
    }
    
    
    
    
    public void desenha(Graphics g, 
                        latas cesto[],
                        lixoTipo lixo[],
                        int level,
                        boolean fimDeJogo,
                        boolean pause,
                        boolean gameRunning,
                        String select[]){
        
        /*System.out.println("=========================");
        System.out.println("Fim de jogo = "+fimDeJogo);
        System.out.println("Pause = "+pause);
        System.out.println("gameRunnig = "+gameRunning);
*/
        int c = 450;
        
        
        
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        
        g.setFont(fonte);
        g.setColor(Color.white);
        
        if(!gameRunning && fimDeJogo){
            g.setFont(titulo);
            g.drawString("Recicla+",  getWidth()/4, getHeight()/6);
            g.setFont(menu);
            g.drawString(select[0]+"Iniciar",  getWidth()/3, getHeight()/2);
            g.drawString(select[1]+"Sair", getWidth()/3, g.getFontMetrics().getHeight()+(getHeight()/2));
        }
        
        
        if(gameRunning){
            
            g.drawImage(fundo.getImage(), 0, 70, null);
        
            g.drawImage(plank.getImage(), 0,getHeightGame()-20, null);

            g.setColor(Color.black);
            g.fillRect(getWidthGame(), 0, getWidth(), getHeight());

            for(int i = 0; i < lixo.length; i++){
                g.drawImage(lixo[0].helpCores(i+1), getWidthGame(), 100*(i+1), null);
                
                if(i+1==1)g.setColor(Color.blue);
                if(i+1==2)g.setColor(Color.green);
                if(i+1==3)g.setColor(Color.red);
                if(i+1==4)g.setColor(Color.yellow);
                if(i+1==5)g.setColor(new Color(210,105,30));
                
                
                g.setFont(fonteHelp);
                g.drawString(lixo[0].getNome(), getWidthGame()+lixo[0].getScaleX(), (100*(i+1))+lixo[0].getScaleY()/2);
            }

            g.setFont(fonte);
            g.setColor(Color.white);

            g.drawString(cesto[0].getHiScore(), getWidthGame()-50, 40);

            for(int i = 0; i<cesto[0].getVidas(); i++){
                g.drawImage(cesto[0].getCoracao(), c, 0, null);
                c+=cesto[0].getTamCoraX();
            }



            if(fimDeJogo){
                for(int i = 0; i<lixo.length; i++){
                    lixo[i].posInicial();
                }
            }

            for(int i = 0; i<lixo.length; i++){
                lixo[i].getObjetoPos(lixo, i);
            }

           if(!fimDeJogo && gameRunning){

               if(!pause){

                    g.drawString(cesto[0].tempo()+" Pontuação: "+cesto[0].getPonto(), 50, 40);

                    g.drawImage(cesto[0].getLata(), cesto[0].getEixoX(), cesto[0].getHeight(), null);

                    for(int i = 0; i<lixo.length-level; i++){
                        g.drawImage(lixo[i].randomLixo(), lixo[i].getPos(), lixo[i].queda(), null);
                    }
                    for(int i = 1; i<cesto.length; i++){
                        g.drawImage(cesto[i].getLata(), cesto[i].getCor(i), getHeightGame()+cesto[i].getTamY()+10, null);
                     }
               } else {
                  g.drawImage(cesto[0].getPause(), (getWidthGame()-cesto[0].getPauseTamX())/2, (getHeight()-cesto[0].getPauseTamY())/2, null); 
               }
           }else if(fimDeJogo && gameRunning){
                g.drawImage(cesto[0].getGameOver(), (getWidthGame()-cesto[0].getTamGameOverX())/2, 0, null);
            }


        }
    
    
      
        }
        
        
}
