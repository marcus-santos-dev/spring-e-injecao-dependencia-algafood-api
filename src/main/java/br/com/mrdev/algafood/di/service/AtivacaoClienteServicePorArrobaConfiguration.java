package br.com.mrdev.algafood.di.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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

import br.com.mrdev.algafood.di.modelo.Cliente;
import br.com.mrdev.algafood.di.notificacao.desambiguacao.via.list.NotificadorDesambiguacaoViaList;

/**
 * @Component é uma das maneiras que podemos definir que essa classe é um Bean Spring. 
 */
//O @Component foi removido daqui para evidenciarmos a outra maneira de configurar o bean.
//Uma outra maneira de fazer isso é via arquivo de configuração. Veja a classe [ServiceConfig].
//@Component
public class AtivacaoClienteServicePorArrobaConfiguration {

	//Isso aqui provoca um acoplamento forte e por causa disso será trocado por 
	//uma interface. Nesse caso tanto NotificadorEmail quanto o NotificadoSMS terão
	//que implementar uma interface q será criada com o nome Notificador.
	//Anteriormente era [private NotificadorEmail notificador;]
	private List<NotificadorDesambiguacaoViaList> notificador = new ArrayList<>();

	/**
	 * Como AtivacaoClienteService é um component Spring (@Component)
	 * e as classes que implementam a interface Notificador tambem são component Spring (@Component)
	 * o simples fato de criar o construtor recebendo alguem que implementa Notificador vai fazer
	 * com que o 'this.notificador' NÃO seja NULO. 1/X
	 */
	@Autowired(required = false)
	public AtivacaoClienteServicePorArrobaConfiguration(NotificadorDesambiguacaoViaList notificador) {
		//this.notificador = notificador;
		this.notificador.add(notificador);
		System.out.println("Contrutor chamado (AtivacaoClienteServicePorArrobaConfiguration).");
	}

	/**
	 * Este construtor foi criado apenas para exemplificarmos a necessidade de especificar
	 * para o spring qual o construtor que ele deve usar. Quando existir mais de um construtor
	 * devemos marcar o construtor q queremos q o spring utilize com o @Autowired, ou seja,
	 * se o construtor [AtivacaoClienteServicePorArrobaConfiguration(Notificador)] não estiver 
	 * marcado com o @Autowired isso irá gerar um erro. 
	 */
	public AtivacaoClienteServicePorArrobaConfiguration(String qualquer) {
		
	}	
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		//Essa possibilidade de não ter notificador é por causa do [(required = false)]
		if( this.notificador != null && this.notificador.size() > 0 ) {
			for(NotificadorDesambiguacaoViaList notificador : this.notificador) {
				notificador.notificar(cliente, "Seu cadastro no sistema está ativo! " + notificador.getClass());
			}
		}else {
			System.out.println( "Não existe notificador, mas seu cliente foi ativado." );
		}
	}


	
}
