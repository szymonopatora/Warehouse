package pl.warehouse.model;

public class Tool {

    private String name;
    private Long id;
    private ToolType toolType;
    private int qty;
    private boolean isAvailable;

    public Tool() {
    }

    public Tool(String name, Long id, ToolType toolType, int qty, boolean isAvailable) {
        this.name = name;
        this.id = id;
        this.toolType = toolType;
        this.qty = qty;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ToolType getToolType() {
        return toolType;
    }

    public void setToolType(ToolType toolType) {
        this.toolType = toolType;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
