package com.dpaula.scmetric.core;

public interface Mapper {
    <D> D map(Object source, Class<D> destinationType);
}
