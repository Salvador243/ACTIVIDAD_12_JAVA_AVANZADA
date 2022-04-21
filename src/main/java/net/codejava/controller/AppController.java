package net.codejava.controller;

import javax.servlet.http.HttpSession;

import net.codejava.entity.Triangulo;
import net.codejava.services.ProductService;

import net.codejava.services.ImcService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

    @Autowired
    private ProductService service;
    @Autowired
    private ImcService imcService;

    @RequestMapping(value="/resultados", method= {RequestMethod.POST, RequestMethod.TRACE})
    public String resultados(@ModelAttribute("triangulo") Triangulo triangulo,
                             BindingResult result, ModelMap model) {
        if (result.hasErrors()){
            return "/";
        }
        double base = (double) triangulo.getBase();
        double altura = (double) triangulo.getAltura();
        double area = triangulo.area();
        double perimetro = triangulo.perimetro();
        Triangulo tr = new Triangulo();
        tr.setId(0L);
        tr.setAltura(altura);
        tr.setBase(base);
        tr.setArea(area);
        tr.setPerimetro(perimetro);
        service.save2(tr);

        model.addAttribute("ar", area);
        model.addAttribute("pr", perimetro);
        return "resultados";
    }


    @RequestMapping("/")
    public String viewHomePage(HttpSession session, Model model) {
        return "triangulo";
    }

}
