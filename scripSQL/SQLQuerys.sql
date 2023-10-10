
----------------------------- ENTIDAD - ROL ---------------------------
SELECT * FROM rol;
INSERT INTO rol (descripcion,nombre)  
VALUES
	('Rol de super usuario sin restricciones de acceso.', 'ROLE_ADMIN'),
	('Rol de usuario normal, con limitaciones de manipulacion de datos.', 'ROLE_USER'),
	('Rol de servicio al cliente.', 'ROLE_SAC'),
	('Rol de gestion de inventariado.', 'ROLE_GDI'),
	('Rol de gestion de inventariado.', 'ROLE_DBA')
-----------------------------------------------------------------------
----------------------------- ENTIDAD - MENU --------------------------
SELECT*FROM menu

INSERT INTO menu(icon,nombre,url)
VALUES 
	('home', 'Inicio','/page/inicio'),
	('design_services','Servicios','./'),
	('commute','Gestion de flota','./'),
	('fact_check','Gestion de facturas','./'),
	('outgoing_mail','Solicitud','./'),
	('recent_actors','Gestion de conductores','/page/trabajadores'),
	('contacts','Gestion de clientes','/page/clientes'),
	('my_location','Geolocalizacion','/page/geolocalizacion'),
	('calendar_month','Gestion de actividades','/page/calendar')

-----------------------------------------------------------------------
-------------------------- ENTIDAD - MENU_ROL -------------------------
 
select*from menu_rol
INSERT INTO menu_rol (id_menu,id_rol)
VALUES 
	--admin
	(1,1),
	(2,1),
	(3,1),
	(4,1),
	(5,1),
	(6,1),
	(7,1),
	(8,1),
	(9,1),

	--user
	(1,2),
	(5,2),
	(8,2)

	--SAC

	(1,3),
	
-----------------------------------------------------------------------
---------------------------- ENTIDAD - USUARIO ------------------------
select*from usuario

INSERT INTO usuario (email,estado,fecha_creacion,non_locked,password)
VALUES 
	('admin@admin.com', 'true', GETDATE() ,'true', '$2a$10$MspLnQ3sZYEvwSGWLXLaFOuMfDbtdX6BBIMkqWA3Xknyu1lioV9Qu'),--123
	('user@user.com', 'true', GETDATE() ,'true', '$2a$10$a/pi2aCD27TgalcV4xBbqu5ug3YGO.HeGAzZbNERefyKPxIgMVZ1m')--123

-----------------------------------------------------------------------
-------------------------- ENTIDAD - USUARIO_ROL -------------------------
SELECT*FROM usuario_rol

INSERT  INTO usuario_rol (id_usuario, id_rol)
VALUES
	(1,1),
	(2,2)


---**CONSULTA PARA LISTAR LOS MENUS DEL USUARIO EN BASE A SU ROL
select m.* from menu m inner join menu_rol mr on m.id_menu = mr.id_menu
            		   inner join rol r on r.id_rol=mr.id_rol
            		   inner join usuario_rol ur on ur.id_rol = r.id_rol
            		   inner join usuario u on u.id_usuario = ur.id_usuario
            		   where u.email='admin@admin.com'
-----------------------------------------------------------------------


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


