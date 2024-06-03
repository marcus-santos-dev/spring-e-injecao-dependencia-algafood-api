package br.com.mrdev.algafood.di.notificacao.desambiguacao.via.anotacao.customizada.e.profile;

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

import org.springframework.stereotype.Component;
import br.com.mrdev.algafood.di.modelo.Cliente;
import br.com.mrdev.algafood.di.notificacao.propriedades.customizadas.NotificadorProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;

/**
 * Essa anotação @Profile irá buscar o atributo [spring.profiles.active]
 * no arquivo [application.properties].
 */
@Profile("PRD")
@TipoDoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorEmailDesambiguacaoViaAnotacaoCustomizadaEProfilePRD implements NotificadorDesambiguacaoViaAnotacaoCustomizadaEProfile {

	//A anotacao @Value vai buscar o atributo no [application.properties]
	@Value("${notificador.email.host-servidor}")
	private String hostViaArrobaValue;
	
	//A anotacao @Value vai buscar o atributo no [application.properties]
	@Value("${notificador.email.porta-servidor}")
	private Integer portaViaArrobaValue;	
	
	@Autowired
	private NotificadorProperties notificadorProperties;
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {

		System.out.println("Host (Via @Value): " + hostViaArrobaValue);
		System.out.println("Porta (Via @Value): " + portaViaArrobaValue);		
		
		System.out.println("Host (Via NotificadorProperties): " + notificadorProperties.getHostServidor());
		System.out.println("Porta (Via NotificadorProperties): " + notificadorProperties.getPortaServidor());		
		
		System.out.printf("Notificando [Via Anotação Customizada] [Profile PRD] [%s] através do e-mail [%s]: [%s]\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}

}
