
package br.com. gpaiva.services;

import br.com. gpaiva.domain.Cliente;
import br.com. gpaiva.exceptions.DAOException;
import br.com. gpaiva.exceptions.TipoChaveNaoEncontradaException;
import br.com. gpaiva.services.generic.IGenericService;

 
public interface IClienteService extends IGenericService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
