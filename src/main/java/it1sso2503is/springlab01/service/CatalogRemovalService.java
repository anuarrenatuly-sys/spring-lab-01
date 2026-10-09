
package it1sso2503is.springlab01.service;

import org.springframework.stereotype.Service;

@Service
public class CatalogRemovalService {

    private final CatalogService catalogService;

    public CatalogRemovalService(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    public String removeTwice(long id) {
        String first = catalogService.remove(id);
        String second = catalogService.remove(id + 1);

        return first + "\n" + second;
    }

}
