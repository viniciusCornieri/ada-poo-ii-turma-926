package br.com.ada.repository;

import br.com.ada.ordenacao.Pessoa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManipuladorDeArquivo {

    public static void escreverEmArquivo(List<Pessoa> dados) {
        ObjectOutputStream escritor = criarFileOutputStream();
        try {
            escritor.writeObject(dados);
        } catch (IOException e) {
            System.out.println("Erro na hora de escrever no arquivo");
            e.printStackTrace();
        } finally {
            try {
                escritor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private static ObjectOutputStream criarFileOutputStream() {
        try {
            OutputStream fileOutputStream = new FileOutputStream("dados_pessoa.txt");
            return new ObjectOutputStream(fileOutputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Pessoa> lerDoArquivo() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = criarObjectInputStream();
        } catch (IOException e) {
            return new ArrayList<>();
        }

        try {
            Object objectLido = objectInputStream.readObject();
            return (List<Pessoa>) objectLido;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static ObjectInputStream criarObjectInputStream() throws IOException {
        InputStream fileInputStream = new FileInputStream("dados_pessoa.txt");
        return new ObjectInputStream(fileInputStream);
    }
}
