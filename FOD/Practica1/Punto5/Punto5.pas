{
Realizar un programa para una tienda de celulares, que presente un menú con
opciones para:
a. Crear un archivo de registros no ordenados de celulares y cargarlo con datos
ingresados desde un archivo de texto denominado “celulares.txt”. Los registros
correspondientes a los celulares, deben contener: código de celular, el nombre,
descripcion, marca, precio, stock mínimo y el stock disponible.
b. Listar en pantalla los datos de aquellos celulares que tengan un stock menor al
stock mínimo.
c. Listar en pantalla los celulares del archivo cuya descripción contenga una
cadena de caracteres proporcionada por el usuario.
d. Exportar el archivo creado en el inciso a- a un archivo de texto denominado
“celulares.txt” con todos los celulares del mismo.

NOTA 1: El nombre del archivo binario de celulares debe ser proporcionado por el usuario
una única vez.
NOTA 2: El archivo de carga debe editarse de manera que cada celular se especifique en
tres líneas consecutivas: en la primera se especifica: código de celular, el precio y
marca, en la segunda el stock disponible, stock mínimo y la descripción y en la tercera
nombre en ese orden. Cada celular se carga leyendo tres líneas del archivo
“celulares.txt”.
}
program Punto5;
type
celular = record
    codigo:integer;
    precio:integer;
    marca:string;
    stockD:integer;
    stockM:integer;
    nombre:string;
    descripcion:string;
end;

lista = file of celular;
{
procedure leer (var cel:celular);
begin
    writeln('Ingrese el codigo del celular');
    readln(cel.codigo);
    writeln('Ingrese el precio del celular');
    readln(cel.precio);
    writeln('Ingrese la marca del celular');
    readln(cel.marca);
    writeln('Ingrese el stock disponible del celular');
    readln(cel.stockD);
    writeln('Ingrese el stock minimo del celular');
    readln(cel.stockM);
    writeln('Ingrese la descripcion del celular');
    readln(cel.descripcion);
end;
}
procedure imprimir (cel:celular);
begin
    writeln(cel.codigo);
    writeln(cel.precio);
    writeln(cel.marca);
    writeln(cel.stockD);
    writeln(cel.stockM);
    writeln(cel.nombre);
    writeln(cel.descripcion);
end;


procedure a (var list:lista; var txt:text);
var
num:integer;
data:string;
celu:celular;
begin
    rewrite(list);
    reset(txt);
    read(txt,num);
    while(num <> 0)do begin
        celu.codigo := num;
        read(txt,num);
        celu.precio := num;
        read(txt,data);
        celu.marca := data;
        read(txt,num);
        celu.stockD := num;
        read(txt,num);
        celu.stockM := num;
        num := 0;
        readln(txt,data);
        celu.nombre := data;
        readln(txt,data);
        celu.descripcion := data;
        write(list,celu);
        read(txt,num);
    end;
    close(txt);
    close(list);
end;

procedure b (var list:lista);
var 
celu:celular;
begin
    reset(list);
    while(not EOF (list))do begin
        read(list,celu);
        if(celu.stockM > celu.stockD)then
            imprimir(celu);
    end;
    close(list);
end;

{¿ C ?}

procedure d (var list:lista;var txt:text);
var
    celu:celular;
begin
    reset(list);
    rewrite(txt);
    while(not EOF (list))do begin
        read(list,celu);
        writeln(txt,'codigo: ',celu.codigo,' precio:',celu.precio,' marca: ',celu.marca,' stockMinimo: ',celu.stockM, ' stockDisponible: ',celu.stockD,' descripcion: ',celu.descripcion,'|');
    end;
    close(txt);
    close(list);
end;

var
txt,txt2:text;
archi:lista;
caracter:char;
BEGIN
assign(archi,'ListaDeTelefonos');
assign(txt,'celulares.txt');
assign(txt2,'celus.txt');
writeln('Ingresar');
readln(caracter);
if(caracter = 'A')then
    a(archi,txt);
if(caracter = 'B')then
    b(archi);
if(caracter = 'D')then
    d(archi,txt2);
END.

