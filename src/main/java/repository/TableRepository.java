/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import DTO.Table;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface TableRepository {
    List<Table> getAll();
    Table findByName(String name);
    void update(Table table);
}
