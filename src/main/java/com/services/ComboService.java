package com.services;
import java.util.List;

public interface ComboService<T> {
    List<T> getAll();
}
