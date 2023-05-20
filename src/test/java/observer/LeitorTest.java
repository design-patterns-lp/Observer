package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeitorTest {

    @Test
    void deveNotificarUmLeitor(){
        PortalNoticias portalNoticias = new PortalNoticias("Globe", "www.globe.com");
        Leitor leitor = new Leitor("Fulano");
        leitor.assinar(portalNoticias);
        portalNoticias.publicarNoticias();
        assertEquals("Fulano, notícia lançada em Portal de Notícias{ Portal='Globe', url='www.globe.com'}", leitor.getultimaNoticia());
    }

    @Test
    void deveNotificarLeitores(){
        PortalNoticias portalNoticias = new PortalNoticias("Globe", "www.globe.com");
        Leitor leitor1 = new Leitor("Fulano1");
        Leitor leitor2 = new Leitor("Fulano2");
        leitor1.assinar(portalNoticias);
        leitor2.assinar(portalNoticias);
        portalNoticias.publicarNoticias();
        assertEquals("Fulano1, notícia lançada em Portal de Notícias{ Portal='Globe', url='www.globe.com'}", leitor1.getultimaNoticia());
        assertEquals("Fulano2, notícia lançada em Portal de Notícias{ Portal='Globe', url='www.globe.com'}", leitor2.getultimaNoticia());
    }

    @Test
    void naoDeveNotificarLeitor() {
        PortalNoticias portalNoticias = new PortalNoticias("Globe", "www.globe.com");
        Leitor leitor = new Leitor("Fulano");
        portalNoticias.publicarNoticias();
        assertEquals(null, leitor.getultimaNoticia());
    }

    @Test
    void deveNotificarLeitorPortalNoticiasA(){
        PortalNoticias portalNoticiasA = new PortalNoticias("Globe", "www.globe.com");
        PortalNoticias portalNoticiasB = new PortalNoticias("ÉssiBêTê", "www.essibete.com");
        Leitor leitor1 = new Leitor("Fulano1");
        Leitor leitor2 = new Leitor("Fulano2");
        leitor1.assinar(portalNoticiasA);
        leitor2.assinar(portalNoticiasB);
        portalNoticiasA.publicarNoticias();
        assertEquals("Fulano1, notícia lançada em Portal de Notícias{ Portal='Globe', url='www.globe.com'}", leitor1.getultimaNoticia());
        assertEquals(null, leitor2.getultimaNoticia());
    }

}