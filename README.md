# Sistema de Registro: Monólito vs. Modularização

Este projeto foi desenvolvido como atividade prática para a disciplina de **Engenharia de Software II** no **IFPA - Campus Tucuruí**. O objetivo central é demonstrar a evolução de um sistema de software partindo de uma abordagem monolítica para uma arquitetura modularizada.

## 🚀 Objetivo do Projeto

Demonstrar as deficiências de um código altamente acoplado (monolítico) e como a aplicação de princípios de design de software (como **SOLID** e **SoC**) pode transformar um sistema em uma estrutura escalável e de fácil manutenção.

---

## 🏗️ Construção e Conceitos Aplicados

O sistema simula um fluxo de registro de usuários, incluindo validação, persistência e notificação.

### 1. O Problema: Arquitetura Monolítica
Na versão inicial, toda a lógica foi concentrada em uma única classe (`SistemaRegistroMonolitico.java`).
* **Alto Acoplamento:** Dependências de e-mail e banco de dados misturadas com regras de negócio.
* **Baixa Coesão:** Uma única unidade de código com múltiplas responsabilidades.

### 2. A Solução: Modularização
O código foi refatorado aplicando o princípio de **Separação de Preocupações (SoC)**, dividindo o sistema em:

* **Camada de Domínio (`Usuario`):** Representação do dado e regras básicas.
* **Camada de Persistência (`UsuarioRepository`):** Isolamento da lógica de acesso a dados.
* **Camada de Serviço Externo (`EmailService`):** Integrações externas (notificações).
* **Camada de Orquestração (`RegistroUsuarioService`):** Coordena o fluxo através de Injeção de Dependência.

---

## 🧩 Elementos Reutilizáveis

Identificamos componentes que podem ser reaproveitados em outros projetos:

1.  **`EmailService`:** Módulo genérico para qualquer sistema que exija notificações via e-mail.
2.  **`UsuarioRepository`:** Estrutura base para persistência de perfis.
3.  **Entidade `Usuario`:** Modelo de dados padrão para gestão de usuários.

---

## 📈 Síntese Técnica

| Conceito | Aplicação Prática |
| :--- | :--- |
| **SRP** | Cada classe possui uma responsabilidade única. |
| **Encapsulamento** | Detalhes de implementação protegidos dentro dos módulos. |
| **Manutenibilidade** | Facilidade em alterar partes do sistema sem impacto global. |

---
**Desenvolvido por:** Artur Sousa 
**Disciplina:** Engenharia de Software II - IFPA
