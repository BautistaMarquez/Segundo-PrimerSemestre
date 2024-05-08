{
Se cuenta con un archivo con información de las diferentes distribuciones de linux
existentes. De cada distribución se conoce: nombre, año de lanzamiento, número de
versión del kernel, cantidad de desarrolladores y descripción. El nombre de las
distribuciones no puede repetirse. Este archivo debe ser mantenido realizando bajas
lógicas y utilizando la técnica de reutilización de espacio libre llamada lista invertida.
Escriba la definición de las estructuras de datos necesarias y los siguientes
procedimientos:
a. ExisteDistribucion: módulo que recibe por parámetro un nombre y devuelve
verdadero si la distribución existe en el archivo o falso en caso contrario.
b. AltaDistribución: módulo que lee por teclado los datos de una nueva
distribución y la agrega al archivo reutilizando espacio disponible en caso
de que exista. (El control de unicidad lo debe realizar utilizando el módulo
anterior). En caso de que la distribución que se quiere agregar ya exista se
debe informar “ya existe la distribución”.
c. BajaDistribución: módulo que da de baja lógicamente una distribución 
cuyo nombre se lee por teclado. Para marcar una distribución como
borrada se debe utilizar el campo cantidad de desarrolladores para
mantener actualizada la lista invertida. Para verificar que la distribución a
borrar exista debe utilizar el módulo ExisteDistribucion. En caso de no existir
se debe informar “Distribución no existente”.
}
program Punto8;
type
distri = record 
    nombre:string;
    cant:integer;
end;

archivo = file of distri;

procedure leer(var d:distri);
begin 
    writeln('Ingrese el nombre y la cantidad de desarrolladores de la distribucion');
    readln(d.nombre);
    readln(d.cant);
end;

procedure imprimir(d:distri);
begin 
    writeln(d.nombre);
    writeln(d.cant);
end;

procedure cargar(var a:archivo);
var 
d:distri;
begin
    rewrite(a);
    d.nombre := '@';
    d.cant := 0;
    write(a,d);
    leer(d);
    while(d.cant <> 0)do 
    begin
        write(a,d);
        leer(d);
    end;
    close(a);
end;

procedure ExisteDistribucion(var a:archivo; name:string; var existe:boolean);
var
d:distri;
begin
    existe := false;
    reset(a);
    while((not eof (a))and(existe = false))do 
    begin
        read(a,d);
        if(d.nombre = name)then 
            existe := true;
    end;
    writeln(existe);
    close(a);
end;

procedure AltaDistribucion(var a:archivo);
var 
d,espacio:distri;
indice:integer;
existe:boolean;
begin
    leer(d);
    ExisteDistribucion(a,d.nombre,existe);
    if(existe = false)then 
    begin
        reset(a);
        read(a,espacio);
        if(espacio.cant = 0)then 
        begin
            seek(a,filesize(a));
            write(a,d);
        end
        else
        begin
            indice := espacio.cant;
            seek(a,indice);
            read(a,espacio);
            seek(a,0);
            write(a,espacio);
            seek(a,indice);
            write(a,d);
        end;
        writeln(' Distribucion cargada con exito ');
        close(a);
    end
    else
        writeln(' Ya existe una distribucion con ese nombre ');
end;

procedure BajaDistribucion(var a:archivo);
var
d,espacio:distri;
name:string;
existe:boolean;
begin
    writeln('Ingrese el nombre de la distribucion que quiere dar de baja');
    readln(name);
    ExisteDistribucion(a,name,existe);
    if(existe = true)then 
    begin
        reset(a);
        read(a,d);
        while(d.nombre <> name)do 
            read(a,d);
        d.cant := filepos(a)-1;
        d.nombre := '@'+d.nombre;
        seek(a,0);
        read(a,espacio);
        seek(a,0);
        write(a,d);
        seek(a,d.cant);
        write(a,espacio);
        close(a);
    end
    else 
        writeln('La distribucion ingresada no se encuentra en el archivo');
end;

procedure listar(var a: archivo);
var 
d:distri;
begin 
reset(a);
while(not eof (a))do 
begin
    read(a,d);
    if(d.nombre[1] <> '@')then
        imprimir(d);
end;
writeln(' Archivo impreso ');
close(a);
end;

var
archi:archivo;
c:char;
BEGIN
	assign(archi,'ArchivoDeDistribucionesDeLinux');
    writeln('Ingrese A si quiere crear el archivo, B si quiere dar de alta una distribucion , C si quiere dar de baja una distribucion Y D si lo quiere listar');
    readln(c);
    if(c='A')then 
        cargar(archi);
    if(c='B')then 
        AltaDistribucion(archi);
    if(c='C')then 
        BajaDistribucion(archi);
	if(c='D')then 
        listar(archi);
END.
//Funciona.
