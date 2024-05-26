package com.manuel.bookstore.utils;

import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectMapperUtils {

    private static ModelMapper modelMapper;

    static {
        modelMapper = ServiceFactory.getBean(ModelMapper.class);
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.addConverter(new AbstractConverter<String, Date>() {
            @Override
            protected Date convert(String source) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date localDate = null; //LocalDate.parse(source, format);
                try {
                    localDate = format.parse(source);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return localDate;
            }
        });
    }

    private ObjectMapperUtils() {
    }


    public static <D, T> D map(final T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }


    public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }


    public static <S, D> D map(final S source, D destination) {
        modelMapper.map(source, destination);
        return destination;
    }
}
