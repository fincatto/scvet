CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS public.empresa (
    id UUID NOT NULL PRIMARY KEY UNIQUE DEFAULT uuid_generate_v4(),
    cadastro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    documento character varying NOT NULL UNIQUE,
    nome character varying
);

CREATE TABLE IF NOT EXISTS public.usuario (
    id UUID NOT NULL PRIMARY KEY UNIQUE DEFAULT uuid_generate_v4(),
    cadastro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_empresa UUID NOT NULL,
    documento character varying NOT NULL UNIQUE,
    email character varying NOT NULL UNIQUE,
    nome character varying,
    senha character varying,
    confirmacao TIMESTAMP,
    CONSTRAINT empresa_fkey FOREIGN KEY (id_empresa) REFERENCES public.empresa (id) ON DELETE RESTRICT ON UPDATE CASCADE
);

INSERT INTO public.empresa (documento,nome)
VALUES ('04514927902','Diego Fincatto Co');

INSERT INTO public.usuario (id_empresa,documento,email,nome,senha)
VALUES (
    (SELECT id FROM public.empresa WHERE documento = '04514927902' LIMIT 1),
    '04514927902','diego@fincatto.com','Diego Fincatto Co','Diego123!'
);