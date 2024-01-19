-- Insertar Usuarios
 insert into usuarios(username, password, enabled, nombre, apellido_paterno, apellido_materno, fecha_nacimiento, fecha_ingreso, tipo_puesto) values('SUPERVISOR', '$2a$10$CF.IsY/7u/X7gRx6o8Yuv.cj8ylUJzKNTalyCSfX1Gd..z1Zf7jXu', 1, 'Oswaldo Daniel', 'Cruz', 'Cruz', '1999-06-07', '2024-01-16', 'SUPERVISOR');

insert into usuarios(username, password, enabled, nombre, apellido_paterno, apellido_materno, fecha_nacimiento, fecha_ingreso, tipo_puesto) values('CAPTURISTA', '$2a$10$lJIFNWI2NYXFifKcPEliL.Lhu.KjvqOPmMuPLAXHtOtWITQbiFDdC', 1, 'Itzel Damayanti', 'Partida', 'Arroyo', '1995-07-18', '2024-01-16', 'CAPTURISTA');

INSERT INTO roles(nombre) VALUES('ROLE_ADMIN');
INSERT INTO roles(nombre) VALUES('ROLE_USER');

INSERT INTO usuarios_roles(usuario_id, rol_id) VALUES(1,1);
INSERT INTO usuarios_roles(usuario_id, rol_id) VALUES(2,2);