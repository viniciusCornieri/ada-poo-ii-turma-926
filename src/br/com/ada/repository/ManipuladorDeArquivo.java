package br.com.ada.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManipuladorDeArquivo {

    public static <T> void escreverEmArquivo(List<T> dados, String arquivo) {
        try(OutputStream fileOutputStream = new FileOutputStream(arquivo);
            ObjectOutputStream escritor = new ObjectOutputStream(fileOutputStream)){
            escritor.writeObject(dados);
            escritor.flush();
        } catch (IOException e) {
            System.out.println("Erro na hora de escrever no arquivo");
            e.printStackTrace();
        }

    }

    public static Object lerDoArquivo(String arquivo) {

        try (InputStream fileInputStream = new FileInputStream(arquivo);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            return objectInputStream.readObject();
        } catch (IOException e) {
            System.out.println("Erro no momento de ler o arquivo, continuando o processamento");
//            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Erro no momento de converter o arquivo para o tipo Java, continuando o processamento");
//            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
