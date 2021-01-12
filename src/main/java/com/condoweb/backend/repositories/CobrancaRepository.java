package com.condoweb.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.condoweb.backend.entities.Cobranca;

public interface CobrancaRepository extends JpaRepository<Cobranca, Long>{
	
	  @Query(value = "select c.* from Cobranca c, Imovel i where c.imovel_id=?1 and i.id=c.imovel_id and data_pagamento is not null", nativeQuery = true)
	  List<Cobranca> buscarCobrancaPagaImovel(Long idImovel);
	  
	  @Query(value = "select c.* from Cobranca c, Imovel i where c.imovel_id=?1 and i.id=c.imovel_id and data_pagamento is null", nativeQuery = true)
	  List<Cobranca> buscarCobrancaNaoPagaImovel(Long idImovel);
	  
	  @Query(value = "select c.* from Cobranca c where data_pagamento is not null", nativeQuery = true)
	  List<Cobranca> buscarCobrancaPaga();
	  
	  @Query(value = "select c.* from Cobranca c where data_pagamento is null", nativeQuery = true)
	  List<Cobranca> buscarCobrancaNaoPaga();
}
