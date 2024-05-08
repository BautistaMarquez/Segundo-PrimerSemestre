{
Se dispone de un archivo con información de los alumnos de la Facultad de Informática. Por
cada alumno se dispone de su código de alumno, apellido, nombre, cantidad de materias
(cursadas) aprobadas sin final y cantidad de materias con final aprobado. Además, se tiene
un archivo detalle con el código de alumno e información correspondiente a una materia
(esta información indica si aprobó la cursada o aprobó el final).
Todos los archivos están ordenados por código de alumno y en el archivo detalle puede
haber 0, 1 ó más registros por cada alumno del archivo maestro. Se pide realizar un
programa con opciones para:
a. Crear el archivo maestro a partir de un archivo de texto llamado “alumnos.txt”.
b. Crear el archivo detalle a partir de en un archivo de texto llamado “detalle.txt”.
c. Listar el contenido del archivo maestro en un archivo de texto llamado
“reporteAlumnos.txt”.
d. Listar el contenido del archivo detalle en un archivo de texto llamado
“reporteDetalle.txt”.
e. Actualizar el archivo maestro de la siguiente manera:
i.Si aprobó el final se incrementa en uno la cantidad de materias con final aprobado.
ii.Si aprobó la cursada se incrementa en uno la cantidad de materias aprobadas sin
final.
f. Listar en un archivo de texto los alumnos que tengan más de cuatro materias
con cursada aprobada pero no aprobaron el final. Deben listarse todos los campos.
NOTA: Para la actualización del inciso e- los archivos deben ser recorridos sólo una vez
}
program Punto2;
type
alumno = record 
    code:integer;
    nombre:string;
    cursadas:integer;
    finales:integer;
end;

detalle = record
    code:integer;
    cursadafinal:integer;
end;

archivo = file of alumno;
archivoD = file of detalle;

procedure a(var mae:archivo; var det:text);
var 
a:alumno;
begin
    reset(det); 
    rewrite(mae);
    while(not eof(det))do 
    begin
        readln(det,a.code,a.nombre);
        readln(det,a.cursadas,a.finales);
        write(mae,a);
    end;
    close(det);
    close(mae);
end;

procedure b(var deta:archivoD; var det:text);
var 
d:detalle;
begin
    reset(det); 
    rewrite(deta);
    while(not eof(det))do 
    begin
        readln(det,d.code,d.cursadafinal);
        write(deta,d);
    end;
    close(det);
    close(deta);
end;

procedure c(var mae:archivo; var texto:text);
var 
a:alumno;
begin
    reset(mae);
    rewrite(texto);
    while(not eof(mae))do 
    begin
        read(mae,a);
        writeln(texto,a.code,a.nombre,a.cursadas,a.finales);
    end;
    close(mae);
    close(texto);
end;

procedure d(var deta:archivoD; var texto:text);
var 
d:detalle;
begin
    reset(deta);
    rewrite(texto);
    while(not eof(deta))do 
    begin
        read(deta,d);
        writeln(texto,d.code,d.cursadafinal);
    end;
    close(deta);
    close(texto);
end;

procedure e(var mae:archivo; var deta:archivoD);
var 
d:detalle;
a:alumno;
begin
    reset(deta); 
    reset(mae);
    while(not eof(deta))do 
    begin
        while(not eof(deta))do 
        begin
            read(deta,d);
            read(mae,a);
            while(a.code <> d.code)do 
                read(mae,a);
            seek(mae,filepos(mae)-1); 
            if(d.cursadafinal = 0)then 
                a.cursadas := a.cursadas +1
            else 
                a.finales := a.finales +1;
            write(mae,a);
            seek(mae,filepos(mae)-1); 
        end;
    end;
    close(deta);
    close(mae);
end;

procedure f(var mae:archivo; var texto:text);
var 
a:alumno;
begin
    reset(mae);
    rewrite(texto);
    while(not eof(mae))do 
    begin
        read(mae,a);
        if(a.cursadas>4)then 
            write(texto,a.code,a.nombre,a.cursadas,a.finales);
    end;
    close(mae);
    close(texto);
end;

var
mae:archivo;
det:archivoD;
aa,bb,cc,dd,ff:text;
car:char;
BEGIN
assign(mae,'maestro');
assign(det,'detalle');

assign(aa,'alumnos.txt');
assign(bb,'detalle.txt');
assign(cc,'reporteAlumnos.txt');
assign(dd,'reporteDetalle.txt');
assign(ff,'reporteAprobados.txt');
writeln('Ingrese un valor dependiendo la accion que quiera realizar');
readln(car);
if(car='a')then
    a(mae,aa)
else if(car='b')then 
    b(det,bb)
    else if(car='c')then
        c(mae,cc)
        else if(car='d')then 
            d(det,dd)
            else if(car='e')then
                e(mae,det)
                else if(car='f')then 
                    f(mae,ff);

END.
