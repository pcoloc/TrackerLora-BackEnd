package com.trackerlora.backend.service;

import com.trackerlora.backend.dto.LoraData;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@Component("loraDataService") // (1) Anotación de componente.
@CrossOrigin(origins = "https://trackerlora.lopezcarrillo.com") // (2) Anotación de CORS.
public class LoraDataService {

    LoraData loraData = new LoraData();
    public LoraData retrieveLoraData() {
        // (2) Implementación de método de servicio.
        try {
            // (2) Conexión con la página web
            Document webPage = Jsoup.connect("https://www.thethingsnetwork.org/community/santa-rosa/post/que-es-la-tecnologia-lora-y-por-que-es-importante-para-iot")
                    .get();
            Element tbody = webPage.getElementById("article-page");
            Element title = tbody.getElementsByTag("h2").get(0);
            Element author = tbody.getElementsByTag("h5").get(0);
            Element date = tbody.getElementsByClass("date").get(0);
            Element content = tbody.getElementById("article-content");
            Element urlImage = content.getElementsByTag("img").get(0);
            loraData.author = author.text();
            loraData.title = title.text();
            loraData.content = content.text();
            loraData.date = date.text();
            loraData.urlImage = urlImage.attr("src");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return loraData;
    }


}
