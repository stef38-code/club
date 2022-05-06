package org.stephane.club.services;

import java.util.List;

public interface DefaultService<T> {
    List<T> getAll();
    T one(String id);
}
