package br.com.mrdev.algafood;

//	Created by:
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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.mrdev.algafood.di.modelo.Cliente;
import br.com.mrdev.algafood.di.service.AtivacaoClientePorEvent;
import br.com.mrdev.algafood.di.service.AtivacaoClienteServiceDesambiguacaoPorAnotacaoCustomizadaEProfile;
import br.com.mrdev.algafood.di.service.AtivacaoClienteServicePorArrobaComponent;
import br.com.mrdev.algafood.di.service.AtivacaoClienteServicePorArrobaComponentDesambiguacaoViaPrimary;
import br.com.mrdev.algafood.di.service.AtivacaoClienteServicePorArrobaComponentDesambiguacaoViaQualifier;
import br.com.mrdev.algafood.di.service.AtivacaoClienteServicePorArrobaConfiguration;

/**
 * @Controller é uma das maneiras que podemos definir que essa classe é um Bean Spring.
 * Lembrando que @Controller é uma <b>META</b> anotação:
 * 		@Target({ElemntType.TYPE})
 * 		@Retention(RetentionPolicy.RUNTIME)
 * 		@Documented
 * 		@Component
 */
@Controller
public class MeuPrimeiroController {

	private AtivacaoClienteServicePorArrobaComponent 
		ativacaoClienteServicePorArrobaComponent;
	private AtivacaoClienteServicePorArrobaConfiguration
		ativacaoClienteServicePorArrobaConfiguration;

	private AtivacaoClienteServicePorArrobaComponentDesambiguacaoViaPrimary 
		ativacaoClienteServicePorArrobaComponentDesambiguacaoViaPrimary;	
	
	private AtivacaoClienteServicePorArrobaComponentDesambiguacaoViaQualifier
		ativacaoClienteServicePorArrobaComponentDesambiguacaoViaQualifier;
	
	private AtivacaoClienteServiceDesambiguacaoPorAnotacaoCustomizadaEProfile
		ativacaoClienteServiceDesambiguacaoPorAnotacaoCustomizada;
	
	private AtivacaoClientePorEvent ativacaoClientePorEvent;
	
	/**
	 * Como AtivacaoClienteService é um component Spring (@Component)
	 * e MeuPrimeiroController tambem é um component Spring (@Component)
	 * o simples fato de criar o construtor recebendo o AtivacaoClienteService
	 * vai fazer com que o 'this.ativacaoClienteService' não seja mais nulo. 1/X
	 */
	public MeuPrimeiroController
		(AtivacaoClienteServicePorArrobaComponent ativacaoClienteServicePorArrobaComponent
				,AtivacaoClienteServicePorArrobaConfiguration ativacaoClienteServicePorArrobaConfiguration
				,AtivacaoClienteServicePorArrobaComponentDesambiguacaoViaPrimary ativacaoClienteServicePorArrobaComponentDesambiguacaoViaPrimary
				,AtivacaoClienteServicePorArrobaComponentDesambiguacaoViaQualifier ativacaoClienteServicePorArrobaComponentDesambiguacaoViaQualifier
				,AtivacaoClienteServiceDesambiguacaoPorAnotacaoCustomizadaEProfile ativacaoClienteServiceDesambiguacaoPorAnotacaoCustomizada
				,AtivacaoClientePorEvent ativacaoClientePorEvent
				) {
		
		this.ativacaoClienteServicePorArrobaComponent = ativacaoClienteServicePorArrobaComponent;
		this.ativacaoClienteServicePorArrobaConfiguration = ativacaoClienteServicePorArrobaConfiguration;
		
		this.ativacaoClienteServicePorArrobaComponentDesambiguacaoViaPrimary = ativacaoClienteServicePorArrobaComponentDesambiguacaoViaPrimary;
		
		this.ativacaoClienteServicePorArrobaComponentDesambiguacaoViaQualifier = ativacaoClienteServicePorArrobaComponentDesambiguacaoViaQualifier;
		
		this.ativacaoClienteServiceDesambiguacaoPorAnotacaoCustomizada = ativacaoClienteServiceDesambiguacaoPorAnotacaoCustomizada;
		
		this.ativacaoClientePorEvent = ativacaoClientePorEvent; 
		
		System.out.println( "MeuPrimeiroController:"
				+ "\n [@Component] " 							+ this.ativacaoClienteServicePorArrobaComponent 
				+ "\n [@Configuration] " 						+ this.ativacaoClienteServicePorArrobaConfiguration 
				+ "\n [@Component] [Via Primary] " 				+ this.ativacaoClienteServicePorArrobaComponentDesambiguacaoViaPrimary
				+ "\n [@Component] [Via Qualifier] " 			+ this.ativacaoClienteServicePorArrobaComponentDesambiguacaoViaQualifier
				+ "\n [@Component] [Via Anotação Customizada] " + this.ativacaoClienteServiceDesambiguacaoPorAnotacaoCustomizada
				+ "\n [@Component] [Via Listener] " 			+ this.ativacaoClientePorEvent
				);
	}
	
	//Essas configurações já permitem chamar http://localhost:8080/hello
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		
		Cliente joao = new Cliente("João", "joao@xyz.com", "349999999");
		Cliente maria = new Cliente("Maria", "maria@xyz.com", "71986874997");
		
		this.ativacaoClienteServicePorArrobaComponent.ativar(joao);
		this.ativacaoClienteServicePorArrobaComponent.ativar(maria);
		
		this.ativacaoClienteServicePorArrobaConfiguration.ativar(joao);
		this.ativacaoClienteServicePorArrobaConfiguration.ativar(maria);

		this.ativacaoClienteServicePorArrobaComponentDesambiguacaoViaPrimary.ativar(joao);
		this.ativacaoClienteServicePorArrobaComponentDesambiguacaoViaPrimary.ativar(maria);

		this.ativacaoClienteServicePorArrobaComponentDesambiguacaoViaQualifier.ativar(joao);
		this.ativacaoClienteServicePorArrobaComponentDesambiguacaoViaQualifier.ativar(maria);

		this.ativacaoClienteServiceDesambiguacaoPorAnotacaoCustomizada.ativar(joao);
		this.ativacaoClienteServiceDesambiguacaoPorAnotacaoCustomizada.ativar(maria);		

		this.ativacaoClientePorEvent.ativar(joao);
		this.ativacaoClientePorEvent.ativar(maria);			
		
		return "Hello!";
	}
	
}
