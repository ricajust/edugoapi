-- Migrations will appear here as you chat with AI

create table professor (
  id bigint primary key generated always as identity,
  nome text not null,
  cpf text unique not null,
  orientacao_sexual text,
  email text unique not null,
  telefone text,
  proficiencia text
);

create table aluno (
  id bigint primary key generated always as identity,
  nome text not null,
  cpf text unique not null,
  orientacao_sexual text,
  email text unique not null,
  telefone text,
  profissao text
);

create table curso (
  id bigint primary key generated always as identity,
  descricao text not null,
  carga_horaria int not null,
  valor numeric(10, 2) not null
);

create table disciplina (
  id bigint primary key generated always as identity,
  descricao text not null,
  professor_id bigint not null,
  foreign key (professor_id) references professor (id)
);

create table nota (
  id bigint primary key generated always as identity,
  aluno_id bigint not null,
  disciplina_id bigint not null,
  valor numeric(5, 2) not null,
  foreign key (aluno_id) references aluno (id),
  foreign key (disciplina_id) references disciplina (id)
);

create table frequencia (
  id bigint primary key generated always as identity,
  aluno_id bigint not null,
  disciplina_id bigint not null,
  presencas int not null,
  total_aulas int not null,
  foreign key (aluno_id) references aluno (id),
  foreign key (disciplina_id) references disciplina (id)
);

create table matricula (
  id bigint primary key generated always as identity,
  aluno_id bigint not null,
  curso_id bigint not null,
  foreign key (aluno_id) references aluno (id),
  foreign key (curso_id) references curso (id)
);

create table parcela (
  id bigint primary key generated always as identity,
  matricula_id bigint not null,
  valor numeric(10, 2) not null,
  status text check (status in ('pago', 'pendente', 'cancelado')) not null,
  foreign key (matricula_id) references matricula (id)
);

create table secretaria (
  id bigint primary key generated always as identity,
  nome text not null,
  cpf text unique not null,
  orientacao_sexual text,
  email text unique not null,
  telefone text,
  profissao text
);

create table curso_disciplina (
  curso_id bigint not null,
  disciplina_id bigint not null,
  primary key (curso_id, disciplina_id),
  foreign key (curso_id) references curso (id),
  foreign key (disciplina_id) references disciplina (id)
);

alter table aluno
rename to student;

alter table curso
rename to course;

alter table disciplina
rename to subject;

alter table professor
rename to teacher;

alter table nota
rename to grade;

alter table frequencia
rename to attendance;

alter table matricula
rename to enrollment;

alter table parcela
rename to installment;

alter table secretaria
rename to administration;

alter table curso_disciplina
rename to course_subject;

alter table student
rename column nome to name;

alter table student
rename column orientacao_sexual to gender;

alter table student
rename column telefone to phone;

alter table student
rename column profissao to profession;

alter table course
rename column descricao to description;

alter table course
rename column carga_horaria to workload;

alter table course
rename column valor to price;

alter table subject
rename column descricao to description;

alter table subject
rename column professor_id to teacher_id;

alter table teacher
rename column nome to name;

alter table teacher
rename column orientacao_sexual to gender;

alter table teacher
rename column telefone to phone;

alter table teacher
rename column proficiencia to proficiency;

alter table grade
rename column aluno_id to student_id;

alter table grade
rename column disciplina_id to subject_id;

alter table grade
rename column valor to value;

alter table attendance
rename column aluno_id to student_id;

alter table attendance
rename column disciplina_id to subject_id;

alter table attendance
rename column presencas to presences;

alter table attendance
rename column total_aulas to total_classes;

alter table enrollment
rename column aluno_id to student_id;

alter table enrollment
rename column curso_id to course_id;

alter table installment
rename column matricula_id to enrollment_id;

alter table installment
rename column valor to amount;

alter table administration
rename column nome to name;

alter table administration
rename column orientacao_sexual to gender;

alter table administration
rename column telefone to phone;

alter table administration
rename column profissao to profession;

alter table course_subject
rename column curso_id to course_id;

alter table course_subject
rename column disciplina_id to subject_id;