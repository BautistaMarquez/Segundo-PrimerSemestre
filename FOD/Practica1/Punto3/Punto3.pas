{
Realizar un programa que presente un menú con opciones para:
a. Crear un archivo de registros no ordenados de empleados y completarlo con
datos ingresados desde teclado. De cada empleado se registra: número de
empleado, apellido, nombre, edad y DNI. Algunos empleados se ingresan con
DNI 00. La carga finaliza cuando se ingresa el String ‘fin’ como apellido.
b. Abrir el archivo anteriormente generado y
i. Listar en pantalla los datos de empleados que tengan un nombre o apellido
determinado.
ii. Listar en pantalla los empleados de a uno por línea.
iii. Listar en pantalla empleados mayores de 70 años, próximos a jubilarse.
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





var
archi:archivo;
caracter:char;
BEGIN
assign(archi, 'ListaDeEmpleados');
writeln('Ingrese A si quiere crear y cargar un nuevo archivo de empleados');
writeln('Ingrese B si quiere abrir su archivo de empleados');
readln(caracter);
if(caracter = 'A')then
    creacion(archi)
	else if(caracter = 'B')then
	begin
		b1(archi);
		b2(archi);
		b3(archi);
	end;
END.

