package com.dasa;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dasa.domain.DadoPopulacional;
import com.dasa.repository.DadosPopulacionaisRepository;
import com.dasa.utils.DatasetReader;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {


    @Autowired
    DadosPopulacionaisRepository dadosPopulacionaisRepository;

    @PostConstruct
    public void init() {

        final Path path = Paths.get("src/main/resources/datasets", "dados_populacionais.csv");
        try {
            Reader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));

            DatasetReader datasetReader = new DatasetReader(reader);

            final List<DadoPopulacional> dadoPopulacionals = datasetReader.readDataset();

            dadosPopulacionaisRepository.deleteAll();

            for(DadoPopulacional d : dadoPopulacionals) {
                dadosPopulacionaisRepository.save(d);
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Erro ao popular a Base de Dados", e);
        }


    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
	@Bean
	public Docket swaggerSettings() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().pathMapping("/");
	}


}