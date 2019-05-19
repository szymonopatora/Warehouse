package pl.warehouse.controller;

import pl.warehouse.model.Tool;
import pl.warehouse.service.ToolService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "ToolList", value = "/")
public class WarehouseServlet extends HttpServlet {

    private static final String TOOL_NAME_VAR = "tools";

    private ToolService toolService = new ToolService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        initializeTools();

        String action = req.getParameter("action");

        if (action != null) {
            processAction(action, Long.valueOf(req.getParameter("id")));
        }

        req.getRequestDispatcher("/tools.jsp").forward(req, resp);
    }

    private void processAction(String action, Long toolId) {

        List<Tool> tools = Collections.emptyList();
        switch (action) {
            case "take":
                toolService.takeTool(toolId);
                break;
            case "return":
                toolService.returnTool(toolId);
                break;
        }
        initializeTools();
    }

    private void initializeTools() {
        getServletContext().setAttribute(TOOL_NAME_VAR, toolService.getTools());
    }
}

