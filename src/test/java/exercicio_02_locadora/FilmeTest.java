package exercicio_02_locadora;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilmeTest {

    @Test
    public void testConstrutores(){
        Filme f1 = new Filme(1, "Jogos Vorazes", "Ação", 10, 125);
        assertEquals(1, f1.getCodigo());
        assertEquals("Jogos Vorazes", f1.getTitulo());
        assertEquals("Ação", f1.getGenero());
        assertEquals(10, f1.getQuantidadeEmEstoque());
        assertEquals();
    }

}
