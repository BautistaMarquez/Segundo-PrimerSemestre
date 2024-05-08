{
Se cuenta con un archivo de productos de una cadena de venta de alimentos congelados.
De cada producto se almacena: código del producto, nombre, descripción, stock disponible,
stock mínimo y precio del producto.
Se recibe diariamente un archivo detalle de cada una de las 30 sucursales de la cadena. Se
debe realizar el procedimiento que recibe los 30 detalles y actualiza el stock del archivo
maestro. La información que se recibe en los detalles es: código de producto y cantidad
vendida. Además, se deberá informar en un archivo de texto: nombre de producto,
descripción, stock disponible y precio de aquellos productos que tengan stock disponible por
debajo del stock mínimo.
Nota: todos los archivos se encuentran ordenados por código de productos. En cada detalle
puede venir 0 o N registros de un determinado producto
} // Lo voy a hacer con tres archivos. 
program Punto3;
type
valorAlto = 9999;
producto = record
    code:integer;
    nombre:string;
    desc:string;
    stockD:integer;
    stockM:integer;
    precio:integer;
end;

detalle = record 
    code:integer;
    venta:integer;
end;

muestra = record 
    nombre:string;
    desc:string;
    stockD:integer;
    precio:integer;
end;

archivo = file of producto;
archivoD = file of detalle;

//procedure leer producto

procedure leerD (var archivo: detalle; var dato:producto);
begin
if (not eof(archivo))
then read (archivo,dato)
else dato.cod := valorAlto;
end;

//procedure cargar detalles

procedure minimo(var det1,det2,det3:archivoD; var min,d1,d2,d3:muestra);
begin
    if (d1.code<=d2.code) and (d1.code<=d3.code) then 
    begin
        min := d1;
        leer(det1,d1)
    end
    else if(d2.code<=d3.code) then 
        begin
            min := d2;
            leer(det2,d2)
        end
        else 
            begin
                min := d3;
                leer(det3,d3)
            end;
end;

procedure actualizar(var mae:archivo; var det1,det2,det3:archivoD);
var
min,d1,d2,d3:detalle;
p:producto;
begin 
    reset(det1); reset(det2); reset(det3); reset(mae);
    leerD(det1,d1);
    leerD(det2,d2);
    leerD(det3,d3);
    minimo(min,d1,d2,d3);
    while(min.venta <> valorAlto)do 
    begin
        read(mae,p):
        while(p.code <> min.code)do 
            read(mae,p);
        while(p.code = min.code)do 
        begin
            p.stockD = p.stockD - min.venta;
            minimo(min,d1,d2,d3);
        end;
        seek(mae, filepos(mae)-1);
        write(mae,p);
    end;
    close(det1); close(det2); close(det3); close(mae);
end;

var
mae:archivo;
deta1,deta2,deta3:archivoD;
BEGIN 
    assign(deta1,'detalle1');
    assign(deta2,'detalle2');
    assign(deta3,'detalle3');
    assign(mae,'maestro');
    actualizar(mae,deta1,deta2,deta3);
    //faltaria hacer lo de la muestra y bueno, cargar los archivos detalle si quiero que funque.
END.