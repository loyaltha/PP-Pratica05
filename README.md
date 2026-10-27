# Sistema de Biblioteca - Prática 05 (SOLID - DIP)

Este repositório contém a evolução do sistema de gerenciamento de biblioteca em Java. 

**Objetivo desta prática:** 
Aplicar o **Princípio da Inversão da Dependência (DIP)** do SOLID. O código foi refatorado para que os módulos de alto nível (classes de negócio como Emprestimo e Usuario) não dependam de implementações concretas e de baixo nível (como o console para imprimir mensagens), mas sim de abstrações, utilizando a interface `ServicoNotificacao`.