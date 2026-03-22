# Checkpoint 1 - Programação em Java Advanced & JPA

## 📋 Descrição do Projeto
Este projeto consiste em um sistema de gerenciamento de funcionários utilizando **Java, JPA (Hibernate) e Annotations**. O objetivo é realizar o ciclo completo de um **CRUD** (Create, Read, Update, Delete) em um banco de dados **Oracle**, integrando lógica de herança para diferentes perfis de funcionários e o uso de **API Reflection** para leitura de metadados.

### Regras de Negócio
* **Funcionário (Base):** Contém nome, as horas trabalhadas e o valor pago por horas trabalhadas.
* **Sênior:** A diferença é que um(a) funcionário(a) sênior recebe um bônus a cada 15 horas trabalhadas.
* **Pleno:** Recebe um bônus a cada 30 horas trabalhadas (Perfil adicional customizado).
* **Junior:** Recebe um bônus a cada 60 horas trabalhadas (Perfil adicional customizado).

---

## 🛠️ Tecnologias Utilizadas
* **Java 21** (utilizando *String Templates* `STR`).
* **JPA / Hibernate** para a conexão e interação com o BD.
* **Oracle SQL Developer** como Banco de Dados.
* **API Reflection** para gerar automaticamente informações baseadas em anotações.

---

## 📂 Mapeamento Objeto-Relacional (Atributos vs. Colunas)
Para atender aos requisitos de customização, o banco de dados possui atributos com nomenclaturas diferentes das classes Java. Abaixo, detalhamos o mapeamento realizado:

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

> **Observação:** Algumas imagens foram cortadas para evitar redundância e focar nas informações pertinentes de cada etapa do processo.

### 1. Create (Cadastro)
O programa instancia os objetos e os persiste no banco de dados. O Hibernate gera automaticamente o script de criação da tabela e as instruções de inserção.

**Antes (Banco Vazio):**
<img src="../../screenshots/Screenshot%20from%202026-03-22%2015-09-06.png" width="600">

**Execução e Script SQL:**
<img src="../../screenshots/Screenshot%20from%202026-03-22%2015-19-24.png" width="600">
<img src="../../screenshots/Screenshot%20from%202026-03-22%2015-20-20.png" width="600">

**Depois (Banco Populado):**
<img src="../../screenshots/Screenshot%20from%202026-03-22%2015-21-23.png" width="600">

---

### 2. Read (Leitura e Reflection)
Busca de dados utilizando o `findById`. O sistema utiliza **API Reflection** para ler a anotação `@Description` e exibir a regra de negócio da categoria no console.

**Execução da Leitura:**
<img src="../../screenshots/Screenshot%20from%202026-03-22%2015-30-11.png" width="600">

---

### 3. Update (Atualização)
Modificação dos dados de um funcionário. O salário é recalculado automaticamente com base nas novas informações fornecidas e persistido no banco.

**Execução da Atualização:**
<img src="../../screenshots/Screenshot%20from%202026-03-22%2015-31-44.png" width="600">

**Banco de Dados Após o Update:**
<img src="../../screenshots/Screenshot%20from%202026-03-22%2015-32-50.png" width="600">

---

### 4. Delete (Remoção)
Exclusão dos registros para limpeza do ambiente de teste e conformidade com o ciclo de vida da aplicação.

**Execução da Remoção:**
<img src="../../screenshots/Screenshot%20from%202026-03-22%2015-34-47.png" width="600">

**Depois (Banco Limpo):**
<img src="../../screenshots/Screenshot%20from%202026-03-22%2015-35-08.png" width="600">

---

## 👥 Integrantes
* **Diego Andrade** - RM566385
* **Grazielle de Alencar** - RM561529
* **Julia Corrêa** - RM564870

---

### 📅 Prazo de Entrega
* **Data Final:** 22/03/2026 às 23:59.
