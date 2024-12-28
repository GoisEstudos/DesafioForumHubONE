INSERT INTO public.Curso (nome, categoria)
VALUES
('Matemática Básica', 'Ciências Exatas'),
('História da Arte', 'Artes'),
('Programação Java', 'Tecnologia'),
('Marketing Digital', 'Negócios'),
('Psicologia para Iniciantes', 'Saúde');

INSERT INTO public.Perfil (nome)
VALUES
('Administrador'),
('Professor'),
('Aluno'),
('Coordenador'),
('Mediador');

INSERT INTO public.Usuario (nome, email, senha, perfil_id)
VALUES
('João Silva', 'joao.silva@email.com', 'senha123', 1),
('Maria Oliveira', 'maria.oliveira@email.com', 'senha456', 2),
('Carlos Souza', 'carlos.souza@email.com', 'senha789', 3),
('Fernanda Costa', 'fernanda.costa@email.com', 'senha101', 4),
('Lucas Almeida', 'lucas.almeida@email.com', 'senha202', 5);

INSERT INTO public.Topico (titulo, mensagem, usuario_id, curso_id, categoria)
VALUES
('Introdução à Programação', 'Este tópico aborda os conceitos básicos de programação.', 3, 3, 'Tecnologia'),
('História das Civilizações', 'Um estudo sobre as principais civilizações ao longo da história.', 2, 2, 'História'),
('Marketing no Facebook', 'Estratégias e ferramentas de marketing no Facebook.', 4, 4, 'Negócios'),
('Fundamentos da Psicologia', 'Uma introdução aos conceitos principais da psicologia.', 5, 5, 'Saúde'),
('Matemática para Iniciantes', 'Tópicos básicos de matemática para quem está começando.', 1, 1, 'Ciências Exatas');

INSERT INTO public.Resposta (mensagem, topico_id, usuario_id, solucao)
VALUES
('O que é variável?', 1, 3, false),
('Como fazer uma análise crítica?', 2, 2, false),
('Como aumentar o engajamento?', 3, 4, false),
('Quais são os tipos de terapia?', 4, 5, true),
('Quais os primeiros conceitos de álgebra?', 5, 1, false);
