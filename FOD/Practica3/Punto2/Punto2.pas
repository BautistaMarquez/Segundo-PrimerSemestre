{
Definir un programa que genere un archivo con registros de longitud fija conteniendo
información de asistentes a un congreso a partir de la información obtenida por
teclado. Se deberá almacenar la siguiente información: nro de asistente, apellido y
nombre, email, teléfono y D.N.I. Implementar un procedimiento que, a partir del
archivo de datos generado, elimine de forma lógica todos los asistentes con nro de
asistente inferior a 1000.
Para ello se podrá utilizar algún carácter especial situándolo delante de algún campo
String a su elección. Ejemplo: ‘@Saldaño’.
}
program Punto2;
type
asistente = record 
	nro:integer;
	nombre:string;
	apellido:string;
end;
archivo = file of asistente;

procedure leer(var a:asistente);
begin
	readln(a.nro);
	readln(a.nombre);
	readln(a.apellido);
	writeln('Asistente completado');
end;

procedure imprimir(var a:asistente);
begin
	writeln(a.nro);
	writeln(a.nombre);
	writeln(a.apellido);
	writeln('Asistente completado');
end;

procedure creacion(var a:archivo);
var 
asi:asistente;
begin
	rewrite(a);
	leer(asi);
	while(asi.nro <> 0)do 
	begin
		write(a,asi);
		leer(asi);
	end;
	writeln('El archivo fue cargado');
	close(a);
end;

procedure mostrar(var a:archivo);
var
asi:asistente;
filtro:char;
begin 
	reset(a);
	while(not EOF (a))do 
	begin
		read(a,asi);
		filtro := asi.nombre[1];
		writeln('el filtro es: ',filtro);
		if(filtro <> '@')then
			imprimir(asi);
	end;
	close(a);
end;

procedure filtro(var a:archivo);
var 
asi:asistente;
c:char;
begin
	c := '@';
	reset(a);
	while(not eof (a))do 
	begin
		read(a,asi);
		if(asi.nro < 1000)then 
			asi.nombre := c+asi.nombre;
		seek(a,filepos(a)-1);
		write(a,asi);
	end;
	close(a);
end;

procedure filtroInverso(var a:archivo);
var 
asi:asistente;
begin
	reset(a);
	while(not eof (a))do 
	begin
		read(a,asi);
		if(asi.nro < 1000)then 
		begin 
			Delete(asi.nombre,1,1); //Elimino el char de la Pos 1 osea el "filtro".
		end;
		seek(a,filepos(a)-1);
		write(a,asi);
	end;
	close(a);
end;

var 
a:archivo;
c:char;
BEGIN
	assign(a,'archivoDeAsistencia');
	readln(c);
	if(c = 'c')then 
		creacion(a);
	if(c = 'f')then
		filtro(a);
	if(c = 'F')then
		filtroInverso(a);	
	mostrar(a);

END.
//Funciona todo.
