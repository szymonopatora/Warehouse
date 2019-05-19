package pl.warehouse.dao;

import pl.warehouse.model.Tool;

import java.util.List;

public interface ToolDao {
    List<Tool> getAllTools();
    void setAvailability(Long id, boolean isAvailable);
}
