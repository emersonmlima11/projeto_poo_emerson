package exercicio_02_locadora;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LocadoraTest {
    LocadoraMap loc = new LocadoraMap();

    @Test
    public void adicionarTest(){
        loc.adicionarFilme("Harry Potter", "Fantasia", 12, 123);
        loc.adicionarFilme("Gente Grande", "Comédia", 5, 123);
        assertEquals(2, loc.getFilmes().size());
    }

    @Test
    public void removerTest(){
        try {
            loc.removerFilme(2);
            assertEquals(1, loc.getFilmes().size());
        } catch (FilmeNaoEncontradoException e) {
            fail("Não deveria ter Exceção");
        }
    }

    @Test
    public void listarFilmesDisponiveisTest(){
        loc.adicionarFilme("Gente Grande", "Comédia", 5, 123);
        assertEquals(2, loc.listarFilmesDisponiveis().size());
    }
}
