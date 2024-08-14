
package br.com. gpaiva.dao;

import br.com. gpaiva.dao.generic.IGenericDAO;
import br.com. gpaiva.domain.Venda;
import br.com. gpaiva.exceptions.DAOException;
import br.com. gpaiva.exceptions.TipoChaveNaoEncontradaException;

 
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
