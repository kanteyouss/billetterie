package com.billetterie.billetterie.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(CategorieRequestDto.class),
        @JsonSubTypes.Type(PlaceRequestDto.class),
        @JsonSubTypes.Type(EvenementRequestDto.class),
        @JsonSubTypes.Type(SalleRequestDto.class),
        @JsonSubTypes.Type(ReservationRequestDto.class)

})
public interface RequestDto { }
