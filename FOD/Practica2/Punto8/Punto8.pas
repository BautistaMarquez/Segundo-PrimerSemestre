{
Se cuenta con un archivo que posee información de las ventas que realiza una empresa a
los diferentes clientes. Se necesita obtener un reporte con las ventas organizadas por
cliente. Para ello, se deberá informar por pantalla: los datos personales del cliente, el total
mensual (mes por mes cuánto compró) y finalmente el monto total comprado en el año por el
cliente. Además, al finalizar el reporte, se debe informar el monto total de ventas obtenido
por la empresa.
El formato del archivo maestro está dado por: cliente (cod cliente, nombre y apellido), año,
mes, día y monto de la venta. El orden del archivo está dado por: cod cliente, año y mes.
Nota: tenga en cuenta que puede haber meses en los que los clientes no realizaron
compras. No es necesario que informe tales meses en el reporte.}

program Punto8;
type

cliente = record
    code:integer;
    nombre:string;
    apellido:string;
end;

venta = record
    cliente:cliente;
    año:integer;
    mes:integer;
    dia:integer;
    monto:integer;
end;

maestro = file of venta; //se supone el archivo esta cargado;

procedure reporte (var mae:maestro);
var 
act,ant:venta;
Montomes,Montoaño,mes,año,total:integer;
begin 
total := 0;
reset(mae);
read(mae,act);
while(not eof mae)do 
begin
    ant := act;
    writeln(" Cliente numero: ", act.cliente.code," de nombre:", act.cliente.nombre," y de apellido: ", act.cliente.apellido);
    while(ant.cliente.code = act.cliente.code)do 
    begin
        año = act.año;
        Montoaño = 0;
        while(año = act.año)do 
        begin
            Montomes = 0;
            mes = act.mes;
            while(mes = act.mes)do 
            begin
                Montomes = Montomes + act.mes;
                read(mae,act);
            end;  
            if(mes > 0)then
                writeln(" El mes:",mes," del año: ",año " compro: ",Montomes);
            Montoaño = Montoaño + MontoMes;
            read(mae,act);
        end;
        total = total + Montoaño;
        writeln(" El año: ",año," compro: ",Montoaño);
    end; 
end;
writeln(" El monto total obtenido por las ventas fue de: ",total);
close(mae);
end;


var
//despues lo pruebo.
BEGIN
	
	
END.

