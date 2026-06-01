package exercicio_02_locadora;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Persistencia {
    private static final String CAMINHO_TAREFA = "locadora.txt";

    public static void gravar(Map<Integer, Filme> filmes){
        File arq = new File(CAMINHO_TAREFA);

        try{
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(arq));
            output.writeObject(filmes);
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<Integer, Filme> ler(){
        Map<Integer, Filme> mapa = new HashMap<>();
        try{
            File arq = new File(CAMINHO_TAREFA);
            if(arq.exists()){
                ObjectInputStream input = new ObjectInputStream(new FileInputStream(arq));
                mapa = (Map<Integer, Filme>) input.readObject();
                input.close();
            }
        }catch (IOException | ClassNotFoundException e){
                throw new RuntimeException(e);
        }
        return mapa;
    }
}
