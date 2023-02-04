package br.com.ada.repository;

import br.com.ada.ordenacao.Pessoa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManipuladorDeArquivo {

    public static void escreverEmArquivo(List<Pessoa> dados) {
        try(OutputStream fileOutputStream = new FileOutputStream("dados_pessoa.txt");
            ObjectOutputStream escritor = new ObjectOutputStream(fileOutputStream)){
            escritor.writeObject(dados);
            escritor.flush();
        } catch (IOException e) {
            System.out.println("Erro na hora de escrever no arquivo");
            e.printStackTrace();
        }

    }

    public static List<Pessoa> lerDoArquivo() {
        try (InputStream fileInputStream = new FileInputStream("dados_pessoa.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            Object objectLido = objectInputStream.readObject();
            return (List<Pessoa>) objectLido;
        } catch (IOException e) {
            System.out.println("Erro no momento de ler o arquivo");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Erro no momento de converter o arquivo para o tipo Java");
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
