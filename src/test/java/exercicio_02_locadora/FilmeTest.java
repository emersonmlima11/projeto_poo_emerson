package exercicio_02_locadora;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilmeTest {

    @Test
    public void testConstrutores(){
        Filme f1 = new Filme(1, "Jogos Vorazes", "Ação", 10, 125);
        assertEquals(1, f1.getCodigo());
        assertEquals("Jogos Vorazes", f1.getTitulo());
        assertEquals("Ação", f1.getGenero());
        assertEquals(10, f1.getQuantidadeEmEstoque());
        assertEquals(125,  f1.getDuracao());

        Filme f2 = new Filme(2, "Harry Potter", "Fantasia", 155);
        assertEquals(2, f2.getCodigo());
        assertEquals("Harry Potter", f2.getTitulo());
        assertEquals("Fantasia", f2.getGenero());
        assertEquals(1, f2.getQuantidadeEmEstoque());
        assertEquals(155,  f2.getDuracao());

        Filme f3 = new Filme("Pânico", "Terror", 2, 130);
        assertEquals("Pânico", f3.getTitulo());
        assertEquals("Terror", f3.getGenero());
        assertEquals(2, f3.getQuantidadeEmEstoque());
        assertEquals(130,  f3.getDuracao());

        Filme f4 = new Filme("Se beber não case", "Comédia", 100);
        assertEquals("Se beber não case", f4.getTitulo());
        assertEquals("Comédia", f4.getGenero());
        assertEquals(100,  f4.getDuracao());

    }

    @Test
    public void testEquals(){
        Filme f1 = new Filme(1, "Jogos Vorazes", "Ação", 10, 125);
        Filme f2 = new Filme(1, "Jogos Vorazes", "Ação", 10, 125);
        Filme f3 = new Filme(2,"Pânico", "Terror", 2, 130);
        assertTrue(f1.equals(f2));
        assertFalse(f1.equals(f3));
    }

    @Test
    public void testDisponivel(){
        Filme f1 = new Filme(1, "Jogos Vorazes", "Ação", 10, 125);
        assertTrue(f1.isDisponivel());
        f1.setDisponivel(false);
        assertFalse(f1.isDisponivel());
    }

    @Test
    public void testAlugarDevolver(){
        Filme f1 = new Filme(1, "Jogos Vorazes", "Ação", 10, 125);
        try{
        f1.alugar();
        assertEquals(9, f1.getQuantidadeEmEstoque());
        } catch (FilmeIndisponivelException e) {
            fail("Não deveria lançar exceção");
        }

        f1.devolver();
        assertEquals(10, f1.getQuantidadeEmEstoque());
    }

}
