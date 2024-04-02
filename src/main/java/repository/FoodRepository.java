/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import entity.Food;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface FoodRepository {
    List<Food> findByCategory(int cId);
    Food findByName(String name);
    Food findById(int id);
}
