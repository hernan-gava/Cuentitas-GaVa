create table inversion_inicial(    
    id_inversion_inicial SERIAL PRIMARY KEY not null,
    nombreProducto String (50) not null,
    total decimal(10,2) not null,
    fecha date not null
    );

create table inversion_proceso(
    id_inversion_proceso SERIAL PRIMARY KEY not null,
    descripcion varchar (60) not null,
    total_inversion decimal(10,2) not null,
    fecha date not null,
);