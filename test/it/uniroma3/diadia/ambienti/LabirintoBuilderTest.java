package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoBuilderTest {

	private Stanza salotto;
	private Stanza camera;
	
	@BeforeEach
	public void setUp() {
		this.salotto = new Stanza("salotto");
		this.camera = new Stanza("camera");
	}
	
	@Test
	public void testLabirintoMonolocale() {
		Labirinto monolocale = new LabirintoBuilder()
					.addStanzaIniziale("stanzaIniziale")
					.addStanzaVincente("stanzaIniziale")
					.getLabirinto();
		assertEquals("stanzaIniziale", monolocale.getStanzaCorrente().getNome());
		assertEquals("stanzaIniziale", monolocale.getStanzaVincente().getNome());
	}
	
	
	@Test
	public void testLabirintoBilocale() {
		Labirinto bilocale = new LabirintoBuilder()
				 .addStanzaIniziale("salotto")
				 .addStanzaVincente("camera")
				 .addAttrezzo("letto", 10) // dove? fa riferimento allíultima stanza aggiunta
				 .addAdiacenza("salotto", "camera", "nord") // camera si trova a nord di salotto
				 .getLabirinto();
		
		assertEquals("salotto", bilocale.getStanzaCorrente().getNome());
		assertEquals("camera", bilocale.getStanzaVincente().getNome());
		
		bilocale.setStanzaCorrente(salotto);
		bilocale.setStanzaVincente(camera);
		bilocale.getStanzaCorrente().impostaStanzaAdiacente("nord", camera);
		assertEquals("camera", bilocale.getStanzaCorrente().getStanzaAdiacente("nord").getNome());
	}
	
	
	@Test
	public void testLabirintoTrilocale() {
		LabirintoBuilder trilocale = (LabirintoBuilder) new LabirintoBuilder()
				 .addStanzaIniziale("salotto")
				 .addStanza("cucina")
				 .addAttrezzo("pentola",1) // dove? fa riferimento allíultima stanza aggiunta
				 .addStanzaVincente("camera")
				 .addAdiacenza("salotto", "cucina", "nord")
				 .addAdiacenza("cucina", "camera", "est")
				 .getLabirinto(); // restituisce il Labirinto cosÏ creato

		assertEquals("salotto", trilocale.getStanzaCorrente().getNome());
		assertEquals("camera", trilocale.getStanzaVincente().getNome());
		
		Stanza cucina = new Stanza("cucina");
		trilocale.setStanzaCorrente(salotto);
		trilocale.setStanzaVincente(camera);
		salotto.impostaStanzaAdiacente("nord", cucina);
		cucina.impostaStanzaAdiacente("est", camera);
		
		assertEquals("cucina", trilocale.getStanzaCorrente().getStanzaAdiacente("nord").getNome());
		assertEquals("camera", trilocale.getStanzaCorrente().getStanzaAdiacente("nord")
						.getStanzaAdiacente("est").getNome());
	}
}
