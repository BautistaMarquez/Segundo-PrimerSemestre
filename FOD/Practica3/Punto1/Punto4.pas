{
Modificar el ejercicio 4 de la práctica 1 (programa de gestión de empleados),
agregándole una opción para realizar bajas copiando el último registro del archivo en
la posición del registro a borrar y luego truncando el archivo en la posición del último
registro de forma tal de evitar duplicados.
}
program Punto3;
type
empleado = record
    num: integer;
    apellido: string;
    nombre: string;
    edad: integer;
    dni: string;
end;

archivo = file of empleado;

procedure leer (var emp: empleado);
begin
writeln('Ingrese el num de empleado');
readln(emp.num);
writeln('Ingrese el apellido del empleado');
readln(emp.apellido);
writeln('Ingrese el nombre del empleado');
readln(emp.nombre);
writeln('Ingrese la edad del empleado');
readln(emp.edad);
writeln('Ingrese el dni del empleado');
readln(emp.dni);
end;

procedure imprimir (emp:empleado);
begin
write(emp.num, '|');
write(emp.apellido, '|');
write(emp.nombre, '|');
write(emp.edad, '|');
write(emp.dni, '|');
writeln('');
end;

procedure creacion (var arch: archivo);
var 
emp: empleado;
begin
rewrite(arch);
leer(emp);
while(emp.apellido <> 'fin') do begin
    write(arch,emp);
    leer(emp);
end;
close(arch);
end;

procedure b1 (var arch: archivo);
var 
emp: empleado;
nomb: string;
cant:integer;
begin
cant := 0;
reset(arch);
writeln('Ingrese el nombre o apellido del empleado/empleados que desea imprimir');
readln(nomb);
while(not EOF(arch))do begin
    read(arch,emp);
    if(emp.nombre = nomb)then begin
		cant := 1;
		imprimir(emp)
	end
    else if (emp.apellido = nomb)then begin
    imprimir(emp);
    cant := 1;
    end;
end;
close(arch);
writeln('Fin de la lista');
if(cant = 0) then 
writeln('No se encontraron empleados de nombre o apellido ', nomb);
end;

procedure b2 (var arch: archivo);
var 
emp:empleado;
begin
reset(arch);
while(not EOF (arch))do begin
    read(arch,emp);
    imprimir(emp);
end;
close(arch);
writeln('Fin de la lista');
end;

procedure b3 (var arch: archivo);
var 
emp:empleado;
cant:integer;
begin
cant := 0;
reset(arch);
while(not EOF (arch))do begin
    read(arch,emp);
    if(emp.edad > 69)then begin
        imprimir(emp);
        cant := 1;
    end;
end;
close(arch);
writeln('Fin de la lista');
if(cant = 0) then 
writeln('No se encontraron empleados mayores de 69 años');
end;

procedure c (var arch:archivo);
var
emp:empleado;
begin
reset(arch);
seek(arch, fileSize(arch));
leer(emp);
while(emp.apellido <> 'fin') do begin
    write(arch,emp);
    leer(emp);
end;
close(arch);
end;

procedure e (var arch:archivo;var arch2:text);
var 
emp:empleado;
begin
reset(arch);
rewrite(arch2);
while(not EOF(arch))do begin
    read(arch,emp);
    writeln(arch2,'nombre: ',emp.nombre,' apellido: ',emp.apellido);
end;
close(arch);
close(arch2);
end;

procedure f(var arch:archivo;var arch2:text);
var 
emp:empleado;
begin
reset(arch);
rewrite(arch2);
while(not EOF(arch))do begin
    read(arch,emp);
    if(emp.dni = '00') then
		writeln(arch2,'nombre: ',emp.nombre,' apellido: ',emp.apellido);
end;
close(arch);
close(arch2);
end;

procedure bajas(var arch:archivo);
var 
emp:empleado;
indice:integer;
begin 
	reset(arch);
	writeln('Ingrese el indice del empleado que quiere eliminar del archivo');
	readln(indice);
	seek(arch, fileSize(arch)-1);
	read(arch,emp);
	seek(arch, indice);
	write(arch,emp);
	seek(arch, fileSize(arch)-1);
	truncate(arch);
	close(arch);
end;


var
archi:archivo;
archi2,archi3:Text;
caracter:char;
BEGIN
assign(archi, 'ListaDeEmpleados');
assign(archi2, 'todos_empleados.txt');
assign(archi3, 'faltaDNIEmpleado.txt');
writeln('Ingrese A si quiere crear y cargar un nuevo archivo de empleados');
writeln('Ingrese B si quiere abrir su archivo de empleados');
writeln('Ingrese C si quiere agregar un empleado a la lista');
writeln('Ingrese E si quiere exportar su lista de empleados a un archivo de texto');
writeln('Ingrese F si quiere exportar su lista de empleados con dni 00 a un archivo de texto');
writeln('Ingrese G si quiere dar de baja a un empleado');
readln(caracter);
case caracter of
	'A':
	begin
		creacion(archi);
    end;
    'B':
    begin
	
		b2(archi);
	
    end;
    'C':
    begin
		c(archi);
    end;
	'E':
	begin
		e(archi,archi2);
	end;
	'F':
	begin
		f(archi,archi3);
	end;
	'G':
	begin
		bajas(archi);
	end;
end;
END.

