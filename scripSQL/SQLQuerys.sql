
----------------------------- ENTIDAD - tipo_cliente ---------------------------
SELECT * FROM tipo_cliente

--No es necesario pasar el id, pues fue configurado pro JPA como autoincremental.
INSERT INTO tipo_cliente (tipo) 
VALUES 
	('PERSONA SIN RUC'),
	('PERSONA NATURAL'),
	('PERSONA JURIDICA')
---------------------------------------------------------------------------------

------------------------------ ENTIDAD - genero ---------------------------------
SELECT * FROM genero

--No es necesario pasar el id, pues fue configurado pro JPA como autoincremental.
INSERT INTO genero (tipo) 
VALUES 
	('HOMBRE'),
	('MUJER'),
	('OTRO')
----------------------------------------------------------------------------------

-------------------------------- ENTIDAD - servicio ------------------------------
SELECT * FROM servicio

--No es necesario pasar el id, pues fue configurado pro JPA como autoincremental.
INSERT INTO servicio (tipo) 
VALUES 
	('TRANSPORTE DE TRABAJADORES'),
	('TRANSPORTE FAMILIAR'),
	('TRANSPORTE ESCOLAR')
----------------------------------------------------------------------------------


-------------------------------- ENTIDAD - inventario ----------------------------
SELECT * FROM inventario

--No es necesario pasar el id, pues fue configurado pro JPA como autoincremental.
INSERT INTO inventario (nombre,estado) 
VALUES 
	('INVENTARIO A', 'true')
----------------------------------------------------------------------------------

-------------------------------- ENTIDAD - proveedor -----------------------------
SELECT * FROM proveedor

--No es necesario pasar el id, pues fue configurado pro JPA como autoincremental.
INSERT INTO proveedor (nombre,ruc,telefono,email,direccion,estado) 
VALUES 
	('Piezas MotorXpress','20123456789','912342578','piezasmotorxpress@gmail.com','Av Grau 148, Ica','true')
----------------------------------------------------------------------------------