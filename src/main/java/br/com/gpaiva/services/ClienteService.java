
package br.com. gpaiva.services;

import br.com. gpaiva.dao.IClienteDAO;
import br.com. gpaiva.domain.Cliente;
import br.com. gpaiva.exceptions.DAOException;
import br.com. gpaiva.exceptions.MaisDeUmRegistroException;
import br.com. gpaiva.exceptions.TableException;
import br.com. gpaiva.exceptions.TipoChaveNaoEncontradaException;
import br.com. gpaiva.services.generic.GenericService;

 
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	//private IClienteDAO clienteDAO;
	
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
		//this.clienteDAO = clienteDAO;
	}

//	@Override
//	public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
//		return clienteDAO.cadastrar(cliente);
//	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public void excluir(Long cpf) {
//		clienteDAO.excluir(cpf);
//	}
//
//	@Override
//	public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException{
//		clienteDAO.alterar(cliente);
//	}

}
