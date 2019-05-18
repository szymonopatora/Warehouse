package pl.warehouse.controller;

import pl.warehouse.service.ToolService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "ToolList", value = "/")
public class WarehouseServlet extends HttpServlet {

    private static final String TOOL_NAME_VAR = "tools";

    private ToolService toolService = new ToolService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        initializeTools();

        req.getRequestDispatcher("/tools.jsp").forward(req, resp);
    }

    private void initializeTools() {
        if (getServletContext().getAttribute(TOOL_NAME_VAR) == null) {
            getServletContext().setAttribute(TOOL_NAME_VAR, toolService.getTools());
        }
    }
}
