{
   Una cadena de tiendas de indumentaria posee un archivo maestro no ordenado con
la información correspondiente a las prendas que se encuentran a la venta. De cada
prenda se registra: cod_prenda, descripción, colores, tipo_prenda, stock y
precio_unitario. Ante un eventual cambio de temporada, se deben actualizar las
prendas a la venta. Para ello reciben un archivo conteniendo: cod_prenda de las
prendas que quedarán obsoletas. Deberá implementar un procedimiento que reciba
ambos archivos y realice la baja lógica de las prendas, para ello deberá modificar el
stock de la prenda correspondiente a valor negativo.
Adicionalmente, deberá implementar otro procedimiento que se encargue de
efectivizar las bajas lógicas que se realizaron sobre el archivo maestro con la
información de las prendas a la venta. Para ello se deberá utilizar una estructura
auxiliar (esto es, un archivo nuevo), en el cual se copien únicamente aquellas prendas
que no están marcadas como borradas. Al finalizar este proceso de compactación
del archivo, se deberá renombrar el archivo nuevo con el nombre del archivo maestro
original.
}
program Punto6;
type 
prenda = record 
   cod:integer;
   descripcion:string;
   colores:integer;
   tipo:string;
   stock:integer;
   precio:integer;
end;

archivo = file of prenda;

contenido = record
   cod:integer;
end;

archivoAux = file of contenido;

procedure bajasLogicas(var a:archivo;var a_aux:archivoAux);
var 
c:contenido;
p:prenda;
begin
   reset(a_aux);
   while(not eof (a_aux))do 
   begin
      read(a_aux,c);
      reset(a);
      read(a,p);
      while(c.cod <> p.cod)do //no controlo el EOF ya que se supone que los codigos tienen que estar en el archivo maestro.
      begin
         read(a,p);
      end;
      p.stock := p.stock * -1;
      seek(a,filesize(a)-1);
      write(a,p);
      writeln(' Archivo actualizado ');
      close(a);
   end;
   close(a_aux);
end;

procedure efectivizar(var a, a2:archivo);
var 
p:prenda;
begin 
rewrite(a2);
reset(a);
while(not eof (a))do 
begin
   read(a,p);
   if(p.stock >= 0)then 
      write(a2,p);
end;
writeln('Bajas logicas efectivizadas');
assign(a,'ArchivoMaestro');
assign(a2,'ArchivoMaestro');
close(a2);
close(a);
end;

var
a,a2:archivo;
a_aux:archivoAux;
BEGIN
reset(a); //Estos archivos ya existen
reset(a_aux); // "
assign(a, 'ArchivoMaestro');
assign(a_aux,'ArchivoBajas');
assign(a2,'ArchivoAuxiliar');
bajasLogicas(a,a_aux);
efectivizar(a,a2);
END.
//Compila, logicamente funcionaria no es muy complejo, NO LO PROBE. 
