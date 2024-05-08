{
Se desea modelar la información necesaria para un sistema de recuentos de casos de covid
para el ministerio de salud de la provincia de buenos aires.
Diariamente se reciben archivos provenientes de los distintos municipios, la información
contenida en los mismos es la siguiente: código de localidad, código cepa, cantidad de
casos activos, cantidad de casos nuevos, cantidad de casos recuperados, cantidad de casos
fallecidos.
El ministerio cuenta con un archivo maestro con la siguiente información: código localidad,
nombre localidad, código cepa, nombre cepa, cantidad de casos activos, cantidad de casos
nuevos, cantidad de recuperados y cantidad de fallecidos.
Se debe realizar el procedimiento que permita actualizar el maestro con los detalles
recibidos, se reciben 10 detalles. Todos los archivos están ordenados por código de
localidad y código de cepa.
Para la actualización se debe proceder de la siguiente manera:
1. Al número de fallecidos se le suman el valor de fallecidos recibido del detalle.
2. Idem anterior para los recuperados.
3. Los casos activos se actualizan con el valor recibido en el detalle.
4. Idem anterior para los casos nuevos hallados.
Realice las declaraciones necesarias, el programa principal y los procedimientos que
requiera para la actualización solicitada e informe cantidad de localidades con más de 50
casos activos (las localidades pueden o no haber sido actualizadas).
}

program Punto7;

type 

valorAlto = "9999";
detalle = record 
    code:integer;
    fecha:string;
    tiempo:integer;
end;

info = record
    code:integer;
    fecha:string;
    tiempoTotal:integer;
end;

archivo = file of info;
archivoD = file of detalle;

procedure minimo(var det1,det2,det3:archivoD; var min,d1,d2,d3:muestra);
begin

    if (d1.code<=d2.code) and (d1.code<=d3.code) then 
    begin
        min := d1;
        leer(det1,d1)
    end
    else if(d2.code<=d3.code) then 
        begin
            min := d2;
            leer(det2,d2)
        end
        else 
            begin
                min := d3;
                leer(det3,d3)
            end;
end;

procedure leerD (var archivo: detalle; var dato:producto);
begin
if (not eof(archivo))
then read (archivo,dato)
else dato.cod := valorAlto;
end;

procedure actualizar (var mae:archivo; var det1,det2,det3:archivoD);
var
i:info;
d1,d2,d3,min:detalle;
begin
    reset(mae); reset(det1); reset(det2); reset(det3);
    leerD(det1,d1); leerD(det2,d2); leerD(det3,d3);
    minimo(det1,det2,det3,min,d1,d2,d3);
    while(min.code <> valorAlto)do 
    begin
        read(mae,i);
        while(i.code <> min.code)do 
            read(mae,i);
        while(i.code = min.code)do 
        begin
            i.tiempoTotal = i.tiempoTotal + min.tiempo;
            minimo(det1,det2,det3,min,d1,d2,d3);
        end;
        seek(mae,filepos(mae)-1);
        write(mae,i);
    end;
    close(mae); close(det1); close(det2); close(det3);
end;




BEGIN

END.