/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import DTO.Category;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CategoryRepository {

    Category findById(int id);

    List<Category> findAll();

    Category findByName(String name);

    List<Category> findByWord(String word);

    void create(Category c);

    void update(Category c);

    void delete(Category c);

    int count();
}
