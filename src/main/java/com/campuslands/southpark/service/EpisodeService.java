package com.campuslands.southpark.service;

import com.campuslands.southpark.model.Episode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EpisodeService {
    private static final String BASE_URL = "https://spapi.dev/api/episodes/";

    @Autowired
    private RestTemplate restTemplate;

    public Episode getEpisodeById(int id) {
        String url = BASE_URL + id;
        EpisodeResponse response = restTemplate.getForObject(url, EpisodeResponse.class);
        return response != null ? response.getData() : null;
    }

    // Clase interna para manejar la estructura de la respuesta JSON
    public static class EpisodeResponse {
        private Episode data;

        public Episode getData() {
            return data;
        }

        public void setData(Episode data) {
            this.data = data;
        }
    }
}
