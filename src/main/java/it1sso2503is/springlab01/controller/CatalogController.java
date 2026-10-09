

package it1sso2503is.springlab01.controller;

import it1sso2503is.springlab01.service.CatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.aop.support.AopUtils;
import java.util.Map;
import it1sso2503is.springlab01.service.CatalogRemovalService;
import it1sso2503is.springlab01.aspect.CallCounterAspect;

@RestController
public class CatalogController {

    private final CatalogService catalogService;
    private final CatalogRemovalService catalogRemovalService;
    private final CallCounterAspect callCounterAspect;

    public CatalogController(
            CatalogService catalogService,
            CatalogRemovalService catalogRemovalService,
            CallCounterAspect callCounterAspect) {
        this.catalogService = catalogService;
        this.catalogRemovalService = catalogRemovalService;
        this.callCounterAspect = callCounterAspect;
    }

    @GetMapping("/api/lab4/item/{id}")
    public String findById(@PathVariable long id) {
        return catalogService.findById(id);
    }

    @GetMapping("/api/lab4/items")
    public List<String> findAll(
            @RequestParam(defaultValue = "5") int limit) {
        return catalogService.findAll(limit);
    }

    @DeleteMapping("/api/lab4/item/{id}")
    public String remove(@PathVariable long id) {
        return catalogService.remove(id);
    }

    @GetMapping("/api/lab4/proxy")
    public Map<String, String> proxyInfo() {
        return Map.of(
                "className", catalogService.getClass().getName(),
                "superClass", catalogService.getClass()
                        .getSuperclass().getSimpleName(),
                "isAopProxy", String.valueOf(
                        AopUtils.isAopProxy(catalogService)),
                "isCglib", String.valueOf(
                        AopUtils.isCglibProxy(catalogService))
        );
    }

    @GetMapping("/api/lab4/remove-twice/{id}")
    public String removeTwice(@PathVariable long id) {
        return catalogRemovalService.removeTwice(id);
    }

    @GetMapping("/api/lab4/call-counts")
    public Map<String, Integer> callCounts() {
        return callCounterAspect.getStatistics();
    }
}
