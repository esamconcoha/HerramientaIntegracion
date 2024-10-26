package com.example.documentos.commons;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

public class CommonController <E, S extends CommonSvc<E>>{

        protected S service;

    @GetMapping
    public ResponseEntity<?> findAll(@RequestHeader(name = "Accept-Languaje", required = false) Locale locale){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id, @RequestHeader(name = "Accept-Languaje", required = false) Locale locale){
        Optional<E> o = service.findById(id);
        if(!o.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(o.get());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody E entity, BindingResult result, @RequestHeader(name = "Accept-Languaje", required = false) Locale locale){
        if(result.hasErrors()){
            return this.validar(result);
        }

        E entityDb = service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable(value = "id") Long id, @RequestHeader(name = "Accept-Languaje", required = false) Locale locale){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    protected ResponseEntity<?> validar(BindingResult result){
        Map<String, Object> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), " El campo " + err.getField() + " " + err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errores);
    }
}
