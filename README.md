# SOFTWARE INSTITUCIONAL ACADÉMICO
 
> Un sistema de gestión académica construido con **Programación Orientada a Objetos Avanzada**, implementando patrones de diseño profesionales mediante **polimorfismo**, **herencia** e **interfaces**.
 
---
 
## Descripción del Proyecto
 
Este software evoluciona de un CRUD básico a una arquitectura empresarial que implementa principios sólidos de POO. Permite la gestión integral de:
 
-  **Participantes** - Registro y seguimiento de usuarios
-  **Proyectos** - Planificación y control de proyectos académicos
-  **Patrocinios** - Administración de patrocinadores y aportes
-  **Recursos** - Inventario y gestión de recursos
-  **Mantenimiento** - Control de mantenimiento de recursos
-  **Registro/Verificación** - Autenticación de usuarios
---
 
##  Arquitectura de POO
 
###  Clase Abstracta Base: **Persona**
 
La piedra angular del sistema. Todas las entidades de usuario heredan de esta clase:
 
```java
public abstract class Persona {
  protected String id;
  protected String nombre;
  protected String correo;

  public Persona(String id, String nombre, String correo) {
    this.id = id;
    this.nombre = nombre;
    this.correo = correo;
  }
  public abstract String rol();

  public abstract void mostrarinfo();
}

```
 
**Clases que heredan de Persona:**
- `Participante` - Usuarios que participan en eventos/proyectos
- `Patrocinio` - Entidades patrocinadoras
- `Registro/Verificacion` - Personal administrativo
- `proyectos` - Tipo de proyecto
---
 
### Clase Abstracta: **RecursoBase** (Implementa Gestionable)
 
Gestiona todo lo relacionado con recursos:
 
```java
public abstract class RecursoBase implements Gestionable {
  protected String id;
  protected String nombre;
  protected String categoria;
  protected String estado;
  protected String ubicacion;
  public RecursoBase(String id, String nombre, String categoria, String estado, String ubicacion) {
    this.id = id;
    this.nombre = nombre;
    this.categoria = categoria;
    this.estado = estado;
    this.ubicacion = ubicacion;
  }
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
```
 
**Clases que heredan de RecursoBase:**
- `Recursos` - Activos del sistema
- `MantenimientoDeRecursos` - Registro de mantenimientos
---
 
###  Interfaz: **Gestionable**
 
Define el contrato que deben cumplir todos los objetos gestionables:
 
```java
public interface Gestionable {
    void cambiarEstado(String nuevoEstado);
    String traerDetalles();
}
```
 
**Implementadores:**
- RecursoBase y sus hijas
- Proyectos (directamente)
- Patrocinio (indirectamente vía Persona)
---
 
##  Polimorfismo en Acción
 
### Ejemplo 1: Almacenamiento Genérico
 
```java
// Usamos un ÚNICO ArrayList de tipo Persona:
ArrayList<Persona> patrocinioList = new ArrayList<>();
// guardar objetos de cualquier clase hija:
patrocinioList.add(new Patrocinio("001", "Empresa XYZ", "xyz@mail.com", "555-1234", "Empresarial", "50000"));
patrocinioList.add(new Patrocinio("002", "Empresa ABC", "abc@mail.com", "555-5678", "Individual", "10000"));
```
 
### Ejemplo 2: Llamadas Polimórficas
 
```java
// Iterar SIN saber qué tipo específico es cada objeto:
for (Persona p : patrocinioList) {
    // Estos métodos se ejecutan según la clase hija real:
    System.out.println(p.rol());
    p.mostrarinfo();
}
```
 
### Ejemplo 3: Casting Dinámico
 
```java
for (Persona p : patrocinioList) {
    if (p.getId().equals(idBuscado)) {
        Patrocinio pat = (Patrocinio) p;  // Cast seguro
        //accedemos a métodos específicos de Patrocinio:
        pat.getTipo_patrocinador();
        pat.getAporte_patrocinador();
    }
}
```
 
---
 
##  Menús Mejorados con Polimorfismo
 
### Menú de Patrocinio
 
