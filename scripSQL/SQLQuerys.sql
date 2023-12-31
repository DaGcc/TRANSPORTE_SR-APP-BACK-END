
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
	('dashboard','Dashboard','/page/dashboard'),

	('','Gestion de solicitudes','/page/solicitudes'),

	('home', 'Inicio','/page/inicio'),
	('perfil', 'person','/page/perfil'),
	('design_services','Servicios','./'),
	('commute','Gestion de flota','/page/flota'),
	('fact_check','Gestion de facturas','/page/facturas'),
	('outgoing_mail','Solicitud','/page/envio-solicitud'),
	('recent_actors','Gestion de conductores','/page/trabajadores'),
	('contacts','Gestion de clientes','/page/clientes'),
	('my_location','Geolocalizacion','/page/geolocalizacion'),
	('calendar_month','Gestion de actividades','/page/calendar')

UPDATE menu SET icon = 'mark_as_unread' WHERE id_menu = 11

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
	(10,1),
	(11, 1),
	(11, 1),
	(12,1)
	--user
	(1,2),
	(5,2),
	(8,2),
	(10,2)

	--SAC

	(1,3),
	
-----------------------------------------------------------------------

-------------------------- ENTIDAD - MENU_ROL -------------------------
select*from tipo_cuenta
INSERT INTO tipo_cuenta
VALUES 
	('ACC_CLIENTE'),
	('ACC_CONDUCTOR')

-----------------------------------------------------------------------


---------------------------- ENTIDAD - USUARIO ------------------------
select*from usuario

INSERT INTO usuario (email,estado,fecha_creacion,non_locked,password,id_tipo_cuenta)
VALUES 
	('admin@admin.com', 'true', GETDATE() ,'true', '$2a$10$MspLnQ3sZYEvwSGWLXLaFOuMfDbtdX6BBIMkqWA3Xknyu1lioV9Qu',1),--123
	('user@user.com', 'true', GETDATE() ,'true', '$2a$10$a/pi2aCD27TgalcV4xBbqu5ug3YGO.HeGAzZbNERefyKPxIgMVZ1m',2)--123

-----------------------------------------------------------------------
-------------------------- ENTIDAD - USUARIO_ROL -------------------------
SELECT*FROM usuario_rol

INSERT  INTO usuario_rol (id_usuario, id_rol)
VALUES
	(1,1),
	(2,2)


---**CONSULTA PARA LISTAR LOS MENUS DEL USUARIO EN BASE A SU ROL
SELECT m.* FROM menu m inner join menu_rol mr ON m.id_menu = mr.id_menu
            		   inner join rol r ON r.id_rol=mr.id_rol
            		   inner join usuario_rol ur ON ur.id_rol = r.id_rol
            		   inner join usuario u ON u.id_usuario = ur.id_usuario
            		   WHERE u.email='admin@admin.com' ORDER BY 
						CASE WHEN m.nombre ='Inicio' THEN 0 ELSE 1 END, -- Filas con condici�n especial primero
							 m.nombre ASC;
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

-------------------------------- ENTIDAD  - tipo vehiculo -----------------------
SELECT * FROM combustible;

INSERT INTO combustible  (tipo) 
VALUES 
	('Di�sel'),
	('Gas'),
	('Electricidad ')
----------------------------------------------------------------------------------
-------------------------------- ENTIDAD  - tipo vehiculo -----------------------
SELECT * FROM tipo_vehiculo
INSERT INTO tipo_vehiculo 
VALUES 
	('M2','< 5 ton','minibus'),
	('M2','< 5 ton','microbus'),
	('M3','> 5 ton','Autobus'),
	('M3','> 5 ton.','Autocares')

----------------------------------------------------------------------------------

------------------------ ENTIDAD  - tipo vehiculo y combustible ------------------
SELECT * FROM tipo_vehiculo
SELECT * FROM combustible;

SELECT * FROM tipo_vehiculo_combustible
INSERT INTO tipo_vehiculo_combustible (id_combustible,id_tipo_vehiculo) 
VALUES 
	(1,3),
	(1,4),
	(1,5),
	(1,6),
	(2,3),
	(2,4)
----------------------------------------------------------------------------------

SELECT * FROM vehiculo
select * from detalle_vehiculo

------------------------------------ SPs ------------------------------------
--alter => para modificar el sp

select*from cliente c where (CHARINDEX('', c.nombres) > 0 AND '' != '')

select*from cliente c where c.nombres like '%dn%'
SELECT * FROM cliente  c where c.ruc is null

select*from detalle_cliente 

SELECT * 
FROM cliente c
LEFT JOIN detalle_cliente dc ON c.id_cliente = dc.id_cliente;

