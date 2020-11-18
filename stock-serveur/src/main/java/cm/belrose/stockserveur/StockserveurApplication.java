package cm.belrose.stockserveur;

import cm.belrose.stockserveur.config.initializer.IInitializeStockDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @EnableJpaRepositories(...): allows integrating spring-data-envers project to your Spring Boot project
 */
@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class StockserveurApplication {
	@Autowired
	IInitializeStockDatabase stockInitService;

	public static void main(String[] args) {
		SpringApplication.run(StockserveurApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
		/*stockInitService.initCategorie();
		stockInitService.initVente();
		stockInitService.initArticle();
		stockInitService.initImage();
		stockInitService.initArticleCategorie();
		stockInitService.initArticleVente();*/
		//stockInitService.initRole();
//		stockInitService.initUsers();
//		stockInitService.initUsersRoles();
		/*
		stockInitService.initPersonne();
		stockInitService.initCommandeClient();
		stockInitService.initLivraisonFournisseur();
		stockInitService.initMouvementStock();
		}
		*/








}
