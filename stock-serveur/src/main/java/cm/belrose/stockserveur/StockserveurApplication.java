package cm.belrose.stockserveur;

import cm.belrose.stockserveur.initDB.StockInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockserveurApplication implements CommandLineRunner {
	@Autowired
	StockInitService stockInitService;

	public static void main(String[] args) {
		SpringApplication.run(StockserveurApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*stockInitService.initCategorie();
		stockInitService.initVente();
		stockInitService.initArticle();
		stockInitService.initImage();
		stockInitService.initArticleCategorie();
		stockInitService.initArticleVente();*/
		stockInitService.initRole();
//		stockInitService.initUsers();
//		stockInitService.initUsersRoles();
		/*stockInitService.initPersonne();
		stockInitService.initCommandeClient();
		stockInitService.initLivraisonFournisseur();
		stockInitService.initMouvementStock();*/







	}
}
