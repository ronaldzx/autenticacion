CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE public.applicant
(
    applicant_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name character varying,
    last_name character varying,
    birth_date character varying,
	address character varying,
	phone character varying,
	email_address  character varying,
	base_salary NUMERIC(12,2)
);