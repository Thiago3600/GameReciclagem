package model;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class latas {

    private int tamX, tamY, eixoX, width, height, tamCoraX, tamCoraY, tamGameOverX, tamGameOverY, pauseTamX, pauseTamY;
    private ImageIcon tipo, lata, coracao, gameOver, azul, verde, vermelho, amarelo, marrom, pause;
    private int taxaAt = 30, ponto = 0, vidas = 4, sec = 0, dSec = 0, dMin = 0, min = 0, cod = 1, hiScore;
    private int posAzX, posVerdX, posVermX, posAmX, posMaX;
    private long totalMillisegundos, totalSegundos;
    private short segundoatual, segundoAnterior = 0;
    private boolean enter = false;

    public latas(int width, int height) {

        setWidth(width);
        setHeight(height);
        setEixoX(getWidth() / 2);

        azul = new ImageIcon(getClass().getResource("/image/lataAzul.png"));
        verde = new ImageIcon(getClass().getResource("/image/lataVerde.png"));
        vermelho = new ImageIcon(getClass().getResource("/image/lataVermelha.png"));
        amarelo = new ImageIcon(getClass().getResource("/image/lataAmarela.png"));
        marrom = new ImageIcon(getClass().getResource("/image/lataMarrom.png"));

        setCoracao(new ImageIcon(getClass().getResource("/image/red-heart-70x70-png.png")));
        setTamCoraX(coracao.getIconWidth());
        setTamCoraY(coracao.getIconHeight());

        setGameOver(new ImageIcon(getClass().getResource("/image/gameOver.png")));
        setTamGameOverX(gameOver.getIconWidth());
        setTamGameOverY(gameOver.getIconHeight());

        setPause(new ImageIcon(getClass().getResource("/image/pause.png")));
        setPauseTamX(pause.getIconWidth());
        setPauseTamY(pause.getIconHeight());

        setTipo(azul);
        setPonto(ponto);
        lata = getTipo();
        setLata(lata);
        setTamX(lata.getIconWidth());
        setTamY(lata.getIconHeight());

        setPosAzX(175);
        setPosVerdX(255);
        setPosVermX(335);
        setPosAmX(415);
        setPosMaX(495);

    }

    public latas(int i) {

        azul = new ImageIcon(getClass().getResource("/image/lataAzul.png"));
        verde = new ImageIcon(getClass().getResource("/image/lataVerde.png"));
        vermelho = new ImageIcon(getClass().getResource("/image/lataVermelha.png"));
        amarelo = new ImageIcon(getClass().getResource("/image/lataAmarela.png"));
        marrom = new ImageIcon(getClass().getResource("/image/lataMarrom.png"));

        setCoracao(new ImageIcon(getClass().getResource("/image/red-heart-70x70-png.png")));
        setTamCoraX(coracao.getIconWidth());
        setTamCoraY(coracao.getIconHeight());

        setGameOver(new ImageIcon(getClass().getResource("/image/gameOver.png")));
        setTamGameOverX(gameOver.getIconWidth());
        setTamGameOverY(gameOver.getIconHeight());

        setPause(new ImageIcon(getClass().getResource("/image/pause.png")));
        setPauseTamX(pause.getIconWidth());
        setPauseTamY(pause.getIconHeight());

        setCor(i);

        setPosAzX(175);
        setPosVerdX(255);
        setPosVermX(335);
        setPosAmX(415);
        setPosMaX(495);
    }

    public int level(int level) {
        int a = level;
        if (getPonto() >= 0) {
            a = 4;
            if (getPonto() >= 20) {
                a = 3;
                if (getPonto() >= 100) {
                    a = 2;
                    if (getPonto() >= 500) {
                        a = 1;
                        if (getPonto() >= 1000) {
                            a = 0;
                        }
                    }
                }
            }
        }
        return a;
    }

    public void voltaJogo(int enter) {

        if (enter == KeyEvent.VK_ENTER) {
            setVidas(4);
            setSec(0);
            setdSec(0);
            setMin(0);
            setdMin(0);
            setPonto(0);
            setEnter(true);

        }
    }

    public String tempo() {

        String tempo;

        totalMillisegundos = System.currentTimeMillis();

        totalSegundos = totalMillisegundos / 1000;

        segundoatual = (short) (totalSegundos % 60);

        if (segundoAnterior != segundoatual) {
            setSec(getSec() + 1);
            if (getSec() > 9) {
                setSec(0);
                setdSec(getdSec() + 1);
                if (getdSec() > 5) {
                    setdSec(0);
                    setMin(getMin() + 1);
                    if (getMin() > 9) {
                        setMin(0);
                        setdMin(getdMin() + 1);
                    }
                }
            }
            segundoAnterior = segundoatual;
        }

        tempo = getdMin() + getMin() + ":" + getdSec() + getSec();

        return tempo;
    }

    public int getCor(int c) {
        switch (c) {
            case 1:
                return getPosAzX();
            case 2:
                return getPosVerdX();
            case 3:
                return getPosVermX();
            case 4:
                return getPosAmX();
            case 5:
                return getPosMaX();
            default:
                return 0;
        }
    }

    private Image setCor(int i) {

        switch (i) {
            case 1:
                setTipo(azul);
                break;
            case 2:
                setTipo(verde);
                break;
            case 3:
                setTipo(vermelho);
                break;
            case 4:
                setTipo(amarelo);
                break;
            case 5:
                setTipo(marrom);
                break;

        }

        setCod(i);

        lata = getTipo();
        setLata(lata);

        setTamX(lata.getIconWidth());
        setTamY(lata.getIconHeight());

        return getLata();

    }

    public Image escolhaLata(int i) {

        switch (i) {
            case KeyEvent.VK_1:
                setTipo(azul);
                setCod(1);
                break;
            case KeyEvent.VK_2:
                setTipo(verde);
                setCod(2);
                break;
            case KeyEvent.VK_3:
                setTipo(vermelho);
                setCod(3);
                break;
            case KeyEvent.VK_4:
                setTipo(amarelo);
                setCod(4);
                break;
            case KeyEvent.VK_5:
                setTipo(marrom);
                setCod(5);

        }

        lata = getTipo();
        setLata(lata);

        setTamX(lata.getIconWidth());
        setTamY(lata.getIconHeight());

        return getLata();

    }

    public void pegarLixo(lixoTipo lixo) {

        if (lixo.getPos() >= getEixoX() - (getTamX() * 0.3) && lixo.getPos() + lixo.getScaleX() <= getEixoX() + getTamX() + (getTamX() * 0.3)) {
            if (lixo.getY() >= getHeight() - getTamY()) {
                if (lixo.getCod() == getCod()) {
                    setPonto(getPonto() + 10);
                    setHiScore(getPonto());
                    lixo.posInicial();
                } else {
                    setVidas(getVidas() - 1);
                    setPonto(getPonto() - 10);
                    lixo.posInicial();
                }
            }
        }
        if (lixo.isChao()) {
            setVidas(getVidas() - 1);
            if (getPonto() > 0) {
                setPonto(getPonto() - 10);
            }

        }

    }

    public void direcao(int dir) {
        if ((dir == KeyEvent.VK_RIGHT || dir == KeyEvent.VK_D) && (getEixoX() + getTaxaAt() < getWidth() - 80)) {
            setEixoX(getEixoX() + getTaxaAt());
        }
        if ((dir == KeyEvent.VK_LEFT || dir == KeyEvent.VK_A) && (getEixoX() - getTaxaAt() > 0)) {
            setEixoX(getEixoX() - getTaxaAt());
        }
    }

    public void trocaLataMouse(int x, int y) {

        if (getPosAzX() <= x && x <= getPosAzX() + getTamX()) {
            if (y > getHeight() + getTamY()) {
                setCor(1);
            }
        }
        if (getPosVerdX() <= x && x <= getPosVerdX() + getTamX()) {
            if (y > getHeight() + getTamY()) {
                setCor(2);
            }
        }
        if (getPosVermX() <= x && x <= getPosVermX() + getTamX()) {
            if (y > getHeight() + getTamY()) {
                setCor(3);
            }
        }
        if (getPosAmX() <= x && x <= getPosAmX() + getTamX()) {
            if (y > getHeight() + getTamY()) {
                setCor(4);
            }
        }
        if (getPosMaX() <= x && x <= getPosMaX() + getTamX()) {
            if (y > getHeight() + getTamY()) {
                setCor(5);
            }
        }

    }

    public int getdSec() {
        return dSec;
    }

    public void setdSec(int dSec) {
        this.dSec = dSec;
    }

    public int getdMin() {
        return dMin;
    }

    public void setdMin(int dMin) {
        this.dMin = dMin;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getTamCoraX() {
        return tamCoraX;
    }

    public void setTamCoraX(int tamCoraX) {
        this.tamCoraX = tamCoraX;
    }

    public int getTamCoraY() {
        return tamCoraY;
    }

    public void setTamCoraY(int tamCoraY) {
        this.tamCoraY = tamCoraY;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public Image getCoracao() {
        return coracao.getImage();
    }

    public void setCoracao(ImageIcon coracao) {
        this.coracao = coracao;
    }

    public void setPosAzX(int posAzX) {
        this.posAzX = posAzX;
    }

    public void setPosVerdX(int posVerdX) {
        this.posVerdX = posVerdX;
    }

    public void setPosVermX(int posVermX) {
        this.posVermX = posVermX;
    }

    public void setPosAmX(int posAmX) {
        this.posAmX = posAmX;
    }

    public void setPosMaX(int posMaX) {
        this.posMaX = posMaX;
    }

    public int getPosAzX() {
        return posAzX;
    }

    public int getPosVerdX() {
        return posVerdX;
    }

    public int getPosVermX() {
        return posVermX;
    }

    public int getPosAmX() {
        return posAmX;
    }

    public int getPosMaX() {
        return posMaX;
    }

    public Image getLata() {
        return lata.getImage();
    }

    public void setLata(ImageIcon lata) {
        this.lata = lata;
    }

    public int getPonto() {
        return ponto;
    }

    public void setPonto(int ponto) {
        if (ponto>0) {
            this.ponto = ponto;
        }
    }

    public int getTamX() {
        return tamX;
    }

    public void setTamX(int tamX) {
        this.tamX = tamX;
    }

    public int getTamY() {
        return tamY;
    }

    public void setTamY(int tamY) {
        this.tamY = tamY;
    }

    public ImageIcon getTipo() {
        return tipo;
    }

    private void setTipo(ImageIcon tipo) {
        this.tipo = tipo;
    }

    public int getEixoX() {
        return eixoX;
    }

    public void setEixoX(int dir) {
        this.eixoX = dir;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getTaxaAt() {
        return taxaAt;
    }

    public void setTaxaAt(int taxaAt) {
        this.taxaAt = taxaAt;
    }

    public Image getGameOver() {
        return gameOver.getImage();
    }

    public void setGameOver(ImageIcon gameOver) {
        this.gameOver = gameOver;
    }

    public int getTamGameOverX() {
        return tamGameOverX;
    }

    public void setTamGameOverX(int tamGameOverX) {
        this.tamGameOverX = tamGameOverX;
    }

    public int getTamGameOverY() {
        return tamGameOverY;
    }

    public void setTamGameOverY(int tamGameOverY) {
        this.tamGameOverY = tamGameOverY;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getHiScore() {

        String score = "High-score: " + hiScore;

        return score;
    }

    public void setHiScore(int hiScore) {

        if (hiScore > this.hiScore) {
            this.hiScore = hiScore;
        }

    }

    public boolean isEnter() {
        return enter;
    }

    public void setEnter(boolean enter) {
        this.enter = enter;
    }

    public int getPauseTamX() {
        return pauseTamX;
    }

    public void setPauseTamX(int pauseTamX) {
        this.pauseTamX = pauseTamX;
    }

    public int getPauseTamY() {
        return pauseTamY;
    }

    public void setPauseTamY(int pauseTamY) {
        this.pauseTamY = pauseTamY;
    }

    public Image getPause() {
        return pause.getImage();
    }

    public void setPause(ImageIcon pause) {
        this.pause = pause;
    }

}
