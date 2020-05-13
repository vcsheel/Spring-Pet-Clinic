package com.spring.learn.spring_pet_clinic.map;

import com.spring.learn.spring_pet_clinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T obj) {

        if(obj != null) {
            if(obj.getId() == null)  {
                obj.setId(getNextId());
            }

            map.put(obj.getId(), obj);
        } else {
            throw new RuntimeException("Object can't be null");
        }

        return obj;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        Long nextId = null;
        if(map.isEmpty()) {
            nextId = 1L;
        }else {
            nextId = Collections.max(map.keySet()) + 1;
        }

        return nextId;
    }

}
