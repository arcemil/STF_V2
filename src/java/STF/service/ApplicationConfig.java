/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package STF.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Julian Marin
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(STF.service.CanoeroFacadeREST.class);
        resources.add(STF.service.EmbarcacionFacadeREST.class);
        resources.add(STF.service.HorariosFacadeREST.class);
        resources.add(STF.service.MonitorFacadeREST.class);
        resources.add(STF.service.ProblemasFacadeREST.class);
        resources.add(STF.service.PuertosFacadeREST.class);
        resources.add(STF.service.SensoresFacadeREST.class);
        resources.add(STF.service.TipoEmbarcacionFacadeREST.class);
        resources.add(STF.service.UsuariosFacadeREST.class);
        resources.add(STF.service.ViajeUsuariosFacadeREST.class);
        resources.add(STF.service.ViajesFacadeREST.class);
    }
    
}
