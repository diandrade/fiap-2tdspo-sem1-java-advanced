# Checkpoint 1 - Programação em Java Advanced & JPA

## 📋 Descrição do Projeto

[cite_start]Este projeto consiste em um sistema de gerenciamento de funcionários utilizando **Java, JPA (Hibernate) e Annotations**[cite: 5, 6]. [cite_start]O objetivo é realizar o ciclo completo de um **CRUD** (Create, Read, Update, Delete) em um banco de dados **Oracle**, integrando lógica de herança para diferentes perfis de funcionários e o uso de **API Reflection** para leitura de metadados[cite: 30, 31, 32].

### Regras de Negócio

  * [cite_start]**Funcionário (Base):** Contém nome, horas trabalhadas e valor por hora[cite: 17, 18].
  * [cite_start]**Sênior:** Possui bônus a cada 15 horas trabalhadas[cite: 20, 25].
  * **Pleno:** Possui bônus a cada 30 horas trabalhadas (Perfil adicional).
  * **Junior:** Possui bônus a cada 60 horas trabalhadas (Perfil adicional).

-----

## 🛠️ Tecnologias Utilizadas

  * **Java 21** (utilizando *String Templates* `STR`).
  * [cite_start]**JPA / Hibernate** para persistência[cite: 31].
  * [cite_start]**Oracle SQL Developer** como Banco de Dados[cite: 31].
  * [cite_start]**API Reflection** para geração dinâmica de informações baseadas em anotações[cite: 30].

-----

## 🔍 Evidências das Etapas (CRUD)

> **Observação:** Algumas imagens foram cortadas para evitar redundância e focar nas informações pertinentes de cada etapa do processo.

### 1\. Create (Cadastro)

O programa instancia os objetos e os persiste no banco de dados. [cite_start]O Hibernate gera automaticamente o script de criação da tabela e as instruções de inserção[cite: 32].

**Antes (Banco Vazio):**

**Execução e Script SQL:**

**Depois (Banco Populado):**

-----

### 2\. Read (Leitura e Reflection)

Busca de dados utilizando o `findById`. [cite_start]O sistema utiliza **API Reflection** para ler a anotação `@Description` e exibir a regra de negócio da categoria no console[cite: 30, 32].

**Execução da Leitura:**

-----

### 3\. Update (Atualização)

Modificação dos dados de um funcionário. [cite_start]O salário é recalculado automaticamente com base nas novas informações fornecidas[cite: 32].

**Execução da Atualização:**

**Banco de Dados Após o Update:**

-----

### 4\. Delete (Remoção)

[cite_start]Exclusão dos registros para limpeza do ambiente de teste[cite: 32].

**Execução da Remoção:**

**Depois (Banco Limpo):**

-----

## 👥 Integrantes

  * [cite_start]**Diego Andrade** - RM566385 [cite: 15]
  * [cite_start]**Grazielle de Alencar** - RM561529 [cite: 15]
  * [cite_start]**Julia Corrêa** - RM564870 [cite: 15]

-----

### 📅 Prazo de Entrega

  * [cite_start]**Data Final:** 22/03/2026 às 23:59[cite: 46].

-----
