package org.it.user.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.it.user.entity.Result;
import org.it.user.util.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "UserInfoController")
@RequestMapping("/user-info")
@RestController
public class UserInfoController {

    @Autowired
    private ServiceHelper serviceHelper;

    @GetMapping("/profile/all")
    public Result<Object> profile() {
        return serviceHelper.getProfiles();
    }

}