--PROCEDIMIENTO ALMACENADO PARA FILTRAR CLIENTES  DE MANERA PAGINADA 
ALTER PROCEDURE filtro_clientes 
( 
	@pageIndex INT = 0, 
	@PageSize INT = 5,
	@param varchar(255) = '' 
)
AS 
BEGIN
	BEGIN TRY
		DECLARE @TotalElementos INT; -- Variable para almacenar el total de elementos
		DECLARE @FirstPage BIT;
		DECLARE @LastPage BIT;

		-- Realizar la consulta para obtener el total de elementos
		SELECT @TotalElementos = COUNT(*)
		FROM cliente C
		LEFT JOIN detalle_cliente dc ON c.id_cliente = dc.id_cliente 
		LEFT JOIN tipo_cliente tc ON c.id_tipo_cliente = tc.id_tipo_cliente
		LEFT JOIN genero g ON g.id_genero = dc.id_genero
		WHERE 
			(CHARINDEX(@param, c.email) > 0 AND @param != '')  OR 
			(CHARINDEX(@param, c.nombres) > 0 AND @param != '') OR 
			(CHARINDEX(@param, c.ruc) > 0 AND @param != '' ) OR
			(CHARINDEX(@param, dc.dni) > 0 AND @param != '') OR
			(CHARINDEX(@param, dc.apellido_paterno) > 0 AND @param != '') OR 
			(CHARINDEX(@param, dc.apellido_materno) > 0 AND @param != '');

		--EVALUAREMOS SI SON PRIMERAS PAGINAS, PAGENAS CENTRALES O ULTIMAS PAGINAS
		IF (@pageIndex = 0 ) --PRIMERA PAGINA
			BEGIN 
				IF ((@TotalElementos - ((@pageIndex+1)*@PageSize)) > 0)--PRIMERA PAGINA NETA, PERO NO LA ULTIMA, PUES HAY MAS FILAS POR MOSTRARR.
					BEGIN 
						SET @FirstPage = 'TRUE';
						SET @LastPage = 'FALSE';
					END
				ELSE --PRIMERA PAGINA Y ULTIMA, ES DECIR, QUE YA NO HAY DATOS, PERO FUE EL PRIMER Y ULTIMO RESULTADO.
					BEGIN
						SET @FirstPage = 'TRUE';
						SET @LastPage = 'TRUE';
					END
			END
		ELSE IF ( (@TotalElementos - ((@pageIndex+1)*@PageSize)) = 0  ) --ULTIMA PAGINA
			BEGIN
				 SET @FirstPage = 'FALSE';
				 SET @LastPage = 'TRUE';
			END
		ELSE --DATA QUE SE ENCUENTRA EN EL CENTRO DE LAS PAGINAS
			BEGIN
				 SET @FirstPage = 'FALSE';
				 SET @LastPage = 'FALSE';
			END
		

		--cantidad - ((pageIndex+1)*pageSize) > 0 && cantidad - ((pageIndex+1)*pageSize) < pagesize  => ultima pagina

		--CONSULTA DE PAGINACION
		SELECT
		c.id_cliente, c.email, c.nombres, c.ruc, c.telefono, tc.id_tipo_cliente, tc.tipo as tipo_cliente, c.estado,
		dc.id_detalle_cliente, dc.apellido_materno, dc.apellido_paterno, dc.dni, dc.edad, dc.foto,
		g.id_genero, g.tipo,  @TotalElementos AS TotalElementos, @FirstPage AS isFirsPage, @LastPage isLastPage
		FROM cliente C
		LEFT JOIN detalle_cliente dc ON c.id_cliente = dc.id_cliente 
		LEFT JOIN tipo_cliente tc ON c.id_tipo_cliente = tc.id_tipo_cliente
		LEFT JOIN genero g ON g.id_genero = dc.id_genero
		WHERE 
			(CHARINDEX(@param, c.email) > 0 AND @param != '')  OR 
			(CHARINDEX(@param, c.nombres) > 0 AND @param != '') OR 
			(CHARINDEX(@param, c.ruc) > 0 AND @param != '' ) OR
			(CHARINDEX(@param, dc.dni)> 0 AND @param != '') OR
			(CHARINDEX(@param, dc.apellido_paterno) > 0  AND @param != '') OR 
			(CHARINDEX(@param, dc.apellido_materno) > 0 AND @param != '')
		ORDER BY c.id_cliente DESC
		OFFSET @pageIndex*@PageSize ROWS  --omitir las filas en base a eso
		FETCH NEXT @PageSize ROWS ONLY --traer las siguientes

	END TRY
	BEGIN CATCH
		SELECT ERROR_MESSAGE() RESULTADO
	END CATCH
END
--EXECUTE or EXCE
EXEC filtro_clientes 0,1,'@'


