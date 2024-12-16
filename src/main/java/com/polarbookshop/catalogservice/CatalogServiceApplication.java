package com.polarbookshop.catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


// run postgres docker locally without volume to avoid persistent storage.
//docker run -d \
//        --name polar-postgres \
//        -e POSTGRES_USER=user \
//        -e POSTGRES_PASSWORD=password \
//        -e POSTGRES_DB=polardb_catalog \
//        -p 5432:5432 \
//        postgres

@SpringBootApplication
@ConfigurationPropertiesScan
public class  CatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogServiceApplication.class, args);
    }

}
