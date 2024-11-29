package repository;

import java.util.List;

public interface Repository <T> {
    List<T> findAll();
    T findById(int id);
    T save(T t);
    T update(T t);
    String delete(int id);
}
