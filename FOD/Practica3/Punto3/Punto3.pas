{
  Realizar un programa que genere un archivo de novelas filmadas durante el presente
año. De cada novela se registra: código, género, nombre, duración, director y precio.
El programa debe presentar un menú con las siguientes opciones:
a. Crear el archivo y cargarlo a partir de datos ingresados por teclado. Se
utiliza la técnica de lista invertida para recuperar espacio libre en el
archivo. Para ello, durante la creación del archivo, en el primer registro del
mismo se debe almacenar la cabecera de la lista. Es decir un registro
ficticio, inicializando con el valor cero (0) el campo correspondiente al
código de novela, el cual indica que no hay espacio libre dentro del
archivo.
b. Abrir el archivo existente y permitir su mantenimiento teniendo en cuenta el
inciso a., se utiliza lista invertida para recuperación de espacio. En
particular, para el campo de ´enlace´ de la lista, se debe especificar los
números de registro referenciados con signo negativo, (utilice el código de
novela como enlace).Una vez abierto el archivo, brindar operaciones para:
i. Dar de alta una novela leyendo la información desde teclado. Para
esta operación, en caso de ser posible, deberá recuperarse el
espacio libre. Es decir, si en el campo correspondiente al código de 
novela del registro cabecera hay un valor negativo, por ejemplo -5, 
se debe leer el registro en la posición 5, copiarlo en la posición 0 
(actualizar la lista de espacio libre) y grabar el nuevo registro en la
posición 5. Con el valor 0 (cero) en el registro cabecera se indica
que no hay espacio libre.
ii. Modificar los datos de una novela leyendo la información desde
teclado. El código de novela no puede ser modificado.
iii. Eliminar una novela cuyo código es ingresado por teclado. Por
ejemplo, si se da de baja un registro en la posición 8, en el campo
código de novela del registro cabecera deberá figurar -8, y en el
registro en la posición 8 debe copiarse el antiguo registro cabecera.
c. Listar en un archivo de texto todas las novelas, incluyendo las borradas, que
representan la lista de espacio libre. El archivo debe llamarse “novelas.txt”.
NOTA: Tanto en la creación como en la apertura el nombre del archivo debe ser
proporcionado por el usuario.
}
program Punto3;
type 
novela = record 
  codigo:integer;
  genero:string;
  nombre:string;
  duracion:string;
  director:string;
  precio:string;
end;

archivo = file of novela;

procedure leer(var n:novela);
begin
  readln(n.codigo);  
  readln(n.genero);
  readln(n.nombre);
  readln(n.duracion);
  readln(n.director);
  readln(n.precio);
end;

procedure creacion(var a:archivo);
var 
nov:novela;
begin 
  rewrite(a);
  leer(nov);
  nov.codigo := 0;
  while(nov.nombre <> 'fin')do 
  begin
    write(a,nov);
    leer(nov);
  end;
  close(a);
end;

procedure b1(var a:archivo);
var 
n,nov:novela;
indice:integer;
begin
  reset(a);
  writeln('Ingrese la novela que quiere dar de alta');
  leer(nov);
  read(a,n);

  if(n.codigo = 0)then 
  begin
    seek(a,filesize(a));
    write(a,nov);
  end
  else 
  begin
    indice := n.codigo * -1;
    seek(a,indice);
    read(a,n);
    seek(a,0);
    write(a,n);
    seek(a,indice);
    write(a,nov);
  end;
  close(a);
end;

//el b2 no me queda muy claro y tiene pinta de ser una boludez.

procedure b3(var a:archivo);
var 
n,nov:novela;
i:integer;
begin
  reset(a);
  writeln('Ingrese el codigo de la novela que quiere eliminar');
  readln(i);
  seek(a,i); // entiendo que el codigo se usa de indice y que una novela tiene el codigo igual a su indice sino seria raro.
  read(a,n);
  n.codigo := n.codigo * -1;
  seek(a,0);
  read(a,nov);
  seek(a,0);
  write(a,n); //escribo el registro de la pos i en 0.
  seek(a,i);
  write(a,nov); //escribo el registro de la pos 0 en i.
  close(a);
end;

var
archi:archivo;
c:char;
i:integer;
BEGIN
	assign(archi,'ArchivoDeNovelas');
  writeln('Ingrese A si quiere crear el archivo de novelas');
	writeln('Ingrese B si quiere abrir el archivo de novelas');
  readln(c);
  if(c = 'A')then 
    creacion(archi);
  if(c = 'B')then 
  begin
    writeln('Ingrese 1 si quiere dar de alta una novela');
	  writeln('Ingrese 3 si quiere dar de baja una novela');
    readln(i);
    if(i = 1)then 
      b1(archi);
    if(i = 3)then 
      b3(archi);
  end;
END.

//No entiendo bien si en el C meto todo en el archivo txt y fue o si tengo que seguir algun tipo de orden.

