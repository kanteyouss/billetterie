package com.billetterie.billetterie.controller;

import com.billetterie.billetterie.dto.RequestDto;
import com.billetterie.billetterie.dto.ResponseDto;
import com.billetterie.billetterie.service.CrudService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
public abstract class CrudController {
    private final CrudService service;

    protected CrudController(CrudService service) {
        this.service = service;
    }

    @GetMapping
    public List<ResponseDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseDto create( @RequestBody RequestDto request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public ResponseDto update(@PathVariable Long id, @RequestBody RequestDto request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
