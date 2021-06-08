# PROYECTO MAGNETO

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men. 
Este proyecto detecta si un humano es mutante basándose en su secuencia de ADN. 

* En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla de (NxN) con la secuencia del ADN.
* Las letras de los Strings solo pueden ser: (A,T,C,G), las cuales representa cada base nitrogenada del ADN. 
 
**NOTA**

**No se harán validaciones de la entrada para no afectar rendimiento**  ya que se asumen como valores validos las letras A,T,C,G y una tabla NXN.

### Instrucciones para ejecutar la API 🚀



### Instrucciones para Instalar y Desplegar en Ambiente Local 🛠️

Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.


### Pre-requisitos 📋

* Software de Control de Versiones GIT
* Entorno de Desarrollo Java (Para la creación se utilizo Spring Tools Suite).
* Version de Java (Se utilizó Java 1.8)
* Maven ( Se utilizó apache-maven-3.6.3)
* Spring 2.5.0

### Instalación 🔧

* Clonar el proyecto desde el siguiente enlace https://github.com/franciscoguerrag/magneto

<div align="center"> <img src="src/main/assets/cloneGitHub.jpg" width="500px"</img> </div>

* Importar el proyecto en el ID utilizando Import-> Existing Maven Projects.

<div align="center"> <img src="src/main/assets/runProjectSpringBootApp.jpg" width="500px"</img> </div>

* Ejecutar los diferentes servicios del Proyecto (puerto configurado 5000, se optó por este puerto por que se realizó despliegue para producción en AWS y este es el puerto por defecto para servicio gratuito)

**Servicios Principales** 

> POST → /mutant/
> 
> * Servicio para analizar mutantes, se debe enviar como parametro un ADN valido. 
> * Ejemplo
> 
>   { “dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}
> 
>   http://localhost:5000/mutant

> GET → /stats
> 
> * Servicio para obtener estatisticas de humanos y mutantes, ademas del porcentaje de mutantes encontrados 
> http://localhost:5000/stats

**Servicios Secundarios** 

> GET → /humans
> 
> * Servicio para obtener todos los humanos analizados, con su ADN y si se encontró como mutante o no.
> http://localhost:5000/humans.
> 
> Ejemplo Respuesta
> > [{"isMutant":true,"dna":["ATGCAA","BAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"],"id":99},{"isMutant":true,"dna":["ATGCAA","BAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"],"id":100},{"isMutant":false,"dna":["TTGCAA","BAGTGC","TTATGT","AGAATG","CCCCTA","TCACTG"],"id":101},{"isMutant":false,"dna":["TTGCAA","BAGTGC","TTATGT","AGAATG","CCCCTA","TCACTG"],"id":102},{"isMutant":false,"dna":["TTGCAA","BAGTGC","TTATGT","AGAATG","CCCCTA","TCACTG"],"id":103},{"isMutant":false,"dna":["TTGCAA","BAGTGC","TTATGT","AGAATG","CCCCTA","TCACTG"],"id":104},{"isMutant":false,"dna":["TTGCAA","BAGTGC","TTATGT","AGAATG","CCCCTA","TCACTG"],"id":105},{"isMutant":false,"dna":["TTGCAA","BAGTGC","TTATGT","AGAATG","CCCCTA","TCACTG"],"id":106}]
> > 


> delete → /deleteHumans
> 
> * Servicio para eliminar los humanos analizados. 
> 
>   http://localhost:5000/deleteHumans


## Ejecutando las pruebas ⚙️

## Despliegue 📦

Como hacer deploy

## Construido con 🛠️

* [Maven](https://maven.apache.org/) - Manejador de dependencias

## Autores ✒️

* **Francisco Guerra** - *Proyecto Magneto* - [franciscoguerrag](https://github.com/franciscoguerrag)

## Expresiones de Gratitud 🎁

* Invita una cerveza 🍺 o un café ☕ a alguien del equipo. 


