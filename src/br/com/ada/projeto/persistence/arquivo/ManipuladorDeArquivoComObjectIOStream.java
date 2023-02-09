package br.com.ada.projeto.persistence.arquivo;

import java.io.*;
import java.util.ArrayList;

public class ManipuladorDeArquivoComObjectIOStream implements ManipuladorDeArquivo {

    private final String arquivo;

    public ManipuladorDeArquivoComObjectIOStream(String arquivo) {
        this.arquivo = arquivo;
    }

    public void escreverNoArquivo(Object dados) {
        try(OutputStream fileOutputStream = new FileOutputStream(arquivo);
            ObjectOutputStream escritor = new ObjectOutputStream(fileOutputStream)){
            escritor.writeObject(dados);
            escritor.flush();
        } catch (IOException e) {
            System.out.println("Erro na hora de escrever no arquivo");
            e.printStackTrace();
        }

    }

    public Object lerDoArquivo() {

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
