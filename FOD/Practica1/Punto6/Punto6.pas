{
Agregar al menú del programa del ejercicio 5, opciones para:

e. Añadir uno o más celulares al final del archivo con sus datos ingresados por
teclado.
f. Modificar el stock de un celular dado.
g. Exportar el contenido del archivo binario a un archivo de texto denominado:
”SinStock.txt”, con aquellos celulares que tengan stock 0.
NOTA: Las búsquedas deben realizarse por nombre de celular.
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

procedure leer (var cel:celular);
begin
    writeln('Ingrese el codigo del celular');
    readln(cel.codigo);
    if(cel.codigo <> 0)then 
    begin
    writeln('Ingrese el precio del celular');
    readln(cel.precio);
    writeln('Ingrese la marca del celular');
    readln(cel.marca);
    writeln('Ingrese el stock disponible del celular');
    readln(cel.stockD);
    writeln('Ingrese el stock minimo del celular');
    readln(cel.stockM);
    writeln('Ingrese el nombre del celular');
    readln(cel.nombre);
    writeln('Ingrese la descripcion del celular');
    readln(cel.descripcion);
    end;
end;

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
        writeln(txt,'codigo: ',celu.codigo,' precio:',celu.precio,' marca: ',celu.marca,' stockMinimo: ',celu.stockM, ' stockDisponible: ',celu.stockD,' nombre: ',celu.nombre, 'descripcion: ',celu.descripcion,'|');
    end;
    close(txt);
    close(list);
end;

procedure e (var list:lista);
var
    celu:celular;
begin
    reset(list);
    leer(celu);
    seek(list,filesize(list));
    while(celu.codigo <> 0)do begin
        write(list,celu);
        leer(celu);
    end;
    close(list);
end;

procedure f (var list:lista);{Habria que ver como solucionar lo de los espacios}
var
    celu:celular;
    nombre:string;
    valor:integer;
begin
	nombre := '';
    reset(list);
    writeln('Ingrese el nombre');
    readln(nombre);
    read(list,celu);
    while(not EOF (list))do begin
		writeln(celu.nombre);
        if(celu.nombre = nombre)then begin
            seek(list,filepos(list)-1);
            writeln('Ingrese el nuevo valor del stockDisponible');
            readln(valor);
            celu.stockD := valor;
            write(list,celu);
        end;
        read(list,celu);
    end;
    close(list);
end;

procedure g (var list:lista;var txt:text);
var
    celu:celular;
begin
    reset(list);
    rewrite(txt);
    while(not EOF (list))do begin
        read(list,celu);
        if(celu.stockD = 0)then
            writeln(txt,'codigo: ',celu.codigo,' precio:',celu.precio,' marca: ',celu.marca,' stockMinimo: ',celu.stockM, ' stockDisponible: ',celu.stockD,' descripcion: ',celu.descripcion,'|');
    end;
    close(txt);
    close(list);
end;

var
txt,txt2,txt3:text;
archi:lista;
caracter:char;
BEGIN
assign(archi,'ListaDeTelefonos');
assign(txt,'celulares.txt');
assign(txt2,'celus.txt');
assign(txt3,'SinStock.txt');
writeln('Ingresar');
readln(caracter);
if(caracter = 'A')then
    a(archi,txt);
if(caracter = 'B')then
    b(archi);
if(caracter = 'D')then
    d(archi,txt2);
if(caracter = 'E')then
    e(archi);
if(caracter = 'F')then
    f(archi);
if(caracter = 'G')then
    g(archi,txt3)
END.

