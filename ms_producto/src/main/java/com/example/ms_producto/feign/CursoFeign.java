package com.example.ms_producto.feign;

import com.example.ms_producto.dto.CategoriaDto;
import com.example.ms_producto.dto.CursoDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-curso-service", path = "/cursos")
public interface CursoFeign {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "cursoListarPorIdCB", fallbackMethod = "fallbackCursoById")
    public ResponseEntity<CursoDto> buscarCurso(@PathVariable Integer id);

    default ResponseEntity<CursoDto> fallbackCursoById(Integer id, Exception e) {
        CursoDto cursoDto = new CursoDto();
        cursoDto.setNombre("Servicio de curso no disponible KR :C");
        return ResponseEntity.ok(cursoDto);
    }
}
