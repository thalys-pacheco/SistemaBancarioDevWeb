package model;

import java.util.ArrayList;

public interface DAO<T> {
    
    public T get(int id);
    public ArrayList<T> getAll();
    public void inset(T t);
    public void update(T t);
    public void delete(int id);
    
}
