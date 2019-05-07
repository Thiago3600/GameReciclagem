package model;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import view.Janela;


public class movimento extends JPanel implements Runnable, KeyListener, MouseListener{
    
    private Thread th, tm;
    public Janela j;
    
    
    public latas[] latas;
    public lixoTipo[] lixos;
    
    public int posIniX = 40;
    
    
    
    private int r = 5;
    private int level;
    private boolean fimDeJogo = true, pause, gameRunnig = false;
    private String[] select; 
    
    public movimento(int width, int height){
        
        addKeyListener(this);
        addMouseListener(this);
        j = new Janela(width, height);
        
        setLayout(new GridLayout());
        setFocusable(true);
        add(j);
        
        
        inicio();
        
            
        
        th = new Thread(this);
        tm = new Thread(this);
        
        th.start();
        tm.start();
    }
    
    public void inicio(){
        
        level = 4;
        
        
        latas = new latas[6];
        lixos = new lixoTipo[5];
        
        select = new String[2];
        select[0] = ">";
        select[1] = " ";
        
        
        
        latas[0] = new latas(j.getWidthGame(), j.getHeightGame());
        
        for(int i = 1; i<latas.length; i++){
            latas[i] = new latas(i);
        }
        for(int i = 0; i<lixos.length; i++){
            lixos[i] = new lixoTipo(r, j.getHeightGame());
        }
        
        
        
        
        
        
    }
    
    
    @Override
    public void run(){
        while(true){
            try {
                while(!isPause()){
                    tick();
                    repaint();
                }
                
                th.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(movimento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
       
    
    public void tick(){

    try {
        
        if(latas[0].getVidas()<0){
            setFimDeJogo(true);
            
        }
        
        setLevel(latas[0].level(getLevel()));
        for(int i = 0; i<lixos.length; i++){
            latas[0].pegarLixo(lixos[i]);
        }
        
        if(latas[0].isEnter() == true && isFimDeJogo() == true){
            
            
            for(int i = 0; i<lixos.length; i++){
                lixos[i].posInicial();
            }
            latas[0].setEnter(false);
            
        }
        
        th.sleep(100);
    } catch (InterruptedException ex) {
        Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
    }

}
   
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int dir = e.getKeyCode();
        
        if(dir == KeyEvent.VK_UP){
            select[0] = ">";
            select[1] = " ";
        }
        if(dir == KeyEvent.VK_DOWN){
            select[0] = " ";
            select[1] = ">";
        }
        if(dir == KeyEvent.VK_ENTER && select[0] == ">" && isFimDeJogo() && !isGameRunnig()){
            setGameRunnig(true);
            setFimDeJogo(false);
        }
        if(dir == KeyEvent.VK_ENTER && isFimDeJogo() && isGameRunnig()){
            setGameRunnig(false);
        }
        if(dir == KeyEvent.VK_ENTER && select[1] == ">" && isFimDeJogo() && !isGameRunnig()){
            System.exit(0);
        }
        
        
        
        if(isGameRunnig()&&!isFimDeJogo()){
            
            if(KeyEvent.VK_ESCAPE == dir){
                if(isPause()){
                    setPause(false);
                }else{
                    setPause(true);
                }
            }
            latas[0].escolhaLata(dir);
            latas[0].direcao(dir);
            latas[0].voltaJogo(dir);
            
        }
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        j.desenha(g, latas, lixos, getLevel(), isFimDeJogo(), isPause(), isGameRunnig(), select);
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int xCoor = e.getX();
        int yCoor = e.getY();
        latas[0].trocaLataMouse(xCoor, yCoor);
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isFimDeJogo() {
        return fimDeJogo;
    }

    public void setFimDeJogo(boolean fimDeJogo) {
        this.fimDeJogo = fimDeJogo;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public boolean isGameRunnig() {
        return gameRunnig;
    }

    public void setGameRunnig(boolean gameRunnig) {
        this.gameRunnig = gameRunnig;
    }

    
    
   
    
}
