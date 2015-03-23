package org.openmrs.module.ngcustomui.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.InitBinder;
import org.openmrs.propertyeditor.PatientEditor;
import org.openmrs.module.ngcustomui.utils.MyFavoritePatientsUtil;
import org.springframework.stereotype.Controller;
import org.openmrs.Patient;
import org.springframework.web.bind.WebDataBinder;
import org.openmrs.api.context.Context;

@Controller
public class MyFavoritePatientsController {

	@InitBinder
    public void initBinder(WebDataBinder wdb){
		wdb.registerCustomEditor(Patient.class, new PatientEditor());
	}
    
    @RequestMapping("/module/ngcustomui/jspexample/addFavoritePatient")
    public String addFavoritePatient(@RequestParam(value="patient_id", required=false) Patient patient) {
       // Patient p = Context.getPatientService().getPatient(patientId);
        if (patient != null)
            MyFavoritePatientsUtil.addFavoritePatient(Context.getAuthenticatedUser(), patient);
        return "redirect:myfavoritepatients.form";
    }

   /** @RequestMapping(value = "/module/ngcustomui/manage", method = RequestMethod.GET)
    public void manage(ModelMap model) {
        model.addAttribute("user", Context.getAuthenticatedUser());
    }*/
}