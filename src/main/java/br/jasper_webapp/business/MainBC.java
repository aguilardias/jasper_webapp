package br.jasper_webapp.business;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.jasper_webapp.entity.Area;
import br.jasper_webapp.entity.Gasto;
import br.jasper_webapp.entity.Pessoa;
import br.jasper_webapp.entity.Profissao;

@BusinessController
public class MainBC {

	@Inject
	private AreaBC areaBC;
	
	@Inject
	private GastoBC gastoBC;
	
	@Inject
	private ProfissaoBC profissaoBC;
	
	@Inject
	private PessoaBC pessoaBC;

	
	@Startup
	@Transactional
	public void load() {
		
		Area exatas = areaBC.insert(new Area("Exatas"));			
		Area humanas = areaBC.insert(new Area("Humanas"));	
		
		Profissao computacao = profissaoBC.insert(new Profissao("computacao", exatas));
		Profissao engenharia = profissaoBC.insert(new Profissao("engenharia", exatas));
		Profissao arquitetura = profissaoBC.insert(new Profissao("arquitetura", exatas));
		Profissao administracao = profissaoBC.insert(new Profissao("administração", humanas));
		Profissao direito = profissaoBC.insert(new Profissao("direito", humanas));
		
		Pessoa jose = pessoaBC.insert(new Pessoa("josé", new Date(), computacao));
		Pessoa maria = pessoaBC.insert(new Pessoa("maria", new Date(), engenharia));
		Pessoa pedro = pessoaBC.insert(new Pessoa("pedro", new Date(), arquitetura));
		Pessoa carla = pessoaBC.insert(new Pessoa("carla", new Date(), administracao));
		Pessoa silvia = pessoaBC.insert(new Pessoa("silvia", new Date(), direito));
		
		Calendar data1 = Calendar.getInstance();
		data1.set(Calendar.MONTH, 10);
		data1.set(Calendar.DATE, 1);
		data1.set(Calendar.YEAR, 2015);
		
		gastoBC.insert(new Gasto(data1.getTime(), "mercado", new BigDecimal("100"), jose));
		gastoBC.insert(new Gasto(new Date(), "gasolina", new BigDecimal("130.5"), maria));
		gastoBC.insert(new Gasto(new Date(), "colégio", new BigDecimal("1000.6"), jose));
		gastoBC.insert(new Gasto(new Date(), "colégio", new BigDecimal("2000.7"), pedro));
		
		
				
	}

	
}
