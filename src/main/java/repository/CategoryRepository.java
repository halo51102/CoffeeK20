/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import entity.Category;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CategoryRepository{
    List<Category> getAll();
    Category findByName(String name);
}
