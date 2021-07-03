package pjatk.jaz.jazs21356nbp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NbpService {

    private RestTemplate restTemplate;

    public NbpService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
}
