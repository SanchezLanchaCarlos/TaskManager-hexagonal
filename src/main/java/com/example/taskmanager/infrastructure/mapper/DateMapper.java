package com.example.taskmanager.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Mapper(componentModel = "spring")
public interface DateMapper {

    @Named("toOffsetDateTime")
    default OffsetDateTime toOffsetDateTime(LocalDateTime dateTime) {
        return dateTime == null ? null : dateTime.atOffset(ZoneOffset.UTC);
    }

    @Named("toLocalDateTime")
    default LocalDateTime toLocalDateTime(final OffsetDateTime offsetDateTime) {
        return offsetDateTime.toLocalDateTime();
    }
}