```java
ArrayList<Persona> patrocinioList = new ArrayList<>();
 
//Ver todos
for (Persona p : patrocinioList) {
    Patrocinio pat = (Patrocinio) p;
    System.out.println("ID: " + pat.getId() + 
                      " | Nombre: " + pat.getNombre() +
                      " | Tipo: " + pat.getTipo_patrocinador());
}
 
// Crear nuevo
Persona nuevoPatrocinador = new Patrocinio(
    id, nombre, correo, contacto, tipo, aporte
);
patrocinioList.add(nuevoPatrocinador);
 
// Ver información
for (Persona p : patrocinioList) {
    if (p.getId().equals(idBuscado)) {
        p.mostrarinfo();  // 
        break;
    }
}
 
// Ver rol
for (Persona p : patrocinioList) {
    if (p.getId().equals(idBuscado)) {
        JOptionPane.showMessageDialog(null, p.rol()); 
        break;
    }
}
```
 
### Menú de Participantes (Mismo patrón)
 
```java
ArrayList<Persona> participantesList = new ArrayList<>();

// Los mismos 8 casos funcionan con Participante:
Persona nuevoParticipante = new Participante(
    id, nombre, correo, ubicacion, rolEspecifico
);
participantesList.add(nuevoParticipante);
 
// Y toda la lógica de búsqueda, actualización, etc.
```
 
---
 
##  Conceptos Implementados
 
| Concepto | Implementación | Beneficio |
|----------|----------------|-----------|
| **Abstracción** | Clases `Persona` y `RecursoBase` | Define contratos claros |
| **Herencia** | `Patrocinio extends Persona` | Reutilización de código |
| **Polimorfismo** | `ArrayList<Persona>` almacena múltiples tipos | Flexibilidad y escalabilidad |
| **Interfaces** | `Gestionable` implementada por `RecursoBase` | Comportamiento estandarizado |
| **Casting** | `(Patrocinio) persona` | Acceso a métodos específicos |
| **Encapsulación** | `protected` y getters/setters | Control de acceso |
 
---
 
##  Estructura de Clases
 
```
Persona (abstracta)
├── Patrocinio
├── Participante
├── Verificacion
└── Proyectos

 
RecursoBase (abstracta) implements Gestionable
├── Recursos
└── MantenimientoDeRecursos
 
Proyectos (directamente, puede implementar Gestionable)
 
Gestionable (interfaz)
└── RecursoBase (implementador)
```
 
---

## Estructura del proyecto
```
└── App.java
    └── 📁proyecto
        └── 📁.vscode
        ├── settings.json
        └── 📁bin
        └── 📁models
            ├── Gestionable.class
            ├── Ioperaciones.class
            ├── Mantenimientoderecursos.class
            ├── Participantes.class
            ├── Patrocinios.class
            ├── Persona.class
            ├── proyectos.class
            ├── RecursoBase.class
            ├── Recursos.class
            ├── Verificacion.class
            ├── App.class
            └── 📁src
            └── 📁models
            ├── Gestionable.java
            ├── Ioperaciones.java
            ├── Mantenimientoderecursos.java
            ├── Participantes.java
            ├── Patrocinios.java
            ├── Persona.java
            ├── Proyectos.java
            ├── RecursoBase.java
            ├── Recursos.java
            ├── Verificacion.java
         ├── App.java
         └── README.md
```
 
##  Ejemplo Completo de Uso
 
```java
// Inicializar
ArrayList<Persona> sistemaPersonas = new ArrayList<>();
 
// Crear un patrocinador (es tipo Persona en la lista)
Persona patrocinador1 = new Patrocinio(
    "PAT001", 
    "Empresa Tech", 
    "tech@company.com",
    "555-0001",
    "Corporativo",
    "100000"
);
 
// Crear un participante (también Persona)
Persona participante1 = new Participante(
    "PART001",
    "Juan García",
    "juan@email.com",
    "Medellín",
    "Desarrollador"
);
 
// Agregar ambos a la MISMA lista
sistemaPersonas.add(patrocinador1);
sistemaPersonas.add(participante1);
 
// Procesar de forma genérica
for (Persona persona : sistemaPersonas) {
    System.out.println(persona.rol());     // Cada uno retorna su rol
    persona.mostrarinfo();                 // Cada uno muestra su info
}
 
// Cuando necesites algo específico, castea:
Patrocinio pat = (Patrocinio) patrocinador1;
System.out.println(pat.getAporte_patrocinador()); // Acceso específico
```
 
