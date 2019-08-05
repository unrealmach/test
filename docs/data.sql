 insert into tbl_categorias(codigo,descripcion) values ("CAMISETAS","Camisetas");

 insert into tbl_categorias(codigo,descripcion) values ("VASOS","Vasos");
 insert into tbl_categorias(codigo,descripcion) values ("COMICS","Comics");

 insert into tbl_categorias(codigo,descripcion) values ("JUGUETES","Juguetes");
 insert into tbl_categorias(codigo,descripcion) values ("OTROS_ACCESORIOS","Otro Accesorios");


insert into tbl_marcas(codigo,descripcion) values ("MARVEL","MARVEL");
insert into tbl_marcas(codigo,descripcion) values ("DCCOMICS","DC Comics");
insert into tbl_marcas(codigo,descripcion) values ("Empresa1","Empresa1");


insert into tbl_articulos(codigo,nombre,precio_compra,precio_venta,stock,marca_id,categoria_id)	values ("art1","gorra1", 0,0,10,1,1);

 INSERT INTO tbl_m_venta(fecha,total,codigo_cliente) values ("2019-01-01",10,999999);
 INSERT INTO `testTodo1`.`tbl_d_venta` (`articulo_id`, `m_venta_id`, `cantidad`, `subtotal`) VALUES ('1', '1', '1', '10');

INSERT INTO tbl_m_compra(fecha,total,codigo_cliente) values ("2019-01-01",10,999999);

INSERT INTO `testTodo1`.`tbl_d_compra` (`articulo_id`, `m_compra_id`, `cantidad`, `subtotal`) VALUES (1, 1, 1, 10);
 
 
Insert into tbl_kardex (fecha,movimiento,cantidad,saldo,articulo_id) values ("2019-01-01","ENTRADA",10,10,1);
