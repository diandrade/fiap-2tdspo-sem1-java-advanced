# Checkpoint 1 - Programação em Java Advanced & JPA

## 📋 Descrição do Projeto
[cite_start]Este projeto consiste em um sistema de gerenciamento de funcionários utilizando **Java, JPA (Hibernate) e Annotations**[cite: 5, 6]. [cite_start]O objetivo é realizar o ciclo completo de um **CRUD** (Create, Read, Update, Delete) em um banco de dados **Oracle**, integrando lógica de herança para diferentes perfis de funcionários e o uso de **API Reflection** para leitura de metadados[cite: 30, 31, 32].

### Regras de Negócio
* [cite_start]**Funcionário (Base):** Contém nome, horas trabalhadas e valor pago por hora[cite: 17, 18].
* [cite_start]**Sênior:** Recebe um bônus a cada 15 horas trabalhadas[cite: 20, 25].
* **Pleno:** Recebe um bônus a cada 30 horas trabalhadas (Perfil adicional customizado).
* **Junior:** Recebe um bônus a cada 60 horas trabalhadas (Perfil adicional customizado).

---

## 🛠️ Tecnologias Utilizadas
* **Java 21** (utilizando *String Templates* `STR`).
* [cite_start]**JPA / Hibernate** para persistência e interação com o banco[cite: 31].
* [cite_start]**Oracle SQL Developer** como Banco de Dados[cite: 31].
* [cite_start]**API Reflection** para geração dinâmica de informações e leitura de anotações[cite: 30].

---

## 📂 Mapeamento Objeto-Relacional (Atributos vs. Colunas)
[cite_start]Para atender aos requisitos de customização, o banco de dados possui atributos com nomenclaturas diferentes das classes Java[cite: 29]. Abaixo, detalhamos o mapeamento realizado:

| Atributo na Classe Java | Coluna no Banco (Oracle) | Descrição do Campo |
| :--- | :--- | :--- |
| `id` | `id_funcionario` | Identificador único (Identity) |
| `nome` | `nm_func` | Nome do funcionário (Varchar2) |
| `horasTrabalhadas` | `nr_horas_trabalhadas` | Total de horas (Number) |
| `salarioCalculado` | `vl_sal_func` | Salário final persistido (Decimal) |
| `valorHora` | *(Não persistido)* | Atributo `@Transient` |
| `valorBonus` | *(Não persistido)* | Atributo `@Transient` |

---

## 🔍 Evidências das Etapas (CRUD)

> [cite_start]**Observação:** Algumas imagens foram cortadas para evitar redundância e focar nas informações pertinentes de cada etapa do processo[cite: 39].

### 1. Create (Cadastro)
O programa instancia os objetos e os persiste no banco de dados. [cite_start]O Hibernate gera automaticamente o script de criação da tabela e as instruções de inserção[cite: 32].

**Antes (Banco Vazio):**
![Banco de Dados Antes do Create](image_f57ba5.png)

**Execução e Script SQL:**
![Script SQL Cadastro](image_f5e13f.png)
![Console Informações Detalhadas](image_f5e46b.png)

**Depois (Banco Populado):**
![Tabela Após o Create](image_f5e541.png)

---

### 2. Read (Leitura e Reflection)
Busca de dados utilizando o `findById`. [cite_start]O sistema utiliza **API Reflection** para ler a anotação `@Description` e exibir a regra de negócio da categoria no console[cite: 30, 32].

**Execução da Leitura:**
![Console Read e SQL](image_f649be.png)

---

### 3. Update (Atualização)
Modificação dos dados de um funcionário. [cite_start]O salário é recalculado automaticamente com base nas novas informações fornecidas e persistido no banco[cite: 32].

**Execução da Atualização:**
![Script SQL Update](image_f64d82.png)

**Banco de Dados Após o Update:**
![Tabela Após o Update](image_f64e21.png)

---

### 4. Delete (Remoção)
[cite_start]Exclusão dos registros para limpeza do ambiente de teste e conformidade com o ciclo de vida da aplicação[cite: 32].

**Execução da Remoção:**
![Script SQL Delete](image_f65218.png)

**Depois (Banco Limpo):**
![Tabela Após o Delete](image_f654e4.png)

---

## 👥 Integrantes
* [cite_start]**Diego Andrade** - RM566385 [cite: 15]
* [cite_start]**Grazielle de Alencar** - RM561529 [cite: 15]
* [cite_start]**Julia Corrêa** - RM564870 [cite: 15]

---

### 📅 Prazo de Entrega
* [cite_start]**Data Final:** 22/03/2026 às 23:59[cite: 46].
