package com.mycompany.detector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DetectorController {
    @Autowired
    private DetectorService service;

    @GetMapping("/detectors")
    public String showDetectorList(Model model) {
        List<Detector> listDetectors = service.listAll();
        model.addAttribute("listDetectors", listDetectors);
        return "detectors";
    }

    @GetMapping("/detectors/new")
    public String showNewForm(Model model) {
        model.addAttribute("detector", new Detector());
        model.addAttribute("pageTitle", "Добавить новый прибор");
                return "detector_form";
    }

    @PostMapping("/detectors/save")
    public String saveDetector(Detector detector, RedirectAttributes ra) {
        service.save(detector);
        ra.addFlashAttribute("message", "Новые данные были успешно внесены в реестр");
        return "redirect:/detectors";
    }

    @GetMapping("/detectors/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Detector detector = service.get(id);
            model.addAttribute("detector", detector);
            model.addAttribute("pageTitle", "Редактирование данных прибора (ID: " + id + ")");
            /*model.addAttribute("toNewTin", "Добавить новый прибор");*/
            return "detector_edit";
        } catch (DetectorNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/detectors";
        }
    }

    @GetMapping("/detectors/delete/{id}")
    public String deleteDetector(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "Прибор с ID: " + id + " был успешно удален из реестра");
        } catch (DetectorNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/detectors";
    }

}


