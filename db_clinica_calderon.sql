CREATE DATABASE Clinica_Calderon_DB;

SELECT * FROM  TB_ODONTOLOGOS;

SELECT * FROM TB_PACIENTES;
SELECT * FROM TB_TRATAMIENTOS;
SELECT * FROM TB_CITAS;
SELECT * FROM TB_PROFORMAS;
SELECT * FROM TB_HISTORIAL_PAGOS;

CREATE TABLE TB_USUARIO (
    usuarios VARCHAR(10) NOT NULL,
    contrasena VARCHAR(10) NOT NULL
);

CREATE TABLE TB_PACIENTES (
    id_paciente INT AUTO_INCREMENT PRIMARY KEY,
    nombre_paciente VARCHAR(150) NOT NULL,
    apellido_paciente VARCHAR(150) NOT NULL,
    dni_paciente VARCHAR(15) NOT NULL,
    edad_paciente VARCHAR(15) NOT NULL,
    enfermedad_paciente VARCHAR(255) NOT NULL,
    celular_paciente VARCHAR(15) NOT NULL,
    fecha_inscripcion DATETIME
);

CREATE TABLE TB_ODONTOLOGOS (
    id_odontologo INT AUTO_INCREMENT PRIMARY KEY,
    nombre_odontologo VARCHAR(255),
    apellido_odontologo VARCHAR(255),
    celular_odontologo VARCHAR(15)
);

CREATE TABLE TB_LISTA_TRATAMIENTOS (
    id_tratamiento INT AUTO_INCREMENT PRIMARY KEY,
    nombre_tratamiento VARCHAR(100),
    costo_tratamiento DECIMAL(10,2)
);

CREATE TABLE TB_CITAS (
    id_cita INT AUTO_INCREMENT PRIMARY KEY,
    id_tratamiento INT NOT NULL,
    dni_paciente VARCHAR(15) NOT NULL,
    nombre_paciente VARCHAR(150) NOT NULL,
    apellido_paciente VARCHAR(150) NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    odontologo VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    estado_cita VARCHAR(50) DEFAULT 'PENDIENTE'
);

CREATE TABLE TB_PROFORMAS (
    id_proforma INT AUTO_INCREMENT PRIMARY KEY,
    nombre_paciente VARCHAR(150) NOT NULL,
    apellido_paciente VARCHAR(150) NOT NULL,
    edad_paciente VARCHAR(5) NOT NULL,
    telefono_paciente VARCHAR(15) NOT NULL,
    direccion_paciente VARCHAR(255) NOT NULL,
    antecedentes VARCHAR(500) NOT NULL,
    motivo_consulta VARCHAR(500) NOT NULL,
    fecha_registro DATE NOT NULL,
    hora_registro TIME NOT NULL,
    tratamientos VARCHAR(255) NOT NULL,
    cantidades_tratamiento VARCHAR(255) NOT NULL,
    costos_unitarios VARCHAR(255) NOT NULL,
    subtotales VARCHAR(255) NOT NULL,
    total DOUBLE NOT NULL
);

CREATE TABLE TB_TRATAMIENTOS (
    id_tratamiento INT AUTO_INCREMENT PRIMARY KEY,
    dni_paciente VARCHAR(10) NOT NULL,
    nombre_paciente VARCHAR(150) NOT NULL,
    apellido_paciente VARCHAR(150) NOT NULL,
    tratamiento VARCHAR(255) NOT NULL,
    odontologo VARCHAR(150) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    fecha_creacion DATE NOT NULL,    
    citas INT DEFAULT 0 NOT NULL,
    costo DECIMAL(10,2) NOT NULL,
    deuda DECIMAL(10,2) NOT NULL,
    estado_pago VARCHAR(50) DEFAULT 'PENDIENTE',
    estado_tratamiento VARCHAR(50) DEFAULT 'PENDIENTE'
);

CREATE TABLE TB_HISTORIAL_PAGOS (
	id_pago INT AUTO_INCREMENT PRIMARY KEY,
    id_tratamiento INT NOT NULL,
    fecha_pago DATE NOT NULL,
    hora_pago TIME NOT NULL,
    dni_paciente VARCHAR (15) NOT NULL,
    nombre_paciente VARCHAR (150) NOT NULL,
    apellido_paciente VARCHAR (150) NOT NULL,
    dinero_ingresado DOUBLE NOT NULL,
    metodo_pago VARCHAR (100) NOT NULL
);

CREATE TABLE TB_METODO_PAGO (
	id_metodo INT AUTO_INCREMENT PRIMARY KEY,
    metodo_pago VARCHAR (100)
);

-- INSERT

INSERT INTO TB_USUARIO(usuarios, contrasena)
VALUES('admin','admin');

INSERT INTO TB_ODONTOLOGOS(nombre_odontologo, apellido_odontologo, celular_odontologo)
VALUES('Oswaldo', 'Calderon', '987654321'),
('Victor', 'Calderon', '321654897'),
('Alexis', 'Calderon', '654987321'),
('Alexandra', 'Calderon', '897541322'),
('Nicole', 'Calderon', '519652328');

INSERT INTO TB_LISTA_TRATAMIENTOS(nombre_tratamiento, costo_tratamiento)
VALUES('Profilaxis Simples', 80),
('Profilaxis Complejas', 150),
('Resina Simple', 50),
('Resina Compuesta', 80),
('Sellantes', 70),
('Espigos', 150),
('Endodoncia Piezas Anteriores', 250),
('Endodoncia en Molares', 400),
('Exodoncia Niños', 80),
('Exodoncias Simples', 80),
('Exodoncias Complejas', 150),
('Corona de Porcelana 1 a 2 Piezas', 400),
('Corona de Porcelana de 3 a mas piezas', 350),
('Protesis Total', 1000),
('Protesis Total con Dientes Ortolux', 1200),
('PPR Metalicas', 1200),
('PPR Metalicas con Dientes Ortolux', 1300),
('PPR Acrilico', 900),
('Pulpotomias', 200),
('Incrustacion Metal', 300),
('Incrustacion Ivocron', 300),
('Incrustacion Porcelana', 400),
('Implante Dentario', 2000),
('Implante Dentario + Corona de Porcelana', 2300),
('Coronas Ivocron', 250),
('Coronas Vinner', 300),
('Coronas de Circonio Porcelana', 700),
('Carillas de Resina Diecta (1 año Garantia)', 200),
('Carillas de Porcelanas', 600),
('Carillas de Circonio', 700),
('Carillas de Silicato', 700),
('Blanqueamiento de Consultorio', 350),
('Blanqueamiento casero', 250),
('Gingivoplastia (Por Arcada)', 200),
('Recorte de Hueso (Por Arcada)', 200);