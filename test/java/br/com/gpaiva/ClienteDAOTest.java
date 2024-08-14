
package br.com. gpaiva;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com. gpaiva.dao.ClienteDAO;
import br.com. gpaiva.dao.IClienteDAO;
import br.com. gpaiva.domain.Cliente;
import br.com. gpaiva.exceptions.DAOException;
import br.com. gpaiva.exceptions.MaisDeUmRegistroException;
import br.com. gpaiva.exceptions.TableException;
import br.com. gpaiva.exceptions.TipoChaveNaoEncontradaException;

 
public class ClienteDAOTest {
	
	private IClienteDAO clienteDao;

	public ClienteDAOTest() {
		clienteDao = new ClienteDAO();
	}
	
	@After
	public void end() throws DAOException {
		Collection<Cliente> list = clienteDao.buscarTodos();
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli.getCpf());
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	@Test
	public void pesquisarCliente() throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Gilberto");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
        cliente.setEmail("email.teste@email.com");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		clienteDao.cadastrar(cliente);

		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);

		clienteDao.excluir(cliente.getCpf());
	}

	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Gilberto");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
        cliente.setEmail("email.teste@email.com");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);

		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);

		clienteDao.excluir(cliente.getCpf());
	}


	@Test
	public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Gilberto");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
        cliente.setEmail("email.teste@email.com");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);

		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);

		clienteDao.excluir(cliente.getCpf());
		clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNull(clienteConsultado);
	}

	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Gilberto");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
        cliente.setEmail("email.teste@email.com");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);

		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);

		clienteConsultado.setNome("Gilberto Paiva");
		clienteDao.alterar(clienteConsultado);

		Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getCpf());
		Assert.assertNotNull(clienteAlterado);
		Assert.assertEquals("Gilberto Paiva", clienteAlterado.getNome());

		clienteDao.excluir(cliente.getCpf());
		clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNull(clienteConsultado);
	}

	@Test
	public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Gilberto");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
        cliente.setEmail("teste.email@email.com");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);

		Cliente cliente1 = new Cliente();
		cliente1.setCpf(56565656569L);
		cliente1.setNome("Gilberto");
		cliente1.setCidade("São Paulo");
		cliente1.setEnd("End");
		cliente1.setEstado("SP");
        cliente1.setEmail("teste.email@email.com");
		cliente1.setNumero(10);
		cliente1.setTel(1199999999L);
		Boolean retorno1 = clienteDao.cadastrar(cliente1);
		Assert.assertTrue(retorno1);
		
		Collection<Cliente> list = clienteDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli.getCpf());
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Collection<Cliente> list1 = clienteDao.buscarTodos();
		assertTrue(list1 != null);
		assertTrue(list1.size() == 0);
	}
}
