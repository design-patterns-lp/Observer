package observer;

import java.util.Observable;
import java.util.Observer;

public class Leitor implements Observer {

    private String nome;
    private String ultimaNoticia;

    public Leitor(String nome) {
        this.nome = nome;
    }

    public String getultimaNoticia() {
        return this.ultimaNoticia;
    }

    public void assinar(PortalNoticias portalNoticias) {
        portalNoticias.addObserver(this);
    }

    public void update(Observable portalNoticias, Object arg1) {
        this.ultimaNoticia = this.nome + ", notícia lançada em" + portalNoticias.toString();
    }
}
