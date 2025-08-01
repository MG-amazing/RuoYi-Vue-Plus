package org.dromara.demo.controller;

import lombok.RequiredArgsConstructor;
import org.dromara.common.core.domain.R;
import org.dromara.demo.util.ClassSourceChecker;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/demo/checkLeg")
public class CheckLegController {
    @PostMapping("/nameCheck")
    public R<String> nameCheck(@RequestParam("entityName") String entityName) {
        return R.ok("true",ClassSourceChecker.isProjectClass(entityName));
    }
}
