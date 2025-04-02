# 🏛️ PROYECTO: APLICACIÓN DE GESTIÓN UNIVERSITARIA

API RESTful para gestión académica con Spring Boot.  
*(Actualizado para Java 23 + Maven)*  

## 🌟 Características
- **Entidades principales**: 
  - `Persona` (clase padre abstracta)
  - `Estudiante` y `Docente` (heredan de `Persona`)
  - `Materia`
- **Operaciones CRUD** en memoria (próximamente PostgreSQL).
- **Patrón DTO** para transferencia de datos.

## 📋 Información Académica
| **Campo**         | **Detalle**                               |
|-------------------|-------------------------------------------|
| **Universidad**   | Universida Mayor de San Andres          |
| **Facultad**      | Facultad de Ciencias Puras y Naturales  |
| **Carrera**       | Informatica                             |
| **Asignatura**    | Desarrollo Web Backend                  |
| **Docente**       | Rosalia Lopez Montalvo                 |
| **Estudiante**    | Israel Andres Quenta Pomacusi           |
| **Matrícula**     | 1845296                                |

## 🛠 Tecnologías
| Tecnología       | Versión   |
|------------------|-----------|
| Java             | 23        |
| Spring Boot      | 3.2.0+    |
| Maven            | 4.0.0     |
| PostgreSQL       | *Próximo* |

## 📡 Endpoints

### Estudiantes
| Método | Ruta                     | Descripción                  |
|--------|--------------------------|------------------------------|
| GET    | `/estudiantes`           | Listar todos                 |
| GET    | `/estudiantes/{id}`      | Buscar por ID                |
| POST   | `/estudiantes`           | Crear nuevo                  |
| PUT    | `/estudiantes/{id}`      | Actualizar                   |
| DELETE | `/estudiantes/{id}`      | Eliminar                     |

### Docentes
| Método | Ruta                   | Descripción                  |
|--------|------------------------|------------------------------|
| GET    | `/docentes`            | Listar todos                 |
| POST   | `/docentes`            | Crear nuevo                  |
| ...    | ...                    | *(Estructura similar)*       |

### Materias
| Método | Ruta                   | Descripción                  |
|--------|------------------------|------------------------------|
| GET    | `/materias`            | Listar todas                 |
| POST   | `/materias`            | Crear nueva                  |

## 🚀 Cómo ejecutar
1. **Clonar repositorio**:
   ```bash
   git clone https://github.com/tu-usuario/gestion-universitaria.git
   
## 📤 Pruebas en Postman
Importa esta colección en Postman para probar los endpoints rápidamente:

1. **Descarga el archivo JSON**:
   - [Colección Postman](./docs/postman_collection.json) *(próximamente)*
   - O copia manualmente los ejemplos abajo.

2. **Ejemplos de requests**:

### Estudiante (POST)
```json
{
    "nombre": "María",
    "apellido": "López",
    "tipo": "ESTUDIANTE",
    "codigoEstudiante": "2024-001",
    "email": "maria@universidad.edu"
}
