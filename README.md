
# SOFTWARE INSTITCIONAL ACADEMICO

Este proyecto evoluciona de un **CRUD** convencional a un sistema robusto basado en **Programación Orientada a Objetos** Avanzada, optimizando la escalabilidad y el rendimiento mediante el uso de polimorfismo y herencia . La arquitectura ahora se fundamenta en una clase abstracta Persona y una clase RecursosBase, de las cuales heredan los modelos específicos como participantes, registro y recursos, permitiendo la reutilización de lógica común y una estructura de datos más limpia . Además, la implementación de la interfaz Gestionable estandariza el comportamiento de los módulos de proyectos, patrocinio y mantenimiento, garantizando que todos cumplan con un contrato de métodos definido. Al integrar estas técnicas, el software no solo gestiona información en ArrayList, sino que utiliza el polimorfismo para tratar diversos objetos de forma genérica, lo que eleva la **calidad** del código a un nivel profesional y facilita su mantenimiento futuro


## Uso / Ejemplos

```Java
package models;

//Primer interface - creado por juan duarte
public interface Gestionable {

  void cambiarEstado(String nuevoEstado);

  String traerDetalles();
}
```
````Java
package models;

//Segunda clase abstracta - creado por juan duarte
public abstract class RecursoBase implements Gestionable {
 
  @Override
  public void cambiarEstado(String nuevoEstado) {
    this.estado = nuevoEstado;
  }

  @Override
  public String traerDetalles() {
    return "ID: " + id + ", Nombre: " + nombre + ", Categoria: " + categoria + ", Estado: " + estado + ", Ubicacion: "
        + ubicacion;
  }
}
````
<br>

## Sustento
<div Style align = "center">
  
![App Screenshot](https://dummyimage.com/1200x600?text=App+Screenshot+Here)</div>


## Caracteristicas

- **Abstracción y Herencia Estructural:** El sistema utiliza una clase abstracta Persona como base para modelos como patrocinio, permitiendo que objetos específicos hereden atributos y comportamientos comunes, lo que garantiza una estructura de datos estandarizada.
- **Implementación de Polimorfismo:** Se aplican técnicas de polimorfismo donde una lista de tipo Persona puede almacenar y gestionar objetos de sus clases hijas (como patrocinio), permitiendo el tratamiento genérico de datos.
- **Contratos de Comportamiento con Interfases:** Mediante la interfaz Gestionable, se asegura que cada módulo implemente métodos obligatorios para la manipulación de información, promoviendo un código más limpio y profesional.
- Especialización de Métodos: El módulo incluye métodos polimórficos especializados como mostrarinfo() y rol(), los cuales permiten ejecutar comportamientos específicos de la clase hija a pesar de estar referenciados como una clase padre.
- Gestión Dinámica mediante Casting: Para acceder a atributos específicos de las clases derivadas (como getTipo_patrocinador), el sistema realiza un casting de objetos ((patrocinio) nombredelista), demostrando un manejo avanzado de tipos en Java.


 ## Herramientas Utilizadas
 Lenguaje /Despliegue / IDEs - Editor 
 
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
<img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white">
![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)


 **Frontend:** (simulacion de frontend) JOptionPane.

## Autores
  DAVE PAEZ

- [![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/dave-paez)
[![Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:davepaezm@gmail.com)

JUAN DUARTE

- [![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/cuartoa2016juanjose-bit)
[![Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:juanjduarteu@gmail.com)

JOHAN WEST
  
- [![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/wjohan39-jpg)
[![Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:wjohan39@gmail.com)

SAMUEL GONZALE

- [![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/samuelitogonzabusta3233-tech)
[![Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:samuelitogonzabusta3233@gmail.com)

