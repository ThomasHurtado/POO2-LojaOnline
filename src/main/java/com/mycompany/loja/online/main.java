/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loja.online;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.Aluno;
import org.bson.Document;

/**
 *
 * @author thoma
 */
public class main {
    
    public static void main(String[] args) {
        // URI de conexão com o MongoDB Atlas
        String connectionString = "mongodb+srv://poo2:1234@cluster0.arlotsu.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

        // Criando uma instância do MongoClient
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            // Acessando o banco de dados
            MongoDatabase database = mongoClient.getDatabase("<database>");

            // Obtendo a coleção de alunos (ou criando-a, se não existir)
            MongoCollection<Document> collection = database.getCollection("alunos");

            // Criando um novo aluno
            Aluno aluno = new Aluno("João da Silva", "123");

            // Convertendo o objeto Aluno para um documento BSON
            Document alunoDoc = new Document("nome", aluno.getNome())
                                    .append("cpf", aluno.getCpf());

            // Inserindo o documento na coleção de alunos
            collection.insertOne(alunoDoc);

            System.out.println("Aluno inserido com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao inserir aluno: " + e);
        }
    }
}
