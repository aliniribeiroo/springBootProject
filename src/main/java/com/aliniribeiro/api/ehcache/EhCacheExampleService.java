package com.aliniribeiro.api.ehcache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
@Service
public class EhCacheExampleService {
	
	private static final Logger log = LoggerFactory.getLogger(EhCacheExampleService.class);

	@Cacheable("cacheExample")
	public String cacheExample() {
		log.info("#### Executando serviço......");
		return "Teste exemplo de cache!!";
	}
}
