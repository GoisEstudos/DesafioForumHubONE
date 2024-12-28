INSERT INTO Perfil (id, nome) VALUES
(1, 'ADMIN'),
(2, 'USER'),
(3, 'MODERATOR');

INSERT INTO Usuario (nome, email, senha, perfis) VALUES
('João Silva', 'joao.silva@example.com', 'senha123', 1),
('Maria Oliveira', 'maria.oliveira@example.com', 'senhaSegura', 2),
('Carlos Souza', 'carlos.souza@example.com', 'senhaForte', 3);