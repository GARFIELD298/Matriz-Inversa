# Programa para calcular la inversa de una matriz
Este proyecto lo hice para poder leer una matriz desde un archivo, calcular su inversa y guardar el resultado en otro archivo. Utilizo el método de Gauss-Jordan para hacer todas las operaciones necesarias.

## ¿Qué hace mi programa?
1. Primero lee un archivo llamado `matriz.txt`.
2. El primer número del archivo indica el tamaño de la matriz (por ejemplo, 3 si es 3x3).
3. Luego toma todos los valores de la matriz y los guarda.
4. Revisa si la matriz es cuadrada, porque si no lo es, no se puede sacar la inversa.
5. Si la matriz sí es válida, intenta calcular la inversa.
6. Si la matriz tiene inversa, la guarda en un archivo llamado `inversa.txt`.
7. Si la matriz no se puede invertir porque su determinante es 0, el programa me lo avisa.

## Formato del archivo matriz.txt
El archivo debe verse así:
3  
1 -2 5
3 3 -1
0 4 -2
El número de arriba (3) indica que la matriz es de 3×3.

## Archivo generado
- `inversa.txt` → Aquí se guarda la matriz inversa si existe.

## Cómo lo ejecuto
Primero compilo el programa:
Luego lo ejecuto:

Me aseguro de que el archivo `matriz.txt` esté en la misma carpeta donde está el programa.

## ¿Para qué me sirve este proyecto?
Este programa me ayuda a practicar:
- Lectura y escritura de archivos en Java  
- Manejo de matrices  
- Método Gauss-Jordan para invertir matrices  
- Control de errores cuando una matriz no se puede invertir  
Es un buen ejercicio para mejorar mis habilidades con estructuras de datos y álgebra lineal en programación.