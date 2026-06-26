# 🍔 Food Store — Sistema de Gestión de Pedidos

Trabajo Práctico Integrador para la materia **Programación 2** — Tecnicatura Universitaria en Programación · UTN

**Autor:** Joaquin Montero · DNI 40.007.042 · Matrícula 102509

---

## Descripción

Food Store es una aplicación de consola desarrollada en Java que permite gestionar categorías, productos, usuarios y pedidos para una tienda de comida. Implementa los principios de la Programación Orientada a Objetos: herencia, interfaces, polimorfismo, enumeraciones, excepciones personalizadas y borrado lógico.

---

## Requisitos previos

| Herramienta | Versión mínima | Descarga |
|---|---|---|
| Java JDK | 25 | [oracle.com/java](https://www.oracle.com/java/technologies/downloads/) |
| Apache Maven | 3.8+ | [maven.apache.org](https://maven.apache.org/download.cgi) |
| Apache NetBeans *(opcional)* | 21+ | [netbeans.apache.org](https://netbeans.apache.org/) |

> Verificá que Java y Maven estén en el PATH antes de continuar.

```bash
java -version
mvn -version
```

---

## Cómo levantar el proyecto

### Opción A — Línea de comandos (Maven)

```bash
# 1. Clonar el repositorio
git clone https://github.com/JoaquinMontero96/tpi-programacion2.git
cd tpi-programacion2

# 2. Compilar el proyecto
mvn compile

# 3. Ejecutar
mvn exec:java
```

### Opción B — Apache NetBeans

1. Abrí NetBeans.
2. Ir a **File → Open Project** y seleccioná la carpeta `tpi-programacion2`.
3. NetBeans detecta automáticamente el proyecto Maven — esperá a que descargue las dependencias.
4. Clic derecho sobre el proyecto → **Run** (o `F6`).

---

## Estructura del proyecto

```
tpi-programacion2/
├── src/
│   └── main/
│       └── java/
│           └── integrado/prog2/
│               ├── Main.java                  ← Punto de entrada
│               ├── entities/
│               │   ├── Base.java              ← Clase abstracta base
│               │   ├── Calculable.java        ← Interfaz
│               │   ├── Categoria.java
│               │   ├── Producto.java
│               │   ├── Usuario.java
│               │   ├── Pedido.java
│               │   └── DetallePedido.java
│               ├── enums/
│               │   ├── Estado.java            ← PENDIENTE | CONFIRMADO | TERMINADO | CANCELADO
│               │   ├── FormaPago.java         ← TARJETA | TRANSFERENCIA | EFECTIVO
│               │   └── Rol.java               ← ADMIN | USUARIO
│               ├── exception/
│               │   ├── CadenaVaciaException.java
│               │   └── NumeroNegativoException.java
│               ├── service/
│               │   ├── CategoriaService.java
│               │   ├── ProductoService.java
│               │   ├── UsuarioService.java
│               │   └── PedidoService.java
│               └── ui/
│                   ├── MenuPrincipal.java
│                   ├── MenuCategorias.java
│                   ├── MenuProductos.java
│                   ├── MenuUsuarios.java
│                   └── MenuPedidos.java
└── pom.xml
```

---

## Funcionalidades

- **Categorías** — Crear, listar, editar y eliminar categorías de productos.
- **Productos** — Gestión completa con precio, stock, imagen y categoría asociada. Validación de valores negativos.
- **Usuarios** — Alta con generación automática de contraseña segura (SecureRandom). Edición y baja lógica.
- **Pedidos** — Creación con múltiples productos, validación de stock, cálculo automático del total y gestión de estado y forma de pago.

---

## Conceptos OOP aplicados

| Concepto | Dónde se aplica |
|---|---|
| Clase abstracta | `Base` — atributos comunes a todas las entidades |
| Herencia | `Categoria`, `Producto`, `Usuario`, `Pedido`, `DetallePedido` extienden `Base` |
| Interfaz | `Calculable` — implementada por `Pedido` |
| Enumeraciones | `Estado`, `FormaPago`, `Rol` |
| Excepciones personalizadas | `NumeroNegativoException`, `CadenaVaciaException` |
| Borrado lógico | Flag `eliminado` en `Base`, activado por los servicios |
| Colecciones | `ArrayList` como repositorio en memoria en cada servicio |

---

## Links

- **Repositorio:** https://github.com/JoaquinMontero96/tpi-programacion2
- **Video explicativo:** *(pendiente — agregar URL)*
