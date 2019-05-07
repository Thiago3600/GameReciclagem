package model;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;



public class lixoTipo{
    
    private String nome;
    private ImageIcon lixo, tipo, papel, lataRefrigerante, vidro, plastico, banana;
    private Random r;
    private int i, y = 100, taxa = 0, k = 5, a, limiteQueda, pos, cod;
    private int scaleX, scaleY;
    private boolean chao, gameOver;
    
    public int posIniX = 40;
    private int[] vetorPos = new int[5];

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    
    

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public boolean isChao() {
        return chao;
    }

    public void setChao(boolean chao) {
        this.chao = chao;
    }
    
    
    

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        int x;
        x = 1+r.nextInt(pos);
        for(int i = 0;i<vetorPos.length; i++){
            if(x == i+1){
               this.pos = vetorPos[i];
            }
            
        }
        
    }

    public int getY() {
        return y;
    }

    public int getScaleX() {
        return scaleX;
    }

    public void setScaleX(int scaleX) {
        this.scaleX = scaleX;
    }

    public int getScaleY() {
        return scaleY;
    }

    private void setScaleY(int scaleY) {
        this.scaleY = scaleY;
    }
  
    
    
    
    public ImageIcon getTipo() {        
        return tipo;
    }

    public void setTipo(ImageIcon tipo) {
        this.tipo = tipo;
    }
    public ImageIcon getLixo() {
        return lixo;
    }

    public void setLixo(ImageIcon lixo) {
        this.lixo = lixo;
    }

    public int getLimiteQueda() {
        return limiteQueda;
    }

    public void setLimiteQueda(int limiteQueda) {
        this.limiteQueda = limiteQueda;
    }
    
    
    
    public lixoTipo(int a, int height){
        
        this.i = a;
        setLimiteQueda(height);
        
        papel = new ImageIcon(getClass().getResource("/image/crumpledPaper.png"));
        lataRefrigerante = new ImageIcon(getClass().getResource("/image/Latinha-de-Refrigerante.png"));
        vidro = new ImageIcon(getClass().getResource("/image/garrafa-vidro.png"));
        plastico = new ImageIcon(getClass().getResource("/image/Garrafa-pet.png"));
        banana = new ImageIcon(getClass().getResource("/image/casca-de-banana.png"));
        posInicial();
        
        
        
    
    }
    
    public void posInicial(){
        
        vetorPos[0] = posIniX*1;
        vetorPos[1] = posIniX*4;
        vetorPos[2] = posIniX*8;
        vetorPos[3] = posIniX*12;
        vetorPos[4] = posIniX*16;
        
        
               
        
        r = new Random();
        a = 1+r.nextInt(i);
        y = 100;
        this.taxa = 2+r.nextInt(6);
        setPos(getK());
        
    }
    
    public int queda(){
        y+=taxa;
        if(chao(getLimiteQueda())){
            posInicial();
            setChao(true);
            
        }else{
            setChao(false);
        }
        return y;
    }
    
    public Image helpCores(int i){
        switch(i){
            case 1:
                setTipo(papel);
                setCod(1);
                setNome(" = Azul");
                break;
                
            case 2:
                setTipo(vidro);
                setCod(2);
                setNome(" = Verde");
                break;
            case 3:
                setTipo(plastico);
                setCod(3);
                setNome(" = Vermelho");
                break;
            case 4:
                setTipo(lataRefrigerante);
                setCod(4);
                setNome("   = Amarelo");
                break;               
            case 5:
                setTipo(banana);
                setCod(5);
                setNome(" = Marrom");
                break; 
        }
        
        lixo = getTipo();
        
        setScaleX(lixo.getIconWidth());
        setScaleY(lixo.getIconHeight());
        
        return lixo.getImage();
    
    }
    
    public Image randomLixo(){
        
        switch(a){
            case 1:
                setTipo(papel);
                setCod(1);
                break;
                
            case 2:
                setTipo(vidro);
                setCod(2);
                break;
            case 3:
                setTipo(plastico);
                setCod(3);
                break;
            case 4:
                setTipo(lataRefrigerante);
                setCod(4);
                break;               
            case 5:
                setTipo(banana);
                setCod(5);
                break; 
        }
        
        lixo = getTipo();
        
        setScaleX(lixo.getIconWidth());
        setScaleY(lixo.getIconHeight());
        
        return lixo.getImage();
    }
    public boolean chao(int height){
        return height<=y;
    }
    
   
    public void getObjetoPos(lixoTipo lixo[], int x){
      
        for(int i = 0; i<lixo.length; i++){
            
            if(i != x && getPos() == lixo[i].getPos() && lixo[i].getY()>110){
                posInicial();
                i = 0;
            }
        }
        
    }
    
    
}
