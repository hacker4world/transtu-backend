package com.group.transtubackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TranstuBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TranstuBackendApplication.class, args);
    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }

//    @Bean
//   public CommandLineRunner commandLineRunner(UserRepository userRepository, DepartementRepository departementRepository) {
//       return args -> {
//
//           Departement departement = Departement.builder()
//                    .name("Passage")
//                   .address("passage")                    .build();
//
//            departementRepository.save(departement);
//
//           Utilisateur utilisateur = Utilisateur.builder()
//                  .nom("aziz")
//                   .prenom("arfaoui")
//                    .email("aziz@gmail.com")
//                   .password("12345678")
//                   .role("inspector")
//                   .departement(departement)
//                   .build();
//
//          userRepository.save(utilisateur);
//
//            System.out.println("user created");
//        };
//
//    }
}