---
 
##  Ventajas de Arquitectura
 
 **Escalabilidad** - Agregar nuevas clases es simple, sin modificar código existente  
 **Mantenibilidad** - Cambios en la lógica común se hacen en un solo lugar  
 **Reutilización** - Métodos comunes heredados por todas las clases  
 **Flexibilidad** - Métodos polimórficos se adaptan a cada tipo  
 **Profesionalismo** - Código limpio y seguible  
 **Testing** - Más fácil de probar interfaces que implementaciones concretas  
 
---
 
 
## 📖 Cómo Usar el Sistema
 
### 1️ Iniciar Sesión / Registro
```
Menu Principal → 1. Iniciar sesión (o 2. Registrarse)
```

<div align="center">
  <img src="https://i.imgur.com/ZfWZFB9.png" width="700">
</div>
 
### 2️ Acceder a Módulos
```
Menu Principal → [1-5] Según el módulo que necesites
```
<div align="center">
  <img src="https://i.imgur.com/B18kwZK.png" width="600">
</div>
 
### 3️ Operaciones CRUD
```
Cada módulo permite:
- Ver todos los registros
- Crear nuevo registro
- Actualizar registro existente
- Eliminar registro
- Operaciones específicas del módulo
```


<div align="center">
  <img src="https://i.imgur.com/LOFkqww.png" width="600">
</div>
 
##  Diagrama de Flujo
 
```
┌─────────────────────────┐
│   MENU PRINCIPAL        │
├─────────────────────────┤
│ 1. Proyectos            │ ← ArrayList<Proyectos>
│ 2. Participantes        │ ← ArrayList<Participante>
│ 3. Recursos             │ ← ArrayList<Recursos>
│ 4. Patrocinio           │ ← ArrayList<Persona>
│ 5. Mantenimiento        │ ← ArrayList<Mantenimiento>
│ 6. Cerrar sesión        │
└─────────────────────────┘
         ↓
    ┌─────────────┐
    │ CRUD OPS    │
    └─────────────┘
         ↓
  ┌──────────────────┐
  │ Polimorfismo     │
  │ en acción        │
  └──────────────────┘
```
 
---
 
## POO Aplicadas

- **Principio DRY** (Don't Repeat Yourself)
- **Principio SOLID** - Single Responsibility
- **Patrón Strategy** (vía interfaces)
- **Patrón Template Method** (vía clases abstractas)
---
 
##  Notas Finales
 
> "El polimorfismo es la capacidad de un objeto para asumir muchas formas. En Java, esto se logra mediante la herencia y las interfaces."
Este proyecto demuestra que el verdadero poder de la POO está en **escribir código una sola vez y usarlo en múltiples contextos**, ahorrando tiempo, reduciendo errores y haciendo el código más profesional.
 
---

##  Herramientas Utilizadas
 
<div align="center">
  
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
![VS Code](https://img.shields.io/badge/VS%20Code-007ACC?style=for-the-badge&logo=visual-studio-code&logoColor=white)
 
**Interface:** JOptionPane (Interfaz gráfica de escritorio)
 
</div>

##  Equipo de Desarrollo
 
| Nombre | GitHub | Email |
|--------|--------|-------|
| **DAVE PAEZ** | [@dave-paez](https://github.com/dave-paez) | davepaezm@gmail.com |
| **JUAN DUARTE** | [@cuartoa2016juanjose-bit](https://github.com/cuartoa2016juanjose-bit) | juanjduarteu@gmail.com |
| **JOHAN WEST** | [@wjohan39-jpg](https://github.com/wjohan39-jpg) | wjohan39@gmail.com |
| **SAMUEL GONZALE** | [@samuelitogonzabusta3233-tech](https://github.com/samuelitogonzabusta3233-tech) | samuelitogonzabusta3233@gmail.com |
 
---
 
<div align="center">
  Gracias por usar nuestro crud de software!
</div>
 
