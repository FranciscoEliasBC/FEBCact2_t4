package com.act1_t4.demo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class MvcController {

    @Value("${app.nombre.proyecto}")
    private String nombreProyecto;

    // Lista estática global para que guarde los registros en memoria
    private static List<ProductoDTO> listaProductos = new ArrayList<>();

    // Datos iniciales
    static {
        listaProductos.add(new ProductoDTO(1L, "Laptop HP", 14500.0, "Computo"));
        listaProductos.add(new ProductoDTO(2L, "Teclado Mecánico RGB", 890.0, "Accesorios"));
        listaProductos.add(new ProductoDTO(3L, "Mouse Inalámbrico", 450.0, "Accesorios"));
    }

    // a) Vista de lista
    @GetMapping("/productos")
    public String listarProductos(@RequestParam(required = false) String categoria, Model model) {
        List<ProductoDTO> productosFiltrados = listaProductos;

        if (categoria != null && !categoria.isEmpty()) {
            productosFiltrados = listaProductos.stream()
                    .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                    .toList();
        }

        model.addAttribute("tituloProyecto", nombreProyecto);
        model.addAttribute("productos", productosFiltrados);
        model.addAttribute("categoriaActual", categoria);
        return "productos"; 
    }

    // Detalle por ID
    @GetMapping("/productos/{id}")
    public String detalleProducto(@PathVariable Long id, Model model) {
        ProductoDTO producto = listaProductos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(new ProductoDTO(0L, "No encontrado", 0.0, "N/A"));

        model.addAttribute("producto", producto);
        model.addAttribute("tituloProyecto", nombreProyecto);
        return "detalle"; 
    }

    // Formulario GET
    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("productoForm", new ProductoDTO());
        model.addAttribute("tituloProyecto", nombreProyecto);
        return "formulario"; 
    }

    // Formulario POST: Aquí agregamos el producto a la lista global
    @PostMapping("/form")
    public String procesarFormulario(@ModelAttribute("productoForm") ProductoDTO productoDTO, Model model) {
        long nuevoId = listaProductos.size() + 1;
        productoDTO.setId(nuevoId);
        
        listaProductos.add(productoDTO); // <-- Agrega el nuevo producto a la lista

        model.addAttribute("producto", productoDTO);
        model.addAttribute("tituloProyecto", nombreProyecto);
        return "resultado"; 
    }

    // Endpoint POST REST para Postman
    @PostMapping("/api/productos")
    @ResponseBody
    public ProductoDTO crearProductoRest(@RequestBody ProductoDTO productoDTO) {
        listaProductos.add(productoDTO);
        return productoDTO;
    }
}