package pl.warehouse.service;

import pl.warehouse.model.Tool;
import pl.warehouse.model.ToolType;

import java.util.ArrayList;
import java.util.List;

public class ToolService {

    private List<Tool> tools;

    public ToolService() {
        tools = new ArrayList<>();

        tools.add(new Tool("Light hammer",1L, ToolType.HAMMER,10,true));
        tools.add(new Tool("Small scrrewdriver",2L, ToolType.SCREW_DRIVER,10,true));
        tools.add(new Tool("Wood saw",3L, ToolType.SAW,10,true));
        tools.add(new Tool("Large pliers",4L, ToolType.PLIERS,10,true));
        tools.add(new Tool("Electric drill",5L, ToolType.POWER_DRILL,10,true));
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }
}
