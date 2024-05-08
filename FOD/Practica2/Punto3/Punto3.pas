{
El encargado de ventas de un negocio de productos de limpieza desea administrar el stock
de los productos que vende. Para ello, genera un archivo maestro donde figuran todos los
productos que comercializa. De cada producto se maneja la siguiente información: código de
producto, nombre comercial, precio de venta, stock actual y stock mínimo. Diariamente se
genera un archivo detalle donde se registran todas las ventas de productos realizadas. De
cada venta se registran: código de producto y cantidad de unidades vendidas. Se pide
realizar un programa con opciones para:
a. Actualizar el archivo maestro con el archivo detalle, sabiendo que:
● Ambos archivos están ordenados por código de producto.
● Cada registro del maestro puede ser actualizado por 0, 1 ó más registros del
archivo detalle.
● El archivo detalle sólo contiene registros que están en el archivo maestro.
b. Listar en un archivo de texto llamado “stock_minimo.txt” aquellos productos cuyo
stock actual esté por debajo del stock mínimo permitido
}

Program Punto3;
type

producto = record 
    code:integer;
    nombre:string;
    precio:integer;
    stock:integer;
    stockM:integer;
end;

detalle = record
    code:integer;
    venta:integer;
end;

archivo = file of producto;

archivoD =  file of detalle;

procedure Actualizar(var mae:archivo; var det:archivoD);
var
p:producto;
d:detalle;
begin
    reset(det); reset(mae);
    read(det,d);
    while(not eof(det))do 
    begin
        read(mae,p);
        while(p.code <> d.code)do
            read(mae,p);
        while(p.code = d.code)do 
        begin
            p.stock = p.stock-d.venta;
            read(det,d);
        end;
        seek(mae, filepos(mae)-1);
        write(mae,p);
    end;
    close(mae); close(det);
end;

procedure b(var mae:archivo; mae2:text);
var 
    p:producto
begin
    reset(mae); reset(mae2);
    read(mae,p);
    while(not eof(mae))do 
    begin
        if(p.stock<p.stockM)then 
            writeln(mae2,p.code,p.nombre,p.precio,p.stock,p.stockM);
        read(mae,p);
    end;
    close(mae); close(mae2);
end;

var
mae:archivo;
det:detalle;
stock:text;
BEGIN
    assign(mae,'maestro');
    assign(det,'detalle');
    assign(stock,'stock_minimo.txt');
    Actualizar(mae,det);
    b(mae,stock);
END.