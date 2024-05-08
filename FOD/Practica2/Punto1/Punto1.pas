{Una empresa posee un archivo con información de los ingresos percibidos por diferentes
empleados en concepto de comisión, de cada uno de ellos se conoce: código de empleado,
nombre y monto de la comisión. La información del archivo se encuentra ordenada por
código de empleado y cada empleado puede aparecer más de una vez en el archivo de
comisiones.
Realice un procedimiento que reciba el archivo anteriormente descripto y lo compacte. En
consecuencia, deberá generar un nuevo archivo en el cual, cada empleado aparezca una
única vez con el valor total de sus comisiones.
NOTA: No se conoce a priori la cantidad de empleados. Además, el archivo debe ser
recorrido una única vez
}
program Punto1;
type
empleado = record 
    code:integer;
    nombre:string;
    monto:integer;
end;

archivo = file of empleado;

procedure leer (var e:empleado);
begin
    writeln('Ingrese el codigo del empleado');
    readln(e.code);
    writeln('Ingrese el nombre del empleado');
    readln(e.nombre);
    writeln('Ingrese el del empleado');
    readln(e.monto);    
end;

procedure carga (var a:archivo);
var 
    e:empleado;
begin
    leer(e);
    rewrite(a);
    while(e.code <> 0)do 
    begin
        write(a,e);
        leer(e);
    end;
    close(a);
end;

procedure actualizar(var det,mae:archivo);
var 
e,ant:empleado;
begin
    reset(det); 
    rewrite(mae);
    while(not eof(det))do 
    begin
        read(det,e);
        ant := e;
        while(not eof(det)) and (ant.code = e.code)do 
        begin
            ant.monto := ant.monto + e.monto;
            read(det,e);
        end;
        write(mae,ant);
        if(eof(det))then
            seek(mae,filepos(det)-1);   
    end;
    close(det);
    close(mae);
end;

procedure leer(var a:archivo);
var 
e:empleado;
begin
    reset(a);
    while(not eof(a))do    
    begin
        read(a,e);
        writeln('codigo: ',e.code,' monto: ',e.monto);
    end;
    writeln('Fin del archivo');
    close(a);
end;

var
det,mae:archivo;
BEGIN
assign(det,'detalle');
assign(mae,'maestro');
carga(det);
actualizar(det,mae);
leer(det);
leer(mae);
END.
//Funciona con prueda incluida.
