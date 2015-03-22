package org.openmrs.module.ngcustomui.utils;


import org.openmrs.api.context.Context;
import org.openmrs.Cohort;
import java.util.List;
import java.util.ArrayList;
import org.openmrs.User;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;


public class MyFavoritePatientsUtil {
 
    private static String cohortName(User u) {
        return "Favorite Patients for User " + u.getUserId();
    }
     
    private static List<Patient> getPatients(Cohort cohort) {
        if (cohort == null)
            return new ArrayList<Patient>();
        else
            return Context.getPatientSetService().getPatients(cohort.getMemberIds());
    }
     
    public static List<Patient> getFavoritePatients(User u) {
        Cohort c = Context.getCohortService().getCohort(cohortName(u));
        return getPatients(c);
    }
     
    public static void addFavoritePatient(User u, Patient p) {
        Cohort c = Context.getCohortService().getCohort(cohortName(u));
        if (c == null) {
            c = new Cohort();
            c.setName(cohortName(u));
            c.setDescription("Automatically generated");
        }
        c.addMember(p.getPatientId());
        Context.getCohortService().saveCohort(c);
    }
     
}