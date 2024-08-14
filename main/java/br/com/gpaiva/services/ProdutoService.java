
package br.com. gpaiva.services;

import br.com. gpaiva.dao.IProdutoDAO;
import br.com. gpaiva.domain.Produto;
import br.com. gpaiva.services.generic.GenericService;

 
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
