package org.udg.pds.springtodo.controller;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.udg.pds.springtodo.controller.exceptions.ControllerException;
import org.udg.pds.springtodo.entity.IdObject;
import org.udg.pds.springtodo.service.GroupService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequestMapping(path="/group")
@RestController
public class GroupController extends BaseController {

    @Autowired
    GroupService groupService;

    @PostMapping(consumes = "application/json")
    public IdObject addGroup(HttpSession session, @Valid @RequestBody GroupController.R_Group group) {

        Long userId = getLoggedUser(session);

        if (group.name == null) {
            throw new ControllerException("No name supplied");
        }
        if (group.description == null) {
            throw new ControllerException("No creation date supplied");
        }

        return groupService.addGroup(group.name, userId, group.description);
    }

    static class R_Group {

        @NotNull
        public String name;

        @NotNull
        public String description;

    }
}
