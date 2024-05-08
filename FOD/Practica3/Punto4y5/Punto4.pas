{
4. Dada la siguiente estructura:
type
reg_flor = record
nombre: String[45];
codigo:integer;
end;
tArchFlores = file of reg_flor;
Las bajas se realizan apilando registros borrados y las altas reutilizando registros
borrados. El registro 0 se usa como cabecera de la pila de registros borrados: el
número 0 en el campo código implica que no hay registros borrados y -N indica que el
próximo registro a reutilizar es el N, siendo éste un número relativo de registro válido.
a. Implemente el siguiente módulo:
---Abre el archivo y agrega una flor, recibida como parámetro
manteniendo la política descrita anteriormente---
procedure agregarFlor (var a: tArchFlores ; nombre: string;
codigo:integer);
b. Liste el contenido del archivo omitiendo las flores eliminadas. Modifique lo que
considere necesario para obtener el listado.
}
program Punto4;
type
flor = record
nombre: String[45];
codigo:integer;
end;

tArchFlores = file of flor;

procedure leer(var f:flor);
begin 
    readln(f.nombre);
    readln(f.codigo);
    writeln('flor cargada');
end;

procedure imprimir(f:flor);
begin 
    writeln(f.nombre);
    writeln(f.codigo);
    writeln('flor impresa');
end;

procedure alta(var a: tArchFlores; f:flor);
var 
flo:flor;
i:integer;
begin
reset(a);
read(a,flo);
if(flo.codigo = 0)then 
begin
    seek(a,filesize(a));
    write(a,f);
end
else 
    begin
    i := flo.codigo * -1;
    writeln('el indice es: ',i);
    seek(a,i);
    read(a,flo);
    seek(a,0);
    write(a,flo);
    seek(a,i);
    read(a,f);
    end;
writeln(' La flor fue dada de alta ');
close(a);
end;

procedure baja(var a:tArchFlores; i:integer); //aca haria la eliminacion logica del arhcivo (Punto5).
var 
flo,f:flor;
begin
reset(a);
read(a,flo);
seek(a,i);
read(a,f);
seek(a,i);
write(a,flo);
seek(a,0);
f.codigo := f.codigo * -1;
writeln(f.codigo,'es el codigo');
write(a,f);
writeln(' La flor fue dada de baja ');
close(a);
end;

procedure agregarFlor (var a: tArchFlores ; f:flor);
begin
	begin 
		alta(a,f);
	end;	
end;

procedure listar(var a: tArchFlores);
var 
f:flor;
begin 
reset(a);
while(not eof (a))do 
begin
    read(a,f);
    if(f.codigo > 0)then 
        imprimir(f)
    else writeln('Filtro: ',f.codigo);
end;
writeln(' Archivo impreso ');
close(a);
end;

var 
archi: tArchFlores;
c:char;
f:flor;
i:integer;
BEGIN
	assign(archi,'ArchivoDeFlores');
    writeln('Ingrese A si quiere agregar una flor');
    writeln('Ingrese B si dar de baja una flor');
    writeln('Ingrese C si listar la lista de flores');
    writeln('Ingrese c para crear el archivo de flores');
    readln(c);
    if(c = 'c')then 
    begin
		rewrite(archi);
		f.nombre := 'vacio';
		f.codigo := 0;
		write(archi,f);
		close(archi);
    end;
    if(c = 'A')then 
    begin
        writeln('Ingrese la flor: ');
        leer(f);
        agregarFlor(archi,f);
    end;   
	if(c = 'B') then 
     begin
        writeln('Ingrese el indice de la flor: ');
        readln(i);
        baja(archi,i);
    end;  
    if(c = 'C')then 
        listar(archi);  
END.
//funciona, es medio raro el tema del indice con el codigo a la hora de dar de baja, pero bueno. Supongo que el codigo siempre tendria que ser igual al indice

