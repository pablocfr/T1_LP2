CREATE DATABASE BD1_I202407970;
USE BD1_I202407970;

CREATE TABLE Cliente(
	id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre_empresa VARCHAR(50) NOT NULL,
    ruc VARCHAR(11) UNIQUE NOT NULL,
    correo VARCHAR(50)
);

CREATE TABLE TipoAuditoria(
	id_tipoAudi INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(20) NOT NULL
);

CREATE TABLE Especialista(
	id_especialista INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    dni varchar (8) NOT NULL,
    correo VARCHAR(50),
    especialidad VARCHAR(40) NOT NULL
);

CREATE TABLE Certificacion(
	id_certificacion INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT,
    id_tipoAudi INT,
    id_especialista INT,
    fecha_emi DATE NOT NULL,
    fecha_ven DATE,
    estado varchar(15) CHECK (estado IN ('VIGENTE', 'EXPIRADA', 'EN_REVISION')),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (id_tipoAudi) REFERENCES TipoAuditoria(id_tipoAudi),
    FOREIGN KEY (id_especialista) REFERENCES Especialista(id_especialista)
);

INSERT INTO TipoAuditoria (descripcion) VALUES
('ISO/IEC 27001'),('ISO/IEC 27017'),('ISO/IEC 27018'),('ISO/IEC 22301'),('SOC 2 Tipo II');

INSERT INTO Cliente (nombre_empresa, ruc, correo) VALUES
('CIBERDEFENSE S.A.C.', '12345678901', 'contacto@ciberdefense.com'),
('SEGURITECH PERU', '23456789012', 'info@seguritech.pe'),
('PROTINFO SOLUCIONES', '34567890123', 'ventas@protinfo.com'),
('REDGUARD LATAM', '45678901234', 'soporte@redguard.com'),
('AUDISEC GLOBAL', '56789012345', 'servicios@audisec.com');

INSERT INTO Especialista (nombre, dni, correo, especialidad) VALUES
('Lucía Ramírez', '74859612', 'lucia.ramirez@correo.com', 'Ciberseguridad'),
('Carlos Mendoza', '65987413', 'carlos.mendoza@correo.com', 'Auditoría TI'),
('Elena Gutiérrez', '81236574', 'elena.gutierrez@correo.com', 'Protección de Datos'),
('Javier Salas', '79845612', 'javier.salas@correo.com', 'Gestión de Continuidad'),
('María Chávez', '72149863', 'maria.chavez@correo.com', 'Normas Internacionales');

INSERT INTO Certificacion (id_cliente, id_tipoAudi, id_especialista, fecha_emi, fecha_ven, estado) VALUES
(1, 1, 1, '2024-01-10', '2025-01-10', 'VIGENTE'),
(2, 2, 2, '2023-05-15', '2024-05-15', 'EXPIRADA'),
(3, 3, 3, '2024-03-20', '2025-03-20', 'EN_REVISION'),
(4, 4, 4, '2024-02-01', '2025-02-01', 'VIGENTE'),
(5, 5, 5, '2022-12-05', '2023-12-05', 'EXPIRADA');