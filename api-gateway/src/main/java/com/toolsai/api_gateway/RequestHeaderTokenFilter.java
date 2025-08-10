package com.toolsai.api_gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RequestHeaderTokenFilter extends AbstractGatewayFilterFactory<RequestHeaderTokenFilter.Config> {

    @Autowired
    private RestTemplate restTemplate;

    public RequestHeaderTokenFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String token = exchange.getRequest().getHeaders().getFirst(config.getHeaderName());
            if (token == null || !token.startsWith("Bearer ")) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            String jwt = token.replace("Bearer ", "");
            try {
                String response = restTemplate.postForObject(
                        "http://AUTH-SERVICE/api/auth/validate",
                        null,
                        String.class,
                        exchange.getRequest().getHeaders()
                );
                if (!"Token is valid".equals(response)) {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }
            } catch (Exception e) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            return chain.filter(exchange);
        };
    }




    public static class Config {
        private String headerName;

        public String getHeaderName(){
            return headerName;
        }

        public void setHeaderName(String headerName) {
            this.headerName = headerName;
        }
    }
}
