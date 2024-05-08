{
A partir de información sobre la alfabetización en la Argentina, se necesita actualizar un
archivo que contiene los siguientes datos: nombre de provincia, cantidad de personas
alfabetizadas y total de encuestados. Se reciben dos archivos detalle provenientes de dos
agencias de censo diferentes, dichos archivos contienen: nombre de la provincia, código de
localidad, cantidad de alfabetizados y cantidad de encuestados. Se pide realizar los módulos
necesarios para actualizar el archivo maestro a partir de los dos archivos detalle.
NOTA: Los archivos están ordenados por nombre de provincia y en los archivos detalle
pueden venir 0, 1 ó más registros por cada provincia.
}
program Punto4;
type
valorAlto = 'zzzz';

provincia = record 
    nombre:string;
    alfabe:integer;
    total:integer;
end;

dato = record
    nombre:string;
    code:integer;
    alfabe:integer;
    total:integer;
end;

archivo = file of provincia;

archivoD = file of dato;

procedure leer(var arch:archivoD; var d:dato);
begin 
    if(not eof(arch))then 
        read(arch,d);
    else 
        d.nombre := valorAlto;
end;

procedure minimo(var det1,det2:archivoD; var min,d1,d2:dato);
begin
    if (d1.nombre<=d2.nombre)then 
    begin
        min := d1;
        leer(det1,d1)
    end
    else
        begin
            min := d2;
            leer(det2,d2);
        end;
end;

procedure actualizar(var mae:archivo;var det1,det2:archivoD);
var 
min,d1,d2:dato;
p:provincia;
begin
    reset(mae); reset(det1); reset(det2);
    leer(det1,d1); leer(det2,d2);
    minimo(det1,det2,min,d1,d2);
    while(min.nombre <> "zzzz")do 
    begin
        read(mae,p);
        while(p.nombre <> min.nombre)do 
            read(mae,p);
        while(p.nombre = min.nombre)do 
        begin
            p.alfabe = p.alfabe + min.alfabe;
            p.total = p.total + min.total;
            minimo(det1,det2,min,d1,d2);
        end;
        seek(mae, filepos(mae)-1);
        write(mae,p);
    end;
    close(det1); close(det2);  close(mae);
end;
var

mae:archivo;
det1,det2:archivoD;
BEGIN 
    assign(mae,'maestro');
    assign(det1,'detalle1');
    assign(det2,'detalle2');
    actualizar(mae,det1,det2);
END.