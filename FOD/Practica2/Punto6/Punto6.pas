{
Suponga que trabaja en una oficina donde está montada una LAN (red local). La misma fue
construida sobre una topología de red que conecta 5 máquinas entre sí y todas las
máquinas se conectan con un servidor central. Semanalmente cada máquina genera un
archivo de logs informando las sesiones abiertas por cada usuario en cada terminal y por
cuánto tiempo estuvo abierta. Cada archivo detalle contiene los siguientes campos:
cod_usuario, fecha, tiempo_sesion. Debe realizar un procedimiento que reciba los archivos
detalle y genere un archivo maestro con los siguientes datos: cod_usuario, fecha,
tiempo_total_de_sesiones_abiertas.
Notas:
● Cada archivo detalle está ordenado por cod_usuario y fecha.
● Un usuario puede iniciar más de una sesión el mismo día en la misma máquina, o
inclusive, en diferentes máquinas.
● El archivo maestro debe crearse en la siguiente ubicación física: /var/log.
}//lo voy a hacer con 3. No se si la fecha se usaria para algo, o solo jode.
//Lo que se me ocurre es que el archivo maestro se tenga que actualizar en varias "pasadas",seria mas ineficiente obviamente pero la eficiencia no nos interesa.


program Punto6;
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




var
mae:archivo;
det1,det2,det3:archivoD;
BEGIN
    assign(mae,'maestro');
    assign(det1,'detalle1');
    assign(det2,'detalle2');
    assign(det3,'detalle3');
    reset(mae); reset(det1); reset(det2); reset(det3);
    actualizar(mae,det1,det2,det3);
END.