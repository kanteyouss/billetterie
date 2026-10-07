package com.billetterie.billetterie.service;

import com.billetterie.billetterie.dto.RequestDto;
import com.billetterie.billetterie.dto.ResponseDto;

import java.util.List;

public interface CrudService {
    List<ResponseDto> getAll();
    ResponseDto getById(Long id);
    ResponseDto create(RequestDto request);
    ResponseDto update(Long id, RequestDto request);
    ResponseDto delete(Long id);
}
