package br.com.mrdev.algafood.config;

//Created by:
//
//	MMMMMMMM               MMMMMMMMRRRRRRRRRRRRRRRRR           	DDDDDDDDDDDDD      EEEEEEEEEEEEEEEEEEEEEEVVVVVVVV           VVVVVVVV
//	M:::::::M             M:::::::MR::::::::::::::::R          	D::::::::::::DDD   E::::::::::::::::::::EV::::::V           V::::::V
//	M::::::::M           M::::::::MR::::::RRRRRR:::::R         	D:::::::::::::::DD E::::::::::::::::::::EV::::::V           V::::::V
//	M:::::::::M         M:::::::::MRR:::::R     R:::::R        	DDD:::::DDDDD:::::DEE::::::EEEEEEEEE::::EV::::::V           V::::::V
//	M::::::::::M       M::::::::::M  R::::R     R:::::R        	  D:::::D    D:::::D E:::::E       EEEEEE V:::::V           V:::::V 
//	M:::::::::::M     M:::::::::::M  R::::R     R:::::R        	  D:::::D     D:::::DE:::::E               V:::::V         V:::::V  
//	M:::::::M::::M   M::::M:::::::M  R::::RRRRRR:::::R         	  D:::::D     D:::::DE::::::EEEEEEEEEE      V:::::V       V:::::V   
//	M::::::M M::::M M::::M M::::::M  R:::::::::::::RR          	  D:::::D     D:::::DE:::::::::::::::E       V:::::V     V:::::V    
//	M::::::M  M::::M::::M  M::::::M  R::::RRRRRR:::::R         	  D:::::D     D:::::DE:::::::::::::::E        V:::::V   V:::::V     
//	M::::::M   M:::::::M   M::::::M  R::::R     R:::::R        	  D:::::D     D:::::DE::::::EEEEEEEEEE         V:::::V V:::::V      
//	M::::::M    M:::::M    M::::::M  R::::R     R:::::R        	  D:::::D     D:::::DE:::::E                    V:::::V:::::V       
//	M::::::M     MMMMM     M::::::M  R::::R     R:::::R        	  D:::::D    D:::::D E:::::E       EEEEEE        V:::::::::V        
//	M::::::M               M::::::MRR:::::R     R:::::R        	DDD:::::DDDDD:::::DEE::::::EEEEEEEE:::::E         V:::::::V         
//	M::::::M               M::::::MR::::::R     R:::::R ...... 	D:::::::::::::::DD E::::::::::::::::::::E          V:::::V          
//	M::::::M               M::::::MR::::::R     R:::::R .::::. 	D::::::::::::DDD   E::::::::::::::::::::E           V:::V           
//	MMMMMMMM               MMMMMMMMRRRRRRRR     RRRRRRR ...... 	DDDDDDDDDDDDD      EEEEEEEEEEEEEEEEEEEEEE            VVV            

//(*1)import org.springframework.context.annotation.Bean;
//(*1)import br.com.mrdev.algafood.di.notificacao.NotificadorEmail;

//import org.springframework.context.annotation.Configuration;
//	Essa configuração foi comentada para podermos evidenciar a maneira
// 	de configurar os beans usando mais de um arquivo.
//  ao fazer isso teremos que saber como citar no arquivo de configuracao
//  a criacao de um bean q está em outro arquivo de configuracao.
//	(*1)
//@Configuration
@Deprecated
public class AlgaConfig {

	/**
	 * Uma observação importante.
	 * Dentro do IoC Container, por padrão o bean será nomeado como notificadorEmail que é exatamente
	 * o nome desse método que define o bean.
	 */
	//	(*1) @Bean
	//public NotificadorEmail notificadorEmail() {
	//	NotificadorEmail notificadorEmail = new NotificadorEmail("smtp.algamail.com.br");
	//	notificadorEmail.setCaixaAlta(true);
	//	return notificadorEmail;
	//}
	
	/**
	 * Uma outra maneira que poderiamos criar o bean do AtivacaoClienteService.
	 * Porem se optarmos por essa abordagem teremos que tirar o @Component da classe 
	 * AtivacaoClienteService
	 * @Bean
	 * public AtivacaoClienteService ativacaoClienteService() {
	 * 		return new AtivacaoClienteService(notificadorEmail());
	 * }
	 */
	
}
