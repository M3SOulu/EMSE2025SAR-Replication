package edu.baylor.ecs.qms.controller;

import edu.baylor.ecs.qms.Exception.InstanceCreatingException;
import edu.baylor.ecs.qms.Exception.ResourceNotFoundException;
import edu.baylor.ecs.qms.model.Configuration;
import edu.baylor.ecs.qms.model.ConfigurationGroup;
import edu.baylor.ecs.qms.repository.ConfigurationRepository;
import edu.baylor.ecs.qms.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/configuration")
public class ConfigurationController {
    @Autowired
    private ConfigurationRepository configurationRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @CrossOrigin
    @GetMapping("")
    @RolesAllowed({"moderator","admin","superadmin"})
    public List<Configuration> findAllConfigurations() {
        return configurationRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{configurationId}")
    @RolesAllowed({"moderator","admin","superadmin"})
    public Configuration findConfigurationsById(@PathVariable Long configurationId) {
        return configurationRepository.findById(configurationId).orElse(null);
    }



    @CrossOrigin
    @DeleteMapping("/{configurationId}")
    @RolesAllowed({"admin","superadmin"})
    public ResponseEntity<?> deleteConfiguration(@PathVariable Long configurationId) {
        return configurationRepository.findById(configurationId)
                .map(configuration -> {
                    configurationRepository.delete(configuration);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Configuration not found with id " + configurationId));
    }

    @CrossOrigin
    @PostMapping("")
    @RolesAllowed({"admin","superadmin"})
    public Configuration createConfiguration(@Valid @RequestBody Map<String, Object> payload) {
        try {
            Configuration configuration = new Configuration();
            configuration.setName((String) payload.get("name"));
            configuration.setDescription((String) payload.get("description"));

            ArrayList<Map<String, Object>> groups = (ArrayList<Map<String, Object>>) payload.get("groups");
            for (Map<String, Object> group : groups) {
                createNewGroupFromJSonForConfiguration(configuration, group);
            }

            return configurationRepository.save(configuration);

        } catch (Exception e) {
            e.printStackTrace();
            throw new InstanceCreatingException("Question created failed because of " + e.getMessage());
        }

    }

    private void createNewGroupFromJSonForConfiguration(Configuration configuration, Map<String, Object> group) {
        ConfigurationGroup c = new ConfigurationGroup();
        c.setCategory(Long.parseLong(group.get("category").toString()));
        c.setCount(Integer.parseInt(group.get("count").toString()));
        c.setLanguageId(languageRepository.findByName(group.get("language").toString()).getId());
        c.setLevel(Integer.parseInt(group.get("level").toString()));
        c.setConfiguration(configuration);
        configuration.getGroups().add(c);
    }


}
