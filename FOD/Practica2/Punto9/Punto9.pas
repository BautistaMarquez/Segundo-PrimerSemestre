{
Se necesita contabilizar los votos de las diferentes mesas electorales registradas por
provincia y localidad. Para ello, se posee un archivo con la siguiente información: código de
provincia, código de localidad, número de mesa y cantidad de votos en dicha mesa.
Presentar en pantalla un listado como se muestra a continuación:
Código de Provincia
    Código de Localidad              Total de Votos
................................ ......................
................................ ......................
Total de Votos Provincia: ____
Código de Provincia
     Código de Localidad            Total de Votos
................................ ......................
Total de Votos Provincia: ___
…………………………………………………………..
Total General de Votos: ___
NOTA: La información está ordenada por código de provincia y código de localidad.
}

program Punto9;
type
info = record
    codeP:integer;
    codeL:integer;
    numMesa:integer;
    votosMesa:integer;
end;

archivo = file of info;

procedure contabilizar (var a:archivo);
var 
codeP, codeL,votos, totalP,total: integer;
act: info;
begin
total = 0;
reset(a);
read(a,act);
while(not eof a)do 
begin
    totalP = 0;
    codeP := act.codeP;
    writeln(" Provincia: ", codeP);
    while(codeP = act.codeP)do 
    begin
        votos = 0;
        codeL := act.codeL;
        while(codeL = act.codeL)do 
        begin
            votos = votos + a.votosMesa;
            read(a,act);
        end;
        totalP = totalP + votos;
        writeln(" Localidad: ",codeL, " Total de votos ",votos);
    end;
    total = total+totalP;
    writeln("Total de votos Provincia: ",totalP);
end;
writeln("Total general de votos: ",total);
close(a);
end;


var
//despues lo pruebo, paja de cargar un archivo.
BEGIN
	
	
END.

