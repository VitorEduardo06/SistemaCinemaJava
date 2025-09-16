import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Metodos {
    public Scanner sc;
    public ArrayList<Cliente> clientes;
    public ArrayList<Ator> atores;
    public ArrayList<Elenco> elencos;
    public ArrayList<Filme> filmes;
    public ArrayList<Genero> generos;
    public ArrayList<Sessao> sessoes;
    public ArrayList<Ingresso> ingressos;
    
    public Metodos() {
        sc = new Scanner(System.in);
        clientes = new ArrayList<>();
        atores = new ArrayList<>(); 
        elencos = new ArrayList<>(); 
        filmes = new ArrayList<>();
        generos = new ArrayList<>();
        sessoes = new ArrayList<>();
        ingressos = new ArrayList<>();
    }

    public void inserirCliente() {
        try {
            System.out.print("Digite o nome do cliente: ");
            String nome = sc.nextLine();
            
            System.out.print("Digite o cpf do cliente: ");
            String cpf = sc.nextLine();

            System.out.print("Digite a idade do cliente: ");
            int idade = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Digite o rg do cliente: ");
            String rg = sc.nextLine();

            System.out.print("O cliente é estudante?  ");
            String ehEstudante = sc.nextLine();

            boolean estudante;
            if (ehEstudante.equalsIgnoreCase("sim") ||
                ehEstudante.equalsIgnoreCase("s")   ||
                ehEstudante.equalsIgnoreCase("ss")) {
                estudante = true;
            } else {
                estudante = false;
            }
            
            Cliente c1 = new Cliente(nome, cpf, idade, rg, estudante);
            if (c1.inserir()) {
                clientes.add(c1);
                System.out.println("Cliente cadastrado!");
            } else {
                System.out.println("Erro no cadastro");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada, verifique se colocou o conteúdo correto!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void inserirAtor() {
        try {
            System.out.print("Digite o nome do ator: ");
            String nome = sc.nextLine();
            
            System.out.print("Digite o cpf do ator: ");
            String cpf = sc.nextLine();

            System.out.print("Digite a idade do ator: ");
            int idade = sc.nextInt();
            sc.nextLine(); 

            System.out.println("Digite o registo profissional do ator ( ID ): "); 
            int registroProfissional = sc.nextInt(); 
            sc.nextLine();

            Ator a1 = new Ator(nome, cpf, idade, registroProfissional );
            if (a1.inserir()) {
                atores.add(a1);
                System.out.println("Ator cadastrado!");
            } else {
                System.out.println("Erro no cadastro");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada, verifique se colocou o conteúdo correto!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void inserirElenco() {
        try {
            System.out.print("Digite o ID do elenco: ");
            int idElenco = sc.nextInt();
            sc.nextLine();

            System.out.print("Digite o CPF do ator: ");
            String cpfAtor = sc.nextLine();
            
            System.out.print("Digite o título do filme: ");
            String tituloFilme = sc.nextLine();

            System.out.print("O ator é principal? ");
            String ehPrincipal = sc.nextLine();
            boolean atorPrincipal = ehPrincipal.equalsIgnoreCase("sim") || ehPrincipal.equalsIgnoreCase("s");

            Ator ator = null;
            for (Ator a : atores) {
                if (a.getCpf().equals(cpfAtor)) {
                    ator = a;
                    break;
                }
            }

            Filme filme = null;
            for (Filme f : filmes) {
                if (f.getTitulo().equals(tituloFilme)) {
                    filme = f;
                    break;
                }
            }

            if (ator != null && filme != null) {
                Elenco e1 = new Elenco(idElenco, ator, filme, atorPrincipal);
                if (e1.inserir()) {
                    elencos.add(e1);
                    System.out.println("Elenco cadastrado!");
                }
            } else {
                System.out.println("Ator ou filme não encontrado!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada, verifique se colocou o conteúdo correto!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void inserirFilme() {
        try {
            System.out.print("Digite o ID do filme: ");
            int idFilme = sc.nextInt();
            sc.nextLine();

            System.out.print("Digite o título do filme: ");
            String titulo = sc.nextLine();

            System.out.print("Digite a duração do filme (em minutos): ");
            int duracao = sc.nextInt();
            sc.nextLine();

            System.out.print("Digite o ID do gênero: ");
            int idGenero = sc.nextInt();
            sc.nextLine();

            Genero genero = null;
            for (Genero g : generos) {
                if (g.getIdGenero() == idGenero) {
                    genero = g;
                    break;
                }
            }

            if (genero == null) {
                System.out.println("Gênero não encontrado!");
                return;
            }

            Filme f1 = new Filme(idFilme, titulo, duracao, genero);
            if (f1.inserir()) {
                filmes.add(f1);
                System.out.println("Filme cadastrado!");
            } else {
                System.out.println("Erro no cadastro");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada, verifique se colocou o conteúdo correto!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void inserirGenero() {
        try {
            System.out.print("Digite o ID do gênero: ");
            int idGenero = sc.nextInt();
            sc.nextLine();

            System.out.print("Digite a descrição do gênero: ");
            String descGenero = sc.nextLine();

            Genero g1 = new Genero(idGenero, descGenero);
            if (g1.inserir()) {
                generos.add(g1);
                System.out.println("Gênero cadastrado!");
            } else {
                System.out.println("Erro no cadastro");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada, verifique se colocou o conteúdo correto!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void inserirSessao() {
        try {
            System.out.print("Digite o ID da sessão: ");
            int idSessao = sc.nextInt();
            sc.nextLine();

            System.out.print("Digite a data da sessão (DD/MM/AAAA): ");
            String dataSessao = sc.nextLine();

            System.out.print("Digite a hora da sessão (HH:MM): ");
            String horaSessao = sc.nextLine();

            System.out.print("Digite a classificação indicativa: ");
            int classificacao = sc.nextInt();
            sc.nextLine();

            System.out.print("Digite o título do filme: ");
            String tituloFilme = sc.nextLine();
            Filme filme = null;
            for (Filme f : filmes) {
                if (f.getTitulo().equals(tituloFilme)) {
                    filme = f;
                    break;
                }
            }
            if (filme == null) {
                System.out.println("Filme não encontrado!");
                return;
            }

            Sessao s1 = new Sessao(idSessao, dataSessao, horaSessao, classificacao, filme);
            if (s1.inserir()) {
                sessoes.add(s1);
                System.out.println("Sessão cadastrada!");
            } else {
                System.out.println("Erro no cadastro");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada, verifique se colocou o conteúdo correto!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void inserirIngresso() {
        try {
            System.out.print("Digite o ID do ingresso: ");
            int idIngresso = sc.nextInt();
            sc.nextLine();

            System.out.print("Digite o valor do ingresso: ");
            double valor = sc.nextDouble();
            sc.nextLine();

            System.out.print("É meia entrada? (sim/não): ");
            String ehMeia = sc.nextLine();
            boolean meiaEntrada = ehMeia.equalsIgnoreCase("sim") || 
                                ehMeia.equalsIgnoreCase("s");

            System.out.print("É gratuito? (sim/não): ");
            String ehGratuito = sc.nextLine();
            boolean gratuidade = ehGratuito.equalsIgnoreCase("sim") || 
                               ehGratuito.equalsIgnoreCase("s");

            System.out.print("Foi utilizado? (sim/não): ");
            String foiUtilizado = sc.nextLine();
            boolean utilizado = foiUtilizado.equalsIgnoreCase("sim") || 
                              foiUtilizado.equalsIgnoreCase("s");

            System.out.print("Digite o CPF do cliente: ");
            String cpfCliente = sc.nextLine();
            Cliente cliente = null;
            for (Cliente c : clientes) {
                if (c.getCpf().equals(cpfCliente)) {
                    cliente = c;
                    break;
                }
            }
            if (cliente == null) {
                System.out.println("Cliente não encontrado!");
                return;
            }

            System.out.print("Digite o ID da sessão: ");
            int idSessao = sc.nextInt();
            sc.nextLine();
            Sessao sessao = null;
            for (Sessao s : sessoes) {
                if (s.getIdSessao() == idSessao) {
                    sessao = s;
                    break;
                }
            }
            if (sessao == null) {
                System.out.println("Sessão não encontrada!");
                return;
            }

            Ingresso i1 = new Ingresso(idIngresso, valor, meiaEntrada, gratuidade, utilizado, sessao, cliente);
            if (i1.inserir()) {
                ingressos.add(i1);
                System.out.println("Ingresso cadastrado!");
            } else {
                System.out.println("Erro no cadastro");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada, verifique se colocou o conteúdo correto!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void listarAtores() {
        System.out.println("\n=== LISTA DE ATORES ===");
        for (Ator ator : atores) {
            System.out.println("Nome: " + ator.getNome());
            System.out.println("CPF: " + ator.getCpf());
            System.out.println("Idade: " + ator.getIdade());
            System.out.println("Registro profissional: " + ator.getRegistroProfissional());
            System.out.println("------------------------");
        }
    }

    public void listarClientes() {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Idade: " + cliente.getIdade());
            System.out.println("RG: " + cliente.getRg());
            System.out.println("Estudante: " + cliente.getEstudante());
            System.out.println("------------------------");
        }
    }

    public void listarElencos() {
        System.out.println("\n=== LISTA DE ELENCOS ===");
        for (Elenco elenco : elencos) {
            System.out.println("ID: " + elenco.getIdElenco());
            System.out.println("Ator: " + elenco.getAtor().getNome());
            System.out.println("Filme: " + elenco.getFilme().getTitulo());
            System.out.println("Ator Principal: " + (elenco.getAtorPrincipal() ? "Sim" : "Não"));
            System.out.println("------------------------");
        }
    }

    public void listarFilmes() {
        System.out.println("\n=== LISTA DE FILMES ===");
        for (Filme filme : filmes) {
            System.out.println("ID: " + filme.getIdFilme());
            System.out.println("Título: " + filme.getTitulo());
            System.out.println("Duração: " + filme.getDuracao() + " minutos");
            System.out.println("Gênero: " + filme.getGenero().getDescGenero());
            System.out.println("------------------------");
        }
    }

    public void listarGeneros() {
        System.out.println("\n=== LISTA DE GÊNEROS ===");
        for (Genero genero : generos) {
            System.out.println("ID: " + genero.getIdGenero());
            System.out.println("Descrição: " + genero.getDescGenero());
            System.out.println("------------------------");
        }
    }

    public void listarSessoes() {
        System.out.println("\n=== LISTA DE SESSÕES ===");
        for (Sessao sessao : sessoes) {
            System.out.println("ID: " + sessao.getIdSessao());
            System.out.println("Data: " + sessao.getDataSessao());
            System.out.println("Hora: " + sessao.getHoraSessao());
            System.out.println("Classificação: " + sessao.getClassificacao());
            System.out.println("Filme: " + sessao.getFilme().getTitulo());
            System.out.println("------------------------");
        }
    }

    public void listarIngressos() {
        System.out.println("\n=== LISTA DE INGRESSOS ===");
        for (Ingresso ingresso : ingressos) {
            System.out.println("ID: " + ingresso.getIdIngresso());
            System.out.println("Valor: R$ " + ingresso.getValor());
            System.out.println("Cliente: " + ingresso.getCliente().getNome());
            System.out.println("Sessão: " + ingresso.getSessao().getIdSessao());
            System.out.println("------------------------");
        }
    }

    public void consultarElenco() {
        try {
            System.out.print("Digite o ID do elenco para consulta: ");
            int idElenco = sc.nextInt();
            sc.nextLine(); 
    
            Elenco encontrado = null;
            for (Elenco e : elencos) {
                if (e.getIdElenco() == idElenco) {
                    encontrado = e;
                    break;
                }
            }
            if (encontrado != null) {
                System.out.println("=== Elenco Encontrado ===");
                System.out.println("ID: " + encontrado.getIdElenco());
                System.out.println("Ator: " + encontrado.getAtor().getNome());
                System.out.println("Filme: " + encontrado.getFilme().getTitulo());
                System.out.println("Ator Principal: " + (encontrado.getAtorPrincipal() ));
            } else {
                System.out.println("Elenco não encontrado.");
            }
    
        } catch (InputMismatchException e) {
            System.out.println("ID inválido! Digite um número inteiro.");
            sc.nextLine(); 
        }
    }

    public void consultarCliente() {
        try {
            System.out.print("Digite o CPF do cliente para consulta: ");
            String cpf = sc.nextLine();
    
            Cliente encontrado = null;
            for (Cliente c : clientes) {
                if (c.getCpf().equals(cpf)) {
                    encontrado = c;
                    break;
                }
            }
            if (encontrado != null) {
                System.out.println("=== Cliente Encontrado ===");
                System.out.println("Nome: " + encontrado.getNome());
                System.out.println("CPF: " + encontrado.getCpf());
                System.out.println("Idade: " + encontrado.getIdade());
                System.out.println("RG: " + encontrado.getRg());
                System.out.println("Estudante: " + (encontrado.getEstudante() ? "Sim" : "Não"));
            } else {
                System.out.println("Cliente não encontrado.");
            }
    
        } catch (Exception e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        }
    }

    public void consultarAtor() {
        try {
            System.out.print("Digite o CPF do ator para consulta: ");
            String cpf = sc.nextLine();
    
            Ator encontrado = null;
            for (Ator a : atores) {
                if (a.getCpf().equals(cpf)) {
                    encontrado = a;
                    break;
                }
            }
            if (encontrado != null) {
                System.out.println("=== Ator Encontrado ===");
                System.out.println("Nome: " + encontrado.getNome());
                System.out.println("CPF: " + encontrado.getCpf());
                System.out.println("Idade: " + encontrado.getIdade());
                System.out.println("Registro Profissional: " + encontrado.getRegistroProfissional());
            } else {
                System.out.println("Ator não encontrado.");
            }
    
        } catch (Exception e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        }
    }

    public void consultarFilme() {
        try {
            System.out.print("Digite o ID do filme para consulta: ");
            int idFilme = sc.nextInt();
            sc.nextLine();
    
            Filme encontrado = null;
            for (Filme f : filmes) {
                if (f.getIdFilme() == idFilme) {
                    encontrado = f;
                    break;
                }
            }
            if (encontrado != null) {
                System.out.println("=== Filme Encontrado ===");
                System.out.println("ID: " + encontrado.getIdFilme());
                System.out.println("Título: " + encontrado.getTitulo());
                System.out.println("Duração: " + encontrado.getDuracao() + " minutos");
                System.out.println("Gênero: " + encontrado.getGenero().getDescGenero());
            } else {
                System.out.println("Filme não encontrado.");
            }
    
        } catch (InputMismatchException e) {
            System.out.println("ID inválido! Digite um número inteiro.");
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        }
    }

    public void consultarGenero() {
        try {
            System.out.print("Digite o ID do gênero para consulta: ");
            int idGenero = sc.nextInt();
            sc.nextLine();
    
            Genero encontrado = null;
            for (Genero g : generos) {
                if (g.getIdGenero() == idGenero) {
                    encontrado = g;
                    break;
                }
            }
            if (encontrado != null) {
                System.out.println("=== Gênero Encontrado ===");
                System.out.println("ID: " + encontrado.getIdGenero());
                System.out.println("Descrição: " + encontrado.getDescGenero());
            } else {
                System.out.println("Gênero não encontrado.");
            }
    
        } catch (InputMismatchException e) {
            System.out.println("ID inválido! Digite um número inteiro.");
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        }
    }

    public void consultarSessao() {
        try {
            System.out.print("Digite o ID da sessão para consulta: ");
            int idSessao = sc.nextInt();
            sc.nextLine();
    
            Sessao encontrada = null;
            for (Sessao s : sessoes) {
                if (s.getIdSessao() == idSessao) {
                    encontrada = s;
                    break;
                }
            }
            if (encontrada != null) {
                System.out.println("=== Sessão Encontrada ===");
                System.out.println("ID: " + encontrada.getIdSessao());
                System.out.println("Data: " + encontrada.getDataSessao());
                System.out.println("Hora: " + encontrada.getHoraSessao());
                System.out.println("Classificação: " + encontrada.getClassificacao());
                System.out.println("Filme: " + encontrada.getFilme().getTitulo());
            } else {
                System.out.println("Sessão não encontrada.");
            }
    
        } catch (InputMismatchException e) {
            System.out.println("ID inválido! Digite um número inteiro.");
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        }
    }

    public void consultarIngresso() {
        try {
            System.out.print("Digite o ID do ingresso para consulta: ");
            int idIngresso = sc.nextInt();
            sc.nextLine();
    
            Ingresso encontrado = null;
            for (Ingresso i : ingressos) {
                if (i.getIdIngresso() == idIngresso) {
                    encontrado = i;
                    break;
                }
            }
            if (encontrado != null) {
                System.out.println("=== Ingresso Encontrado ===");
                System.out.println("ID: " + encontrado.getIdIngresso());
                System.out.println("Valor: R$ " + encontrado.getValor());
                System.out.println("Meia Entrada: " + (encontrado.getMeiaEntrada() ? "Sim" : "Não"));
                System.out.println("Gratuito: " + (encontrado.getGratuidade() ? "Sim" : "Não"));
                System.out.println("Utilizado: " + (encontrado.getUtilizado() ? "Sim" : "Não"));
                System.out.println("Cliente: " + encontrado.getCliente().getNome());
                System.out.println("Sessão: " + encontrado.getSessao().getIdSessao());
            } else {
                System.out.println("Ingresso não encontrado.");
            }
    
        } catch (InputMismatchException e) {
            System.out.println("ID inválido! Digite um número inteiro.");
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        }
    }

    public void menuClientes() {
        while (true) {
            try {
                System.out.println("\n=== MENU CLIENTES ===");
                System.out.println("1 - Inserir cliente");
                System.out.println("2 - Listar clientes");
                System.out.println("3 - Consultar cliente");
                System.out.println("4 - Sair");
                System.out.print("Digite sua opção: ");

                int opcao = sc.nextInt();
                sc.nextLine(); 

                switch (opcao) {
                    case 1:
                        inserirCliente();
                        break;
                    case 2:
                        listarClientes();
                        break;
                    case 3:
                        consultarCliente();
                        break;
                    case 4:
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite uma entrada valida!");
                sc.nextLine(); 
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                sc.nextLine();
            }
        } 
    }

    public void menuAtores() {
        while (true) {
            try {
                System.out.println("\n=== MENU Atores ===");
                System.out.println("1 - Inserir ator");
                System.out.println("2 - Listar atores");
                System.out.println("3 - Consultar ator");
                System.out.println("4 - Sair");
                System.out.print("Digite sua opção: ");

                int opcao = sc.nextInt();
                sc.nextLine(); 

                switch (opcao) {
                    case 1:
                        inserirAtor();
                        break;
                    case 2:
                        listarAtores();
                        break;
                    case 3:
                        consultarAtor();
                        break;
                    case 4:
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite uma entrada valida!");
                sc.nextLine(); 
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                sc.nextLine();
            }
        } 
    }

    public void menuElenco() {
        while (true) {
            try {
                System.out.println("\n=== MENU ELENCO ===");
                System.out.println("1 - Inserir elenco");
                System.out.println("2 - Listar elencos");
                System.out.println("3 - Consultar Elenco");
                System.out.println("4 - Sair");
                System.out.print("Digite sua opção: ");
                 
                int opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        inserirElenco();
                        break;
                    case 2:
                        listarElencos();
                        break;
                    case 3:
                         consultarElenco();
                    case 4:
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite uma entrada valida!");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                sc.nextLine();
            }
        }
    }

    public void menuFilmes() {
        while (true) {
            try {
                System.out.println("\n=== MENU FILMES ===");
                System.out.println("1 - Inserir filme");
                System.out.println("2 - Listar filmes");
                System.out.println("3 - Consultar filme");
                System.out.println("4 - Sair");
                System.out.print("Digite sua opção: ");

                int opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        inserirFilme();
                        break;
                    case 2:
                        listarFilmes();
                        break;
                    case 3:
                        consultarFilme();
                        break;
                    case 4:
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite uma entrada valida!");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                sc.nextLine();
            }
        }
    }

    public void menuGeneros() {
        while (true) {
            try {
                System.out.println("\n=== MENU GÊNEROS ===");
                System.out.println("1 - Inserir gênero");
                System.out.println("2 - Listar gêneros");
                System.out.println("3 - Consultar gênero");
                System.out.println("4 - Sair");
                System.out.print("Digite sua opção: ");

                int opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        inserirGenero();
                        break;
                    case 2:
                        listarGeneros();
                        break;
                    case 3:
                        consultarGenero();
                        break;
                    case 4:
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite uma entrada valida!");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                sc.nextLine();
            }
        }
    }

    public void menuSessoes() {
        while (true) {
            try {
                System.out.println("\n=== MENU SESSÕES ===");
                System.out.println("1 - Inserir sessão");
                System.out.println("2 - Listar sessões");
                System.out.println("3 - Consultar sessão");
                System.out.println("4 - Sair");
                System.out.print("Digite sua opção: ");

                int opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        inserirSessao();
                        break;
                    case 2:
                        listarSessoes();
                        break;
                    case 3:
                        consultarSessao();
                        break;
                    case 4:
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite uma entrada valida!");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                sc.nextLine();
            }
        }
    }

    public void menuIngressos() {
        while (true) {
            try {
                System.out.println("\n=== MENU INGRESSOS ===");
                System.out.println("1 - Inserir ingresso");
                System.out.println("2 - Listar ingressos");
                System.out.println("3 - Consultar ingresso");
                System.out.println("4 - Sair");
                System.out.print("Digite sua opção: ");

                int opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        inserirIngresso();
                        break;
                    case 2:
                        listarIngressos();
                        break;
                    case 3:
                        consultarIngresso();
                        break;
                    case 4:
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite uma entrada valida!");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                sc.nextLine();
            }
        }
    }
}












        
        





    