package com.condoweb.backend.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.condoweb.backend.entities.Bloco;
import com.condoweb.backend.entities.Cobranca;
import com.condoweb.backend.entities.Condominio;
import com.condoweb.backend.entities.Endereco;
import com.condoweb.backend.entities.Imovel;
import com.condoweb.backend.entities.ImovelInformativo;
import com.condoweb.backend.entities.Informativo;
import com.condoweb.backend.entities.Perfil;
import com.condoweb.backend.entities.Permissao;
import com.condoweb.backend.entities.Pessoa;
import com.condoweb.backend.entities.Usuario;
import com.condoweb.backend.repositories.BlocoRepository;
import com.condoweb.backend.repositories.CobrancaRepository;
import com.condoweb.backend.repositories.CondominioRepository;
import com.condoweb.backend.repositories.EnderecoRepository;
import com.condoweb.backend.repositories.ImovelInformativoRepository;
import com.condoweb.backend.repositories.ImovelRepository;
import com.condoweb.backend.repositories.InformativoRepository;
import com.condoweb.backend.repositories.PerfilRepository;
import com.condoweb.backend.repositories.PermissaoRepository;
import com.condoweb.backend.repositories.PessoaRepository;
import com.condoweb.backend.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PermissaoRepository permissaoRepository;
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private ImovelRepository imovelRepository;	
	
	@Autowired
	private BlocoRepository blocoRepository;
	
	@Autowired
	private CobrancaRepository cobrancaRepository;
	
	@Autowired
	private CondominioRepository condominioRepository;
	
	@Autowired
	private ImovelInformativoRepository imovelInformativoRepository;
	
	@Autowired
	private InformativoRepository informativoRepository;

	@Override
	public void run(String... args) throws Exception {
						
		Endereco ender1 = new Endereco(null, "Rua", "Antônio Francisco Rosa", 180, "Apto 101", "Aclimação","Uberlândia", "MG", "38400076", "");
		Endereco ender2 = new Endereco(null, "Rua", "Antônio Francisco Rosa", 180, "Apto 102", "Aclimação","Uberlândia", "MG", "38400076", "");
		Endereco ender3 = new Endereco(null, "Rua", "Antônio Francisco Rosa", 180, "Apto 103", "Aclimação","Uberlândia", "MG", "38400076", "");
		Endereco ender4 = new Endereco(null, "Rua", "Antônio Francisco Rosa", 180, "Apto 104", "Aclimação","Uberlândia", "MG", "38400076", "");
		Endereco ender5 = new Endereco(null, "Rua", "Antônio Francisco Rosa", 180, "Apto 105", "Aclimação","Uberlândia", "MG", "38400076", "");
		Endereco ender6 = new Endereco(null, "Rua", "Antônio Francisco Rosa", 180, "Apto 106", "Aclimação","Uberlândia", "MG", "38400076", "");
		Endereco ender7 = new Endereco(null, "Rua", "Antônio Francisco Rosa", 180, "Apto 107", "Aclimação","Uberlândia", "MG", "38400076", "");

		enderecoRepository.saveAll(Arrays.asList(ender1, ender2, ender3, ender4, ender5, ender6, ender7));
		
		Pessoa p1 = new Pessoa(null, "Jade Marina", "03654125877", "985214", new SimpleDateFormat("yyyy-MM-dd").parse("1999-03-02"), "jade@gmail.com", "3534345345", "96521457", ender1);
		Pessoa p2 = new Pessoa(null, "Cristiane Alves", "12545874588", "9854125", new SimpleDateFormat("yyyy-MM-dd").parse("1999-10-20"), "cristiane@gmail.com", "3435343463", "98745236", ender2);
		Pessoa p3 = new Pessoa(null, "Nazaré Silveira", "05874596522", "652874", new SimpleDateFormat("yyyy-MM-dd").parse("1988-01-08"), "nazare@gmail.com", "3213221321", "94253658", ender3);
		Pessoa p4 = new Pessoa(null, "Murilo Alves Dias", "36525414799", "852147", new SimpleDateFormat("yyyy-MM-dd").parse("1998-07-09"), "murilo@gmail.com", "3534534646", "98521478", ender4);
		Pessoa p5 = new Pessoa(null, "José Antonio", "45632114755", "8541256", new SimpleDateFormat("yyyy-MM-dd").parse("1998-07-05"), "jose@gmail.com", "3214567321", "93251458", ender5);
		Pessoa p6 = new Pessoa(null, "Marcos Frauches Leocádio", "12332424", "432423123", new SimpleDateFormat("yyyy-MM-dd").parse("2011-12-19"), "marcos@frauches.com", "34999999999", "34888888888", ender6);
		Pessoa p7 = new Pessoa(null, "Juliano Leocádio Batista", "4265484697", "12095709", new SimpleDateFormat("yyyy-MM-dd").parse("1981-03-31"), "julianoleo@gmail.com", "34032924700", "34992622680", ender1);
		Pessoa p8 = new Pessoa(null, "Lucas Itelvino da Silva", "5654645645", "465445654", new SimpleDateFormat("yyyy-MM-dd").parse("2000-05-30"), "lucas@gmail.com", "3498797897", "3432432423", ender1);
		
		pessoaRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8));
		
		Usuario u1 = new Usuario(null, "Jade", "1234", p1);
		Usuario u2 = new Usuario(null, "Cristiane", "1234", p2);
		Usuario u3 = new Usuario(null, "Nazare", "1234", p3);
		Usuario u4 = new Usuario(null, "Murilo", "1234", p4);
		Usuario u5 = new Usuario(null, "Jantonio", "1234", p5);
		Usuario u6 = new Usuario(null, "Marcos", "1234", p6);
		Usuario u7 = new Usuario(null, "Juliano", "1234", p7);
		Usuario u8 = new Usuario(null, "Lucas", "1234", p8);
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7, u8));
		
		Perfil perf1 = new Perfil(null, "Condomino", new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-20"));
		Perfil perf2 = new Perfil(null, "Sindico", new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-20"));
		Perfil perf3 = new Perfil(null, "Administrador", new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-20"));
		
		perfilRepository.saveAll(Arrays.asList(perf1, perf2, perf3));
		
		Permissao perm1 = new Permissao(null, false, new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-20"), u1, perf1);
		Permissao perm2 = new Permissao(null, false, new SimpleDateFormat("yyyy-MM-dd").parse("2018-07-10"), u2, perf1);
		Permissao perm3 = new Permissao(null, false, new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-25"), u3, perf2);
		Permissao perm4 = new Permissao(null, true, new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-06"), u4, perf1);
		Permissao perm5 = new Permissao(null, true, new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-02"), u5, perf1);
		Permissao perm6 = new Permissao(null, true, new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-13"), u6, perf3);
		Permissao perm7 = new Permissao(null, true, new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20"), u7, perf1);
		Permissao perm8 = new Permissao(null, true, new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20"), u7, perf2);
		
		permissaoRepository.saveAll(Arrays.asList(perm1, perm2, perm3, perm4, perm5, perm6, perm7, perm8));
		
		Bloco b1 = new Bloco(null, "A1", "Bloco A1");
		Bloco b2 = new Bloco(null, "A2", "Bloco A2");
		Bloco b3 = new Bloco(null, "A3", "Bloco A3");
		Bloco b4 = new Bloco(null, "B1", "Bloco B1");
		Bloco b5 = new Bloco(null, "B2", "Bloco B2");
		Bloco b6 = new Bloco(null, "B3", "Bloco B3");
		
		blocoRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5, b6));
		
		Condominio condo = new Condominio(null, "Edificio Santa Rosa", 64, 4);
		
		condominioRepository.save(condo);
		
		Imovel imovel1 = new Imovel(null, 101, "FINANCIADO", b1, condo, u1, p1);
		Imovel imovel2 = new Imovel(null, 102, "ALUGADO", b1, condo, u2, p2);
		Imovel imovel3 = new Imovel(null, 103, "FINANCIADO", b1, condo, u3, p3);
		Imovel imovel4 = new Imovel(null, 104, "ALUGADO", b1, condo, u4, p4);
		Imovel imovel5 = new Imovel(null, 105, "FINANCIADO", b2, condo, u5, p5);
		Imovel imovel6 = new Imovel(null, 106, "FINANCIADO", b2, condo, u6, p6);
		Imovel imovel7 = new Imovel(null, 107, "FINANCIADO", b2, condo, u7, p7);
		Imovel imovel8 = new Imovel(null, 108, "FINANCIADO", b2, condo, u8, p7);
		
		imovelRepository.saveAll(Arrays.asList(imovel1, imovel2, imovel3, imovel4, imovel5, imovel6, imovel7, imovel8));
		
		Cobranca cobr1 = new Cobranca(null, "Condominio", "Cobranca referente ao condominio", 200.00, 200.00, new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-20"), new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-24"), new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-21"), imovel1);
		Cobranca cobr2 = new Cobranca(null, "Condominio", "Cobranca referente ao condominio", 200.00, 200.00, new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-20"), new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-24"), new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-21"), imovel2);
		Cobranca cobr3 = new Cobranca(null, "Condominio", "Cobranca referente ao condominio", 200.00, 200.00, null, new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-24"), new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-24"), imovel3);
		Cobranca cobr4 = new Cobranca(null, "Condominio", "Cobranca referente ao condominio", 200.00, 200.00, null, new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-24"), new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-24"), imovel4);
		Cobranca cobr5 = new Cobranca(null, "Condominio", "Cobranca referente ao condominio", 200.00, 200.00, new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-20"), new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-24"), new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-21"), imovel5);
		Cobranca cobr6 = new Cobranca(null, "Condominio", "Cobranca referente ao condominio", 200.00, 200.00, null, new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-24"), new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-24"), imovel6);
		Cobranca cobr7 = new Cobranca(null, "Condominio", "Cobranca referente ao condominio", 200.00, 200.00, new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-20"), new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-24"), new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-21"), imovel7);
		Cobranca cobr8 = new Cobranca(null, "Condominio", "Cobranca referente ao condominio", 200.00, 200.00, new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-20"), new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-24"), new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-21"), imovel8);
		Cobranca cobr9 = new Cobranca(null, "Salao de festa", "Cobranca referente ao uso do salao de festa", 50.00, 50.00, new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-20"), new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-24"), new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-21"), imovel1);
		Cobranca cobr10 = new Cobranca(null, "Barulho da Obra", "Cobranca referente ao barulho, causado durante a obra", 100.00, 100.00, new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-20"), new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-24"), new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-21"), imovel1);
		
		cobrancaRepository.saveAll(Arrays.asList(cobr1, cobr2, cobr3, cobr4, cobr5, cobr6, cobr7, cobr8, cobr9, cobr10));
		
		Informativo info1 = new Informativo(null, "Eleição do sindico", "Lorem ipsum volutpat ultricies nisi fames torquent in ac, sed nostra feugiat vitae interdum", new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-14"));
		Informativo info2 = new Informativo(null, "Creche", "Lorem ipsum volutpat ultricies nisi fames torquent in ac, sed nostra feugiat vitae interdum", new SimpleDateFormat("yyyy-MM-dd").parse("2020-06-19"));
		Informativo info3 = new Informativo(null, "Salão de festas", "Lorem ipsum volutpat ultricies nisi fames torquent in ac, sed nostra feugiat vitae interdum", new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-27"));
		Informativo info4 = new Informativo(null, "Segurança", "Lorem ipsum volutpat ultricies nisi fames torquent in ac, sed nostra feugiat vitae interdum", new SimpleDateFormat("yyyy-MM-dd").parse("2020-05-18"));
		
		informativoRepository.saveAll(Arrays.asList(info1, info2, info3, info4));
		
		ImovelInformativo imoInfo1 = new ImovelInformativo(imovel1, info1);
		ImovelInformativo imoInfo2 = new ImovelInformativo(imovel2, info2);
		ImovelInformativo imoInfo3 = new ImovelInformativo(imovel3, info3);
		ImovelInformativo imoInfo4 = new ImovelInformativo(imovel4, info4);
		ImovelInformativo imoInfo5 = new ImovelInformativo(imovel1, info1);
		ImovelInformativo imoInfo6 = new ImovelInformativo(imovel2, info3);
		ImovelInformativo imoInfo7 = new ImovelInformativo(imovel3, info2);
		ImovelInformativo imoInfo8 = new ImovelInformativo(imovel4, info4);
		ImovelInformativo imoInfo9 = new ImovelInformativo(imovel4, info1);
		
		imovelInformativoRepository.saveAll(Arrays.asList(imoInfo1, imoInfo2, imoInfo3, imoInfo4, imoInfo5, imoInfo6, imoInfo7, imoInfo8, imoInfo9));
	}
}
