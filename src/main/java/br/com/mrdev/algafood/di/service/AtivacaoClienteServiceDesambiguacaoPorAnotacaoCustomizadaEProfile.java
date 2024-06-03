package br.com.mrdev.algafood.di.service;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.mrdev.algafood.di.modelo.Cliente;
import br.com.mrdev.algafood.di.notificacao.desambiguacao.via.anotacao.customizada.e.profile.NivelUrgencia;
import br.com.mrdev.algafood.di.notificacao.desambiguacao.via.anotacao.customizada.e.profile.NotificadorDesambiguacaoViaAnotacaoCustomizadaEProfile;
import br.com.mrdev.algafood.di.notificacao.desambiguacao.via.anotacao.customizada.e.profile.TipoDoNotificador;

@Component
public class AtivacaoClienteServiceDesambiguacaoPorAnotacaoCustomizadaEProfile {

	@TipoDoNotificador(NivelUrgencia.URGENTE)
	@Autowired
	private NotificadorDesambiguacaoViaAnotacaoCustomizadaEProfile notificador;
	
	//Método de callback do bean.
	//Observações:
	// 		Pode ser qualquer nome, mas é interessante padronizar;
	// 		Esse método é chamado logo depois de chamar o construtor;
	// 		Essa é uma das formas de fazer, mas existe outra forma que é via classe de configuração [@Configuration].
	// 			Na anotação [@Bean] ficará assim: [@Bean(initMethod = "init", destroyMethod="destroy")];
	// 				Uma outra forma é implementando as interfaces InitializingBean e DisposableBean (não recomendado);
	//@PostConstruct
	//public void init() {
	//	System.out.println("Init (AtivacaoClienteServiceDesambiguacaoPorAnotacaoCustomizadaEProfile)");
	//}
	
	//Método de callback do bean.
	//Observações:
	// 		Pode ser qualquer nome, mas é interessante padronizar;
	// 	 	Essa é uma das formas de fazer, mas existe outra forma que é via classe de configuração [@Configuration].
	// 			Na anotação [@Bean] ficará assim: [@Bean(initMethod = "init", destroyMethod="destroy")];
	// 				Uma outra forma é implementando as interfaces InitializingBean e DisposableBean (não recomendado);; 		
	// 		Esse método é chamado quando paramos a aplicação por que isso provocará que o container do spring seja parado também; 
	// 		Observe que será chamado um pouco antes de destruir até porque não faz sentido destruir e chamar 
	// 			porque daria Nullpointer;
	//@PreDestroy
	//public void destroy() {
	//	System.out.println("PreDestroy (AtivacaoClienteServiceDesambiguacaoPorAnotacaoCustomizadaEProfile)");
	//}
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		//notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}
	
}
