package com.universidad.proyecto.services;

import java.util.List;

import com.universidad.proyecto.dto.EstudianteDTO;

public interface IEstudianteService {
    List<EstudianteDTO> obtenerTodosLosEstudiantes(); // listar los estudiantes

    EstudianteDTO obtenerEstudiantePorId(Long id); // obtener un estudiante por su ID

    void eliminarEstudiante(Long id); // eliminar el estudiante

    EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO); // crear un estudiante

    EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO estudianteDTO); // actualizar al estudiante
}