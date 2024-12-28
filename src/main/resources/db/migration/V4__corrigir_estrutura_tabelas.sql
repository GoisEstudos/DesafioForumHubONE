DROP TABLE public.resposta CASCADE;
DROP TABLE public.topico CASCADE;
DROP TABLE public.curso CASCADE;
DROP TABLE public.usuario CASCADE;
DROP TABLE public.perfil CASCADE;

CREATE TABLE public.Curso (
    id BIGSERIAL NOT NULL,
    nome VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL,
    CONSTRAINT pk_curso PRIMARY KEY (id)
);

CREATE TABLE public.Perfil (
    id BIGSERIAL NOT NULL,
    nome VARCHAR(255) NOT NULL,
    CONSTRAINT perfil_pkey PRIMARY KEY (id)
);

CREATE TABLE public.Usuario (
    id BIGSERIAL NOT NULL,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    perfil_id BIGINT NOT NULL,
    CONSTRAINT usuario_pkey PRIMARY KEY (id),
    CONSTRAINT fk_usuario_perfil FOREIGN KEY (perfil_id) REFERENCES public.perfil(id)
);

CREATE TABLE public.Topico (
    id BIGSERIAL NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    mensagem VARCHAR(255) NOT NULL,
    data_criacao TIMESTAMP NOT NULL DEFAULT now(),
    status VARCHAR(50) NOT NULL DEFAULT 'ATIVO',
    usuario_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    categoria VARCHAR(255),
    CONSTRAINT topico_pkey PRIMARY KEY (id),
    CONSTRAINT fk_topico_usuario FOREIGN KEY (usuario_id) REFERENCES public.usuario(id),
    CONSTRAINT fk_topico_curso FOREIGN KEY (curso_id) REFERENCES public.curso(id)
);

CREATE TABLE public.Resposta (
    id BIGSERIAL NOT NULL,
    mensagem VARCHAR(255) NOT NULL,
    data_criacao TIMESTAMP NOT NULL DEFAULT now(),
    topico_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    solucao BOOLEAN NOT NULL DEFAULT false,
    CONSTRAINT resposta_pkey PRIMARY KEY (id),
    CONSTRAINT fk_resposta_topico FOREIGN KEY (topico_id) REFERENCES public.topico(id),
    CONSTRAINT fk_resposta_usuario FOREIGN KEY (usuario_id) REFERENCES public.usuario(id)
);