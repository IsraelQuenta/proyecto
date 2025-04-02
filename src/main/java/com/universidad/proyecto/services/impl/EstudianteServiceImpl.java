package com.universidad.proyecto.services.impl;

import com.universidad.proyecto.dto.EstudianteDTO; // Importa la clase EstudianteDTO del paquete dto
import com.universidad.proyecto.model.Estudiante; // Importa la clase Estudiante del paquete model
import com.universidad.proyecto.repository.EstudianteRepository; // Importa la clase EstudianteRepository del paquete repository
import com.universidad.proyecto.services.IEstudianteService; // Importa la interfaz IEstudianteService del paquete service

import jakarta.annotation.PostConstruct; // Importa la anotación PostConstruct de Jakarta
//import org.springframework.beans.factory.annotation.Autowired; // Importa la anotación Autowired de Spring
import org.springframework.stereotype.Service; // Importa la anotación Service de Spring

import java.util.ArrayList; // Importa la clase ArrayList para manejar listas
import java.util.List; // Importa la interfaz List para manejar listas

@Service // Anotación que indica que esta clase es un servicio de Spring
public class EstudianteServiceImpl implements IEstudianteService { // Define la clase EstudianteServiceImpl que
                                                                   // implementa la interfaz IEstudianteService

    private final EstudianteRepository estudianteRepository; // Declara una variable final para el repositorio de
                                                             // estudiantes

    // @Autowired // Anotación que indica que el constructor debe ser usado para
    // inyección de
    // dependencias
    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) { // Constructor que recibe el repositorio
                                                                              // de estudiantes
        this.estudianteRepository = estudianteRepository; // Asigna el repositorio de estudiantes a la variable de
                                                          // instancia
    }

    @PostConstruct // Anotación que indica que este método debe ejecutarse después de la
                   // construcción del bean
    public void init() { // Método para inicializar datos de ejemplo
        estudianteRepository.init(); // Llama al método init del repositorio de estudiantes
    }

    // metodos para obtener un estudiante mediante su ID
    @Override
    public EstudianteDTO obtenerEstudiantePorId(Long id) {
        EstudianteDTO estudiantefind = convertToDTO(estudianteRepository.findById(id));
        return estudiantefind;
    }

    // Medoto para eliminar un estudiante
    @Override
    public void eliminarEstudiante(Long id) {
        Estudiante delEstudiante = estudianteRepository.findById(id);// obtener al estudiante por su ID
        estudianteRepository.deleteById(delEstudiante.getId());
    }

    @Override // Anotación que indica que este método sobrescribe un método de la interfaz
    public List<EstudianteDTO> obtenerTodosLosEstudiantes() { // Método para obtener una lista de todos los
                                                              // EstudianteDTO
        List<Estudiante> estudiantes = estudianteRepository.findAll(); // Obtiene todos los estudiantes del repositorio
        List<EstudianteDTO> estudiantesDTO = new ArrayList<>(); // Crea una nueva lista para los EstudianteDTO

        for (Estudiante estudiante : estudiantes) { // Itera sobre la lista de estudiantes
            estudiantesDTO.add(convertToDTO(estudiante)); // Convierte cada estudiante a EstudianteDTO y lo agrega a la
                                                          // lista
        }
        return estudiantesDTO; // Retorna la lista de EstudianteDTO
    }

    // metodo para crear un estudiante
    @Override
    public EstudianteDTO crearEstudiante(EstudianteDTO estudianteDto) {
        Estudiante estudiante = convertToEntity(estudianteDto);
        Estudiante estudianteNuevo = estudianteRepository.crearEstudiante(estudiante);
        return convertToDTO(estudianteNuevo);
    }

    // metodo para actualizar al estudiante
    @Override
    public EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO estudianteDTO) {
        EstudianteDTO oldEstudianteDTO = convertToDTO(estudianteRepository.findById(id));
        Estudiante estudianteActualizado = estudianteRepository.actualizarEstudiante(id, convertToEntity(estudianteDTO),
                convertToEntity(oldEstudianteDTO));
        return convertToDTO(estudianteActualizado);
    }

    // Método auxiliar para convertir entidad a DTO
    private EstudianteDTO convertToDTO(Estudiante estudiante) { // Método para convertir un Estudiante a EstudianteDTO
        return EstudianteDTO.builder() // Usa el patrón builder para crear un EstudianteDTO
                .id(estudiante.getId()) // Asigna el ID
                .nombre(estudiante.getNombre()) // Asigna el nombre
                .apellido(estudiante.getApellido()) // Asigna el apellido
                .email(estudiante.getEmail()) // Asigna el email
                .fechaNacimiento(estudiante.getFechaNacimiento()) // Asigna la fecha de nacimiento
                .numeroInscripcion(estudiante.getNumeroInscripcion()) // Asigna el número de inscripción
                .build(); // Construye el objeto EstudianteDTO
    }

    // Método auxiliar para convertir DTO a entidad
    private Estudiante convertToEntity(EstudianteDTO estudianteDTO) { // Método para convertir un EstudianteDTO a
                                                                      // Estudiante
        return Estudiante.builder() // Usa el patrón builder para crear un Estudiante
                .id(estudianteDTO.getId()) // Asigna el ID
                .nombre(estudianteDTO.getNombre()) // Asigna el nombre
                .apellido(estudianteDTO.getApellido()) // Asigna el apellido
                .email(estudianteDTO.getEmail()) // Asigna el email
                .fechaNacimiento(estudianteDTO.getFechaNacimiento()) // Asigna la fecha de nacimiento
                .numeroInscripcion(estudianteDTO.getNumeroInscripcion()) // Asigna el número de inscripción
                .build(); // Construye el objeto Estudiante
    }
}