--PROCEDIMIENTO ALMACENADO PARA FILTRAR CONDUCTORES DE MANERA PAGINADA 
SELECT*FROM conductor
CREATE PROCEDURE filtro_conductores 
( 
	@pageIndex INT = 0, 
	@PageSize INT = 5,
	@param varchar(255) = '' 
)
AS 
BEGIN
	BEGIN TRY
		DECLARE @TotalElementos INT; -- Variable para almacenar el total de elementos
		DECLARE @FirstPage BIT;
		DECLARE @LastPage BIT;

		-- Realizar la consulta para obtener el total de elementos
		SELECT @TotalElementos = COUNT(*)
		FROM conductor c
		LEFT JOIN genero g ON g.id_genero = c.id_genero
		WHERE 
			(CHARINDEX(@param, c.email) > 0 AND @param != '')  OR 
			(CHARINDEX(@param, c.nombres) > 0 AND @param != '') OR 
			(CHARINDEX(@param, c.dni) > 0 AND @param != '') OR
			(CHARINDEX(@param, c.apellido_paterno) > 0 AND @param != '') OR 
			(CHARINDEX(@param, c.apellido_materno) > 0 AND @param != '');

		--EVALUAREMOS SI SON PRIMERAS PAGINAS, PAGENAS CENTRALES O ULTIMAS PAGINAS
		IF (@pageIndex = 0 ) --PRIMERA PAGINA
			BEGIN 
				IF ((@TotalElementos - ((@pageIndex+1)*@PageSize)) > 0)--PRIMERA PAGINA NETA, PERO NO LA ULTIMA, PUES HAY MAS FILAS POR MOSTRARR.
					BEGIN 
						SET @FirstPage = 'TRUE';
						SET @LastPage = 'FALSE';
					END
				ELSE --PRIMERA PAGINA Y ULTIMA, ES DECIR, QUE YA NO HAY DATOS, PERO FUE EL PRIMER Y ULTIMO RESULTADO.
					BEGIN
						SET @FirstPage = 'TRUE';
						SET @LastPage = 'TRUE';
					END
			END
		ELSE IF ( (@TotalElementos - ((@pageIndex+1)*@PageSize)) = 0  ) --ULTIMA PAGINA
			BEGIN
				 SET @FirstPage = 'FALSE';
				 SET @LastPage = 'TRUE';
			END
		ELSE --DATA QUE SE ENCUENTRA EN EL CENTRO DE LAS PAGINAS
			BEGIN
				 SET @FirstPage = 'FALSE';
				 SET @LastPage = 'FALSE';
			END
		
		--cantidad - ((pageIndex+1)*pageSize) > 0 && cantidad - ((pageIndex+1)*pageSize) < pagesize  => ultima pagina

		--CONSULTA DE PAGINACION
		SELECT
		c.id_conductor, c.email, c.nombres, c.telefono, c.estado,
		c.apellido_materno, c.apellido_paterno, c.dni, c.edad, c.foto,
		g.id_genero, g.tipo,  @TotalElementos AS TotalElementos, @FirstPage AS isFirsPage, @LastPage isLastPage
		FROM conductor c
		LEFT JOIN genero g ON g.id_genero = c.id_genero
		WHERE 
			(CHARINDEX(@param, c.email) > 0 AND @param != '')  OR 
			(CHARINDEX(@param, c.nombres) > 0 AND @param != '') OR 
			(CHARINDEX(@param, c.dni) > 0 AND @param != '') OR
			(CHARINDEX(@param, c.apellido_paterno) > 0 AND @param != '') OR 
			(CHARINDEX(@param, c.apellido_materno) > 0 AND @param != '')
		ORDER BY c.id_conductor DESC
		OFFSET @pageIndex*@PageSize ROWS  --omitir las filas en base a eso
		FETCH NEXT @PageSize ROWS ONLY --traer las siguientes

	END TRY
	BEGIN CATCH
		SELECT ERROR_MESSAGE() RESULTADO
	END CATCH
END
--EXECUTE or EXCE
EXEC filtro_conductores 0,1,'d'
















---UK_1qv1p1ipq2w53pmqimnap9yh9
ALTER TABLE cliente DROP CONSTRAINT UK_1qv1p1ipq2w53pmqimnap9yh9;

-- Agrega una regla de validaci�n para permitir m�ltiples valores NULL
ALTER TABLE cliente
ADD CONSTRAINT UK_1qv1p1ipq2w53pmqimnap9yh9 CHECK (ruc IS NULL OR ruc NOT IN (SELECT ruc FROM cliente WHERE ruc IS NOT NULL))

ALTER TABLE cliente
ALTER COLUMN ruc NVARCHAR(11) NULL;

ALTER TABLE cliente
ADD CONSTRAINT UK_1qv1p1ipq2w53pmqimnap9yh9 UNIQUE (ruc);


select*from cliente
select*from detalle_cliente
	CREATE TRIGGER Tr_InsertCliente
	ON cliente
	INSTEAD OF INSERT
	AS
	BEGIN
		-- Insertar los registros en la tabla
		INSERT INTO cliente
		SELECT ruc FROM inserted WHERE ruc IS NOT NULL;
	END;