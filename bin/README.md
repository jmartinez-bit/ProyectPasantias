INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

-----------
Registro
http://localhost:2020/api/auth/signup
IniciarSesion
http://localhost:2020/api/auth/signin
{
	"username":"admin",
	"password":"12345678"
}
----------
GET - Contenido Publico
http://localhost:2020/api/test/all

GET - Contenido del Usuario (antes debe iniciar sesion)
http://localhost:2020/api/test/user

GET - Contenido del Moderador 
http://localhost:2020/api/test/mod

GET - Contenido del Admin
http://localhost:2020/api/test/admin
