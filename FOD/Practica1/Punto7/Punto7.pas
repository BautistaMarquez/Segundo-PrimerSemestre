{
Realizar un programa que permita:
a- Crear un archivo binario a partir de la información almacenada en un archivo de
texto. El nombre del archivo de texto es: “novelas.txt”. La información en el
archivo de texto consiste en: código de novela, nombre, género y precio de
diferentes novelas argentinas. Los datos de cada novela se almacenan en dos
líneas en el archivo de texto. La primera línea contendrá la siguiente información:
código novela, precio y género, y la segunda línea almacenará el nombre de la
novela.
b- Abrir el archivo binario y permitir la actualización del mismo. Se debe poder
agregar una novela y modificar una existente. Las búsquedas se realizan por
código de novela.
NOTA: El nombre del archivo binario es proporcionado por el usuario desde el teclado.
}
program Punto7;
type
novela = record
    codigo:integer;
    precio:integer;
    genero:string;
    nombre:string;
end;

archivo =  file of novela;

procedure leer (var n:novela);
begin 
writeln('Ingrese el codigo de la novela');
readln(n.codigo);
writeln('Ingrese el precio de la novela');
readln(n.precio);
writeln('Ingrese el genero de la novela');
readln(n.genero);
writeln('Ingrese el nombre de la novela');
readln(n.nombre);
end;

procedure modificar (var n:novela);
begin 
writeln('Ingrese el nuevo codigo de la novela');
readln(n.codigo);
writeln('Ingrese el nuevo precio de la novela');
readln(n.precio);
end;

procedure a (var arch:archivo;var txt:text);
var
int:integer;
str:string;
n:novela;
begin
int := 0;
rewrite(arch);
reset(txt);
read(txt,int);
while(int <> 0)do begin
    n.codigo := int;
    read(txt,int);
    n.precio := int;
    int := 0;
    readln(txt,str);
    n.genero := str;
    readln(txt,str);
    n.nombre := str;
    write(arch,n);
    read(txt,int);
end;
close(arch);
close(txt);
end;

procedure b (var arch:archivo);
var
n:novela;
i,code:integer;
begin
    i:=0;
    reset(arch);
    writeln('Si quiere agregar una novela al archivo aprete 1');
    writeln('Si quiere modificar una novela existente aprete 2');
    readln(i);
    if(i = 1)then begin
        leer(n);
        seek(arch,filesize(arch));
        write(arch,n);
    end
    else if(i = 2)then begin
        writeln('Ingrese el codigo de la novela que quiere modificar');
        readln(code);
        while(not EOF(arch))do begin
            read(arch,n);
            writeln(n.codigo);
            if(n.codigo = code)then begin
                i := 0;
                modificar(n);
                seek(arch,filepos(arch)-1);
                write(arch,n);
            end;
        end;
        if( i = 2)then 
             writeln('No existe ninguna novela en el archivo con ese codigo');
    end;
end;

var
archi:archivo;
txt:text;
c:char;
BEGIN
assign(archi,'ListaDeNovelas');
assign(txt,'novelas.txt');
writeln('Si quiere crear un archivo con la informacion del txt oprima A');
writeln('Si quiere acceder al archivo binario oprima B');
readln(c);
if(c = 'A')then 
    a(archi,txt);
if(c = 'B')then 
    b(archi);
END.

