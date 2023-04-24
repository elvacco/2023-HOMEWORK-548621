package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;

class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiFisarmonica factory;
	private Comando comando;
	static final private String[] elencoComandi = {"vai", "aiuto", "prendi", "posa", "fine"};

	@BeforeEach
	public void setUp() {
		this.factory = new FabbricaDiComandiFisarmonica();
	}

	@Test
	public void testCostruisciComandoVai() {
		this.comando = new ComandoVai();

		assertEquals(this.factory.costruisciComando("vai nord", new IOConsole()).getNome(), this.comando.getNome());
	}

	@Test
	public void testCostruisciComandoAiuto() {
		this.comando = new ComandoAiuto(elencoComandi);

		assertEquals(this.factory.costruisciComando("aiuto", new IOConsole()).getNome(), this.comando.getNome());
	}

	@Test
	public void testCostruisciComandoGuarda() {
		this.comando = new ComandoGuarda();

		assertEquals(this.factory.costruisciComando("guarda", new IOConsole()).getNome(), this.comando.getNome());
	}

	@Test
	public void testCostruisciComandoPrendi() {
		this.comando = new ComandoPrendi();

		assertEquals(this.factory.costruisciComando("prendi", new IOConsole()).getNome(), this.comando.getNome());
	}

	@Test
	public void testCostruisciComandoPosa() {
		this.comando = new ComandoPosa();

		assertEquals(this.factory.costruisciComando("posa", new IOConsole()).getNome(), this.comando.getNome());
	}

	@Test
	public void testCostruisciComandoFine() {
		this.comando = new ComandoFine();

		assertEquals(this.factory.costruisciComando("fine", new IOConsole()).getNome(), this.comando.getNome());
	}

	@Test
	public void testCostruisciComandoNonValido() {
		this.comando = new ComandoNonValido();

		assertEquals(this.factory.costruisciComando("qualcosa", new IOConsole()).getNome(), this.comando.getNome());
	}

}
