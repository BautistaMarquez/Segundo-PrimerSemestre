{
 Se cuenta con un archivo que almacena información sobre especies de aves en vía
de extinción, para ello se almacena: código, nombre de la especie, familia de ave,
descripción y zona geográfica. El archivo no está ordenado por ningún criterio. Realice
un programa que elimine especies de aves, para ello se recibe por teclado las
especies a eliminar. Deberá realizar todas las declaraciones necesarias, implementar
todos los procedimientos que requiera y una alternativa para borrar los registros. Para
ello deberá implementar dos procedimientos, uno que marque los registros a borrar y
posteriormente otro procedimiento que compacte el archivo, quitando los registros
marcados. Para quitar los registros se deberá copiar el último registro del archivo en la
posición del registro a borrar y luego eliminar del archivo el último registro de forma tal
de evitar registros duplicados.
Nota: Las bajas deben finalizar al recibir el código 5000
}

program Punto7;
type
especie = record
    cod:integer;
    especie:string;
end;

archivo = file of especie;

procedure leer(var e:especie);
begin
    writeln('Ingrese el codigo y luego la especie');
    readln(e.cod);
    read(e.especie);
end;

procedure imprimir(e:especie);
begin
    writeln(e.cod);
    writeln(e.especie);
end;

procedure crear(var a:archivo);
var 
e:especie;
begin
    rewrite(a);
    leer(e);
    while(e.cod <> 0)do 
    begin
        write(a,e);
        leer(e);
    end;
    close(a);
end;

procedure marcar(var a:archivo);
var 
e:especie;
i:integer;
begin
    reset(a);
    writeln('Ingrese el codigo de la especie que quiere eliminar');
    readln(i);
    while(i <> 5000)do 
    begin
        read(a,e); //podria hacer este read afuera del while y ni bien entro al while hago el while con la condicion del code y del EOF junto, lo dejo pero esta bueno dejar en claro que ya se que la otra forma capaz es mejor o mas eficiente o qsy.
        while(e.cod <> i)do 
            read(a,e);
        e.especie := '@'+e.especie;
        seek(a,filepos(a)-1);
        write(a,e);
        seek(a,0); //nose si lo mejor seria posicionarse en el 0 ya en este momento o usar una condicion especial y hasta no llegar a EOF no "adelantarse" por asi decir, capaz que no es muy relevante.
        writeln('Ingrese el codigo de la especie que quiere eliminar');
        readln(i);
    end;
    close(a);
end;

procedure eliminar(var a:archivo);
var 
i:integer;
e:especie;
filtro:char;
begin
reset(a);
while(not eof (a))do 
begin
    read(a,e);
    filtro := e.especie[1];
    if(filtro = '@')then 
    begin
        i := filepos(a)-1;
        seek(a,filesize(a)-1);
        read(a,e);
        seek(a,i);
        write(a,e);
        seek(a,filesize(a)-1);
        truncate(a);
        seek(a,i); // me posiciono a donde quede en la lectura
    end;
end;
close(a);
end;

procedure listar(var a: archivo);
var 
e:especie;
begin 
reset(a);
while(not eof (a))do 
begin
    read(a,e);
    imprimir(e);
end;
writeln(' Archivo impreso ');
close(a);
end;

var
archi:archivo;
c:char;
BEGIN
	assign(archi,'ArchivoDeEspeciesEnExticion');
    writeln('Ingrese A para crear el archivo, B para eliminar elementos y C para listarlo');
    readln(c);
    if(c='A')then 
        crear(archi);
    if(c='B')then 
    begin
        marcar(archi);
        eliminar(archi);
    end;
    if(c='C')then 
        listar(archi);
END.
//Funciona.
