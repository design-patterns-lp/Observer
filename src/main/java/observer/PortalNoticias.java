package observer;

import java.util.Observable;

public class PortalNoticias extends Observable {

    private String nomePortal;
    private String urlPortal;

    public PortalNoticias(String nomePortal, String urlPortal) {
        this.nomePortal = nomePortal;
        this.urlPortal = urlPortal;
    }

    public void publicarNoticias() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return " Portal de Notícias{" +
                " Portal='" + nomePortal + '\'' +
                ", url='" + urlPortal + '\'' +
                '}';
    }
}
