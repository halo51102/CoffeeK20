/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import DTO.Food;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface FoodRepository {

    List<Food> findByCategory(int cId);

    Food findByName(String name);

    Food findById(int id);

    List<Food> findAll();

    void create(Food food);

    void update(Food food);

    void delete(Food food);

    List<Food> findByWord(String word);

    int count();

    Food bestSeller();
}
