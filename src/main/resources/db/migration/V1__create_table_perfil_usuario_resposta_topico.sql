CREATE TABLE Curso (
    id SERIAL NOT NULL,
    nome VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL,
    CONSTRAINT pk_curso PRIMARY KEY (id)
);

CREATE TABLE Perfil (
  id INT NOT NULL PRIMARY KEY,
  nome VARCHAR(255) NOT NULL
);

CREATE TABLE Usuario (
  id SERIAL NOT NULL PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  senha VARCHAR(255) NOT NULL,
  perfis INT NOT NULL,
  CONSTRAINT fk_usuario_perfis FOREIGN KEY (perfis) REFERENCES Perfil(id)
);

CREATE TABLE Topico (
  id SERIAL PRIMARY KEY NOT NULL,
  titulo VARCHAR(255) NOT NULL,
  mensagem TEXT NOT NULL,
  dataCriacao TIMESTAMP NOT NULL,
  status VARCHAR(255) NOT NULL,
  usuario INT NOT NULL,
  curso INT NOT NULL,
  CONSTRAINT fk_topico_usuario FOREIGN KEY (usuario) REFERENCES Usuario(id),
  CONSTRAINT fk_topico_curso FOREIGN KEY (curso) REFERENCES Curso(id)
);

CREATE TABLE Resposta (
  id SERIAL PRIMARY KEY NOT NULL,
  mensagem TEXT NOT NULL,
  topico INT NOT NULL,
  dataCriacao TIMESTAMP NOT NULL,
  usuario INT NOT NULL,
  solucao TEXT NOT NULL,
  CONSTRAINT fk_resposta_topico FOREIGN KEY (topico) REFERENCES Topico(id),
  CONSTRAINT fk_topico_usuario FOREIGN KEY (usuario) REFERENCES Usuario(id)
);